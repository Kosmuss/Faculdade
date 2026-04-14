/*9. Entrar com uma matriz de ordem MxN, onde a ordem também será escolhida pelo usuário,
sendo que no máximo 10x10. A matriz não precisa ser quadrática. Após a digitação dos
elementos, calcular e exibir a matriz transposta. 

Exercício feito por Igor Cristiano Bezerra (CB3038408) e Pedro Matias dos Santos Neto (CB3038785)*/

package LPR1.TP02;
import java.util.Scanner;

public class TP02_Ex09 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m, n;
        
        do {
            System.out.print("Digite o número de linhas (M <= 10): ");
            m = sc.nextInt();
            System.out.print("Digite o número de colunas (N <= 10): ");
            n = sc.nextInt();
        } while (m <= 0 || m > 10 || n <= 0 || n > 10);
        
        int[][] matriz = new int[m][n];
        int[][] transposta = new int[n][m];
        
        System.out.println("Digite os valores da matriz:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("Posição [" + i + "][" + j + "]: ");
                matriz[i][j] = sc.nextInt();
                transposta[j][i] = matriz[i][j];
            }
        }
        
        System.out.println("\nMatriz Transposta:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(transposta[i][j] + "\t");
            }
            System.out.println();
        }
        sc.close();
    }
}