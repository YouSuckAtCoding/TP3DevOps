package infnet.edu.tp3devops.Config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan("infnet.edu.jdbc")
public class JDBCConfig {
    
    private final String Url = "jdbc:mysql://host.docker.internal:3312/tp3database";
    private final String User = "myuser";
    private final String Pass = "Numsey@Password!";


    @Bean
    public DataSource mysqlDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl(Url);
        dataSource.setUsername(User);
        dataSource.setPassword(Pass);

        return dataSource;
    }

}
