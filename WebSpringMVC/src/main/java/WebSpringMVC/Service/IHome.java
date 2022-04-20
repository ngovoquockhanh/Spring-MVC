package WebSpringMVC.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import WebSpringMVC.Dto.ProductsDto;
import WebSpringMVC.Entity.Categorys;
import WebSpringMVC.Entity.Menus;
import WebSpringMVC.Entity.Slides;
@Service
public interface IHome {
	@Autowired
	public List<Slides> GetDataSlide();
	public List<Menus> GetDataMenus();
	public List<Categorys> GetDataCategorys();
	public List<ProductsDto> GetDataProducts();
}
