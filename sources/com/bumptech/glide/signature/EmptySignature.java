package com.bumptech.glide.signature;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import java.security.MessageDigest;

public final class EmptySignature implements Key {

    /* renamed from: c  reason: collision with root package name */
    private static final EmptySignature f18518c = new EmptySignature();

    private EmptySignature() {
    }

    @NonNull
    public static EmptySignature c() {
        return f18518c;
    }

    public void a(@NonNull MessageDigest messageDigest) {
    }

    public String toString() {
        return "EmptySignature";
    }
}
