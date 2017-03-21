/**
 * Created by 冰封承諾Andy on 2017/3/16 0016.
 * 可变参数 和 枚举
 */
public class VarPar {
    public static void main(String[] args) {
        //可变参数
        int sum = testSum(1,2,3,4,5,6,7);
        System.out.println(sum);
        System.out.println(testSum(new int[]{1,2,3,4,5,6,7}));

        //枚举
        System.out.println(Grade.B.name());
        System.out.println(Grade.B);
        System.out.println(Grade.B.ordinal());  // 角标
        System.out.println(Grade.B.getValue());
        System.out.println(Grade.B.getAge());

//        将一个字符串转换成枚举类型，通常来判断（用户的表单提交）是否是合法值
        Grade g = Grade.valueOf("C");
//        Grade g = Grade.valueOf(Grade.class,"C"); // 同上
        System.out.println(g);

        Grade[] values = Grade.values(); // 取得枚举的所有值
    }

    // 可变参数只能写在最后，否则不能区分
    // 可变参数其实是个数组，所以传入一个数组也是可以的
    private static int testSum(int ...nums) {
        int sum = 0;
        for (int i :
                nums) {
            sum += i;
        }
        return sum;
    }

    // 相当于定义了一个类，A B C D都是一个obj对象
    enum Grade{
        //A,B,C,D; //相当于 Grade A = new Grade();

        A("欣妍"){
            @Override
            public String getAge() {
                return "12";
            }
        }

        ,B("诗茵"){
            @Override
            public String getAge() {
                return "13";
            }
        }

        ,C("娅楠"){
            @Override
            public String getAge() {
                return "14";
            }
        }

        ,D("凝萱"){
            @Override
            public String getAge() {
                return "15";
            }
        };

        private String value;
        // 定义一个抽象方法，这样的话这个枚举类也时抽象方法，在new的时候要实现这个抽象方法
        public abstract String getAge();

        // 构造函数,默认就是私有化
        Grade(String str){
            this.value = str;
        }

        public String getValue(){
            return this.value;
        }
    }
}
