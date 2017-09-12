package cn.itcast.e_fileupload;

import java.io.File;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 文件下载
 * 1. 显示所有要下载文件的列表
 * 2. 文件下载
 * @author Jie.Yuan
 *
 */
public class DownAction extends ActionSupport {
	
	
	/*************1. 显示所有要下载文件的列表*********************/
	public String list() throws Exception {
		
		//得到upload目录路径
		String path = ServletActionContext.getServletContext().getRealPath("/upload");
		// 目录对象
		File file  = new File(path);
		// 得到所有要下载的文件的文件名
		String[] fileNames =  file.list();
		// 保存
		ActionContext ac = ActionContext.getContext();
		// 得到代表request的map (第二种方式)
		Map<String,Object> request= (Map<String, Object>) ac.get("request");
		request.put("fileNames", fileNames);
		return "list";
	}
	
	
	/*************2. 文件下载*********************/
	
	// 1. 获取要下载的文件的文件名
	private String fileName;
	public void setFileName(String fileName) {
		// 处理传入的参数中问题(get提交)
		try {
			fileName = new String(fileName.getBytes("ISO8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
		// 把处理好的文件名，赋值
		this.fileName = fileName;
	}
	
	//2. 下载提交的业务方法 (在struts.xml中配置返回stream)
	public String down() throws Exception {
		return "download";
	}
	
	// 3. 返回文件流的方法
	public InputStream getAttrInputStream(){
		return ServletActionContext.getServletContext().getResourceAsStream("/upload/" + fileName);
	}
	
	// 4. 下载显示的文件名（浏览器显示的文件名）
	public String getDownFileName() {
		// 需要进行中文编码
		try {
			fileName = URLEncoder.encode(fileName, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
		return fileName;
	}

	
}










