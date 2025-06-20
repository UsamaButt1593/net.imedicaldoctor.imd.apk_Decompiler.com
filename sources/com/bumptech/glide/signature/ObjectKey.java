package com.bumptech.glide.signature;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.util.Preconditions;
import com.dd.plist.ASCIIPropertyListParser;
import java.security.MessageDigest;

public final class ObjectKey implements Key {

    /* renamed from: c  reason: collision with root package name */
    private final Object f18522c;

    public ObjectKey(@NonNull Object obj) {
        this.f18522c = Preconditions.d(obj);
    }

    public void a(@NonNull MessageDigest messageDigest) {
        messageDigest.update(this.f18522c.toString().getBytes(Key.f17830b));
    }

    public boolean equals(Object obj) {
        if (obj instanceof ObjectKey) {
            return this.f18522c.equals(((ObjectKey) obj).f18522c);
        }
        return false;
    }

    public int hashCode() {
        return this.f18522c.hashCode();
    }

    public String toString() {
        return "ObjectKey{object=" + this.f18522c + ASCIIPropertyListParser.f18653k;
    }
}
