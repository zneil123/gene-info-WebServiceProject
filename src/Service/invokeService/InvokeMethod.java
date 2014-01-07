package Service.invokeService;

public class InvokeMethod {
	 public String getName()
	    {
	        try
	        {            
	            System.out.println("getName方法正在执行");
	            //  延迟5秒
	            Thread.sleep(5000);
	        }
	        catch (Exception e)
	        {        
	        }
	        return "火星";
	    }

}
