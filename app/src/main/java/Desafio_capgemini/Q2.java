package Desafio_capgemini;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.lang.Math;

/**
 * A classe <b>Q2</b> recebe do usuário uma senha e verifica quantos caracteres restam para que a mesma seja considerada segura 
 * @author Lucas Xavier
 * @since fev 2022
 * @version 1.0 
 */
public class Q2 {
    /**
     * Constante utilizada para facilitar utilização da String como chave de um HashMap
     */
    public static final String maiusculas = "mai";
    /**
     * Constante utilizada para facilitar utilização da String como chave de um HashMap
     */
    public static final String minusculas = "min";
    /**
     * Constante utilizada para facilitar utilização da String como chave de um HashMap
     */
    public static final String digitos = "dig";
    /**
     * Constante utilizada para facilitar utilização da String como chave de um HashMap
     */
    public static final String especiais = "esp";
    /**
     * Constante utilizada para facilitar utilização da String como chave de um HashMap
     */
    public static final String outros = "out";
    
    
    
     
    /**
     * Método utilizado para quebrar a senha em caracteres e contar as aparições de cada tipo de caractere. <br><br>
     * <b>Uso:</b><br>
     * Q2.contarCaracteres("Maria@123");
     * @param senha String que representa a senha passada pelo usuário.
     * @return Map<String,Integer> contendo os tipos de caracteres possíveis (letras maiúsculas, 
     * letras minúsculas, dígitos, caracteres especiais e outros caracteres) e o número de aparições de cada
     * tipo na senha fornecida.
     */

    //quebrar a senha em caracteres e contar as aparições de cada tipo de caractere
    public static Map<String, Integer> contarCaracteres(String senha){
        String[] caracs = senha.split("");

        Map<String, Integer> contadores = Q2.instanciarMapa();

        for(int i=0; i<caracs.length; i++){
            //converter a string em char
            char caractere = caracs[i].charAt(0);

            //contar a quantidade de cada tipo de caractere que há e registrá-las em um hashmap
            if(Character.isUpperCase(caractere)){
                contadores.replace(Q2.maiusculas, 
                            contadores.get(Q2.maiusculas), 
                            contadores.get(Q2.maiusculas)+1);
            } else if(Character.isLowerCase(caractere)){
                contadores.replace(Q2.minusculas, 
                            contadores.get(Q2.minusculas), 
                            contadores.get(Q2.minusculas)+1);
            } else if(Character.isDigit(caractere)){
                contadores.replace(Q2.digitos, 
                            contadores.get(Q2.digitos), 
                            contadores.get(Q2.digitos)+1);
            } else if("!@#$%^&*()-+".contains(String.valueOf(caractere))){
                contadores.replace(Q2.especiais, 
                            contadores.get(Q2.especiais), 
                            contadores.get(Q2.especiais)+1);
            } else {
                contadores.replace(Q2.outros, 
                            contadores.get(Q2.outros), 
                            contadores.get(Q2.outros)+1);
            }
        }

        return contadores;
    }

    /**
     * Método utilizado para contar a quantidade de tipos de caracteres que precisam ser adicionados para que a senha
     * seja considerada segura. <br><br>
     * <b>Uso:</b><br>
     * Q2.contarTiposCaracteresQueFaltam(new HashMap<String,Integer>().put(Q2.maiusculas, 1));
     * @param contadores Map<String,Integer> contendo a quantidade de cada tipo de caractere presente na senha passada pelo usuário.
     * @return Integer contendo a quantidade de tipos de caracteres que faltam
     * para que a senha seja considerada segura, os caracteres do tipo "outros"
     * não são considerados necessários.
     */

    //os tipos de caracteres que faltarem devem ser contabilizados, exceto os do tipo outros
    public static int contarTiposCaracteresQueFaltam(Map<String, Integer> contadores) {
        int contador = 0;
        
        //apenas contadores zerados devem ser contabilizados como em falta
        if(contadores.get(Q2.maiusculas)==0)    contador++;
        if(contadores.get(Q2.minusculas)==0)    contador++;
        if(contadores.get(Q2.digitos)==0)       contador++;
        if(contadores.get(Q2.especiais)==0)     contador++;

        return contador;
    }

