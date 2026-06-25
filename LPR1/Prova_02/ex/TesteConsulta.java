package LPR1.Prova_02;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class TesteConsulta {
    public static void main(String[] args) {
        String textoArquivo = "";

        ConsultaAgendada p1 = new ConsultaAgendada(14, 30, 0, 10, 11, 2024, "João", "Dr. Roberto");

        String dadosP1 = "Propriedades P1 -> Paciente: " + p1.getNomePaciente() + " | Medico: " + p1.getNomeMedico() + " | Data: " + p1.getData() + " | Hora: " + p1.getHora() + "\n";
        System.out.println(dadosP1);
        textoArquivo += dadosP1;

        ConsultaAgendada p2 = new ConsultaAgendada();

        String dadosP2 = "Propriedades P2 -> Paciente: " + p2.getNomePaciente() + " | Medico: " + p2.getNomeMedico() + " | Data: " + p2.getData() + " | Hora: " + p2.getHora() + "\n";
        System.out.println(dadosP2);
        textoArquivo += dadosP2;

        System.out.println("\nAlterando P1:");
        p1.setData();
        p1.setHora();
        p1.setNomePaciente();
        p1.setNomeMedico();

        String dadosP1Alterado = "Propriedades P1 (novo) -> Paciente: " + p1.getNomePaciente() + " | Medico: " + p1.getNomeMedico() + " | Data: " + p1.getData() + " | Hora: " + p1.getHora() + "\n";
        System.out.println(dadosP1Alterado);
        textoArquivo += dadosP1Alterado;

        String dadosQtd = "Quantidade final de consultas: " + p1.getAmostra() + "\n";
        System.out.println(dadosQtd);
        textoArquivo += dadosQtd;

        try {
            FileWriter arquivo = new FileWriter("exercicio3.txt");
            PrintWriter gravar = new PrintWriter(arquivo);
            gravar.print(textoArquivo);
            arquivo.close();
            System.out.println("Arquivo exercicio3.txt gerado com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao tentar gravar o arquivo texto.");
        }
    }
}