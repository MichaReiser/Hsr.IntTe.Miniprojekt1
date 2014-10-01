package ch.hsr.intTe.ui;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import ch.hsr.intTe.ServiceLocator;
import ch.hsr.intTe.domain.User;
import ch.hsr.intTe.service.UserService;

import com.google.common.base.Preconditions;

@ManagedBean
@SessionScoped
public class Login implements Serializable {
	
	private static final long serialVersionUID = 5386638232357681140L;
	
	private User user;
	
	public String login(Credentials credentials) {
		Preconditions.checkNotNull(credentials);
		
		user = ServiceLocator.getInstance().locate(UserService.class).getByUsername(credentials.getUsername());
		return "/index.xhtml";
	}
	
	public void logout() {
		user = null;
	}
	
	public boolean isLoggedIn() {
		return user != null;
	}
}
