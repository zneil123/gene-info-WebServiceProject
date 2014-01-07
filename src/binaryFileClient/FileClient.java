package binaryFileClient;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import binaryFileDemo.FileServiceStub;
import binaryFileDemo.FileServiceStub.UploadWithByte;
import binaryFileDemo.FileServiceStub.UploadWithDataHandler;
 


 

public class FileClient {
	public static void main(String[] args) throws Exception{
		String tmp = "http://localhost:8880/axis2/services/FileService";
		 
		String imagePath="D:\\eclipse\\InfoStore\\WebServiceProject\\picture\\test.jpg";
		DataHandler dh = new DataHandler(new FileDataSource(imagePath));
		 
		UploadWithByte uwb = new UploadWithByte();
		uwb.setFile(dh);//源图片传输地址
		uwb.setFilename("D:\\eclipse\\InfoStore\\WebServiceProject\\picture\\test1.jpg");//产生新图片地址
		
		UploadWithByte uwb1 = new UploadWithByte();
		uwb1.setFile(dh);//源图片传输地址
		uwb1.setFilename("D:\\eclipse\\InfoStore\\WebServiceProject\\picture\\test3.jpg");//产生新图片地址
		
		UploadWithDataHandler udh=new UploadWithDataHandler();
		udh.setFile(dh);
		udh.setFilename("D:\\eclipse\\InfoStore\\WebServiceProject\\picture\\test2.jpg");//产生新图片地址
		FileServiceStub stub = new FileServiceStub(tmp);
        stub.uploadWithByte(uwb);
        stub.uploadWithByte(uwb1);
        stub.uploadWithDataHandler(udh);
		System.out.println("finish");
	}
}
