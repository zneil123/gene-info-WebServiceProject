package module;

import org.apache.axis2.AxisFault;
import org.apache.axis2.context.MessageContext;
import org.apache.axis2.engine.Handler;
import org.apache.axis2.handlers.AbstractHandler;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class LogHandler extends AbstractHandler implements Handler {
	private static final Log log = LogFactory.getLog(LogHandler.class);

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public InvocationResponse invoke(MessageContext msgContext)
			throws AxisFault {
		// 向Tomcat控制台输出请求和响应SOAP消息
		log.info(msgContext.getEnvelope().toString());
		return InvocationResponse.CONTINUE;

	}

	public void revoke(MessageContext msgContext) {
		log.info(msgContext.getEnvelope().toString());
	}

}
