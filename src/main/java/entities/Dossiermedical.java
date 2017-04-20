/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author l_a-b
 */
@Entity
@Table(name = "dossiermedical")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dossiermedical.findAll", query = "SELECT d FROM Dossiermedical d")
    , @NamedQuery(name = "Dossiermedical.findByIddossiermedical", query = "SELECT d FROM Dossiermedical d WHERE d.iddossiermedical = :iddossiermedical")
    , @NamedQuery(name = "Dossiermedical.findByNompatient", query = "SELECT d FROM Dossiermedical d WHERE d.nompatient = :nompatient")
    , @NamedQuery(name = "Dossiermedical.findByDatenaissance", query = "SELECT d FROM Dossiermedical d WHERE d.datenaissance = :datenaissance")
    , @NamedQuery(name = "Dossiermedical.findByEmail", query = "SELECT d FROM Dossiermedical d WHERE d.email = :email")
    , @NamedQuery(name = "Dossiermedical.findByTel", query = "SELECT d FROM Dossiermedical d WHERE d.tel = :tel")
    , @NamedQuery(name = "Dossiermedical.findByAdresse", query = "SELECT d FROM Dossiermedical d WHERE d.adresse = :adresse")
    , @NamedQuery(name = "Dossiermedical.findByGroupesanguin", query = "SELECT d FROM Dossiermedical d WHERE d.groupesanguin = :groupesanguin")
    , @NamedQuery(name = "Dossiermedical.findByRegimeassurance", query = "SELECT d FROM Dossiermedical d WHERE d.regimeassurance = :regimeassurance")
    , @NamedQuery(name = "Dossiermedical.findByDatedossier", query = "SELECT d FROM Dossiermedical d WHERE d.datedossier = :datedossier")
    , @NamedQuery(name = "Dossiermedical.findByDescription", query = "SELECT d FROM Dossiermedical d WHERE d.description = :description")})
public class Dossiermedical implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iddossiermedical")
    private Integer iddossiermedical;
    @Basic(optional = false)
    
    @Column(name = "nompatient")
    private String nompatient;
    
    @Column(name = "datenaissance")
    @Temporal(TemporalType.DATE)
    private Date datenaissance;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    
    @Column(name = "email")
    private String email;
    
    @Basic(optional = false)
    @Column(name = "tel")
    private String tel;
    
    @Column(name = "adresse")
    private String adresse;
    
    @Column(name = "groupesanguin")
    private String groupesanguin;
    
    @Column(name = "regimeassurance")
    private String regimeassurance;
    @Basic(optional = false)
    
    @Column(name = "datedossier")
    private String datedossier;
    @Basic(optional = false)
    
    @Column(name = "description")
    private String description;

    public Dossiermedical() {
    }

    public Dossiermedical(Integer iddossiermedical) {
        this.iddossiermedical = iddossiermedical;
    }

    public Dossiermedical(Integer iddossiermedical, String nompatient, Date datenaissance, String email, String tel, String adresse, String groupesanguin, String regimeassurance, String datedossier, String description) {
        this.iddossiermedical = iddossiermedical;
        this.nompatient = nompatient;
        this.datenaissance = datenaissance;
        this.email = email;
        this.tel = tel;
        this.adresse = adresse;
        this.groupesanguin = groupesanguin;
        this.regimeassurance = regimeassurance;
        this.datedossier = datedossier;
        this.description = description;
    }

    public Integer getIddossiermedical() {
        return iddossiermedical;
    }

    public void setIddossiermedical(Integer iddossiermedical) {
        this.iddossiermedical = iddossiermedical;
    }

    public String getNompatient() {
        return nompatient;
    }

    public void setNompatient(String nompatient) {
        this.nompatient = nompatient;
    }

    public Date getDatenaissance() {
        return datenaissance;
    }

    public void setDatenaissance(Date datenaissance) {
        this.datenaissance = datenaissance;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getGroupesanguin() {
        return groupesanguin;
    }

    public void setGroupesanguin(String groupesanguin) {
        this.groupesanguin = groupesanguin;
    }

    public String getRegimeassurance() {
        return regimeassurance;
    }

    public void setRegimeassurance(String regimeassurance) {
        this.regimeassurance = regimeassurance;
    }

    public String getDatedossier() {
        return datedossier;
    }

    public void setDatedossier(String datedossier) {
        this.datedossier = datedossier;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddossiermedical != null ? iddossiermedical.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dossiermedical)) {
            return false;
        }
        Dossiermedical other = (Dossiermedical) object;
        if ((this.iddossiermedical == null && other.iddossiermedical != null) || (this.iddossiermedical != null && !this.iddossiermedical.equals(other.iddossiermedical))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Dossiermedical[ iddossiermedical=" + iddossiermedical + " ]";
    }
    
}
