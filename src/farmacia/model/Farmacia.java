package farmacia.model;

import java.text.NumberFormat;

public class Farmacia {

	// Atributos
	private int idProduto;
	private String nome;
	private int tipoProduto;
	private float preco;

	public Farmacia(int idProduto, String nomeProduto, int tipoProduto, float preco) {
		this.idProduto = idProduto;
		this.nome = nomeProduto;
		this.tipoProduto = tipoProduto;
		this.preco = preco;
	}

	// Getters e Setters
	public int getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getTipoProduto() {
		return tipoProduto;
	}

	public void setTipoProduto(int tipoProduto) {
		this.tipoProduto = tipoProduto;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	// Método visualizar
	public void visualizar() {
		String tipo = switch (this.tipoProduto) {
			case 1 -> "Fármaco";
			case 2 -> "Produto Cosmético";
			default -> "Inválido";
		};

		NumberFormat formatarMoeda = NumberFormat.getCurrencyInstance();

		System.out.println("=====================================");
		System.out.println("Nome: " + this.nome + " | ID: " + this.idProduto);
		System.out.println("Tipo do Produto: " + tipo);
		System.out.println("Valor por Unidade: " + formatarMoeda.format(this.preco));
	}
}
