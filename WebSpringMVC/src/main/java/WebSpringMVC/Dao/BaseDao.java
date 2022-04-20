package WebSpringMVC.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import WebSpringMVC.Entity.Bills;

public class BaseDao {
	@Autowired
	public JdbcTemplate  _jdbcTemplate;

	
}
