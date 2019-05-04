package com.examples.config;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import com.datastax.driver.mapping.MappingManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cassandra.CassandraAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(CassandraAutoConfiguration.class)
public class AppConfig {

    @Bean
    @Autowired
    public MappingManager mappingManager(Session session){
        MappingManager manager = new MappingManager(session);
        return  manager;
    }
    @Bean
    @Autowired
    public Session session(Cluster cluster){
        return cluster.connect();
    }


}
