package com.jinnara.testcontainer.repository.elastic;

import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.testcontainers.elasticsearch.ElasticsearchContainer;


abstract class ElasticTestContainer {
  public static final ElasticsearchContainer ELASTIC_CONTAINER;
  private RestClient restClient = null;

  static {
    ELASTIC_CONTAINER = new ElasticsearchContainer("docker.elastic.co/elasticsearch/elasticsearch:7.12.0");
    ELASTIC_CONTAINER.start();
  }

  RestClient getRestClient() {
    if (restClient != null) {
      return restClient;
    }

    BasicCredentialsProvider credentialsProvider = new BasicCredentialsProvider();
    credentialsProvider.setCredentials(
      AuthScope.ANY,
      new UsernamePasswordCredentials("elasticsearch", "elasticsearch"));

    RestClientBuilder builder = RestClient.builder(HttpHost.create(ElasticTestContainer.ELASTIC_CONTAINER.getHttpHostAddress()));
    restClient = RestClient
      .builder(HttpHost.create(ElasticTestContainer.ELASTIC_CONTAINER.getHttpHostAddress()))
      .setHttpClientConfigCallback(httpClientBuilder ->
        httpClientBuilder.setDefaultCredentialsProvider(credentialsProvider))
      .build();
    return restClient;
  }
}
