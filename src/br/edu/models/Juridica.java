package br.edu.models;

import java.util.InputMismatchException;

public class Juridica extends Pessoa {

    private String strNome = "";
    private String strCNPJ = "";

    public Juridica (String pNome, String pDocumento) {
        strNome = pNome;
        strCNPJ = pDocumento;
    }

    public String getCNPJ() {
        return this.strCNPJ;
    }

    public String imprimeCNPJ() {
        // máscara do CNPJ: 99.999.999.9999-99
        return (this.strCNPJ.substring(0, 2) + "." + this.strCNPJ.substring(2, 5) + "." +
                this.strCNPJ.substring(5, 8) + "." + this.strCNPJ.substring(8, 12) + "-" +
                this.strCNPJ.substring(12, 14));
    }

    @Override
    public void setNome(String pNome) {
        this.strNome = pNome;
    }

    @Override
    public String getNome() {
        return this.strNome;
    }
}
