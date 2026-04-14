/*6. Armazenar seis nomes em uma matriz de ordem 2x3. Apresentar os nomes na tela. 

Exercício feito por Igor Cristiano Bezerra (CB3038408) e Pedro Matias dos Santos Neto (CB3038785)*/

package LPR1.TP02;
import java.util.Scanner;

public class TP02_Ex06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[][] matriz = new String[2][3];
        
        System.out.println("Digite 6 nomes para a matriz 2x3:");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("Nome [" + i + "][" + j + "]: ");
                matriz[i][j] = sc.next();
            }
        }
        
        System.out.println("\nMatriz de Nomes:");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println();
        }
        sc.close();
    }
}