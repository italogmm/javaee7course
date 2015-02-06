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
import br.com.devmedia.consultorioee.entities.Customer;
import br.com.devmedia.consultorioee.entities.Orcamento;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.ejb.PostActivate;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author italo.miranda
 */
@Stateless
@LocalBean
public class AnamneseService {

    private static final long serialVersionUID = 1L;
    
    @PersistenceContext
    private EntityManager em;
    private AnamneseRepository anamneseRepository;
    
    @PostConstruct
    @PostActivate
    private void postConstruct() {
        anamneseRepository = new AnamneseRepository(em);
    }
    
    public Anamnese getAnamnese(Integer idOfAnamnese){
        return anamneseRepository.getAnamnese(idOfAnamnese);
    }
    
    public Anamnese setAnamnese(Anamnese anamnese){
        return anamneseRepository.setAnamnese(anamnese);
    }
    
    public Anamnese addAnamnese(Anamnese anamnese){
        return anamneseRepository.addAnamnese(anamnese);
    }
    
    public void removeAnamnese(Anamnese anamnese){
        anamneseRepository.removeAnamnese(anamnese);
    }
    
    public List<Anamnese> getAnamnesesByCustomer(Customer customer){
        return anamneseRepository.getAnamnesesByCustomer(customer);
    }
    
    public List<Anamnese> getAnamnesesByOrcamento(Orcamento orcamento){
        return anamneseRepository.getAnamnesesByOrcamento(orcamento);
    }
}
