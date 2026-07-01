package com.example.spring_boot_basics_kotlin

import org.hibernate.validator.constraints.Length
import org.intellij.lang.annotations.Pattern

data class QuoteDTO(
    val id: Long,
    @field:Length(
        min = 5,
        max = 64,
        message = "Ayo cuh content must be in [4,64] range cuh"
    )
    var content: String,
    @field:jakarta.validation.constraints.Pattern(
        regexp = "\\b[a-zA-Z]+\\b(?:\\s+\\b[a-zA-Z]+\\b)+",
        message = "author name must be full cuh"
    )
    val author: String,

)
