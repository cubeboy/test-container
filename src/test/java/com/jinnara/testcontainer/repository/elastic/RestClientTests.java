package com.jinnara.testcontainer.repository.elastic;
import org.elasticsearch.client.Request;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Import(TestElasticConfig.class)
@ExtendWith(SpringExtension.class)
public class RestClientTests  {

  @Autowired
  RestClient restClient;

  @Test
  public void test() throws Exception {
    Response response = restClient.performRequest(new Request("GET", "/_cluster/health"));
    assertEquals(200, response.getStatusLine().getStatusCode());
  }
}
