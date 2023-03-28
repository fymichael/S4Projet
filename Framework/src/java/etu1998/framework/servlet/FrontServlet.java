/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etu1998.framework.servlet;

import etu1998.AllAnnotations.Method;
import etu1998.framework.Annotation;
import etu1998.framework.Mapping;   
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author P15B-79-FY
 */
public class FrontServlet extends HttpServlet {
    
    HashMap<String,Mapping> MappingUrls;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet FrontServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet FrontServlet at " + request.getRequestURI() + "</h1>");
            out.println("<h1>Servlet FrontServlet at " + request.getQueryString() + "</h1>");
            for ( HashMap.Entry<String, Mapping> en : this.MappingUrls.entrySet()) {
                out.println("<p> Le nom de la classe : "+en.getValue().getClassName()+"</p>");
                out.println("<p> La methode : "+en.getValue().getMethod()+"</p>"); 
           }
            out.println("</body>");
            out.println("</html>");
        }
    }
    @Override
    public void init(){
        try{
            //System.out.println("etu1998.framework.servlet.FrontServlet.init()");
            Annotation a = new Annotation();
            
            Vector<Class> vec = a.getClassFrom("etu1998.models");
            for(int i = 0; i < vec.size(); i++) { 
                if(vec.get(i) != null) {
                    insertHashMap(vec.get(i),"emp-add");
                }
            }
        }
        catch(Exception e){
            try {
                throw e;
            } catch (Exception ex) {
                Logger.getLogger(FrontServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
       }
//       
        public void insertHashMap(Class<?> className,String query) {
        for(int i = 0; i < className.getDeclaredMethods().length; i++) {
            //System.out.println(className.getDeclaredMethods()[i].getName());
            if(className.getDeclaredMethods()[i].getAnnotation(Method.class).name_method().compareToIgnoreCase(query) == 0){
              System.out.println(className.getDeclaredMethods()[i].getAnnotation(Method.class).name_method());
              String url = className.getDeclaredMethods()[i].getAnnotation(Method.class).name_method();
              this.MappingUrls = new HashMap();
              this.MappingUrls.put(url, new Mapping(className.getSimpleName(),className.getDeclaredMethods()[i].getName()));
            }
        }
    }
//       
       public void afficherHashMap(){
           for ( HashMap.Entry<String, Mapping> en : this.MappingUrls.entrySet()) {
            System.out.println(" Le nom de la classe : "+en.getValue().getClassName());
            System.out.println(" La methode : "+en.getValue().getMethod()); 
           }
       }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
