package infnet.edu.tp3devops.Infrastructure.Repositories;

import java.util.List;

import infnet.edu.tp3devops.Domain.Models.Fornecedor;

public interface IFornecedorRepository {

    List<Fornecedor> GetAll();

    Fornecedor GetById(long id);

    void CreateFornecedor(Fornecedor fornecedor);

    void UpdateFornecedor(Fornecedor fornecedor);

    void DeleteFornecedor(long id);

}