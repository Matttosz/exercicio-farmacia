package farmacia.repository;

import farmacia.model.Farmacia;

public interface FarmaciaRepository {
	
	public void ProcurarPorId(int IdProduto);
	public void ProcurarPorNome(String Nome);
	public void ListarProdutos();
	public void CadastrarProdutos(Farmacia Farmacia);
	public void AtualizarProduto(Farmacia Farmacia);
	public void DeletarProdutoPorId(int IdProduto);
	
	

}
