package androidx.media3.ui;

import android.graphics.Typeface;
import android.view.accessibility.CaptioningManager;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.view.ViewCompat;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@UnstableApi
public final class CaptionStyleCompat {

    /* renamed from: g  reason: collision with root package name */
    public static final int f14612g = 0;

    /* renamed from: h  reason: collision with root package name */
    public static final int f14613h = 1;

    /* renamed from: i  reason: collision with root package name */
    public static final int f14614i = 2;

    /* renamed from: j  reason: collision with root package name */
    public static final int f14615j = 3;

    /* renamed from: k  reason: collision with root package name */
    public static final int f14616k = 4;

    /* renamed from: l  reason: collision with root package name */
    public static final int f14617l = 1;

    /* renamed from: m  reason: collision with root package name */
    public static final CaptionStyleCompat f14618m = new CaptionStyleCompat(-1, ViewCompat.y, 0, 0, -1, (Typeface) null);

    /* renamed from: a  reason: collision with root package name */
    public final int f14619a;

    /* renamed from: b  reason: collision with root package name */
    public final int f14620b;

    /* renamed from: c  reason: collision with root package name */
    public final int f14621c;

    /* renamed from: d  reason: collision with root package name */
    public final int f14622d;

    /* renamed from: e  reason: collision with root package name */
    public final int f14623e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public final Typeface f14624f;

    @Documented
    @Target({ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface EdgeType {
    }

    public CaptionStyleCompat(int i2, int i3, int i4, int i5, int i6, @Nullable Typeface typeface) {
        this.f14619a = i2;
        this.f14620b = i3;
        this.f14621c = i4;
        this.f14622d = i5;
        this.f14623e = i6;
        this.f14624f = typeface;
    }

    @RequiresApi(19)
    public static CaptionStyleCompat a(CaptioningManager.CaptionStyle captionStyle) {
        return Util.f9646a >= 21 ? c(captionStyle) : b(captionStyle);
    }

    @RequiresApi(19)
    private static CaptionStyleCompat b(CaptioningManager.CaptionStyle captionStyle) {
        return new CaptionStyleCompat(captionStyle.foregroundColor, captionStyle.backgroundColor, 0, captionStyle.edgeType, captionStyle.edgeColor, captionStyle.getTypeface());
    }

    @RequiresApi(21)
    private static CaptionStyleCompat c(CaptioningManager.CaptionStyle captionStyle) {
        return new CaptionStyleCompat(captionStyle.hasForegroundColor() ? captionStyle.foregroundColor : f14618m.f14619a, captionStyle.hasBackgroundColor() ? captionStyle.backgroundColor : f14618m.f14620b, captionStyle.hasWindowColor() ? captionStyle.windowColor : f14618m.f14621c, captionStyle.hasEdgeType() ? captionStyle.edgeType : f14618m.f14622d, captionStyle.hasEdgeColor() ? captionStyle.edgeColor : f14618m.f14623e, captionStyle.getTypeface());
    }
}
