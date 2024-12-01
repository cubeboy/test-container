package com.jinnara.testcontainer.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@AllArgsConstructor
@Getter
@Setter
@Document(indexName = "test_index")
public class MyDocument {
  @Id
  private String id;
  private String content;
}
