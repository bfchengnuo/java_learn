package web.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTag;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.Tag;

/**
 * Created by 冰封承諾Andy on 4/19/2017.
 * 自定义标签
 */
public class UpdateTag extends BodyTagSupport {

    @Override
    public int doStartTag() throws JspException {
        // 返回值为 EVAL_BODY_BUFFERED 会自动调用 setBodyContent(BodyContent b)
        // 然后就可以在 End 标签里获取到内容了
        return BodyTag.EVAL_BODY_BUFFERED;
    }

    @Override
    public int doEndTag() throws JspException {
        BodyContent bodyContent = this.getBodyContent();
        String content = bodyContent.getString();

        return Tag.EVAL_PAGE;
    }
}
