/*3. Entrar via teclado com “N” valores quaisquer. O valor “N” (que representa a quantidade de
números) será digitado, deverá ser positivo, porém menor que vinte. Caso a quantidade não
satisfaça a restrição, enviar mensagem de erro e solicitar o valor novamente. Após a
digitação dos “N” valores, exibir:
a. O maior valor;
b. O menor valor;
c. A soma dos valores;
d. A média aritmética dos valores;
e. A porcentagem de valores que são positivos;
f. A porcentagem de valores negativos;
Após exibir os dados, perguntar ao usuário de deseja ou não uma nova execução do
programa. Consistir a resposta no sentido de aceitar somente “S” ou “N” e encerrar o
programa em função dessa resposta. 

Exercício feito por Igor Cristiano Bezerra (CB3038408) e Pedro Matias dos Santos Neto (CB3038785)*/

package LPR1.TP02;
import java.util.Scanner;

public class TP02_Ex03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String resposta;
        
        do {
            int n;
            do {
                System.out.print("Digite a quantidade de números (positivo e menor que 20): ");
                n = sc.nextInt();
                if (n <= 0 || n >= 20) {
                    System.out.println("Erro: Quantidade inválida.");
                }
            } while (n <= 0 || n >= 20);
            
            int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE, soma = 0;
            int positivos = 0, negativos = 0;
            
            for (int i = 1; i <= n; i++) {
                System.out.print("Digite o " + i + "º valor: ");
                int v = sc.nextInt();
                
                if (v > max) max = v;
                if (v < min) min = v;
                soma += v;
                if (v > 0) positivos++;
                if (v < 0) negativos++;
            }
            
            System.out.println("\nResultados:");
            System.out.println("Maior valor: " + max);
            System.out.println("Menor valor: " + min);
            System.out.println("Soma: " + soma);
            System.out.println("Média: " + ((double) soma / n));
            System.out.println("% Positivos: " + ((double) positivos / n * 100) + "%");
            System.out.println("% Negativos: " + ((double) negativos / n * 100) + "%");
            
            do {
                System.out.print("\nDeseja uma nova execução? (S/N): ");
                resposta = sc.next().toUpperCase();
            } while (!resposta.equals("S") && !resposta.equals("N"));
            
        } while (resposta.equals("S"));
        
        System.out.println("Programa encerrado.");
        sc.close();
    }
}