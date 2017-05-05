import java.util.ArrayList;
import java.util.List;


public class ActionInvocation {
	List<Interceptor> interceptors = new ArrayList<Interceptor>();
	int index = -1;
	Action a = new Action();
	
	public ActionInvocation() {
		this.interceptors.add(new FirstInterceptor());
		this.interceptors.add(new SecondInterceptor());
		
	}
	
	public void invoke() {
		index ++;
		if(index >= this.interceptors.size()) {		//递归结束条件
			a.execute();
		}else {
			System.out.println("第"+(index+1)+"个拦截器");
			this.interceptors.get(index).intercept(this);//递归语句
		}
	}
}
