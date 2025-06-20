package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.LocaleList;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.inputmethod.EditorInfoCompat;
import java.lang.ref.WeakReference;
import java.util.Locale;

class AppCompatTextHelper {

    /* renamed from: n  reason: collision with root package name */
    private static final int f3139n = -1;
    private static final int o = 1;
    private static final int p = 2;
    private static final int q = 3;
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final TextView f3140a;

    /* renamed from: b  reason: collision with root package name */
    private TintInfo f3141b;

    /* renamed from: c  reason: collision with root package name */
    private TintInfo f3142c;

    /* renamed from: d  reason: collision with root package name */
    private TintInfo f3143d;

    /* renamed from: e  reason: collision with root package name */
    private TintInfo f3144e;

    /* renamed from: f  reason: collision with root package name */
    private TintInfo f3145f;

    /* renamed from: g  reason: collision with root package name */
    private TintInfo f3146g;

    /* renamed from: h  reason: collision with root package name */
    private TintInfo f3147h;
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    private final AppCompatTextViewAutoSizeHelper f3148i;

    /* renamed from: j  reason: collision with root package name */
    private int f3149j = 0;

    /* renamed from: k  reason: collision with root package name */
    private int f3150k = -1;

    /* renamed from: l  reason: collision with root package name */
    private Typeface f3151l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f3152m;

