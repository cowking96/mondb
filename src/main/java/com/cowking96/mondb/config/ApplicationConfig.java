package com.cowking96.mondb.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties
public class ApplicationConfig {

    static final Logger LOG = LoggerFactory.getLogger(JpaProperties.class);

    private final JpaProperties jpaProperties;

    @Autowired
    public ApplicationConfig( JpaProperties jpaProperties){
        this.jpaProperties = jpaProperties;
        LOG.debug("jpa user name is: {}", jpaProperties.getUserName());

    }
}
