import java.util.*;
/*
	使用HashSet 千万不要在添加元素之后
	直接修改参与生成哈希码的属性
	否则会导致非常可怕的事情发生

	如果需求决定一定要去修改 请三个步骤完成：
		1.删除
		2.修改属性
		3.重新添加 [重新确定元素该在的位置！]
*/
public class TestHashSet8{
	public static void main(String[] args){
		Set<Teacher> etoak = new HashSet<>();
		Teacher tea = new Teacher("Jay",16);
		etoak.add(tea);//tea.hashCode() "Jay"+16
		etoak.remove(tea);//1st.
		tea.age = 61;//2nd.
		etoak.add(tea);
		System.out.println(etoak);

	}
}
class Teacher{
	String name;
	int age;
	public Teacher(String name,int age){
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString(){
		return name + " : " + age;
	}
	@Override
	public int hashCode(){
		return name.hashCode() + age;
	}
	@Override
	public boolean equals(Object obj){
		if(obj == null) return false;
		if(!(obj instanceof Teacher)) return false;
		if(obj == this) return true;
		Teacher t1 = this;
		Teacher t2 = (Teacher)obj;
		return t1.name.equals(t2.name) && t1.age == t2.age;
	}
}