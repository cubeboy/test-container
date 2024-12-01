package com.jinnara.testcontainer.repository.elastic;

import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class TestElasticConfig {
  @Bean
  public RestClient restClient() {
    BasicCredentialsProvider credentialsProvider = new BasicCredentialsProvider();
    credentialsProvider.setCredentials(
      AuthScope.ANY,
      new UsernamePasswordCredentials("elasticsearch", "elasticsearch"));

    RestClientBuilder builder = RestClient.builder(HttpHost.create(ElasticTestContainer.ELASTIC_CONTAINER.getHttpHostAddress()));
    return RestClient
      .builder(HttpHost.create(ElasticTestContainer.ELASTIC_CONTAINER.getHttpHostAddress()))
      .setHttpClientConfigCallback(httpClientBuilder ->
        httpClientBuilder.setDefaultCredentialsProvider(credentialsProvider))
      .build();
  }
}
