package com.elasticsearch.dao.base;

import com.alibaba.fastjson.JSONObject;
import com.elasticsearch.domian.BaseDomain;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.text.Text;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.sort.SortOrder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

/**
 * @author xu rongchao
 * @date 2021/3/15 13:26
 */
public abstract class AbstractElasticsearchDAO<T extends BaseDomain> implements Supplier<ElasticsearchBaseConfig> {


    private String getIndex() {
        return get().getIndex();
    }

    private RestHighLevelClient getClient() {
        return get().getRestHighLevelClient();
    }


//    public List<T> search(String str) {
//        GetRequest getRequest = new GetRequest();
//        getRequest.index(index);
//        getRequest.
//        getClient()
//    }

    public Map<String, Object> getById(Long id) {
        GetRequest getRequest = new GetRequest();
        getRequest.id(id.toString());
        getRequest.index(getIndex());
        try {
            GetResponse getResponse = getClient().get(getRequest, RequestOptions.DEFAULT);
            return getResponse.getSource();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int create(T documentDO) {
        IndexRequest request = new IndexRequest();
        request.id(documentDO.getId().toString());
        request.index(getIndex());
        request.source(JSONObject.toJSONString(documentDO), XContentType.JSON);
        try {
            IndexResponse response = getClient().index(request, RequestOptions.DEFAULT);
            return response.status().getStatus();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }


    public int update(T documentDO) {
        UpdateRequest request = new UpdateRequest();
        request.id(documentDO.getId().toString());
        request.index(getIndex());
        request.doc(JSONObject.toJSONString(documentDO), XContentType.JSON);
        try {
            UpdateResponse updateResponse = getClient().update(request, RequestOptions.DEFAULT);
            return updateResponse.status().getStatus();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int delete(T documentDO) {
        DeleteRequest request = new DeleteRequest();
        request.id(documentDO.getId().toString());
        request.index(getIndex());
        try {
            DeleteResponse deleteResponse = getClient().delete(request, RequestOptions.DEFAULT);
            return deleteResponse.status().getStatus();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void bulkCreate(List<T> list) {
        BulkRequest bulkRequest = new BulkRequest();
        bulkRequest.timeout("10s");

        for (T documentDO : list) {
            IndexRequest indexRequest = new IndexRequest();
            indexRequest.index(getIndex());
            indexRequest.id(documentDO.getId().toString());
            indexRequest.source(JSONObject.toJSONString(documentDO), XContentType.JSON);
            bulkRequest.add(indexRequest);
        }

        BulkResponse bulkResponse = null;
        try {
            bulkResponse = getClient().bulk(bulkRequest, RequestOptions.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(bulkResponse);
    }

    public List<Map<String, Object>> search(String name) {
        SearchRequest searchRequest = new SearchRequest();
        searchRequest.indices(getIndex());
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();

        // TermQueryBuilder queryBuilder = new TermQueryBuilder("id", "1");
        if (name != null) {
            MatchQueryBuilder queryBuilder = new MatchQueryBuilder("content", name);
            searchSourceBuilder.query(queryBuilder);
        }

        searchSourceBuilder.timeout(new TimeValue(10, TimeUnit.SECONDS));
        searchSourceBuilder.from(0);
        searchSourceBuilder.size(10);
        searchSourceBuilder.sort("id", SortOrder.DESC);
        searchRequest.source(searchSourceBuilder);

        SearchResponse searchResponse = null;
        try {
            searchResponse = getClient().search(searchRequest, RequestOptions.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Map<String, Object>> resList = new ArrayList<>();
        System.out.println(searchResponse);
        for (SearchHit hit : searchResponse.getHits()) {
            resList.add(hit.getSourceAsMap());
        }
        return resList;
    }

    public List<Map<String, Object>> highlighterSearch(String name) {
        SearchRequest searchRequest = new SearchRequest();
        searchRequest.indices(getIndex());
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();

//         TermQueryBuilder queryBuilder = new TermQueryBuilder("id", "1");


        HighlightBuilder highlightBuilder = new HighlightBuilder().field("content")
                .preTags("【").postTags("】");
        searchSourceBuilder.highlighter(highlightBuilder);

        if (name != null) {
            MatchQueryBuilder queryBuilder = new MatchQueryBuilder("content", name);
            searchSourceBuilder.query(queryBuilder);
        }
        searchSourceBuilder.timeout(new TimeValue(10, TimeUnit.SECONDS));
        searchSourceBuilder.from(0);
        searchSourceBuilder.size(10);
        searchSourceBuilder.sort("id", SortOrder.DESC);
        searchRequest.source(searchSourceBuilder);

        SearchResponse searchResponse = null;
        try {
            searchResponse = getClient().search(searchRequest, RequestOptions.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<Map<String, Object>> resList = new ArrayList<>();
        for (SearchHit hit : searchResponse.getHits()) {
            StringBuilder content = new StringBuilder();
            for (Text text : hit.getHighlightFields().get("content").getFragments()) {
                content.append(text);
            }
            hit.getSourceAsMap().put("content", content.toString());
            resList.add(hit.getSourceAsMap());
        }
        return resList;
    }

}
