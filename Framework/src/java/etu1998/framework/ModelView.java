/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etu1998.framework;

/**
 *
 * @author P15B-79-FY
 */
public class ModelView {
    String viewName;

    public String getViewName() {
        return viewName;
    }

    public void setViewName(String viewName) {
        this.viewName = viewName;
    }

    public ModelView(String viewName) {
        this.viewName = viewName;
    }
    
}
