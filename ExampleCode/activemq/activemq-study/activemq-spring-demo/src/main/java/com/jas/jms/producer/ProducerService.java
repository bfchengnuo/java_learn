package com.jas.jms.producer;

/**
 * @author Jas
 * @create 2018-04-14 9:20
 **/
public interface ProducerService {
    /**
     * 生产者发送消息
     * @param message
     */
    void sendMessage(String message);
}
