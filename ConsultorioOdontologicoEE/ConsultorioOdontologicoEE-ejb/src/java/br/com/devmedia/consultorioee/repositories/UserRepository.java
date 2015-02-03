/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.devmedia.consultorioee.repositories;

import br.com.devmedia.consultorioee.entities.Users;
import br.com.devmedia.consultorioee.service.BasicRepository;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author italo.miranda
 */
public class UserRepository extends BasicRepository {

    public UserRepository(EntityManager entityManager) {
        super(entityManager);
    }

    public Users getUser(int id) {
        return getEntity(Users.class, id);
    }

    public Users setUser(Users usr){
        return setEntity(Users.class, usr);
    }
    
    public void removeUser(Users usr){
        removeEntity(usr);
    }
    
    public Users addUser(Users usr){
        
        usr.setUsuPassword(getMD5(usr.getUsuPassword()));
        addEntity(Users.class, usr);
        
        return usr;
    }
    
    public void setPassword(String newPassword, int idOfUser){
        String np = getMD5(newPassword);
        Users usr = getUser(idOfUser);
        usr.setUsuPassword(np);
        setUser(usr);
    }
    
    public Users getUserByLoginPassword(String login, String password) {
        Users user = getPurePojo(Users.class,
                "select usr from Users usr where usr.usuLogin = ?1 and usr.usuPassword = ?2 "
                , login, getMD5(password));

        return user;
    }

    public List<Users> getUsers(){
        return getPureList(Users.class, "select usr from Users user");
    } 
    
    public List<Users> getUsersByName(String name){
        
        List<Users> users = getPureList(Users.class,
                "select usr from Users usr where usr.usuName = ?1", name + "%");

        return users;
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

}
