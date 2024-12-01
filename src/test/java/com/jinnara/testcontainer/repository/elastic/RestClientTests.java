package com.jinnara.testcontainer.repository.elastic;

import com.jinnara.testcontainer.repository.MyDocumentRepository;
import org.elasticsearch.client.Request;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@ComponentScan(basePackages = {"com.jinnara.testcontainer.repository"})
public class RestClientTests extends ElasticTestContainer  {
  @Autowired
  MyDocumentRepository myDocumentRepository;

  RestClient restClient = getRestClient();

  @Test
  public void test() throws Exception {
    Response response = restClient.performRequest(new Request("GET", "/_cluster/health"));
    assertEquals(200, response.getStatusLine().getStatusCode());
  }

  @Test
  public void testRepository() {
    assertNotNull(myDocumentRepository);
  }
}
