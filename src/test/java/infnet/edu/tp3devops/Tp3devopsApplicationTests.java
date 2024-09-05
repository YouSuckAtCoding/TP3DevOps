package infnet.edu.tp3devops;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootTest
class Tp3devopsApplicationTests {

	@Autowired
    JdbcTemplate jdbcTemplate;

	@Test
	void contextLoads() {
	}



	@Test
	void Should_Create_Connection_With_MySql_Databse()
	{
		jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS teste" +
		"(id int)");
	}

}
