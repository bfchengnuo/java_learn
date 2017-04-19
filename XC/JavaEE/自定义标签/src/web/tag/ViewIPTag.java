package web.tag;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.IterationTag;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

/**
 * Created by 冰封承諾Andy on 4/19/2017.
 * 一般自定义标签
 */
public class ViewIPTag extends TagSupport {
    private int i = 5;

    // 如果是单标签一般写在 Start 方法里
    // 当返回值为：EVAL_BODY_INCLUDE 时，执行标签体内的内容
    // 当返回值为：SKIP_BODY 时，跳过标签体内的内容
    @Override
    public int doStartTag() throws JspException {
        // 获取 pageContext 对象,也就得到了所有的隐式对象
        HttpServletRequest request = (HttpServletRequest) this.pageContext.getRequest();
        JspWriter out = this.pageContext.getOut();

        // 获取 IP 并输出
        String remoteAddr = request.getRemoteAddr();
        try {
            out.write(remoteAddr);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return Tag.EVAL_BODY_INCLUDE;
    }

    // 返回值如果是 EVAL_PAGE 继续执行
    // 返回值如果是 SKIP_PAGE 不再执行后面内容
    @Override
    public int doEndTag() throws JspException {
        return Tag.EVAL_PAGE;
    }

    // 返回值如果是 EVAL_BODY_AGAIN 继续执行标签体的内容，以及本方法
    // 返回值如果是 SKIP_BODY 跳过，继续执行 doEndTag 方法
    // doStartTag 方法不会重复执行
    @Override
    public int doAfterBody() throws JspException {
        if (--i >= 0)
            return IterationTag.EVAL_BODY_AGAIN;
        else
            return IterationTag.SKIP_BODY;
    }
}
