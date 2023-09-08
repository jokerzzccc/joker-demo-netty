package com.joker.demo.netty.server;

import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

/**
 * <p>
 *
 * </p>
 *
 * @author jokerzzccc
 * @since 2023/9/9
 */
public class ChannelHandler {

    /**
     * 用于存放用户Channel信息，也可以建立map结构模拟不同的消息群
     */
    public static ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

}
