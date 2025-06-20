package com.bumptech.glide.signature;

import android.content.Context;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.util.Util;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

public final class AndroidResourceSignature implements Key {

    /* renamed from: c  reason: collision with root package name */
    private final int f18514c;

    /* renamed from: d  reason: collision with root package name */
    private final Key f18515d;

    private AndroidResourceSignature(int i2, Key key) {
        this.f18514c = i2;
        this.f18515d = key;
    }

    @NonNull
    public static Key c(@NonNull Context context) {
        return new AndroidResourceSignature(context.getResources().getConfiguration().uiMode & 48, ApplicationVersionSignature.c(context));
    }

    public void a(@NonNull MessageDigest messageDigest) {
        this.f18515d.a(messageDigest);
        messageDigest.update(ByteBuffer.allocate(4).putInt(this.f18514c).array());
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AndroidResourceSignature)) {
            return false;
        }
        AndroidResourceSignature androidResourceSignature = (AndroidResourceSignature) obj;
        return this.f18514c == androidResourceSignature.f18514c && this.f18515d.equals(androidResourceSignature.f18515d);
    }

    public int hashCode() {
        return Util.p(this.f18515d, this.f18514c);
    }
}
