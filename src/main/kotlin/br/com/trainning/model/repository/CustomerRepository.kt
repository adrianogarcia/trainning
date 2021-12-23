package br.com.trainning.model.repository

import br.com.trainning.model.Customer
import org.springframework.data.jpa.repository.JpaRepository

interface CustomerRepository: JpaRepository<Customer, Long>