package com.microservices.dockerdemo.actuator

import com.microservices.dockerdemo.service.CustomerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.actuate.health.AbstractHealthIndicator
import org.springframework.boot.actuate.health.Health
import org.springframework.stereotype.Component
import java.lang.Exception

@Component
class CustomerServiceHealthIndicator: AbstractHealthIndicator() {

    @Autowired
    lateinit var customerService: CustomerService

    override fun doHealthCheck(builder: Health.Builder) {
        val customersPresent = try {
            val customersPresent = customerService.getAllCustomers().isNotEmpty()
            builder.up()
            customersPresent
        } catch (exception: Exception) {
            builder.down()
            "ERROR:$exception"
        }
        builder.withDetail("customersPresent", customersPresent)
    }

}