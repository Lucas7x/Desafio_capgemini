/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Desafio_capgemini;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
        
class Q1Test {
    @Test 
    public void test01_GerarEscada() {
        int n = 3;
        String esperado = "  *\n **\n***";
        String obtido = Q1.gerarEscada(n);
    }
    
    @Test 
    public void test02_GerarEscada() {
        int n = -1;
        String esperado = "";
        String obtido = Q1.gerarEscada(n);
    }
    

}
