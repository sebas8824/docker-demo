package com.microservices.dockerdemo.service

import org.amshove.kluent.*
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
internal class CustomerServiceTest {

    @Autowired
    lateinit var customerService: CustomerService

    @Test
    fun `we should get a customer with id 1`() {
        val customer = customerService.getCustomer(1)
        customer.`should not be null`()
        customer?.name `should be` "Kotlin"
    }

    @Test
    fun `we should get all the customers`() {
        val customers = customerService.getAllCustomers()
        customers.size `should equal to` 3
        customers.size `should be greater than` 0
        customers.size shouldBeLessOrEqualTo 3
        customers.size `should be in range` 1..3
    }
}