package br.edu.models;

import java.util.InputMismatchException;

public class Fisica extends Pessoa {

    private String strNome = "";
    private String strCPF = "";

    public void setCPF(String pCPF) {
        this.strCPF = pCPF;
    }

    public String getCPF() {
        return this.strCPF;
    }

    public String imprimeCPF() {
        return (this.strCPF.substring(0, 3) + "." + this.strCPF.substring(3, 6) + "." +
                this.strCPF.substring(6, 9) + "-" + this.strCPF.substring(9, 11));
    }


    public boolean valida() {
        // considera-se erro CPF's formados por uma sequencia de numeros iguais
        if (this.strCPF.equals("00000000000") ||
            this.strCPF.equals("11111111111") ||
            this.strCPF.equals("22222222222") || this.strCPF.equals("33333333333") ||
            this.strCPF.equals("44444444444") || this.strCPF.equals("55555555555") ||
            this.strCPF.equals("66666666666") || this.strCPF.equals("77777777777") ||
            this.strCPF.equals("88888888888") || this.strCPF.equals("99999999999") ||
            (this.strCPF.length() != 11))
            return false;

        char dig10, dig11;
        int sm, i, r, num, peso;

        // "try" - protege o codigo para eventuais erros de conversao de tipo (int)
        try {
            // Calculo do 1o. Digito Verificador
            sm = 0;
            peso = 10;
            for (i = 0; i < 9; i++) {
                // converte o i-esimo caractere do CPF em um numero:
                // por exemplo, transforma o caractere '0' no inteiro 0
                // (48 eh a posicao de '0' na tabela ASCII)
                num = (int) (this.strCPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig10 = '0';
            else dig10 = (char) (r + 48); // converte no respectivo caractere numerico

            // Calculo do 2o. Digito Verificador
            sm = 0;
            peso = 11;
            for(i = 0; i < 10; i++) {
                num = (int) (this.strCPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig11 = '0';
            else dig11 = (char) (r + 48);

            // Verifica se os digitos calculados conferem com os digitos informados.
            return (dig10 == this.strCPF.charAt(9)) && (dig11 == this.strCPF.charAt(10));

        } catch (InputMismatchException erro) {
            return(false);
        }
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
