/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.devmedia.consultorioee.repositories;

import br.com.devmedia.consultorioee.entities.Customer;
import br.com.devmedia.consultorioee.service.BasicRepository;
import javax.persistence.EntityManager;

/**
 *
 * @author italogustavomirandamelo
 */
public class CustomerRepository extends BasicRepository {

    private static final long serialVersionUID = 1L;

    public CustomerRepository(EntityManager entityManager) {
        super(entityManager);
    }

    public Customer addCostumer(Customer customer) {
        return addEntity(Customer.class, customer);
    }

    public Customer setCostumer(Customer customer) {
        return setEntity(Customer.class, customer);
    }

    public void removeCostumer(Customer customer) {
        removeEntity(customer);
    }

    public Customer getCostumer(Customer customer) {
        return getEntity(Customer.class, customer);
    }
    
    public Customer getCostumer(int idCostumer) {
        return getEntity(Customer.class, idCostumer);
    }

}
