package Client;

import smiDemo.SmiSAPServiceStub;
import smiDemo.SmiSAPServiceStub.ItemsList;
import smiDemo.SmiSAPServiceStub.SmiSAPRelease;
import smiDemo.SmiSAPServiceStub.SmiSAPimprove;
import smiDemo.SmiSAPServiceStub.UserItem1;
import smiDemo.SmiSAPServiceStub.UserItem2;

public class  SAPClient {
	public static void main(String[] args) throws Exception{
		String tmp = "http://localhost:8880/axis2/services/smiSAPService?wsdl";
		SmiSAPServiceStub stub = new SmiSAPServiceStub(tmp);
		SmiSAPRelease req=new SmiSAPRelease();
		
		UserItem1 item1=new UserItem1();
		item1.setDept("IT");
		item1.setName("Tom");
		UserItem1 item12=new UserItem1();
		item12.setDept("Finance");
		item12.setName("Juno");
		req.addItem1(item1);
		req.addItem1(item12);
		UserItem2[] item2=stub.smiSAPRelease(req).get_return();
		for (int i = 0; i < item2.length; i++) {
			System.out.println(item2[i].getVoucher());
		}
		ItemsList list =new ItemsList();
		list.addDTItemsList1(item1);
		list.addDTItemsList1(item12);
		SmiSAPimprove req2=new SmiSAPimprove();
		req2.setItemlist(list);
		UserItem2[] item21=stub.smiSAPimprove(req2).get_return();
		for (int i = 0; i < item21.length; i++) {
			System.out.println(item21[i].getVoucher());
		}
		
	}

}
