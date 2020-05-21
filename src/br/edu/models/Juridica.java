package br.edu.models;

import java.util.InputMismatchException;

public class Juridica extends Pessoa {

    private String strNome = "";
    private String strCNPJ = "";

    public boolean validaCNPJ() {
        // considera-se erro CNPJ's formados por uma sequencia de numeros iguais
        if (this.strCNPJ.equals("00000000000000") || this.strCNPJ.equals("11111111111111") ||
            this.strCNPJ.equals("22222222222222") || this.strCNPJ.equals("33333333333333") ||
            this.strCNPJ.equals("44444444444444") || this.strCNPJ.equals("55555555555555") ||
            this.strCNPJ.equals("66666666666666") || this.strCNPJ.equals("77777777777777") ||
            this.strCNPJ.equals("88888888888888") || this.strCNPJ.equals("99999999999999") ||
            (this.strCNPJ.length() != 14))
            return false;

        char dig13, dig14;
        int sm, i, r, num, peso;

        // "try" - protege o código para eventuais erros de conversao de tipo (int)
        try {
            // Calculo do 1o. Digito Verificador
            sm = 0;
            peso = 2;
            for (i = 11; i >= 0; i--) {
            // converte o i-ésimo caractere do CNPJ em um número:
            // por exemplo, transforma o caractere '0' no inteiro 0
            // (48 eh a posição de '0' na tabela ASCII)
                num = (int) (this.strCNPJ.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso + 1;
                if (peso == 10)
                    peso = 2;
            }

            r = sm % 11;
            if ((r == 0) || (r == 1))
                dig13 = '0';
            else dig13 = (char) ((11 - r) + 48);

            // Calculo do 2o. Digito Verificador
            sm = 0;
            peso = 2;
            for (i = 12; i >= 0; i--) {
                num = (int) (this.strCNPJ.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso + 1;
                if (peso == 10)
                    peso = 2;
            }

            r = sm % 11;
            if ((r == 0) || (r == 1))
                dig14 = '0';
            else dig14 = (char) ((11 - r) + 48);

            // Verifica se os dígitos calculados conferem com os dígitos informados.
            return (dig13 == this.strCNPJ.charAt(12)) && (dig14 == this.strCNPJ.charAt(13));

        } catch (InputMismatchException erro) {
            return false;
        }
    }

    public void setCNPJ(String pCNPJ) {
        this.strCNPJ = pCNPJ;
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
