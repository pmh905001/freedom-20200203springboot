package com.pmh.freedom.springboot.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.pmh.freedom.springboot.entity.BlogModel;


public interface BlogRepository extends ElasticsearchRepository<BlogModel, String> {

}
