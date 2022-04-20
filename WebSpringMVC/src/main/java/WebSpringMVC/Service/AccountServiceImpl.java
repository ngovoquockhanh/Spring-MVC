package WebSpringMVC.Service;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import WebSpringMVC.Dao.UsersDao;
import WebSpringMVC.Entity.Users;

@Service
public class AccountServiceImpl implements IAccountService {
	@Autowired
	UsersDao userDao = new UsersDao();

	public int AddAccount(Users user) {
		user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(12)) );	
		return userDao.AddAccount(user);
	}

	public Users CheckAccount(Users user) {
		String pass = user.getPassword();
		user = userDao.GetUserByAccount(user);
		if(user !=null) {
			if(BCrypt.checkpw(pass, user.getPassword())) {
				return user;
			}
			else {
				return null;
			}
		}
		return null;
	}
}
