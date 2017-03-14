import java.util.*;

/**
 * Created by 冰封承諾Andy on 2017/3/14 0014.
 * 实现对象集合的比较
 */
public class CompTest {

    public static void main(String[] args) {
//        List<Person> list = new ArrayList<>();
//        list.add(new Person("凝萱",12));
//        list.add(new Person("欣妍",10));
//        list.add(new Person("诗茵",7));
//        list.add(new Person("茹雪",17));
//        list.add(new Person("娅楠",22));
//        list.add(new Person("沛凝",5));
//
//        System.out.println(list);
//
//        Collections.sort(list);
//
//        System.out.println(list);

        // 第二种方式

        List<Person2> list = new ArrayList<>();
        list.add(new Person2("凝萱",12));
        list.add(new Person2("欣妍",10));
        list.add(new Person2("诗茵",7));
        list.add(new Person2("茹雪",17));
        list.add(new Person2("娅楠",22));
        list.add(new Person2("沛凝",5));

        System.out.println(list);

//        Collections.sort(list, new PersonComparator());
        list.sort(new PersonComparator());

        System.out.println(list);
    }

}

class Person implements Comparable<Person> {
    private int age;
    private String name;
    public Person(String name, int age) {
        this.age = age;
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    //实现Comparable接口的compareTo方法
    @Override
    public int compareTo(Person o) {
        // 如果是和自己比，直接返回0，就是相等
        if (this == o)
            return 0;
        // 实际就是按照年龄进行排序
        return this.age - o.age;
    }

    @Override
    public String toString() {
        return "Person[name=" + name + ", age=" + age + "]";
    }
}

class Person2 {
    private int age;
    private String name;
    public Person2(String name, int age) {
        this.age = age;
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person[name=" + name + ", age=" + age + "]";
    }
}

//这是一个比较器，用于比较Person对象
class PersonComparator implements Comparator<Person2> {
    @Override
    public int compare(Person2 o1, Person2 o2) {
        //两个Person对象的比较过程，当然，这里可以实现更多更复杂的比较过程
        return o1.getAge() - o2.getAge();
    }
}
