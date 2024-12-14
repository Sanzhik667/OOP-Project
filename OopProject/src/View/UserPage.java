package View;

import System.ProjectSystem;
import Users.User;

public abstract class UserPage extends ProjectSystem {

	public UserPage(User currentUser) {
		// TODO Auto-generated constructor stub
	}
	 @Override
	public abstract void handleUserActions();
	
}