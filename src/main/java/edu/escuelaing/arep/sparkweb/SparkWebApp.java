package edu.escuelaing.arep.sparkweb;

import edu.escuelaing.arep.calc.CalcStat;
import edu.escuelaing.arep.util.LinkedList;

import javax.swing.*;
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
                "<head>" +
                "<title> Calculadora</title>"+
                "</head>"+
                "<body>" +
                "<div>" +
                "<h2>Calculadora de media y Desviación</h2>" +
                "</div>"+
                "<form action=\"/respuesta\" method=\"get\">" +
                "<div>" +
                " <h4 for\"info\"> Ingrese los datos separados por guion (-)</h4>" +
                " <input required name=\"datos\" id=\"datos\" value=\"\">" +
                "</div>" +
                "</br>"+
                "<button> Calcular </button>" +
                "</form>"+
                "</body>";
        });

        get("/respuesta", (req, res) -> {
            DecimalFormat format = new DecimalFormat("#########.##");
            String data = req.queryParams("datos");
            List<String> temp = Arrays.asList(data.split("-"));
            List<Double> paraCalcular = new LinkedList<>();
            String media;
            String desvia;
            try {
                for (String t : temp) {
                    paraCalcular.add(Double.parseDouble(t));
                }
                media = format.format(CalcStat.media(paraCalcular));
                desvia = format.format(CalcStat.desStand(paraCalcular));
                return "<!DOCTYPE html>" +
                        "<html>" +
                        "<head>" +
                        "<title> Respuesta </title>"+
                        "</head>"+
                        "<body>" +
                        "<form action=\"/\" method=\"get\">" +
                        " <label for\"media\"> La media de los datos Ingresados:</label>" +
                        "</br>" +
                        "<label>" + media + "</label>\n" +
                        "</br>" +
                        "<label for\"deviacion\"> La desviación estandar de los datos Ingresados:</label>" +
                        "</br>" +
                        "<label>" + desvia + "</label>\n" +
                        "</br>" +
                        "<button> Volver </button>" +
                        "</form>" +
                        "</body>";

            } catch (Exception e) {
                return "<!DOCTYPE html>" +
                        "<html>" +
                        "<body>" +
                        "<head>" +
                        "<title> 406 Inaceptable </title>"+
                        "</head>"+
                        "<form action=\"/\" method=\"get\">" +
                        "<h1>406 Inaceptable</h1>" +
                        "<button> Volver </button>" +
                        "</form>" +
                        "" +
                        "" +
                        "" ;
            }

        });

    }



    static int getPort(){
        if(System.getenv("PORT")!= null){
            return  Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }





}