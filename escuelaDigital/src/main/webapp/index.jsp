<%-- 
    Document   : index
    Created on : 18 dic. 2021, 15:23:11
    Author     : Lucero
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <link href="Vistas/estilo.css" rel="stylesheet">
    </head>
    <body>
        
        <div class="text-center"> <h1>Login</h1> </div>
        <div class="container">
            <div class="row d-flex justify-content-center">
                <form class="p-5 w-50" action="AlumnosController?accion=ingresar" method="POST">
                    <div class="mb-3">
                        <label for="email" class="form-label">Email</label>
                        <input type="text" class="form-control" id="email" name="email"/>
                    </div>
                    <div class="mb-3">
                        <label for="password" class="form-label">Contraseña</label>
                        <input type="text" class="form-control" id="password" name="password"/>
                    </div>
                    <button type="submit" class="btn btn-danger">Iniciar</button>
                    
                </form>
                
            </div>
        </div>   
        
        
        
        
    </body>
</html>