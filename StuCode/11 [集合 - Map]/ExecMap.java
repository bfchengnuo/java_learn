import java.util.*;
public class ExecMap{
	public static void main(String[] args){
		Map<String,Integer> map = new HashMap<>();
		map.put("[蜀] 赵子龙",96);
		map.put("[蜀] 关云长",92);
		map.put("[群] 吕奉先",100);
		map.put("[魏] 夏侯妙才",86);
		map.put("[魏] 张文远",91);
		map.put("[魏] 郭奉孝",38);
		map.put("[蜀] 诸葛孔明",60);
		map.put("[吴] 周公瑾",86);
		map.put("[吴] 鲁子敬",40);
		//map.put("[魏] 郭奉孝",map.get("[魏] 郭奉孝")+10);
		//请统计所有蜀国武将的平均武力值   entrySet()
		{
			int sum = 0,count = 0;
			Set<Map.Entry<String,Integer>> es = map.entrySet();
			for(Map.Entry<String,Integer> e : es){
				String k = e.getKey();
				Integer v = e.getValue();
				if(k.startsWith("[蜀]")){
					sum += v;
					count++;
				}
			}
			System.out.println(sum / count);
		}
		//蜀中大旱 所有蜀国武将武力值上升10%  Map.Entry
		{
			for(Map.Entry<String,Integer> e : map.entrySet()){
				String k = e.getKey();
				Integer v = e.getValue();
				if(k.startsWith("[蜀]")){
					e.setValue(v*11/10);
				}
			}
		}
		//请问总共有多少个 吴国的将领信息
		{
			int count = 0;
			for(String k : map.keySet()){
				if(k.startsWith("[吴]")){
					count++;
				}
			}
			System.out.println(count);
		}
		//请问总共有多少个 名字像鬼子的将领信息
		{
			int count = 0;
			for(String k : map.keySet()){
				if(k.length() > 7){
					count++;
				}
			}
			System.out.println(count);
		}
		//请问所有武将平均武力值多少
		{
			int sum = 0;
			for(Integer v : map.values()){
				sum += v;
			}
			System.out.println(sum/map.size());
		}
		//请问最高武力值和最低武力值是多少
		{
			int max = 0,min = 999;
			for(Integer v : map.values()){
				if(v > max){
					max = v;
				}
				if(v < min){
					min = v;
				}
			}
			System.out.println(max);
			System.out.println(min);
		}

		//请问map集合总共有多少个英雄
		System.out.println(map.size());
		//请问 蜀国武将赵子龙 武力值多少
		System.out.println(map.get("[蜀] 赵子龙"));
		//请问 是否有武力值100的武将
		System.out.println(map.containsValue(100));
		//请问 是否有收录 吴国的 周公瑾将军
		System.out.println(map.containsKey("[吴] 周公瑾"));
		//郭奉孝病逝 请删除魏国郭奉孝
		map.remove("[魏] 郭奉孝");
	}
}