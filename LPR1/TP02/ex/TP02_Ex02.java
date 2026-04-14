/*2. Entrar via teclado com dez valores positivos. Consistir a digitação e enviar mensagem de
erro, se necessário. Após a digitação, exibir:
a. O maior valor;
b. A soma dos valores;
c. A média aritmética dos valores. 

Exercício feito por Igor Cristiano Bezerra (CB3038408) e Pedro Matias dos Santos Neto (CB3038785)*/

package LPR1.TP02;
import java.util.Scanner;

public class TP02_Ex02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int max = Integer.MIN_VALUE;
        int soma = 0;
        
        for (int i = 1; i <= 10; i++) {
            int valor;
            do {
                System.out.print("Digite o " + i + "º valor positivo: ");
                valor = sc.nextInt();
                if (valor <= 0) {
                    System.out.println("Erro: O valor deve ser positivo.");
                }
            } while (valor <= 0);
            
            if (valor > max) max = valor;
            soma += valor;
        }
        
        System.out.println("Maior valor: " + max);
        System.out.println("Soma dos valores: " + soma);
        System.out.println("Média aritmética: " + (soma / 10.0));
        sc.close();
    }
}
