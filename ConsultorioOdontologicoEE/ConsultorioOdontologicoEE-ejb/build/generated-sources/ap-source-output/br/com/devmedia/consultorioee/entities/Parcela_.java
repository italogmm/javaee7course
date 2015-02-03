package br.com.devmedia.consultorioee.entities;

import br.com.devmedia.consultorioee.entities.Orcamento;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-02-03T13:28:03")
@StaticMetamodel(Parcela.class)
public class Parcela_ { 

    public static volatile SingularAttribute<Parcela, Integer> parNumero;
    public static volatile SingularAttribute<Parcela, Orcamento> parOrcamento;
    public static volatile SingularAttribute<Parcela, BigDecimal> parValue;
    public static volatile SingularAttribute<Parcela, Boolean> parPago;
    public static volatile SingularAttribute<Parcela, Integer> parId;

}