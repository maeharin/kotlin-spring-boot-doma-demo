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

    override fun findById(id: Int): Customer? {
        return customerDomaDao.selectById(id)?.let { _mapToModel(it) }
    }

    override fun create(customer: Customer): Int {
        val domaEntity = _mapToDomaEntity(customer)
        customerDomaDao.insert(domaEntity)
        return domaEntity.id
    }

    override fun update(customer: Customer) {
        val domaEntity = _mapToDomaEntity(customer)
        customerDomaDao.update(domaEntity)
    }

    override fun delete(customer: Customer) {
        val domaEntity = _mapToDomaEntity(customer)
        customerDomaDao.delete(domaEntity)
    }

    private fun _mapToModel(domaEntity: CustomerDomaEntity): Customer {
        return Customer(
                id = domaEntity.id,
                name = domaEntity.name,
                email = domaEntity.email
        )
    }

    private fun _mapToDomaEntity(customer: Customer): CustomerDomaEntity {
        return CustomerDomaEntity().also {
            it.id = customer.id
            it.name = customer.name
            it.email = customer.email
        }
    }
}