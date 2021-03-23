package com.elasticsearch.dao.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.elasticsearch.client.RestHighLevelClient;

/**
 * @author xu rongchao
 * @date 2021/3/15 18:50
 */
@Data
@AllArgsConstructor
public class ElasticsearchBaseConfig {

    private String index;

    private RestHighLevelClient restHighLevelClient;
}
