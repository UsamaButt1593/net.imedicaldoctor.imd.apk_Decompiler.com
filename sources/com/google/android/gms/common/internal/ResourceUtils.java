package com.google.android.gms.common.internal;

import android.net.Uri;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public final class ResourceUtils {

    /* renamed from: a  reason: collision with root package name */
    private static final Uri f20256a = new Uri.Builder().scheme("android.resource").authority("com.google.android.gms").appendPath("drawable").build();

    private ResourceUtils() {
    }
}
