public class TestArrayList8{
	public static void main(String[] args){
		EtoakList list = new EtoakList();
		list.add(111);
		list.add(222);
		list.add(333);

		for(int i = 0;i<list.size();i++){
			System.out.println(list.get(i));
		}
	}
}
//模拟实现ArrayList所有核心功能
class EtoakList{
	private Object[] data;
	private int size;//0
	public EtoakList(int x){
		data = new Object[x];
	}
	public EtoakList(){
		this(10);
	}
	//得到元素个数的方法 size()
	public int size(){
		return size;
	}
	//得到第几个元素的方法 get()
	public Object get(int x){
		return data[x];
	}
	//添加元素的方法 add()
	public void add(Object obj){
		if(size == data.length){//如果筐已经满了
			Object[] temp = new Object[size*3/2+1];//找来一个更大的新筐
			System.arraycopy(data,0,temp,0,size);//将老筐里面的棒子转移到新筐内
			data = temp;//背上新筐(扔掉老筐)
		}
		data[size++] = obj;//把新棒子放入筐里
	}
	//删除元素的方法1 remove(int)
	public void remove(int x){
		System.arraycopy(data,x+1,data,x,size-- - x-1);
	}
	//删除元素的方法2 remove(Object)
	public void remove(Object obj){
		for(int i = 0;i<size;i++){
			if(obj.equals(data[i])){
				remove(i);
				return;
			}
		}
	}
}






