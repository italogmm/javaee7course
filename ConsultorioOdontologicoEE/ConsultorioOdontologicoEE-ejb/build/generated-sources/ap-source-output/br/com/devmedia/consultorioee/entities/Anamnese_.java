package br.com.devmedia.consultorioee.entities;

import br.com.devmedia.consultorioee.entities.Costumer;
import br.com.devmedia.consultorioee.entities.Orcamento;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-02-05T19:45:27")
@StaticMetamodel(Anamnese.class)
public class Anamnese_ { 

    public static volatile SingularAttribute<Anamnese, Boolean> ansmedicacaoContinua;
    public static volatile SingularAttribute<Anamnese, Boolean> ansAlergia;
    public static volatile SingularAttribute<Anamnese, Boolean> ansDoenca;
    public static volatile SingularAttribute<Anamnese, Integer> ansId;
    public static volatile SingularAttribute<Anamnese, String> ansdescricaoDst;
    public static volatile SingularAttribute<Anamnese, String> ansdescricaoDoenca;
    public static volatile SingularAttribute<Anamnese, Boolean> ansFuma;
    public static volatile SingularAttribute<Anamnese, String> ansdescricaoAlergia;
    public static volatile SingularAttribute<Anamnese, String> ansObs;
    public static volatile SingularAttribute<Anamnese, Costumer> ansCustomer;
    public static volatile SingularAttribute<Anamnese, Boolean> ansPraticaExercicio;
    public static volatile SingularAttribute<Anamnese, Boolean> ansDst;
    public static volatile SingularAttribute<Anamnese, String> ansdescricaoMedicacaoContinua;
    public static volatile SingularAttribute<Anamnese, Boolean> ansoperacaoRecente;
    public static volatile SingularAttribute<Anamnese, String> ansdescricaoOperacaoRecente;
    public static volatile SingularAttribute<Anamnese, Orcamento> ansOrcamento;

}