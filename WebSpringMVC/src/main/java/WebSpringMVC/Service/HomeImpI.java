package WebSpringMVC.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import WebSpringMVC.Dao.CategorysDao;
import WebSpringMVC.Dao.MenuDao;
import WebSpringMVC.Dao.ProductsDao;
import WebSpringMVC.Dao.SlidesDao;
import WebSpringMVC.Dto.ProductsDto;
import WebSpringMVC.Entity.Categorys;
import WebSpringMVC.Entity.Menus;
import WebSpringMVC.Entity.Slides;

@Service
public class HomeImpI implements IHome {
	@Autowired
	private SlidesDao slidesDao;
	@Autowired
	private CategorysDao categoryDao;
	@Autowired
	private MenuDao menuDao;
	@Autowired
	private ProductsDao productsDao;
	
	public List<Slides> GetDataSlide() {
		// TODO Auto-generated method stub
		return slidesDao.GetDataSlide();
	}

	public List<Categorys> GetDataCategorys() {
		// TODO Auto-generated method stub
		return categoryDao.GetDataCategorys();
	}

	public List<Menus> GetDataMenus() {
		// TODO Auto-generated method stub
		return menuDao.GetDataMenus();
	}

	@Override
	public List<ProductsDto> GetDataProducts() {
List<ProductsDto> listProducts= productsDao.GetDataProducts();
		return listProducts;
	}

	

}
