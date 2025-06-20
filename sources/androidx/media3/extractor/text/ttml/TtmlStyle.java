package androidx.media3.extractor.text.ttml;

import android.text.Layout;
import androidx.annotation.Nullable;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

final class TtmlStyle {
    public static final int A = 2;
    public static final int B = 3;
    private static final int C = 0;
    private static final int D = 1;
    public static final int E = 1;
    public static final int F = 2;
    public static final int G = 3;
    public static final int H = 4;
    public static final int t = -1;
    public static final float u = Float.MAX_VALUE;
    public static final int v = 0;
    public static final int w = 1;
    public static final int x = 2;
    public static final int y = 3;
    public static final int z = 1;
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private String f14057a;

    /* renamed from: b  reason: collision with root package name */
    private int f14058b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f14059c;

    /* renamed from: d  reason: collision with root package name */
    private int f14060d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f14061e;

    /* renamed from: f  reason: collision with root package name */
    private int f14062f = -1;

    /* renamed from: g  reason: collision with root package name */
    private int f14063g = -1;

    /* renamed from: h  reason: collision with root package name */
    private int f14064h = -1;

    /* renamed from: i  reason: collision with root package name */
    private int f14065i = -1;

    /* renamed from: j  reason: collision with root package name */
    private int f14066j = -1;

    /* renamed from: k  reason: collision with root package name */
    private float f14067k;
    @Nullable

    /* renamed from: l  reason: collision with root package name */
    private String f14068l;

    /* renamed from: m  reason: collision with root package name */
    private int f14069m = -1;

    /* renamed from: n  reason: collision with root package name */
    private int f14070n = -1;
    @Nullable
    private Layout.Alignment o;
    @Nullable
    private Layout.Alignment p;
    private int q = -1;
    @Nullable
    private TextEmphasis r;
    private float s = Float.MAX_VALUE;

