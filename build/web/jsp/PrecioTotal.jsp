<%@page import="java.util.List"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <<!-- MATERIAL DESIGN ICONIC FONT -->
        <link rel="stylesheet" href="fonts/material-design-iconic-font/css/material-design-iconic-font.css">
        <link rel="stylesheet" href="css/checkbox.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>
    <body>

      <div class="container">
        <div class="row">
          <div class="col">
            <div style="border-bottom: 1px solid #000;text-align: center;"> 
              <h3>CYBERSOUL</h3>
              <h5>(Venta de Ordenadores)</h5>
            </div>
            
            <div style="padding: 10px 0px;">
              <div class="row">
                <div class="col">
                  <h4>Precio total</h4>

                  <div class="row">
                    <div class="col-md-6">
                      <div class="table-responsive">
                        <table class="table table-bordered table-sm">
                          <tbody>
                            <tr>
                              <th scope="row">Nombre</th>
                              <td>${cliente.getNombre()}</td>
                            </tr>
                            <tr>
                              <th scope="row">Apellidos</th>
                              <td>${cliente.getApellido()}</td>
                            </tr>
                            <tr>
                              <th scope="row">Telefono</th>
                              <td>${cliente.getTelefono()}</td>
                            </tr>
                          </tbody>
                        </table>
                      </div>
                    </div>
                  </div>

                  <div class="row">
                    <div class="col">
                      <div class="table-responsive">
                        <table class="table">
                          <thead>
                            <tr>
                                <th>Partes</th>                      
                                <th>Cantidad</th>                      
                                <th>Precio Total</th>      
                            </tr>
                          </thead>
                          <tbody>
                            <tr>
                                <td>CPU</td>
                                <td>1</td>
                                <td>S/150</td>
                            </tr>
                            <tr>
                                <td>D.Entrada</td>
                                <td>2</td>
                                <td>S/300</td>
                            </tr>
                            <tr>
                                <td>D.Salida</td>
                                <td>1</td>
                                <td>S/150</td>
                            </tr>
                            <tr>
                                <td colspan="2" style="text-align: right;">Precio Total</td>
                                <td>S/550</td>
                            </tr>
                          </tbody>
                        </table>
                      </div>
                    </div>
                  </div>
                  <div class="row">
                    <div class="col">
                      <button type="submit" class="btn btn-primary">Vender</button>
                    </div>
                  </div>
                </div>
              </div>
            </div>

          </div>          
        </div>
      </div>



    <script src="js/jquery-3.3.1.min.js"></script>
    
    <!-- JQUERY STEP -->
    <script src="js/jquery.steps.js"></script>

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>





