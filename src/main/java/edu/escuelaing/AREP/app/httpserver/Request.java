package edu.escuelaing.AREP.app.httpserver;



import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class that represent the HTTP request line
 * @author dnielben
 */
public class Request {

    private String met;
    private String reqURI;
    private String versionHTTP;
    private URI theuri;
    private Map<String,String> query;

    public Request(String rLine){
        parseRequestLine(rLine);
    }

    public Map<String, String> getQuery() {
        return query;
    }

    public void setQuery(Map<String, String> query) {
        this.query = query;
    }

    public String getMet() {
        return met;
    }

    public void setMet(String met) {
        this.met = met;
    }

    public String getReqURI() {
        return reqURI;
    }

    public void setReqURI(String reqURI) {
        this.reqURI = reqURI;
    }

    public String getVersionHTTP() {
        return versionHTTP;
    }

    public void setVersionHTTP(String versionHTTP) {
        this.versionHTTP = versionHTTP;
    }

    public URI getTheuri() {
        return theuri;
    }

    public void setTheuri(URI theuri) {
        this.theuri = theuri;
    }


    //code edit from https://stackoverflow.com/questions/13592236/parse-a-uri-string-into-name-value-collection
    private  Map<String, String> parseQuery(String url) throws UnsupportedEncodingException {
        if (url==null) return null;
        Map<String, String> query_pairs = new LinkedHashMap<String, String>();
        String[] pairs = url.split("&");
        for (String pair : pairs) {
            int idx = pair.indexOf("=");
            if (idx!=-1) {
                query_pairs.put(pair.substring(0,idx), pair.substring(idx + 1));
            }
        }
        return query_pairs;
    }

    public void parseRequestLine(String requestLine){
        try {
            String[] components= requestLine.split("\\s");
            met = components[0];
            reqURI = components[1];
            versionHTTP = components[2];
            setTheuri(new URI(reqURI));
            query = parseQuery(theuri.getQuery());
        } catch (URISyntaxException | UnsupportedEncodingException ex) {
            Logger.getLogger(Request.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public String getValFromQuery(String varname){
        return query.get(varname);
    }

    public String toString(){
        return met + " " + reqURI + " " + versionHTTP + "\n\r" +
                getTheuri() + "\n\r" +
                "Query: " + query;
    }
}