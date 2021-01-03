package client;

public class LoginDialog {
	public LoginController controller;
	
	private String email = "sample@gmail.com";
	private String password = "12345";	

	public LoginDialog(LoginController controller) {
		this.controller = controller;
	}
	
	public void login() {
		System.out.println(" - Login into the server: '" + email + "' - '" + password + "'");
		
		boolean loginResult = controller.login(email, password);
		
		System.out.println("    * Login result: " + loginResult);
	}
}
