package infnet.edu.tp3devops.Infrastructure.Database;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class DatabaseHelper {

    private Connection connection;
    
    @Autowired
    JdbcTemplate jdbcTemplate;

    public void DatabaseInitializer() throws SQLException
    {

        jdbcTemplate.execute("CREATE TABLE fornecedores(" +
            "id long, name VARCHAR(30), store VARCHAR(30))");
        jdbcTemplate.execute("INSERT INTO fornecedores (name, email, store)\r\n" + //
                        "values ('Admin', 'admin@teste.com', 'RandomStore');");
    }
    
}
