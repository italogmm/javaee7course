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

import br.com.devmedia.consultorioee.entities.Costumer;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author italogustavomirandamelo
 */
public class CustomerRepository extends BasicRepository {

    private static final long serialVersionUID = 1L;

    public CustomerRepository(EntityManager entityManager) {
        super(entityManager);
    }

    public Costumer addCostumer(Costumer customer) {
        return addEntity(Costumer.class, customer);
    }

    public Costumer setCostumer(Costumer customer) {
        return setEntity(Costumer.class, customer);
    }

    public void removeCostumer(Costumer customer) {
        removeEntity(customer);
    }

    public Costumer getCostumer(Costumer customer) {
        return getEntity(Costumer.class, customer);
    }

    public Costumer getCostumer(int idCostumer) {
        return getEntity(Costumer.class, idCostumer);
    }

    public List<Costumer> getCustomerByName(String name) {
        return getPureList(Costumer.class, "select cus from Customer cus where cus.cusName like ?1", name + "%");
    }

    public List<Costumer> getCustomersToCall(int month, int year) {

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month - 1);
        cal.set(Calendar.DAY_OF_MONTH, 1);

        Date dataInicial = cal.getTime();

        cal.add(Calendar.MONTH, month);
        cal.add(Calendar.DAY_OF_YEAR, -1);

        Date dataFinal = cal.getTime();

        return getPureList(Costumer.class, "select orc.orcCustomer from Orcamento orc where orc.orcDate >= ?1 "
                + " and orc.orcDate <= 2", dataInicial, dataFinal);
    }

    public List<Costumer> getCustomersComPagamentoEmAberto(int idOfCustomer) {
        return getPureList(Costumer.class, "select par.parOrcamento.orcCustomer from Parcela par where "
                + "par.parOrcamento.orcCustomer.cusId = ?1 and par.parPago = ?2 ",
                idOfCustomer, Boolean.FALSE);
    }

}
