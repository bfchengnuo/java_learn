public class TestOverridePlus3{
	public static void main(String[] args){

	}
}
class Animal{
	public Animal xiaZaiEr(){
		Animal an = new Animal();
		return an;
	}
}
class Fox extends Animal{
	@Override
	public Fox xiaZaiEr(){
		Fox fox = new Fox();
		return fox;
	}
}




