package Service;

import org.apache.axis2.context.MessageContext;
import org.apache.axis2.context.ServiceContext;

import ComplexTypedata.DataForm;

public class LoginService {
	 public boolean login(String username, String password)
	    {
		
		 MessageContext mc = MessageContext.getCurrentMessageContext();
         ServiceContext sc = mc.getServiceContext();
	        if("bill".equals(username) && "1234".equals(password))
	        {
	            //  第1步：设置key-value
	            sc.setProperty("login", "成功登录");    
	            return true;
	        }
	        else
	        {
	        	sc.setProperty("login", username+"和"+password+"不匹配");
	            return false;
	        }
	    }
	    public String getLoginMsg()
	    {
	        //  第1步：获得key-value对中的value
	        MessageContext mc = MessageContext.getCurrentMessageContext();
	        ServiceContext sc = mc.getServiceContext();
	        return (String)sc.getProperty("login");    
	    }
}
