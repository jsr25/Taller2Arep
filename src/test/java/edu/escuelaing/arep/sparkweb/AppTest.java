package edu.escuelaing.arep.sparkweb;

import edu.escuelaing.arep.calc.CalcStat;
import edu.escuelaing.arep.util.Reader;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.text.DecimalFormat;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    private DecimalFormat format;
    private List<Double> valores1;
    private List<Double> valores2;
    private List<Double> valores3;
    private List<Double> valores4;
    private List<Double> valores5;
    private List<Double> valores6;
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
        format= new DecimalFormat("#########.##");
        valores1 = Reader.lector("src/test/resources/test1.txt");
        valores2 = Reader.lector("src/test/resources/test2.txt");
        valores3 = Reader.lector("src/test/resources/test3.txt");
        valores4 = Reader.lector("src/test/resources/test4.txt");
        valores5 = Reader.lector("src/test/resources/test5.txt");
        valores6 = Reader.lector("src/test/resources/test6.txt");

    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testMediaC1()
    {
        Double resultadoEsperado=10.33;
        Double resusltadoObtenido= CalcStat.media(valores1);
        assertEquals(format.format(resultadoEsperado),format.format(resusltadoObtenido));
    }
    public void testMediaC2()
    {
        Double resultadoEsperado=8.6;
        Double resusltadoObtenido= CalcStat.media(valores2);
        assertEquals(format.format(resultadoEsperado),format.format(resusltadoObtenido));
    }
    public void testMediaC3()
    {
        Double resultadoEsperado=1444.99;
        Double resusltadoObtenido= CalcStat.media(valores3);
        assertEquals(format.format(resultadoEsperado),format.format(resusltadoObtenido));
    }
    public void testMediaC4()
    {
        Double resultadoEsperado=3391.47;
        Double resusltadoObtenido= CalcStat.media(valores4);
        assertEquals(format.format(resultadoEsperado),format.format(resusltadoObtenido));
    }

    public void testDesvC1()
    {
        Double resultadoEsperado = 4.54;
        Double resusltadoObtenido = CalcStat.desStand(valores1);
        assertEquals(format.format(resultadoEsperado),format.format(resusltadoObtenido));
    }
    public void testDesvC2()
    {
        Double resultadoEsperado = 8.38;
        Double resusltadoObtenido = CalcStat.desStand(valores2);
        assertEquals(format.format(resultadoEsperado),format.format(resusltadoObtenido));
    }
    public void testDesvC3()
    {
        Double resultadoEsperado = 1454.56;
        Double resusltadoObtenido = CalcStat.desStand(valores3);
        assertEquals(format.format(resultadoEsperado),format.format(resusltadoObtenido));
    }
    public void testDesvC4()
    {
        Double resultadoEsperado = 10068.55;
        Double resusltadoObtenido = CalcStat.desStand(valores4);
        assertEquals(format.format(resultadoEsperado),format.format(resusltadoObtenido));
    }

    public void testMediaC5(){
        Double resultadoEsperado=550.6;
        Double resusltadoObtenido= CalcStat.media(valores5);
        assertEquals(format.format(resultadoEsperado),format.format(resusltadoObtenido));

    }

    public void testMediaC6(){
        Double resultadoEsperado=60.32;
        Double resusltadoObtenido= CalcStat.media(valores6);
        assertEquals(format.format(resultadoEsperado),format.format(resusltadoObtenido));

    }

    public void testDesvC5(){
        Double resultadoEsperado = 572.03;
        Double resusltadoObtenido = CalcStat.desStand(valores5);
        assertEquals(format.format(resultadoEsperado),format.format(resusltadoObtenido));
    }

    public void testDesvC6(){
        Double resultadoEsperado = 62.26;
        Double resusltadoObtenido = CalcStat.desStand(valores6);
        assertEquals(format.format(resultadoEsperado),format.format(resusltadoObtenido));

    }
}
