package com.example.spring_boot_basics_kotlin


class QuoteNotFoundException(
    private var id: Long
): RuntimeException(
    "quote with id: $id not Found"
)