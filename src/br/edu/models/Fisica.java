package br.edu.models;

import java.util.InputMismatchException;

public class Fisica extends Pessoa {

    private String strNome = "";
    private String strCPF = "";

    public Fisica (String pNome, String pDocumento) {
        strNome = pNome;
        strCPF = pDocumento;
    }

    public String getCPF() {
        return this.strCPF;
    }

    public String imprimeCPF() {
        return (this.strCPF.substring(0, 3) + "." + this.strCPF.substring(3, 6) + "." +
                this.strCPF.substring(6, 9) + "-" + this.strCPF.substring(9, 11));
    }

    @Override
    public String getNome() {
        return this.strNome;
    }

}
