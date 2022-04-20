package WebSpringMVC.Service;

import org.springframework.stereotype.Service;

import WebSpringMVC.Entity.Users;
@Service
public interface IAccountService {
	public int AddAccount(Users user);

	public Users CheckAccount(Users user);
}
