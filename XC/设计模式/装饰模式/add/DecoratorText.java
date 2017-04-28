package add;

public class DecoratorText {

	/*
	 * 1、什么是装饰模式？
	 * 装饰模式又名包装(Wrapper)模式，装饰模式以对客户透明的方式动态的给一个对象附加上更多的责任。装饰模式在不必改变原类文件和使用继承的情况下
	 * ，动态的扩展一个对象的功能。它是通过创建一个包装对象，也就是装饰来包裹真实的对象。
	 * 
	 * 2、为什么使用装饰模式？
	 * 我们通常使用继承来实现功能的扩展，如果这些需要扩展的功能的种类很繁多，那么势必会生成很多子类，增加系统的复杂性。同时，使用继承实现功能扩展
	 * ，必须先知道这些扩展功能的作用，这些功能是在编译时就确定了的，是静态的。
	 * 而使用装饰模式可以在不创造更多子类的情况下，将对象的功能加以扩展，是继承关系的一个替代方案。
	 * 
	 * 3、装饰模式的角色和特点？ 角色构成： -抽象构件角色：给出一个抽象接口，以规范准备接收附加责任的对象。
	 * -具体构件角色：定义一个将要接收附加责任的类。 -装饰角色：持有一个构件对象的引用，并定义一个与抽象构件接口一致的接口。
	 * -具体装饰角色：负责给构件对象“贴上”附加的责任。
	 * 
	 * 装饰模式的特点： 1.装饰对象和真实对象有相同的接口。这样客户端对象就可以以和真实对象相同的方式和装饰 对象交互。
	 * 2.装饰对象包含一个真实对象的引用(reference)。 3.装饰对象接收所有来自客户端的请求。它把这些请求转发给真实对象。
	 * 4.装饰对象可以在转发这些请求以前或者以后增加一些附加功能
	 * 。这样就确保了在运行时，不用修改给定对象的结构就可以在外部增加附加的功能。而在面向对象设计中，通常是通过继承来实现对给定类的功能扩展。
	 * 
	 * 4、装饰模式与继承的区别？ 装饰模式 继承 用来扩展特定对象的功能 用来扩展一类对象的功能 不需要子类 需要子类 运行时分配职责 编译时分配职责
	 * 防止由于子类而导致的复杂和混乱 导致很多子类产生 更多的灵活性 缺乏灵活性
	 */

	
	
	//待添加
	public static void main(String[] args) {

		Component component = new ConcreteDecorator2(new ConcreteDecorator1(
				new ConcreteComponent()));

		component.doSomething();
	}

}

// 抽象构件接口，规范准备接收附加责任的对象
interface Component {
	public void doSomething();
}

// 具体构件角色
class ConcreteComponent implements Component {
	@Override
	public void doSomething() {
		System.out.println("功能A");
	}
}

// 装饰角色：持有一个构件(Component)对象的引用
class Decorator implements Component {
	private Component component;

	public Decorator(Component component) {
		this.component = component;
	}

	@Override
	public void doSomething() {
		component.doSomething();
	}
}

// 具体装饰角色1，负责给构件对象"贴上"附加的责任，即添加新的功能
class ConcreteDecorator1 extends Decorator {
	public ConcreteDecorator1(Component component) {
		super(component);
	}

	@Override
	public void doSomething() {
		super.doSomething();
		this.doAnotherThing();
	}

	private void doAnotherThing() {
		System.out.println("功能B");
	}
}

// 具体装饰角色2
class ConcreteDecorator2 extends Decorator {
	public ConcreteDecorator2(Component component) {
		super(component);
	}

	@Override
	public void doSomething() {
		super.doSomething();
		this.doAnotherThing();
	}

	private void doAnotherThing() {
		System.out.println("功能B");
	}
}
