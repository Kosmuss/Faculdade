//Feito por Igor Cristiano Bezerra (CB3038408) e Pedro Matias dos Santos Neto(CB3038785)

package LPR1.LPR2.TP03;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Calculadora extends JFrame implements ActionListener {
    private JTextField display;
    private double num1 = 0, num2 = 0, resultado = 0;
    private char operador;

    public Calculadora() {
        setTitle("Calcul...");
        setSize(250, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        display = new JTextField("0");
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false);
        add(display, BorderLayout.NORTH);

        JPanel painelBotoes = new JPanel();
        painelBotoes.setLayout(new GridLayout(5, 4, 2, 2));

        String[] botoes = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+",
            "C", "", "", ""
        };

        for (String texto : botoes) {
            JButton botao = new JButton(texto);
            if (!texto.isEmpty()) {
                botao.addActionListener(this);
            } else {
                botao.setVisible(false);
            }
            painelBotoes.add(botao);
        }

        add(painelBotoes, BorderLayout.CENTER);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();

        try {
            if ("0123456789.".contains(comando)) {
                if (display.getText().equals("0")) {
                    display.setText(comando);
                } else {
                    display.setText(display.getText() + comando);
                }
            } else if ("/*-+".contains(comando)) {
                num1 = Double.parseDouble(display.getText());
                operador = comando.charAt(0);
                display.setText("0");
            } else if ("=".equals(comando)) {
                num2 = Double.parseDouble(display.getText());
                switch (operador) {
                    case '+': resultado = num1 + num2; break;
                    case '-': resultado = num1 - num2; break;
                    case '*': resultado = num1 * num2; break;
                    case '/': 
                        if (num2 == 0) throw new ArithmeticException("Divisão por zero");
                        resultado = num1 / num2; 
                        break;
                }
                display.setText(String.valueOf(resultado));
            } else if ("C".equals(comando)) {
                num1 = 0;
                num2 = 0;
                resultado = 0;
                display.setText("0");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Erro de formatação de número.", "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (ArithmeticException ex) {
            JOptionPane.showMessageDialog(this, "Impossível dividir por zero.", "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Ocorreu um erro inesperado.", "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            System.out.println("Operação processada: " + comando);
        }
    }

    public static void main(String[] args) {
        new Calculadora();
    }
}