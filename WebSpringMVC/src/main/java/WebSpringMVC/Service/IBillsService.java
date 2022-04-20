package WebSpringMVC.Service;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import WebSpringMVC.Dto.CartDto;
import WebSpringMVC.Entity.Bills;

@Service
public interface IBillsService {
	public int AddBills(Bills bill);

	public void AddBillsDetail(HashMap<Long, CartDto> cart);
}