    @RequiresApi(21)
    static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        static Locale a(String str) {
            return Locale.forLanguageTag(str);
        }
    }

    @RequiresApi(24)
    static class Api24Impl {
        private Api24Impl() {
        }

        @DoNotInline
        static LocaleList a(String str) {
            return LocaleList.forLanguageTags(str);
        }

        @DoNotInline
        static void b(TextView textView, LocaleList localeList) {
            textView.setTextLocales(localeList);
        }
    }

    @RequiresApi(26)
    static class Api26Impl {
        private Api26Impl() {
        }

        @DoNotInline
        static int a(TextView textView) {
            return textView.getAutoSizeStepGranularity();
        }

        @DoNotInline
        static void b(TextView textView, int i2, int i3, int i4, int i5) {
            textView.setAutoSizeTextTypeUniformWithConfiguration(i2, i3, i4, i5);
        }

        @DoNotInline
        static void c(TextView textView, int[] iArr, int i2) {
            textView.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i2);
        }

        @DoNotInline
        static boolean d(TextView textView, String str) {
            return textView.setFontVariationSettings(str);
        }
    }

    @RequiresApi(28)
    static class Api28Impl {
        private Api28Impl() {
        }

        @DoNotInline
        static Typeface a(Typeface typeface, int i2, boolean z) {
            return Typeface.create(typeface, i2, z);
        }
    }

    AppCompatTextHelper(@NonNull TextView textView) {
        this.f3140a = textView;
        this.f3148i = new AppCompatTextViewAutoSizeHelper(textView);
    }

    private void B(int i2, float f2) {
        this.f3148i.t(i2, f2);
    }

    private void C(Context context, TintTypedArray tintTypedArray) {
        String w;
        Typeface create;
        Typeface typeface;
        this.f3149j = tintTypedArray.o(R.styleable.d6, this.f3149j);
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 28) {
            int o2 = tintTypedArray.o(R.styleable.m6, -1);
            this.f3150k = o2;
            if (o2 != -1) {
                this.f3149j &= 2;
            }
        }
        int i3 = R.styleable.l6;
        boolean z = true;
        if (tintTypedArray.C(i3) || tintTypedArray.C(R.styleable.n6)) {
            this.f3151l = null;
            int i4 = R.styleable.n6;
            if (tintTypedArray.C(i4)) {
                i3 = i4;
            }
            final int i5 = this.f3150k;
            final int i6 = this.f3149j;
            if (!context.isRestricted()) {
                final WeakReference weakReference = new WeakReference(this.f3140a);
                try {
                    Typeface k2 = tintTypedArray.k(i3, this.f3149j, new ResourcesCompat.FontCallback() {
                        public void h(int i2) {
                        }

                        public void i(@NonNull Typeface typeface) {
                            int i2;
                            if (Build.VERSION.SDK_INT >= 28 && (i2 = i5) != -1) {
                                typeface = Api28Impl.a(typeface, i2, (i6 & 2) != 0);
                            }
                            AppCompatTextHelper.this.n(weakReference, typeface);
                        }
                    });
                    if (k2 != null) {
                        if (i2 >= 28 && this.f3150k != -1) {
                            k2 = Api28Impl.a(Typeface.create(k2, 0), this.f3150k, (this.f3149j & 2) != 0);
                        }
                        this.f3151l = k2;
                    }
                    this.f3152m = this.f3151l == null;
                } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
                }
            }
            if (this.f3151l == null && (w = tintTypedArray.w(i3)) != null) {
                if (Build.VERSION.SDK_INT < 28 || this.f3150k == -1) {
                    create = Typeface.create(w, this.f3149j);
                } else {
                    Typeface create2 = Typeface.create(w, 0);
                    int i7 = this.f3150k;
                    if ((this.f3149j & 2) == 0) {
                        z = false;
                    }
                    create = Api28Impl.a(create2, i7, z);
                }
                this.f3151l = create;
                return;
            }
            return;
        }
        int i8 = R.styleable.c6;
        if (tintTypedArray.C(i8)) {
            this.f3152m = false;
            int o3 = tintTypedArray.o(i8, 1);
            if (o3 == 1) {
                typeface = Typeface.SANS_SERIF;
            } else if (o3 == 2) {
                typeface = Typeface.SERIF;
            } else if (o3 == 3) {
                typeface = Typeface.MONOSPACE;
            } else {
                return;
            }
            this.f3151l = typeface;
        }
    }

    private void a(Drawable drawable, TintInfo tintInfo) {
        if (drawable != null && tintInfo != null) {
            AppCompatDrawableManager.j(drawable, tintInfo, this.f3140a.getDrawableState());
        }
    }

    private static TintInfo d(Context context, AppCompatDrawableManager appCompatDrawableManager, int i2) {
        ColorStateList f2 = appCompatDrawableManager.f(context, i2);
        if (f2 == null) {
            return null;
        }
        TintInfo tintInfo = new TintInfo();
        tintInfo.f3315d = true;
        tintInfo.f3312a = f2;
        return tintInfo;
    }

    private void y(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4, Drawable drawable5, Drawable drawable6) {
        if (drawable5 != null || drawable6 != null) {
            Drawable[] compoundDrawablesRelative = this.f3140a.getCompoundDrawablesRelative();
            if (drawable5 == null) {
                drawable5 = compoundDrawablesRelative[0];
            }
            if (drawable2 == null) {
                drawable2 = compoundDrawablesRelative[1];
            }
            if (drawable6 == null) {
                drawable6 = compoundDrawablesRelative[2];
            }
            TextView textView = this.f3140a;
            if (drawable4 == null) {
                drawable4 = compoundDrawablesRelative[3];
            }
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable5, drawable2, drawable6, drawable4);
        } else if (drawable != null || drawable2 != null || drawable3 != null || drawable4 != null) {
            Drawable[] compoundDrawablesRelative2 = this.f3140a.getCompoundDrawablesRelative();
            Drawable drawable7 = compoundDrawablesRelative2[0];
            if (drawable7 == null && compoundDrawablesRelative2[2] == null) {
                Drawable[] compoundDrawables = this.f3140a.getCompoundDrawables();
                TextView textView2 = this.f3140a;
                if (drawable == null) {
                    drawable = compoundDrawables[0];
                }
                if (drawable2 == null) {
                    drawable2 = compoundDrawables[1];
                }
                if (drawable3 == null) {
                    drawable3 = compoundDrawables[2];
                }
                if (drawable4 == null) {
                    drawable4 = compoundDrawables[3];
                }
                textView2.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
                return;
            }
            if (drawable2 == null) {
                drawable2 = compoundDrawablesRelative2[1];
            }
            if (drawable4 == null) {
                drawable4 = compoundDrawablesRelative2[3];
            }
            this.f3140a.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable7, drawable2, compoundDrawablesRelative2[2], drawable4);
        }
    }

    private void z() {
        TintInfo tintInfo = this.f3147h;
        this.f3141b = tintInfo;
        this.f3142c = tintInfo;
        this.f3143d = tintInfo;
        this.f3144e = tintInfo;
        this.f3145f = tintInfo;
        this.f3146g = tintInfo;
    }

    /* access modifiers changed from: package-private */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void A(int i2, float f2) {
        if (!ViewUtils.f3370d && !l()) {
            B(i2, f2);
        }
    }

    /* access modifiers changed from: package-private */
    public void b() {
        if (!(this.f3141b == null && this.f3142c == null && this.f3143d == null && this.f3144e == null)) {
            Drawable[] compoundDrawables = this.f3140a.getCompoundDrawables();
            a(compoundDrawables[0], this.f3141b);
            a(compoundDrawables[1], this.f3142c);
            a(compoundDrawables[2], this.f3143d);
            a(compoundDrawables[3], this.f3144e);
        }
        if (this.f3145f != null || this.f3146g != null) {
            Drawable[] compoundDrawablesRelative = this.f3140a.getCompoundDrawablesRelative();
            a(compoundDrawablesRelative[0], this.f3145f);
            a(compoundDrawablesRelative[2], this.f3146g);
        }
    }

    /* access modifiers changed from: package-private */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void c() {
        this.f3148i.a();
    }

    /* access modifiers changed from: package-private */
    public int e() {
        return this.f3148i.f();
    }

    /* access modifiers changed from: package-private */
    public int f() {
        return this.f3148i.g();
    }

    /* access modifiers changed from: package-private */
    public int g() {
        return this.f3148i.h();
    }

    /* access modifiers changed from: package-private */
    public int[] h() {
        return this.f3148i.i();
    }

    /* access modifiers changed from: package-private */
    public int i() {
        return this.f3148i.j();
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public ColorStateList j() {
        TintInfo tintInfo = this.f3147h;
        if (tintInfo != null) {
            return tintInfo.f3312a;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public PorterDuff.Mode k() {
        TintInfo tintInfo = this.f3147h;
        if (tintInfo != null) {
            return tintInfo.f3313b;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean l() {
        return this.f3148i.n();
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x01db  */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x01e2  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x021e  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x0259  */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x025f  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x0268  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x026e  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x0277  */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x027d  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x0286  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x028c  */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x0295  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x029b  */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x02a4  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x02aa  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x02be  */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x02cf  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x02df  */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x02f4  */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x0316  */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x031f  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x0326  */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x032f  */
    /* JADX WARNING: Removed duplicated region for block: B:171:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00f7  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0102  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0107  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x010a  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0142  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x016e  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0176  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0186  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x01a9  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x01b0  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x01b7  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x01c7  */
    @android.annotation.SuppressLint({"NewApi"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m(@androidx.annotation.Nullable android.util.AttributeSet r23, int r24) {
        /*
            r22 = this;
            r7 = r22
            r8 = r23
            r9 = r24
            android.widget.TextView r0 = r7.f3140a
            android.content.Context r10 = r0.getContext()
            androidx.appcompat.widget.AppCompatDrawableManager r11 = androidx.appcompat.widget.AppCompatDrawableManager.b()
            int[] r2 = androidx.appcompat.R.styleable.n0
            r12 = 0
            androidx.appcompat.widget.TintTypedArray r13 = androidx.appcompat.widget.TintTypedArray.G(r10, r8, r2, r9, r12)
            android.widget.TextView r0 = r7.f3140a
            android.content.Context r1 = r0.getContext()
            android.content.res.TypedArray r4 = r13.B()
            r6 = 0
            r3 = r23
            r5 = r24
            androidx.core.view.ViewCompat.F1(r0, r1, r2, r3, r4, r5, r6)
            int r0 = androidx.appcompat.R.styleable.o0
            r14 = -1
            int r0 = r13.u(r0, r14)
            int r1 = androidx.appcompat.R.styleable.r0
            boolean r2 = r13.C(r1)
            if (r2 == 0) goto L_0x0042
            int r1 = r13.u(r1, r12)
            androidx.appcompat.widget.TintInfo r1 = d(r10, r11, r1)
            r7.f3141b = r1
        L_0x0042:
            int r1 = androidx.appcompat.R.styleable.p0
            boolean r2 = r13.C(r1)
            if (r2 == 0) goto L_0x0054
            int r1 = r13.u(r1, r12)
            androidx.appcompat.widget.TintInfo r1 = d(r10, r11, r1)
            r7.f3142c = r1
        L_0x0054:
            int r1 = androidx.appcompat.R.styleable.s0
            boolean r2 = r13.C(r1)
            if (r2 == 0) goto L_0x0066
            int r1 = r13.u(r1, r12)
            androidx.appcompat.widget.TintInfo r1 = d(r10, r11, r1)
            r7.f3143d = r1
        L_0x0066:
            int r1 = androidx.appcompat.R.styleable.q0
            boolean r2 = r13.C(r1)
            if (r2 == 0) goto L_0x0078
            int r1 = r13.u(r1, r12)
            androidx.appcompat.widget.TintInfo r1 = d(r10, r11, r1)
            r7.f3144e = r1
        L_0x0078:
            int r1 = androidx.appcompat.R.styleable.t0
            boolean r2 = r13.C(r1)
            if (r2 == 0) goto L_0x008a
            int r1 = r13.u(r1, r12)
            androidx.appcompat.widget.TintInfo r1 = d(r10, r11, r1)
            r7.f3145f = r1
        L_0x008a:
            int r1 = androidx.appcompat.R.styleable.u0
            boolean r2 = r13.C(r1)
            if (r2 == 0) goto L_0x009c
            int r1 = r13.u(r1, r12)
            androidx.appcompat.widget.TintInfo r1 = d(r10, r11, r1)
            r7.f3146g = r1
        L_0x009c:
            r13.I()
            android.widget.TextView r1 = r7.f3140a
            android.text.method.TransformationMethod r1 = r1.getTransformationMethod()
            boolean r1 = r1 instanceof android.text.method.PasswordTransformationMethod
            r2 = 26
            r3 = 23
            if (r0 == r14) goto L_0x011c
            int[] r5 = androidx.appcompat.R.styleable.a6
            androidx.appcompat.widget.TintTypedArray r0 = androidx.appcompat.widget.TintTypedArray.E(r10, r0, r5)
            if (r1 != 0) goto L_0x00c3
            int r5 = androidx.appcompat.R.styleable.p6
            boolean r6 = r0.C(r5)
            if (r6 == 0) goto L_0x00c3
            boolean r5 = r0.a(r5, r12)
            r6 = 1
            goto L_0x00c5
        L_0x00c3:
            r5 = 0
            r6 = 0
        L_0x00c5:
            r7.C(r10, r0)
            int r15 = android.os.Build.VERSION.SDK_INT
            if (r15 >= r3) goto L_0x00f7
            int r4 = androidx.appcompat.R.styleable.e6
            boolean r17 = r0.C(r4)
            if (r17 == 0) goto L_0x00d9
            android.content.res.ColorStateList r4 = r0.d(r4)
            goto L_0x00da
        L_0x00d9:
            r4 = 0
        L_0x00da:
            int r13 = androidx.appcompat.R.styleable.f6
            boolean r18 = r0.C(r13)
            if (r18 == 0) goto L_0x00e7
            android.content.res.ColorStateList r13 = r0.d(r13)
            goto L_0x00e8
        L_0x00e7:
            r13 = 0
        L_0x00e8:
            int r14 = androidx.appcompat.R.styleable.g6
            boolean r19 = r0.C(r14)
            if (r19 == 0) goto L_0x00f5
            android.content.res.ColorStateList r14 = r0.d(r14)
            goto L_0x00fa
        L_0x00f5:
            r14 = 0
            goto L_0x00fa
        L_0x00f7:
            r4 = 0
            r13 = 0
            goto L_0x00f5
        L_0x00fa:
            int r3 = androidx.appcompat.R.styleable.q6
            boolean r20 = r0.C(r3)
            if (r20 == 0) goto L_0x0107
            java.lang.String r3 = r0.w(r3)
            goto L_0x0108
        L_0x0107:
            r3 = 0
        L_0x0108:
            if (r15 < r2) goto L_0x0117
            int r15 = androidx.appcompat.R.styleable.o6
            boolean r20 = r0.C(r15)
            if (r20 == 0) goto L_0x0117
            java.lang.String r15 = r0.w(r15)
            goto L_0x0118
        L_0x0117:
            r15 = 0
        L_0x0118:
            r0.I()
            goto L_0x0123
        L_0x011c:
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r13 = 0
            r14 = 0
            r15 = 0
        L_0x0123:
            int[] r0 = androidx.appcompat.R.styleable.a6
            androidx.appcompat.widget.TintTypedArray r0 = androidx.appcompat.widget.TintTypedArray.G(r10, r8, r0, r9, r12)
            if (r1 != 0) goto L_0x013a
            int r2 = androidx.appcompat.R.styleable.p6
            boolean r21 = r0.C(r2)
            if (r21 == 0) goto L_0x013a
            boolean r5 = r0.a(r2, r12)
            r16 = 1
            goto L_0x013c
        L_0x013a:
            r16 = r6
        L_0x013c:
            int r2 = android.os.Build.VERSION.SDK_INT
            r6 = 23
            if (r2 >= r6) goto L_0x0166
            int r6 = androidx.appcompat.R.styleable.e6
            boolean r19 = r0.C(r6)
            if (r19 == 0) goto L_0x014e
            android.content.res.ColorStateList r4 = r0.d(r6)
        L_0x014e:
            int r6 = androidx.appcompat.R.styleable.f6
            boolean r19 = r0.C(r6)
            if (r19 == 0) goto L_0x015a
            android.content.res.ColorStateList r13 = r0.d(r6)
        L_0x015a:
            int r6 = androidx.appcompat.R.styleable.g6
            boolean r19 = r0.C(r6)
            if (r19 == 0) goto L_0x0166
            android.content.res.ColorStateList r14 = r0.d(r6)
        L_0x0166:
            int r6 = androidx.appcompat.R.styleable.q6
            boolean r19 = r0.C(r6)
            if (r19 == 0) goto L_0x0172
            java.lang.String r3 = r0.w(r6)
        L_0x0172:
            r6 = 26
            if (r2 < r6) goto L_0x0182
            int r6 = androidx.appcompat.R.styleable.o6
            boolean r19 = r0.C(r6)
            if (r19 == 0) goto L_0x0182
            java.lang.String r15 = r0.w(r6)
        L_0x0182:
            r6 = 28
            if (r2 < r6) goto L_0x019f
            int r6 = androidx.appcompat.R.styleable.b6
            boolean r19 = r0.C(r6)
            if (r19 == 0) goto L_0x019f
            r12 = -1
            int r6 = r0.g(r6, r12)
            if (r6 != 0) goto L_0x019f
            android.widget.TextView r6 = r7.f3140a
            r12 = 0
            r20 = r11
            r11 = 0
            r6.setTextSize(r11, r12)
            goto L_0x01a1
        L_0x019f:
            r20 = r11
        L_0x01a1:
            r7.C(r10, r0)
            r0.I()
            if (r4 == 0) goto L_0x01ae
            android.widget.TextView r0 = r7.f3140a
            r0.setTextColor(r4)
        L_0x01ae:
            if (r13 == 0) goto L_0x01b5
            android.widget.TextView r0 = r7.f3140a
            r0.setHintTextColor(r13)
        L_0x01b5:
            if (r14 == 0) goto L_0x01bc
            android.widget.TextView r0 = r7.f3140a
            r0.setLinkTextColor(r14)
        L_0x01bc:
            if (r1 != 0) goto L_0x01c3
            if (r16 == 0) goto L_0x01c3
            r7.s(r5)
        L_0x01c3:
            android.graphics.Typeface r0 = r7.f3151l
            if (r0 == 0) goto L_0x01d9
            int r1 = r7.f3150k
            r4 = -1
            if (r1 != r4) goto L_0x01d4
            android.widget.TextView r1 = r7.f3140a
            int r4 = r7.f3149j
            r1.setTypeface(r0, r4)
            goto L_0x01d9
        L_0x01d4:
            android.widget.TextView r1 = r7.f3140a
            r1.setTypeface(r0)
        L_0x01d9:
            if (r15 == 0) goto L_0x01e0
            android.widget.TextView r0 = r7.f3140a
            androidx.appcompat.widget.AppCompatTextHelper.Api26Impl.d(r0, r15)
        L_0x01e0:
            if (r3 == 0) goto L_0x0202
            r0 = 24
            if (r2 < r0) goto L_0x01f0
            android.widget.TextView r0 = r7.f3140a
            android.os.LocaleList r1 = androidx.appcompat.widget.AppCompatTextHelper.Api24Impl.a(r3)
            androidx.appcompat.widget.AppCompatTextHelper.Api24Impl.b(r0, r1)
            goto L_0x0202
        L_0x01f0:
            java.lang.String r0 = ","
            java.lang.String[] r0 = r3.split(r0)
            r1 = 0
            r0 = r0[r1]
            android.widget.TextView r1 = r7.f3140a
            java.util.Locale r0 = androidx.appcompat.widget.AppCompatTextHelper.Api21Impl.a(r0)
            r1.setTextLocale(r0)
        L_0x0202:
            androidx.appcompat.widget.AppCompatTextViewAutoSizeHelper r0 = r7.f3148i
            r0.o(r8, r9)
            boolean r0 = androidx.appcompat.widget.ViewUtils.f3370d
            r9 = -1082130432(0xffffffffbf800000, float:-1.0)
            if (r0 == 0) goto L_0x0248
            androidx.appcompat.widget.AppCompatTextViewAutoSizeHelper r0 = r7.f3148i
            int r0 = r0.j()
            if (r0 == 0) goto L_0x0248
            androidx.appcompat.widget.AppCompatTextViewAutoSizeHelper r0 = r7.f3148i
            int[] r0 = r0.i()
            int r1 = r0.length
            if (r1 <= 0) goto L_0x0248
            android.widget.TextView r1 = r7.f3140a
            int r1 = androidx.appcompat.widget.AppCompatTextHelper.Api26Impl.a(r1)
            float r1 = (float) r1
            int r1 = (r1 > r9 ? 1 : (r1 == r9 ? 0 : -1))
            if (r1 == 0) goto L_0x0242
            android.widget.TextView r0 = r7.f3140a
            androidx.appcompat.widget.AppCompatTextViewAutoSizeHelper r1 = r7.f3148i
            int r1 = r1.g()
            androidx.appcompat.widget.AppCompatTextViewAutoSizeHelper r2 = r7.f3148i
            int r2 = r2.f()
            androidx.appcompat.widget.AppCompatTextViewAutoSizeHelper r3 = r7.f3148i
            int r3 = r3.h()
            r4 = 0
            androidx.appcompat.widget.AppCompatTextHelper.Api26Impl.b(r0, r1, r2, r3, r4)
            goto L_0x0248
        L_0x0242:
            r4 = 0
            android.widget.TextView r1 = r7.f3140a
            androidx.appcompat.widget.AppCompatTextHelper.Api26Impl.c(r1, r0, r4)
        L_0x0248:
            int[] r0 = androidx.appcompat.R.styleable.v0
            androidx.appcompat.widget.TintTypedArray r8 = androidx.appcompat.widget.TintTypedArray.F(r10, r8, r0)
            int r0 = androidx.appcompat.R.styleable.E0
            r1 = -1
            int r0 = r8.u(r0, r1)
            r2 = r20
            if (r0 == r1) goto L_0x025f
            android.graphics.drawable.Drawable r0 = r2.c(r10, r0)
            r3 = r0
            goto L_0x0260
        L_0x025f:
            r3 = 0
        L_0x0260:
            int r0 = androidx.appcompat.R.styleable.J0
            int r0 = r8.u(r0, r1)
            if (r0 == r1) goto L_0x026e
            android.graphics.drawable.Drawable r0 = r2.c(r10, r0)
            r4 = r0
            goto L_0x026f
        L_0x026e:
            r4 = 0
        L_0x026f:
            int r0 = androidx.appcompat.R.styleable.F0
            int r0 = r8.u(r0, r1)
            if (r0 == r1) goto L_0x027d
            android.graphics.drawable.Drawable r0 = r2.c(r10, r0)
            r5 = r0
            goto L_0x027e
        L_0x027d:
            r5 = 0
        L_0x027e:
            int r0 = androidx.appcompat.R.styleable.C0
            int r0 = r8.u(r0, r1)
            if (r0 == r1) goto L_0x028c
            android.graphics.drawable.Drawable r0 = r2.c(r10, r0)
            r6 = r0
            goto L_0x028d
        L_0x028c:
            r6 = 0
        L_0x028d:
            int r0 = androidx.appcompat.R.styleable.G0
            int r0 = r8.u(r0, r1)
            if (r0 == r1) goto L_0x029b
            android.graphics.drawable.Drawable r0 = r2.c(r10, r0)
            r11 = r0
            goto L_0x029c
        L_0x029b:
            r11 = 0
        L_0x029c:
            int r0 = androidx.appcompat.R.styleable.D0
            int r0 = r8.u(r0, r1)
            if (r0 == r1) goto L_0x02aa
            android.graphics.drawable.Drawable r0 = r2.c(r10, r0)
            r10 = r0
            goto L_0x02ab
        L_0x02aa:
            r10 = 0
        L_0x02ab:
            r0 = r22
            r1 = r3
            r2 = r4
            r3 = r5
            r4 = r6
            r5 = r11
            r6 = r10
            r0.y(r1, r2, r3, r4, r5, r6)
            int r0 = androidx.appcompat.R.styleable.H0
            boolean r1 = r8.C(r0)
            if (r1 == 0) goto L_0x02c7
            android.content.res.ColorStateList r0 = r8.d(r0)
            android.widget.TextView r1 = r7.f3140a
            androidx.core.widget.TextViewCompat.s(r1, r0)
        L_0x02c7:
            int r0 = androidx.appcompat.R.styleable.I0
            boolean r1 = r8.C(r0)
            if (r1 == 0) goto L_0x02df
            r1 = -1
            int r0 = r8.o(r0, r1)
            r2 = 0
            android.graphics.PorterDuff$Mode r0 = androidx.appcompat.widget.DrawableUtils.e(r0, r2)
            android.widget.TextView r2 = r7.f3140a
            androidx.core.widget.TextViewCompat.t(r2, r0)
            goto L_0x02e0
        L_0x02df:
            r1 = -1
        L_0x02e0:
            int r0 = androidx.appcompat.R.styleable.L0
            int r0 = r8.g(r0, r1)
            int r2 = androidx.appcompat.R.styleable.O0
            int r2 = r8.g(r2, r1)
            int r1 = androidx.appcompat.R.styleable.P0
            boolean r3 = r8.C(r1)
            if (r3 == 0) goto L_0x0316
            android.util.TypedValue r3 = r8.H(r1)
            if (r3 == 0) goto L_0x030e
            int r4 = r3.type
            r5 = 5
            if (r4 != r5) goto L_0x030e
            int r1 = r3.data
            int r12 = androidx.core.util.TypedValueCompat.c(r1)
            int r1 = r3.data
            float r1 = android.util.TypedValue.complexToFloat(r1)
            r3 = r12
            r12 = -1
            goto L_0x031a
        L_0x030e:
            r12 = -1
            int r1 = r8.g(r1, r12)
            float r1 = (float) r1
        L_0x0314:
            r3 = -1
            goto L_0x031a
        L_0x0316:
            r12 = -1
            r1 = -1082130432(0xffffffffbf800000, float:-1.0)
            goto L_0x0314
        L_0x031a:
            r8.I()
            if (r0 == r12) goto L_0x0324
            android.widget.TextView r4 = r7.f3140a
            androidx.core.widget.TextViewCompat.y(r4, r0)
        L_0x0324:
            if (r2 == r12) goto L_0x032b
            android.widget.TextView r0 = r7.f3140a
            androidx.core.widget.TextViewCompat.z(r0, r2)
        L_0x032b:
            int r0 = (r1 > r9 ? 1 : (r1 == r9 ? 0 : -1))
            if (r0 == 0) goto L_0x033b
            android.widget.TextView r0 = r7.f3140a
            if (r3 != r12) goto L_0x0338
            int r1 = (int) r1
            androidx.core.widget.TextViewCompat.A(r0, r1)
            goto L_0x033b
        L_0x0338:
            androidx.core.widget.TextViewCompat.B(r0, r3, r1)
        L_0x033b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.AppCompatTextHelper.m(android.util.AttributeSet, int):void");
    }

    /* access modifiers changed from: package-private */
    public void n(WeakReference<TextView> weakReference, final Typeface typeface) {
        if (this.f3152m) {
            this.f3151l = typeface;
            final TextView textView = weakReference.get();
            if (textView == null) {
                return;
            }
            if (textView.isAttachedToWindow()) {
                final int i2 = this.f3149j;
                textView.post(new Runnable() {
                    public void run() {
                        textView.setTypeface(typeface, i2);
                    }
                });
                return;
            }
            textView.setTypeface(typeface, this.f3149j);
        }
    }

    /* access modifiers changed from: package-private */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void o(boolean z, int i2, int i3, int i4, int i5) {
        if (!ViewUtils.f3370d) {
            c();
        }
    }

    /* access modifiers changed from: package-private */
    public void p() {
        b();
    }

    /* access modifiers changed from: package-private */
    public void q(Context context, int i2) {
        String w;
        ColorStateList d2;
        ColorStateList d3;
        ColorStateList d4;
        TintTypedArray E = TintTypedArray.E(context, i2, R.styleable.a6);
        int i3 = R.styleable.p6;
        if (E.C(i3)) {
            s(E.a(i3, false));
        }
        int i4 = Build.VERSION.SDK_INT;
        if (i4 < 23) {
            int i5 = R.styleable.e6;
            if (E.C(i5) && (d4 = E.d(i5)) != null) {
                this.f3140a.setTextColor(d4);
            }
            int i6 = R.styleable.g6;
            if (E.C(i6) && (d3 = E.d(i6)) != null) {
                this.f3140a.setLinkTextColor(d3);
            }
            int i7 = R.styleable.f6;
            if (E.C(i7) && (d2 = E.d(i7)) != null) {
                this.f3140a.setHintTextColor(d2);
            }
        }
        int i8 = R.styleable.b6;
        if (E.C(i8) && E.g(i8, -1) == 0) {
            this.f3140a.setTextSize(0, 0.0f);
        }
        C(context, E);
        if (i4 >= 26) {
            int i9 = R.styleable.o6;
            if (E.C(i9) && (w = E.w(i9)) != null) {
                Api26Impl.d(this.f3140a, w);
            }
        }
        E.I();
        Typeface typeface = this.f3151l;
        if (typeface != null) {
            this.f3140a.setTypeface(typeface, this.f3149j);
        }
    }

    /* access modifiers changed from: package-private */
    public void r(@NonNull TextView textView, @Nullable InputConnection inputConnection, @NonNull EditorInfo editorInfo) {
        if (Build.VERSION.SDK_INT < 30 && inputConnection != null) {
            EditorInfoCompat.k(editorInfo, textView.getText());
        }
    }

    /* access modifiers changed from: package-private */
    public void s(boolean z) {
        this.f3140a.setAllCaps(z);
    }

    /* access modifiers changed from: package-private */
    public void t(int i2, int i3, int i4, int i5) throws IllegalArgumentException {
        this.f3148i.p(i2, i3, i4, i5);
    }

    /* access modifiers changed from: package-private */
    public void u(@NonNull int[] iArr, int i2) throws IllegalArgumentException {
        this.f3148i.q(iArr, i2);
    }

    /* access modifiers changed from: package-private */
    public void v(int i2) {
        this.f3148i.r(i2);
    }

    /* access modifiers changed from: package-private */
    public void w(@Nullable ColorStateList colorStateList) {
        if (this.f3147h == null) {
            this.f3147h = new TintInfo();
        }
        TintInfo tintInfo = this.f3147h;
        tintInfo.f3312a = colorStateList;
        tintInfo.f3315d = colorStateList != null;
        z();
    }

    /* access modifiers changed from: package-private */
    public void x(@Nullable PorterDuff.Mode mode) {
        if (this.f3147h == null) {
            this.f3147h = new TintInfo();
        }
        TintInfo tintInfo = this.f3147h;
        tintInfo.f3313b = mode;
        tintInfo.f3314c = mode != null;
        z();
    }
}
