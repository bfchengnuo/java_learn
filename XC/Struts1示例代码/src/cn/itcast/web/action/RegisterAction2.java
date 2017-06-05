package cn.itcast.web.action;

import java.io.FileOutputStream;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;
import org.apache.struts.upload.FormFile;

import cn.itcast.web.formbean.RegisterFormBean;

public class RegisterAction2 extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		DynaActionForm dynaform = (DynaActionForm) form;
		System.out.println(dynaform.getString("username"));
		System.out.println(dynaform.getString("password"));
		System.out.println(dynaform.getString("email"));
		
		return null;
	}
}
