package com.google.firebase.encoders.config;

import androidx.annotation.NonNull;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ValueEncoder;
import com.google.firebase.encoders.config.EncoderConfig;

public interface EncoderConfig<T extends EncoderConfig<T>> {
    @NonNull
    <U> T a(@NonNull Class<U> cls, @NonNull ValueEncoder<? super U> valueEncoder);

    @NonNull
    <U> T b(@NonNull Class<U> cls, @NonNull ObjectEncoder<? super U> objectEncoder);
}
