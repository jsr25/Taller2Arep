package edu.escuelaing.arep.calc;

import java.util.List;


/**
 * Calculadora de media y desviacion estandar
 *
 * Autor: Juan Sebastian Ramos Isaza
 */
public class CalcStat {

    /**
     * Funcion encargada de realizar el calculo y
     * volver el resultado de la media de un conjunto de datos
     * @param valores Lista de numeros que se usaran para el calculo
     * @return La media de los datos ingresados
     */
    public static Double media(List<Double> valores ){
        Double respuesta = 0.0;
        for (Double val: valores){
            respuesta = respuesta + val;
        }

        return  (respuesta/valores.size());
    }

    /**
     * Funcion encargada de realizar el calculo y devolver el resultado
     * la desviacion estandar de un conjunto de datos
     * @param valores Lista de numeros que se usaran para el calculo
     * @return La desviacion estandar de los datos ingresados
     */
    public static Double desStand(List<Double> valores){
        Double media = CalcStat.media(valores);
        Double respuesta = 0.0;
        for (Double val: valores){
            Double temp = val - media;
            respuesta = respuesta + Math.pow(temp,2);
        }
        Double temp = respuesta / (valores.size()-1);
        respuesta = Math.sqrt(temp);
        return respuesta;
    }
}

