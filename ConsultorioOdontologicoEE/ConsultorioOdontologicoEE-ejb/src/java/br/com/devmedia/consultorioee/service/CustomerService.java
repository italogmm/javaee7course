/*
 * Copyright (C) 2015 italogustavomirandamelo
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package br.com.devmedia.consultorioee.service;

import br.com.devmedia.consultorioee.entities.Customer;
import br.com.devmedia.consultorioee.repositories.CustomerRepository;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.ejb.PostActivate;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author italogustavomirandamelo
 */
@Stateless
@LocalBean
public class CustomerService extends BasicService {

    private static final long serialVersionUID = 1L;

    @PersistenceContext
    private EntityManager em;
    private CustomerRepository customerRepository;

    @PostConstruct
    @PostActivate
    private void postConstruct() {
        customerRepository = new CustomerRepository(em);
    }
    
    public Customer addCustomer(Customer customer) {
        return customerRepository.addCustomer(customer);
    }

    public Customer setCustomer(Customer customer) {
        return customerRepository.setCustomer(customer);
    }

    public void removeCustomer(Customer customer) {
        customerRepository.removeCustomer(customer);
    }

    public Customer getCustomer(int idCostumer) {
        return customerRepository.getCustomer(idCostumer);
    }

    public List<Customer> getCustomerByName(String name) {
        return customerRepository.getCustomerByName(name);
    }
    
    public List<Customer> getCustomersToCall(int month, int year) {
        return customerRepository.getCustomersToCall(month, year);
    }
    
    public List<Customer> getCustomersComPagamentoEmAberto(int idOfCustomer) {
        return customerRepository.getCustomersComPagamentoEmAberto(idOfCustomer);
    }
}
