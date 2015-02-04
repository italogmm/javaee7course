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

import br.com.devmedia.consultorioee.entities.Parcela;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author italogustavomirandamelo
 */
public class FinanceRepository extends BasicRepository {

    private static final long serialVersionUID = 1L;

    public FinanceRepository(EntityManager entityManager) {
        super(entityManager);
    }

    public Parcela getParcela(int idParcela) {
        return getEntity(Parcela.class, idParcela);
    }

    public Parcela setParcela(Parcela parcela) {
        return setEntity(Parcela.class, parcela);
    }

    public Parcela addParcela(Parcela parcela) {
        return addEntity(Parcela.class, parcela);
    }

    public void removeParcela(Parcela parcela) {
        removeEntity(parcela);
    }

    public List<Parcela> getParcelasOfOrcamento(int idOrcamento) {
        return getPureList(Parcela.class,
                "select par from Parcela par where par.parOrcamento.orcId = ?1", idOrcamento);
    }
    
    public List<Parcela> getParcelasOfOrcamentoEmAberto(int idOrcamento){
        return getPureList(Parcela.class,
                "select par from Parcela par where par.parOrcamento.orcId = ?1 and par.parPago = ?2",
                idOrcamento, Boolean.FALSE);
    }
    
    public List<Parcela> getParcelasOfOrcamentoPagas(int idOrcamento){
        return getPureList(Parcela.class,
                "select par from Parcela par where par.parOrcamento.orcId = ?1 and par.parPago = ?2",
                idOrcamento, Boolean.TRUE);
    }
    
    public List<Parcela> getParcelasOfCostumer(int idCostumer) {
        return getPureList(Parcela.class,
                "select par from Parcela par where par.parOrcamento.orcCostumer.cusId = ?1", idCostumer);
    }
    
    public List<Parcela> getParcelasOfCostumerEmAberto(int idCostumer) {
        return getPureList(Parcela.class,
                "select par from Parcela par where par.parOrcamento.orcCostumer.cusId = ?1 and par.parPago = ?2", idCostumer);
    }
    
    public List<Parcela> getParcelasOfCostumerPagas(int idCostumer){
        return getPureList(Parcela.class,
                "select par from Parcela par where par.parOrcamento.orcCostumer.cusId = ?1 and par.parPago = ?2",
                idCostumer, Boolean.TRUE);
    }
    
    public Parcela setPagamentoParcela(int idOfParcela){
        
        Parcela parcela = getParcela(idOfParcela);
        parcela.setParPago(true);
        setParcela(parcela);
        
        return parcela;
    }
    
    
}
