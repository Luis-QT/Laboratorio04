<%@page import="java.util.List"%>


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
                  <div style="display: flow-root; padding-bottom: 10px;">
                    <h4 class="float-left">Lista de Ventas</h4>
                    <a href="PedirOrdenador" type="button" class="btn btn-primary float-right">
                      Vender
                    </a>
                  </div>
                  <div>
                    <table class="table">
                      <thead>
                        <tr>
                            <th>#</th>                      
                            <th>Cliente</th>                      
                            <th>CPU</th>                      
                            <th>D.Entrada</th>                      
                            <th>D.Salida</th>                      
                            <th>Precio</th>      
                        </tr>
                      </thead>
                      <tbody>
                        <tr>
                            <td>1</td>
                            <td>Luis Antonio Quispe Taquire</td>
                            <td>Core i7 Intel</td>
                            <td>
                              Mouse Micronics MS45, Teclado Lenovo V354
                            </td>
                            <td>
                              Impresora Lase RICOH CM20, Pantalla Samsung VMD4
                            </td>
                            <td>S/1500</td>
                        </tr>
                        <tr>
                            <td>2</td>
                            <td>Luis Antonio Quispe Taquire</td>
                            <td>Core i7 Intel</td>
                            <td>
                              Mouse Micronics MS45, Teclado Lenovo V354
                            </td>
                            <td>
                              Impresora Lase RICOH CM20, Pantalla Samsung VMD4
                            </td>
                            <td>S/1500</td>
                        </tr>
                        <tr>
                            <td>3</td>
                            <td>Luis Antonio Quispe Taquire</td>
                            <td>Core i7 Intel</td>
                            <td>
                              Mouse Micronics MS45, Teclado Lenovo V354
                            </td>
                            <td>
                              Impresora Lase RICOH CM20, Pantalla Samsung VMD4
                            </td>
                            <td>S/1500</td>
                        </tr>
                      </tbody>
                    </table>
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





