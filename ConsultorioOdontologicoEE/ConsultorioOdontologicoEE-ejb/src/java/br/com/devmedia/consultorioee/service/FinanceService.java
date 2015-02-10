/*
 * Copyright (C) 2015 italogustavomirandamelo
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

import br.com.devmedia.consultorioee.entities.Parcela;
import br.com.devmedia.consultorioee.repositories.FinanceRepository;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.ejb.PostActivate;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author italogustavomirandamelo
 */
@Stateless
@LocalBean
@TransactionAttribute(TransactionAttributeType.REQUIRED)
@TransactionManagement(TransactionManagementType.CONTAINER)
public class FinanceService {

    private static final long serialVersionUID = 1L;

    @PersistenceContext
    private EntityManager em;
    private FinanceRepository financeRepository;

    @PostConstruct
    @PostActivate
    private void postConstruct() {
        financeRepository = new FinanceRepository(em);
    }

    public Parcela getParcela(int idParcela) {
        return financeRepository.getParcela(idParcela);
    }

    public Parcela setParcela(Parcela parcela) {
        return financeRepository.setParcela(parcela);
    }

    public Parcela addParcela(Parcela parcela) {
        return financeRepository.addParcela(parcela);
    }

    public void removeParcela(Parcela parcela) {
        financeRepository.removeParcela(parcela);
    }

    public List<Parcela> getParcelasOfOrcamento(int idOrcamento) {
        return financeRepository.getParcelasOfOrcamento(idOrcamento);
    }

    public List<Parcela> getParcelasOfOrcamentoEmAberto(int idOrcamento) {
        return financeRepository.getParcelasOfOrcamentoEmAberto(idOrcamento);
    }

    public List<Parcela> getParcelasOfOrcamentoPagas(int idOrcamento) {
        return financeRepository.getParcelasOfOrcamentoPagas(idOrcamento);
    }

    public List<Parcela> getParcelasOfCostumer(int idCostumer) {
        return financeRepository.getParcelasOfCostumer(idCostumer);
    }

    public List<Parcela> getParcelasOfCostumerEmAberto(int idCostumer) {
        return financeRepository.getParcelasOfCostumerEmAberto(idCostumer);
    }

    public List<Parcela> getParcelasOfCostumerPagas(int idCostumer) {
        return financeRepository.getParcelasOfCostumerPagas(idCostumer);
    }

    public Parcela setPagamentoParcela(int idOfParcela) {
        return financeRepository.setPagamentoParcela(idOfParcela);
    }
}
