package cn.itcast.web.formbean;

import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.upload.FormFile;

public class RegisterFormBean extends ActionForm {

	private String username;
	private String password;
	private String email;
	private FormFile file;
	
	
	
	public FormFile getFile() {
		return file;
	}
	public void setFile(FormFile file) {
		this.file = file;
	}
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		
		ActionErrors errors = new ActionErrors();
		ResourceBundle rb = ResourceBundle.getBundle("MessageResource");
		
		if(this.username==null || this.username.trim().equals("")){
			errors.add("username", new ActionMessage("prompt.message",rb.getString("prompt.username")));
		}else{
			if(!this.username.matches("[A-Za-z]{3,6}")){
				errors.add("username",new ActionMessage("prompt.errors.username"));
			}
		}
		
		if(this.password==null || this.password.trim().equals("")){
			errors.add("password", new ActionMessage("prompt.message",rb.getString("prompt.password")));
		}else{
			if(!this.password.matches("\\d{3,6}")){
				errors.add("password",new ActionMessage("prompt.errors.password"));
			}
		}
		
		
		return errors;
	}
	
	
	
	
}
