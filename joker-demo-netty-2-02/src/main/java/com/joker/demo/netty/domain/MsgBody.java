package com.joker.demo.netty.domain;

import com.google.protobuf.GeneratedMessageV3;

/**
 * <p>
 *
 * </p>
 *
 * @author jokerzzccc
 * @since 2023/9/11
 */
public final class MsgBody extends GeneratedMessageV3 implements MsgBodyOrBuilder {

    private static final long serialVersionUID = 0L;

    private MsgBody(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
    }

    private MsgBody() {
        channelId_ = "";
        msgInfo_ = "";
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
        return this.unknownFields;
    }

    private MsgBody(
            com.google.protobuf.CodedInputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
        this();
        if (extensionRegistry == null) {
            throw new java.lang.NullPointerException();
        }
        int mutable_bitField0_ = 0;
        com.google.protobuf.UnknownFieldSet.Builder unknownFields =
                com.google.protobuf.UnknownFieldSet.newBuilder();
        try {
            boolean done = false;
            while (!done) {
                int tag = input.readTag();
                switch (tag) {
                    case 0:
                        done = true;
                        break;
                    default: {
                        if (!parseUnknownFieldProto3(
                                input, unknownFields, extensionRegistry, tag)) {
                            done = true;
                        }
                        break;
                    }
                    case 10: {
                        java.lang.String s = input.readStringRequireUtf8();

                        channelId_ = s;
                        break;
                    }
                    case 18: {
                        java.lang.String s = input.readStringRequireUtf8();

                        msgInfo_ = s;
                        break;
                    }
                }
            }
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
            throw e.setUnfinishedMessage(this);
        } catch (java.io.IOException e) {
            throw new com.google.protobuf.InvalidProtocolBufferException(
                    e).setUnfinishedMessage(this);
        } finally {
            this.unknownFields = unknownFields.build();
            makeExtensionsImmutable();
        }
    }

