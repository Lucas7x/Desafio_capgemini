package Desafio_capgemini;

import java.util.Scanner;

/**
 * A classe <b>Q1</b> recebe do usuário um número N e imprime no terminal uma "escada" de asteriscos 
 * @author Lucas Xavier
 * @since fev 2022
 * @version 1.0
 */
public class Q1 {

    /**
     * Método utilizado para gerar uma String em forma de escada de dimensões n por n <br><br>
     * <b>Uso:</b><br>
     * Q3.gerarEscada(3); 
     * @param n inteiro que indica o número de iterações do laço for 
     */
    public static String gerarEscada(int n) {
      String escada = "";
      for(int i=1; i<=n; i++){
        String linha = "";
        for(int j=1; j<=n; j++){
            if(j <= (n-i)){
                linha += " ";
            } else{
                linha += "*";
            }
        }

        if(i==1){
          escada += linha;
        }else{
          escada += "\n";
          escada += linha;
        }

      }

      return escada;
    }

    public static void main(String args[]) {
      //variaveis
      Scanner scan = new Scanner(System.in);
      int n;

      try {
        System.out.println("Digite o valor de N");
        //ler o valor de n (inteiro)
        n = scan.nextInt();
        
        //chamar o método que imprime
        System.out.println(Q1.gerarEscada(n));

      } catch (Exception e) {
        System.out.println(e.toString());
      }
      
      //fechar o que for necessário
      scan.close();
      
    }
}