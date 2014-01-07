package Client;

import javax.xml.namespace.QName;

import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.rpc.client.RPCServiceClient;

import LoginServiceDemo.LoginServiceStub;

 

public class LoginClient {
	
	public static void main(String[] args) throws Exception{
		String tmp = "http://localhost:8880/axis2/services/LoginService";
/*		RPCServiceClient serviceClient = new RPCServiceClient();
		Options options = serviceClient.getOptions();
		EndpointReference targetEPR = new EndpointReference(tmp);
		options.setTo(targetEPR);  
		Object[] opAddEntryArgs = new Object[] {"bill","1234"};
		 
		QName opAddEntry = new QName("http://Service","login");
	 
		String[] strArray = (String[]) serviceClient.invokeBlocking(opAddEntry,
				opAddEntryArgs, new Class[] { String[].class })[0];
		System.out.println(strArray[0]);*/
		
		
		LoginServiceStub stub = new LoginServiceStub(tmp);
		LoginServiceStub.Login login = new LoginServiceStub.Login();
		login.setUsername("bill");
		login.setPassword("1234");
		 
		if(stub.login(login).get_return())
		{
		    System.out.println(stub.getLoginMsg(new LoginServiceStub.GetLoginMsg()).get_return());
		}
		else
		{
			System.out.println("登录及密码"+stub.getLoginMsg(new LoginServiceStub.GetLoginMsg()).get_return());
		}
	}
	

}
