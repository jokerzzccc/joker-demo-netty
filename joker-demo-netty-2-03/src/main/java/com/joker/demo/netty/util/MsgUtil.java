package com.joker.demo.netty.util;

import com.joker.demo.netty.domain.MsgInfo;

/**
 * <p>
 *
 * </p>
 *
 * @author jokerzzccc
 * @since 2023/9/11
 */
public class MsgUtil {

    public static MsgInfo buildMsg(String channelId, String msgContent) {
        return new MsgInfo(channelId, msgContent);
    }

}
