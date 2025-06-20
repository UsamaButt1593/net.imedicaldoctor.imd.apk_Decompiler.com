package com.google.firebase.encoders;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.IOException;

public interface ObjectEncoderContext {
    @NonNull
    ObjectEncoderContext b(@NonNull FieldDescriptor fieldDescriptor, boolean z) throws IOException;

    @NonNull
    ObjectEncoderContext c(@NonNull FieldDescriptor fieldDescriptor, long j2) throws IOException;

    @NonNull
    ObjectEncoderContext d(@NonNull FieldDescriptor fieldDescriptor, int i2) throws IOException;

    @NonNull
    ObjectEncoderContext e(@NonNull FieldDescriptor fieldDescriptor, float f2) throws IOException;

    @NonNull
    ObjectEncoderContext f(@NonNull FieldDescriptor fieldDescriptor) throws IOException;

    @NonNull
    ObjectEncoderContext g(@NonNull FieldDescriptor fieldDescriptor, double d2) throws IOException;

    @NonNull
    ObjectEncoderContext h(@Nullable Object obj) throws IOException;

    @NonNull
    @Deprecated
    ObjectEncoderContext i(@NonNull String str, boolean z) throws IOException;

    @NonNull
    @Deprecated
    ObjectEncoderContext j(@NonNull String str, double d2) throws IOException;

    @NonNull
    @Deprecated
    ObjectEncoderContext k(@NonNull String str, long j2) throws IOException;

    @NonNull
    @Deprecated
    ObjectEncoderContext l(@NonNull String str, int i2) throws IOException;

    @NonNull
    @Deprecated
    ObjectEncoderContext o(@NonNull String str, @Nullable Object obj) throws IOException;

    @NonNull
    ObjectEncoderContext r(@NonNull String str) throws IOException;

    @NonNull
    ObjectEncoderContext s(@NonNull FieldDescriptor fieldDescriptor, @Nullable Object obj) throws IOException;
}
