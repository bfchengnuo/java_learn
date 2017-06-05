package cn.itcast.web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;

public class BookAction2 extends MappingDispatchAction {

	public ActionForward add(ActionMapping arg0, ActionForm arg1,
			HttpServletRequest arg2, HttpServletResponse arg3) throws Exception {
		
		System.out.println("add");
		return null;
	}
	
	public ActionForward update(ActionMapping arg0, ActionForm arg1,
			HttpServletRequest arg2, HttpServletResponse arg3) throws Exception {

		System.out.println("update");
		return null;
	}
	
	public ActionForward find(ActionMapping arg0, ActionForm arg1,
			HttpServletRequest arg2, HttpServletResponse arg3) throws Exception {

		System.out.println("find");
		return null;
	}
	
	public ActionForward delete(ActionMapping arg0, ActionForm arg1,
			HttpServletRequest arg2, HttpServletResponse arg3) throws Exception {

		System.out.println("delete");
		return null;
	}
	
}
