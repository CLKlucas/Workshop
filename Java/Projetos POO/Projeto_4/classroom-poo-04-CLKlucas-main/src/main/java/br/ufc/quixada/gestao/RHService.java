package br.ufc.quixada.gestao;

import br.ufc.quixada.gestao.model.Funcionario;
import br.ufc.quixada.gestao.contrato.IRHService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class RHService implements IRHService {
    private ArrayList<Funcionario> ListaTotalFuncionarios = new ArrayList<>();
    private double Lucros;



    @Override
    public boolean cadastrar(Funcionario funcionario) {
        for (int i = 0;i < ListaTotalFuncionarios.size(); i++) {
            if (ListaTotalFuncionarios.get(i).getCpf().equals(funcionario.getCpf()))
                return false;

// Bruno estou abismado que arrayList não tem null quando inicializado
// tava querendo fazer igual à atividade do estacionamento que usa uma lista padrão, mas
// não dá porque não tem null para comparar
        }

        if(!funcionario.getValidacao())
            return false;


        ListaTotalFuncionarios.add(funcionario);
        return true;

    }
    @Override
    public boolean remover(String cpf) {
        for(int i = 0;i < ListaTotalFuncionarios.size();i++){
            if (ListaTotalFuncionarios.get(i).getCpf().equals(cpf)){
                ListaTotalFuncionarios.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public Funcionario obterFuncionario(String cpf) {
        for (int i = 0;i< ListaTotalFuncionarios.size();i++){
            if (ListaTotalFuncionarios.get(i).getCpf().equals(cpf))
                return ListaTotalFuncionarios.get(i);
        }
        return null;
    }

    @Override
    public List<Funcionario> getFuncionarios() {
        ListaTotalFuncionarios.sort(Comparator.comparing(Funcionario::getNome));
        return ListaTotalFuncionarios;

    }

    @Override
    public List<Funcionario> getFuncionariosPorCategoria(Tipo tipo) {
        List<Funcionario> ListarCategoria = new ArrayList<>();
        for (int i = 0;i < ListaTotalFuncionarios.size();i++){
            if (ListaTotalFuncionarios.get(i).getTipoFuncionario().equals(tipo)){
                ListarCategoria.add(ListaTotalFuncionarios.get(i));
            }
        }
        ListarCategoria.sort(Comparator.comparing(Funcionario::getNome));
        return ListarCategoria;
    }

    @Override
    public int getTotalFuncionarios() {
        return ListaTotalFuncionarios.size();
    }

    @Override
    public boolean solicitarDiaria(String cpf) {

        for (int i = 0;i < ListaTotalFuncionarios.size();i++){
            if(ListaTotalFuncionarios.get(i).getCpf().equals(cpf)){

                if(ListaTotalFuncionarios.get(i).getTipoFuncionario().equals(Tipo.TERC))
                    return false;

                else if(ListaTotalFuncionarios.get(i).getTipoFuncionario().equals(Tipo.PROF)){
                    if (ListaTotalFuncionarios.get(i).getDiaria() != 3){
                        ListaTotalFuncionarios.get(i).setDiarias(1);
                        return true;
                    }
                }
                else{
                    if (ListaTotalFuncionarios.get(i).getDiaria() != 1) {
                        ListaTotalFuncionarios.get(i).setDiarias(1);
                        return true;
                    }
                }

            }
        }
        return false;
    }

    @Override
    public void partilharLucros(double valor) {
        Lucros = valor / ListaTotalFuncionarios.size();

    }

    @Override
    public void iniciarMes() {
        for (int i = 0; i < ListaTotalFuncionarios.size(); i++) {
            ListaTotalFuncionarios.get(i).setDiarias(0);
        }
        Lucros = 0;
    }
    @Override
    public Double calcularSalarioDoFuncionario(String cpf) {
        for (int i = 0; i < ListaTotalFuncionarios.size(); i++) {
            if (ListaTotalFuncionarios.get(i).getCpf().equals(cpf)) {
               return ListaTotalFuncionarios.get(i).getSalarioMes() + Lucros;

            }
        }
        return null;
    }
    @Override
    public double calcularFolhaDePagamento() {
        double folhaPagamento = 0;
        for (int i = 0; i < ListaTotalFuncionarios.size(); i++) {
            folhaPagamento += calcularSalarioDoFuncionario(ListaTotalFuncionarios.get(i).getCpf());
        }
        return folhaPagamento;
    }
}