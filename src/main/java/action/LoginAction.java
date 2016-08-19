package action;

import org.springframework.beans.factory.annotation.Autowired;

import service.UserService;

import com.opensymphony.xwork2.ActionSupport;

import domain.ResultDO;
import domain.User;

public class LoginAction extends ActionSupport { //implements InitializingBean 

    private String username;  
    private String password;  
    
	@Autowired
	private UserService userService;
    
    public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String execute() throws Exception {
		
		// 校验该用户是否存在
		ResultDO<User> loginResultDO = userService.queryUserByName(username);
		if(loginResultDO.isFailure()){
			this.addFieldError("username", loginResultDO.getRespDesc());
			return "input";
		}
		
		// 校验登录密码
		User user = loginResultDO.getResult();
		if(!password.equals(user.getPassword())) {
			this.addFieldError("password", "密码不正确！");
			return "fail";
		}
		
		System.out.println(user);
		return SUCCESS;
     }
	
	public void validateExecute(){
    	if (this.username == null || "".equals(this.username.trim())) {
    		this.addFieldError("username", "用户名不能为空！");
    	}
    }
     
/*	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		app.getPerson().printPerson();
		System.out.println(username);
	}  */
}  