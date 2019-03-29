package com.mayikt.goods.es.reposiory;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.mayikt.goods.es.entity.ProductEntity;

public interface ProductReposiory extends ElasticsearchRepository<ProductEntity, Long> {

}
 