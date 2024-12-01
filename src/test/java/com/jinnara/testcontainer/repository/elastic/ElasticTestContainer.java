package com.jinnara.testcontainer.repository.elastic;
import org.testcontainers.elasticsearch.ElasticsearchContainer;


public class ElasticTestContainer {
  public static final ElasticsearchContainer ELASTIC_CONTAINER;

  static {
    ELASTIC_CONTAINER = new ElasticsearchContainer("docker.elastic.co/elasticsearch/elasticsearch:7.12.0");
    ELASTIC_CONTAINER.start();
  }
}
