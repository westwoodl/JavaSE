package com.elasticsearch;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

/**
 * @author xu rongchao
 * @date 2021/3/15 13:25
 */
public class ElasticsearchClientFactory {
    public final static RestHighLevelClient LOCAL_ES_CLIENT = new RestHighLevelClient(
            RestClient.builder(
                    new HttpHost("localhost", 9200, "http")));

}
