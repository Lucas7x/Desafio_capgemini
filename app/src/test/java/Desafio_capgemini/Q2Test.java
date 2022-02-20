/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Desafio_capgemini;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;
import java.util.HashMap;
/**
 *
 * @author medusa
 */
public class Q2Test {
    
    public Q2Test() {
    }

    @Test
    public void test01_ContarCaracteres() {
        String senha = "Ma@";
        Map<String,Integer> esperado = new HashMap<String,Integer>();
        esperado.put(Q2.maiusculas, 1);
        esperado.put(Q2.minusculas, 1);
        esperado.put(Q2.especiais, 1);
        esperado.put(Q2.digitos, 0);
        esperado.put(Q2.outros, 0);
        
        Map<String,Integer> obtido = Q2.contarCaracteres(senha);
        assertEquals(esperado, obtido);
    }
    
    @Test
    public void test02_ContarCaracteres() {
        String senha = "Ma@ ";
        Map<String,Integer> esperado = new HashMap<String,Integer>();
        esperado.put(Q2.maiusculas, 1);
        esperado.put(Q2.minusculas, 1);
        esperado.put(Q2.especiais, 1);
        esperado.put(Q2.digitos, 0);
        esperado.put(Q2.outros, 1);
        
        Map<String,Integer> obtido = Q2.contarCaracteres(senha);
        assertEquals(esperado, obtido);
    }
    
    @Test
    public void test03_ContarCaracteres() {
        String senha = "Ma@12";
        Map<String,Integer> esperado = new HashMap<String,Integer>();
        esperado.put(Q2.maiusculas, 1);
        esperado.put(Q2.minusculas, 1);
        esperado.put(Q2.especiais, 1);
        esperado.put(Q2.digitos, 2);
        esperado.put(Q2.outros, 0);
        
        Map<String,Integer> obtido = Q2.contarCaracteres(senha);
        assertEquals(esperado, obtido);
    }
    

    @Test
    public void test01_ContarTiposCaracteresQueFaltam() {
        Map<String, Integer> contadores = new HashMap<String,Integer>();
        contadores.put(Q2.maiusculas, 1);
        contadores.put(Q2.minusculas, 2);
        contadores.put(Q2.especiais, 0);
        contadores.put(Q2.digitos, 0);
        contadores.put(Q2.outros, 0);
        
        int esperado = 2;
        int obtido = Q2.contarTiposCaracteresQueFaltam(contadores);
        
        assertEquals(esperado, obtido);
    }
    
    @Test
    public void test02_ContarTiposCaracteresQueFaltam() {
        Map<String, Integer> contadores = new HashMap<String,Integer>();
        contadores.put(Q2.maiusculas, 1);
        contadores.put(Q2.minusculas, 2);
        contadores.put(Q2.especiais, 0);
        contadores.put(Q2.digitos, 0);
        contadores.put(Q2.outros, 2);
        
        int esperado = 2;
        int obtido = Q2.contarTiposCaracteresQueFaltam(contadores);
        
        assertEquals(esperado, obtido);
    }
    
    

    @Test
    public void testInstanciarMapa() {
        Map<String,Integer> esperado = new HashMap<String,Integer>();
        esperado.put(Q2.maiusculas, 0);
        esperado.put(Q2.minusculas, 0);
        esperado.put(Q2.especiais, 0);
        esperado.put(Q2.digitos, 0);
        esperado.put(Q2.outros, 0);
        
        Map<String,Integer> obtido = Q2.instanciarMapa();
        
        assertEquals(esperado,obtido);
    }

    @Test
    public void test01_ContarDigitosQueFaltamParaAlcancarMinimo() {
        String senha = "M@r";
        int qtdMinimaCaracteres = 6;
        int valorEsperado = 3;
        int obtido = Q2.contarDigitosQueFaltamParaAlcancarMinimo(senha, qtdMinimaCaracteres);
        assertEquals(valorEsperado, obtido);
    }
    
    @Test
    public void test02_ContarDigitosQueFaltamParaAlcancarMinimo() {
        String senha = "";
        int qtdMinimaCaracteres = 6;
        int valorEsperado = 6;
        int obtido = Q2.contarDigitosQueFaltamParaAlcancarMinimo(senha, qtdMinimaCaracteres);
        assertEquals(valorEsperado, obtido);
    }
    
    @Test
    public void test03_ContarDigitosQueFaltamParaAlcancarMinimo() {
        String senha = "";
        int qtdMinimaCaracteres = -1;
        int valorEsperado = 0;
        int obtido = Q2.contarDigitosQueFaltamParaAlcancarMinimo(senha, qtdMinimaCaracteres);
        assertEquals(valorEsperado, obtido);
    }

    @Test
    public void test01_ContarDigitosParaSenhaSegura() {
        String senha = "Ya3";
        int minCaracteres = 6;
        int esperado =  3;
        int obtido = Q2.contarDigitosParaSenhaSegura(senha, minCaracteres);
        
        assertEquals(esperado, obtido);
    }
    
    @Test
    public void test02_ContarDigitosParaSenhaSegura() {
        String senha = "Mari@1";
        int minCaracteres = 6;
        int esperado =  0;
        int obtido = Q2.contarDigitosParaSenhaSegura(senha, minCaracteres);
        
        assertEquals(esperado, obtido);
    }
    
    @Test
    public void test03_ContarDigitosParaSenhaSegura() {
        String senha = "Ma@1";
        int minCaracteres = 2;
        int esperado =  0;
        int obtido = Q2.contarDigitosParaSenhaSegura(senha, minCaracteres);
        
        assertEquals(esperado, obtido);
    }

    @Test
    public void testMain() {
    }
    
}
