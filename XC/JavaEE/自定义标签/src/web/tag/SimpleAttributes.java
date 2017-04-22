package web.tag;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

/**
 * Created by 冰封承諾Andy on 4/20/2017.
 * 自定义标签的属性
 */
public class SimpleAttributes extends SimpleTagSupport {
    // 自定义的属性
    private int cont;

    // 可以自动转换八大基本数据类型
    public void setCont(int cont) {
        this.cont = cont;
    }

    @Override
    public void doTag() throws JspException, IOException {
        PageContext context = (PageContext) this.getJspContext();
        HttpServletRequest request = (HttpServletRequest) context.getRequest();

        JspFragment jf = this.getJspBody();
        for (int i = 0; i < cont; i++) {
            jf.invoke(null);
        }
    }
}
