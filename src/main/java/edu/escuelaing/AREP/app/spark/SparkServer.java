package edu.escuelaing.AREP.app.spark;


import edu.escuelaing.AREP.app.spring.MicroSpring;
import edu.escuelaing.AREP.app.httpserver.HttpServer;


/**
 * Class that generate a spark server
 * @author dnielben
 */
public class SparkServer {

    public static void main(String[] args) {
        String[] args1 = new String[1];
        args1[0] = "edu.escuelaing.AREP.app.controllers.Controller";
        HttpServer server = null;
        try {
            MicroSpring microSpring = new MicroSpring();
            try {
                microSpring.starts(args1);
            } catch (Exception e) {
                e.printStackTrace();
            }
            server = new HttpServer(microSpring);
            server.run();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}





