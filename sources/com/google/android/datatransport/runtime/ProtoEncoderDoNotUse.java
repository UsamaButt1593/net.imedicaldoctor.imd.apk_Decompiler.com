package com.google.android.datatransport.runtime;

import com.google.android.datatransport.runtime.firebase.transport.ClientMetrics;
import com.google.firebase.encoders.annotations.Encodable;
import com.google.firebase.encoders.proto.ProtobufEncoder;
import java.io.IOException;
import java.io.OutputStream;

@Encodable
public abstract class ProtoEncoderDoNotUse {

    /* renamed from: a  reason: collision with root package name */
    private static final ProtobufEncoder f19442a = ProtobufEncoder.a().e(AutoProtoEncoderDoNotUseEncoder.f19375b).d();

    private ProtoEncoderDoNotUse() {
    }

    public static void a(Object obj, OutputStream outputStream) throws IOException {
        f19442a.b(obj, outputStream);
    }

    public static byte[] b(Object obj) {
        return f19442a.c(obj);
    }

    public abstract ClientMetrics c();
}
