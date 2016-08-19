package service;

import java.util.List;

import domain.ResultDO;
import domain.User;

public interface UserService {
	public void test();

	public ResultDO<User> queryUserByName(String username);

	ResultDO<String> saveUser(String username, String password);

	ResultDO<String> checkDuplicateUser(String username);
}
