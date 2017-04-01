import java.security.MessageDigest;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;


public class Encrypt {
	
	public static void main(String[] args){
		try {
			String s1 = getEncrypt("123".getBytes(), "MD5");
			System.out.println(s1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 数据加密
	 * @param data 加密的数据
	 * @param mode 加密模式
	 * @return 加密后的字串
	 * @throws Exception
	 *
	 * 科普 MD5
	 * md5的长度，默认为128bit，也就是128个0和1的二进制串。
	 * 这样的表达不是很友好
	 * 所以将二进制转成了16进制，每4个bit表示一个16进制，
	 * 所以128/4 = 32 换成16进制表示后，为32位了。
	 */
	public static String getEncrypt(byte[] data,String mode)throws Exception{
		//实例化-初始化
		MessageDigest md = MessageDigest.getInstance(mode);
		//处理数据
		md.update(data);
		//完成哈希计算，返回计算结果，MessageDigest对象被重置为初始状态
		byte[] digest = md.digest();
		//二进制转十六进制
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < digest.length; i++) {
			// 首先转成4位的 int 值，然后按位与运算
			// 一个字节是八位，所以如果不够16要补0，凑齐2个
			int temp = (int)digest[i] & 0xff;
			if (temp < 16) {
				sb.append("0");
			}
			sb.append(Integer.toHexString(temp));
		}
		return sb.toString();
		
	}
	
	/**
	 * AES加密
	 * @param data
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static byte[] aesEncrypt2bytes(String data,String key) throws Exception{
		//创建AES的生产者
		KeyGenerator Kgen =KeyGenerator.getInstance("AES");
		//利用指定的密钥生产出128位的key生产者
		Kgen.init(128,new SecureRandom(key.getBytes()));
		//创建密码器
		Cipher cipher = Cipher.getInstance("AES");
		//初始化为加密模式的密码器
		cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(Kgen.generateKey().getEncoded(), "AES"));
		//进行数据的加密并返回
		return cipher.doFinal(data.getBytes("UTF-8"));
	}
	
	/**
	 * AES解密
	 * @param data
	 * @param key
	 * @return
	 */
	public static String aesDecryptBybytes(String data,String key)throws Exception{
		KeyGenerator Kgen = KeyGenerator.getInstance("AES");
		Kgen.init(128,new SecureRandom(key.getBytes()));
		Cipher cipher=Cipher.getInstance("AES");
		//设置为解密模式
		cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(Kgen.generateKey().getEncoded(), "AES"));
		return new String(cipher.doFinal(),"UTF-8");
	}
}
