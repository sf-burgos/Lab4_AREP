package edu.escuelaing.AREP.app.controllers;

import edu.escuelaing.AREP.app.spring.RequestMapping;

public class Controller {
    @RequestMapping(value = "/hola")
    static public String index(){
        return "Estoy en el controlador bro, help me";
    }
}
