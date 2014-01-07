package Client.LoggingMonitor;

import javax.xml.namespace.QName;

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNamespace;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;
import org.apache.axis2.rpc.client.RPCServiceClient;

public class MonitorClient {
	public static void main(String[] args) throws Exception {
		//Document访问方式
		Options options = new Options();
		// 指定调用WebService的URL
		EndpointReference targetEPR = new EndpointReference(
				"http://localhost:8880/axis2/services/MonitorService");
		options.setTo(targetEPR);
		// options.setAction("urn:getPrice");
		ServiceClient sender = new ServiceClient();
		sender.setOptions(options);
		OMFactory fac = OMAbstractFactory.getOMFactory();
		String tns = "http://LogMonitor.Service";
		 
		OMNamespace omNs = fac.createOMNamespace(tns, "");
		OMElement method = fac.createOMElement("getGreeting", omNs);
		OMElement symbol = fac.createOMElement("arg", omNs);
		//symbol.setText("1");
		symbol.addChild(fac.createOMText(symbol, "Tom"));
		method.addChild(symbol);
		method.build();
		OMElement result = sender.sendReceive(method);
		System.out.println(result);
		//RPC访问方式    
/*		RPCServiceClient serviceClient = new RPCServiceClient();
		Options options = serviceClient.getOptions();
		EndpointReference targetEPR = new EndpointReference(
				"http://localhost:8880/axis2/services/MonitorService");
		options.setTo(targetEPR);
		Object[] opAddEntryArgs = new Object[] {"Tom "};
		QName opAddEntry = new QName("http://LogMonitor.Service", "getGreeting");
		OMElement element = serviceClient.invokeBlocking(opAddEntry, opAddEntryArgs);//返回XML
		System.out.println(element);
		System.out.println(element.getFirstElement().getText());
		Object strSyn = serviceClient.invokeBlocking(opAddEntry,
				opAddEntryArgs, new Class[] { String.class })[0];
		System.out.println(strSyn);
		System.out.println("同步");*/
	}
}
