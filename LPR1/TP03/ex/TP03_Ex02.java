/*Exercício feito por Igor Cristiano Bezerra (CB3038408) e Pedro Matias dos Santos Neto (CB3038785)*/

package LPR1.TP03;

public class TP03_Ex02 {
    public static void main(String[] args) {
        System.out.println("--- Teste do Construtor Vazio (Digitacao) ---");
        TP03_Ex01 h1 = new TP03_Ex01();
        
        System.out.println("\nFormato 1: " + h1.getHora1());
        System.out.println("Formato 2: " + h1.getHora2());
        System.out.println("Total em segundos: " + h1.getSegundos());
        
        System.out.println("\n--- Teste do Construtor com Parametros ---");
        TP03_Ex01 h2 = new TP03_Ex01(16, 30, 45);
        
        System.out.println("Formato 1: " + h2.getHora1());
        System.out.println("Formato 2: " + h2.getHora2());
        System.out.println("Total em segundos: " + h2.getSegundos());

        System.out.println("\n--- Teste dos Getters e Setters ---");
        h2.setHor(9);
        h2.setMin(15);
        h2.setSeg(5);
        
        System.out.println("Hora isolada: " + h2.getHor());
        System.out.println("Minuto isolado: " + h2.getMin());
        System.out.println("Segundo isolado: " + h2.getSeg());
        System.out.println("Nova hora montada: " + h2.getHora1());
    }
}