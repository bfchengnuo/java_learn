package cn.itcast.e_fileupload;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class FileUpload extends ActionSupport {

	// 对应表单：<input type="file" name="file1">
	private File file1; 
	// 文件名
	private String file1FileName;
	// 文件的类型(MIME)
	private String file1ContentType;
	public void setFile1(File file1) {
		this.file1 = file1;
	}
	public void setFile1FileName(String file1FileName) {
		this.file1FileName = file1FileName;
	}
	public void setFile1ContentType(String file1ContentType) {
		this.file1ContentType = file1ContentType;
	}
	
	
	@Override
	public String execute() throws Exception {
		/******拿到上传的文件，进行处理******/
		// 把文件上传到upload目录
		
		// 获取上传的目录路径
		String path = ServletActionContext.getServletContext().getRealPath("/upload");
		// 创建目标文件对象
		File destFile = new File(path,file1FileName);
		// 把上传的文件，拷贝到目标文件中
		FileUtils.copyFile(file1, destFile);
		
		return SUCCESS;
	}
}
