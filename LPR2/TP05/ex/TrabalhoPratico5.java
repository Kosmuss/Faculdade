// Feito por Igor Cristiano Bezerra (CB3038408) e Pedro Matias dos Santos Neto (CB3038785)

package LPR1.LPR2.TP05;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class TrabalhoPratico5 extends JFrame {
    private JTextField txtMaximo;
    private JTextField txtPrioridade1;
    private JTextField txtPrioridade2;
    private JButton btnIniciar;
    private JButton btnLimpar;
    private PainelThread painel1;
    private PainelThread painel2;

    public TrabalhoPratico5() {
        super("Trabalho Prático 5");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(520, 420);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        JPanel painelSuperior = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridx = 0;
        gbc.gridy = 0;
        painelSuperior.add(new JLabel("Máximo:"), gbc);

        gbc.gridx = 1;
        txtMaximo = new JTextField("1000", 12);
        painelSuperior.add(txtMaximo, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        painelSuperior.add(new JLabel("Prioridade 1:"), gbc);

        gbc.gridx = 1;
        txtPrioridade1 = new JTextField("1", 12);
        painelSuperior.add(txtPrioridade1, gbc);

        gbc.gridx = 2;
        gbc.gridheight = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        painelSuperior.add(new JLabel("  }   Número entre 1 e 10"), gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridheight = 1;
        gbc.anchor = GridBagConstraints.WEST;
        painelSuperior.add(new JLabel("Prioridade 2:"), gbc);

        gbc.gridx = 1;
        txtPrioridade2 = new JTextField("10", 12);
        painelSuperior.add(txtPrioridade2, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 3;
        gbc.anchor = GridBagConstraints.CENTER;
        btnIniciar = new JButton("Iniciar");
        painelSuperior.add(btnIniciar, gbc);

        add(painelSuperior, BorderLayout.NORTH);

        JPanel painelCentral = new JPanel(new FlowLayout(FlowLayout.CENTER, 90, 10));
        painel1 = new PainelThread();
        painel2 = new PainelThread();
        painelCentral.add(painel1);
        painelCentral.add(painel2);

        add(painelCentral, BorderLayout.CENTER);

        JPanel painelInferior = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 15));
        btnLimpar = new JButton("Limpar");
        painelInferior.add(btnLimpar);

        add(painelInferior, BorderLayout.SOUTH);

        btnIniciar.addActionListener(e -> iniciarThreads());
        btnLimpar.addActionListener(e -> limparCampos());
    }

    private void iniciarThreads() {
        try {
            int max = Integer.parseInt(txtMaximo.getText().trim());
            int p1 = Integer.parseInt(txtPrioridade1.getText().trim());
            int p2 = Integer.parseInt(txtPrioridade2.getText().trim());

            if (p1 < Thread.MIN_PRIORITY || p1 > Thread.MAX_PRIORITY ||
                p2 < Thread.MIN_PRIORITY || p2 > Thread.MAX_PRIORITY) {
                JOptionPane.showMessageDialog(this, "As prioridades devem estar entre 1 e 10.", "Aviso", JOptionPane.WARNING_MESSAGE);
                return;
            }

            if (max <= 0) {
                JOptionPane.showMessageDialog(this, "O valor máximo deve ser maior que zero.", "Aviso", JOptionPane.WARNING_MESSAGE);
                return;
            }

            painel1.configurar(max);
            painel2.configurar(max);

            Thread t1 = new Thread(painel1);
            Thread t2 = new Thread(painel2);

            t1.setPriority(p1);
            t2.setPriority(p2);

            t1.start();
            t2.start();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos com números inteiros válidos.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void limparCampos() {
        txtMaximo.setText("");
        txtPrioridade1.setText("");
        txtPrioridade2.setText("");
        painel1.limpar();
        painel2.limpar();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TrabalhoPratico5().setVisible(true);
        });
    }
}