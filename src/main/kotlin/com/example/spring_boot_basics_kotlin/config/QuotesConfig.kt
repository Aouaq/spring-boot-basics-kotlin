package com.example.spring_boot_basics_kotlin.config

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "quotes")
data class QuotesConfig(
    val search: SearchConfig,
    val validation: ValidationConfig
) {

    data class SearchConfig(
        val ignoreCase: Boolean= true,
        val minlength: Int=5,
    )

    data class ValidationConfig(
        val mincontentlength: Int=5,
        val maxcontentlength: Int=500,
        val requireauthor: Boolean=true,
        val allowedcategories: List<String> = emptyList()
    )
}