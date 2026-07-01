package com.example.spring_boot_basics_kotlin.repository

import com.example.spring_boot_basics_kotlin.QuoteDTO
import com.example.spring_boot_basics_kotlin.QuoteNotFoundException
import com.example.spring_boot_basics_kotlin.entity.QuoteEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

interface QuotesRepository: JpaRepository<QuoteEntity, Long> {
    @Query("""
            SELECT q FROM QuoteEntity q WHERE LOWER(q.content)
          LIKE LOWER(CONCAT('%', :query, '%')) OR LOWER(q.author)
           LIKE LOWER(CONCAT('%', :query, '%'))
         """)
    fun findByContentContainingIgnoreCaseOrAuthorContainingIgnoreCase(query: String): List<QuoteEntity>
//    fun findByAuthorContainsIgnoreCase(query: String): List<QuoteEntity>
}