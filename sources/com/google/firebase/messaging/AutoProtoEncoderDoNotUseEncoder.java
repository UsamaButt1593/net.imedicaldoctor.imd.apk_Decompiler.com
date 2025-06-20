package com.google.firebase.messaging;

import androidx.core.app.NotificationCompat;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.config.Configurator;
import com.google.firebase.encoders.config.EncoderConfig;
import com.google.firebase.encoders.proto.AtProtobuf;
import com.google.firebase.messaging.reporting.MessagingClientEvent;
import com.google.firebase.messaging.reporting.MessagingClientEventExtension;
import java.io.IOException;

public final class AutoProtoEncoderDoNotUseEncoder implements Configurator {

    /* renamed from: a  reason: collision with root package name */
    public static final int f24631a = 2;

    /* renamed from: b  reason: collision with root package name */
    public static final Configurator f24632b = new AutoProtoEncoderDoNotUseEncoder();

    private static final class MessagingClientEventEncoder implements ObjectEncoder<MessagingClientEvent> {

        /* renamed from: a  reason: collision with root package name */
        static final MessagingClientEventEncoder f24633a = new MessagingClientEventEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f24634b = FieldDescriptor.a("projectNumber").b(AtProtobuf.b().d(1).a()).a();

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f24635c = FieldDescriptor.a("messageId").b(AtProtobuf.b().d(2).a()).a();

        /* renamed from: d  reason: collision with root package name */
        private static final FieldDescriptor f24636d = FieldDescriptor.a("instanceId").b(AtProtobuf.b().d(3).a()).a();

        /* renamed from: e  reason: collision with root package name */
        private static final FieldDescriptor f24637e = FieldDescriptor.a("messageType").b(AtProtobuf.b().d(4).a()).a();

        /* renamed from: f  reason: collision with root package name */
        private static final FieldDescriptor f24638f = FieldDescriptor.a("sdkPlatform").b(AtProtobuf.b().d(5).a()).a();

        /* renamed from: g  reason: collision with root package name */
        private static final FieldDescriptor f24639g = FieldDescriptor.a("packageName").b(AtProtobuf.b().d(6).a()).a();

        /* renamed from: h  reason: collision with root package name */
        private static final FieldDescriptor f24640h = FieldDescriptor.a("collapseKey").b(AtProtobuf.b().d(7).a()).a();

        /* renamed from: i  reason: collision with root package name */
        private static final FieldDescriptor f24641i = FieldDescriptor.a("priority").b(AtProtobuf.b().d(8).a()).a();

        /* renamed from: j  reason: collision with root package name */
        private static final FieldDescriptor f24642j = FieldDescriptor.a("ttl").b(AtProtobuf.b().d(9).a()).a();

        /* renamed from: k  reason: collision with root package name */
        private static final FieldDescriptor f24643k = FieldDescriptor.a("topic").b(AtProtobuf.b().d(10).a()).a();

        /* renamed from: l  reason: collision with root package name */
        private static final FieldDescriptor f24644l = FieldDescriptor.a("bulkId").b(AtProtobuf.b().d(11).a()).a();

        /* renamed from: m  reason: collision with root package name */
        private static final FieldDescriptor f24645m = FieldDescriptor.a(NotificationCompat.I0).b(AtProtobuf.b().d(12).a()).a();

        /* renamed from: n  reason: collision with root package name */
        private static final FieldDescriptor f24646n = FieldDescriptor.a("analyticsLabel").b(AtProtobuf.b().d(13).a()).a();
        private static final FieldDescriptor o = FieldDescriptor.a("campaignId").b(AtProtobuf.b().d(14).a()).a();
        private static final FieldDescriptor p = FieldDescriptor.a("composerLabel").b(AtProtobuf.b().d(15).a()).a();

        private MessagingClientEventEncoder() {
        }

        /* renamed from: b */
        public void a(MessagingClientEvent messagingClientEvent, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.c(f24634b, messagingClientEvent.m());
            objectEncoderContext.s(f24635c, messagingClientEvent.i());
            objectEncoderContext.s(f24636d, messagingClientEvent.h());
            objectEncoderContext.s(f24637e, messagingClientEvent.j());
            objectEncoderContext.s(f24638f, messagingClientEvent.n());
            objectEncoderContext.s(f24639g, messagingClientEvent.k());
            objectEncoderContext.s(f24640h, messagingClientEvent.d());
            objectEncoderContext.d(f24641i, messagingClientEvent.l());
            objectEncoderContext.d(f24642j, messagingClientEvent.p());
            objectEncoderContext.s(f24643k, messagingClientEvent.o());
            objectEncoderContext.c(f24644l, messagingClientEvent.b());
            objectEncoderContext.s(f24645m, messagingClientEvent.g());
            objectEncoderContext.s(f24646n, messagingClientEvent.a());
            objectEncoderContext.c(o, messagingClientEvent.c());
            objectEncoderContext.s(p, messagingClientEvent.e());
        }
    }

    private static final class MessagingClientEventExtensionEncoder implements ObjectEncoder<MessagingClientEventExtension> {

        /* renamed from: a  reason: collision with root package name */
        static final MessagingClientEventExtensionEncoder f24647a = new MessagingClientEventExtensionEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f24648b = FieldDescriptor.a("messagingClientEvent").b(AtProtobuf.b().d(1).a()).a();

        private MessagingClientEventExtensionEncoder() {
        }

        /* renamed from: b */
        public void a(MessagingClientEventExtension messagingClientEventExtension, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.s(f24648b, messagingClientEventExtension.c());
        }
    }

    private static final class ProtoEncoderDoNotUseEncoder implements ObjectEncoder<ProtoEncoderDoNotUse> {

        /* renamed from: a  reason: collision with root package name */
        static final ProtoEncoderDoNotUseEncoder f24649a = new ProtoEncoderDoNotUseEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f24650b = FieldDescriptor.d("messagingClientEventExtension");

        private ProtoEncoderDoNotUseEncoder() {
        }

        /* renamed from: b */
        public void a(ProtoEncoderDoNotUse protoEncoderDoNotUse, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.s(f24650b, protoEncoderDoNotUse.c());
        }
    }

    private AutoProtoEncoderDoNotUseEncoder() {
    }

    public void a(EncoderConfig<?> encoderConfig) {
        encoderConfig.b(ProtoEncoderDoNotUse.class, ProtoEncoderDoNotUseEncoder.f24649a);
        encoderConfig.b(MessagingClientEventExtension.class, MessagingClientEventExtensionEncoder.f24647a);
        encoderConfig.b(MessagingClientEvent.class, MessagingClientEventEncoder.f24633a);
    }
}
