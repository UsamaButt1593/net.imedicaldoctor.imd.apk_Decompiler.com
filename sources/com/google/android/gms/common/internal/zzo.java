package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.net.Uri;
import androidx.annotation.Nullable;
import com.itextpdf.text.Annotation;

public final class zzo {

    /* renamed from: f  reason: collision with root package name */
    private static final Uri f20313f = new Uri.Builder().scheme(Annotation.i3).authority("com.google.android.gms.chimera").build();
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private final String f20314a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private final String f20315b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private final ComponentName f20316c;

    /* renamed from: d  reason: collision with root package name */
    private final int f20317d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f20318e;

    public zzo(ComponentName componentName, int i2) {
        this.f20314a = null;
        this.f20315b = null;
        Preconditions.r(componentName);
        this.f20316c = componentName;
        this.f20317d = 4225;
        this.f20318e = false;
    }

    @Nullable
    public final ComponentName a() {
        return this.f20316c;
    }

    /* JADX WARNING: type inference failed for: r6v9, types: [android.os.Parcelable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.content.Intent b(android.content.Context r6) {
        /*
            r5 = this;
            java.lang.String r0 = "ConnectionStatusConfig"
            java.lang.String r1 = r5.f20314a
            if (r1 == 0) goto L_0x0060
            boolean r1 = r5.f20318e
            r2 = 0
            if (r1 == 0) goto L_0x0050
            android.os.Bundle r1 = new android.os.Bundle
            r1.<init>()
            java.lang.String r3 = r5.f20314a
            java.lang.String r4 = "serviceActionBundleKey"
            r1.putString(r4, r3)
            android.content.ContentResolver r6 = r6.getContentResolver()     // Catch:{ IllegalArgumentException -> 0x0024 }
            android.net.Uri r3 = f20313f     // Catch:{ IllegalArgumentException -> 0x0024 }
            java.lang.String r4 = "serviceIntentCall"
            android.os.Bundle r6 = r6.call(r3, r4, r2, r1)     // Catch:{ IllegalArgumentException -> 0x0024 }
            goto L_0x0033
        L_0x0024:
            r6 = move-exception
            java.lang.String r1 = "Dynamic intent resolution failed: "
            java.lang.String r6 = r6.toString()
            java.lang.String r6 = r1.concat(r6)
            android.util.Log.w(r0, r6)
            r6 = r2
        L_0x0033:
            if (r6 != 0) goto L_0x0036
            goto L_0x003f
        L_0x0036:
            java.lang.String r1 = "serviceResponseIntentKey"
            android.os.Parcelable r6 = r6.getParcelable(r1)
            r2 = r6
            android.content.Intent r2 = (android.content.Intent) r2
        L_0x003f:
            if (r2 != 0) goto L_0x0050
            java.lang.String r6 = r5.f20314a
            java.lang.String r6 = java.lang.String.valueOf(r6)
            java.lang.String r1 = "Dynamic lookup for intent failed for action: "
            java.lang.String r6 = r1.concat(r6)
            android.util.Log.w(r0, r6)
        L_0x0050:
            if (r2 != 0) goto L_0x006b
            java.lang.String r6 = r5.f20314a
            android.content.Intent r0 = new android.content.Intent
            r0.<init>(r6)
            java.lang.String r6 = r5.f20315b
            android.content.Intent r6 = r0.setPackage(r6)
            return r6
        L_0x0060:
            android.content.Intent r6 = new android.content.Intent
            r6.<init>()
            android.content.ComponentName r0 = r5.f20316c
            android.content.Intent r2 = r6.setComponent(r0)
        L_0x006b:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.zzo.b(android.content.Context):android.content.Intent");
    }

    @Nullable
    public final String c() {
        return this.f20315b;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzo)) {
            return false;
        }
        zzo zzo = (zzo) obj;
        return Objects.b(this.f20314a, zzo.f20314a) && Objects.b(this.f20315b, zzo.f20315b) && Objects.b(this.f20316c, zzo.f20316c) && this.f20318e == zzo.f20318e;
    }

    public final int hashCode() {
        return Objects.c(this.f20314a, this.f20315b, this.f20316c, 4225, Boolean.valueOf(this.f20318e));
    }

    public final String toString() {
        String str = this.f20314a;
        if (str != null) {
            return str;
        }
        Preconditions.r(this.f20316c);
        return this.f20316c.flattenToString();
    }

    public zzo(String str, int i2, boolean z) {
        this(str, "com.google.android.gms", 4225, false);
    }

    public zzo(String str, String str2, int i2, boolean z) {
        Preconditions.l(str);
        this.f20314a = str;
        Preconditions.l(str2);
        this.f20315b = str2;
        this.f20316c = null;
        this.f20317d = 4225;
        this.f20318e = z;
    }
}
