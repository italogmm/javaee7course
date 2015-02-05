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

import br.com.devmedia.consultorioee.entities.Service;
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

        List<Service> services = getPureList(Service.class,
                "select serv from Service serv where serv.srvName like ?1", name + "%");

        return services;
    }
}
