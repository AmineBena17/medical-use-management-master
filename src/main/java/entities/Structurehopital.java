/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author l_a-b
 */
@Entity
@Table(name = "structurehopital")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Structurehopital.findAll", query = "SELECT s FROM Structurehopital s")
    , @NamedQuery(name = "Structurehopital.findByIdstructurehopital", query = "SELECT s FROM Structurehopital s WHERE s.idstructurehopital = :idstructurehopital")
    , @NamedQuery(name = "Structurehopital.findByDepartement", query = "SELECT s FROM Structurehopital s WHERE s.departement = :departement")
    , @NamedQuery(name = "Structurehopital.findByLocal", query = "SELECT s FROM Structurehopital s WHERE s.local = :local")
    , @NamedQuery(name = "Structurehopital.findByService", query = "SELECT s FROM Structurehopital s WHERE s.service = :service")
    , @NamedQuery(name = "Structurehopital.findByRefDepartement", query = "SELECT s FROM Structurehopital s WHERE s.refDepartement = :refDepartement")})
public class Structurehopital implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idstructurehopital")
    private Integer idstructurehopital;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "departement")
    private String departement;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "local")
    private String local;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "service")
    private String service;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "ref_departement")
    private String refDepartement;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "service")
    private List<Medecin> medecinList;

    public Structurehopital() {
    }

    public Structurehopital(Integer idstructurehopital) {
        this.idstructurehopital = idstructurehopital;
    }

    public Structurehopital(Integer idstructurehopital, String departement, String local, String service, String refDepartement) {
        this.idstructurehopital = idstructurehopital;
        this.departement = departement;
        this.local = local;
        this.service = service;
        this.refDepartement = refDepartement;
    }

    public Integer getIdstructurehopital() {
        return idstructurehopital;
    }

    public void setIdstructurehopital(Integer idstructurehopital) {
        this.idstructurehopital = idstructurehopital;
    }

    public String getDepartement() {
        return departement;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getRefDepartement() {
        return refDepartement;
    }

    public void setRefDepartement(String refDepartement) {
        this.refDepartement = refDepartement;
    }

    @XmlTransient
    public List<Medecin> getMedecinList() {
        return medecinList;
    }

    public void setMedecinList(List<Medecin> medecinList) {
        this.medecinList = medecinList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idstructurehopital != null ? idstructurehopital.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Structurehopital)) {
            return false;
        }
        Structurehopital other = (Structurehopital) object;
        if ((this.idstructurehopital == null && other.idstructurehopital != null) || (this.idstructurehopital != null && !this.idstructurehopital.equals(other.idstructurehopital))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Structurehopital[ idstructurehopital=" + idstructurehopital + " ]";
    }
    
}
