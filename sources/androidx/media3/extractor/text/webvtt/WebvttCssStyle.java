package androidx.media3.extractor.text.webvtt;

import android.text.TextUtils;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import androidx.media3.common.util.UnstableApi;
import com.google.common.base.Ascii;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@UnstableApi
public final class WebvttCssStyle {
    private static final int A = 1;
    public static final int r = -1;
    public static final int s = 0;
    public static final int t = 1;
    public static final int u = 2;
    public static final int v = 3;
    public static final int w = 1;
    public static final int x = 2;
    public static final int y = 3;
    private static final int z = 0;

    /* renamed from: a  reason: collision with root package name */
    private String f14105a = "";

    /* renamed from: b  reason: collision with root package name */
    private String f14106b = "";

    /* renamed from: c  reason: collision with root package name */
    private Set<String> f14107c = Collections.emptySet();

    /* renamed from: d  reason: collision with root package name */
    private String f14108d = "";
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private String f14109e = null;
    @ColorInt

    /* renamed from: f  reason: collision with root package name */
    private int f14110f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f14111g = false;

    /* renamed from: h  reason: collision with root package name */
    private int f14112h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f14113i = false;

    /* renamed from: j  reason: collision with root package name */
    private int f14114j = -1;

    /* renamed from: k  reason: collision with root package name */
    private int f14115k = -1;

    /* renamed from: l  reason: collision with root package name */
    private int f14116l = -1;

    /* renamed from: m  reason: collision with root package name */
    private int f14117m = -1;

    /* renamed from: n  reason: collision with root package name */
    private int f14118n = -1;
    private float o;
    private int p = -1;
    private boolean q = false;

    @Documented
    @Target({ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface FontSizeUnit {
    }

    @Documented
    @Target({ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface StyleFlags {
    }

    private static int C(int i2, String str, @Nullable String str2, int i3) {
        if (str.isEmpty() || i2 == -1) {
            return i2;
        }
        if (str.equals(str2)) {
            return i2 + i3;
        }
        return -1;
    }

    public void A(String str) {
        this.f14108d = str;
    }

    @CanIgnoreReturnValue
    public WebvttCssStyle B(boolean z2) {
        this.f14115k = z2 ? 1 : 0;
        return this;
    }

    public int a() {
        if (this.f14113i) {
            return this.f14112h;
        }
        throw new IllegalStateException("Background color not defined.");
    }

    public boolean b() {
        return this.q;
    }

    public int c() {
        if (this.f14111g) {
            return this.f14110f;
        }
        throw new IllegalStateException("Font color not defined");
    }

    @Nullable
    public String d() {
        return this.f14109e;
    }

    public float e() {
        return this.o;
    }

    public int f() {
        return this.f14118n;
    }

    public int g() {
        return this.p;
    }

    public int h(@Nullable String str, @Nullable String str2, Set<String> set, @Nullable String str3) {
        if (this.f14105a.isEmpty() && this.f14106b.isEmpty() && this.f14107c.isEmpty() && this.f14108d.isEmpty()) {
            return TextUtils.isEmpty(str2) ? 1 : 0;
        }
        int C = C(C(C(0, this.f14105a, str, 1073741824), this.f14106b, str2, 2), this.f14108d, str3, 4);
        if (C == -1 || !set.containsAll(this.f14107c)) {
            return 0;
        }
        return C + (this.f14107c.size() * 4);
    }

    public int i() {
        int i2 = this.f14116l;
        if (i2 == -1 && this.f14117m == -1) {
            return -1;
        }
        int i3 = 0;
        int i4 = i2 == 1 ? 1 : 0;
        if (this.f14117m == 1) {
            i3 = 2;
        }
        return i4 | i3;
    }

    public boolean j() {
        return this.f14113i;
    }

    public boolean k() {
        return this.f14111g;
    }

    public boolean l() {
        return this.f14114j == 1;
    }

    public boolean m() {
        return this.f14115k == 1;
    }

    @CanIgnoreReturnValue
    public WebvttCssStyle n(int i2) {
        this.f14112h = i2;
        this.f14113i = true;
        return this;
    }

    @CanIgnoreReturnValue
    public WebvttCssStyle o(boolean z2) {
        this.f14116l = z2 ? 1 : 0;
        return this;
    }

    @CanIgnoreReturnValue
    public WebvttCssStyle p(boolean z2) {
        this.q = z2;
        return this;
    }

    @CanIgnoreReturnValue
    public WebvttCssStyle q(int i2) {
        this.f14110f = i2;
        this.f14111g = true;
        return this;
    }

    @CanIgnoreReturnValue
    public WebvttCssStyle r(@Nullable String str) {
        this.f14109e = str == null ? null : Ascii.g(str);
        return this;
    }

    @CanIgnoreReturnValue
    public WebvttCssStyle s(float f2) {
        this.o = f2;
        return this;
    }

    @CanIgnoreReturnValue
    public WebvttCssStyle t(int i2) {
        this.f14118n = i2;
        return this;
    }

    @CanIgnoreReturnValue
    public WebvttCssStyle u(boolean z2) {
        this.f14117m = z2 ? 1 : 0;
        return this;
    }

    @CanIgnoreReturnValue
    public WebvttCssStyle v(boolean z2) {
        this.f14114j = z2 ? 1 : 0;
        return this;
    }

    @CanIgnoreReturnValue
    public WebvttCssStyle w(int i2) {
        this.p = i2;
        return this;
    }

    public void x(String[] strArr) {
        this.f14107c = new HashSet(Arrays.asList(strArr));
    }

    public void y(String str) {
        this.f14105a = str;
    }

    public void z(String str) {
        this.f14106b = str;
    }
}
