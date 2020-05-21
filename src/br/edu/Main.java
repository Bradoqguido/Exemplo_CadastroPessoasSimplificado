package br.edu;

import br.edu.models.Fisica;
import br.edu.models.Juridica;
import br.edu.models.Pessoa;

public class Main {
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
}
