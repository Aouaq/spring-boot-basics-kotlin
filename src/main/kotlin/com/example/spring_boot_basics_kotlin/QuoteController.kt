package com.example.spring_boot_basics_kotlin

import com.example.spring_boot_basics_kotlin.service.QuotesService
import jakarta.validation.Valid
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate


@RestController
@RequestMapping("/quotes")
class QuoteController(
    private val quotesService: QuotesService,
    private val restTemplate3: RestTemplate
) {

    val quotes = mutableListOf<QuoteDTO>()

    @GetMapping
    fun loadQuotes(
        @RequestParam("q", required = false) q: String?
    ): List<QuoteDTO>{
        return quotesService.getQuotes(q)
    }

    @PostMapping
    fun postQuote(
       @Valid @RequestBody quoteDTO:QuoteDTO
    ): QuoteDTO {
        return quotesService.insertQuote(quoteDTO)
    }


//    @PutMapping
//    fun update(
//       @Valid @RequestBody quoteDTO:QuoteDTO
//    ): QuoteDTO
//    {
//        return quotesService.updateQuote(quoteDTO)
//    }

    @DeleteMapping("/{id}")
    fun deletequote(@PathVariable("id") id : Long){
        quotesService.deleteQuote(id)

    }


}