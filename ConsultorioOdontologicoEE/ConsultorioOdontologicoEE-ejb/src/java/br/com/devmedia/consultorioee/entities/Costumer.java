/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.devmedia.consultorioee.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author italo.miranda
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Costumer.findAll", query = "SELECT c FROM Costumer c")})
public class Costumer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "cus_id", nullable = false)
    private Integer cusId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "cus_name", nullable = false, length = 255)
    private String cusName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cus_age", nullable = false)
    private int cusAge;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "cus_state", nullable = false, length = 2)
    private String cusState;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "cus_city", nullable = false, length = 255)
    private String cusCity;
    @Lob
    @Size(max = 65535)
    @Column(name = "cus_complement", length = 65535)
    private String cusComplement;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "cus_father", nullable = false, length = 255)
    private String cusFather;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "cus_mother", nullable = false, length = 255)
    private String cusMother;
    @Lob
    @Size(max = 65535)
    @Column(name = "cus_obs", length = 65535)
    private String cusObs;
    @Size(max = 45)
    @Column(name = "cus_ocupation", length = 45)
    private String cusOcupation;
    @Size(max = 15)
    @Column(name = "cus_workNumber", length = 15)
    private String cusworkNumber;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "cus_cellNumber", nullable = false, length = 15)
    private String cuscellNumber;
    @Size(max = 45)
    @Column(name = "cus_workName", length = 45)
    private String cusworkName;
    @Size(max = 255)
    @Column(name = "cus_workAdress", length = 255)
    private String cusworkAdress;
    @Lob
    @Size(max = 65535)
    @Column(name = "cus_workObs", length = 65535)
    private String cusworkObs;
    @Size(max = 255)
    @Column(name = "cus_telephone", length = 255)
    private String cusTelephone;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cus_bornDate", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date cusbornDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ansCostumer")
    private List<Anamnese> anamneseList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orcCostumer")
    private List<Orcamento> orcamentoList;

    public Costumer() {
    }

    public Costumer(Integer cusId) {
        this.cusId = cusId;
    }

    public Costumer(Integer cusId, String cusName, int cusAge, String cusState, String cusCity, String cusFather, String cusMother, String cuscellNumber, Date cusbornDate) {
        this.cusId = cusId;
        this.cusName = cusName;
        this.cusAge = cusAge;
        this.cusState = cusState;
        this.cusCity = cusCity;
        this.cusFather = cusFather;
        this.cusMother = cusMother;
        this.cuscellNumber = cuscellNumber;
        this.cusbornDate = cusbornDate;
    }

    public Integer getCusId() {
        return cusId;
    }

    public void setCusId(Integer cusId) {
        this.cusId = cusId;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public int getCusAge() {
        return cusAge;
    }

    public void setCusAge(int cusAge) {
        this.cusAge = cusAge;
    }

    public String getCusState() {
        return cusState;
    }

    public void setCusState(String cusState) {
        this.cusState = cusState;
    }

    public String getCusCity() {
        return cusCity;
    }

    public void setCusCity(String cusCity) {
        this.cusCity = cusCity;
    }

    public String getCusComplement() {
        return cusComplement;
    }

    public void setCusComplement(String cusComplement) {
        this.cusComplement = cusComplement;
    }

    public String getCusFather() {
        return cusFather;
    }

    public void setCusFather(String cusFather) {
        this.cusFather = cusFather;
    }

    public String getCusMother() {
        return cusMother;
    }

    public void setCusMother(String cusMother) {
        this.cusMother = cusMother;
    }

    public String getCusObs() {
        return cusObs;
    }

    public void setCusObs(String cusObs) {
        this.cusObs = cusObs;
    }

    public String getCusOcupation() {
        return cusOcupation;
    }

    public void setCusOcupation(String cusOcupation) {
        this.cusOcupation = cusOcupation;
    }

    public String getCusworkNumber() {
        return cusworkNumber;
    }

    public void setCusworkNumber(String cusworkNumber) {
        this.cusworkNumber = cusworkNumber;
    }

    public String getCuscellNumber() {
        return cuscellNumber;
    }

    public void setCuscellNumber(String cuscellNumber) {
        this.cuscellNumber = cuscellNumber;
    }

    public String getCusworkName() {
        return cusworkName;
    }

    public void setCusworkName(String cusworkName) {
        this.cusworkName = cusworkName;
    }

    public String getCusworkAdress() {
        return cusworkAdress;
    }

    public void setCusworkAdress(String cusworkAdress) {
        this.cusworkAdress = cusworkAdress;
    }

    public String getCusworkObs() {
        return cusworkObs;
    }

    public void setCusworkObs(String cusworkObs) {
        this.cusworkObs = cusworkObs;
    }

    public String getCusTelephone() {
        return cusTelephone;
    }

    public void setCusTelephone(String cusTelephone) {
        this.cusTelephone = cusTelephone;
    }

    public Date getCusbornDate() {
        return cusbornDate;
    }

    public void setCusbornDate(Date cusbornDate) {
        this.cusbornDate = cusbornDate;
    }

    @XmlTransient
    public List<Anamnese> getAnamneseList() {
        return anamneseList;
    }

    public void setAnamneseList(List<Anamnese> anamneseList) {
        this.anamneseList = anamneseList;
    }

    @XmlTransient
    public List<Orcamento> getOrcamentoList() {
        return orcamentoList;
    }

    public void setOrcamentoList(List<Orcamento> orcamentoList) {
        this.orcamentoList = orcamentoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cusId != null ? cusId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Costumer)) {
            return false;
        }
        Costumer other = (Costumer) object;
        if ((this.cusId == null && other.cusId != null) || (this.cusId != null && !this.cusId.equals(other.cusId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.devmedia.consultorioee.entities.Costumer[ cusId=" + cusId + " ]";
    }
    
}
