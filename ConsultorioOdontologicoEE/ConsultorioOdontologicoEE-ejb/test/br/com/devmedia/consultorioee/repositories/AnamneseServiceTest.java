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
package br.com.devmedia.consultorioee.repositories;

import br.com.devmedia.consultorioee.service.AnamneseService;
import br.com.devmedia.consultorioee.entities.Anamnese;
import br.com.devmedia.consultorioee.entities.Customer;
import br.com.devmedia.consultorioee.entities.Orcamento;
import br.com.devmedia.consultorioee.entities.Orcamentoitem;
import br.com.devmedia.consultorioee.entities.Service;
import br.com.devmedia.consultorioee.entities.Users;
import java.util.List;
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
public class AnamneseServiceTest {

    private EJBContainer container;
    private AnamneseService instance;
    private Customer customerOne;
    private Users usrOne;
    private Service servOne;
    private Orcamento orcamentoOne;
    private Orcamentoitem orcamentoItemOfOne;
    private Anamnese anamneseOne;
    private Anamnese anamneseTwo;

    public AnamneseServiceTest() {
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
        instance = (AnamneseService) container.getContext().lookup("java:global/classes/AnamneseService");
        
    }
    

    @After
    public void tearDown() {
        
        instance.removeAnamnese(anamneseOne);
        instance.removeAnamnese(anamneseTwo);
        instance = null;
        container.close();
        container = null;
    }

    /**
     * Test of getAnamnese method, of class AnamneseService.
     */
    @Test
    public void testGetAnamnese() throws Exception {
        System.out.println("getAnamnese");
        Integer idOfAnamnese = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        AnamneseService instance = (AnamneseService) container.getContext().lookup("java:global/classes/AnamneseService");
        Anamnese expResult = null;
        Anamnese result = instance.getAnamnese(idOfAnamnese);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAnamnese method, of class AnamneseService.
     */
    @Test
    public void testSetAnamnese() throws Exception {
        System.out.println("setAnamnese");
        Anamnese anamnese = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        AnamneseService instance = (AnamneseService) container.getContext().lookup("java:global/classes/AnamneseService");
        Anamnese expResult = null;
        Anamnese result = instance.setAnamnese(anamnese);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addAnamnese method, of class AnamneseService.
     */
    @Test
    public void testAddAnamnese() throws Exception {
        System.out.println("addAnamnese");
        Anamnese anamnese = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        AnamneseService instance = (AnamneseService) container.getContext().lookup("java:global/classes/AnamneseService");
        Anamnese expResult = null;
        Anamnese result = instance.addAnamnese(anamnese);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeAnamnese method, of class AnamneseService.
     */
    @Test
    public void testRemoveAnamnese() throws Exception {
        System.out.println("removeAnamnese");
        Anamnese anamnese = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        AnamneseService instance = (AnamneseService) container.getContext().lookup("java:global/classes/AnamneseService");
        instance.removeAnamnese(anamnese);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAnamnesesByCustomer method, of class AnamneseService.
     */
    @Test
    public void testGetAnamnesesByCustomer() throws Exception {
        System.out.println("getAnamnesesByCustomer");
        Customer customer = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        AnamneseService instance = (AnamneseService) container.getContext().lookup("java:global/classes/AnamneseService");
        List<Anamnese> expResult = null;
        List<Anamnese> result = instance.getAnamnesesByCustomer(customer);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAnamnesesByOrcamento method, of class AnamneseService.
     */
    @Test
    public void testGetAnamnesesByOrcamento() throws Exception {
        System.out.println("getAnamnesesByOrcamento");
        Orcamento orcamento = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        AnamneseService instance = (AnamneseService) container.getContext().lookup("java:global/classes/AnamneseService");
        List<Anamnese> expResult = null;
        List<Anamnese> result = instance.getAnamnesesByOrcamento(orcamento);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
