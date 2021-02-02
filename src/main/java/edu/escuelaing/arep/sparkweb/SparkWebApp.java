package edu.escuelaing.arep.sparkweb;

import edu.escuelaing.arep.calc.CalcStat;
import edu.escuelaing.arep.util.LinkedList;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;

import static spark.Spark.*;
public class SparkWebApp {

    public static void main(String[] args) {
        port(getPort());
        get("/", (req, res) -> {
        return "<!DOCTYPE html>"+
                 "<html>"+
                "<body>"+
                "<form action=\"/respuesta\" method=\"get\">" +
                "<div>" +
                "   <label for\"info\"> Ingrese los datos separados por guion (-)</label>" +
                "</br>"+
                "   <input required name=\"datos\" id=\"datos\" value=\"\">" +
                "</div>" +
                "<button> Calcular </button>" +
                "</form>"+
                "</body>";
        });

        get("/respuesta", (req, res) -> {
            DecimalFormat format= new DecimalFormat("#########.##");
            String data = req.queryParams("datos");
            List<String> temp = Arrays.asList(data.split("-"));
            List<Double> paraCalcular= new LinkedList<>();
            for(String t: temp){
                try{
                paraCalcular.add(Double.parseDouble(t));}
                catch (Exception e){

                }
            }
            String media =format.format(CalcStat.media(paraCalcular));
            String desvia =format.format(CalcStat.desStand(paraCalcular));
            return  "<!DOCTYPE html>"+
                    "<html>"+
                    "<body>"+
                    "<form action=\"/\" method=\"get\">" +
                    " <label for\"media\"> La media de los datos Ingresados:</label>" +
                    "</br>"+
                    "<label>"+media+"</label>\n"+
                    "</br>"+
                    "<label for\"deviacion\"> La desviación estandar de los datos Ingresados:</label>" +
                    "</br>"+
                    "<label>"+desvia+"</label>\n"+
                    "</br>"+
                    "<button> Volver </button>" +
                    "</form>"+
                    "</body>";
        });
    }



    static int getPort(){
        if(System.getenv("PORT")!= null){
            return  Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }





}