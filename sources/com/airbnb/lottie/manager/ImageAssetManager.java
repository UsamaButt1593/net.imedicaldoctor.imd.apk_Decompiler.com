package com.airbnb.lottie.manager;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import androidx.annotation.Nullable;
import com.airbnb.lottie.ImageAssetDelegate;
import com.airbnb.lottie.LottieImageAsset;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.Utils;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ImageAssetManager {

    /* renamed from: e  reason: collision with root package name */
    private static final Object f17089e = new Object();

    /* renamed from: a  reason: collision with root package name */
    private final Context f17090a;

    /* renamed from: b  reason: collision with root package name */
    private String f17091b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private ImageAssetDelegate f17092c;

    /* renamed from: d  reason: collision with root package name */
    private final Map<String, LottieImageAsset> f17093d;

    public ImageAssetManager(Drawable.Callback callback, String str, ImageAssetDelegate imageAssetDelegate, Map<String, LottieImageAsset> map) {
        this.f17091b = str;
        if (!TextUtils.isEmpty(str)) {
            String str2 = this.f17091b;
            if (str2.charAt(str2.length() - 1) != '/') {
                this.f17091b += '/';
            }
        }
        if (!(callback instanceof View)) {
            Logger.e("LottieDrawable must be inside of a view for images to work.");
            this.f17093d = new HashMap();
            this.f17090a = null;
            return;
        }
        this.f17090a = ((View) callback).getContext();
        this.f17093d = map;
        d(imageAssetDelegate);
    }

    private Bitmap c(String str, @Nullable Bitmap bitmap) {
        synchronized (f17089e) {
            this.f17093d.get(str).g(bitmap);
        }
        return bitmap;
    }

    @Nullable
    public Bitmap a(String str) {
        String str2;
        Bitmap m2;
        LottieImageAsset lottieImageAsset = this.f17093d.get(str);
        if (lottieImageAsset == null) {
            return null;
        }
        Bitmap a2 = lottieImageAsset.a();
        if (a2 != null) {
            return a2;
        }
        ImageAssetDelegate imageAssetDelegate = this.f17092c;
        if (imageAssetDelegate != null) {
            Bitmap a3 = imageAssetDelegate.a(lottieImageAsset);
            if (a3 != null) {
                c(str, a3);
            }
            return a3;
        }
        String c2 = lottieImageAsset.c();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = true;
        options.inDensity = 160;
        if (!c2.startsWith("data:") || c2.indexOf("base64,") <= 0) {
            try {
                if (!TextUtils.isEmpty(this.f17091b)) {
                    AssetManager assets = this.f17090a.getAssets();
                    m2 = Utils.m(BitmapFactory.decodeStream(assets.open(this.f17091b + c2), (Rect) null, options), lottieImageAsset.f(), lottieImageAsset.d());
                } else {
                    throw new IllegalStateException("You must set an images folder before loading an image. Set it with LottieComposition#setImagesFolder or LottieDrawable#setImagesFolder");
                }
            } catch (IOException e2) {
                e = e2;
                str2 = "Unable to open asset.";
                Logger.f(str2, e);
                return null;
            }
        } else {
            try {
                byte[] decode = Base64.decode(c2.substring(c2.indexOf(44) + 1), 0);
                m2 = BitmapFactory.decodeByteArray(decode, 0, decode.length, options);
            } catch (IllegalArgumentException e3) {
                e = e3;
                str2 = "data URL did not have correct base64 format.";
                Logger.f(str2, e);
                return null;
            }
        }
        return c(str, m2);
    }

    public boolean b(Context context) {
        return (context == null && this.f17090a == null) || this.f17090a.equals(context);
    }

    public void d(@Nullable ImageAssetDelegate imageAssetDelegate) {
        this.f17092c = imageAssetDelegate;
    }

    @Nullable
    public Bitmap e(String str, @Nullable Bitmap bitmap) {
        if (bitmap == null) {
            LottieImageAsset lottieImageAsset = this.f17093d.get(str);
            Bitmap a2 = lottieImageAsset.a();
            lottieImageAsset.g((Bitmap) null);
            return a2;
        }
        Bitmap a3 = this.f17093d.get(str).a();
        c(str, bitmap);
        return a3;
    }
}
