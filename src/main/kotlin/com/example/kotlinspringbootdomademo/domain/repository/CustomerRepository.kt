package com.example.kotlinspringbootdomademo.domain.repository

import com.example.kotlinspringbootdomademo.domain.model.Customer

interface CustomerRepository {
    fun findAll(): List<Customer>
    fun findById(id: Int): Customer?
    fun create(customer: Customer): Int
}