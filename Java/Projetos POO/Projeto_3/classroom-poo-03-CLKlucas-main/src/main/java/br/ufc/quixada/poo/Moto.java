package br.ufc.quixada.poo;

public class Moto extends Veiculo{
  public Moto(String identificador) {
    super(identificador);
  }

  @Override
  public TipoVaga getTipoVaga(){
    return TipoVaga.MOTO_E_BIKE;
  }

  @Override
  public String getTipoVeiculo(){
    return "moto";
  }
}