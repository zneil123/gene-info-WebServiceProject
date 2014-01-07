package WS_SAPGathering;

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNamespace;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;
import org.apache.axis2.rpc.client.RPCServiceClient;
import org.apache.axis2.transport.http.HTTPConstants;
import org.apache.axis2.transport.http.HttpTransportProperties.Authenticator;



import javax.xml.namespace.QName;

import GatheringDemo.SI_BUSINESS_REVERSE_CWSK_OUTServiceStub;
import GatheringDemo.SI_BUSINESS_REVERSE_CWSK_OUTServiceStub.DT_BUSINESS_REVERSE_CWSK_OUT_REQ;
import GatheringDemo.SI_BUSINESS_REVERSE_CWSK_OUTServiceStub.ITEM_type0;
import GatheringDemo.SI_BUSINESS_REVERSE_CWSK_OUTServiceStub.ITEM_type1;
import GatheringDemo.SI_BUSINESS_REVERSE_CWSK_OUTServiceStub.MT_BUSINESS_REVERSE_CWSK_OUT_REQ;
import GatheringDemo.SI_BUSINESS_REVERSE_CWSK_OUTServiceStub.MT_BUSINESS_REVERSE_CWSK_OUT_RES;

public class WSTestGathering {

 

	public static void main(String[] args) throws Exception {
          //baomi见webService笔记中可以找到
		  String tmp = "http://baomi/XISOAPAdapter/MessageServlet?channel=:BS_BUSINESS:CC_BUSINESS_SOAP_REVERSE_CWSK_OUT&amp;version=3.0&amp;Sender.Service=BS_BUSINESS&amp;Interface=urn%3Abusiness2ecc%3Areverse_cwsk%5ESI_BUSINESS_REVERSE_CWSK_OUT";
		  
/*		  //RPC访问
		  RPCServiceClient serviceClient = new RPCServiceClient(); 
		  Options opt = serviceClient.getOptions(); 
		  EndpointReference targetEPR = new EndpointReference(tmp); opt.setTo(targetEPR);
		  opt.setProperty(HTTPConstants.SO_TIMEOUT, new Integer(30000));//30秒后超时自动进入异常
		  opt.setAction("p1:MT_BUSINESS_REVERSE_CWSK_OUT_REQ");
		  Authenticator authenticator = new Authenticator();
		  //baomi见webService笔记中可以找到
		  authenticator.setPassword("baomi");
		  authenticator.setUsername("baomi");
		  opt.setProperty(HTTPConstants.AUTHENTICATE, authenticator);
		  serviceClient.setOptions(opt);
		  ITEM_type1 type1 = new ITEM_type1(); 
		  type1.setCity("1");
		  type1.setGatheringID("2"); 
		  type1.setGJAHR("3");
		  type1.setVoucher("4");
		  DT_BUSINESS_REVERSE_CWSK_OUT_REQ cwsk = new DT_BUSINESS_REVERSE_CWSK_OUT_REQ();
		  cwsk.addITEM(type1);
		  Object[] opAddEntryArgs = new Object[] {cwsk};
		  QName opAddEntry = new QName("urn:business2ecc:reverse_cwsk",
		  "MT_BUSINESS_REVERSE_CWSK_OUT_REQ");
		  
		  OMElement element = serviceClient.invokeBlocking(opAddEntry, opAddEntryArgs);   

		  
		  MT_BUSINESS_REVERSE_CWSK_OUT_RES res=(MT_BUSINESS_REVERSE_CWSK_OUT_RES)serviceClient.invokeBlocking(
				  opAddEntry,opAddEntryArgs ,new Class[] { MT_BUSINESS_REVERSE_CWSK_OUT_RES.class })[0];
		  System.out.println(res);*/
		 
        //stub访问
		SI_BUSINESS_REVERSE_CWSK_OUTServiceStub stub = new SI_BUSINESS_REVERSE_CWSK_OUTServiceStub();
		Options opt = stub._getServiceClient().getOptions();
		EndpointReference address = new EndpointReference(tmp);
		opt.setTo(address);
		opt.setProperty(HTTPConstants.SO_TIMEOUT, new Integer(30000));// 30秒后超时自动进入异常
		Authenticator authenticator = new Authenticator();
		//baomi见webService笔记中可以找到
		authenticator.setPassword("baomi");
		authenticator.setUsername("baomi");
		opt.setProperty(HTTPConstants.AUTHENTICATE, authenticator);
		stub._getServiceClient().setOptions(opt);

		ITEM_type1 type1 = new ITEM_type1();
		type1.setCity("1");
		type1.setGatheringID("2");
		type1.setGJAHR("3");
		type1.setVoucher("4");
		DT_BUSINESS_REVERSE_CWSK_OUT_REQ cwsk = new DT_BUSINESS_REVERSE_CWSK_OUT_REQ();
		cwsk.addITEM(type1);
		cwsk.addITEM(type1);
		MT_BUSINESS_REVERSE_CWSK_OUT_REQ req = new MT_BUSINESS_REVERSE_CWSK_OUT_REQ();
		req.setMT_BUSINESS_REVERSE_CWSK_OUT_REQ(cwsk);
		MT_BUSINESS_REVERSE_CWSK_OUT_RES res = stub
				.sI_BUSINESS_REVERSE_CWSK_OUT(req);
		ITEM_type0[] m0 = res.getMT_BUSINESS_REVERSE_CWSK_OUT_RES().getITEM();
		for (int i = 0; i < m0.length; i++) {
			System.out.println(m0[i].getMESTX());

		}

	}
}
