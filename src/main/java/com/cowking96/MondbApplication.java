package com.cowking96;

import com.cowking96.mondb.util.DatabaseCreator;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;

import static org.springframework.boot.Banner.Mode.OFF;

@SpringBootApplication
public class MondbApplication {
	private static final Logger LOG = LoggerFactory.getLogger(MondbApplication.class);

	public static void main(String[] args) {

		try {

			LOG.debug("Application starting");


			new SpringApplicationBuilder()
					.bannerMode(OFF)
					.sources(MondbApplication.class)
					.run(args);
		} catch(Exception e) {
			LOG.error("Unexpected and unhandled exception during operation. Details follow...");
			LOG.error("Exception was of type: {} with message: {}", e.getClass() ,e.getMessage());
			e.printStackTrace();
		}
	}

	@Bean
	public boolean loadMonsterData(DatabaseCreator databaseCreator) {
		databaseCreator.loadData();
		return true;
	}

}