package br.com.devmedia.consultorioee.entities;

import br.com.devmedia.consultorioee.entities.Anamnese;
import br.com.devmedia.consultorioee.entities.Orcamento;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-02-03T21:01:58")
@StaticMetamodel(Costumer.class)
public class Costumer_ { 

    public static volatile SingularAttribute<Costumer, String> cusMother;
    public static volatile SingularAttribute<Costumer, String> cusState;
    public static volatile SingularAttribute<Costumer, String> cusworkAdress;
    public static volatile SingularAttribute<Costumer, String> cusComplement;
    public static volatile ListAttribute<Costumer, Orcamento> orcamentoList;
    public static volatile SingularAttribute<Costumer, String> cusName;
    public static volatile SingularAttribute<Costumer, Date> cusbornDate;
    public static volatile SingularAttribute<Costumer, String> cusCity;
    public static volatile SingularAttribute<Costumer, String> cusObs;
    public static volatile SingularAttribute<Costumer, Integer> cusAge;
    public static volatile SingularAttribute<Costumer, String> cusOcupation;
    public static volatile SingularAttribute<Costumer, String> cusworkName;
    public static volatile SingularAttribute<Costumer, String> cusFather;
    public static volatile SingularAttribute<Costumer, String> cuscellNumber;
    public static volatile SingularAttribute<Costumer, String> cusworkObs;
    public static volatile ListAttribute<Costumer, Anamnese> anamneseList;
    public static volatile SingularAttribute<Costumer, String> cusTelephone;
    public static volatile SingularAttribute<Costumer, Integer> cusId;
    public static volatile SingularAttribute<Costumer, String> cusworkNumber;

}