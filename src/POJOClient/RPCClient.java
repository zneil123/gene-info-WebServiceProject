package POJOClient;

import javax.xml.namespace.QName;

import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;

import org.apache.axis2.rpc.client.RPCServiceClient;

public class RPCClient {
	public static void main(String[] args) throws Exception {
		//使用RPC方式调用WebService　　　　
		RPCServiceClient serviceClient = new RPCServiceClient();
		Options options = serviceClient.getOptions();
		//指定调用WebService的URL
		EndpointReference targetEPR = new EndpointReference(
				"http://localhost:8880/axis2/services/SimpleService");
		options.setTo(targetEPR);
		
		//指定getGreeting方法的参数值
		Object[] opAddEntryArgs = new Object[] { "supperman" };
		//指定getGreeting方法返回值的数据类型的Class对象
		Class[] classes = new Class[] { String.class };
		//指定要调用的getGreeting方法及WSDL文件的命名空间
		QName opAddEntry = new QName("http://ws.apache.org/axis2",
				"getGreeting");
		//调用getGreeting方法并输出该方法的返回值
		System.out.println(serviceClient.invokeBlocking(opAddEntry,
				opAddEntryArgs, classes)[0]);
		//下面是调用getPrice方法的代码，这些代码与调用getGreeting方法的代码类似
		classes = new Class[] { int.class };
		opAddEntry = new QName("http://ws.apache.org/axis2", "getPrice");
		System.out.println(serviceClient.invokeBlocking(opAddEntry,
				new Object[] {}, classes)[0]);
/*		注意:invokeBlocking方法有三个参数，其中第一个参数的类型是QName对象，表示要调用的方法名；第二个参数表示要调用的WebService方法的参数值，
		参数类型为Object[]；第三个参数表示WebService方法的返回值类型的Class对象，参数类型为Class[]。
		当方法没有参数时，invokeBlocking方法的第二个参数值不能是null，而要使用new Object[]{}。
		.在创建QName对象时，QName类的构造方法的第一个参数表示WSDL文件的命名空间名，也就是<wsdl:definitions>元素的targetNamespace属性值。*/


	}
}
