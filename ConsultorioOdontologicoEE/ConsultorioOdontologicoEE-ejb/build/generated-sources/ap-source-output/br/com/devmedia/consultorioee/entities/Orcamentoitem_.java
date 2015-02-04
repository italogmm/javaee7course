package br.com.devmedia.consultorioee.entities;

import br.com.devmedia.consultorioee.entities.Orcamento;
import br.com.devmedia.consultorioee.entities.Service;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-02-03T22:43:02")
@StaticMetamodel(Orcamentoitem.class)
public class Orcamentoitem_ { 

    public static volatile SingularAttribute<Orcamentoitem, Integer> oriId;
    public static volatile SingularAttribute<Orcamentoitem, BigDecimal> oriCost;
    public static volatile SingularAttribute<Orcamentoitem, Service> oriService;
    public static volatile SingularAttribute<Orcamentoitem, Orcamento> oriOrcamento;
    public static volatile SingularAttribute<Orcamentoitem, String> oriObs;

}