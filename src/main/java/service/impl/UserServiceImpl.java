package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.UserDao;
import domain.ResultDO;
import domain.User;
import service.UserService;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public void test() {
		System.out.println("userServiceImpl do !");
		
	}

	@Override
	public ResultDO<User> queryUserByName(String username) {
		// TODO Auto-generated method stub
		ResultDO<User> resultDO = new ResultDO<User>();
		
		List<User> userList = userDao.queryUserByName(username);
		if (userList == null || userList.size() == 0) {
			resultDO.setRespCode("01");
			resultDO.setRespDesc("该用户不存在!");
		}
		else if (userList.size() > 1) {
			resultDO.setRespCode("02");
			resultDO.setRespDesc("该用户名在数据库中已重复!");
		}
		else {
			resultDO.setSuccess(true);
			resultDO.setResult(userList.get(0));
		}
		
		return resultDO;
	}
	
	@Override
	public ResultDO<String> checkDuplicateUser(String username) {
		ResultDO<String> resultDO = new ResultDO<String>();
		
		List<User> userList = userDao.queryUserByName(username);
		if (userList.size() > 0) {
			resultDO.setRespCode("03");
			resultDO.setRespDesc("该用户名已存在!");
		}
		else {
			resultDO.setSuccess(true);
			resultDO.setResult(username);
		}
		
		return resultDO;
	}
	
	@Override
	public ResultDO<String> saveUser(String username, String password) {
		// TODO
		User user = new User(username, password);
		return userDao.saveUserDO(user);
	}
	
}
