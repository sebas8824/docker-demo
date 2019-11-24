package com.microservices.dockerdemo.service

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
        Assert.assertNotNull(customer)
        Assert.assertEquals(customer?.name, "Kotlin")
    }

    @Test
    fun `we should get all the customers`() {
        val customers = customerService.getAllCustomers()
        Assert.assertEquals(customers.size, 3)
    }
}