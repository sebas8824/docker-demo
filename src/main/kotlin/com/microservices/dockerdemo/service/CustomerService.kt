package com.microservices.dockerdemo.service

import com.microservices.dockerdemo.data.Customer

interface CustomerService {
    fun getCustomer(id: Int): Customer?
    fun getAllCustomers(): List<Customer>
}