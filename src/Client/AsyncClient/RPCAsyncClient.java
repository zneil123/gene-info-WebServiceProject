package Client.AsyncClient;

import invokeServiceDemo.InvokeMethodCallbackHandler;
import invokeServiceDemo.InvokeMethodStub;
import invokeServiceDemo.InvokeMethodStub.GetName;
import invokeServiceDemo.InvokeMethodStub.GetNameResponse;

import javax.xml.namespace.QName;

import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.context.MessageContext;
import org.apache.axis2.rpc.client.RPCServiceClient;


class MyCallback extends InvokeMethodCallbackHandler
{
    @Override
    public void receiveResultgetName(GetNameResponse result)
    {
        //  输出getName方法的返回结果
        System.out.println(result.get_return());
    }
}



public class RPCAsyncClient {
	public static void main(String[] args) throws Exception {
		//RPC方式
/*		RPCServiceClient serviceClient = new RPCServiceClient();
		Options options = serviceClient.getOptions();
		EndpointReference targetEPR = new EndpointReference(
				"http://localhost:8880/axis2/services/InvokeMethod");
		options.setTo(targetEPR);
		Object[] opAddEntryArgs = new Object[] {"tom"};
		QName opAddEntry = new QName("http://invokeService.Service", "getName");
		Object strSyn=serviceClient.invokeBlocking(opAddEntry,opAddEntryArgs, new Class[] { String.class })[0];
		System.out.println(strSyn);
		System.out.println("同步");
		serviceClient.invokeNonBlocking(opAddEntry, opAddEntryArgs,
				new org.apache.axis2.client.async.AxisCallback() {

					@Override
					public void onComplete() {
						// TODO Auto-generated method stub

					}

					@Override
					public void onError(Exception arg0) {
						// TODO Auto-generated method stub

					}

					@Override
					public void onFault(MessageContext arg0) {
						// TODO Auto-generated method stub

					}

					@Override
					public void onMessage(MessageContext mc) {

						// 输出返回值
						System.out.println(mc.getEnvelope().getFirstElement()
								.getFirstElement().getFirstElement().getText());

					}

				});
		System.out.println("异步调用！");
		// 阻止程序退出(没有即使在onMessage回调函数中设置断点，也无法获取返回值。如果之前执行过多遍，将控制台完全关闭后在测试)
		System.in.read();*/
		
		//stub方式调用
		String tmp = "http://localhost:8880/axis2/services/InvokeMethod";
		InvokeMethodStub stub = new InvokeMethodStub(tmp);        
	    //异步调用WebService
	    stub.startgetName(new GetName(),new MyCallback());
	    //同步调用WebService
	    GetNameResponse res=stub.getName(new GetName());
	    System.out.println(res.get_return());
	    System.out.println("异步调用！");
	    System.in.read();    
 
	}
 
}
