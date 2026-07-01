package com.example.spring_boot_basics_kotlin.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.web.client.ResponseErrorHandler
import org.springframework.web.client.RestTemplate

@Configuration
class RestConfig {

    @Bean
    @Primary
    fun restTemplate(): RestTemplate{
        return RestTemplate().apply {
            println("bean 1")
        }
    }

    @Bean
    fun restTemplate2(): RestTemplate{
        return RestTemplate().apply {
            println("bean 2")
        }
    }
}