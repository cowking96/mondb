package com.cowking96;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.builder.SpringApplicationBuilder;

import static org.springframework.boot.Banner.Mode.OFF;

@SpringBootApplication
public class MondbApplication {
	static final Logger LOG = LoggerFactory.getLogger(MondbApplication.class);

	public static void main(String[] args) {

		LOG.debug("Application starting");
		new SpringApplicationBuilder()
				.bannerMode(OFF)
				.sources(MondbApplication.class)
				.run(args);
	}

}
