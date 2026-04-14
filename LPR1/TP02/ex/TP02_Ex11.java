/*11. Entrar com uma matriz de ordem MxM, onde a ordem também será escolhida pelo usuário,
sendo que no máximo será de ordem 10 e quadrática. Após a digitação dos elementos,
calcular e exibir determinante da matriz. 

Exercício feito por Igor Cristiano Bezerra (CB3038408) e Pedro Matias dos Santos Neto (CB3038785)*/

package LPR1.TP02;
import java.util.Scanner;

public class TP02_Ex11 {
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
        
        double det = calcularDeterminante(matriz);
        System.out.printf("\nO determinante da matriz é: %.3f\n", det);
        sc.close();
    }

    public static double calcularDeterminante(double[][] matriz) {
        int n = matriz.length;
        if (n == 1) return matriz[0][0];
        if (n == 2) return (matriz[0][0] * matriz[1][1]) - (matriz[0][1] * matriz[1][0]);

        double det = 0;
        for (int j = 0; j < n; j++) {
            double[][] submatriz = criarSubmatriz(matriz, 0, j);
            det += Math.pow(-1, j) * matriz[0][j] * calcularDeterminante(submatriz);
        }
        return det;
    }

    public static double[][] criarSubmatriz(double[][] matriz, int linhaRemovida, int colunaRemovida) {
        int n = matriz.length;
        double[][] submatriz = new double[n - 1][n - 1];
        int r = -1;
        
        for (int i = 0; i < n; i++) {
            if (i == linhaRemovida) continue;
            r++;
            int c = -1;
            for (int j = 0; j < n; j++) {
                if (j == colunaRemovida) continue;
                submatriz[r][++c] = matriz[i][j];
            }
        }
        return submatriz;
    }
}