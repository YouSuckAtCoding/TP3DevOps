package infnet.edu.tp3devops.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import infnet.edu.tp3devops.Domain.Models.Fornecedor;

public class FornecedorMapper implements RowMapper<Fornecedor> {
  
    @Override
    public Fornecedor mapRow(ResultSet rs, int rowNum) throws SQLException {

        Fornecedor Fornecedor = new Fornecedor(rs.getLong("id"),
        rs.getString("name"),
        rs.getString("email"),
        rs.getString("store"));
        return Fornecedor;

    }
}
