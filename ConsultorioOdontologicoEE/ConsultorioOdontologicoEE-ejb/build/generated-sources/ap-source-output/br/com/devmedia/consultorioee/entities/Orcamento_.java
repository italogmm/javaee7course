package br.com.devmedia.consultorioee.entities;

import br.com.devmedia.consultorioee.entities.Anamnese;
import br.com.devmedia.consultorioee.entities.Costumer;
import br.com.devmedia.consultorioee.entities.Orcamentoitem;
import br.com.devmedia.consultorioee.entities.Parcela;
import br.com.devmedia.consultorioee.entities.Users;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-02-03T21:01:58")
@StaticMetamodel(Orcamento.class)
public class Orcamento_ { 

    public static volatile SingularAttribute<Orcamento, Date> orcDate;
    public static volatile ListAttribute<Orcamento, Orcamentoitem> orcamentoitemList;
    public static volatile ListAttribute<Orcamento, Anamnese> anamneseList;
    public static volatile SingularAttribute<Orcamento, Date> orcHour;
    public static volatile SingularAttribute<Orcamento, String> orcpaymentType;
    public static volatile SingularAttribute<Orcamento, BigDecimal> orcTotal;
    public static volatile SingularAttribute<Orcamento, Users> orcDentist;
    public static volatile SingularAttribute<Orcamento, Integer> orcId;
    public static volatile SingularAttribute<Orcamento, Costumer> orcCostumer;
    public static volatile ListAttribute<Orcamento, Parcela> parcelaList;
    public static volatile SingularAttribute<Orcamento, String> orcObs;
    public static volatile SingularAttribute<Orcamento, Integer> orcTimes;

}