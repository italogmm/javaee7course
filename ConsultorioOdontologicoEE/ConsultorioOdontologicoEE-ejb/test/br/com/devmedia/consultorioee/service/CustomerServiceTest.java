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
import java.util.Date;
import java.util.List;
import java.util.Random;
import javax.ejb.embeddable.EJBContainer;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author italogustavomirandamelo
 */
public class CustomerServiceTest {
    
    private Customer customerOne;
    private Customer customerTwo;
    private Customer customerThree;

    private EJBContainer container;
    private CustomerService instance;
    
    public CustomerServiceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws Exception{
        
        container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        instance = (CustomerService) container.getContext().lookup("java:global/classes/CustomerService");

        customerOne = new Customer();
        customerOne.setCusAdress("Address one " + new Random().nextInt());
        customerOne.setCusbornDate(new Date());
        customerOne.setCusAge(Math.abs(new Random().nextInt(99)));
        customerOne.setCusCity("City " + new Random().nextInt());
        customerOne.setCusComplement("Complement " + new Random().nextInt());
        customerOne.setCusFather("Father " + new Random().nextInt());
        customerOne.setCusMother("Mother " + new Random().nextInt());
        customerOne.setCusName("Name One " + new Random().nextInt());
        customerOne.setCusObs("Obs " + new Random().nextInt());
        customerOne.setCusOcupation("Ocupation " + new Random().nextInt());
        customerOne.setCusState("XX " + new Random().nextInt());
        customerOne.setCusTelephone("Tel " + new Random().nextInt());
        customerOne.setCuscellNumber("Cellnumber " + new Random().nextInt());
        customerOne.setCusworkAdress("Work address one " + new Random().nextInt());
        
        customerTwo = new Customer();
        
        customerThree = new Customer();

        customerOne = instance.addCustomer(customerOne);
        customerTwo = instance.addCustomer(customerTwo);
        customerThree = instance.addCustomer(customerThree);
    }
    
    @After
    public void tearDown() {
        
        instance.removeCustomer(customerOne);
        instance.removeCustomer(customerTwo);
        instance.removeCustomer(customerThree);

        instance = null;

        customerOne = null;
        customerTwo = null;
        customerThree = null;

        container.close();
        container = null;
        
    }

    /**
     * Test of addCustomer method, of class CustomerService.
     */
    @Test
    public void testAddCustomer() throws Exception {
        System.out.println("addCustomer");
        Customer customer = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        CustomerService instance = (CustomerService)container.getContext().lookup("java:global/classes/CustomerService");
        Customer expResult = null;
        Customer result = instance.addCustomer(customer);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCustomer method, of class CustomerService.
     */
    @Test
    public void testSetCustomer() throws Exception {
        System.out.println("setCustomer");
        Customer customer = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        CustomerService instance = (CustomerService)container.getContext().lookup("java:global/classes/CustomerService");
        Customer expResult = null;
        Customer result = instance.setCustomer(customer);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeCustomer method, of class CustomerService.
     */
    @Test
    public void testRemoveCustomer() throws Exception {
        System.out.println("removeCustomer");
        Customer customer = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        CustomerService instance = (CustomerService)container.getContext().lookup("java:global/classes/CustomerService");
        instance.removeCustomer(customer);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCustomer method, of class CustomerService.
     */
    @Test
    public void testGetCustomer() throws Exception {
        System.out.println("getCustomer");
        int idCustomer = 0;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        CustomerService instance = (CustomerService)container.getContext().lookup("java:global/classes/CustomerService");
        Customer expResult = null;
        Customer result = instance.getCustomer(idCustomer);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCustomerByName method, of class CustomerService.
     */
    @Test
    public void testGetCustomerByName() throws Exception {
        System.out.println("getCustomerByName");
        String name = "";
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        CustomerService instance = (CustomerService)container.getContext().lookup("java:global/classes/CustomerService");
        List<Customer> expResult = null;
        List<Customer> result = instance.getCustomerByName(name);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCustomersToCall method, of class CustomerService.
     */
    @Test
    public void testGetCustomersToCall() throws Exception {
        System.out.println("getCustomersToCall");
        int month = 0;
        int year = 0;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        CustomerService instance = (CustomerService)container.getContext().lookup("java:global/classes/CustomerService");
        List<Customer> expResult = null;
        List<Customer> result = instance.getCustomersToCall(month, year);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCustomersComPagamentoEmAberto method, of class CustomerService.
     */
    @Test
    public void testGetCustomersComPagamentoEmAberto() throws Exception {
        System.out.println("getCustomersComPagamentoEmAberto");
        int idOfCustomer = 0;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        CustomerService instance = (CustomerService)container.getContext().lookup("java:global/classes/CustomerService");
        List<Customer> expResult = null;
        List<Customer> result = instance.getCustomersComPagamentoEmAberto(idOfCustomer);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
