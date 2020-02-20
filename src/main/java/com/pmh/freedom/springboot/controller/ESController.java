package com.pmh.freedom.springboot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pmh.freedom.springboot.entity.BlogModel;
import com.pmh.freedom.springboot.repository.BlogRepository;

@RestController
@RequestMapping("/es")
public class ESController {
	@Autowired
	private BlogRepository repository;

	@RequestMapping("/add")
	public BlogModel add(BlogModel view) {
		BlogModel entity = repository.save(view);
		return entity;
	}

	@RequestMapping("/all")
	public List<BlogModel> getAll() {
		Iterable<BlogModel> all = repository.findAll();
		List<BlogModel> list = new ArrayList<>();
		all.forEach(item -> list.add(item));
		return list;
	}
}
