package cn.itcast.d_component;

import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.junit.Test;

public class App {
	
	private static SessionFactory sf;
	static {
		sf = new Configuration()
			.configure()
			.addClass(Car.class)   
			.buildSessionFactory();
	}

	@Test
	public void getSave() {
		
		Session session = sf.openSession();
		session.beginTransaction();
		
		// ÂÖ×Ó
		Wheel wheel = new Wheel();
		wheel.setSize(38);
		wheel.setCount(4);
		// Æû³µ
		Car car = new Car();
		car.setName("BMW");
		car.setWheel(wheel);
		
		// ±£´æ
		session.save(car);
		
		session.getTransaction().commit();
		session.close();
		
	}
	
}
