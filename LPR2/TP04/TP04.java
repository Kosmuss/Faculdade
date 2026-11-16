// Feito por Igor Cristiano Bezerra (CB3038408) e Pedro Matias dos Santos Neto (CB3038785)

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class TP04 extends JFrame {

    private JTextField txtPesquisa;
    private JButton btnPesquisar;
    private JTextField txtNome;
    private JTextField txtSalario;
    private JTextField txtCargo;
    private JButton btnAnterior;
    private JButton btnProximo;

    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs;

    private final String url = "jdbc:sqlserver://localhost:1433;databaseName=aulajava;encrypt=true;trustServerCertificate=true;";
    private final String usuario = "sa";
    private final String senha = "123";

    public TP04() {
        setTitle("TRABALHO PRATICO 04");
        setSize(420, 240);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        JPanel painelSuperior = new JPanel(new GridLayout(2, 1, 5, 5));
        painelSuperior.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10));

        JPanel linhaBusca = new JPanel(new FlowLayout(FlowLayout.CENTER, 8, 2));
        linhaBusca.add(new JLabel("Nome:"));
        txtPesquisa = new JTextField(22);
        linhaBusca.add(txtPesquisa);

        JPanel linhaBotaoPesquisar = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 2));
        btnPesquisar = new JButton("Pesquisar");
        linhaBotaoPesquisar.add(btnPesquisar);

        painelSuperior.add(linhaBusca);
        painelSuperior.add(linhaBotaoPesquisar);

        JPanel painelCentral = new JPanel(new GridLayout(4, 2, 5, 5));
        painelCentral.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));

        painelCentral.add(new JLabel("Nome:"));
        txtNome = new JTextField();
        txtNome.setEditable(false);
        painelCentral.add(txtNome);

        painelCentral.add(new JLabel("Salário:"));
        txtSalario = new JTextField();
        txtSalario.setEditable(false);
        painelCentral.add(txtSalario);

        painelCentral.add(new JLabel("Cargo:"));
        txtCargo = new JTextField();
        txtCargo.setEditable(false);
        painelCentral.add(txtCargo);

        btnAnterior = new JButton("Anterior");
        btnAnterior.setEnabled(false);
        painelCentral.add(btnAnterior);

        btnProximo = new JButton("Próximo");
        btnProximo.setEnabled(false);
        painelCentral.add(btnProximo);

        add(painelSuperior, BorderLayout.NORTH);
        add(painelCentral, BorderLayout.CENTER);

        conectarBanco();
        configurarEventos();
    }

    private void conectarBanco() {
        try {
            conn = DriverManager.getConnection(url, usuario, senha);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Erro ao conectar ao banco: " + e.getMessage());
        }
    }

    private void configurarEventos() {
        btnPesquisar.addActionListener(e -> pesquisar());

        btnAnterior.addActionListener(e -> {
            try {
                if (rs != null && !rs.isFirst() && rs.previous()) {
                    exibirRegistro();
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Erro ao navegar: " + ex.getMessage());
            }
        });

        btnProximo.addActionListener(e -> {
            try {
                if (rs != null && !rs.isLast() && rs.next()) {
                    exibirRegistro();
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Erro ao navegar: " + ex.getMessage());
            }
        });

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                fecharRecursos();
            }
        });
    }

    private void pesquisar() {
        if (conn == null) {
            JOptionPane.showMessageDialog(this, "Sem conexão com o banco de dados.");
            return;
        }

        try {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }

            String sql = "SELECT f.nome_func, f.sal_func, c.ds_cargo " +
                         "FROM tbfuncs f " +
                         "INNER JOIN tbcargos c ON f.cod_cargo = c.cd_cargo " +
                         "WHERE f.nome_func LIKE ?";

            stmt = conn.prepareStatement(
                sql,
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY
            );
            stmt.setString(1, "%" + txtPesquisa.getText().trim() + "%");

            rs = stmt.executeQuery();

            if (rs.next()) {
                exibirRegistro();
            } else {
                limparCampos();
                JOptionPane.showMessageDialog(this, "Nenhum funcionário encontrado.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erro na pesquisa: " + ex.getMessage());
        }
    }

    private void exibirRegistro() throws SQLException {
        String nome = rs.getString("nome_func");
        double salario = rs.getDouble("sal_func");
        String cargo = rs.getString("ds_cargo");

        txtNome.setText(nome != null ? nome.trim() : "");
        txtSalario.setText(String.format(Locale.US, "%.2f", salario));
        txtCargo.setText(cargo != null ? cargo.trim() : "");

        btnAnterior.setEnabled(!rs.isFirst());
        btnProximo.setEnabled(!rs.isLast());
    }

    private void limparCampos() {
        txtNome.setText("");
        txtSalario.setText("");
        txtCargo.setText("");
        btnAnterior.setEnabled(false);
        btnProximo.setEnabled(false);
    }

    private void fecharRecursos() {
        try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (SQLException ex) {
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TP04().setVisible(true);
        });
    }
}