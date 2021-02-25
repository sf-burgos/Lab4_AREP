package edu.escuelaing.AREP.app.ejemplopiojo;

import java.util.ArrayList;
import java.util.List;

public class Persona {
    public static void main(String[] args) {

        List<PojoPersona> lista = new ArrayList<PojoPersona>();

        PojoPersona obj = new PojoPersona();
        obj.setNombre("Brayan");
        obj.setApellidos("Burgos Delgado");

        PojoPersona obj2 = new PojoPersona();
        obj2.setNombre("Juan");
        obj2.setApellidos("Garcia Ruiz");

        lista.add(obj);
        lista.add(obj2);

        for (PojoPersona dato : lista){
            String a = dato.getNombre();
            String b = dato.getApellidos();
            System.out.println(a+" "+b);
        }
    }
}
