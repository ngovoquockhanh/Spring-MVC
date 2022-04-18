package WebSpringMVC.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import WebSpringMVC.Dao.ProductsDao;
import WebSpringMVC.Dto.ProductsDto;


public class ProductServiceImpl implements IProductService {
	
	@Autowired
	ProductsDao productDao = new ProductsDao();

	public ProductsDto GetProductByID(long id) {
		List<ProductsDto> listProducts = productDao.GetProductByID(id);
		return listProducts.get(0);
	}

	public List<ProductsDto> GetProductByIDCategory(int id) {
		return productDao.GetAllProductsByID(id);
	}
}
