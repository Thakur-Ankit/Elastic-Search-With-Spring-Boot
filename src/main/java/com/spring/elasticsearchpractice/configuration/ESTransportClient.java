package com.spring.elasticsearchpractice.configuration;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * The type Es transport client.
 */
@Configuration
public class ESTransportClient {

    /**
     * The Logger.
     */
    Logger logger = LoggerFactory.getLogger(ESTransportClient.class);

    /**
     * Gets client.
     *
     * @return the client
     */
    @Bean(name = "restHighLevelClient", destroyMethod = "close")
    public RestHighLevelClient getClient() {
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost("localhost", 9200, "http")
                ));
        logger.info("Bean Create for the RestHighLevelClient");

        return client;
    }
}