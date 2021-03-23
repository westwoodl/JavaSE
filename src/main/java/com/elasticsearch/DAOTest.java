package com.elasticsearch;

import com.elasticsearch.dao.DocumentDAO;
import com.elasticsearch.domian.DocumentDO;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xu rongchao
 * @date 2021/3/15 17:46
 */
public class DAOTest {
    DocumentDAO documentDAO = new DocumentDAO();

    @Test
    public void create() {
        DocumentDO documentDO = new DocumentDO();
        documentDO.setId(2L);
        documentDO.setContent("who will love you? i think none");
        System.out.println(documentDAO.create(documentDO));
    }

    @Test
    public void bulkCreate() {
        List<DocumentDO> list = new ArrayList<>();
        list.add(new DocumentDO(3L, "Most options controlling the search behavior can be set on the SearchSourceBuilder, which contains more or less the equivalent of the options in the search request body of the Rest API."));
        list.add(new DocumentDO(4L, "Aggregations can be added to the search by first creating the appropriate AggregationBuilder and then setting it on the SearchSourceBuilder. In the following example we create a terms aggregation on company names with a sub-aggregation on the average age of employees in the company:"));
        list.add(new DocumentDO(5L, "Synchronous calls may throw an IOException in case of either failing to parse the REST response in the high-level REST client, the request times out or similar cases where there is no response coming back from the server.In cases where the server returns a 4xx or 5xx error code, the high-level client tries to parse the response body error details instead and then throws a generic ElasticsearchException and adds the original ResponseException as a suppressed exception to it."));
        list.add(new DocumentDO(6L, "The asynchronous method does not block and returns immediately."));
        list.add(new DocumentDO(7L, "Once it is completed the ActionListener is called back using the onResponse method if the execution successfully completed or using the onFailure method if it failed. "));
        list.add(new DocumentDO(8L, "Failure scenarios and expected exceptions are the same as in the synchronous execution case."));
        list.add(new DocumentDO(9L, "The SearchResponse that is returned by executing the search provides details about the search execution itself as well as access to the documents returned. First, there is useful information about the request execution itself, like the HTTP status code, execution time or whether the request terminated early or timed out:"));
        list.add(new DocumentDO(10L, "Second, the response also provides information about the execution on the shard level by offering statistics about the total number of shards that were affected by the search, and the successful vs. unsuccessful shards. Possible failures can also be handled by iterating over an array off ShardSearchFailures like in the following example:"));
        list.add(new DocumentDO(11L, "int totalShards = searchResponse.getTotalShards();\n" +
                "int successfulShards = searchResponse.getSuccessfulShards();\n" +
                "int failedShards = searchResponse.getFailedShards();\n" +
                "for (ShardSearchFailure failure : searchResponse.getShardFailures()) {\n" +
                "    // failures should be handled here\n" +
                "}"));
        list.add(new DocumentDO(12L, "String index = hit.getIndex();\n" +
                "String id = hit.getId();\n" +
                "float score = hit.getScore();"));
        list.add(new DocumentDO(13L, "1 2"));
        list.add(new DocumentDO(14L, "3 "));
        list.add(new DocumentDO(15L, "4 "));
        list.add(new DocumentDO(16L, "5 "));
        list.add(new DocumentDO(17L, "6"));
        list.add(new DocumentDO(18L, "7"));
        list.add(new DocumentDO(19L, "9"));
        list.add(new DocumentDO(20L, "8"));
        list.add(new DocumentDO(21L, "0"));
        list.add(new DocumentDO(22L, "-"));
        list.add(new DocumentDO(23L, "12"));
        list.add(new DocumentDO(24L, "~"));

        documentDAO.bulkCreate(list);
    }

    @Test
    public void update() {
        DocumentDO documentDO = new DocumentDO();
        documentDO.setId(1L);
        documentDO.setContent("i would not love you forever");
        System.out.println(documentDAO.update(documentDO));
    }

    @Test
    public void getById() {
        System.out.println(documentDAO.getById(1L));
    }

    @Test
    public void search() {
        System.out.println(documentDAO.search("as"));
        System.out.println(documentDAO.search("love"));
        System.out.println(documentDAO.highlighterSearch("love"));
        System.out.println(documentDAO.search(null));
    }
}
