package Service.crossSession;

import org.apache.axis2.context.MessageContext;
import org.apache.axis2.context.ServiceGroupContext;

public class LoginCrossService {

	public boolean login(String username, String password) {
		MessageContext mc = MessageContext.getCurrentMessageContext();
		ServiceGroupContext sgc = mc.getServiceGroupContext();
		if ("bill".equals(username) && "1234".equals(password)) {
			// 第1步：设置key-value对
			sgc.setProperty("login", "成功登录");
			return true;
		} else {
			sgc.setProperty("login", username+"和"+password+"不匹配");
			return false;
		}
	}

	public String getLoginMsg() {
		// 第1步：获得key-value对中的value
		MessageContext mc = MessageContext.getCurrentMessageContext();
		ServiceGroupContext sgc = mc.getServiceGroupContext();
		return (String) sgc.getProperty("login");
	}

}
