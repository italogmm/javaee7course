package br.com.devmedia.consultorioee.entities;

import br.com.devmedia.consultorioee.entities.Orcamentoitem;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-02-06T14:47:20")
@StaticMetamodel(Service.class)
public class Service_ { 

    public static volatile SingularAttribute<Service, String> srvName;
    public static volatile SingularAttribute<Service, Integer> srvId;
    public static volatile ListAttribute<Service, Orcamentoitem> orcamentoitemList;
    public static volatile SingularAttribute<Service, BigDecimal> srvCost;

}