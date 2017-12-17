package com.example.kotlinspringbootdomademo.application.service

import com.example.kotlinspringbootdomademo.application.input.CustomerInput
import com.example.kotlinspringbootdomademo.domain.model.Customer
import com.example.kotlinspringbootdomademo.domain.repository.CustomerRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class CustomerApplicationService(
        private val customerRepository: CustomerRepository
) {
    fun create(customerInput: CustomerInput): Int {
        val customer = Customer(
                name = customerInput.name!!,
                email = customerInput.email!!
        )

        return customerRepository.create(customer)
    }
}