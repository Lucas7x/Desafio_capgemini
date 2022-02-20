/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Desafio_capgemini;

import java.util.Map;
import java.util.HashMap;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author medusa
 */
public class Q3Test {
    
    public Q3Test() {
    }

    @Test
    public void test01_SaoAnagramas() {
        Map<String, Integer> sub_palavra_1 = new HashMap<String,Integer>();
        sub_palavra_1.put("o", 2);
        sub_palavra_1.put("v", 1);
        Map<String, Integer> sub_palavra_2 = new HashMap<String,Integer>();
        sub_palavra_2.put("v", 1);
        sub_palavra_2.put("o", 2);
        
        boolean esperado = true;
        boolean obtido = Q3.saoAnagramas(sub_palavra_1, sub_palavra_2);
        
        assertEquals(esperado, obtido);
        
    }
    
    @Test
    public void test02_SaoAnagramas() {
        Map<String, Integer> sub_palavra_1 = new HashMap<String,Integer>();
        sub_palavra_1.put("o", 2);
        sub_palavra_1.put("v", 1);
        Map<String, Integer> sub_palavra_2 = new HashMap<String,Integer>();
        sub_palavra_2.put("f", 1);
        sub_palavra_2.put("o", 2);
        
        boolean esperado = false;
        boolean obtido = Q3.saoAnagramas(sub_palavra_1, sub_palavra_2);
        
        assertEquals(esperado, obtido);
        
    }
    

    @Test
    public void testPegarLetrasSubPalavra() {
        String[] palavra = "ovos".split("");
        int tam_sub_palavra = 3;
        int inicio_subpalavra = 0;
        Map<String,Integer> esperado = new HashMap<String,Integer>();
        esperado.put("o", 2);
        esperado.put("v", 1);
        
        Map<String,Integer> obtido = Q3.pegarLetrasSubPalavra(palavra, tam_sub_palavra, inicio_subpalavra);
        
        assertEquals(esperado, obtido);
        
    }

    @Test
    public void test01_ContarAnagramas() {
        String palavra = "ifailuhkqq";
        int esperado = 3;
        int obtido = Q3.contarAnagramas(palavra);
        
        assertEquals(esperado, obtido);
    }
    
    @Test
    public void test02_ContarAnagramas() {
        String palavra = "feio";
        int esperado = 0;
        int obtido = Q3.contarAnagramas(palavra);
        
        assertEquals(esperado, obtido);
    }
    

    @Test
    public void testMain() {
    }
    
}
