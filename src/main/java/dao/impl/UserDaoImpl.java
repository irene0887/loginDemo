package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import mapper.UserMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.stereotype.Repository;

import constants.SqlConstants;
import dao.UserDao;
import domain.ResultDO;
import domain.User;

@Repository
public class UserDaoImpl implements UserDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<User> queryUserByName(String username) {
		List<User> userList = jdbcTemplate.query(SqlConstants.USER_SEL_BY_NAME, new Object[]{username}, new UserMapper());
		return userList;
	}
	
	@Override
	public ResultDO<String> saveUserDO(User user){
		int rows = jdbcTemplate.update(new PreparedStatementCreator(){

			@Override
			public PreparedStatement createPreparedStatement(Connection conn)
					throws SQLException {
				PreparedStatement ps = conn.prepareStatement(SqlConstants.USER_INS_USER);
				ps.setString(1, user.getUsername());
				ps.setString(2, user.getPassword()); // TODO 加密
				ps.setDate(3, new java.sql.Date(new java.util.Date().getTime()));
				
				return ps;
			}});
		
		ResultDO<String> resultDO = new ResultDO<String>();
		if (rows > 0) {
			resultDO.setSuccess(true);
			resultDO.setRespCode("00");
			resultDO.setResult(user.getUsername());
		}
		else {
			resultDO.setRespCode("04");
			resultDO.setRespDesc("注册失败！");
		}
		return resultDO;
	}
}
