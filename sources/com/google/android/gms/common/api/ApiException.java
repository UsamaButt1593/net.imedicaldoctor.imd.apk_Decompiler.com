package com.google.android.gms.common.api;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ApiException extends Exception {
    @NonNull
    @Deprecated
    protected final Status s;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ApiException(@androidx.annotation.NonNull com.google.android.gms.common.api.Status r4) {
        /*
            r3 = this;
            int r0 = r4.I()
            java.lang.String r1 = r4.N()
            if (r1 == 0) goto L_0x000f
            java.lang.String r1 = r4.N()
            goto L_0x0011
        L_0x000f:
            java.lang.String r1 = ""
        L_0x0011:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            java.lang.String r0 = ": "
            r2.append(r0)
            r2.append(r1)
            java.lang.String r0 = r2.toString()
            r3.<init>(r0)
            r3.s = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.ApiException.<init>(com.google.android.gms.common.api.Status):void");
    }

    @NonNull
    public Status a() {
        return this.s;
    }

    public int b() {
        return this.s.I();
    }

    @Deprecated
    @Nullable
    public String c() {
        return this.s.N();
    }
}
