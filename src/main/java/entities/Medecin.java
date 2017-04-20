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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "medecin")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Medecin.findAll", query = "SELECT m FROM Medecin m")
    , @NamedQuery(name = "Medecin.findByIdmedecin", query = "SELECT m FROM Medecin m WHERE m.idmedecin = :idmedecin")
    , @NamedQuery(name = "Medecin.findByNom", query = "SELECT m FROM Medecin m WHERE m.nom = :nom")
    , @NamedQuery(name = "Medecin.findByPrenom", query = "SELECT m FROM Medecin m WHERE m.prenom = :prenom")
    , @NamedQuery(name = "Medecin.findByEmail", query = "SELECT m FROM Medecin m WHERE m.email = :email")
    , @NamedQuery(name = "Medecin.findByTel", query = "SELECT m FROM Medecin m WHERE m.tel = :tel")
    , @NamedQuery(name = "Medecin.findByAdresse", query = "SELECT m FROM Medecin m WHERE m.adresse = :adresse")
    , @NamedQuery(name = "Medecin.findByDatenaissance", query = "SELECT m FROM Medecin m WHERE m.datenaissance = :datenaissance")
    , @NamedQuery(name = "Medecin.findByLocal", query = "SELECT m FROM Medecin m WHERE m.local = :local")
    , @NamedQuery(name = "Medecin.findByCodemedecin", query = "SELECT m FROM Medecin m WHERE m.codemedecin = :codemedecin")
    , @NamedQuery(name = "Medecin.findBySpecialite", query = "SELECT m FROM Medecin m WHERE m.specialite = :specialite")
    , @NamedQuery(name = "Medecin.findByPassword", query = "SELECT m FROM Medecin m WHERE m.password = :password")})
public class Medecin implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idmedecin")
    private Integer idmedecin;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "nom")
    private String nom;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "prenom")
    private String prenom;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "tel")
    private String tel;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "adresse")
    private String adresse;
    @Basic(optional = false)
    @NotNull
    @Column(name = "datenaissance")
    @Temporal(TemporalType.DATE)
    private Date datenaissance;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "local")
    private String local;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "codemedecin")
    private String codemedecin;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "specialite")
    private String specialite;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "password")
    private String password;
    @JoinColumn(name = "service", referencedColumnName = "service")
    @ManyToOne(optional = false)
    private Structurehopital service;

    public Medecin() {
    }

    public Medecin(Integer idmedecin) {
        this.idmedecin = idmedecin;
    }

    public Medecin(Integer idmedecin, String nom, String prenom, String email, String tel, String adresse, Date datenaissance, String local, String codemedecin, String specialite, String password) {
        this.idmedecin = idmedecin;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.tel = tel;
        this.adresse = adresse;
        this.datenaissance = datenaissance;
        this.local = local;
        this.codemedecin = codemedecin;
        this.specialite = specialite;
        this.password = password;
    }

    public Integer getIdmedecin() {
        return idmedecin;
    }

    public void setIdmedecin(Integer idmedecin) {
        this.idmedecin = idmedecin;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
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

    public Date getDatenaissance() {
        return datenaissance;
    }

    public void setDatenaissance(Date datenaissance) {
        this.datenaissance = datenaissance;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getCodemedecin() {
        return codemedecin;
    }

    public void setCodemedecin(String codemedecin) {
        this.codemedecin = codemedecin;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Structurehopital getService() {
        return service;
    }

    public void setService(Structurehopital service) {
        this.service = service;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmedecin != null ? idmedecin.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Medecin)) {
            return false;
        }
        Medecin other = (Medecin) object;
        if ((this.idmedecin == null && other.idmedecin != null) || (this.idmedecin != null && !this.idmedecin.equals(other.idmedecin))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Medecin[ idmedecin=" + idmedecin + " ]";
    }
    
}
