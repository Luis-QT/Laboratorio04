<%@page import="com.aplication.servlet.dao.ConsultaTrabajadoresConContratoVigenteDAO"%>
<%@page import="java.util.List"%>
<%@page import="com.aplication.servlet.dao.TrabajadorDAO"%>


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
              <div style="display: flow-root; padding-bottom: 10px;">
                <h4 class="float-left">Registro de Venta</h4>
              </div>
              <div>
                <ul class="nav nav-pills nav-fill  mb-3">
                  <li class="nav-item">
                    <a class="nav-link active" id="pills-cliente-tab" data-toggle="pill" href="#pills-cliente" role="tab" aria-controls="pills-cliente" aria-selected="true">Datos de Cliente</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" id="pills-cpu-tab" data-toggle="pill" href="#pills-cpu" role="tab" aria-controls="pills-cpu" aria-selected="false">CPU</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" id="pills-entrada-tab" data-toggle="pill" href="#pills-entrada" role="tab" aria-controls="pills-entrada" aria-selected="false">Disp.Entrada</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" id="pills-salida-tab" data-toggle="pill" href="#pills-salida" role="tab" aria-controls="pills-salida" aria-selected="false">Disp.Salida</a>
                  </li>
                </ul>

                <form method="POST" action="PrecioTotal">
                  <div class="tab-content" id="pills-tabContent">
                    <div class="tab-pane fade show active" id="pills-cliente" role="tabpanel" aria-labelledby="pills-cliente-tab">
                      <div class="row">
                        <div class="col">
                          <div class="form-group">
                            <label>Nombre</label>
                            <input type="text" name="nombre" class="form-control">
                          </div>
                        </div>
                        <div class="col">
                          <div class="form-group">
                            <label>Apellidos</label>
                            <input type="text" name="apellido" class="form-control">
                          </div>
                        </div>
                      </div>
                      <div class="row">
                        <div class="col">
                          <div class="form-group">
                            <label>Telefono</label>
                            <input type="text" name="telefono" class="form-control">
                          </div>
                        </div>
                        <div class="col">
                          <div class="form-group">
                            <label>Email</label>
                            <input type="text" name="email" class="form-control">
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="tab-pane fade" id="pills-cpu" role="tabpanel" aria-labelledby="pills-cpu-tab">
                         <div class="row">
                           <div class="col">
                            <div class="table-responsive">
                              <table class="table">
                                <thead>
                                  <tr>
                                      <th>CPU</th>                      
                                      <th>Precio</th>                      
                                      <th>Seleccionar</th>                      
                                  </tr>
                                </thead>
                                <tbody>
                                  <tr>
                                      <td>Core i7 6400 Intel 3.00Ghz</td>
                                      <td>S/1500</td>
                                      <td><input class="cpu" type="checkbox" value="1" name="cpu"></td>
                                  </tr>
                                  <tr>
                                      <td>Core i7 6400 Intel 3.00Ghz</td>
                                      <td>S/1500</td>
                                      <td><input class="cpu" type="checkbox" value="2"  name="cpu"></td>
                                  </tr>
                                  <tr>
                                      <td>Core i7 6400 Intel 3.00Ghz</td>
                                      <td>S/1500</td>
                                      <td><input class="cpu" type="checkbox" value="3"  name="cpu"></td>
                                  </tr>
                                </tbody>
                              </table>
                            </div>
                            
                          </div>
                        </div>                 
                    </div>
                    <div class="tab-pane fade" id="pills-entrada" role="tabpanel" aria-labelledby="pills-entrada-tab">
                      <div class="row">
                           <div class="col">
                            <div class="table-responsive">
                              <table class="table">
                                <thead>
                                  <tr>
                                      <th>Dispositivo de Entrada</th>                      
                                      <th>Precio</th>                      
                                      <th>Cantidad</th>                      
                                  </tr>
                                </thead>
                                <tbody>
                                  <tr>
                                      <td>Teclado Micronics VC451 Ludico+</td>
                                      <td>S/300</td>
                                      <td>
                                        <select name="salida" class="form-control" style="width: 60px;">
                                          <option>1</option>  
                                          <option>2</option>  
                                          <option>3</option>  
                                          <option>4</option>  
                                          <option>5</option>  
                                          <option>6</option>  
                                        </select>
                                      </td>
                                  </tr>
                                  <tr>
                                      <td>Teclado Micronics VC451 Ludico+</td>
                                      <td>S/300</td>
                                      <td>
                                        <select name="salida" class="form-control" style="width: 60px;">
                                          <option>1</option>  
                                          <option>2</option>  
                                          <option>3</option>  
                                          <option>4</option>  
                                          <option>5</option>  
                                          <option>6</option>  
                                        </select>
                                      </td>
                                  </tr>
                                  <tr>
                                      <td>Teclado Micronics VC451 Ludico+</td>
                                      <td>S/300</td>
                                      <td>
                                        <select name="salida" class="form-control" style="width: 60px;">
                                          <option>1</option>  
                                          <option>2</option>  
                                          <option>3</option>  
                                          <option>4</option>  
                                          <option>5</option>  
                                          <option>6</option>  
                                        </select>
                                      </td>
                                  </tr>
                                </tbody>
                              </table>
                            </div>
                          </div>
                        </div>              
                    </div>
                    <div class="tab-pane fade" id="pills-salida" role="tabpanel" aria-labelledby="pills-salida-tab">
                      <div class="row">
                           <div class="col">
                            <div class="table-responsive">
                              <table class="table">
                                <thead>
                                  <tr>
                                      <th>Dispositivo de Salida</th>                      
                                      <th>Precio</th>                      
                                      <th>Cantidad</th>                      
                                  </tr>
                                </thead>
                                <tbody>
                                  <tr>
                                      <td>Impresora Laser Ricoh Aficio C2500</td>
                                      <td>S/3000</td>
                                      <td>
                                        <select name="salida" class="form-control" style="width: 60px;">
                                          <option>1</option>  
                                          <option>2</option>  
                                          <option>3</option>  
                                          <option>4</option>  
                                          <option>5</option>  
                                          <option>6</option>  
                                        </select>
                                      </td>
                                  </tr>
                                  <tr>
                                      <td>Impresora Laser Ricoh Aficio C2500</td>
                                      <td>S/3000</td>
                                      <td>
                                        <select name="salida" class="form-control" style="width: 60px;">
                                          <option>1</option>  
                                          <option>2</option>  
                                          <option>3</option>  
                                          <option>4</option>  
                                          <option>5</option>  
                                          <option>6</option>  
                                        </select>
                                      </td>
                                  </tr>
                                  <tr>
                                      <td>Impresora Laser Ricoh Aficio C2500</td>
                                      <td>S/3000</td>
                                      <td>
                                        <select name="salida" class="form-control" style="width: 60px;">
                                          <option>1</option>  
                                          <option>2</option>  
                                          <option>3</option>  
                                          <option>4</option>  
                                          <option>5</option>  
                                          <option>6</option>  
                                        </select>
                                      </td>
                                  </tr>
                                </tbody>
                              </table>
                            </div>
                          </div>
                        </div>  
                        <div class="">
                            <button type="submit" id="submit" class="btn btn-primary">Continuar</button>
                        </div>            
                    </div>
                  </div>
                </form>
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

    <script type="text/javascript">
      
      $(document).ready(function() {
          $("#submit").on("click", function() {
              var n =0;
              $(".cpu").each(function(){
                if($(this).is(":checked")){
                  n++;
                }
              });
              if(n>1){
                alert("Solo puede seleccionar un cpu");
                event.preventDefault();
              }
              if(n==0){
                alert("Debe seleccionar un cpu");
                event.preventDefault();
              }
          });
      });

    </script>

    </body>
</html>
