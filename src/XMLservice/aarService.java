package XMLservice;
//控制台jar cvf ws.aar . //注意后面有个"."
public class aarService {
	public String getGreeting(String name) {
		return "您好" + name;
	}

	public void update(String data) {
		System.out.println("<" + data + ">已经更新");
	}
}