    @Documented
    @Target({ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface FontSizeUnit {
    }

    @Documented
    @Target({ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface RubyType {
    }

    @Documented
    @Target({ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface StyleFlags {
    }

    @CanIgnoreReturnValue
    private TtmlStyle s(@Nullable TtmlStyle ttmlStyle, boolean z2) {
        int i2;
        Layout.Alignment alignment;
        Layout.Alignment alignment2;
        String str;
        if (ttmlStyle != null) {
            if (!this.f14059c && ttmlStyle.f14059c) {
                x(ttmlStyle.f14058b);
            }
            if (this.f14064h == -1) {
                this.f14064h = ttmlStyle.f14064h;
            }
            if (this.f14065i == -1) {
                this.f14065i = ttmlStyle.f14065i;
            }
            if (this.f14057a == null && (str = ttmlStyle.f14057a) != null) {
                this.f14057a = str;
            }
            if (this.f14062f == -1) {
                this.f14062f = ttmlStyle.f14062f;
            }
            if (this.f14063g == -1) {
                this.f14063g = ttmlStyle.f14063g;
            }
            if (this.f14070n == -1) {
                this.f14070n = ttmlStyle.f14070n;
            }
            if (this.o == null && (alignment2 = ttmlStyle.o) != null) {
                this.o = alignment2;
            }
            if (this.p == null && (alignment = ttmlStyle.p) != null) {
                this.p = alignment;
            }
            if (this.q == -1) {
                this.q = ttmlStyle.q;
            }
            if (this.f14066j == -1) {
                this.f14066j = ttmlStyle.f14066j;
                this.f14067k = ttmlStyle.f14067k;
            }
            if (this.r == null) {
                this.r = ttmlStyle.r;
            }
            if (this.s == Float.MAX_VALUE) {
                this.s = ttmlStyle.s;
            }
            if (z2 && !this.f14061e && ttmlStyle.f14061e) {
                v(ttmlStyle.f14060d);
            }
            if (z2 && this.f14069m == -1 && (i2 = ttmlStyle.f14069m) != -1) {
                this.f14069m = i2;
            }
        }
        return this;
    }

    @CanIgnoreReturnValue
    public TtmlStyle A(int i2) {
        this.f14066j = i2;
        return this;
    }

    @CanIgnoreReturnValue
    public TtmlStyle B(@Nullable String str) {
        this.f14068l = str;
        return this;
    }

    @CanIgnoreReturnValue
    public TtmlStyle C(boolean z2) {
        this.f14065i = z2 ? 1 : 0;
        return this;
    }

    @CanIgnoreReturnValue
    public TtmlStyle D(boolean z2) {
        this.f14062f = z2 ? 1 : 0;
        return this;
    }

    @CanIgnoreReturnValue
    public TtmlStyle E(@Nullable Layout.Alignment alignment) {
        this.p = alignment;
        return this;
    }

    @CanIgnoreReturnValue
    public TtmlStyle F(int i2) {
        this.f14070n = i2;
        return this;
    }

    @CanIgnoreReturnValue
    public TtmlStyle G(int i2) {
        this.f14069m = i2;
        return this;
    }

    @CanIgnoreReturnValue
    public TtmlStyle H(float f2) {
        this.s = f2;
        return this;
    }

    @CanIgnoreReturnValue
    public TtmlStyle I(@Nullable Layout.Alignment alignment) {
        this.o = alignment;
        return this;
    }

    @CanIgnoreReturnValue
    public TtmlStyle J(boolean z2) {
        this.q = z2 ? 1 : 0;
        return this;
    }

    @CanIgnoreReturnValue
    public TtmlStyle K(@Nullable TextEmphasis textEmphasis) {
        this.r = textEmphasis;
        return this;
    }

    @CanIgnoreReturnValue
    public TtmlStyle L(boolean z2) {
        this.f14063g = z2 ? 1 : 0;
        return this;
    }

    @CanIgnoreReturnValue
    public TtmlStyle a(@Nullable TtmlStyle ttmlStyle) {
        return s(ttmlStyle, true);
    }

    public int b() {
        if (this.f14061e) {
            return this.f14060d;
        }
        throw new IllegalStateException("Background color has not been defined.");
    }

    public int c() {
        if (this.f14059c) {
            return this.f14058b;
        }
        throw new IllegalStateException("Font color has not been defined.");
    }

    @Nullable
    public String d() {
        return this.f14057a;
    }

    public float e() {
        return this.f14067k;
    }

    public int f() {
        return this.f14066j;
    }

    @Nullable
    public String g() {
        return this.f14068l;
    }

    @Nullable
    public Layout.Alignment h() {
        return this.p;
    }

    public int i() {
        return this.f14070n;
    }

    public int j() {
        return this.f14069m;
    }

    public float k() {
        return this.s;
    }

    public int l() {
        int i2 = this.f14064h;
        if (i2 == -1 && this.f14065i == -1) {
            return -1;
        }
        int i3 = 0;
        int i4 = i2 == 1 ? 1 : 0;
        if (this.f14065i == 1) {
            i3 = 2;
        }
        return i4 | i3;
    }

    @Nullable
    public Layout.Alignment m() {
        return this.o;
    }

    public boolean n() {
        return this.q == 1;
    }

    @Nullable
    public TextEmphasis o() {
        return this.r;
    }

    public boolean p() {
        return this.f14061e;
    }

    public boolean q() {
        return this.f14059c;
    }

    @CanIgnoreReturnValue
    public TtmlStyle r(@Nullable TtmlStyle ttmlStyle) {
        return s(ttmlStyle, false);
    }

    public boolean t() {
        return this.f14062f == 1;
    }

    public boolean u() {
        return this.f14063g == 1;
    }

    @CanIgnoreReturnValue
    public TtmlStyle v(int i2) {
        this.f14060d = i2;
        this.f14061e = true;
        return this;
    }

    @CanIgnoreReturnValue
    public TtmlStyle w(boolean z2) {
        this.f14064h = z2 ? 1 : 0;
        return this;
    }

    @CanIgnoreReturnValue
    public TtmlStyle x(int i2) {
        this.f14058b = i2;
        this.f14059c = true;
        return this;
    }

    @CanIgnoreReturnValue
    public TtmlStyle y(@Nullable String str) {
        this.f14057a = str;
        return this;
    }

    @CanIgnoreReturnValue
    public TtmlStyle z(float f2) {
        this.f14067k = f2;
        return this;
    }
}
