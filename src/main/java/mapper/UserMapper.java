package mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import domain.User;

public class UserMapper implements RowMapper<User>{

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		user.setId(rs.getInt("U_ID"));
		user.setUsername(rs.getString("U_NAME"));
		user.setPassword(rs.getString("U_PWD"));
		user.setRegist_time(rs.getDate("REG_TS"));
		return user;
	}

}
