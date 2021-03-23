package com.elasticsearch;

import org.apache.http.HttpHost;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentType;
import org.junit.Test;

import java.io.IOException;

/**
 * @author xu rongchao
 * @date 2021/3/10 22:26
 */
public class ElasticsearchTest {


    static RestHighLevelClient client = new RestHighLevelClient(
            RestClient.builder(
                    new HttpHost("localhost", 9200, "http")));

    @Test
    public void exist() throws IOException {
        GetRequest request = new GetRequest();
        request.id("1");
        request.index("posts");
        System.out.println(client.exists(request, RequestOptions.DEFAULT));
    }

    public static void main(String[] args) throws IOException {

        // 1.index
        IndexRequest request = new IndexRequest("posts");
        // 2. id (没有type)
        request.id("1");
        request.timeout(TimeValue.timeValueMillis(1));
        String jsonString = "{" +
                "\"user\":\"kimchy\"," +
                "\"postDate\":\"2013-01-30\"," +
                "\"message\":\"trying out Elasticsearch\"" +
                "}";
        request.source(jsonString, XContentType.JSON);
        IndexResponse indexResponse = client.index(request, RequestOptions.DEFAULT);
        System.out.println(indexResponse.status());
        System.out.println(indexResponse.toString());
    }
}
