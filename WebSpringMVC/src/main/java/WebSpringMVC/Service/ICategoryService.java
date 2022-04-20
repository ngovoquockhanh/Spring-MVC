package WebSpringMVC.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import WebSpringMVC.Dto.ProductsDto;


@Service
public interface ICategoryService {
	public List<ProductsDto> GetAllProductsByID(int id);
}
