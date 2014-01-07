package binaryFileService;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;

public class FileService {
//  使用byte[]类型参数上传二进制文件
    public boolean uploadWithByte(byte[] file, String filename)
    {
         FileOutputStream fos = null;
         try
         {                          
             fos = new FileOutputStream(filename);    
             fos.write(file);
             fos.close();
         }
         catch (Exception e)
         {
             return false;
         }
         finally
         {
             if (fos != null)
             {
                 try
                 {
                     fos.close();
                 }
                 catch (Exception e)
                 {
                 }
             }
         }
         return true;
    }
    private void writeInputStreamToFile(InputStream is, OutputStream os) throws Exception
    {
         int n = 0;
         byte[] buffer = new byte[8192];
         while((n = is.read(buffer)) > 0)
         {
             os.write(buffer, 0, n);
         }
    }
    //  使用DataHandler类型参数上传文件
    public boolean uploadWithDataHandler(DataHandler file, String filename)
    {
        
         FileOutputStream fos = null;
         try
         {            
             fos = new FileOutputStream(filename);   
             //  可通过DataHandler类的getInputStream方法读取上传数据
             writeInputStreamToFile(file.getInputStream(), fos);
             fos.close();
         }
         catch (Exception e)
         {
             return false;
         }
         finally
         {
             if (fos != null)
             {
                 try
                 {
                     fos.close();
                 }
                 catch (Exception e)
                 {
                 }
             }
         }
         return true;
    }
    
/*    public static void main(String[] args) throws Exception{
    	java.io.File file = new java.io.File("D:\\eclipse\\InfoStore\\WebServiceProject\\picture\\test.jpg");
		java.io.FileInputStream fis = new java.io.FileInputStream(
				"D:\\eclipse\\InfoStore\\WebServiceProject\\picture\\test.jpg");
		// 创建保存要上传的图像文件内容的字节数组
		byte[] buffer = new byte[(int) file.length()];
		// 将图像文件的内容读取buffer数组中
		fis.read(buffer);
    	FileService ff=new FileService();
    	 ff.uploadWithByte(buffer, "D:\\eclipse\\InfoStore\\WebServiceProject\\picture\\test1.jpg");
    	 
	}*/

}
