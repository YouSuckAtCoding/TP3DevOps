package infnet.edu.tp3devops;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import infnet.edu.tp3devops.Domain.Models.Fornecedor;
import infnet.edu.tp3devops.Infrastructure.Repositories.IFornecedorRepository;

@SpringBootTest
public class FornecedorRepositoryTests {

    @Autowired
    private IFornecedorRepository repository;

    @Test
    void Should_Retrieve_Fornecedores_From_Database()
    {
        var result = repository.GetAll();

        Assert.notEmpty(result, "ok");
    }

    @Test
    void Should_Insert_Fornecedor_Into_Database()
    {
        Fornecedor forn = MakeFornecedor();

        repository.CreateFornecedor(forn);

        var list = repository.GetAll();

        boolean result = list.stream().anyMatch(x -> x.name.equals(forn.name));

        Assert.isTrue(result, "Inserted");
       
    }

    @Test
    void Should_Delete_Fornecedor_From_Database()
    {
        var list = repository.GetAll();
        Fornecedor last = list.get(list.size() - 1);

        repository.DeleteFornecedor(last.id);
        list = repository.GetAll();
        boolean result = list.stream().anyMatch(x -> x.id == (last.id));

        Assert.isTrue(result == false, "Deleted");
    }

    @Test
    void Should_Update_Fornecedor_From_Database()
    {
        Fornecedor forn = MakeFornecedor();
        repository.CreateFornecedor(forn);

        var list = repository.GetAll();

        Fornecedor last = list.get(list.size() - 1);
        last.name = "Updated";

        repository.UpdateFornecedor(last);

        list = repository.GetAll();

        boolean result = list.stream().anyMatch(x -> x.name.equals(last.name));
        Assert.isTrue(result, "Updated");        
    }

    private Fornecedor MakeFornecedor() {
        Fornecedor forn = new Fornecedor(0, 
        "teste", 
        "teste@email.com", 
        "teste store");
        return forn;
    }

}
