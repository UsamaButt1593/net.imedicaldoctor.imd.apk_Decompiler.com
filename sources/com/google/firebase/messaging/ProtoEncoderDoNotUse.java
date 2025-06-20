package com.google.firebase.messaging;

import com.google.firebase.encoders.annotations.Encodable;
import com.google.firebase.encoders.proto.ProtobufEncoder;
import com.google.firebase.messaging.reporting.MessagingClientEventExtension;
import java.io.IOException;
import java.io.OutputStream;

@Encodable
public abstract class ProtoEncoderDoNotUse {

    /* renamed from: a  reason: collision with root package name */
    private static final ProtobufEncoder f24817a = ProtobufEncoder.a().e(AutoProtoEncoderDoNotUseEncoder.f24632b).d();

    private ProtoEncoderDoNotUse() {
    }

    public static void a(Object obj, OutputStream outputStream) throws IOException {
        f24817a.b(obj, outputStream);
    }

    public static byte[] b(Object obj) {
        return f24817a.c(obj);
    }

    public abstract MessagingClientEventExtension c();
}
