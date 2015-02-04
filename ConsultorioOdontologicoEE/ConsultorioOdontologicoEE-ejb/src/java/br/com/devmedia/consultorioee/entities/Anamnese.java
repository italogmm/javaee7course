/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.devmedia.consultorioee.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author italo.miranda
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Anamnese.findAll", query = "SELECT a FROM Anamnese a")})
public class Anamnese implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "ans_id", nullable = false)
    private Integer ansId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ans_fuma", nullable = false)
    private boolean ansFuma;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ans_pratica_exercicio", nullable = false)
    private boolean ansPraticaExercicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ans_doenca", nullable = false)
    private boolean ansDoenca;
    @Size(max = 255)
    @Column(name = "ans_descricaoDoenca", length = 255)
    private String ansdescricaoDoenca;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ans_operacaoRecente", nullable = false)
    private boolean ansoperacaoRecente;
    @Size(max = 255)
    @Column(name = "ans_descricaoOperacaoRecente", length = 255)
    private String ansdescricaoOperacaoRecente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ans_medicacaoContinua", nullable = false)
    private boolean ansmedicacaoContinua;
    @Size(max = 255)
    @Column(name = "ans_descricaoMedicacaoContinua", length = 255)
    private String ansdescricaoMedicacaoContinua;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ans_alergia", nullable = false)
    private boolean ansAlergia;
    @Size(max = 255)
    @Column(name = "ans_descricaoAlergia", length = 255)
    private String ansdescricaoAlergia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ans_dst", nullable = false)
    private boolean ansDst;
    @Size(max = 255)
    @Column(name = "ans_descricaoDst", length = 255)
    private String ansdescricaoDst;
    @Lob
    @Size(max = 65535)
    @Column(name = "ans_obs", length = 65535)
    private String ansObs;
    @JoinColumn(name = "ans_orcamento", referencedColumnName = "orc_id", nullable = false)
    @ManyToOne(optional = false)
    private Orcamento ansOrcamento;
    @JoinColumn(name = "ans_costumer", referencedColumnName = "cus_id", nullable = false)
    @ManyToOne(optional = false)
    private Customer ansCostumer;

    public Anamnese() {
    }

    public Anamnese(Integer ansId) {
        this.ansId = ansId;
    }

    public Anamnese(Integer ansId, boolean ansFuma, boolean ansPraticaExercicio, boolean ansDoenca, boolean ansoperacaoRecente, boolean ansmedicacaoContinua, boolean ansAlergia, boolean ansDst) {
        this.ansId = ansId;
        this.ansFuma = ansFuma;
        this.ansPraticaExercicio = ansPraticaExercicio;
        this.ansDoenca = ansDoenca;
        this.ansoperacaoRecente = ansoperacaoRecente;
        this.ansmedicacaoContinua = ansmedicacaoContinua;
        this.ansAlergia = ansAlergia;
        this.ansDst = ansDst;
    }

    public Integer getAnsId() {
        return ansId;
    }

    public void setAnsId(Integer ansId) {
        this.ansId = ansId;
    }

    public boolean getAnsFuma() {
        return ansFuma;
    }

    public void setAnsFuma(boolean ansFuma) {
        this.ansFuma = ansFuma;
    }

    public boolean getAnsPraticaExercicio() {
        return ansPraticaExercicio;
    }

    public void setAnsPraticaExercicio(boolean ansPraticaExercicio) {
        this.ansPraticaExercicio = ansPraticaExercicio;
    }

    public boolean getAnsDoenca() {
        return ansDoenca;
    }

    public void setAnsDoenca(boolean ansDoenca) {
        this.ansDoenca = ansDoenca;
    }

    public String getAnsdescricaoDoenca() {
        return ansdescricaoDoenca;
    }

    public void setAnsdescricaoDoenca(String ansdescricaoDoenca) {
        this.ansdescricaoDoenca = ansdescricaoDoenca;
    }

    public boolean getAnsoperacaoRecente() {
        return ansoperacaoRecente;
    }

    public void setAnsoperacaoRecente(boolean ansoperacaoRecente) {
        this.ansoperacaoRecente = ansoperacaoRecente;
    }

    public String getAnsdescricaoOperacaoRecente() {
        return ansdescricaoOperacaoRecente;
    }

    public void setAnsdescricaoOperacaoRecente(String ansdescricaoOperacaoRecente) {
        this.ansdescricaoOperacaoRecente = ansdescricaoOperacaoRecente;
    }

    public boolean getAnsmedicacaoContinua() {
        return ansmedicacaoContinua;
    }

    public void setAnsmedicacaoContinua(boolean ansmedicacaoContinua) {
        this.ansmedicacaoContinua = ansmedicacaoContinua;
    }

    public String getAnsdescricaoMedicacaoContinua() {
        return ansdescricaoMedicacaoContinua;
    }

    public void setAnsdescricaoMedicacaoContinua(String ansdescricaoMedicacaoContinua) {
        this.ansdescricaoMedicacaoContinua = ansdescricaoMedicacaoContinua;
    }

    public boolean getAnsAlergia() {
        return ansAlergia;
    }

    public void setAnsAlergia(boolean ansAlergia) {
        this.ansAlergia = ansAlergia;
    }

    public String getAnsdescricaoAlergia() {
        return ansdescricaoAlergia;
    }

    public void setAnsdescricaoAlergia(String ansdescricaoAlergia) {
        this.ansdescricaoAlergia = ansdescricaoAlergia;
    }

    public boolean getAnsDst() {
        return ansDst;
    }

    public void setAnsDst(boolean ansDst) {
        this.ansDst = ansDst;
    }

    public String getAnsdescricaoDst() {
        return ansdescricaoDst;
    }

    public void setAnsdescricaoDst(String ansdescricaoDst) {
        this.ansdescricaoDst = ansdescricaoDst;
    }

    public String getAnsObs() {
        return ansObs;
    }

    public void setAnsObs(String ansObs) {
        this.ansObs = ansObs;
    }

    public Orcamento getAnsOrcamento() {
        return ansOrcamento;
    }

    public void setAnsOrcamento(Orcamento ansOrcamento) {
        this.ansOrcamento = ansOrcamento;
    }

    public Customer getAnsCostumer() {
        return ansCostumer;
    }

    public void setAnsCostumer(Customer ansCostumer) {
        this.ansCostumer = ansCostumer;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ansId != null ? ansId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Anamnese)) {
            return false;
        }
        Anamnese other = (Anamnese) object;
        if ((this.ansId == null && other.ansId != null) || (this.ansId != null && !this.ansId.equals(other.ansId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.devmedia.consultorioee.entities.Anamnese[ ansId=" + ansId + " ]";
    }
    
}
