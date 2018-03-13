public class TestOverridePlus2{
	public static void main(String[] args){
		Gosu weixiao = new Gosu();
		weixiao.kill();//?

	}
}
class Noob{//noob = 菜鸟
	public void kill(){
		System.out.println("上来先开大 r");
		System.out.println("qwe乱丢");
		System.out.println("闪现撞到墙 黑白屏了");
	}
}
class Gosu extends Noob{
	@Override //Annotation = 注解 = 注释的注释 = 给机器看的注释
	public void kill(){
		System.out.println("先不断平a消耗");
		System.out.println("qwe各种技能连续丢");
		System.out.println("最后闪现开大收人头");
	}
}




