package br.ufc.quixada.poo;

public class Bike extends Veiculo{

  public Bike(String identificador) {
    super(identificador);
  }

  @Override
  public TipoVaga getTipoVaga(){
    return TipoVaga.MOTO_E_BIKE;
  }

  @Override
  public String getTipoVeiculo(){
    return "bike";
  }
}