package com.example.spring_boot_basics_kotlin

import jakarta.validation.Constraint
import jakarta.validation.Payload
import jakarta.validation.constraints.Pattern
import kotlin.reflect.KClass


@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
@Constraint(validatedBy = [])
@Pattern(
    regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}\$",
    message = "Password must be like example Passw0rd no special chars"
)
annotation class Password(
    val message: String = "Password must be like example Passw0rd no special chars",
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<out Payload>> = []
)
