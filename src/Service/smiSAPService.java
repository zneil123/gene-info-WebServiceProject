package Service;

import SAPItems.ItemsList;
import SAPItems.UserItem1;
import SAPItems.UserItem2;

public class smiSAPService {
	private UserItem1 array1[];
	private UserItem2 array2[];
	private int count = 0;

	// 原始函数
	public UserItem2[] smiSAPRelease(UserItem1[] item1) {
		array2 = new UserItem2[item1.length];
		for (int i = 0; i < item1.length; i++) {
			count++;
			array2[i] = new UserItem2();
			array2[i].setName(item1[i].getName());
			array2[i].setVoucher(String.valueOf(count));
		}
		return array2;
	}

	// 改进型函数
	public UserItem2[] smiSAPimprove(ItemsList itemlist) {
		array1 = itemlist.getDTItemsList1();
		array2 = new UserItem2[itemlist.getDTItemsList1().length];
		for (int i = 0; i < array1.length; i++) {
			count++;
			array2[i] = new UserItem2();
			array2[i].setName(array1[i].getName());
			array2[i].setVoucher(String.valueOf(count));
		}
		return array2;
	}
	/*
	 * public static void main(String[] args) { UserItem2 array2[] = new
	 * UserItem2[2]; UserItem1 array1[] = new UserItem1[2]; UserItem1 item1 =
	 * new UserItem1(); item1.setDept("IT"); item1.setName("tom"); array1[0]=
	 * item1; array1[1]= item1; smiSAPService s = new smiSAPService(); array2 =
	 * s.smiSAPRelease(array1); System.out.println(array2[0].getVoucher()); }
	 */

}
