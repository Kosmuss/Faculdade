/*1. Entrar com dois valores via teclado, onde o segundo valor deverá ser maior que o primeiro.
Caso contrário solicitar novamente apenas o segundo valor. 

Exercício feito por Igor Cristiano Bezerra (CB3038408) e Pedro Matias dos Santos Neto (CB3038785)*/


package LPR1.TP02;
import java.util.Scanner;

public class TP02_Ex01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o primeiro valor: ");
        int valor1 = sc.nextInt();
        int valor2;
        
        do {
            System.out.print("Digite o segundo valor (deve ser maior que o primeiro): ");
            valor2 = sc.nextInt();
            if (valor2 <= valor1) {
                System.out.println("Erro: O segundo valor deve ser estritamente maior que o primeiro.");
            }
        } while (valor2 <= valor1);
        
        System.out.println("Valores aceitos: " + valor1 + " e " + valor2);
        sc.close();
    }
}