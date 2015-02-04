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

import br.com.devmedia.consultorioee.entities.Orcamento;
import br.com.devmedia.consultorioee.entities.Orcamentoitem;
import br.com.devmedia.consultorioee.service.BasicRepository;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author italo.miranda
 */
public class OrcamentoRepository extends BasicRepository{

    public OrcamentoRepository(EntityManager entityManager) {
        super(entityManager);
    }
    
    public Orcamento getOrcamento(int orcamentoId){
        return getEntity(Orcamento.class, orcamentoId);
    }
    
    public Orcamento addOrcamento(Orcamento orc){
        return addEntity(Orcamento.class, orc);
    }
    
    public Orcamento setOrcamento(Orcamento orc){
        return setEntity(Orcamento.class, orc);
    }
    
    public void removeOrcamento(Orcamento orc){
        removeEntity(orc);
    }
    
    public List<Orcamento> getOrcamentos(int idOfCostumer){
        return getPureList(Orcamento.class, "from orc Orcamento orc where orc.orcCustomer.cusId = ?1", 
                idOfCostumer);
    }
    
    public List<Orcamentoitem> getItens(int idOfOrcamento){
        return getPureList(Orcamentoitem.class, "from orcItem Orcamentoitem orcItem where orcItem.oriOrcamento.oriId = ?1", 
                idOfOrcamento);
    }
    
    public void removeItem(Orcamentoitem orcItem){
        removeEntity(orcItem);
    }
    
    public void addItem(Orcamentoitem orcItem){
        addEntity(Orcamentoitem.class, orcItem);
    }
    
    public Orcamentoitem setItem(Orcamentoitem orcItem){
        return setEntity(Orcamentoitem.class, orcItem);
    }
    
    public Orcamentoitem getItem(int orcamentoItemId){
        return getEntity(Orcamentoitem.class, orcamentoItemId);
    }
}