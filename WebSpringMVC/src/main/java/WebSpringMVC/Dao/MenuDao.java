package WebSpringMVC.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import WebSpringMVC.Entity.MapperMenu;
import WebSpringMVC.Entity.Menus;

@Repository
public class MenuDao extends BaseDao {
	public List<Menus> GetDataMenus() {
		List<Menus> list = new ArrayList<Menus>();
		String sql = "SELECT * FROM menus";
		list = _jdbcTemplate.query(sql, new MapperMenu());
		return list;
	}
}
