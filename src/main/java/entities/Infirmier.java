/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author l_a-b
 */
@Entity
@Table(name = "infirmier")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Infirmier.findAll", query = "SELECT i FROM Infirmier i")
    , @NamedQuery(name = "Infirmier.findByIdinfirimier", query = "SELECT i FROM Infirmier i WHERE i.idinfirimier = :idinfirimier")
    , @NamedQuery(name = "Infirmier.findByNom", query = "SELECT i FROM Infirmier i WHERE i.nom = :nom")
    , @NamedQuery(name = "Infirmier.findByPrenom", query = "SELECT i FROM Infirmier i WHERE i.prenom = :prenom")
    , @NamedQuery(name = "Infirmier.findByEmail", query = "SELECT i FROM Infirmier i WHERE i.email = :email")
    , @NamedQuery(name = "Infirmier.findByPassword", query = "SELECT i FROM Infirmier i WHERE i.password = :password")
    , @NamedQuery(name = "Infirmier.findByCode", query = "SELECT i FROM Infirmier i WHERE i.code = :code")})
public class Infirmier implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idinfirimier")
    private Integer idinfirimier;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nom")
    private String nom;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "prenom")
    private String prenom;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 255)
    @Column(name = "email")
    private String email;
    @Size(max = 255)
    @Column(name = "password")
    private String password;
    @Size(max = 255)
    @Column(name = "code")
    private String code;

    public Infirmier() {
    }

    public Infirmier(Integer idinfirimier) {
        this.idinfirimier = idinfirimier;
    }

    public Infirmier(Integer idinfirimier, String nom, String prenom) {
        this.idinfirimier = idinfirimier;
        this.nom = nom;
        this.prenom = prenom;
    }

    public Integer getIdinfirimier() {
        return idinfirimier;
    }

    public void setIdinfirimier(Integer idinfirimier) {
        this.idinfirimier = idinfirimier;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idinfirimier != null ? idinfirimier.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Infirmier)) {
            return false;
        }
        Infirmier other = (Infirmier) object;
        if ((this.idinfirimier == null && other.idinfirimier != null) || (this.idinfirimier != null && !this.idinfirimier.equals(other.idinfirimier))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Infirmier[ idinfirimier=" + idinfirimier + " ]";
    }
    
}
