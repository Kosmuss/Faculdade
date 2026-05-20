/*Exercício feito por Igor Cristiano Bezerra (CB3038408) e Pedro Matias dos Santos Neto (CB3038785)*/


package LPR1.TP03;
import java.util.Scanner;

public class TP03_Ex01 {
    private int hora;
    private int min;
    private int seg;

    public TP03_Ex01() {
        setHor();
        setMin();
        setSeg();
    }

    public TP03_Ex01(int h, int m, int s) {
        setHor(h);
        setMin(m);
        setSeg(s);
    }

    public void setHor(int h) {
        if (h >= 0 && h <= 23) {
            this.hora = h;
        } else {
            this.hora = 0;
        }
    }

    public void setMin(int m) {
        if (m >= 0 && m <= 59) {
            this.min = m;
        } else {
            this.min = 0;
        }
    }

    public void setSeg(int s) {
        if (s >= 0 && s <= 59) {
            this.seg = s;
        } else {
            this.seg = 0;
        }
    }

    public void setHor() {
        Scanner sc = new Scanner(System.in);
        boolean valido = false;
        while (!valido) {
            try {
                System.out.print("Digite a hora: ");
                int h = Integer.parseInt(sc.nextLine());
                if (h >= 0 && h <= 23) {
                    this.hora = h;
                    valido = true;
                } else {
                    System.out.println("Hora invalida. Digite novamente.");
                }
            } catch (Exception e) {
                System.out.println("Erro de digitacao. Informe um numero inteiro.");
            }
        }
    }

    public void setMin() {
        Scanner sc = new Scanner(System.in);
        boolean valido = false;
        while (!valido) {
            try {
                System.out.print("Digite os minutos: ");
                int m = Integer.parseInt(sc.nextLine());
                if (m >= 0 && m <= 59) {
                    this.min = m;
                    valido = true;
                } else {
                    System.out.println("Minuto invalido. Digite novamente.");
                }
            } catch (Exception e) {
                System.out.println("Erro de digitacao. Informe um numero inteiro.");
            }
        }
    }

    public void setSeg() {
        Scanner sc = new Scanner(System.in);
        boolean valido = false;
        while (!valido) {
            try {
                System.out.print("Digite os segundos: ");
                int s = Integer.parseInt(sc.nextLine());
                if (s >= 0 && s <= 59) {
                    this.seg = s;
                    valido = true;
                } else {
                    System.out.println("Segundo invalido. Digite novamente.");
                }
            } catch (Exception e) {
                System.out.println("Erro de digitacao. Informe um numero inteiro.");
            }
        }
    }

    public int getHor() {
        return this.hora;
    }

    public int getMin() {
        return this.min;
    }

    public int getSeg() {
        return this.seg;
    }

    public String getHora1() {
        return String.format("%02d:%02d:%02d", this.hora, this.min, this.seg);
    }

    public String getHora2() {
        int h12 = this.hora % 12;
        if (h12 == 0) {
            h12 = 12;
        }
        String ampm = (this.hora < 12) ? "AM" : "PM";
        return String.format("%02d:%02d:%02d (%s)", h12, this.min, this.seg, ampm);
    }

    public int getSegundos() {
        return (this.hora * 3600) + (this.min * 60) + this.seg;
    }
}