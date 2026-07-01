package com.example.spring_boot_basics_kotlin.service

import com.example.spring_boot_basics_kotlin.QuoteDTO
import com.example.spring_boot_basics_kotlin.entity.QuoteEntity

fun QuoteEntity.toDto(): QuoteDTO{
    return QuoteDTO(
        id= this.id,
        author = this.author,
        content = this.content
    )
}

fun QuoteDTO.toEntity(): QuoteEntity{
    return QuoteEntity(
        id= this.id,
        author = this.author,
        content = this.content,
    )
}