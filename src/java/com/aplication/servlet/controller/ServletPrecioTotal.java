/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aplication.servlet.controller;

import com.aplication.servlet.entidades.Cliente;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;

/**
 *
 * @author LuisQT
 */
@WebServlet(name = "ServletPrecioTotal", urlPatterns = {"/PrecioTotal"})
public class ServletPrecioTotal extends HttpServlet {

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
        
        String lista_id_entradas = "";
        String id_cpu = "";
        String lista_id_salidas = "";
        
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String telefono = request.getParameter("telefono");
        String email = request.getParameter("email");
        
        Cliente cliente = new Cliente(nombre, apellido, telefono, email);
        
        String cpu = request.getParameter("cpu");
        String[] entradas = request.getParameterValues("entrada");
        String[] salidas = request.getParameterValues("salida");

        //Calculo del precio y cantidad del cpu
        String[] parts = cpu.split("-");
        id_cpu = parts[0];
        double precioCpu = Double.parseDouble(parts[1]);
        
        //Calculo del precio y cantidad de disp. entradas
        double precioEntradas=0;
        int cantEntradas=0;
        for(String entrada : entradas){
            String[] partes = entrada.split("-");
            if(lista_id_entradas==""){
                lista_id_entradas = partes[0];
            }else{
                lista_id_entradas = lista_id_entradas+"-"+partes[0];
            }
            int cantidad = Integer.parseInt(partes[1]);
            double precio = Double.parseDouble(partes[2]);
            if(cantidad!=0){
                cantEntradas=cantEntradas+cantidad;
            }
            precioEntradas+=cantidad*precio;
        }
        
        //Calculo del precio y cantidad de disp. salidas
        double precioSalidas=0;
        int cantSalidas=0;
        for(String salida : salidas){
            String[] partes = salida.split("-");
            if(lista_id_salidas==""){
                lista_id_salidas = partes[0];
            }else{
                lista_id_salidas = lista_id_salidas+"-"+partes[0];
            }
            int cantidad = Integer.parseInt(partes[1]);
            double precio = Double.parseDouble(partes[2]);
            if(cantidad!=0){
                cantSalidas=cantSalidas+cantidad;
            }
            precioSalidas+=cantidad*precio;
        }
        
        double precioTotal = precioCpu+precioEntradas+precioSalidas;
        
        
        request.setAttribute("cliente",cliente);
        request.setAttribute("precioEntradas",precioEntradas);
        request.setAttribute("cantEntradas",cantEntradas);
        request.setAttribute("precioSalidas",precioSalidas);
        request.setAttribute("cantSalidas",cantSalidas);
        request.setAttribute("precioCpu",precioCpu);
        request.setAttribute("precioTotal",precioTotal);
        request.setAttribute("id_cpu",id_cpu);
        request.setAttribute("lista_id_entradas",lista_id_entradas);
        request.setAttribute("lista_id_salidas",lista_id_salidas);
        
        request.getRequestDispatcher("jsp/PrecioTotal.jsp").forward(request, response);

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