    public static final com.google.protobuf.Descriptors.Descriptor
    getDescriptor() {
        return com.joker.demo.netty.domain.MsgInfo.internal_static_org_itstack_demo_netty_domain_MsgBody_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
    internalGetFieldAccessorTable() {
        return com.joker.demo.netty.domain.MsgInfo.internal_static_org_itstack_demo_netty_domain_MsgBody_fieldAccessorTable
                .ensureFieldAccessorsInitialized(
                        com.joker.demo.netty.domain.MsgBody.class, com.joker.demo.netty.domain.MsgBody.Builder.class);
    }

    public static final int CHANNELID_FIELD_NUMBER = 1;
    private volatile java.lang.Object channelId_;

    /**
     * <code>string channelId = 1;</code>
     */
    public java.lang.String getChannelId() {
        java.lang.Object ref = channelId_;
        if (ref instanceof java.lang.String) {
            return (java.lang.String) ref;
        } else {
            com.google.protobuf.ByteString bs =
                    (com.google.protobuf.ByteString) ref;
            java.lang.String s = bs.toStringUtf8();
            channelId_ = s;
            return s;
        }
    }

    /**
     * <code>string channelId = 1;</code>
     */
    public com.google.protobuf.ByteString
    getChannelIdBytes() {
        java.lang.Object ref = channelId_;
        if (ref instanceof java.lang.String) {
            com.google.protobuf.ByteString b =
                    com.google.protobuf.ByteString.copyFromUtf8(
                            (java.lang.String) ref);
            channelId_ = b;
            return b;
        } else {
            return (com.google.protobuf.ByteString) ref;
        }
    }

    public static final int MSGINFO_FIELD_NUMBER = 2;
    private volatile java.lang.Object msgInfo_;

    /**
     * <code>string msgInfo = 2;</code>
     */
    public java.lang.String getMsgInfo() {
        java.lang.Object ref = msgInfo_;
        if (ref instanceof java.lang.String) {
            return (java.lang.String) ref;
        } else {
            com.google.protobuf.ByteString bs =
                    (com.google.protobuf.ByteString) ref;
            java.lang.String s = bs.toStringUtf8();
            msgInfo_ = s;
            return s;
        }
    }

    /**
     * <code>string msgInfo = 2;</code>
     */
    public com.google.protobuf.ByteString getMsgInfoBytes() {
        java.lang.Object ref = msgInfo_;
        if (ref instanceof java.lang.String) {
            com.google.protobuf.ByteString b =
                    com.google.protobuf.ByteString.copyFromUtf8(
                            (java.lang.String) ref);
            msgInfo_ = b;
            return b;
        } else {
            return (com.google.protobuf.ByteString) ref;
        }
    }

    private byte memoizedIsInitialized = -1;

    public final boolean isInitialized() {
        byte isInitialized = memoizedIsInitialized;
        if (isInitialized == 1) return true;
        if (isInitialized == 0) return false;

        memoizedIsInitialized = 1;
        return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
            throws java.io.IOException {
        if (!getChannelIdBytes().isEmpty()) {
            com.google.protobuf.GeneratedMessageV3.writeString(output, 1, channelId_);
        }
        if (!getMsgInfoBytes().isEmpty()) {
            com.google.protobuf.GeneratedMessageV3.writeString(output, 2, msgInfo_);
        }
        unknownFields.writeTo(output);
    }

    public int getSerializedSize() {
        int size = memoizedSize;
        if (size != -1) return size;

        size = 0;
        if (!getChannelIdBytes().isEmpty()) {
            size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, channelId_);
        }
        if (!getMsgInfoBytes().isEmpty()) {
            size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, msgInfo_);
        }
        size += unknownFields.getSerializedSize();
        memoizedSize = size;
        return size;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof com.joker.demo.netty.domain.MsgBody)) {
            return super.equals(obj);
        }
        com.joker.demo.netty.domain.MsgBody other = (com.joker.demo.netty.domain.MsgBody) obj;

        boolean result = true;
        result = result && getChannelId()
                .equals(other.getChannelId());
        result = result && getMsgInfo()
                .equals(other.getMsgInfo());
        result = result && unknownFields.equals(other.unknownFields);
        return result;
    }

    @java.lang.Override
    public int hashCode() {
        if (memoizedHashCode != 0) {
            return memoizedHashCode;
        }
        int hash = 41;
        hash = (19 * hash) + getDescriptor().hashCode();
        hash = (37 * hash) + CHANNELID_FIELD_NUMBER;
        hash = (53 * hash) + getChannelId().hashCode();
        hash = (37 * hash) + MSGINFO_FIELD_NUMBER;
        hash = (53 * hash) + getMsgInfo().hashCode();
        hash = (29 * hash) + unknownFields.hashCode();
        memoizedHashCode = hash;
        return hash;
    }

    public static com.joker.demo.netty.domain.MsgBody parseFrom(
            java.nio.ByteBuffer data)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static com.joker.demo.netty.domain.MsgBody parseFrom(
            java.nio.ByteBuffer data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.joker.demo.netty.domain.MsgBody parseFrom(
            com.google.protobuf.ByteString data)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static com.joker.demo.netty.domain.MsgBody parseFrom(
            com.google.protobuf.ByteString data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.joker.demo.netty.domain.MsgBody parseFrom(byte[] data)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static com.joker.demo.netty.domain.MsgBody parseFrom(
            byte[] data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.joker.demo.netty.domain.MsgBody parseFrom(java.io.InputStream input)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseWithIOException(PARSER, input);
    }

    public static com.joker.demo.netty.domain.MsgBody parseFrom(
            java.io.InputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public static com.joker.demo.netty.domain.MsgBody parseDelimitedFrom(java.io.InputStream input)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseDelimitedWithIOException(PARSER, input);
    }

    public static com.joker.demo.netty.domain.MsgBody parseDelimitedFrom(
            java.io.InputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }

    public static com.joker.demo.netty.domain.MsgBody parseFrom(
            com.google.protobuf.CodedInputStream input)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseWithIOException(PARSER, input);
    }

    public static com.joker.demo.netty.domain.MsgBody parseFrom(
            com.google.protobuf.CodedInputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(com.joker.demo.netty.domain.MsgBody prototype) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }

    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE
                ? new Builder() : new Builder().mergeFrom(this);
    }

    @java.lang.Override
    protected Builder newBuilderForType(
            com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        Builder builder = new Builder(parent);
        return builder;
    }

    /**
     * Protobuf type {@code com.joker.demo.netty.domain.MsgBody}
     */
    public static final class Builder extends
            com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
            // @@protoc_insertion_point(builder_implements:com.joker.demo.netty.domain.MsgBody)
            com.joker.demo.netty.domain.MsgBodyOrBuilder {
        public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
            return com.joker.demo.netty.domain.MsgInfo.internal_static_org_itstack_demo_netty_domain_MsgBody_descriptor;
        }

        protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
            return com.joker.demo.netty.domain.MsgInfo.internal_static_org_itstack_demo_netty_domain_MsgBody_fieldAccessorTable
                    .ensureFieldAccessorsInitialized(
                            com.joker.demo.netty.domain.MsgBody.class, com.joker.demo.netty.domain.MsgBody.Builder.class);
        }

        // Construct using com.joker.demo.netty.domain.MsgBody.newBuilder()
        private Builder() {
            maybeForceBuilderInitialization();
        }

        private Builder(
                com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
            super(parent);
            maybeForceBuilderInitialization();
        }

        private void maybeForceBuilderInitialization() {
            if (com.google.protobuf.GeneratedMessageV3
                    .alwaysUseFieldBuilders) {
            }
        }

        public Builder clear() {
            super.clear();
            channelId_ = "";

            msgInfo_ = "";

            return this;
        }

        public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
            return com.joker.demo.netty.domain.MsgInfo.internal_static_org_itstack_demo_netty_domain_MsgBody_descriptor;
        }

        public com.joker.demo.netty.domain.MsgBody getDefaultInstanceForType() {
            return com.joker.demo.netty.domain.MsgBody.getDefaultInstance();
        }

        public com.joker.demo.netty.domain.MsgBody build() {
            com.joker.demo.netty.domain.MsgBody result = buildPartial();
            if (!result.isInitialized()) {
                throw newUninitializedMessageException(result);
            }
            return result;
        }

        public com.joker.demo.netty.domain.MsgBody buildPartial() {
            com.joker.demo.netty.domain.MsgBody result = new com.joker.demo.netty.domain.MsgBody(this);
            result.channelId_ = channelId_;
            result.msgInfo_ = msgInfo_;
            onBuilt();
            return result;
        }

        public Builder clone() {
            return (Builder) super.clone();
        }

        public Builder setField(
                com.google.protobuf.Descriptors.FieldDescriptor field,
                java.lang.Object value) {
            return (Builder) super.setField(field, value);
        }

        public Builder clearField(
                com.google.protobuf.Descriptors.FieldDescriptor field) {
            return (Builder) super.clearField(field);
        }

        public Builder clearOneof(
                com.google.protobuf.Descriptors.OneofDescriptor oneof) {
            return (Builder) super.clearOneof(oneof);
        }

        public Builder setRepeatedField(
                com.google.protobuf.Descriptors.FieldDescriptor field,
                int index, java.lang.Object value) {
            return (Builder) super.setRepeatedField(field, index, value);
        }

        public Builder addRepeatedField(
                com.google.protobuf.Descriptors.FieldDescriptor field,
                java.lang.Object value) {
            return (Builder) super.addRepeatedField(field, value);
        }

        public Builder mergeFrom(com.google.protobuf.Message other) {
            if (other instanceof com.joker.demo.netty.domain.MsgBody) {
                return mergeFrom((com.joker.demo.netty.domain.MsgBody) other);
            } else {
                super.mergeFrom(other);
                return this;
            }
        }

        public Builder mergeFrom(com.joker.demo.netty.domain.MsgBody other) {
            if (other == com.joker.demo.netty.domain.MsgBody.getDefaultInstance()) return this;
            if (!other.getChannelId().isEmpty()) {
                channelId_ = other.channelId_;
                onChanged();
            }
            if (!other.getMsgInfo().isEmpty()) {
                msgInfo_ = other.msgInfo_;
                onChanged();
            }
            this.mergeUnknownFields(other.unknownFields);
            onChanged();
            return this;
        }

        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeFrom(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            com.joker.demo.netty.domain.MsgBody parsedMessage = null;
            try {
                parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
            } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                parsedMessage = (com.joker.demo.netty.domain.MsgBody) e.getUnfinishedMessage();
                throw e.unwrapIOException();
            } finally {
                if (parsedMessage != null) {
                    mergeFrom(parsedMessage);
                }
            }
            return this;
        }

        private java.lang.Object channelId_ = "";

        /**
         * <code>string channelId = 1;</code>
         */
        public java.lang.String getChannelId() {
            java.lang.Object ref = channelId_;
            if (!(ref instanceof java.lang.String)) {
                com.google.protobuf.ByteString bs =
                        (com.google.protobuf.ByteString) ref;
                java.lang.String s = bs.toStringUtf8();
                channelId_ = s;
                return s;
            } else {
                return (java.lang.String) ref;
            }
        }

        /**
         * <code>string channelId = 1;</code>
         */
        public com.google.protobuf.ByteString
        getChannelIdBytes() {
            java.lang.Object ref = channelId_;
            if (ref instanceof String) {
                com.google.protobuf.ByteString b =
                        com.google.protobuf.ByteString.copyFromUtf8(
                                (java.lang.String) ref);
                channelId_ = b;
                return b;
            } else {
                return (com.google.protobuf.ByteString) ref;
            }
        }

        /**
         * <code>string channelId = 1;</code>
         */
        public Builder setChannelId(
                java.lang.String value) {
            if (value == null) {
                throw new NullPointerException();
            }

            channelId_ = value;
            onChanged();
            return this;
        }

        /**
         * <code>string channelId = 1;</code>
         */
        public Builder clearChannelId() {

            channelId_ = getDefaultInstance().getChannelId();
            onChanged();
            return this;
        }

        /**
         * <code>string channelId = 1;</code>
         */
        public Builder setChannelIdBytes(
                com.google.protobuf.ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            }
            checkByteStringIsUtf8(value);

            channelId_ = value;
            onChanged();
            return this;
        }

        private java.lang.Object msgInfo_ = "";

        /**
         * <code>string msgInfo = 2;</code>
         */
        public java.lang.String getMsgInfo() {
            java.lang.Object ref = msgInfo_;
            if (!(ref instanceof java.lang.String)) {
                com.google.protobuf.ByteString bs =
                        (com.google.protobuf.ByteString) ref;
                java.lang.String s = bs.toStringUtf8();
                msgInfo_ = s;
                return s;
            } else {
                return (java.lang.String) ref;
            }
        }

        /**
         * <code>string msgInfo = 2;</code>
         */
        public com.google.protobuf.ByteString
        getMsgInfoBytes() {
            java.lang.Object ref = msgInfo_;
            if (ref instanceof String) {
                com.google.protobuf.ByteString b =
                        com.google.protobuf.ByteString.copyFromUtf8(
                                (java.lang.String) ref);
                msgInfo_ = b;
                return b;
            } else {
                return (com.google.protobuf.ByteString) ref;
            }
        }

        /**
         * <code>string msgInfo = 2;</code>
         */
        public Builder setMsgInfo(
                java.lang.String value) {
            if (value == null) {
                throw new NullPointerException();
            }

            msgInfo_ = value;
            onChanged();
            return this;
        }

        /**
         * <code>string msgInfo = 2;</code>
         */
        public Builder clearMsgInfo() {

            msgInfo_ = getDefaultInstance().getMsgInfo();
            onChanged();
            return this;
        }

        /**
         * <code>string msgInfo = 2;</code>
         */
        public Builder setMsgInfoBytes(
                com.google.protobuf.ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            }
            checkByteStringIsUtf8(value);

            msgInfo_ = value;
            onChanged();
            return this;
        }

        public final Builder setUnknownFields(
                final com.google.protobuf.UnknownFieldSet unknownFields) {
            return super.setUnknownFieldsProto3(unknownFields);
        }

        public final Builder mergeUnknownFields(
                final com.google.protobuf.UnknownFieldSet unknownFields) {
            return super.mergeUnknownFields(unknownFields);
        }


        // @@protoc_insertion_point(builder_scope:com.joker.demo.netty.domain.MsgBody)
    }

    // @@protoc_insertion_point(class_scope:com.joker.demo.netty.domain.MsgBody)
    private static final com.joker.demo.netty.domain.MsgBody DEFAULT_INSTANCE;

    static {
        DEFAULT_INSTANCE = new com.joker.demo.netty.domain.MsgBody();
    }

    public static com.joker.demo.netty.domain.MsgBody getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<MsgBody>
            PARSER = new com.google.protobuf.AbstractParser<MsgBody>() {
        public MsgBody parsePartialFrom(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return new MsgBody(input, extensionRegistry);
        }
    };

    public static com.google.protobuf.Parser<MsgBody> parser() {
        return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<MsgBody> getParserForType() {
        return PARSER;
    }

    public com.joker.demo.netty.domain.MsgBody getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

}
