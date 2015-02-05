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

import br.com.devmedia.consultorioee.entities.Service;
import java.math.BigDecimal;
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
public class ServiceServiceTest {   
    
    private Service servOne;
    private Service servTwo;
    private Service servThree;

    private EJBContainer container;
    private ServiceService instance;
    
    public ServiceServiceTest() {
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
        instance = (ServiceService) container.getContext().lookup("java:global/classes/UserService");

        servOne = new Service();
        servOne.setSrvName("Serv One teste " + new Random().nextInt());
        servOne.setSrvCost(new BigDecimal(new Random().nextFloat()));
        
        servTwo = new Service();
        servTwo.setSrvName("Serv Two teste " + new Random().nextInt());
        servTwo.setSrvCost(new BigDecimal(new Random().nextFloat()));
        
        servThree = new Service();
        servThree.setSrvName("Serv Three teste " + new Random().nextInt());
        servThree.setSrvCost(new BigDecimal(new Random().nextFloat()));

        servOne = instance.addService(servOne);
        servTwo = instance.addService(servTwo);
        servThree = instance.addService(servThree);
    }
    
    @After
    public void tearDown() {
        
        instance.removeService(servOne);
        instance.removeService(servThree);
        instance.removeService(servTwo);

        instance = null;

        servOne = null;
        servTwo = null;
        servThree = null;

        container.close();
        container = null;
        
    }

    /**
     * Test of addService method, of class ServiceService.
     */
    @Test
    public void testAddService() throws Exception {
        System.out.println("addService");
        
        Service service = null;
        Service expResult = null;
        Service result = instance.addService(service);
        assertEquals(expResult, result);
    }

    /**
     * Test of setService method, of class ServiceService.
     */
    @Test
    public void testSetService() throws Exception {
        System.out.println("setService");
        
        Service service = null;
        Service expResult = null;
        Service result = instance.setService(service);
        assertEquals(expResult, result);
    }

    /**
     * Test of removeService method, of class ServiceService.
     */
    @Test
    public void testRemoveService() throws Exception {
        System.out.println("removeService");
        
        Service service = null;
        instance.removeService(service);
    }

    /**
     * Test of getService method, of class ServiceService.
     */
    @Test
    public void testGetService() throws Exception {
        System.out.println("getService");
        
        int idOfService = 0;
        Service expResult = null;
        Service result = instance.getService(idOfService);
        assertEquals(expResult, result);
    }

    /**
     * Test of getServices method, of class ServiceService.
     */
    @Test
    public void testGetServices() throws Exception {
        System.out.println("getServices");
        
        List<Service> expResult = null;
        List<Service> result = instance.getServices();
        assertEquals(expResult, result);
    }

    /**
     * Test of getServicesByName method, of class ServiceService.
     */
    @Test
    public void testGetServicesByName() throws Exception {
        System.out.println("getServicesByName");
        
        String name = "";
        List<Service> expResult = null;
        List<Service> result = instance.getServicesByName(name);
        assertEquals(expResult, result);
    }
    
}
