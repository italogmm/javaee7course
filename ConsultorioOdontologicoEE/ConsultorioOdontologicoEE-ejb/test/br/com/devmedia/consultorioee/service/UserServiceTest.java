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

import br.com.devmedia.consultorioee.entities.Users;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.LinkedList;
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
public class UserServiceTest {

    private Users usrOne;
    private Users usrTwo;
    private Users usrThree;

    private EJBContainer container;
    private UserService instance;

    public UserServiceTest() {
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
        instance = (UserService) container.getContext().lookup("java:global/classes/UserService");

        usrOne = new Users();
        usrOne.setUsuAdministrator(new Random().nextBoolean());
        usrOne.setUsuDentist(new Random().nextBoolean());
        usrOne.setUsuLogin("testLoginOne " + new Random().nextInt());
        usrOne.setUsuName("testNameOne " + new Random().nextInt());
        usrOne.setUsuPassword((usrOne.getUsuLogin()));

        usrTwo = new Users();
        usrTwo.setUsuAdministrator(new Random().nextBoolean());
        usrTwo.setUsuDentist(new Random().nextBoolean());
        usrTwo.setUsuLogin("testLoginTwo " + new Random().nextInt());
        usrTwo.setUsuName("testNameTwo " + new Random().nextInt());
        usrTwo.setUsuPassword((usrTwo.getUsuLogin()));

        usrThree = new Users();
        usrThree.setUsuAdministrator(new Random().nextBoolean());
        usrThree.setUsuDentist(new Random().nextBoolean());
        usrThree.setUsuLogin("testLoginThree " + new Random().nextInt());
        usrThree.setUsuName("testNameThree " + new Random().nextInt());
        usrThree.setUsuPassword((usrThree.getUsuLogin()));

        usrOne = instance.addUser(usrOne);
        usrTwo = instance.addUser(usrTwo);
        usrThree = instance.addUser(usrThree);
    }

    @After
    public void tearDown() {

        instance.removeUser(usrOne);
        instance.removeUser(usrTwo);
        instance.removeUser(usrThree);

        instance = null;

        usrOne = null;
        usrTwo = null;
        usrThree = null;

        container.close();
        container = null;
    }

    /**
     * Test of getUser method, of class UserService.
     */
    @Test
    public void testGetUser() throws Exception {
        System.out.println("getUser");

        Users expResult = usrTwo;

        Users result = instance.getUser(usrTwo.getUsuId());
        assertEquals(expResult, result);

    }

    /**
     * Test of setUser method, of class UserService.
     */
    @Test
    public void testSetUser() throws Exception {
        System.out.println("setUser");

        Users user = usrThree;
        Users expResult = usrThree;

        user.setUsuName("ChangedUserName " + new Random().nextInt());

        Users result = instance.setUser(user);
        Users resultFromGet = instance.getUser(user.getUsuId());

        assertEquals(resultFromGet.getUsuName(), expResult.getUsuName());
        assertEquals(resultFromGet, result);
        assertEquals(resultFromGet.getUsuName(), result.getUsuName());
    }

    /**
     * Test of removeUser method, of class UserService.
     */
    @Test
    public void testRemoveUser() throws Exception {

        System.out.println("removeUser");

        Users user = new Users();
        user.setUsuAdministrator(new Random().nextBoolean());
        user.setUsuDentist(new Random().nextBoolean());
        user.setUsuLogin("My Test Login User " + new Random().nextInt());
        user.setUsuName("My Test Name User " + new Random().nextInt());
        user.setUsuPassword((user.getUsuLogin()));
        
        user = instance.addUser(user);
        instance.removeUser(user);
        
        Users userRemoved = instance.getUser(user.getUsuId());
        
        instance.removeUser(user);
        assertNull(userRemoved);
    }

    /**
     * Test of setPassword method, of class UserService.
     */
    @Test
    public void testSetPassword() throws Exception {
        
        System.out.println("setPassword");
        
        String tmpPassword = new Random().nextInt() + "MyChangePassword";
        String md5TmpPassword = getMD5(tmpPassword);
        
        instance.setPassword(usrTwo.getUsuId(), md5TmpPassword);
        
        Users user = instance.getUser(usrTwo.getUsuId());
        assertEquals(user.getUsuPassword(), md5TmpPassword);
    }
    
    private String getMD5(final String message) {
        try {
            MessageDigest m = MessageDigest.getInstance("MD5");
            m.reset();
            m.update(message.getBytes());
            BigInteger bigInt = new BigInteger(1, m.digest());
            String hashtext = bigInt.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    /**
     * Test of addUser method, of class UserService.
     */
    @Test
    public void testAddUser() throws Exception {
        System.out.println("addUser");
        
        Users user = new Users();
        user.setUsuAdministrator(new Random().nextBoolean());
        user.setUsuDentist(new Random().nextBoolean());
        user.setUsuLogin("My Test Login User (Add)" + new Random().nextInt());
        user.setUsuName("My Test Name User (Add) " + new Random().nextInt());
        user.setUsuPassword((user.getUsuLogin()));
        
        Users result = instance.addUser(user);
        
        Users resulFromGet = instance.getUser(user.getUsuId());
        
        assertEquals(result, resulFromGet);
        
        instance.removeUser(resulFromGet);
    }

    /**
     * Test of getUserByLoginPassword method, of class UserService.
     */
    @Test
    public void testGetUserByLoginPassword() throws Exception {
        System.out.println("getUserByLoginPassword");
        
        String login = usrOne.getUsuLogin();
        String password = usrOne.getUsuLogin();
        
        Users expResult = usrOne;
        
        Users result = instance.getUserByLoginPassword(login, password);
        assertEquals(expResult, result);
    }

    /**
     * Test of getUsers method, of class UserService.
     */
    @Test
    public void testGetUsers() throws Exception {
        System.out.println("getUsers");
        
        List<Users> expResult = new LinkedList<Users>();
        expResult.add(usrOne);
        expResult.add(usrTwo);
        expResult.add(usrThree);
        
        List<Users> result = instance.getUsers();
        assertTrue(expResult.containsAll(result));
    }
}
