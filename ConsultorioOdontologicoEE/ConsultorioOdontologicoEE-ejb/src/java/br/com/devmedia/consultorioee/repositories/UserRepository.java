/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.devmedia.consultorioee.repositories;

import br.com.devmedia.consultorioee.entities.Users;
import br.com.devmedia.consultorioee.service.BasicRepository;
import javax.persistence.EntityManager;

/**
 *
 * @author italo.miranda
 */
public class UserRepository extends BasicRepository{

    public UserRepository(EntityManager entityManager) {
        super(entityManager);
    }
    
    public Users getUser(int id){
        return getEntityManager().find(Users.class, id);
    }
}
