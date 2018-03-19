public class TestInterface{
	public static void main(String[] args){
		Computer pc = new Computer();
		USB ie30 = new Mouse();//接口类型 实现类对象也能体现多态
		USB kb = new Keyboard();
		pc.openDevice(ie30);
		pc.openDevice(kb);

		Tank tk = new Tank();
		pc.openDevice(tk);
	}
}
interface A{}
interface B{}
interface C extends A,B{}

interface USB{
	//接口当中定义的变量 默认就是常量 自动添加三个修饰符
	//public static final
	int v = 5;//USB接口额定电压5V

	//接口当中定义的方法 默认就是公共的抽象方法
	//public abstract
	void connect();
}
class Mouse implements USB{//类和接口 不可能是继承关系 而是实现关系
	@Override
	public void connect(){
		System.out.println("USB鼠标连接电脑的方法");
	}
}
class Keyboard implements USB{
	@Override
	public void connect(){
		System.out.println("USB键盘连接电脑的方法");
	}
}
class Tank implements USB{
	@Override
	public void connect(){
		System.out.println("USB坦克连接电脑的方法");
	}
}

class Computer{
	public void openDevice(USB x){
		x.connect();
	}
}