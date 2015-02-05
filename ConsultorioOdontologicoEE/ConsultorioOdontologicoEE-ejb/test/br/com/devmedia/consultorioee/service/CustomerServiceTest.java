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
import br.com.devmedia.consultorioee.entities.Orcamento;
import br.com.devmedia.consultorioee.entities.PaymentType;
import br.com.devmedia.consultorioee.entities.Users;
import java.math.BigDecimal;
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
    private Users usrOne;
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
    public void setUp() throws Exception {

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
        customerOne.setCusName("Customer Name one " + new Random().nextInt());
        customerOne.setCusObs("Obs " + new Random().nextInt());
        customerOne.setCusOcupation("Ocupation " + new Random().nextInt());
        customerOne.setCusState("XX " + new Random().nextInt());
        customerOne.setCusTelephone("Tel " + new Random().nextInt());
        customerOne.setCuscellNumber("Cellnumber " + new Random().nextInt());
        customerOne.setCusworkAdress("Work address one " + new Random().nextInt());
        customerOne.setCusworkName("Work name one " + new Random().nextInt());
        customerOne.setCusworkNumber("Work number one " + new Random().nextInt());
        customerOne.setCusworkObs("Work number obs " + new Random().nextInt());

        customerTwo = new Customer();
        customerTwo.setCusAdress("Address two " + new Random().nextInt());
        customerTwo.setCusbornDate(new Date());
        customerTwo.setCusAge(Math.abs(new Random().nextInt(99)));
        customerTwo.setCusCity("City " + new Random().nextInt());
        customerTwo.setCusComplement("Complement " + new Random().nextInt());
        customerTwo.setCusFather("Father " + new Random().nextInt());
        customerTwo.setCusMother("Mother " + new Random().nextInt());
        customerTwo.setCusName("Customer Name two " + new Random().nextInt());
        customerTwo.setCusObs("Obs " + new Random().nextInt());
        customerTwo.setCusOcupation("Ocupation " + new Random().nextInt());
        customerTwo.setCusState("XX " + new Random().nextInt());
        customerTwo.setCusTelephone("Tel " + new Random().nextInt());
        customerTwo.setCuscellNumber("Cellnumber " + new Random().nextInt());
        customerTwo.setCusworkAdress("Work address two " + new Random().nextInt());
        customerTwo.setCusworkName("Work name two " + new Random().nextInt());
        customerTwo.setCusworkNumber("Work number two " + new Random().nextInt());
        customerTwo.setCusworkObs("Work number two " + new Random().nextInt());

        customerThree = new Customer();
        customerThree.setCusAdress("Address three " + new Random().nextInt());
        customerThree.setCusbornDate(new Date());
        customerThree.setCusAge(Math.abs(new Random().nextInt(99)));
        customerThree.setCusCity("City " + new Random().nextInt());
        customerThree.setCusComplement("Complement " + new Random().nextInt());
        customerThree.setCusFather("Father " + new Random().nextInt());
        customerThree.setCusMother("Mother " + new Random().nextInt());
        customerThree.setCusName("Customer Name three " + new Random().nextInt());
        customerThree.setCusObs("Obs " + new Random().nextInt());
        customerThree.setCusOcupation("Ocupation " + new Random().nextInt());
        customerThree.setCusState("XX " + new Random().nextInt());
        customerThree.setCusTelephone("Tel " + new Random().nextInt());
        customerThree.setCuscellNumber("Cellnumber " + new Random().nextInt());
        customerThree.setCusworkAdress("Work address three " + new Random().nextInt());
        customerThree.setCusworkName("Work name three " + new Random().nextInt());
        customerThree.setCusworkNumber("Work number three " + new Random().nextInt());
        customerThree.setCusworkObs("Work number three " + new Random().nextInt());

        usrOne = new Users();
        usrOne.setUsuAdministrator(new Random().nextBoolean());
        usrOne.setUsuDentist(new Random().nextBoolean());
        usrOne.setUsuLogin("testLoginOne " + new Random().nextInt());
        usrOne.setUsuName("testNameOne " + new Random().nextInt());
        usrOne.setUsuPassword((usrOne.getUsuLogin()));
        
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

        Customer customer = new Customer();
        customer.setCusAdress("Address testeAdd " + new Random().nextInt());
        customer.setCusbornDate(new Date());
        customer.setCusAge(Math.abs(new Random().nextInt(99)));
        customer.setCusCity("City " + new Random().nextInt());
        customer.setCusComplement("Complement " + new Random().nextInt());
        customer.setCusFather("Father " + new Random().nextInt());
        customer.setCusMother("Mother " + new Random().nextInt());
        customer.setCusName("Name testeAdd " + new Random().nextInt());
        customer.setCusObs("Obs " + new Random().nextInt());
        customer.setCusOcupation("Ocupation " + new Random().nextInt());
        customer.setCusState("XX " + new Random().nextInt());
        customer.setCusTelephone("Tel " + new Random().nextInt());
        customer.setCuscellNumber("Cellnumber " + new Random().nextInt());
        customer.setCusworkAdress("Work address testeAdd " + new Random().nextInt());
        customer.setCusworkName("Work name testeAdd " + new Random().nextInt());
        customer.setCusworkNumber("Work number testeAdd " + new Random().nextInt());
        customer.setCusworkObs("Work number testeAdd " + new Random().nextInt());

        Customer result = instance.addCustomer(customer);
        
        Customer expResult = instance.getCustomer(result.getCusId());
        
        assertEquals(expResult, result);
        assertEquals(expResult.getCusName(), result.getCusName());
    }

    /**
     * Test of setCustomer method, of class CustomerService.
     */
    @Test
    public void testSetCustomer() throws Exception {
        
        System.out.println("setCustomer");

        String newNameOfCustomer = "Customer changed name " + new Random().nextInt();
        Customer cus = customerTwo;
        cus.setCusName(newNameOfCustomer);
        
        Customer result = instance.setCustomer(cus);
        assertEquals(newNameOfCustomer, result.getCusName());
    }

    /**
     * Test of removeCustomer method, of class CustomerService.
     */
    @Test
    public void testRemoveCustomer() throws Exception {
        System.out.println("removeCustomer");

        Customer cus = new Customer();
        cus.setCusAdress("Address testeRemove " + new Random().nextInt());
        cus.setCusbornDate(new Date());
        cus.setCusAge(Math.abs(new Random().nextInt(99)));
        cus.setCusCity("City " + new Random().nextInt());
        cus.setCusComplement("Complement " + new Random().nextInt());
        cus.setCusFather("Father " + new Random().nextInt());
        cus.setCusMother("Mother " + new Random().nextInt());
        cus.setCusName("Name testeAdd " + new Random().nextInt());
        cus.setCusObs("Obs " + new Random().nextInt());
        cus.setCusOcupation("Ocupation " + new Random().nextInt());
        cus.setCusState("XX " + new Random().nextInt());
        cus.setCusTelephone("Tel " + new Random().nextInt());
        cus.setCuscellNumber("Cellnumber " + new Random().nextInt());
        cus.setCusworkAdress("Work address testeRemove " + new Random().nextInt());
        cus.setCusworkName("Work name testeRemove " + new Random().nextInt());
        cus.setCusworkNumber("Work number testeRemove " + new Random().nextInt());
        cus.setCusworkObs("Work number testeRemove " + new Random().nextInt());

        Customer toRemove = instance.addCustomer(cus);
        Customer gettedToRemove = instance.getCustomer(toRemove.getCusId());
        
        assertNotNull(toRemove);
        assertNotNull(gettedToRemove);
        
        instance.removeCustomer(gettedToRemove);
        
        Customer removed = instance.getCustomer(gettedToRemove.getCusId());
        assertNull(removed);
    }

    /**
     * Test of getCustomer method, of class CustomerService.
     */
    @Test
    public void testGetCustomer() throws Exception {
        System.out.println("getCustomer");

        int idCustomer = customerThree.getCusId();
        
        Customer expResult = customerThree;
        Customer result = instance.getCustomer(idCustomer);
        
        assertEquals(expResult, result);
    }

    /**
     * Test of getCustomerByName method, of class CustomerService.
     */
    @Test
    public void testGetCustomerByName() throws Exception {
        System.out.println("getCustomerByName");

        assertEquals(3, instance.getCustomerByName("Customer Name"));
        assertEquals(1, instance.getCustomerByName("Customer Name one"));
        assertEquals(1, instance.getCustomerByName("Customer Name two"));
        assertEquals(1, instance.getCustomerByName("Customer Name three"));
        assertEquals(0, instance.getCustomerByName("ksaakdasdklhjdk" + new Random().nextInt()));
    }

    /**
     * Test of getCustomersToCall method, of class CustomerService.
     */
    @Test
    public void testGetCustomersToCall() throws Exception {
        System.out.println("getCustomersToCall");

        int month = new Random().nextInt(13);
        if(month == 0) month++;
        
        int year = 2013;
        
        Orcamento orcamento = new Orcamento();
        orcamento.setOrcCustomer(customerOne);
        orcamento.setOrcDentist(usrOne);
        orcamento.setOrcTimes(10);
        orcamento.setOrcTotal(BigDecimal.TEN);
        orcamento.setOrcpaymentType(PaymentType.CREDITO);
        
        
        List<Customer> expResult = null;
        List<Customer> result = instance.getCustomersToCall(month, year);
        assertEquals(expResult, result);
    }

    /**
     * Test of getCustomersComPagamentoEmAberto method, of class
     * CustomerService.
     */
    @Test
    public void testGetCustomersComPagamentoEmAberto() throws Exception {
        System.out.println("getCustomersComPagamentoEmAberto");

        int idOfCustomer = 0;
        List<Customer> expResult = null;
        List<Customer> result = instance.getCustomersComPagamentoEmAberto(idOfCustomer);
        assertEquals(expResult, result);
    }
}
