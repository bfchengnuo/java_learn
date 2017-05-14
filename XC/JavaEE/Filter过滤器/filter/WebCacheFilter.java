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
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 冰封承諾Andy on 5/13/2017.
 * 缓存 web 服务器的资源，比如商品的分类，这一类不会经常更新的资源
 * 避免频繁的查找数据库，减轻服务器压力和数据库压力
 */
@WebFilter(filterName = "mWebCacheFilter")
public class WebCacheFilter implements Filter {
    private Map<String, byte[]> mMap = new HashMap<>();

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;


        // 1.得到用户想访问的资源 url
        String uri = request.getRequestURI();
        // 2.看 map 集合是否保存了该资源的数据
        byte[] b = mMap.get(uri);
        // 3.如果保存了，直接取出保存的数据打给浏览器
        if (b != null) {
            response.getOutputStream().write(b);
            return;
        }
        // 4.如果没有缓存数据，则放行，让目标资源执行，还需要有一个 Response 类来捕获目标资源的输出
        MyResponse myResponse = new MyResponse(response);
        chain.doFilter(request, myResponse);
        byte[] out = myResponse.getBuffer();
        // 5.以资源的 url 为关键字，将资源的数据保存到 map 集合中去，以备下次访问
        mMap.put(uri, out);
        // 6.输出数据给浏览器
        response.getOutputStream().write(out);
    }

    public void init(FilterConfig config) throws ServletException {

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
