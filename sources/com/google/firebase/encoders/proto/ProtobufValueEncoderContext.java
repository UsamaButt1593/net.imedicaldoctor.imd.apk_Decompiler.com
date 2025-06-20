package com.google.firebase.encoders.proto;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ValueEncoderContext;
import java.io.IOException;

class ProtobufValueEncoderContext implements ValueEncoderContext {

    /* renamed from: a  reason: collision with root package name */
    private boolean f24372a = false;

    /* renamed from: b  reason: collision with root package name */
    private boolean f24373b = false;

    /* renamed from: c  reason: collision with root package name */
    private FieldDescriptor f24374c;

    /* renamed from: d  reason: collision with root package name */
    private final ProtobufDataEncoderContext f24375d;

    ProtobufValueEncoderContext(ProtobufDataEncoderContext protobufDataEncoderContext) {
        this.f24375d = protobufDataEncoderContext;
    }

    private void b() {
        if (!this.f24372a) {
            this.f24372a = true;
            return;
        }
        throw new EncodingException("Cannot encode a second value in the ValueEncoderContext");
    }

    @NonNull
    public ValueEncoderContext a(long j2) throws IOException {
        b();
        this.f24375d.v(this.f24374c, j2, this.f24373b);
        return this;
    }

    @NonNull
    public ValueEncoderContext add(int i2) throws IOException {
        b();
        this.f24375d.t(this.f24374c, i2, this.f24373b);
        return this;
    }

    /* access modifiers changed from: package-private */
    public void c(FieldDescriptor fieldDescriptor, boolean z) {
        this.f24372a = false;
        this.f24374c = fieldDescriptor;
        this.f24373b = z;
    }

    @NonNull
    public ValueEncoderContext m(@Nullable String str) throws IOException {
        b();
        this.f24375d.p(this.f24374c, str, this.f24373b);
        return this;
    }

    @NonNull
    public ValueEncoderContext n(boolean z) throws IOException {
        b();
        this.f24375d.x(this.f24374c, z, this.f24373b);
        return this;
    }

    @NonNull
    public ValueEncoderContext p(double d2) throws IOException {
        b();
        this.f24375d.m(this.f24374c, d2, this.f24373b);
        return this;
    }

    @NonNull
    public ValueEncoderContext q(float f2) throws IOException {
        b();
        this.f24375d.n(this.f24374c, f2, this.f24373b);
        return this;
    }

    @NonNull
    public ValueEncoderContext u(@NonNull byte[] bArr) throws IOException {
        b();
        this.f24375d.p(this.f24374c, bArr, this.f24373b);
        return this;
    }
}
