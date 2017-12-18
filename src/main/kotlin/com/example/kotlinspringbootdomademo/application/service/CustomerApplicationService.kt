package com.example.kotlinspringbootdomademo.application.service

import com.example.kotlinspringbootdomademo.application.RecordNotFoundException
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
    fun findAll(): List<Customer> {
        return customerRepository.findAll()
    }

    fun findById(id: Int): Customer {
        return customerRepository.findById(id) ?: throw RecordNotFoundException()
    }

    fun create(customerInput: CustomerInput): Int {
        val customer = Customer(
                name = customerInput.name!!,
                email = customerInput.email!!
        )

        return customerRepository.create(customer)
    }

    fun update(id: Int, customerInput: CustomerInput) {
        val existingCustomer = customerRepository.findById(id) ?: throw RecordNotFoundException()

        val customer = existingCustomer.copy(
                name = customerInput.name!!,
                email = customerInput.email!!
        )

        customerRepository.update(customer)
    }

    fun delete(id: Int) {
        val customer = customerRepository.findById(id) ?: throw RecordNotFoundException()
        customerRepository.delete(customer)
    }
}