package com.etoak.test;

import java.io.File;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 *
 * @author Kerronex
 * @version 创建时间：2018年4月26日 上午9:38:18
 */
public class ReadXml {

	public static void main(String[] args) {
		// 使用 Java 代码来读取一个已存在的 XML 文件
		try {
			// 1.拿取 Dom4j 的解析器
			SAXReader sax = new SAXReader();
			// 2.使用解析器读取XML文档，拿取文档对象模型
			Document doc = sax.read(new File("etoak1.xml"));
			// 3.拿取根元素
			Element root = doc.getRootElement();
			System.out.println("根元素是：" + root.getName());
			// 4.拿取所有的一级元素
			List<Element> firstChild = root.elements();
			// 5.遍历
			for (Element element : firstChild) {
				System.out.println("一级子元素是：" + element.getName());
				// 6.拿取一级子元素的所有属性
				List<Attribute> firstChildAttr = element.attributes();
				for (Attribute attribute : firstChildAttr) {
					System.out.println(element.getName() + "属性为" + attribute.getName() +
							", 值为：" + attribute.getValue());
				}
				
				// 7.使用一级子元素拿取二级子元素
				List<Element> secondChild = element.elements();
				for (Element secondElement : secondChild) {
					System.out.println("二级子元素：" + secondElement.getName());
					System.out.println(secondElement.getName() + "嵌套的值是：" + secondElement.getText());
				}
				
				System.out.println();
			}
			
			
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

}
