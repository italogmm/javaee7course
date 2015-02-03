/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.devmedia.consultorioee.repositories;

import br.com.devmedia.consultorioee.entities.Parcela;
import br.com.devmedia.consultorioee.service.BasicRepository;
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

    public List<Parcela> getParcelas(int idOrcamento) {
        return getPureList(Parcela.class,
                "select par from Parcela par where par.parOrcamento.orcId = ?1", idOrcamento);
    }
    
    public List<Parcela> getParcelasEmAberto(int idOrcamento){
        return getPureList(Parcela.class,
                "select par from Parcela par where par.parOrcamento.orcId = ?1 and par.parPago = ?2",
                idOrcamento, Boolean.FALSE);
    }
    
    public List<Parcela> getParcelasPagas(int idOrcamento){
        return getPureList(Parcela.class,
                "select par from Parcela par where par.parOrcamento.orcId = ?1 and par.parPago = ?2",
                idOrcamento, Boolean.TRUE);
    }
}
