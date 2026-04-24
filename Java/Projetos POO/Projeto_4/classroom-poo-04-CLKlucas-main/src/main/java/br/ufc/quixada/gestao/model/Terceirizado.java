package br.ufc.quixada.gestao.model;

import br.ufc.quixada.gestao.contrato.IRHService;

public class Terceirizado extends Funcionario{
    private boolean insalubre;


    public Terceirizado(String cpf, String nome, boolean insalubre) {
        super(cpf,nome);
        this.insalubre = insalubre;
    }


    @Override
    public IRHService.Tipo getTipoFuncionario(){
        return IRHService.Tipo.TERC;
    }

    @Override
    public double getSalarioBase(){
        if(insalubre)
            return 1500;

        return 1000;
    }

    @Override
    public int getDiaria(){
        return 0;
    }

    @Override
    public boolean getValidacao() {return true;}
}