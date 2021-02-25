package edu.escuelaing.AREP.app.httpserver;

import edu.escuelaing.AREP.app.spring.MicroSpring;

import java.io.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
        * Class that generate a Http Server
        *
        * @author github.com/sf-burgos
        */

public class HttpServer {
    private MicroSpring iocServer;
    private boolean running=false; 
    
    public HttpServer(){}

    //constructor
    public HttpServer(MicroSpring iocServer) {
        this.iocServer = iocServer;
    }

    private static int getPort(){
        if (System.getenv("Port")!= null){
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 1437;
    }



    public void run() throws IOException {
        try {
            ServerSocket serverSocket = null;
            int port = getPort();

            try {
                serverSocket = new ServerSocket(port);
            } catch (IOException e) {
                System.err.println("Could not listen on port: " + port);
                System.exit(1);
            }

            running = true;
            while (running) {
                try {
                    Socket clientSocket = null;
                    try {
                        System.out.println("Listo para recibir ...");
                        clientSocket = serverSocket.accept();
                    } catch (IOException e) {
                        System.err.println("Could not listen on port:" + getPort());
                        System.exit(1);
                    }

                    processRequest(clientSocket);

                    clientSocket.close();
                }

                catch (IOException ex) {
                    Logger.getLogger(HttpServer.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
            serverSocket.close();
        } catch (IOException ex) {
            Logger.getLogger(HttpServer.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void processRequest(Socket clientSocket) throws IOException, InvocationTargetException, IllegalAccessException {
        BufferedReader in = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream()));
        String inputLine;
        Map<String, String> request = new HashMap<>();
        boolean requestLineReady = false;
        while ((inputLine = in.readLine()) != null) {
            if (!requestLineReady) {
                request.put("requestLine", inputLine);
                requestLineReady = true;
            } else {
                String[] entry = createEntry(inputLine);
                if (entry.length > 1) {
                    request.put(entry[0], entry[1]);
                }
            }
            if (!in.ready()) {
                break;
            }
        }


        if(request.get("requestLine")!=null){
            Request req = new Request(request.get("requestLine"));

            System.out.println("RequestLine: " + req);
            if(req != null) {
                createResponse(req, new PrintWriter(
                        clientSocket.getOutputStream(), true),clientSocket.getOutputStream());
            }
            in.close();

        }

    }

    private void createResponse(Request req, PrintWriter printWriter, OutputStream outputStream)  throws InvocationTargetException, IllegalAccessException {
    //implementar cuando se atore el code :V
    }

    private String[] createEntry(String inputLine) {
        return inputLine.split(":");
    }


}
