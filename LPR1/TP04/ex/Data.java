package LPR1.TP04;

import java.text.DateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Data {
    
    private int dia;
    private int mes;
    private int ano;

    public Data() {
        Scanner sc = new Scanner(System.in);
        boolean dadosValidos = false;
        
        System.out.println("--- Inicializando Nova Data ---");
        while (!dadosValidos) {
            try {
                System.out.print("Digite o dia: ");
                int d = sc.nextInt();
                System.out.print("Digite o mês: ");
                int m = sc.nextInt();
                System.out.print("Digite o ano: ");
                int a = sc.nextInt();

                if (isDataValida(d, m, a)) {
                    this.dia = d;
                    this.mes = m;
                    this.ano = a;
                    dadosValidos = true;
                } else {
                    System.out.println("Erro: Data inválida! Por favor, redigite.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro: Entrada inconsistente. Digite apenas números inteiros.");
                sc.nextLine();
            }
        }
    }

    public Data(int d, int m, int a) {
        if (isDataValida(d, m, a)) {
            this.dia = d;
            this.mes = m;
            this.ano = a;
        } else {
            System.out.println("Valores fornecidos são inválidos. Inicializando com 01/01/1900 por padrão.");
            this.dia = 1;
            this.mes = 1;
            this.ano = 1900;
        }
    }

    public void entraDia(int d) {
        if (isDataValida(d, this.mes, this.ano)) {
            this.dia = d;
        } else {
            System.out.println("Erro: O dia " + d + " é inválido para o mês/ano atual.");
        }
    }

    public void entraMes(int m) {
        if (isDataValida(this.dia, m, this.ano)) {
            this.mes = m;
        } else {
            System.out.println("Erro: O mês " + m + " é inválido para o dia/ano atual.");
        }
    }

    public void entraAno(int a) {
        if (isDataValida(this.dia, this.mes, a)) {
            this.ano = a;
        } else {
            System.out.println("Erro: Ano inválido.");
        }
    }

    public void entraDia() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Digite um novo dia: ");
                int d = sc.nextInt();
                if (isDataValida(d, this.mes, this.ano)) {
                    this.dia = d;
                    break;
                } else {
                    System.out.println("Erro: Dia inválido. Redigite.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro: Entrada inválida.");
                sc.nextLine();
            }
        }
    }

    public void entraMes() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Digite um novo mês: ");
                int m = sc.nextInt();
                if (isDataValida(this.dia, m, this.ano)) {
                    this.mes = m;
                    break;
                } else {
                    System.out.println("Erro: Mês inválido. Redigite.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro: Entrada inválida.");
                sc.nextLine();
            }
        }
    }

    public void entraAno() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Digite um novo ano: ");
                int a = sc.nextInt();
                if (isDataValida(this.dia, this.mes, a)) {
                    this.ano = a;
                    break;
                } else {
                    System.out.println("Erro: Ano inválido. Redigite.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro: Entrada inválida.");
                sc.nextLine();
            }
        }
    }

    public int retDia() {
        return this.dia;
    }

    public int retMes() {
        return this.mes;
    }

    public int retAno() {
        return this.ano;
    }

    public String mostra1() {
        return String.format("%02d/%02d/%04d", this.dia, this.mes, this.ano);
    }

    public String mostra2() {
        String[] meses = {
            "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", 
            "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"
        };
        return String.format("%02d/%s/%04d", this.dia, meses[this.mes - 1], this.ano);
    }

    public boolean bissexto() {
        return (this.ano % 4 == 0 && this.ano % 100 != 0) || (this.ano % 400 == 0);
    }

    public int diasTranscorridos() {
        int diasTotais = 0;
        for (int i = 1; i < this.mes; i++) {
            if (i == 4 || i == 6 || i == 9 || i == 11) {
                diasTotais += 30;
            } else if (i == 2) {
                diasTotais += bissexto() ? 29 : 28;
            } else {
                diasTotais += 31;
            }
        }
        diasTotais += this.dia;
        return diasTotais;
    }

    public void apresentaDataAtual() {
        Date dataAtual = new Date();
        DateFormat df = DateFormat.getDateInstance(DateFormat.FULL);
        System.out.println("Data Atual do Sistema: " + df.format(dataAtual));
    }
    
    private boolean isDataValida(int d, int m, int a) {
        if (a < 1 || m < 1 || m > 12 || d < 1) {
            return false;
        }
        int maxDias = 31;
        if (m == 4 || m == 6 || m == 9 || m == 11) {
            maxDias = 30;
        } else if (m == 2) {
            boolean isBissexto = (a % 4 == 0 && a % 100 != 0) || (a % 400 == 0);
            maxDias = isBissexto ? 29 : 28;
        }
        return d <= maxDias;
    }
}