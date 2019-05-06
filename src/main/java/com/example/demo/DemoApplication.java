package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	interface A {
		void doA();
	}

	interface B {
		void doB();
	}

	@Service
	static class SomeService {
		@Autowired
		public <T extends A & B> SomeService(List<T> impls) {
			impls.forEach(s -> {
				s.doA();
				s.doB();
			});
		}
	}

	@Component
	static class AwithB implements A, B {

		@Override
		public void doA() {

		}

		@Override
		public void doB() {

		}
	}

	@Component
	static class AwithoutB implements A {

		@Override
		public void doA() {

		}
	}
}

