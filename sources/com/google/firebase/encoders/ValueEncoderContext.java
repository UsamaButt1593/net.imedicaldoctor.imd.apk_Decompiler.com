package com.google.firebase.encoders;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.IOException;

public interface ValueEncoderContext {
    @NonNull
    ValueEncoderContext a(long j2) throws IOException;

    @NonNull
    ValueEncoderContext add(int i2) throws IOException;

    @NonNull
    ValueEncoderContext m(@Nullable String str) throws IOException;

    @NonNull
    ValueEncoderContext n(boolean z) throws IOException;

    @NonNull
    ValueEncoderContext p(double d2) throws IOException;

    @NonNull
    ValueEncoderContext q(float f2) throws IOException;

    @NonNull
    ValueEncoderContext u(@NonNull byte[] bArr) throws IOException;
}
