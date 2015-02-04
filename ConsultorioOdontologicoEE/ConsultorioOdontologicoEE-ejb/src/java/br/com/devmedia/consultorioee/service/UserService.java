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

import br.com.devmedia.consultorioee.entities.Users;
import br.com.devmedia.consultorioee.repositories.UserRepository;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.PostActivate;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author italo.miranda
 */
@Stateless
@LocalBean
public class UserService extends BasicService {

    private static final long serialVersionUID = 1L;

    @PersistenceContext
    private EntityManager em;
    private UserRepository userRepository;

    public UserService() {

    }

    public Users getUser(int id) {
        return userRepository.getUser(id);
    }

    public Users setUser(Users user) {
        return userRepository.setUser(user);
    }

    public void removeUser(Users user) {
        userRepository.removeUser(user);
    }

    public void setPassword(int idOfUser, String password) {
        userRepository.setPassword(password, idOfUser);
    }

    public Users addUser(Users user) {
        return userRepository.addUser(user);
    }
    
    public Users getUserByLoginPassword(String login, String password){
        return userRepository.getUserByLoginPassword(login, password);
    }

    public List<Users> getUsers(){
        return userRepository.getUsers();
    }
    
    @PostConstruct
    @PostActivate
    private void postConstruct() {
        userRepository = new UserRepository(em);
    }
}
