package com.joker.demo.netty.domain;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;

/**
 * <p>
 *
 * </p>
 *
 * @author jokerzzccc
 * @since 2023/9/11
 */
public interface MsgBodyOrBuilder extends MessageOrBuilder {

    String getChannelId();

    ByteString getChannelIdBytes();

    String getMsgInfo();

    ByteString getMsgInfoBytes();
}
