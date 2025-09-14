package br.ufc.quixada.gestao.model;

import br.ufc.quixada.gestao.contrato.IRHService;

public abstract class Funcionario {
    private String cpf;
    private String nome;
    private int diaria;


    public Funcionario(String CPF,String NOME){
        this.cpf = CPF;
        this.nome = NOME;
        this.diaria = 0;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public int getDiaria(){
        return diaria;
    }

    public void setDiarias(int NumeroDiarias){
        this.diaria += NumeroDiarias;
    }

    public double getSalarioMes(){
        return getSalarioBase() + (100 * diaria);
    }

    public abstract boolean getValidacao();

    public abstract double getSalarioBase();

    public abstract IRHService.Tipo getTipoFuncionario();

}