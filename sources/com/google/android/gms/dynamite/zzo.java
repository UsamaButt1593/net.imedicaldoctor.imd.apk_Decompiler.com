package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;

final class zzo implements DynamiteModule.VersionPolicy.IVersions {

    /* renamed from: a  reason: collision with root package name */
    private final int f20486a;

    public zzo(int i2, int i3) {
        this.f20486a = i2;
    }

    public final int a(Context context, String str, boolean z) {
        return 0;
    }

    public final int b(Context context, String str) {
        return this.f20486a;
    }
}
