package br.edu.models;

public interface Cadastro {

    public void cadastrar();

    public void editar();

    public void remover();

    // se for CPF lista os registros de pessoa fisica, caso contrario, lista os registros de pessoa juridica.
    public void listarRegistros(boolean isCPF);
}
