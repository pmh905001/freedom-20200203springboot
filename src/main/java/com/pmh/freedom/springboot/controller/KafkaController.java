package com.pmh.freedom.springboot.controller;

import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pmh.freedom.springboot.services.RedisService;

@RestController
@RequestMapping("/kafka")
public class KafkaController {
	@Autowired
	private RedisService redisService;

	@RequestMapping("/producer")
	public String producer() {

		// Assign topicName to string variable
		String topicName = "test";

		// create instance for properties to access producer configs
		Properties props = new Properties();

		// Assign localhost id 192.168.75.132
		props.put("bootstrap.servers", "localhost:9092");

		props.put("acks", "all");

		// If the request fails, the producer can automatically retry,
		props.put("retries", 0);

		// Specify buffer size in config
		props.put("batch.size", 16384);

		props.put("buffer.memory", 33554432);

		props.put("key.serializer",
				"org.apache.kafka.common.serialization.StringSerializer");
		props.put("value.serializer",
				"org.apache.kafka.common.serialization.StringSerializer");

		Producer<String, String> producer = new KafkaProducer<String, String>(
				props);
		for (int i = 0; i < 10; i++) {
			producer.send(new ProducerRecord<String, String>(topicName, Integer
					.toString(i), Integer.toString(i)));

		}
		System.out.println("message send successfully");
		producer.close();
		return "success";
	}

	@RequestMapping("/consumer")
	public String consumer(String key) {
		String topic = "test";
		String group = "group";

		Properties props = new Properties();
		props.put("bootstrap.servers", "localhost:9092");
		props.put("group.id", group);
		props.put("enable.auto.commit", "true");
		props.put("auto.commit.interval.ms", "1000");
		props.put("session.timeout.ms", "30000");
		// 当各分区下有已提交的offset时，从提交的offset开始消费；无提交的offset时，从头开始消费
		props.put("auto.offset.reset", "earliest");
		props.put("key.deserializer",
				"org.apache.kafka.common.serialization.StringDeserializer");
		props.put("value.deserializer",
				"org.apache.kafka.common.serialization.StringDeserializer");

		KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(
				props);

		consumer.subscribe(Arrays.asList(topic));
		while (true) {
			ConsumerRecords<String, String> records = consumer.poll(200);
			for (ConsumerRecord<String, String> record : records) {
				System.out.printf(
						"============offset = %d,key = %s,value=%s\n",
						record.offset(), record.key(), record.value());
			}
			// 提交已经拉取出来的offset,如果是手动模式下面,必须拉取之后提交,否则以后会拉取重复消息
			consumer.commitSync();

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
