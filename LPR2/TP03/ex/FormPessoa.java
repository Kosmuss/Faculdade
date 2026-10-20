//Feito por Igor Cristiano Bezerra (CB3038408) e Pedro Matias dos Santos Neto(CB3038785)

package LPR1.LPR2.TP03;

import java.awt.*;
import javax.swing.*;


class Pessoa {
    protected static int kp = 0;
    protected String nome;
    protected char sexo;
    protected int idade;

    public Pessoa() {
        kp++;
    }

    public Pessoa(String nome, char sexo, int idade) {
        this.nome = nome;
        this.sexo = sexo;
        this.idade = idade;
        kp++;
    }

    public void setKp() {
        kp++;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getKp() {
        return kp;
    }

    public String getNome() {
        return nome;
    }

    public char getSexo() {
        return sexo;
    }

    public int getIdade() {
        return idade;
    }
}


public class FormPessoa extends JFrame {
    private JTextField txtNumero, txtNome, txtSexo, txtIdade;
    private Pessoa umaPessoa;

    public FormPessoa() {
        setTitle("Exercicio 02 - FormPessoa");
        setSize(300, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2, 5, 5));

        
        add(new JLabel("Numero:"));
        txtNumero = new JTextField(String.valueOf(Pessoa.kp));
        txtNumero.setEditable(false); 
        add(txtNumero);

        add(new JLabel("Nome:"));
        txtNome = new JTextField();
        add(txtNome);

        add(new JLabel("Sexo (M/F):"));
        txtSexo = new JTextField();
        add(txtSexo);

        add(new JLabel("Idade:"));
        txtIdade = new JTextField();
        add(txtIdade);

        // Botões
        JButton btnOk = new JButton("OK");
        JButton btnLimpar = new JButton("Limpar");
        JButton btnMostrar = new JButton("Mostrar");
        JButton btnSair = new JButton("Sair");

        
        btnOk.addActionListener(e -> {
            try {
                String nome = txtNome.getText();
                String sexoStr = txtSexo.getText().toUpperCase();
                String idadeStr = txtIdade.getText();

                
                if (nome.isEmpty() || sexoStr.isEmpty() || idadeStr.isEmpty()) {
                    throw new Exception("Os campos Nome, Sexo e Idade são de preenchimento obrigatório.");
                }
                
                
                if (!sexoStr.equals("M") && !sexoStr.equals("F")) {
                    throw new Exception("O campo Sexo só deve aceitar 'M' ou 'F'.");
                }

                int idade = Integer.parseInt(idadeStr);

                
                umaPessoa = new Pessoa(nome, sexoStr.charAt(0), idade);
                txtNumero.setText(String.valueOf(umaPessoa.getKp())); 
                
                JOptionPane.showMessageDialog(this, "Dados transferidos para o objeto com sucesso!");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "A idade deve ser um número inteiro válido.");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        });

        btnLimpar.addActionListener(e -> {
            txtNome.setText("");
            txtSexo.setText("");
            txtIdade.setText("");
        });

        btnMostrar.addActionListener(e -> {
            if (umaPessoa != null) {
                JOptionPane.showMessageDialog(this, 
                    "Contador (kp): " + umaPessoa.getKp() + 
                    "\nNome: " + umaPessoa.getNome() + 
                    "\nSexo: " + umaPessoa.getSexo() + 
                    "\nIdade: " + umaPessoa.getIdade(),
                    "Dados de UmaPessoa", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Ainda não existem dados transferidos para o objeto.");
            }
        });

        btnSair.addActionListener(e -> System.exit(0));

        
        JPanel painelBotoes1 = new JPanel(new GridLayout(1, 2));
        painelBotoes1.add(btnOk);
        painelBotoes1.add(btnLimpar);

        JPanel painelBotoes2 = new JPanel(new GridLayout(1, 2));
        painelBotoes2.add(btnMostrar);
        painelBotoes2.add(btnSair);

        add(painelBotoes1);
        add(painelBotoes2);

        setVisible(true);
    }

    public static void main(String[] args) {
        
        SwingUtilities.invokeLater(() -> new FormPessoa());
    }
}