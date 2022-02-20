package Desafio_capgemini;

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;

/**
 * A classe <b>Q3</b> recebe do usuário uma palavra e verifica quantos pares de substrings podem ser considedos anagramas. 
 * @author Lucas Xavier
 * @since fev 2022
 * @version 1.0 
 */

public class Q3 {

    /**
     * Método utilizado para verificar se duas sub-palavras são anagramas. <br><br>
     * <b>Uso:</b><br>
     * Q3.saoAnagramas("ov","vo");
     * @param sub_palavra_1 Map<String,Integer> representando as letras presentes na primeira sub-palavra que será comparada e quantas vezes a mesma aparece.
     * @param sub_palavra_2 Map<String,Integer> representando as letras presentes na segunda sub-palavra que será comparada e quantas vezes a mesma aparece.
     * @return boolean onde será retornado "true" caso as palavras sejam anagramas e "false" caso contrário.
     */

    //verifica se as 2 sub-palavras são anagramas
    public static boolean saoAnagramas(Map<String, Integer> sub_palavra_1, Map<String, Integer> sub_palavra_2) {
        //converte 
        Set<String> letras = sub_palavra_1.keySet();
        for(String letra : letras){
            if(sub_palavra_2.get(letra)==null || sub_palavra_2.get(letra)!=sub_palavra_1.get(letra)){
                //sao_anagramas = false;
                return false;
            }
        }

        return true;
    }
    

    /**
     * Método utilizado para pegar as letras de uma sub-palavra. <br><br>
     * <b>Uso:</b><br>
     * Q3.pegarLetrasSubPalavra("capgemini",3,3);
     * @param palavra Array de Strings representando as letras presentes na palavra fornecida.
     * @param tam_sub_palavra Integer representando o tamanho que a sub-palavra deve possuir.
     * @param inicio_subpalavra Integer representando a posição inicial da sub-palavra no Array que representa a palavra.
     * @return Map<String,Integer> contendo as letras presentes na sub-palavra e a quantidade de vezes que aparece.
     */
    public static Map<String, Integer> pegarLetrasSubPalavra(String[] palavra, int tam_sub_palavra, int inicio_subpalavra) {
        Map<String, Integer> letras_subpalavra = new HashMap<String, Integer>();
        
        //contar a quantidade de cada letra da sub-palavra de tamanho "tam_sub_palavra" 
        //iniciada na posição "inicio_subpalavra"
        for(int n=0; n<tam_sub_palavra; n++){
            String letra = palavra[inicio_subpalavra+n];

            //registrar a letra da sub-palavra i 
            if(!letras_subpalavra.containsKey(letra)){
                letras_subpalavra.put(letra, 1);
            }else{
                letras_subpalavra.replace(letra, letras_subpalavra.get(letra), letras_subpalavra.get(letra)+1);
            }
        }

        return letras_subpalavra;
    }

    /**
     * Método utilizado para contar quantos anagramas há na palavra informada. Define os laços de repetição
     * que definem as iterações que geram as sub-palavras. Utiliza os métodos: pegarLetrasSubPalavra e
     * saoAnagramas. <br><br>
     * <b>Uso:</b><br>
     * Q3.contarAnagramas("capgemini");
     * @param palavra
     * @return
     */
    public static int contarAnagramas(String palavra) {
        String[] letras_palavra = palavra.split("");
        int size_palavra = letras_palavra.length;
        int cont_anagramas = 0;
        
        //definir inteiros menores que a qtd de letras para formar sub-palavras
        for(int size_sub_palavra=1; size_sub_palavra<size_palavra; size_sub_palavra++){
            //formar sub-palavra de tamanho tam que se inicie na posição i para comparar com as geradas a seguir
            for(int i=0; (i+size_sub_palavra-1)<(size_palavra); i++){
                //formar sub-palavras iniciadas na posição j=i+1 para comparar com a gerada anteriormente e verificar se são anagramas 
                for(int j=i+1; (j+size_sub_palavra-1)<(size_palavra); j++){

                    //verifica se as letras das sub-palavras ja estao mapeadas e adiciona ou incrementa de acordo com as condições
                    Map<String, Integer> sub_palavra_1 = Q3.pegarLetrasSubPalavra(letras_palavra, size_sub_palavra, i);
                    Map<String, Integer> sub_palavra_2 = Q3.pegarLetrasSubPalavra(letras_palavra, size_sub_palavra, j);

                    //verifica se são anagramas e incrementa o contador caso seja
                    boolean sao_anagramas = Q3.saoAnagramas(sub_palavra_1, sub_palavra_2);
                    if(sao_anagramas){
                        cont_anagramas = cont_anagramas +1;
                    }
                }
                
            }
        }

        return cont_anagramas;
    } 

    public static void main(String args[]) {
        //variaveis
        Scanner scan = new Scanner(System.in);
        int cont_anagramas = 0;


        try {

            //ler a palavra
            String palavra = scan.next();

            cont_anagramas = Q3.contarAnagramas(palavra);
            System.out.println(cont_anagramas);

        } catch (Exception e) {
            System.out.println(e.toString());
        }

        //fechar o que for necessário
        scan.close();
        
    }
}
