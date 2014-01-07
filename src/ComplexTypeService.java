import java.io.FileOutputStream;

import ComplexTypedata.DataForm;

public class ComplexTypeService {

	// 　上传图像，imageByte参数表示上传图像文件的字节，
	// 　length参数表示图像文件的字节长度（该参数值可能小于imageByte的数组长度）
	public boolean uploadImageWithByte(byte[] imageByte, int length) {
		FileOutputStream fos = null;
		try {
			// 将上传的图像保存在D盘的test1.jpg文件中
			fos = new FileOutputStream("D:\\eclipse\\InfoStore\\WebServiceProject\\picture\\test1.jpg");
			// 　开始写入图像文件的字节
			fos.write(imageByte, 0, length);
			fos.close();
		} catch (Exception e) {
			return false;
		} finally {
			if (fos != null) {
				try {
					fos.close();
				} catch (Exception e) {
				}
			}
		}
		return true;
	}

	// 　返回一维字符串数组
	public String[] getArray() {
		String[] strArray = new String[] { "自行车", "飞机", "火箭" };
		return strArray;
	}

	// 　返回二维字符串数组
	public String[] getMDArray() {
		String[] strArray = new String[] { "自行车,飞机,火箭", "中国,美国,德国",
				"超人,蜘蛛侠,钢铁侠" };
		return strArray;
	}

	// 　返回DataForm类的对象实例
	public DataForm getDataForm() {
		return new DataForm();
	}

	// 　将DataForm类的对象实例序列化，并返回序列化后的字节数组
	public byte[] getDataFormBytes() throws Exception {
		java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();  
		java.io.ObjectOutputStream oos = new java.io.ObjectOutputStream(baos);  
	    oos.writeObject(new DataForm());          
		return baos.toByteArray(); 
	}
	//如果觉得服务器端代码中的某个方法有问题，用main函数检验一下该方法是否可行
	//例如org.apache.axis2.AxisFault: ComplexTypedata.DataForm，表示DataForm类有问题
/*	public static void main(String[] args) throws Exception{
		ComplexTypeService tmp = new ComplexTypeService();
		byte[] buffer =tmp.getDataFormBytes();
		java.io.ObjectInputStream ois = new java.io.ObjectInputStream(new java.io.ByteArrayInputStream(buffer));
		DataForm df = (DataForm) ois.readObject();
		System.out.println(df.getName());
	}*/
}
