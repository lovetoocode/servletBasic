package service;

import blogs.beans.Blogger;
import javax.servlet.http.HttpSession;

public class Session {
	public Session() {
		
	}
	public Boolean loginCheck(Blogger blogger) {
		if(blogger instanceof Blogger && blogger != null)
			return true;
		return false;
	}
}
