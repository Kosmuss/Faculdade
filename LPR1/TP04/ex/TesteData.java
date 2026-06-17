package LPR1.TP04;

public class TesteData {
    public static void main(String[] args) {
        System.out.println("==== TESTE DA CLASSE DATA ====\n");

        System.out.println("1. Criando data com parâmetros (25/12/2023)...");
        Data dataNatal = new Data(25, 12, 2023);
        System.out.println("Formato mostra1(): " + dataNatal.mostra1());
        System.out.println("Formato mostra2(): " + dataNatal.mostra2());
        System.out.println("Dias transcorridos: " + dataNatal.diasTranscorridos());
        System.out.println("É ano bissexto? " + (dataNatal.bissexto() ? "Sim" : "Não"));
        System.out.println();

        System.out.println("2. Criando data através do construtor sem parâmetros (interativo):");
        Data dataUsuario = new Data();
        System.out.println("Você digitou a data: " + dataUsuario.mostra2());
        System.out.println("Dias transcorridos neste ano até a data informada: " + dataUsuario.diasTranscorridos());
        System.out.println();

        System.out.println("3. Alterando os dados da data inicial via código (para 29/02/2024)...");
        dataNatal.entraAno(2024);
        dataNatal.entraMes(2);
        dataNatal.entraDia(29);
        System.out.println("Nova data: " + dataNatal.mostra1());
        System.out.println("É ano bissexto? " + (dataNatal.bissexto() ? "Sim" : "Não"));
        System.out.println();

        System.out.println("4. Alterando o mês interativamente para a data: " + dataUsuario.mostra1());
        dataUsuario.entraMes();
        System.out.println("A data atualizada ficou: " + dataUsuario.mostra2());
        System.out.println();

        System.out.println("5. Teste de impressão da Data Atual do Sistema:");
        dataUsuario.apresentaDataAtual();
        
        System.out.println("\n==== FIM DOS TESTES ====");
    }
}