package com.google.android.material.resources;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.os.Handler;
import android.text.TextPaint;
import android.util.Log;
import androidx.annotation.FontRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.annotation.VisibleForTesting;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class TextAppearance {
    private static final String r = "TextAppearance";
    private static final int s = 1;
    private static final int t = 2;
    private static final int u = 3;
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public final ColorStateList f21706a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public final ColorStateList f21707b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public final ColorStateList f21708c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public final String f21709d;

    /* renamed from: e  reason: collision with root package name */
    public final int f21710e;

    /* renamed from: f  reason: collision with root package name */
    public final int f21711f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f21712g;

    /* renamed from: h  reason: collision with root package name */
    public final float f21713h;

    /* renamed from: i  reason: collision with root package name */
    public final float f21714i;

    /* renamed from: j  reason: collision with root package name */
    public final float f21715j;

    /* renamed from: k  reason: collision with root package name */
    public final boolean f21716k;

    /* renamed from: l  reason: collision with root package name */
    public final float f21717l;
    @Nullable

    /* renamed from: m  reason: collision with root package name */
    private ColorStateList f21718m;

    /* renamed from: n  reason: collision with root package name */
    private float f21719n;
    @FontRes
    private final int o;
    /* access modifiers changed from: private */
    public boolean p = false;
    /* access modifiers changed from: private */
    public Typeface q;

    public TextAppearance(@NonNull Context context, @StyleRes int i2) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i2, R.styleable.Zv);
        l(obtainStyledAttributes.getDimension(R.styleable.aw, 0.0f));
        k(MaterialResources.a(context, obtainStyledAttributes, R.styleable.dw));
        this.f21706a = MaterialResources.a(context, obtainStyledAttributes, R.styleable.ew);
        this.f21707b = MaterialResources.a(context, obtainStyledAttributes, R.styleable.fw);
        this.f21710e = obtainStyledAttributes.getInt(R.styleable.cw, 0);
        this.f21711f = obtainStyledAttributes.getInt(R.styleable.bw, 1);
        int g2 = MaterialResources.g(obtainStyledAttributes, R.styleable.mw, R.styleable.kw);
        this.o = obtainStyledAttributes.getResourceId(g2, 0);
        this.f21709d = obtainStyledAttributes.getString(g2);
        this.f21712g = obtainStyledAttributes.getBoolean(R.styleable.ow, false);
        this.f21708c = MaterialResources.a(context, obtainStyledAttributes, R.styleable.gw);
        this.f21713h = obtainStyledAttributes.getFloat(R.styleable.hw, 0.0f);
        this.f21714i = obtainStyledAttributes.getFloat(R.styleable.iw, 0.0f);
        this.f21715j = obtainStyledAttributes.getFloat(R.styleable.jw, 0.0f);
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(i2, R.styleable.Zn);
        int i3 = R.styleable.ao;
        this.f21716k = obtainStyledAttributes2.hasValue(i3);
        this.f21717l = obtainStyledAttributes2.getFloat(i3, 0.0f);
        obtainStyledAttributes2.recycle();
    }

    private void d() {
        String str;
        if (this.q == null && (str = this.f21709d) != null) {
            this.q = Typeface.create(str, this.f21710e);
        }
        if (this.q == null) {
            int i2 = this.f21711f;
            this.q = i2 != 1 ? i2 != 2 ? i2 != 3 ? Typeface.DEFAULT : Typeface.MONOSPACE : Typeface.SERIF : Typeface.SANS_SERIF;
            this.q = Typeface.create(this.q, this.f21710e);
        }
    }

    private boolean m(Context context) {
        if (TextAppearanceConfig.b()) {
            return true;
        }
        int i2 = this.o;
        return (i2 != 0 ? ResourcesCompat.d(context, i2) : null) != null;
    }

    public Typeface e() {
        d();
        return this.q;
    }

    @VisibleForTesting
    @NonNull
    public Typeface f(@NonNull Context context) {
        if (this.p) {
            return this.q;
        }
        if (!context.isRestricted()) {
            try {
                Typeface j2 = ResourcesCompat.j(context, this.o);
                this.q = j2;
                if (j2 != null) {
                    this.q = Typeface.create(j2, this.f21710e);
                }
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            } catch (Exception e2) {
                Log.d(r, "Error loading font " + this.f21709d, e2);
            }
        }
        d();
        this.p = true;
        return this.q;
    }

    public void g(@NonNull final Context context, @NonNull final TextPaint textPaint, @NonNull final TextAppearanceFontCallback textAppearanceFontCallback) {
        p(context, textPaint, e());
        h(context, new TextAppearanceFontCallback() {
            public void a(int i2) {
                textAppearanceFontCallback.a(i2);
            }

            public void b(@NonNull Typeface typeface, boolean z) {
                TextAppearance.this.p(context, textPaint, typeface);
                textAppearanceFontCallback.b(typeface, z);
            }
        });
    }

    public void h(@NonNull Context context, @NonNull final TextAppearanceFontCallback textAppearanceFontCallback) {
        if (m(context)) {
            f(context);
        } else {
            d();
        }
        int i2 = this.o;
        if (i2 == 0) {
            this.p = true;
        }
        if (this.p) {
            textAppearanceFontCallback.b(this.q, true);
            return;
        }
        try {
            ResourcesCompat.l(context, i2, new ResourcesCompat.FontCallback() {
                public void h(int i2) {
                    boolean unused = TextAppearance.this.p = true;
                    textAppearanceFontCallback.a(i2);
                }

                public void i(@NonNull Typeface typeface) {
                    TextAppearance textAppearance = TextAppearance.this;
                    Typeface unused = textAppearance.q = Typeface.create(typeface, textAppearance.f21710e);
                    boolean unused2 = TextAppearance.this.p = true;
                    textAppearanceFontCallback.b(TextAppearance.this.q, false);
                }
            }, (Handler) null);
        } catch (Resources.NotFoundException unused) {
            this.p = true;
            textAppearanceFontCallback.a(1);
        } catch (Exception e2) {
            Log.d(r, "Error loading font " + this.f21709d, e2);
            this.p = true;
            textAppearanceFontCallback.a(-3);
        }
    }

    @Nullable
    public ColorStateList i() {
        return this.f21718m;
    }

    public float j() {
        return this.f21719n;
    }

    public void k(@Nullable ColorStateList colorStateList) {
        this.f21718m = colorStateList;
    }

    public void l(float f2) {
        this.f21719n = f2;
    }

    public void n(@NonNull Context context, @NonNull TextPaint textPaint, @NonNull TextAppearanceFontCallback textAppearanceFontCallback) {
        o(context, textPaint, textAppearanceFontCallback);
        ColorStateList colorStateList = this.f21718m;
        textPaint.setColor(colorStateList != null ? colorStateList.getColorForState(textPaint.drawableState, colorStateList.getDefaultColor()) : ViewCompat.y);
        float f2 = this.f21715j;
        float f3 = this.f21713h;
        float f4 = this.f21714i;
        ColorStateList colorStateList2 = this.f21708c;
        textPaint.setShadowLayer(f2, f3, f4, colorStateList2 != null ? colorStateList2.getColorForState(textPaint.drawableState, colorStateList2.getDefaultColor()) : 0);
    }

    public void o(@NonNull Context context, @NonNull TextPaint textPaint, @NonNull TextAppearanceFontCallback textAppearanceFontCallback) {
        if (m(context)) {
            p(context, textPaint, f(context));
        } else {
            g(context, textPaint, textAppearanceFontCallback);
        }
    }

    public void p(@NonNull Context context, @NonNull TextPaint textPaint, @NonNull Typeface typeface) {
        Typeface a2 = TypefaceUtils.a(context, typeface);
        if (a2 != null) {
            typeface = a2;
        }
        textPaint.setTypeface(typeface);
        int i2 = this.f21710e & (~typeface.getStyle());
        textPaint.setFakeBoldText((i2 & 1) != 0);
        textPaint.setTextSkewX((i2 & 2) != 0 ? -0.25f : 0.0f);
        textPaint.setTextSize(this.f21719n);
        if (this.f21716k) {
            textPaint.setLetterSpacing(this.f21717l);
        }
    }
}
