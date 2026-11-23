// Feito por Igor Cristiano Bezerra (CB3038408) e Pedro Matias dos Santos Neto (CB3038785)

package LPR1.LPR2.TP05;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class PainelThread extends JPanel implements Runnable {
    private DefaultListModel<Integer> listModel;
    private JList<Integer> jList;
    private JLabel lblFinal;
    private int maximo;

    public PainelThread() {
        setLayout(new BorderLayout(5, 5));

        listModel = new DefaultListModel<>();
        jList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(jList);
        scrollPane.setPreferredSize(new Dimension(110, 150));

        lblFinal = new JLabel("Final", SwingConstants.CENTER);
        lblFinal.setVisible(false);

        add(scrollPane, BorderLayout.CENTER);
        add(lblFinal, BorderLayout.SOUTH);
    }

    public void configurar(int maximo) {
        this.maximo = maximo;
        limpar();
    }

    public void limpar() {
        listModel.clear();
        lblFinal.setVisible(false);
    }

    @Override
    public void run() {
        for (int i = 0; i < maximo; i++) {
            final int valor = i;
            SwingUtilities.invokeLater(() -> {
                listModel.addElement(valor);
                jList.ensureIndexIsVisible(listModel.getSize() - 1);
            });
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
        SwingUtilities.invokeLater(() -> lblFinal.setVisible(true));
    }
}