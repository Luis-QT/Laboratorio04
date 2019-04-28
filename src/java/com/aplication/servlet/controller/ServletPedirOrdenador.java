/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aplication.servlet.controller;

import com.aplication.servlet.entidades.Componente;
import com.aplication.servlet.entidades.DispEntrada;
import com.aplication.servlet.entidades.DispSalida;
import com.aplication.servlet.entidades.Pantalla;
import com.aplication.servlet.entidades.Raton;
import com.aplication.servlet.entidades.Teclado;
import com.aplication.servlet.entidades.UnidadControl;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author LuisQT
 */
@WebServlet(name = "ServletPedirOrdenador", urlPatterns = {"/PedirOrdenador"})
public class ServletPedirOrdenador extends HttpServlet {

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
        
        Teclado teclado = new Teclado(1,"Cable ps2", "asus", "13.56", "DHSFSJB");
        Raton raton = new Raton(2,"Cable usb", "lenovo", "13.56", "VV66s");
        ArrayList<DispEntrada> dispEntradas = new ArrayList();
        dispEntradas.add(teclado);
        dispEntradas.add(raton);
        
        Pantalla pantalla1 = new Pantalla("200px", 1, "VGA", "Samsung", "1400", "ASSS2");
        Pantalla pantalla2 = new Pantalla("300px", 8, "HDMI", "ACER", "2400", "ASSS2");
        Pantalla pantalla3 = new Pantalla("500px", 3, "VGA", "LG", "500", "ASSS2");
        ArrayList<DispSalida> dispSalidas = new ArrayList();
        dispSalidas.add(pantalla1);
        dispSalidas.add(pantalla2);
        dispSalidas.add(pantalla3);
        
        UnidadControl cpu1 = new UnidadControl("Intel", "1500", "Core i7 6400 Intel 3.00Ghz");
        UnidadControl cpu2 = new UnidadControl("Intel", "1000", "Core i5 5400 Intel 3.00Ghz");
        UnidadControl cpu3 = new UnidadControl("Intel", "1200", "Core i3 8400 Intel 3.00Ghz");
        ArrayList<UnidadControl> cpus = new ArrayList();
        cpus.add(cpu1);
        cpus.add(cpu2);
        cpus.add(cpu3);
        
        request.setAttribute("dispEntradas",dispEntradas);
        request.setAttribute("dispSalidas",dispSalidas);
        request.setAttribute("cpus",cpus);
        request.getRequestDispatcher("jsp/PedirOrdenador.jsp").forward(request, response);
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
