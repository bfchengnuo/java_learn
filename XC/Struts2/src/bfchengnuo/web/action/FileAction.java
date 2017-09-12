package com.bfchengnuo.web.action;

import org.apache.struts2.ServletActionContext;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by 冰封承諾Andy on 2017/6/18.
 * 测试文件下载
 */
public class FileAction {
    private String fileName;

    public String stream() {
        try {
            fileName = URLEncoder.encode("雷姆","utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "stream";
    }

    // 让其得到输入流
    public InputStream getIs() {
        String dir = ServletActionContext.getServletContext().getRealPath("/upload/1.jpg");
        try {
            return new FileInputStream(dir);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
