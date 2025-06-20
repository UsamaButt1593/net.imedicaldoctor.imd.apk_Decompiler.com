package com.bumptech.glide.load.resource.drawable;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import java.util.List;

public class ResourceDrawableDecoder implements ResourceDecoder<Uri, Drawable> {

    /* renamed from: b  reason: collision with root package name */
    private static final String f18359b = "android";

    /* renamed from: c  reason: collision with root package name */
    private static final int f18360c = 0;

    /* renamed from: d  reason: collision with root package name */
    private static final int f18361d = 2;

    /* renamed from: e  reason: collision with root package name */
    private static final int f18362e = 0;

    /* renamed from: f  reason: collision with root package name */
    private static final int f18363f = 1;

    /* renamed from: g  reason: collision with root package name */
    private static final int f18364g = 1;

    /* renamed from: h  reason: collision with root package name */
    private static final int f18365h = 0;

    /* renamed from: a  reason: collision with root package name */
    private final Context f18366a;

    public ResourceDrawableDecoder(Context context) {
        this.f18366a = context.getApplicationContext();
    }

    @NonNull
    private Context d(Uri uri, String str) {
        if (str.equals(this.f18366a.getPackageName())) {
            return this.f18366a;
        }
        try {
            return this.f18366a.createPackageContext(str, 0);
        } catch (PackageManager.NameNotFoundException e2) {
            if (str.contains(this.f18366a.getPackageName())) {
                return this.f18366a;
            }
            throw new IllegalArgumentException("Failed to obtain context or unrecognized Uri format for: " + uri, e2);
        }
    }

    @DrawableRes
    private int e(Uri uri) {
        try {
            return Integer.parseInt(uri.getPathSegments().get(0));
        } catch (NumberFormatException e2) {
            throw new IllegalArgumentException("Unrecognized Uri format: " + uri, e2);
        }
    }

    @DrawableRes
    private int f(Context context, Uri uri) {
        List<String> pathSegments = uri.getPathSegments();
        String authority = uri.getAuthority();
        String str = pathSegments.get(0);
        String str2 = pathSegments.get(1);
        int identifier = context.getResources().getIdentifier(str2, str, authority);
        if (identifier == 0) {
            identifier = Resources.getSystem().getIdentifier(str2, str, f18359b);
        }
        if (identifier != 0) {
            return identifier;
        }
        throw new IllegalArgumentException("Failed to find resource id for: " + uri);
    }

    @DrawableRes
    private int g(Context context, Uri uri) {
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments.size() == 2) {
            return f(context, uri);
        }
        if (pathSegments.size() == 1) {
            return e(uri);
        }
        throw new IllegalArgumentException("Unrecognized Uri format: " + uri);
    }

    @Nullable
    /* renamed from: c */
    public Resource<Drawable> b(@NonNull Uri uri, int i2, int i3, @NonNull Options options) {
        Context d2 = d(uri, uri.getAuthority());
        return NonOwnedDrawableResource.e(DrawableDecoderCompat.b(this.f18366a, d2, g(d2, uri)));
    }

    /* renamed from: h */
    public boolean a(@NonNull Uri uri, @NonNull Options options) {
        return uri.getScheme().equals("android.resource");
    }
}
