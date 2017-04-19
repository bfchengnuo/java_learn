package web.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.SkipPageException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.io.StringWriter;

/**
 * Created by 冰封承諾Andy on 4/19/2017.
 * 简单自定义标签
 */
public class SimpleTag extends SimpleTagSupport {

    @Override
    public void doTag() throws JspException, IOException {
        // 获取标签体
        JspFragment jf = this.getJspBody();
        // 执行标签体的内容，如果不手动调用就不会执行
        jf.invoke(this.getJspContext().getOut());
        // 上面那句等价于 jf.invoke(null);


        // 获取标签体内容. 将内容写入到事先准备的缓冲区内，然后获取
        StringWriter sw = new StringWriter();
        jf.invoke(sw);
        String content = sw.toString();

        // 如果不执行后面的内容，抛一个 SkipPageException 异常
        throw new SkipPageException();
    }
}
