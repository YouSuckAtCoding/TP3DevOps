package infnet.edu.tp3devops.Infrastructure.Repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import infnet.edu.tp3devops.Domain.Models.Fornecedor;
import infnet.edu.tp3devops.Mapper.FornecedorMapper;

@Repository
public class FornecedorRepository implements IFornecedorRepository {

    @Autowired
    private JdbcTemplate JdbcTemplate;
    
    @Override
    public Fornecedor GetById(long id) {
        
        return JdbcTemplate.queryForObject(
        "SELECT id, name, email, store from Fornecedor Where id = " + id
        , new FornecedorMapper());
                 
    }

    @Override
    public List<Fornecedor> GetAll()
    {
        return JdbcTemplate.query(
            "Select id, name, email, store from Fornecedor;",
            new FornecedorMapper());
    }

    @Override
    public void CreateFornecedor(Fornecedor fornecedor)
    {
        JdbcTemplate.execute("Insert into Fornecedor (name, email, store) " + 
        "values ('" + fornecedor.name + "', '" + fornecedor.email + "', '" + fornecedor.store + "')");
    }

    @Override
    public void UpdateFornecedor(Fornecedor fornecedor)
    {
        JdbcTemplate.execute("Update Fornecedor " + 
        "Set name = '" + fornecedor.name + "', " 
         + "email = '" + fornecedor.email + "', " 
         + "store = '" + fornecedor.store + "'" +
        " Where id = " + fornecedor.id);
    }

    @Override
    public void DeleteFornecedor(long id)
    {
        JdbcTemplate.execute("Delete from Fornecedor Where id = " + id);
    }

    
}   
