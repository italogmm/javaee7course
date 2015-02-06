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

import br.com.devmedia.consultorioee.entities.Orcamento;
import br.com.devmedia.consultorioee.entities.Orcamentoitem;
import br.com.devmedia.consultorioee.repositories.OrcamentoRepository;
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
public class OrcamentoService extends BasicService {

    private static final long serialVersionUID = 1L;

    @PersistenceContext
    private EntityManager em;
    private OrcamentoRepository orcamentoRepository;

    @PostConstruct
    @PostActivate
    private void postConstruct() {
        orcamentoRepository = new OrcamentoRepository(em);
    }
    
     public Orcamento addOrcamento(Orcamento orc){
        return orcamentoRepository.addOrcamento(orc);
    }
    
    public Orcamento setOrcamento(Orcamento orc){
        return orcamentoRepository.setOrcamento(orc);
    }
    
    public void removeOrcamento(Orcamento orc){
        orcamentoRepository.removeOrcamento(orc);
    }
    
    public List<Orcamento> getOrcamentos(Integer idOfCostumer){
        return orcamentoRepository.getOrcamentos(idOfCostumer);
    }
    
    public List<Orcamentoitem> getItens(Integer idOfOrcamento){
        return orcamentoRepository.getItens(idOfOrcamento);
    }
    
    public void removeItem(Orcamentoitem orcItem){
        orcamentoRepository.removeItem(orcItem);
    }
    
    public void addItem(Orcamentoitem orcItem){
        orcamentoRepository.addItem(orcItem);
    }
    
    public Orcamentoitem setItem(Orcamentoitem orcItem){
        return orcamentoRepository.setItem(orcItem);
    }
    
    public Orcamentoitem getItem(Integer orcamentoItemId){
        return orcamentoRepository.getItem(orcamentoItemId);
    }
}