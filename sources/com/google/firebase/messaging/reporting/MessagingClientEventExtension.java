package com.google.firebase.messaging.reporting;

import com.google.firebase.encoders.annotations.Encodable;
import com.google.firebase.encoders.proto.Protobuf;
import com.google.firebase.messaging.ProtoEncoderDoNotUse;
import java.io.IOException;
import java.io.OutputStream;

public final class MessagingClientEventExtension {

    /* renamed from: b  reason: collision with root package name */
    private static final MessagingClientEventExtension f24949b = new Builder().a();

    /* renamed from: a  reason: collision with root package name */
    private final MessagingClientEvent f24950a;

    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private MessagingClientEvent f24951a = null;

        Builder() {
        }

        public MessagingClientEventExtension a() {
            return new MessagingClientEventExtension(this.f24951a);
        }

        public Builder b(MessagingClientEvent messagingClientEvent) {
            this.f24951a = messagingClientEvent;
            return this;
        }
    }

    MessagingClientEventExtension(MessagingClientEvent messagingClientEvent) {
        this.f24950a = messagingClientEvent;
    }

    public static MessagingClientEventExtension a() {
        return f24949b;
    }

    public static Builder d() {
        return new Builder();
    }

    @Encodable.Ignore
    public MessagingClientEvent b() {
        MessagingClientEvent messagingClientEvent = this.f24950a;
        return messagingClientEvent == null ? MessagingClientEvent.f() : messagingClientEvent;
    }

    @Protobuf(tag = 1)
    @Encodable.Field(name = "messagingClientEvent")
    public MessagingClientEvent c() {
        return this.f24950a;
    }

    public byte[] e() {
        return ProtoEncoderDoNotUse.b(this);
    }

    public void f(OutputStream outputStream) throws IOException {
        ProtoEncoderDoNotUse.a(this, outputStream);
    }
}
