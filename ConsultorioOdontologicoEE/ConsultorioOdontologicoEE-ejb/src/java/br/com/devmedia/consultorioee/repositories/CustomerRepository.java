/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.devmedia.consultorioee.repositories;

import br.com.devmedia.consultorioee.entities.Customer;
import br.com.devmedia.consultorioee.service.BasicRepository;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
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

    public List<Customer> getCustomerByName(String name) {
        return getPureList(Customer.class, "select cus from Customer cus where cus.cusName like ?1", name + "%");
    }

    public List<Customer> getCustomersToCall(int month, int year) {

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month - 1);
        cal.set(Calendar.DAY_OF_MONTH, 1);

        Date dataInicial = cal.getTime();

        cal.add(Calendar.MONTH, month);
        cal.add(Calendar.DAY_OF_YEAR, -1);

        Date dataFinal = cal.getTime();

        return getPureList(Customer.class, "select orc.orcCustomer from Orcamento orc where orc.orcDate >= ?1 "
                + " and orc.orcDate <= 2", dataInicial, dataFinal);
    }

    public List<Customer> getCustomersComPagamentoEmAberto(int idOfCustomer) {
        return getPureList(Customer.class, "select par.parOrcamento.orcCustomer from Parcela par where "
                + "par.parOrcamento.orcCustomer.cusId = ?1 and par.parPago = ?2 ",
                idOfCustomer, Boolean.FALSE);
    }

}
