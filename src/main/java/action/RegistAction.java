package action;

import org.springframework.beans.factory.annotation.Autowired;

import service.UserService;

import com.opensymphony.xwork2.ActionSupport;

import domain.ResultDO;
import domain.User;

public class RegistAction extends ActionSupport
{ 

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
    	
    	// 校验用户名是否已存在
    	ResultDO<String> regCheckResultDO = userService.checkDuplicateUser(username);
    	if (regCheckResultDO.isFailure()) {
    		this.addFieldError("username",regCheckResultDO.getRespDesc());
    		return "input";
    	}
    	
    	ResultDO<String> regResultDO = userService.saveUser(username, password);
    	if(regResultDO.isFailure()){
    		this.addActionError(regResultDO.getRespDesc());
    		return "fail";
    	}
    	
    	System.out.println("reg_name: " + regResultDO.getResult() + " done!");
		return SUCCESS;
    }  
    
    public void validateExecute(){
    	if (this.username == null || "".equals(this.username.trim())) {
    		this.addFieldError("username", "用户名不能为空！");
    	}
    	if (this.password == null || "".equals(this.password.trim())) {
    		this.addFieldError("password", "密码不能为空！");
    	}
    }
}  