/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.devmedia.consultorioee.repositories;

import br.com.devmedia.consultorioee.entities.Service;
import br.com.devmedia.consultorioee.service.BasicRepository;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author italogustavomirandamelo
 */
public class ServiceRepository extends BasicRepository {

    private static final long serialVersionUID = 1L;

    public ServiceRepository(EntityManager entityManager) {
        super(entityManager);
    }

    public Service getService(int id) {
        return getEntity(Service.class, id);
    }

    public Service setService(Service serv) {
        return setEntity(Service.class, serv);
    }

    public void removeUser(Service serv) {
        removeEntity(serv);
    }

    public Service addService(Service serv) {

        addEntity(Service.class, serv);
        return serv;
    }

    public List<Service> getServices() {
        return getPureList(Service.class, "select serv from Service serv");
    }

    public List<Service> getServiceByName(String name) {

        List<Service> users = getPureList(Service.class,
                "select serv from Service serv where serv.srvName = ?1", name + "%");

        return users;
    }
}