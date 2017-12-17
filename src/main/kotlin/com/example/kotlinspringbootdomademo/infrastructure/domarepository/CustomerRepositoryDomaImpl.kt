package com.example.kotlinspringbootdomademo.infrastructure.domarepository

import com.example.kotlinspringbootdomademo.domain.model.Customer
import com.example.kotlinspringbootdomademo.domain.repository.CustomerRepository
import com.example.kotlinspringbootdomademo.infrastructure.doma.dao.CustomerDomaDao
import com.example.kotlinspringbootdomademo.infrastructure.doma.entity.CustomerDomaEntity
import org.springframework.stereotype.Repository

@Repository
class CustomerRepositoryDomaImpl(
        private val customerDomaDao: CustomerDomaDao
): CustomerRepository {
    override fun findAll(): List<Customer> {
        return customerDomaDao.selectAll().map { _mapToModel(it) }
    }

    private fun _mapToModel(domaEntity: CustomerDomaEntity): Customer {
        return Customer(
                id = domaEntity.id,
                name = domaEntity.name,
                email = domaEntity.email
        )
    }
}