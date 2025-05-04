package farmacia.model;

public class Farmaco extends Farmacia {
	private boolean generico;

	public Farmaco(int idProduto, String nomeProduto, int tipoProduto, float preco, boolean generico) {
		super(idProduto, nomeProduto, tipoProduto, preco);
		this.generico = generico;
	}

	public boolean isGenerico() {
		return generico;
	}

	public void setGenerico(boolean generico) {
		this.generico = generico;
	}

	@Override
	public void visualizar() {
		super.visualizar();
		System.out.println("Genérico: " + (this.generico ? "Sim" : "Não"));
	}
}
