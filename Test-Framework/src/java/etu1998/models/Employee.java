/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etu1998.models;

import etu1998.AllAnnotations.Method;
import etu1998.framework.ModelView;

/**
 *
 * @author P15B-79-FY
 */
public class Employee {
    
    String nom;
    String prenom;

    public Employee() {
    }

    @Method(name_method = "getNom")
    public ModelView getNom() {
        ModelView mv = new ModelView("index.jsp");
        return mv;
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
   
    
//    @Method(name_method = "emp-add")
    public void emp_add(){
        System.out.println("emp-add");
    }
     @Method(name_method = "emp-all")
    public void emp_all(){
        System.out.println("emp-all");
    }
}
