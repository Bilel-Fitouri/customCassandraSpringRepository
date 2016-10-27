package org.spring.cassandra.example.config;

import org.springframework.context.annotation.*;

/**
 * Created by bfitouri on 26/10/16.
 */
@Configuration
@ComponentScan(basePackages = "org.spring.cassandra.example")
@Import({CassandraConfig.class})
public class AppConfig {




}
