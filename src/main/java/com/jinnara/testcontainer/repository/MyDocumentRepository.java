package com.jinnara.testcontainer.repository;

import com.jinnara.testcontainer.models.MyDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface MyDocumentRepository extends ElasticsearchRepository<MyDocument, String> {
}
