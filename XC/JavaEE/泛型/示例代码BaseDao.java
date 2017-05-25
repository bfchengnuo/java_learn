package cn.itcast.generic;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import org.hibernate.Session;
import cn.itcast.domain.Category;

//T extends Serializable & Cloneable   限定处理的类型
public class BaseDao<T extends Serializable & Cloneable> {  

	private Session session;
	private Class clazz;
	
	public BaseDao(){
		ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();//BaseDao<Category>
		clazz = (Class) pt.getActualTypeArguments()[0];
	}
	
	public void add(T t){
		session.save(t);
	}
	
	public T find(String id){
		return (T) session.get(clazz,id);
	}
	
	public void update(T t){
		session.update(t);
	}
	
	public void delete(String id){
		T t = (T) session.get(clazz,id);
		session.delete(t);
	}
	
}
