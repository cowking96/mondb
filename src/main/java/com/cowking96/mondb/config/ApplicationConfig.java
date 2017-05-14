package com.cowking96.mondb.config;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties
public class ApplicationConfig {

    static final Logger LOG = LoggerFactory.getLogger(ApplicationConfig.class);

    private String driverClass;
    private String jdbcURL;
    private String userName;
    private String hibernateShowSql;

    public ApplicationConfig(){
        LOG.debug("ApplicationConfig constructed");
    }

    public String getDriverClass() {
        return driverClass;
    }

    public void setDriverClass(String driverClass) {
        this.driverClass = driverClass;
        LOG.debug("Driver class set to " + driverClass);
    }

    public String getJdbcURL() {
        return jdbcURL;
    }

    public void setJdbcURL(String jdbcURL) {
        this.jdbcURL = jdbcURL;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getHibernateShowSql() {
        return hibernateShowSql;
    }

    public void setHibernateShowSql(String hibernateShowSql) {
        this.hibernateShowSql = hibernateShowSql;
    }


}
