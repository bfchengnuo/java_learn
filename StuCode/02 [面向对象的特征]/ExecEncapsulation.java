public class ExecEncapsulation{
	public static void main(String[] args){
		//要求 请按照封装的要求改写Rect类体当中的代码
		//之后创建两个长方形对象 一个长5宽3 一个长8宽2
		Rect no1 = new Rect();
		no1.setLength(5);
		no1.setWidth(3);
		Rect no2 = new Rect();
		no2.setLength(8);
		no2.setWidth(2);

		no1.showArea();
		no2.showArea();

	}
}
class Rect{
	private int length;//长度
	private int width;//宽度
	//用于设置属性的setter
	public void setLength(int length){
		this.length = length;
	}
	public void setWidth(int width){
		this.width = width;
	}
	//用于得到属性的getter
	public int getLength(){
		return length;
	}
	public int getWidth(){
		return width;
	}

	//显示自己的面积
	public void showArea(){
		System.out.println(length * width);
	}
}