package WS_SAPForeman;

import javax.xml.namespace.QName;

import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.context.MessageContext;
import org.apache.axis2.rpc.client.RPCServiceClient;
import org.apache.axis2.transport.http.HTTPConstants;
import org.apache.axis2.transport.http.HttpTransportProperties.Authenticator;



import ForemanDemo.SI_BUSINESS_XMJLFK_OUTServiceCallbackHandler;
import ForemanDemo.SI_BUSINESS_XMJLFK_OUTServiceStub;
import ForemanDemo.SI_BUSINESS_XMJLFK_OUTServiceStub.DT_BUSINESS_XMJLFK_OUT;
import ForemanDemo.SI_BUSINESS_XMJLFK_OUTServiceStub.ITEM_type0;
import ForemanDemo.SI_BUSINESS_XMJLFK_OUTServiceStub.ITEM_type1;
import ForemanDemo.SI_BUSINESS_XMJLFK_OUTServiceStub.MT_BUSINESS_XMJLFK_OUT;
import ForemanDemo.SI_BUSINESS_XMJLFK_OUTServiceStub.MT_ECC_XMJLFK_IN;

public class WSTestForeman {
	public static void main(String[] args) throws Exception {
		//baomi见webService笔记中可以找到
		String tmp = "http://baomi/XISOAPAdapter/MessageServlet?channel=:BS_BUSINESS:CC_BUSINESS_SOAP_OUT_XMJLFK&amp;version=3.0&amp;Sender.Service=BS_BUSINESS&amp;Interface=urn%3Abusiness2hr%3Axmjlfk%5ESI_BUSINESS_XMJLFK_OUT";
 
		SI_BUSINESS_XMJLFK_OUTServiceStub stub = new SI_BUSINESS_XMJLFK_OUTServiceStub();
		Options opt = stub._getServiceClient().getOptions();
		EndpointReference address = new EndpointReference(tmp);
		opt.setTo(address);
		opt.setProperty(HTTPConstants.SO_TIMEOUT, new Integer(300000));
		Authenticator authenticator = new Authenticator();
		//baomi见webService笔记中可以找到
		authenticator.setPassword("baomi");
		authenticator.setUsername("baomi");
		opt.setProperty(HTTPConstants.AUTHENTICATE, authenticator);
		opt.setProperty(HTTPConstants.CHUNKED, "false");
		stub._getServiceClient().setOptions(opt);

		DT_BUSINESS_XMJLFK_OUT param1 = new DT_BUSINESS_XMJLFK_OUT();
		ITEM_type0 m0 = new ITEM_type0();
		m0.setBUDAT("20130303");
		m0.setBUKRS("2");
		m0.setLIFNR("3");
		m0.setPRCTR("4");
		m0.setREASON("5");
		m0.setWRBTR("6");
		m0.setXBLNR("7");

		param1.addITEM(m0);
		MT_BUSINESS_XMJLFK_OUT req = new MT_BUSINESS_XMJLFK_OUT();
		req.setMT_BUSINESS_XMJLFK_OUT(param1);

		try {
			SI_BUSINESS_XMJLFK_OUTServiceStub.MT_ECC_XMJLFK_IN res = stub
					.sI_BUSINESS_XMJLFK_OUT(req);

			ITEM_type1[] m1 = res.getMT_ECC_XMJLFK_IN().getITEM();
			for (int i = 0; i < m1.length; i++) {
				System.out.println(m1[i].getMSGTX());

			}

		} catch (Exception e) {
			e.printStackTrace();

		}

	}
}
