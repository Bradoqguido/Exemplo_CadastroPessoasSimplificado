package br.edu.components;

import br.edu.Controllers.Controller;
import br.edu.models.Fisica;
import br.edu.models.Juridica;
import br.edu.models.Pessoa;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class FrmMenu extends JFrame {

    private JPanel pnlFields;
    private JPanel pnlNome;
    private JLabel lblNome;
    private JTextField txtNome;
    private JPanel pnlDocumento;
    private JLabel lblDocumento;
    private JTextField txtDocumento;
    private JPanel pnlActions;
    private JButton btnAddRegistro;
    private JRadioButton btnRadioCPF;
    private JRadioButton btnRadioCNPJ;
    private JTextArea txtRegistros;

    private Controller controller;

    public static void main(String[] args) {
        new FrmMenu();
    }

    public FrmMenu() {
        inicializarComponents();
        listeners();
    }

    private void inicializarComponents() {
        controller = new Controller();

        getContentPane().setLayout(new BorderLayout(0, 0));

        pnlFields = new JPanel();
        pnlFields.setLayout(new BorderLayout(0, 0));

        pnlNome = new JPanel(new BorderLayout(0,0));
            lblNome = new JLabel("Nome:");
            pnlNome.add(lblNome, BorderLayout.WEST);
            txtNome = new JTextField();
            pnlNome.add(txtNome, BorderLayout.CENTER);
        pnlFields.add(pnlNome, BorderLayout.NORTH);

        pnlDocumento = new JPanel(new BorderLayout(0,0));
            lblDocumento = new JLabel("Documento:");
            pnlDocumento.add(lblDocumento, BorderLayout.WEST);
            txtDocumento = new JTextField();
            pnlDocumento.add(txtDocumento, BorderLayout.CENTER);
        pnlFields.add(pnlDocumento, BorderLayout.CENTER);

        pnlActions = new JPanel(new BorderLayout(0,0));
            btnRadioCPF = new JRadioButton("CPF");
            pnlActions.add(btnRadioCPF, BorderLayout.WEST);
            btnRadioCNPJ = new JRadioButton("CNPJ");
            pnlActions.add(btnRadioCNPJ, BorderLayout.CENTER);
            btnAddRegistro = new JButton("Inserir");
            pnlActions.add(btnAddRegistro, BorderLayout.EAST);
        pnlFields.add(pnlActions, BorderLayout.SOUTH);

        getContentPane().add(pnlFields, BorderLayout.NORTH);

        txtRegistros = new JTextArea();
        getContentPane().add(txtRegistros, BorderLayout.CENTER);

        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void listeners() {
        btnRadioCNPJ.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnRadioCPF.setSelected(false);
                listarRegistrosDeCPF();
            }
        });

        btnRadioCPF.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnRadioCNPJ.setSelected(false);
                listarRegistrosDeCNPJ();
            }
        });

        btnAddRegistro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (btnRadioCPF.isSelected()) {
                    if (controller.validarCPF(txtDocumento.getText())) {
                        controller.inserirRegistroComCPF(txtNome.getText(), txtDocumento.getText());
                    } else {
                        JOptionPane.showMessageDialog(null, "CPF inválido!");
                    }
                    listarRegistrosDeCPF();
                }

                if (btnRadioCNPJ.isSelected()) {
                    if (controller.validarCNPJ(txtDocumento.getText())) {
                        controller.inserirRegistroComCNPJ(txtNome.getText(), txtDocumento.getText());
                    } else {
                        JOptionPane.showMessageDialog(null, "CNPJ inválido!");
                    }
                    listarRegistrosDeCNPJ();
                }

                txtNome.setText("");
                txtDocumento.setText("");
            }
        });
    }

    private void listarRegistrosDeCPF() {
        txtRegistros.setText("");
        List<Fisica> pessoas = controller.getPessoas();
        StringBuilder stbPessoas = new StringBuilder();

        for (Fisica pessoa : pessoas) {
            stbPessoas.append("\nNome:")
                    .append(pessoa.getNome())
                    .append(" - CPF: ").append(pessoa.getCPF());
        }
        txtRegistros.setText(stbPessoas.toString());
    }

    private void listarRegistrosDeCNPJ() {
        txtRegistros.setText("");
        List<Juridica> pessoas = controller.getPessoas();
        StringBuilder stbPessoas = new StringBuilder();

        for (Juridica pessoa : pessoas) {
            stbPessoas.append("\nNome:")
                    .append(pessoa.getNome())
                    .append(" - CNPJ: ").append(pessoa.getCNPJ());
        }
        txtRegistros.setText(stbPessoas.toString());
    }
}
