package br.edu.Controllers;

import br.edu.models.Fisica;
import br.edu.models.Juridica;
import br.edu.models.Pessoa;
import br.edu.models.Validadores;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class Controller implements Validadores {

    private List<Pessoa> pessoas = new ArrayList<>();

    public void inserirRegistro(String nome, String documento, boolean isCpf) {
        if (isCpf) {
            pessoas.add(new Fisica(nome, documento));
        } else {
            pessoas.add(new Juridica(nome, documento));
        }
    }

    @Override
    public boolean validarCPF(String pCPF) {
        // considera-se erro CPF's formados por uma sequencia de numeros iguais
        if (pCPF.equals("00000000000") ||
            pCPF.equals("11111111111") ||
            pCPF.equals("22222222222") ||pCPF.equals("33333333333") ||
            pCPF.equals("44444444444") ||pCPF.equals("55555555555") ||
            pCPF.equals("66666666666") ||pCPF.equals("77777777777") ||
            pCPF.equals("88888888888") ||pCPF.equals("99999999999") ||
            (pCPF.length() != 11))
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
                num = (int) (pCPF.charAt(i) - 48);
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
                num = (int) (pCPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig11 = '0';
            else dig11 = (char) (r + 48);

            // Verifica se os digitos calculados conferem com os digitos informados.
            return (dig10 ==pCPF.charAt(9)) && (dig11 ==pCPF.charAt(10));

        } catch (InputMismatchException erro) {
            return(false);
        }
    }

    @Override
    public boolean validarCNPJ(String pCNPJ) {
        // considera-se erro CNPJ's formados por uma sequencia de numeros iguais
        if (pCNPJ.equals("00000000000000") || pCNPJ.equals("11111111111111") ||
            pCNPJ.equals("22222222222222") || pCNPJ.equals("33333333333333") ||
            pCNPJ.equals("44444444444444") || pCNPJ.equals("55555555555555") ||
            pCNPJ.equals("66666666666666") || pCNPJ.equals("77777777777777") ||
            pCNPJ.equals("88888888888888") || pCNPJ.equals("99999999999999") ||
            (pCNPJ.length() != 14))
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
                num = (int) (pCNPJ.charAt(i) - 48);
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
                num = (int) (pCNPJ.charAt(i) - 48);
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
            return (dig13 == pCNPJ.charAt(12)) && (dig14 == pCNPJ.charAt(13));

        } catch (InputMismatchException erro) {
            return false;
        }
    }
}
