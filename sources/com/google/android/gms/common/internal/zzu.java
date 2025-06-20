package com.google.android.gms.common.internal;

import android.net.Uri;

public final class zzu {

    /* renamed from: a  reason: collision with root package name */
    private static final Uri f20327a;

    /* renamed from: b  reason: collision with root package name */
    private static final Uri f20328b;

    static {
        Uri parse = Uri.parse("https://plus.google.com/");
        f20327a = parse;
        f20328b = parse.buildUpon().appendPath("circles").appendPath("find").build();
    }
}
