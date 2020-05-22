package br.edu.components;

import br.edu.Controllers.Controller;
import br.edu.models.Fisica;
import br.edu.models.Juridica;
import br.edu.models.Pessoa;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    private JList lstRegistros;

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

        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void listeners() {
        btnRadioCNPJ.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnRadioCPF.setSelected(false);
            }
        });

        btnRadioCPF.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnRadioCNPJ.setSelected(false);
            }
        });

        btnAddRegistro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.inserirRegistro(txtNome.getText(), txtDocumento.getText(), btnRadioCPF.isSelected());

                txtNome.setText("");
                txtDocumento.setText("");
                btnRadioCPF.setSelected(false);
            }
        });
    }

    private void listarRegistrosDeCPF() {}

    private void listarRegistrosDeCNPJ() {}
}
