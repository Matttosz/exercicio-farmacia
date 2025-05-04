package farmacia.controller;
import java.util.ArrayList;
import farmacia.model.Farmacia;
import farmacia.repository.FarmaciaRepository;

public class FarmaciaController implements FarmaciaRepository{
	
	private ArrayList<Farmacia> listaProdutos = new ArrayList<Farmacia>();
	
	boolean encontrado = false;
	int ControleProdutos = 0;

	@Override
	public void ProcurarPorId(int IdProduto) {
		
		var farma = buscarNaCollection(IdProduto);
		
		if(farma != null)
		{
			farma.visualizar();
		}	
		else 
		{
			System.out.printf("\n A conta não foi encontrada!");
		}	
	}
	@Override
	public void ProcurarPorNome(String Nome) {
		
		for (Farmacia produto : listaProdutos) 
		{ 
	        if (produto.getNome().toLowerCase().contains(Nome.toLowerCase())) 
	        {
	            produto.visualizar();
	            encontrado = true;
	        }
	    }
	    if (!encontrado) 
	    {
	        System.out.println("Nenhum produto com nome parecido a '" + Nome + "' foi encontrado.");
	    }		
	}

	@Override
	public void ListarProdutos() {
		for (var farma : listaProdutos)
		{
			farma.visualizar();
		}		
	}

	@Override
	public void CadastrarProdutos(Farmacia Farmacia) 
	{
		listaProdutos.add(Farmacia);
        System.out.println("||================||");
		System.out.println("||Conta Adicionada||");		
        System.out.println("||================||");

	}

	@Override
	public void AtualizarProduto(Farmacia Farmacia) {
		
	}

	@Override
	public void DeletarProdutoPorId(int IdProduto) 
	{				
	    for (int remover = 0; remover < listaProdutos.size(); remover++) {
	        if (listaProdutos.get(remover).getIdProduto() == IdProduto) 
	        {
	            listaProdutos.remove(remover);
	            System.out.println("Produto com ID " + IdProduto + " foi removido com sucesso.");
	            encontrado = true;
	        break;
	        }
	    }
	    if (!encontrado) 
	    {
	        System.out.println("Produto com ID " + IdProduto + " não foi encontrado.");
	    }	
	}
	
	public int gerarId() 
	{
		return ++ ControleProdutos;
	}
	
	public Farmacia buscarNaCollection(int numero) 
	{
		for ( var farma : listaProdutos) 
		{
			if(farma.getIdProduto() == numero)
				return farma;
		}
		return null;
	}
		
}
