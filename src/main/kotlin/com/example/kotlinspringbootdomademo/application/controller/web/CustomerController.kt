package com.example.kotlinspringbootdomademo.application.controller.web

import com.example.kotlinspringbootdomademo.application.RecordNotFoundException
import com.example.kotlinspringbootdomademo.application.input.CustomerInput
import com.example.kotlinspringbootdomademo.application.service.CustomerApplicationService
import com.example.kotlinspringbootdomademo.domain.repository.CustomerRepository
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/customers")
class CustomerController(
        private val customerRepository: CustomerRepository,
        private val customerApplicationService: CustomerApplicationService
) {
    @GetMapping("")
    fun index(model: Model): String {
        val customers = customerRepository.findAll()
        model.addAttribute("customers", customers)
        return "customers/index"
    }

    @GetMapping("{id}")
    fun show(
            @PathVariable id: Int,
            model: Model
    ): String {
        val customer = customerRepository.findById(id) ?: throw RecordNotFoundException()
        model.addAttribute("customer", customer)
        return "customers/show"
    }

    @GetMapping("new")
    fun new(input: CustomerInput): String {
        return "customers/new"
    }

    @PostMapping("")
    fun create(
            @Validated customerInput: CustomerInput,
            bindingResult: BindingResult
    ): String {
        if(bindingResult.hasErrors()) {
            return "customers/new"
        }

        val id = customerApplicationService.create(customerInput)

        return "redirect:/customers/${id}"
    }
}