package com.cowking96.mondb.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "jpa")
public class JpaProperties {

    static final Logger LOG = LoggerFactory.getLogger(JpaProperties.class);

    private String driverClass;
    private String jdbcUrl;
    private String userName;

    public String getJdbcURL() {
        return jdbcUrl;
    }

    public void setJdbcURL(String jdbcUrl) {
        this.jdbcUrl = jdbcUrl;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDriverClass() {
        return driverClass;
    }

    public void setDriverClass(String driverClass) {
        this.driverClass = driverClass;
        LOG.debug("Driver class set to " + driverClass);
    }
}
