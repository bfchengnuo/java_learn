public class TestArrayOfArray{
	public static void main(String[] args){
		int[][] data = new int[12][];
		data[0] = new int[4];
		data[1] = new int[4];
		data[2] = new int[5];
		data[3] = new int[5];
		//....

		for(int x = 0;x<data.length;x++){
			for(int y = 0;y<data[x].length;y++){
				System.out.println(data[x][y]);
			}
		}
	}
}