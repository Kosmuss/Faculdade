package LPR1.Prova_02;

import java.util.Scanner;

public class ConsultaAgendada {
    private Data data;
    private Hora hora;
    private String nomePaciente;
    private static int quantidade = 0;
    private String nomeMedico;

    public ConsultaAgendada() {
        this.data = new Data();
        this.hora = new Hora();
        setData();
        setHora();
        setNomePaciente();
        setNomeMedico();
        quantidade++;
    }

    public ConsultaAgendada(int h, int mi, int s, int d, int m, int a, String p, String med) {
        this.hora = new Hora(h, mi, s);
        this.data = new Data(d, m, a);
        this.nomePaciente = p;
        this.nomeMedico = med;
        quantidade++;
    }

    public ConsultaAgendada(Data d, Hora h, String p, String m) {
        this.data = d;
        this.hora = h;
        this.nomePaciente = p;
        this.nomeMedico = m;
        quantidade++;
    }

    public void setData(int a, int b, int c) {
        this.data.setDia(a);
        this.data.setMes(b);
        this.data.setAno(c);
    }

    public void setData() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Dia da consulta: ");
        int d = sc.nextInt();
        System.out.print("Mes da consulta: ");
        int m = sc.nextInt();
        System.out.print("Ano da consulta: ");
        int a = sc.nextInt();
        this.data.setDia(d);
        this.data.setMes(m);
        this.data.setAno(a);
    }

    public void setHora(int a, int b, int c) {
        this.hora.setHora(a);
        this.hora.setMinuto(b);
        this.hora.setSegundo(c);
    }

    public void setHora() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Hora: ");
        int h = sc.nextInt();
        System.out.print("Minuto: ");
        int m = sc.nextInt();
        System.out.print("Segundo: ");
        int s = sc.nextInt();
        this.hora.setHora(h);
        this.hora.setMinuto(m);
        this.hora.setSegundo(s);
    }

    public void setNomePaciente(String p) {
        this.nomePaciente = p;
    }

    public void setNomePaciente() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nome do Paciente: ");
        this.nomePaciente = sc.nextLine();
    }

    public void setNomeMedico(String m) {
        this.nomeMedico = m;
    }

    public void setNomeMedico() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nome do Medico: ");
        this.nomeMedico = sc.nextLine();
    }

    public int getAmostra() {
        return quantidade;
    }

    public String getData() {
        int ultimosDigitosAno = this.data.getAno() % 100;
        return this.data.getDia() + "/" + this.data.getMes() + "/" + ultimosDigitosAno;
    }

    public String getHora() {
        return this.hora.getHora() + ":" + this.hora.getMinuto() + ":" + this.hora.getSegundo();
    }

    public String getNomePaciente() {
        return this.nomePaciente;
    }

    public String getNomeMedico() {
        return this.nomeMedico;
    }
}