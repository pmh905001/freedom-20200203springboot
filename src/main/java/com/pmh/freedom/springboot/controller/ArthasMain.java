package com.pmh.freedom.springboot.controller;

import java.util.concurrent.atomic.AtomicInteger;

public class ArthasMain {

	private static AtomicInteger count = new AtomicInteger(1);

	public static void main(String[] args) throws InterruptedException {
		arthas();
	}

	public static void arthas() throws InterruptedException {

		while (true) {
			System.err.println(count.getAndIncrement());
			Thread.currentThread().getId();

//			Thread.sleep(5000);

		}

	}

}
