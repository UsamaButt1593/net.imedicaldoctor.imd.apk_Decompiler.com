package com.google.firebase.encoders;

import androidx.annotation.NonNull;
import java.io.IOException;

interface Encoder<TValue, TContext> {
    void a(@NonNull TValue tvalue, @NonNull TContext tcontext) throws IOException;
}
