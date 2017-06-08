package com.bfchengnuo.web.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.validation.SkipValidation;

import java.io.File;

/**
 * Created by 冰封承諾Andy on 2017/6/7.
 * 注册页面，用到了数据的校验，所以继承 ActionSupport
 */
public class RegAction extends ActionSupport {
    private static final long serialVersionUID = 1006766693264599611L;
    private String name;
    private String age;

    // 上传文件相关，以及获取的文件名和类型
    private File img;
    private String imgFileName;
    private String imgContentType;

    // 到达注册页面,本方法不应该被校验
    @SkipValidation
    public String toReg() {
        return "regView";
    }

    public String reg() {
        // 获取上传的文件
        String dir = ServletActionContext.getServletContext().getRealPath("/upload");
        System.out.println(dir);
        String ext = imgFileName.substring(imgFileName.lastIndexOf("."));
        long l = System.nanoTime();

        File file = new File(dir, l + ext);
        img.renameTo(file);
        return "success";
    }

    @Override
    public void validate() {
        if (name == null || name.isEmpty()) {
            addFieldError("name",getText("error.name.empty"));
        }
    }

    // 去校验的第二种方法---加后缀法指定校验方法，这种其他过滤器也通用，注解是特有的
    // public void validateReg() {
    //     if (name == null || name.isEmpty()) {
    //         addFieldError("name",getText("error.name.empty"));
    //     }
    // }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public File getImg() {
        return img;
    }

    public void setImg(File img) {
        this.img = img;
    }

    public String getImgFileName() {
        return imgFileName;
    }

    public void setImgFileName(String imgFileName) {
        this.imgFileName = imgFileName;
    }

    public String getImgContentType() {
        return imgContentType;
    }

    public void setImgContentType(String imgContentType) {
        this.imgContentType = imgContentType;
    }
}
