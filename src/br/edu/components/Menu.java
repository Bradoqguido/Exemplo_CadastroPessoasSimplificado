package br.edu.components;

import br.edu.models.Cadastro;
import br.edu.models.Fisica;
import br.edu.models.Juridica;
import br.edu.models.Pessoa;

import javax.swing.*;

public class Menu extends JFrame implements Cadastro {
    public static void main(String[] args) {

        // implementar interface grafica
        // e fazer uma classe com as implementacoes necessarias extender a classe JPanel

        Pessoa pessoaFisica = new Fisica();
        pessoaFisica.setNome("pessoa1");
        System.out.println(pessoaFisica.getNome());

        Pessoa pessoaJuridica = new Juridica();
        pessoaJuridica.setNome("pessoa2");
        System.out.println(pessoaJuridica.getNome());
    }

    @Override
    public void cadastrar() {

    }

    @Override
    public void editar() {

    }

    @Override
    public void remover() {

    }

    @Override
    public void listarRegistros(boolean isCPF) {

    }
}
