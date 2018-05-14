package com.etoak.test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

/**
 *
 * @author Kerronex
 * @version 创建时间：2018年4月26日 上午10:58:25
 */
public class WriteXml {

	public static void main(String[] args) {
		// 1.创建一个文档对象模型
		Document doc = DocumentHelper.createDocument();
		// 2.创建根元素
		Element root = doc.addElement("root");
		// 3.创建一级子元素
		Element student = root.addElement("student");
		// 4.添加属性
		student.addAttribute("id", "et001");
		student.addAttribute("name", "Penny");
		// 5.添加二级子元素
		Element email = student.addElement("email");
		email.setText("et001@etoak.com");
		Element phone = student.addElement("phone");
		phone.setText("1111");
		
		try {
			OutputStream ops = new FileOutputStream("etoak2.xml");
			// 设置自动换行的 XML
			OutputFormat format = OutputFormat.createPrettyPrint();
			// 设置编码
			format.setEncoding("utf-8");
			
			// 输出文本
			XMLWriter xw = new XMLWriter(ops,format);
			xw.write(doc);
			xw.flush();
			xw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
