import java.util.*;
public class TestThreeMethods{
	public static void main(String[] args){
		List<String> xm = new ArrayList<>();
		Collections.addAll(xm,"语文","数学","英语");
		List<String> xg = new ArrayList<>();
		Collections.addAll(xg,"数学","物理","化学");
		//求小明喜欢而小刚不喜欢的所有课
		{
			List<String> mg = new ArrayList<>();
			mg.addAll(xm);
			mg.removeAll(xg);
			System.out.println(mg);
		}

		//求小明和小刚都喜欢的课 : 数学    retainAll()
		{
			List<String> mg = new ArrayList<>();
			mg.addAll(xm);
			mg.retainAll(xg);
			System.out.println(mg);
		}

		//两个人喜欢的所有课程   addAll()
		{
			List<String> mg = new ArrayList<>();
			mg.addAll(xm);
			mg.addAll(xg);
		}


	}
}