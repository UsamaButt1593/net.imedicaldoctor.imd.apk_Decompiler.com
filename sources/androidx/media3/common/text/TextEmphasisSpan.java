package androidx.media3.common.text;

import android.os.Bundle;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@UnstableApi
public final class TextEmphasisSpan implements LanguageFeatureSpan {

    /* renamed from: d  reason: collision with root package name */
    public static final int f9483d = 0;

    /* renamed from: e  reason: collision with root package name */
    public static final int f9484e = 1;

    /* renamed from: f  reason: collision with root package name */
    public static final int f9485f = 2;

    /* renamed from: g  reason: collision with root package name */
    public static final int f9486g = 3;

    /* renamed from: h  reason: collision with root package name */
    public static final int f9487h = 0;

    /* renamed from: i  reason: collision with root package name */
    public static final int f9488i = 1;

    /* renamed from: j  reason: collision with root package name */
    public static final int f9489j = 2;

    /* renamed from: k  reason: collision with root package name */
    private static final String f9490k = Util.d1(0);

    /* renamed from: l  reason: collision with root package name */
    private static final String f9491l = Util.d1(1);

    /* renamed from: m  reason: collision with root package name */
    private static final String f9492m = Util.d1(2);

    /* renamed from: a  reason: collision with root package name */
    public int f9493a;

    /* renamed from: b  reason: collision with root package name */
    public int f9494b;

    /* renamed from: c  reason: collision with root package name */
    public final int f9495c;

    @Documented
    @Target({ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface MarkFill {
    }

    @Documented
    @Target({ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface MarkShape {
    }

    public TextEmphasisSpan(int i2, int i3, int i4) {
        this.f9493a = i2;
        this.f9494b = i3;
        this.f9495c = i4;
    }

    public static TextEmphasisSpan a(Bundle bundle) {
        return new TextEmphasisSpan(bundle.getInt(f9490k), bundle.getInt(f9491l), bundle.getInt(f9492m));
    }

    public Bundle b() {
        Bundle bundle = new Bundle();
        bundle.putInt(f9490k, this.f9493a);
        bundle.putInt(f9491l, this.f9494b);
        bundle.putInt(f9492m, this.f9495c);
        return bundle;
    }
}
