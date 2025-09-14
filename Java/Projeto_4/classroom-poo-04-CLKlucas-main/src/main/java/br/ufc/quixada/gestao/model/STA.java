package br.ufc.quixada.gestao.model;

import br.ufc.quixada.gestao.contrato.IRHService;

public class STA extends Funcionario{
    private int nivel;


    public STA(String cpf, String nome, int nivel) {
        super(cpf,nome);
        this.nivel = nivel;

    }

    @Override
    public boolean getValidacao() {
        return nivel >= 0 && nivel <= 30;



    }
    @Override
    public IRHService.Tipo getTipoFuncionario(){
        return IRHService.Tipo.STA;
    }

    @Override
    public double getSalarioBase(){
        return 1000 + (100 * nivel);
    }



}