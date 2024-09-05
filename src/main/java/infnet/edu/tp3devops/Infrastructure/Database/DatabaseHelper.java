package infnet.edu.tp3devops.Infrastructure.Database;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DatabaseHelper {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @EventListener(ContextRefreshedEvent.class)
    public void DatabaseInitializer() throws SQLException
    {
        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS Fornecedor(" +
            "id int NOT NULL AUTO_INCREMENT, name VARCHAR(30), email VARCHAR(40), store VARCHAR(30)," +
            "PRIMARY KEY (id))");

        jdbcTemplate.execute(
        "INSERT INTO Fornecedor (name, email, store) " + 
        "SELECT 'Admin', 'admin@teste.com', 'admin store' " +
        "Where NOT EXISTS (SELECT name from Fornecedor where name = 'Admin')");
    }

    
}