    /**
     * Método utilizado para inicializar um Map contendo pares <String,Integer> que representam
     * os tipos de caracteres que podem aparecer na senha e sua quantidade, que inicialmente é 
     * instanciada com o valor 0. <br><br>
     * <b>Uso:</b><br>
     * Q2.instanciarMapa();
     * @return Map<String,Integer> com os tipos de caracteres que podem aparecer na senha com contadores zerados.
     */

    //criar hashmap para facilitar a contagem e retorno dos contadores
    public static Map<String, Integer> instanciarMapa(){
        Map<String, Integer> contadores = new HashMap<String, Integer>();
        contadores.put(Q2.maiusculas, 0);
        contadores.put(Q2.minusculas, 0);
        contadores.put(Q2.digitos, 0);
        contadores.put(Q2.especiais, 0);
        contadores.put(Q2.outros, 0);

        return contadores;
    }

    /**
     * Método utilizado para contar quantos caracteres faltam para que a senha possua uma quantidade de
     * caracteres considerada segura. <br><br>
     * <b>Uso:</b><br>
     * Q2.contarDigitosQueFaltamParaAlcancarMinimo("Maria@123", 6);
     * @param senha String que representa a senha passada pelo usuário 
     * @param qtdMinimaCaracteres inteiro que representa a quantidade mínima de caracteres presentes na senha 
     * para que esta possa ser considerada segura.
     * @return Integer contendo a quantidade de caracteres que faltam para que a senha seja considerada segura. 
     */

    //contar os caracteres que faltam para alcançar a quantidade mínima aceitada
    public static int contarDigitosQueFaltamParaAlcancarMinimo(String senha, int qtdMinimaCaracteres) {
        int tamSenhaAtual = senha.length();
        qtdMinimaCaracteres = Math.max(0, qtdMinimaCaracteres);
        int faltantes = qtdMinimaCaracteres - tamSenhaAtual;
        if(faltantes >= 0){
            return faltantes;
        }

        return 0;
    }


    /**
     * Método utilizado para contar quantos caracteres faltam ser adicionados para que a senha seja considerada segura. 
     * Utiliza os métodos: contarCaracteres, contarTiposCaracteresQueFaltam e contarDigitosQueFaltamParaAlcancarMinimo.<br><br>
     * <b>Uso:</b><br>
     * Q2.contarDigitosParaSenhaSegura("Maria@123", 6);
     * @param senha String que representa a senha passada pelo usuário.
     * @param minCaracteresSenha Integer representando a quantidade mínima de caracteres necessários para uma senha
     * ser considerada segura.
     * @return Integer representando a quantidade mínima de caracteres que precisam ser adicionados à senha para que esta
     * possa ser considerada segura.
     */

    //retorna maior valor, necessário para comparar quantidade que falta para alcançar
    //quantidade minima de caracteres e quantidade de tipos de caracteres que faltam
    public static int contarDigitosParaSenhaSegura(String senha, int minCaracteresSenha) {
        Map<String, Integer> conts= Q2.contarCaracteres(senha);
        int tiposCaracteresQueFaltam = Q2.contarTiposCaracteresQueFaltam(conts);
        int digitosQueFaltamParaMinimo = Q2.contarDigitosQueFaltamParaAlcancarMinimo(senha, minCaracteresSenha);
        
        if(tiposCaracteresQueFaltam > digitosQueFaltamParaMinimo) {
            return tiposCaracteresQueFaltam;
        } else {
            return digitosQueFaltamParaMinimo;
        }
    }

    

    public static void main(String args[]) {
        //inicializar variaveis mais básicas
        int minCaracteresSenha = 6;
        Scanner scan = new Scanner(System.in);
        String senha = "";
        int qtdCaracteres = 0;

        try {
            //ler a senha e quebrá-la em caracteres
            senha = scan.nextLine();
            
            qtdCaracteres = Q2.contarDigitosParaSenhaSegura(senha, minCaracteresSenha);

            System.out.println(qtdCaracteres);

        } catch (Exception e) {
            System.out.println(e.toString());
        }
        
        //fechar o que for necessário
        scan.close();
    }
}
