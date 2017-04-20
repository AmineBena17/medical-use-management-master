/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package search;

import entities.*;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author l_a-b
 */
@Named(value = "searchBean")
@RequestScoped
public class SearchBean {

    @Inject
    SearchService service;
    
    private List<Medecin> list_medecin= new ArrayList<>();
    private List<Structurehopital> list_structure= new ArrayList<>();
    private List<Dossiermedical> list_dossier=new ArrayList<>();
    private List<Infirmier> list_sec= new ArrayList<>();
    
    private Medecin medecin= new Medecin();
    private Structurehopital structurehopital= new Structurehopital();
    private Dossiermedical dossiermedical= new Dossiermedical();
    private Infirmier infirmier= new Infirmier();

    public List<Infirmier> getList_sec() {
        return list_sec;
    }

    public void setList_sec(List<Infirmier> list_sec) {
        this.list_sec = list_sec;
    }

    public Infirmier getInfirmier() {
        return infirmier;
    }

    public void setInfirmier(Infirmier infirmier) {
        this.infirmier = infirmier;
    }
    
    
    
    public List<Medecin> getList_medecin() {
        return list_medecin;
    }

    public void setList_medecin(List<Medecin> list_medecin) {
        this.list_medecin = list_medecin;
    }

    public List<Structurehopital> getList_structure() {
        return list_structure;
    }

    public void setList_structure(List<Structurehopital> list_structure) {
        this.list_structure = list_structure;
    }

    public List<Dossiermedical> getList_dossier() {
        return list_dossier;
    }

    public void setList_dossier(List<Dossiermedical> list_dossier) {
        this.list_dossier = list_dossier;
    }

    public Medecin getMedecin() {
        return medecin;
    }

    public void setMedecin(Medecin medecin) {
        this.medecin = medecin;
    }

    public Structurehopital getStructurehopital() {
        return structurehopital;
    }

    public void setStructurehopital(Structurehopital structurehopital) {
        this.structurehopital = structurehopital;
    }

    public Dossiermedical getDossiermedical() {
        return dossiermedical;
    }

    public void setDossiermedical(Dossiermedical dossiermedical) {
        this.dossiermedical = dossiermedical;
    }
    
    
    
    
    /*beans a créer*/
    
    
    
    public String chercherDossier(){
        this.list_dossier=service.searchDossier(dossiermedical.getNompatient());
        return "ResultatDossierAdmin";
    }
    
     public String chercherDossierMedecin(){
        this.list_dossier=service.searchDossier(dossiermedical.getNompatient());
        return "ResultatDossierMedecin";
    }
    public String chercherDossierInfirmiere(){
        this.list_dossier=service.searchDossier(dossiermedical.getNompatient());
        return "ResultatInfirimere";
    }
     
     
     
    public String chercherMedecin(){
        this.list_medecin=service.searchMedecin(medecin.getNom());
        return "ResultatMedecinAdmin";
    }
    
    public String chercherMedecinMedecin(){
        this.list_medecin=service.searchMedecin(medecin.getNom());
        return "ResultatMedecinMedecin";
    }
    
        public String chercherMedecinSec(){
        this.list_medecin=service.searchMedecin(medecin.getNom());
        return "ResultatMedecinSec";
    }
    
    
    public String chercherStructure(){
        this.list_structure=service.searchStructure(structurehopital.getDepartement());
        return "ResultatStructureAdmin";
    }
    
        public String chercherStructureMedecin(){
        this.list_structure=service.searchStructure(structurehopital.getDepartement());
        return "ResultatStructureMedecin";
    }
    
        
        
    public String chercherSecretaire(){
        this.list_sec=service.searchInfirmier(infirmier.getNom());
        return "ResultatSec";
    }
    /**
     * Creates a new instance of SearchBean
     */
    public SearchBean() {
    }
    
}
