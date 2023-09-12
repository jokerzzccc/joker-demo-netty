package com.joker.demo.netty.domain;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;

/**
 * <p>
 *
 * </p>
 *
 * @author jokerzzccc
 * @since 2023/9/11
 */
public final class MsgInfo {
    private MsgInfo() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
        registerAllExtensions(registry);
    }

    static final Descriptors.Descriptor
            internal_static_org_itstack_demo_netty_domain_MsgBody_descriptor;
    static final GeneratedMessageV3.FieldAccessorTable
            internal_static_org_itstack_demo_netty_domain_MsgBody_fieldAccessorTable;

    private static Descriptors.FileDescriptor
            descriptor;

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        java.lang.String[] descriptorData = {
                "\n\rMsgInfo.proto\022\035org.itstack.demo.netty." +
                        "domain\"-\n\007MsgBody\022\021\n\tchannelId\030\001 \001(\t\022\017\n\007" +
                        "msgInfo\030\002 \001(\tB*\n\035org.itstack.demo.netty." +
                        "domainB\007MsgInfoP\001b\006proto3"
        };

        Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
                new Descriptors.FileDescriptor.InternalDescriptorAssigner() {
                    public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor root) {
                        descriptor = root;
                        return null;
                    }
                };

        Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(
                descriptorData,
                new Descriptors.FileDescriptor[]{},
                assigner);

        internal_static_org_itstack_demo_netty_domain_MsgBody_descriptor =
                getDescriptor().getMessageTypes().get(0);

        internal_static_org_itstack_demo_netty_domain_MsgBody_fieldAccessorTable = new
                GeneratedMessageV3.FieldAccessorTable(
                internal_static_org_itstack_demo_netty_domain_MsgBody_descriptor,
                new String[]{"ChannelId", "MsgInfo",});
    }


}
