import java.util.*;
/*
	HashSet构造方法的两个参数：
		int 分组组数 默认是16
			可以随意指定但是最终结果一定会是2的n次方数
		float 加载因子 默认0.75F

		阈值 Threshold = 分组组数*加载因子
			阈值：达到某个条件的最小临界值
				  哈希表扩容的最小大小

		达到或者超过阈值 哈希表就会扩容
			让原本的分组组数*2
			而且涉及到所有老元素重新散列
			这会影响效率
		我们如果已经知道最终要存放多少个元素
			请保证 分组组数*加载因子>元素总量
			在这个前提下
			分组组数变大 牺牲空间 提高效率
			分组组数不变 加载因子变大 牺牲效率 保证节约空间

	*:HashSet如何调整性能?

*/
public class TestHashSet9{
	public static void main(String[] args){
		Set<Integer> set = new HashSet<>(16,0.75F);
	}
	public static void get(int x){//7
		int okay = 1;
		while(okay < x){
			okay <<= 1;
		}
		System.out.println(okay);
	}
}