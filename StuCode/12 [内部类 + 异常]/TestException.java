import java.awt.*;
public class TestException{
	public static void main(String[] args)throws Exception{
		Robot bot = new Robot();//»úÆ÷ÈË
		while(true){
			int x = (int)(Math.random()*1024);
			int y = (int)(Math.random()*768);
			bot.mouseMove(x,y);
		}
	}
}