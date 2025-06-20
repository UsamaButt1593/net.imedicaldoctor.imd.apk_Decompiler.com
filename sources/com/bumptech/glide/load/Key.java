package com.bumptech.glide.load;

import androidx.annotation.NonNull;
import java.nio.charset.Charset;
import java.security.MessageDigest;

public interface Key {

    /* renamed from: a  reason: collision with root package name */
    public static final String f17829a = "UTF-8";

    /* renamed from: b  reason: collision with root package name */
    public static final Charset f17830b = Charset.forName("UTF-8");

    void a(@NonNull MessageDigest messageDigest);

    boolean equals(Object obj);

    int hashCode();
}
