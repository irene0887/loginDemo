package dao;

import java.util.List;

import domain.ResultDO;
import domain.User;

public interface UserDao {

	public List<User> queryUserByName(String username);

	public ResultDO<String> saveUserDO(User user);

}
