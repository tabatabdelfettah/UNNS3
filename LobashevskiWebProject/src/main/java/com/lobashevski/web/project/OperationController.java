/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lobashevski.web.project;

import com.mycompany.senior.bll.SeniorBLGateway;
import com.mycompany.senior.commun.bean.CityBean;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
public class OperationController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String operation = request.getParameter("operation");
        String toPage = request.getParameter("page");

        if (operation==null || toPage==null || operation.equals("") || toPage.equals("")) {
            response.sendRedirect("index.jsp");
            
        }else{
        
            if(operation.equals("createProduct")){
                String NameAr = request.getParameter("NameAr");  
                String NameEn = request.getParameter("NameEn");
                SeniorBLGateway bll = new SeniorBLGateway();
                CityBean cb = new CityBean();
                cb.setNameAr(NameAr);
                cb.setNameEn(NameEn);
                bll.addCity(cb);
                request.getRequestDispatcher("AppController?page=ShowData").forward(request, response);
            }
          
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
