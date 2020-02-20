package com.pmh.freedom.springboot.es;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.pmh.freedom.springboot.FreedomSpringbootApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = FreedomSpringbootApplication.class)
class ESApplicationTest {
	
	@Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

	@Test
    public void testCreateIndex() {
        elasticsearchTemplate.createIndex(Item.class);
    }

}
