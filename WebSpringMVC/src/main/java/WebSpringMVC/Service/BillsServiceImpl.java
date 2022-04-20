package WebSpringMVC.Service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import WebSpringMVC.Dao.BillsDao;
import WebSpringMVC.Dto.CartDto;
import WebSpringMVC.Entity.BillDetail;
import WebSpringMVC.Entity.Bills;

@Service
public class BillsServiceImpl implements IBillsService {

	@Autowired
	private BillsDao billsDao;

	public int AddBills(Bills bill) {
		return billsDao.AddBills(bill);
	}

	public void AddBillsDetail(HashMap<Long, CartDto> cart) {
		long idBills = billsDao.GetIDLastBills();
		for (Map.Entry<Long, CartDto> itemCart : cart.entrySet()) {
			BillDetail billDetail = new BillDetail();
			billDetail.setId_bills(idBills);
			billDetail.setId_product(itemCart.getValue().getProduct().getId_product());
			billDetail.setQuanty(itemCart.getValue().getQuanty());
			billDetail.setTotal(itemCart.getValue().getTotalPrice());
			billsDao.AddBillsDetail(billDetail);
		}

	}
}
