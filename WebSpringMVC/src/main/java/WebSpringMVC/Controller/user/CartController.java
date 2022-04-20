package WebSpringMVC.Controller.user;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import WebSpringMVC.Dto.CartDto;
import WebSpringMVC.Entity.Bills;
import WebSpringMVC.Entity.Users;
import WebSpringMVC.Service.BillsServiceImpl;
import WebSpringMVC.Service.CartSerciveImpl;

@Controller
public class CartController extends BaseController{
	
	@Autowired
	private CartSerciveImpl cartService = new CartSerciveImpl();
	@Autowired
private BillsServiceImpl billsService =new BillsServiceImpl();
	@RequestMapping(value = "gio-hang")
	public ModelAndView Index() {
		_mvShare.addObject("slides", _homeService.GetDataSlide());
		_mvShare.addObject("categorys", _homeService.GetDataCategorys());
		_mvShare.addObject("products", _homeService.GetDataProducts());
		_mvShare.setViewName("user/cart/list_cart");
		return _mvShare;
	}
	
	@RequestMapping(value = "AddCart/{id}")
	public String AddCart(HttpServletRequest request ,HttpSession session, @PathVariable long id) {
		HashMap<Long, CartDto> cart = (HashMap<Long, CartDto>)session.getAttribute("Cart");
		if(cart == null) {
			cart = new HashMap<Long, CartDto>();
		}
		cart = cartService.AddCart(id, cart);
		session.setAttribute("Cart", cart);
		session.setAttribute("TotalQuantyCart", cartService.TotalQuanty(cart));
		session.setAttribute("TotalPriceCart", cartService.TotalPrice(cart));
		return "redirect:"+request.getHeader("Referer");
	}
	
	@RequestMapping(value = "EditCart/{id}/{quanty}")
	public String EditCart(HttpServletRequest request ,HttpSession session, @PathVariable long id,@PathVariable int quanty) {
		HashMap<Long, CartDto> cart = (HashMap<Long, CartDto>)session.getAttribute("Cart");
		if(cart == null) {
			cart = new HashMap<Long, CartDto>();
		}
		cart = cartService.EditCart(id, quanty, cart);
		session.setAttribute("Cart", cart);
		session.setAttribute(" ", cartService.TotalQuanty(cart));
		session.setAttribute("TotalPriceCart", cartService.TotalPrice(cart));
		return "redirect:"+request.getHeader("Referer");
	}
	
	
	@RequestMapping(value = "DeleteCart/{id}")
	public String DeleteCart(HttpServletRequest request ,HttpSession session, @PathVariable long id) {
		HashMap<Long, CartDto> cart = (HashMap<Long, CartDto>)session.getAttribute("Cart");
		if(cart == null) {
			cart = new HashMap<Long, CartDto>();
		}
		cart = cartService.DeleteCart(id, cart);
		session.setAttribute("Cart", cart);
		session.setAttribute("TotalQuantyCart", cartService.TotalQuanty(cart));
		session.setAttribute("TotalPriceCart", cartService.TotalPrice(cart));
		return "redirect:"+request.getHeader("Referer");
	}
	

	@RequestMapping(value = "checkout" , method = RequestMethod.GET)
	public ModelAndView Checkout(HttpServletRequest request ,HttpSession session) {
		_mvShare.setViewName("user/bills/checkout");
		Bills bills=new Bills();
		Users loginInfo=(Users)session.getAttribute("LoginInfo");
		if(loginInfo !=null) {
			bills.setAddress(loginInfo.getAddress());
			bills.setDisplay_name(loginInfo.getDisplay_name());
			bills.setUser(loginInfo.getUser());
		}
		_mvShare.addObject("bills",bills);
		return _mvShare;
	}
	
	@RequestMapping(value = "checkout" , method = RequestMethod.POST)
	public String Checkout(HttpServletRequest request ,HttpSession session,@ModelAttribute("bills")Bills bill) {
		if(billsService.AddBills(bill)>0) {
			HashMap<Long, CartDto>cart=(HashMap<Long,CartDto>)session.getAttribute("Cart");
			billsService.AddBillsDetail(cart);
		}
	session.removeAttribute("Cart");	
		return "redirect:gio-hang";
	}
	
}
