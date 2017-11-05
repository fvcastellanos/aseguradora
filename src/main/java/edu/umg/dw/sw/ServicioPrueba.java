package edu.umg.dw.sw;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class ServicioPrueba {

    @WebMethod
    public String holaMundo() {
        return "Hola Mundo";
    }
}
