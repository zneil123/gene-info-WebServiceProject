package Client.crossSession;

import java.rmi.RemoteException;

import LoginServiceDemo.SearchDemo.LoginCrossServiceStub;
import LoginServiceDemo.SearchDemo.SearchServiceStub;

public class LoginClient {

	public static void main(String[] args) throws RemoteException {

		String SearchService = "http://localhost:8880/axis2/services/SearchService";
		String LoginCrossService = "http://localhost:8880/axis2/services/LoginCrossService";
		LoginCrossServiceStub lss = new LoginCrossServiceStub(LoginCrossService);
		LoginCrossServiceStub.Login login = new LoginCrossServiceStub.Login();
		LoginCrossServiceStub.GetLoginMsg glm = new LoginCrossServiceStub.GetLoginMsg();
		login.setUsername("bill1");
		login.setPassword("1234");
		if (lss.login(login).get_return()) {
			System.out.println(lss.getLoginMsg(glm).get_return());
			SearchServiceStub sss = new SearchServiceStub(SearchService);
			SearchServiceStub.FindByName fbn = new SearchServiceStub.FindByName();
			fbn.setName("bill");
			System.out.println(sss.findByName(fbn).get_return());
		}
		else
		{
			System.out.println(lss.getLoginMsg(glm).get_return());
			SearchServiceStub sss = new SearchServiceStub(SearchService);
			SearchServiceStub.FindByName fbn = new SearchServiceStub.FindByName();
			fbn.setName("bill");
			System.out.println(sss.findByName(fbn).get_return());
		}
	 
	}

}
