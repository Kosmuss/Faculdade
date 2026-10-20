package LPR1.LPR2.TP03;

import java.awt.*;
import javax.swing.*;

// Pode apagar esta classe Pessoa se ela já estiver noutro ficheiro do seu projeto
class Pessoa {
    protected static int kp = 0;
    protected String nome;
    protected char sexo;
    protected int idade;

    public Pessoa(String nome, char sexo, int idade) {
        this.nome = nome;
        this.sexo = sexo;
        this.idade = idade;
        kp++;
    }

    public int getKp() { return kp; }
    public String getNome() { return nome; }
    public char getSexo() { return sexo; }
    public int getIdade() { return idade; }
}

public class FormPessoaV3 extends JFrame {
    private JTextField txtNumero, txtNome, txtIdade;
    private JRadioButton rbMasc, rbFem; // Componentes alterados para JRadioButton
    private Pessoa umaPessoa;

    public FormPessoaV3() {
        setTitle("Exercicio 02 - Versão 03 (JRadioButton)");
        setSize(320, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2, 5, 5));

        add(new JLabel("Numero:"));
        txtNumero = new JTextField(String.valueOf(Pessoa.kp));
        txtNumero.setEditable(false);
        add(txtNumero);

        add(new JLabel("Nome:"));
        txtNome = new JTextField();
        add(txtNome);

        add(new JLabel("Sexo:"));
        // Configuração dos JRadioButtons
        JPanel painelSexo = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        rbMasc = new JRadioButton("M", true); // Pré-selecionado
        rbFem = new JRadioButton("F");
        
        // Agrupa os botões para que apenas um seja selecionado
        ButtonGroup bgSexo = new ButtonGroup();
        bgSexo.add(rbMasc);
        bgSexo.add(rbFem);
        
        painelSexo.add(rbMasc);
        painelSexo.add(rbFem);
        add(painelSexo);

        add(new JLabel("Idade:"));
        txtIdade = new JTextField();
        add(txtIdade);

        JButton btnOk = new JButton("OK");
        JButton btnLimpar = new JButton("Limpar");
        JButton btnMostrar = new JButton("Mostrar");
        JButton btnSair = new JButton("Sair");

        btnOk.addActionListener(e -> {
            try {
                String nome = txtNome.getText();
                // Verifica qual RadioButton está selecionado
                char sexo = rbMasc.isSelected() ? 'M' : 'F';
                String idadeStr = txtIdade.getText();

                if (nome.isEmpty() || idadeStr.isEmpty()) {
                    throw new Exception("Os campos Nome e Idade são obrigatórios.");
                }

                int idade = Integer.parseInt(idadeStr);
                umaPessoa = new Pessoa(nome, sexo, idade);
                txtNumero.setText(String.valueOf(umaPessoa.getKp()));
                
                JOptionPane.showMessageDialog(this, "Dados guardados com sucesso!");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "A idade deve ser um número válido.");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        });

        btnLimpar.addActionListener(e -> {
            txtNome.setText("");
            rbMasc.setSelected(true); // Volta para o "M"
            txtIdade.setText("");
        });

        btnMostrar.addActionListener(e -> {
            if (umaPessoa != null) {
                JOptionPane.showMessageDialog(this, 
                    "Contador (kp): " + umaPessoa.getKp() + 
                    "\nNome: " + umaPessoa.getNome() + 
                    "\nSexo: " + umaPessoa.getSexo() + 
                    "\nIdade: " + umaPessoa.getIdade());
            } else {
                JOptionPane.showMessageDialog(this, "Nenhum dado registado.");
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
        SwingUtilities.invokeLater(() -> new FormPessoaV3());
    }
}