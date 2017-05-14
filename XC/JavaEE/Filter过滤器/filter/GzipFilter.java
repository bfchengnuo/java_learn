package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.zip.GZIPOutputStream;

/**
 * Created by 冰封承諾Andy on 5/13/2017.
 * 全站压缩代码
 * 包括 jsp html 等静态资源，图片也会被压缩
 * 任何请求都是靠的 Servlet ，如果没找到就调用缺省的去找，比如访问图片，所以任何资源都是压缩的
 * gzip 主要是压缩文本的，所以最好不要配 /* 只压缩下 jsp html js css等资源就行，这里只为方便
 *      因为 jsp 都是通过转发访问，所以最好配一下 dispatcher
 */
@WebFilter(filterName = "mGzipFilter", value = "/*",dispatcherTypes = {DispatcherType.FORWARD,DispatcherType.REQUEST})
public class GzipFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpServletRequest request = (HttpServletRequest) req;

        MyResponse myResponse = new MyResponse(response);
        // 放行后，目标资源获得的是我们自定义的缓冲流；并且会把输出写入到这个流
        chain.doFilter(request, myResponse);
        // 得到目标资源的输出，然后进行压缩
        byte[] out = myResponse.getBuffer();
        byte[] gzipOut = gzip(out);

        // 将压缩后的数据写出到浏览器，并设置标准
        response.setHeader("content-encoding", "gzip");
        response.setHeader("content-length", gzipOut.length + "");
        response.getOutputStream().write(gzipOut);
    }

    public void init(FilterConfig config) throws ServletException {

    }

    // 传入一个byte数组，返回一个压缩后的数组
    private byte[] gzip(byte[] data) throws IOException {
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        GZIPOutputStream gout = new GZIPOutputStream(bout);
        gout.write(data);
        gout.close();

        return bout.toByteArray();
    }


    /**
     * 增强 Response ，增加压缩功能
     */
    class MyResponse extends HttpServletResponseWrapper {
        private HttpServletResponse response;
        // 定义一个缓冲区，用于后面的压缩；所有的数据应该写入到这个流
        private ByteArrayOutputStream bout = new ByteArrayOutputStream();
        // 维护一个 PrintWriter 流，用于确保最终数据写入到底层流 bout
        private PrintWriter pw;

        public MyResponse(HttpServletResponse response) {
            super(response);
            this.response = response;
        }

        public byte[] getBuffer() {
            if (pw != null) {
                // 关闭流，会把缓存数据写入到底层流
                pw.close();
            }
            return bout.toByteArray();
        }

        @Override
        public ServletOutputStream getOutputStream() throws IOException {
            // 当目标资源获取输出流时，返回自己设置好的缓冲流
            return new MyServletOutputStream(bout);
        }

        @Override
        public PrintWriter getWriter() throws IOException {
            // 目标资源执行写出时，会先写出到 PrintWriter，等到了一定数据量再写入到 bout
            // 所以在获取 bout 的时候，关一下 pw 让其数据写出到 bout 中
            // 字符流向字节流写数据可能有乱码问题，使用转换流指定编码
            pw = new PrintWriter(new OutputStreamWriter(bout, response.getCharacterEncoding()));
            return pw;
        }

        /**
         * 定义自己的流，实现缓存的功能;
         * 因为是抽象方法，所以需要自己定义一个
         * 从上层接收一个缓冲流，将数据全部写到这个流
         */
        class MyServletOutputStream extends ServletOutputStream {
            private ByteArrayOutputStream bout;

            public MyServletOutputStream(ByteArrayOutputStream bout) {
                this.bout = bout;
            }

            // 最终目标资源调用的是这个方法，用来写出数据
            @Override
            public void write(int b) throws IOException {
                bout.write(b);
            }
        }
    }

}
