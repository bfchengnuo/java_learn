package com.bfchengnuo.netty;

import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

/**
 * 存储整个工程的全局配置
 * Created by 冰封承諾Andy on 2018/5/13.
 */
public class NettyConfig {

    /**
     * 存储每一个客户端连接进来时的 channel 对象
     */
    public static ChannelGroup group = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
}
