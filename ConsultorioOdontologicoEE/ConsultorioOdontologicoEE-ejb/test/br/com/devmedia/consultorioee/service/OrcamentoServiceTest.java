/*
 * Copyright (C) 2015 italo.miranda
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
import br.com.devmedia.consultorioee.entities.Orcamentoitem;
import br.com.devmedia.consultorioee.entities.PaymentType;
import br.com.devmedia.consultorioee.entities.Service;
import br.com.devmedia.consultorioee.entities.Users;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Random;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.NamingException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author italo.miranda
 */
public class OrcamentoServiceTest {
    
    private EJBContainer container;
    private OrcamentoService instance;
    private CustomerService instanceCustomer;
    private UserService instanceUser;
    private ServiceService instanceService;
    
    private Customer customerOne;
    private Users usrOne;

    private Service servOne;
    
    private Orcamento orcamentoOne;
    
    private Orcamento orcamentoTwo;
    private Orcamento orcamentoThree;
    
    private Orcamentoitem orcamentoItemOfOne;
    
    
    
    
    public OrcamentoServiceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws NamingException {
        
        container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        instance = (OrcamentoService) container.getContext().lookup("java:global/classes/OrcamentoService");
        instanceCustomer = (CustomerService) container.getContext().lookup("java:global/classes/CustomerService");
        instanceUser = (UserService) container.getContext().lookup("java:global/classes/UserService");
        instanceService = (ServiceService) container.getContext().lookup("java:global/classes/ServiceService");

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
        
        usrOne = new Users();
        usrOne.setUsuAdministrator(new Random().nextBoolean());
        usrOne.setUsuDentist(new Random().nextBoolean());
        usrOne.setUsuLogin("testLoginOne " + new Random().nextInt());
        usrOne.setUsuName("testNameOne " + new Random().nextInt());
        usrOne.setUsuPassword((usrOne.getUsuLogin()));
        
        orcamentoOne = new Orcamento();
        orcamentoOne.setOrcCustomer(customerOne);
        orcamentoOne.setOrcDate(new Date());
        orcamentoOne.setOrcHour(new Date());
        orcamentoOne.setOrcObs("Obs " + new Random().nextInt());
        orcamentoOne.setOrcTimes(new Random().nextInt(10));
        orcamentoOne.setOrcTotal(new BigDecimal(Math.abs(new Random().nextDouble())));
        orcamentoOne.setOrcpaymentType(PaymentType.CREDITO);
        
        servOne = new Service();
        servOne.setSrvName("Serv orc teste One " + new Random().nextInt());
        servOne.setSrvCost(orcamentoOne.getOrcTotal());
        
        orcamentoItemOfOne = new Orcamentoitem();
        orcamentoItemOfOne.setOriCost(orcamentoOne.getOrcTotal());
        orcamentoItemOfOne.setOriObs("Obs Item " + new Random().nextInt());
        orcamentoItemOfOne.setOriService(servOne);
        
        orcamentoOne.addItem(orcamentoItemOfOne);
        
        customerOne = instanceCustomer.addCustomer(customerOne);
        usrOne = instanceUser.addUser(usrOne);
        orcamentoTwo = instance.addOrcamento(orcamentoTwo);
        orcamentoOne = instance.addOrcamento(orcamentoOne);
    }
    
    
    @After
    public void tearDown() {
        
        instance.removeOrcamento(orcamentoOne);
        instance.removeOrcamento(orcamentoTwo);
        
        instanceCustomer.removeCustomer(customerOne);
        instanceUser.removeUser(usrOne);
        
        instance = null;
        instanceCustomer = null;
        instanceUser = null;
        
        customerOne = null;
        usrOne = null;

        container.close();
        container = null;
    }

    /**
     * Test of addOrcamento method, of class OrcamentoService.
     */
    @Test
    public void testAddOrcamento() throws Exception {
        System.out.println("addOrcamento");
        Orcamento orc = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        OrcamentoService instance = (OrcamentoService)container.getContext().lookup("java:global/classes/OrcamentoService");
        Orcamento expResult = null;
        Orcamento result = instance.addOrcamento(orc);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setOrcamento method, of class OrcamentoService.
     */
    @Test
    public void testSetOrcamento() throws Exception {
        System.out.println("setOrcamento");
        Orcamento orc = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        OrcamentoService instance = (OrcamentoService)container.getContext().lookup("java:global/classes/OrcamentoService");
        Orcamento expResult = null;
        Orcamento result = instance.setOrcamento(orc);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeOrcamento method, of class OrcamentoService.
     */
    @Test
    public void testRemoveOrcamento() throws Exception {
        System.out.println("removeOrcamento");
        Orcamento orc = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        OrcamentoService instance = (OrcamentoService)container.getContext().lookup("java:global/classes/OrcamentoService");
        instance.removeOrcamento(orc);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOrcamentos method, of class OrcamentoService.
     */
    @Test
    public void testGetOrcamentos() throws Exception {
        System.out.println("getOrcamentos");
        Integer idOfCostumer = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        OrcamentoService instance = (OrcamentoService)container.getContext().lookup("java:global/classes/OrcamentoService");
        List<Orcamento> expResult = null;
        List<Orcamento> result = instance.getOrcamentos(idOfCostumer);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getItens method, of class OrcamentoService.
     */
    @Test
    public void testGetItens() throws Exception {
        System.out.println("getItens");
        Integer idOfOrcamento = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        OrcamentoService instance = (OrcamentoService)container.getContext().lookup("java:global/classes/OrcamentoService");
        List<Orcamentoitem> expResult = null;
        List<Orcamentoitem> result = instance.getItens(idOfOrcamento);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeItem method, of class OrcamentoService.
     */
    @Test
    public void testRemoveItem() throws Exception {
        System.out.println("removeItem");
        Orcamentoitem orcItem = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        OrcamentoService instance = (OrcamentoService)container.getContext().lookup("java:global/classes/OrcamentoService");
        instance.removeItem(orcItem);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addItem method, of class OrcamentoService.
     */
    @Test
    public void testAddItem() throws Exception {
        System.out.println("addItem");
        Orcamentoitem orcItem = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        OrcamentoService instance = (OrcamentoService)container.getContext().lookup("java:global/classes/OrcamentoService");
        instance.addItem(orcItem);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setItem method, of class OrcamentoService.
     */
    @Test
    public void testSetItem() throws Exception {
        System.out.println("setItem");
        Orcamentoitem orcItem = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        OrcamentoService instance = (OrcamentoService)container.getContext().lookup("java:global/classes/OrcamentoService");
        Orcamentoitem expResult = null;
        Orcamentoitem result = instance.setItem(orcItem);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getItem method, of class OrcamentoService.
     */
    @Test
    public void testGetItem() throws Exception {
        System.out.println("getItem");
        Integer orcamentoItemId = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        OrcamentoService instance = (OrcamentoService)container.getContext().lookup("java:global/classes/OrcamentoService");
        Orcamentoitem expResult = null;
        Orcamentoitem result = instance.getItem(orcamentoItemId);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
