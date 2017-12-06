package com.bfchengnuo.File;

import java.io.IOException;
import java.io.InputStream;

/**
 * 自己仿写字节流的缓冲类
 */
public class MyBufferedInputStream {
    private InputStream in;
    private byte[] buf = new byte[1024];
    private int pos = 0;
    private int count = 0;

    public MyBufferedInputStream(InputStream in) {
        this.in = in;
    }

    /**
     * 先读取到设定的字节数组缓冲区中，再从缓冲区中一次读取一个字节返回给调用方
     * 为了避免读取到 11111111 的字节数据误判的文件的结束，所以从数组取出返回的时候进行向上转型，只保留低八位
     * 默认的向上转型 -1 还是 -1，前面补零就可以保证不为 -1，也就是 &255
     * 在写入的时候也会进行相应的向下转型只写入低八位，来保证文件的大小不变
     *
     * @return 缓冲区的一个字节，结尾返回 -1
     * @throws IOException IO 异常
     */
    public int myRead() throws IOException {
        if (count == 0) {
            count = in.read(buf);
            // 如果已经是末尾直接返回
            if (count == -1)
                return -1;

            // 指针置为0，从头开始读
            pos = 0;

            byte b = buf[pos];
            count--;
            pos++;
            return b & 255;  // & 六个1取低八位
        } else if (count > 0) {
            byte b = buf[pos];
            count--;
            pos++;
            return b & 0xff;
        }

        return -1;
    }

    public void myClose() throws IOException {
        in.close();
    }
}
