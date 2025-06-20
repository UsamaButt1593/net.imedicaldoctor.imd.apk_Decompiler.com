package com.google.firebase.encoders.proto;

import androidx.annotation.NonNull;
import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.ValueEncoder;
import com.google.firebase.encoders.config.Configurator;
import com.google.firebase.encoders.config.EncoderConfig;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

public class ProtobufEncoder {

    /* renamed from: a  reason: collision with root package name */
    private final Map<Class<?>, ObjectEncoder<?>> f24365a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<Class<?>, ValueEncoder<?>> f24366b;

    /* renamed from: c  reason: collision with root package name */
    private final ObjectEncoder<Object> f24367c;

    public static final class Builder implements EncoderConfig<Builder> {

        /* renamed from: d  reason: collision with root package name */
        private static final ObjectEncoder<Object> f24368d = new b();

        /* renamed from: a  reason: collision with root package name */
        private final Map<Class<?>, ObjectEncoder<?>> f24369a = new HashMap();

        /* renamed from: b  reason: collision with root package name */
        private final Map<Class<?>, ValueEncoder<?>> f24370b = new HashMap();

        /* renamed from: c  reason: collision with root package name */
        private ObjectEncoder<Object> f24371c = f24368d;

        /* access modifiers changed from: private */
        public static /* synthetic */ void f(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
            throw new EncodingException("Couldn't find encoder for type " + obj.getClass().getCanonicalName());
        }

        public ProtobufEncoder d() {
            return new ProtobufEncoder(new HashMap(this.f24369a), new HashMap(this.f24370b), this.f24371c);
        }

        @NonNull
        public Builder e(@NonNull Configurator configurator) {
            configurator.a(this);
            return this;
        }

        @NonNull
        /* renamed from: g */
        public <U> Builder b(@NonNull Class<U> cls, @NonNull ObjectEncoder<? super U> objectEncoder) {
            this.f24369a.put(cls, objectEncoder);
            this.f24370b.remove(cls);
            return this;
        }

        @NonNull
        /* renamed from: h */
        public <U> Builder a(@NonNull Class<U> cls, @NonNull ValueEncoder<? super U> valueEncoder) {
            this.f24370b.put(cls, valueEncoder);
            this.f24369a.remove(cls);
            return this;
        }

        @NonNull
        public Builder i(@NonNull ObjectEncoder<Object> objectEncoder) {
            this.f24371c = objectEncoder;
            return this;
        }
    }

    ProtobufEncoder(Map<Class<?>, ObjectEncoder<?>> map, Map<Class<?>, ValueEncoder<?>> map2, ObjectEncoder<Object> objectEncoder) {
        this.f24365a = map;
        this.f24366b = map2;
        this.f24367c = objectEncoder;
    }

    public static Builder a() {
        return new Builder();
    }

    public void b(@NonNull Object obj, @NonNull OutputStream outputStream) throws IOException {
        new ProtobufDataEncoderContext(outputStream, this.f24365a, this.f24366b, this.f24367c).C(obj);
    }

    @NonNull
    public byte[] c(@NonNull Object obj) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            b(obj, byteArrayOutputStream);
        } catch (IOException unused) {
        }
        return byteArrayOutputStream.toByteArray();
    }
}
