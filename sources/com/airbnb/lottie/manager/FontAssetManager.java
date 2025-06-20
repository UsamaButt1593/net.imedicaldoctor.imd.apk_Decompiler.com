package com.airbnb.lottie.manager;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.Nullable;
import com.airbnb.lottie.FontAssetDelegate;
import com.airbnb.lottie.model.MutablePair;
import com.airbnb.lottie.utils.Logger;
import java.util.HashMap;
import java.util.Map;

public class FontAssetManager {

    /* renamed from: a  reason: collision with root package name */
    private final MutablePair<String> f17083a = new MutablePair<>();

    /* renamed from: b  reason: collision with root package name */
    private final Map<MutablePair<String>, Typeface> f17084b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, Typeface> f17085c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    private final AssetManager f17086d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private FontAssetDelegate f17087e;

    /* renamed from: f  reason: collision with root package name */
    private String f17088f = ".ttf";

    public FontAssetManager(Drawable.Callback callback, @Nullable FontAssetDelegate fontAssetDelegate) {
        AssetManager assets;
        this.f17087e = fontAssetDelegate;
        if (!(callback instanceof View)) {
            Logger.e("LottieDrawable must be inside of a view for images to work.");
            assets = null;
        } else {
            assets = ((View) callback).getContext().getAssets();
        }
        this.f17086d = assets;
    }

    private Typeface a(String str) {
        String b2;
        Typeface typeface = this.f17085c.get(str);
        if (typeface != null) {
            return typeface;
        }
        FontAssetDelegate fontAssetDelegate = this.f17087e;
        Typeface a2 = fontAssetDelegate != null ? fontAssetDelegate.a(str) : null;
        FontAssetDelegate fontAssetDelegate2 = this.f17087e;
        if (!(fontAssetDelegate2 == null || a2 != null || (b2 = fontAssetDelegate2.b(str)) == null)) {
            a2 = Typeface.createFromAsset(this.f17086d, b2);
        }
        if (a2 == null) {
            a2 = Typeface.createFromAsset(this.f17086d, "fonts/" + str + this.f17088f);
        }
        this.f17085c.put(str, a2);
        return a2;
    }

    private Typeface e(Typeface typeface, String str) {
        boolean contains = str.contains("Italic");
        boolean contains2 = str.contains("Bold");
        int i2 = (!contains || !contains2) ? contains ? 2 : contains2 ? 1 : 0 : 3;
        return typeface.getStyle() == i2 ? typeface : Typeface.create(typeface, i2);
    }

    public Typeface b(String str, String str2) {
        this.f17083a.b(str, str2);
        Typeface typeface = this.f17084b.get(this.f17083a);
        if (typeface != null) {
            return typeface;
        }
        Typeface e2 = e(a(str), str2);
        this.f17084b.put(this.f17083a, e2);
        return e2;
    }

    public void c(String str) {
        this.f17088f = str;
    }

    public void d(@Nullable FontAssetDelegate fontAssetDelegate) {
        this.f17087e = fontAssetDelegate;
    }
}
