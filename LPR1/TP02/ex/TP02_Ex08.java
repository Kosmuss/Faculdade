/*8. Entrar via teclado com doze valores e armazená-los em uma matriz de ordem 3x4. Após a
digitação dos valores solicitar uma constante multiplicativa, que deverá multiplicar cada
valor matriz e armazenar o resultado em outra matriz de mesma ordem, nas posições
correspondentes. Exibir as matrizes na tela, sob a forma matricial, ou seja, linhas por
colunas. 

Exercício feito por Igor Cristiano Bezerra (CB3038408) e Pedro Matias dos Santos Neto (CB3038785)*/

package LPR1.TP02;
import java.util.Scanner;

public class TP02_Ex08 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] matrizA = new int[3][4];
        int[][] matrizB = new int[3][4];
        
        System.out.println("Digite 12 valores para a matriz 3x4:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print("Posição [" + i + "][" + j + "]: ");
                matrizA[i][j] = sc.nextInt();
            }
        }
        
        System.out.print("\nDigite uma constante multiplicativa: ");
        int constante = sc.nextInt();
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                matrizB[i][j] = matrizA[i][j] * constante;
            }
        }
        
        System.out.println("\nMatriz Original:");
        imprimirMatriz(matrizA);
        
        System.out.println("\nMatriz Resultante:");
        imprimirMatriz(matrizB);
        
        sc.close();
    }
    
    public static void imprimirMatriz(int[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                System.out.print(m[i][j] + "\t");
            }
            System.out.println();
        }
    }
}