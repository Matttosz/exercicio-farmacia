package farmacia.model;

public class Cosmetico extends Farmacia{
	
	private String fragancia;

	public Cosmetico(int IdProduto, String NomeProduto, int TipoProduto, float Preco, String Fragancia) {
		super(IdProduto, NomeProduto, TipoProduto, Preco);
		this.fragancia = Fragancia;		
	}

	public String getFragancia() {
		return fragancia;
	}

	public void setFragancia(String fragancia) {
		this.fragancia = fragancia;
	}

	@Override
	public void visualizar() {
		super.visualizar();
		System.out.println("Fragância: " + fragancia );
	}
	

}
