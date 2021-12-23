package br.com.trainning.model.repository.controller

import br.com.trainning.model.Customer
import br.com.trainning.model.repository.CustomerRepository
import org.springframework.data.domain.Example
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/customer")
class CustomerController (val repository: CustomerRepository ){

    @GetMapping
    fun findAll() = repository.findAll()


    @PostMapping
    fun addCustomer(@RequestBody customer: Customer) = repository.save(customer)


    @PutMapping("/{id}")
    fun updateCustomer(@PathVariable id: Long, @RequestBody customer: Customer){

        assert(customer.id == id)

        repository.save(customer)
    }


    @DeleteMapping("/{id}")
    fun removeCustomer(@PathVariable id: Long)
        = repository.delete(repository.getById(id))


    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long) = repository.findOne(Example.of(repository.getById(id)))

}