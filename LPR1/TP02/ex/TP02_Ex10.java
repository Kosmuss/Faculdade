/*10. Entrar com uma matriz de ordem MxM, onde a ordem também será escolhida pelo usuário,
sendo que no máximo será de ordem 10 e quadrática. Após a digitação dos elementos,
calcular e exibir a matriz inversa. Exibir as matrizes na tela, sob a forma matricial (linhas x
colunas). 

Exercício feito por Igor Cristiano Bezerra (CB3038408) e Pedro Matias dos Santos Neto (CB3038785)*/

package LPR1.TP02;
import java.util.Scanner;

public class TP02_Ex10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m;
        
        do {
            System.out.print("Digite a ordem da matriz quadrática (M <= 10): ");
            m = sc.nextInt();
        } while (m <= 0 || m > 10);
        
        double[][] matriz = new double[m][m];
        System.out.println("Digite os elementos da matriz:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print("Posição [" + i + "][" + j + "]: ");
                matriz[i][j] = sc.nextDouble();
            }
        }
        
        double[][] inversa = calcularInversa(matriz);
        
        if (inversa != null) {
            System.out.println("\nMatriz Inversa:");
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < m; j++) {
                    System.out.printf("%.3f\t", inversa[i][j]);
                }
                System.out.println();
            }
        } else {
            System.out.println("\nA matriz não possui inversa (Determinante é zero).");
        }
        sc.close();
    }

    public static double[][] calcularInversa(double[][] matriz) {
        int n = matriz.length;
        double[][] aumentada = new double[n][2 * n];

        // Montar matriz aumentada [A | I]
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                aumentada[i][j] = matriz[i][j];
            }
            aumentada[i][i + n] = 1;
        }

        // Eliminação de Gauss-Jordan
        for (int i = 0; i < n; i++) {
            double pivo = aumentada[i][i];
            if (pivo == 0) return null; // Não é inversível

            for (int j = 0; j < 2 * n; j++) {
                aumentada[i][j] /= pivo;
            }

            for (int k = 0; k < n; k++) {
                if (k != i) {
                    double fator = aumentada[k][i];
                    for (int j = 0; j < 2 * n; j++) {
                        aumentada[k][j] -= fator * aumentada[i][j];
                    }
                }
            }
        }

        // Extrair a matriz inversa
        double[][] inversa = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                inversa[i][j] = aumentada[i][j + n];
            }
        }
        return inversa;
    }
}