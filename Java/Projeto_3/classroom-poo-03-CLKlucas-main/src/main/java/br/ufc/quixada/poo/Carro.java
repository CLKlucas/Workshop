package br.ufc.quixada.poo;

public class Carro extends Veiculo {

  public Carro(String identificador) {
    super(identificador);
  }

  @Override
  public TipoVaga getTipoVaga(){
    return TipoVaga.CARRO;
  }
  @Override
  public String getTipoVeiculo(){
    return "carro";
  }
}