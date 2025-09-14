package br.ufc.quixada.gestao.model;

import br.ufc.quixada.gestao.contrato.IRHService;

public class Professor extends Funcionario {
    private char classe;


    public Professor(String cpf, String nome, char classe) {
        super(cpf,nome);
        this.classe = classe;

    }

    @Override
    public boolean getValidacao() {
        return classe == 'A' || classe == 'B' || classe == 'C' || classe == 'D' || classe == 'E';



    }

    @Override
    public IRHService.Tipo getTipoFuncionario(){ return IRHService.Tipo.PROF; }

    @Override
    public double getSalarioBase(){
        if (classe == 'A')
            return 3000;
        else if (classe == 'B')
            return 5000;
        else if (classe == 'C')
            return 7000;
        else if (classe == 'D')
            return 9000;
        else
            return 11000;
    }



}
