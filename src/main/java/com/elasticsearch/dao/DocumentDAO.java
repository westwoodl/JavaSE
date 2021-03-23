package com.elasticsearch.dao;

import com.elasticsearch.ElasticsearchClientFactory;
import com.elasticsearch.dao.base.AbstractElasticsearchDAO;
import com.elasticsearch.dao.base.ElasticsearchBaseConfig;
import com.elasticsearch.domian.DocumentDO;


/**
 * @author xu rongchao
 * @date 2021/3/15 13:26
 */
public class DocumentDAO extends AbstractElasticsearchDAO<DocumentDO> {
    public static final ElasticsearchBaseConfig ELASTICSEARCH_BASE_CONFIG = new ElasticsearchBaseConfig("xu_document", ElasticsearchClientFactory.LOCAL_ES_CLIENT);
    @Override
    public ElasticsearchBaseConfig get() {
        return ELASTICSEARCH_BASE_CONFIG;
    }

}
