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

import br.com.devmedia.consultorioee.entities.Anamnese;
import br.com.devmedia.consultorioee.entities.Costumer;
import br.com.devmedia.consultorioee.entities.Orcamento;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author italo.miranda
 */
public class AnamneseRepository extends BasicRepository{

    private static final long serialVersionUID = 1L;
    
    public AnamneseRepository(EntityManager entityManager) {
        super(entityManager);
    }
    
    public Anamnese getAnamnese(int idOfAnamnese){
        return getEntity(Anamnese.class, idOfAnamnese);
    }
    
    public Anamnese setAnamnese(Anamnese anamnese){
        return setEntity(Anamnese.class, anamnese);
    }
    
    public Anamnese addAnamnese(Anamnese anamnese){
        return addEntity(Anamnese.class, anamnese);
    }
    
    public void removeAnamnese(Anamnese anamnese){
        removeEntity(anamnese);
    }
    
    public List<Anamnese> getAnamnesesByCustomer(Costumer customer){
        return getPureList(Anamnese.class, "select anam from Anamnese anam where anam.ansCustomer.cusId = ?1 ", 
                customer.getCusId());
    }
    
    public List<Anamnese> getAnamnesesByOrcamento(Orcamento orcamento){
        return getPureList(Anamnese.class, "select anam from Anamnese anam where anam.ansOrcamento.orcId = ?1", 
                orcamento.getOrcId());
    }
    
    
    
}
