package com.easylab.jms.producer;

/******************************
 * @author : liuyang
 * <p>ProjectName:jms-spring  </p>
 * @ClassName :  IProducerService
 * @date : 2018/6/24 0024
 * @time : 8:41
 * @createTime 2018-06-24 8:41
 * @version : 2.0
 * @description :
 *
 *
 *
 *******************************/


public interface IProducerService {


    public void sendMessage(String message);
}
