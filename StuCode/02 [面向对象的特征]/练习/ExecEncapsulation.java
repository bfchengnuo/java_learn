public class ExecEncapsulation{
	public static void main(String[] args){
		Rect r1 = new Rect();
		Rect r2 = new Rect();
		
		r1.setLength(5);
		r1.setWidth(3);
		
		r2.setLength(8);
		r2.setWidth(2);
		
		System.out.println("r1--->" + r1.getLength() + "," + r1.getWidth());
		System.out.println("r2--->" + r2.getLength() + "," + r2.getWidth());
	}
}

class Rect{
	private int length;
	private int width;
	
	public int getLength(){
		return length;
	}
	public void setLength(int length){
		this.length = length;
	}
	
	public int getWidth(){
		return width;
	}
	public void setWidth(int width){
		this.width = width;
	}
}