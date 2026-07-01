package com.example.spring_boot_basics_kotlin.service

import com.example.spring_boot_basics_kotlin.QuoteDTO
import com.example.spring_boot_basics_kotlin.config.QuotesConfig
import com.example.spring_boot_basics_kotlin.repository.QuotesRepository
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class QuotesService(
    val quotesRepository: QuotesRepository,
    @param:Value("\${spring.application.version}") private val version: String,
    @param:Value("\${CUSTOM_ENV}") private val customenv: String,
    quotesConfig: QuotesConfig

) {

    init {
        println("spring backend is running on version $version")
        println("custom env $customenv")
        println(quotesConfig)
    }

    fun getQuotes(query: String?): List<QuoteDTO> {
        return if (!query.isNullOrBlank()){
            quotesRepository.findByContentContainingIgnoreCaseOrAuthorContainingIgnoreCase(query).map { it.toDto() }
        }
        else { quotesRepository.findAll().map { it.toDto() } }
    }

    fun insertQuote(quoteDTO: QuoteDTO): QuoteDTO{
        return quotesRepository.save(quoteDTO.toEntity()).toDto()
    }

//    fun updateQuote(quoteDTO: QuoteDTO):QuoteDTO {
//        return quotesRepository.updateQuote(quoteDTO)
//    }

    fun deleteQuote(quoteId: Long){
        quotesRepository.deleteById(quoteId)
    }

}