package com.bumptech.glide.load.data.mediastore;

import android.net.Uri;
import com.itextpdf.text.Annotation;

public final class MediaStoreUtil {

    /* renamed from: a  reason: collision with root package name */
    private static final int f17846a = 512;

    /* renamed from: b  reason: collision with root package name */
    private static final int f17847b = 384;

    private MediaStoreUtil() {
    }

    public static boolean a(Uri uri) {
        return b(uri) && !e(uri);
    }

    public static boolean b(Uri uri) {
        return uri != null && Annotation.i3.equals(uri.getScheme()) && "media".equals(uri.getAuthority());
    }

    public static boolean c(Uri uri) {
        return b(uri) && e(uri);
    }

    public static boolean d(int i2, int i3) {
        return i2 != Integer.MIN_VALUE && i3 != Integer.MIN_VALUE && i2 <= 512 && i3 <= 384;
    }

    private static boolean e(Uri uri) {
        return uri.getPathSegments().contains("video");
    }
}
