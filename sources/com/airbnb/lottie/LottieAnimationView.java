package com.airbnb.lottie;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.AttrRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.view.ViewCompat;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.LottieFrameInfo;
import com.airbnb.lottie.value.LottieValueCallback;
import com.airbnb.lottie.value.SimpleLottieValueCallback;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottieAnimationView extends AppCompatImageView {
    private static final String r3 = "LottieAnimationView";
    /* access modifiers changed from: private */
    public static final LottieListener<Throwable> s3 = new LottieListener<Throwable>() {
        /* renamed from: a */
        public void onResult(Throwable th) {
            if (Utils.k(th)) {
                Logger.f("Unable to load composition.", th);
                return;
            }
            throw new IllegalStateException("Unable to parse composition", th);
        }
    };
    private final LottieListener<LottieComposition> Z2 = new LottieListener<LottieComposition>() {
        /* renamed from: a */
        public void onResult(LottieComposition lottieComposition) {
            LottieAnimationView.this.setComposition(lottieComposition);
        }
    };
    private final LottieListener<Throwable> a3 = new LottieListener<Throwable>() {
        /* renamed from: a */
        public void onResult(Throwable th) {
            if (LottieAnimationView.this.c3 != 0) {
                LottieAnimationView lottieAnimationView = LottieAnimationView.this;
                lottieAnimationView.setImageResource(lottieAnimationView.c3);
            }
            (LottieAnimationView.this.b3 == null ? LottieAnimationView.s3 : LottieAnimationView.this.b3).onResult(th);
        }
    };
    /* access modifiers changed from: private */
    @Nullable
    public LottieListener<Throwable> b3;
    /* access modifiers changed from: private */
    @DrawableRes
    public int c3 = 0;
    private final LottieDrawable d3 = new LottieDrawable();
    private boolean e3;
    private String f3;
    @RawRes
    private int g3;
    private boolean h3 = false;
    private boolean i3 = false;
    private boolean j3 = false;
    private boolean k3 = false;
    private boolean l3 = true;
    private RenderMode m3 = RenderMode.AUTOMATIC;
    private Set<LottieOnCompositionLoadedListener> n3 = new HashSet();
    private int o3 = 0;
    @Nullable
    private LottieTask<LottieComposition> p3;
    @Nullable
    private LottieComposition q3;

    /* renamed from: com.airbnb.lottie.LottieAnimationView$5  reason: invalid class name */
    static /* synthetic */ class AnonymousClass5 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f16682a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.airbnb.lottie.RenderMode[] r0 = com.airbnb.lottie.RenderMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f16682a = r0
                com.airbnb.lottie.RenderMode r1 = com.airbnb.lottie.RenderMode.HARDWARE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f16682a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.airbnb.lottie.RenderMode r1 = com.airbnb.lottie.RenderMode.SOFTWARE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f16682a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.airbnb.lottie.RenderMode r1 = com.airbnb.lottie.RenderMode.AUTOMATIC     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.LottieAnimationView.AnonymousClass5.<clinit>():void");
        }
    }

    public LottieAnimationView(Context context) {
        super(context);
        s((AttributeSet) null, R.attr.i2);
    }

    private void l() {
        LottieTask<LottieComposition> lottieTask = this.p3;
        if (lottieTask != null) {
            lottieTask.k(this.Z2);
            this.p3.j(this.a3);
        }
    }

    private void m() {
        this.q3 = null;
        this.d3.l();
    }

    private void p() {
        LottieComposition lottieComposition;
        LottieComposition lottieComposition2;
        int i2 = AnonymousClass5.f16682a[this.m3.ordinal()];
        int i4 = 2;
        if (i2 != 1 && (i2 == 2 || i2 != 3 || (((lottieComposition = this.q3) != null && lottieComposition.r() && Build.VERSION.SDK_INT < 28) || ((lottieComposition2 = this.q3) != null && lottieComposition2.m() > 4)))) {
            i4 = 1;
        }
        if (i4 != getLayerType()) {
            setLayerType(i4, (Paint) null);
        }
    }

    private void s(@Nullable AttributeSet attributeSet, @AttrRes int i2) {
        String string;
        boolean z = false;
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.m5, i2, 0);
        if (!isInEditMode()) {
            this.l3 = obtainStyledAttributes.getBoolean(R.styleable.o5, true);
            int i4 = R.styleable.w5;
            boolean hasValue = obtainStyledAttributes.hasValue(i4);
            int i5 = R.styleable.s5;
            boolean hasValue2 = obtainStyledAttributes.hasValue(i5);
            int i6 = R.styleable.C5;
            boolean hasValue3 = obtainStyledAttributes.hasValue(i6);
            if (!hasValue || !hasValue2) {
                if (hasValue) {
                    int resourceId = obtainStyledAttributes.getResourceId(i4, 0);
                    if (resourceId != 0) {
                        setAnimation(resourceId);
                    }
                } else if (hasValue2) {
                    String string2 = obtainStyledAttributes.getString(i5);
                    if (string2 != null) {
                        setAnimation(string2);
                    }
                } else if (hasValue3 && (string = obtainStyledAttributes.getString(i6)) != null) {
                    setAnimationFromUrl(string);
                }
                setFallbackResource(obtainStyledAttributes.getResourceId(R.styleable.r5, 0));
            } else {
                throw new IllegalArgumentException("lottie_rawRes and lottie_fileName cannot be used at the same time. Please use only one at once.");
            }
        }
        if (obtainStyledAttributes.getBoolean(R.styleable.n5, false)) {
            this.j3 = true;
            this.k3 = true;
        }
        if (obtainStyledAttributes.getBoolean(R.styleable.u5, false)) {
            this.d3.t0(-1);
        }
        int i7 = R.styleable.z5;
        if (obtainStyledAttributes.hasValue(i7)) {
            setRepeatMode(obtainStyledAttributes.getInt(i7, 1));
        }
        int i8 = R.styleable.y5;
        if (obtainStyledAttributes.hasValue(i8)) {
            setRepeatCount(obtainStyledAttributes.getInt(i8, -1));
        }
        int i9 = R.styleable.B5;
        if (obtainStyledAttributes.hasValue(i9)) {
            setSpeed(obtainStyledAttributes.getFloat(i9, 1.0f));
        }
        setImageAssetsFolder(obtainStyledAttributes.getString(R.styleable.t5));
        setProgress(obtainStyledAttributes.getFloat(R.styleable.v5, 0.0f));
        o(obtainStyledAttributes.getBoolean(R.styleable.q5, false));
        int i10 = R.styleable.p5;
        if (obtainStyledAttributes.hasValue(i10)) {
            SimpleColorFilter simpleColorFilter = new SimpleColorFilter(obtainStyledAttributes.getColor(i10, 0));
            i(new KeyPath("**"), LottieProperty.C, new LottieValueCallback(simpleColorFilter));
        }
        int i11 = R.styleable.A5;
        if (obtainStyledAttributes.hasValue(i11)) {
            this.d3.w0(obtainStyledAttributes.getFloat(i11, 1.0f));
        }
        int i12 = R.styleable.x5;
        if (obtainStyledAttributes.hasValue(i12)) {
            RenderMode renderMode = RenderMode.AUTOMATIC;
            int i13 = obtainStyledAttributes.getInt(i12, renderMode.ordinal());
            if (i13 >= RenderMode.values().length) {
                i13 = renderMode.ordinal();
            }
            setRenderMode(RenderMode.values()[i13]);
        }
        if (getScaleType() != null) {
            this.d3.x0(getScaleType());
        }
        obtainStyledAttributes.recycle();
        LottieDrawable lottieDrawable = this.d3;
        if (Utils.f(getContext()) != 0.0f) {
            z = true;
        }
        lottieDrawable.z0(Boolean.valueOf(z));
        p();
        this.e3 = true;
    }

    private void setCompositionTask(LottieTask<LottieComposition> lottieTask) {
        m();
        l();
        this.p3 = lottieTask.f(this.Z2).e(this.a3);
    }

    public void A() {
        this.d3.V();
    }

    public void B(Animator.AnimatorListener animatorListener) {
        this.d3.W(animatorListener);
    }

    public boolean C(@NonNull LottieOnCompositionLoadedListener lottieOnCompositionLoadedListener) {
        return this.n3.remove(lottieOnCompositionLoadedListener);
    }

    public void D(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.d3.X(animatorUpdateListener);
    }

    public List<KeyPath> E(KeyPath keyPath) {
        return this.d3.Y(keyPath);
    }

    @MainThread
    public void F() {
        if (isShown()) {
            this.d3.Z();
            p();
            return;
        }
        this.h3 = false;
        this.i3 = true;
    }

    public void G() {
        this.d3.a0();
    }

    public void H(InputStream inputStream, @Nullable String str) {
        setCompositionTask(LottieCompositionFactory.j(inputStream, str));
    }

    public void I(String str, @Nullable String str2) {
        H(new ByteArrayInputStream(str.getBytes()), str2);
    }

    public void J(String str, @Nullable String str2) {
        setCompositionTask(LottieCompositionFactory.x(getContext(), str, str2));
    }

    public void K(int i2, int i4) {
        this.d3.k0(i2, i4);
    }

    public void L(String str, String str2, boolean z) {
        this.d3.m0(str, str2, z);
    }

    public void M(@FloatRange(from = 0.0d, to = 1.0d) float f2, @FloatRange(from = 0.0d, to = 1.0d) float f4) {
        this.d3.n0(f2, f4);
    }

    @Nullable
    public Bitmap N(String str, @Nullable Bitmap bitmap) {
        return this.d3.B0(str, bitmap);
    }

    public void buildDrawingCache(boolean z) {
        L.a("buildDrawingCache");
        this.o3++;
        super.buildDrawingCache(z);
        if (this.o3 == 1 && getWidth() > 0 && getHeight() > 0 && getLayerType() == 1 && getDrawingCache(z) == null) {
            setRenderMode(RenderMode.HARDWARE);
        }
        this.o3--;
        L.b("buildDrawingCache");
    }

    public void f(Animator.AnimatorListener animatorListener) {
        this.d3.f(animatorListener);
    }

    public void g(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.d3.g(animatorUpdateListener);
    }

    @Nullable
    public LottieComposition getComposition() {
        return this.q3;
    }

    public long getDuration() {
        LottieComposition lottieComposition = this.q3;
        if (lottieComposition != null) {
            return (long) lottieComposition.d();
        }
        return 0;
    }

    public int getFrame() {
        return this.d3.w();
    }

    @Nullable
    public String getImageAssetsFolder() {
        return this.d3.z();
    }

    public float getMaxFrame() {
        return this.d3.A();
    }

    public float getMinFrame() {
        return this.d3.C();
    }

    @Nullable
    public PerformanceTracker getPerformanceTracker() {
        return this.d3.D();
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float getProgress() {
        return this.d3.E();
    }

    public int getRepeatCount() {
        return this.d3.F();
    }

    public int getRepeatMode() {
        return this.d3.G();
    }

    public float getScale() {
        return this.d3.H();
    }

    public float getSpeed() {
        return this.d3.I();
    }

    public boolean h(@NonNull LottieOnCompositionLoadedListener lottieOnCompositionLoadedListener) {
        LottieComposition lottieComposition = this.q3;
        if (lottieComposition != null) {
            lottieOnCompositionLoadedListener.a(lottieComposition);
        }
        return this.n3.add(lottieOnCompositionLoadedListener);
    }

    public <T> void i(KeyPath keyPath, T t, LottieValueCallback<T> lottieValueCallback) {
        this.d3.h(keyPath, t, lottieValueCallback);
    }

    public void invalidateDrawable(@NonNull Drawable drawable) {
        Drawable drawable2 = getDrawable();
        LottieDrawable lottieDrawable = this.d3;
        if (drawable2 == lottieDrawable) {
            super.invalidateDrawable(lottieDrawable);
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    public <T> void j(KeyPath keyPath, T t, final SimpleLottieValueCallback<T> simpleLottieValueCallback) {
        this.d3.h(keyPath, t, new LottieValueCallback<T>() {
            public T a(LottieFrameInfo<T> lottieFrameInfo) {
                return simpleLottieValueCallback.a(lottieFrameInfo);
            }
        });
    }

    @MainThread
    public void k() {
        this.j3 = false;
        this.i3 = false;
        this.h3 = false;
        this.d3.k();
        p();
    }

    public void n() {
        this.d3.m();
    }

    public void o(boolean z) {
        this.d3.q(z);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.k3 || this.j3) {
            x();
            this.k3 = false;
            this.j3 = false;
        }
        if (Build.VERSION.SDK_INT < 23) {
            onVisibilityChanged(this, getVisibility());
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        if (t()) {
            k();
            this.j3 = true;
        }
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        String str = savedState.s;
        this.f3 = str;
        if (!TextUtils.isEmpty(str)) {
            setAnimation(this.f3);
        }
        int i2 = savedState.X;
        this.g3 = i2;
        if (i2 != 0) {
            setAnimation(i2);
        }
        setProgress(savedState.Y);
        if (savedState.Z) {
            x();
        }
        this.d3.g0(savedState.X2);
        setRepeatMode(savedState.Y2);
        setRepeatCount(savedState.Z2);
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.s = this.f3;
        savedState.X = this.g3;
        savedState.Y = this.d3.E();
        savedState.Z = this.d3.N() || (!ViewCompat.R0(this) && this.j3);
        savedState.X2 = this.d3.z();
        savedState.Y2 = this.d3.G();
        savedState.Z2 = this.d3.F();
        return savedState;
    }

    /* access modifiers changed from: protected */
    public void onVisibilityChanged(@NonNull View view, int i2) {
        if (this.e3) {
            if (isShown()) {
                if (this.i3) {
                    F();
                } else if (this.h3) {
                    x();
                }
                this.i3 = false;
                this.h3 = false;
            } else if (t()) {
                w();
                this.i3 = true;
            }
        }
    }

    public boolean q() {
        return this.d3.L();
    }

    public boolean r() {
        return this.d3.M();
    }

    public void setAnimation(@RawRes int i2) {
        this.g3 = i2;
        this.f3 = null;
        setCompositionTask(this.l3 ? LottieCompositionFactory.s(getContext(), i2) : LottieCompositionFactory.t(getContext(), i2, (String) null));
    }

    @Deprecated
    public void setAnimationFromJson(String str) {
        I(str, (String) null);
    }

    public void setAnimationFromUrl(String str) {
        setCompositionTask(this.l3 ? LottieCompositionFactory.w(getContext(), str) : LottieCompositionFactory.x(getContext(), str, (String) null));
    }

    public void setApplyingOpacityToLayersEnabled(boolean z) {
        this.d3.b0(z);
    }

    public void setCacheComposition(boolean z) {
        this.l3 = z;
    }

    public void setComposition(@NonNull LottieComposition lottieComposition) {
        if (L.f16670a) {
            String str = r3;
            Log.v(str, "Set Composition \n" + lottieComposition);
        }
        this.d3.setCallback(this);
        this.q3 = lottieComposition;
        boolean c0 = this.d3.c0(lottieComposition);
        p();
        if (getDrawable() != this.d3 || c0) {
            onVisibilityChanged(this, getVisibility());
            requestLayout();
            for (LottieOnCompositionLoadedListener a2 : this.n3) {
                a2.a(lottieComposition);
            }
        }
    }

    public void setFailureListener(@Nullable LottieListener<Throwable> lottieListener) {
        this.b3 = lottieListener;
    }

    public void setFallbackResource(@DrawableRes int i2) {
        this.c3 = i2;
    }

    public void setFontAssetDelegate(FontAssetDelegate fontAssetDelegate) {
        this.d3.d0(fontAssetDelegate);
    }

    public void setFrame(int i2) {
        this.d3.e0(i2);
    }

    public void setImageAssetDelegate(ImageAssetDelegate imageAssetDelegate) {
        this.d3.f0(imageAssetDelegate);
    }

    public void setImageAssetsFolder(String str) {
        this.d3.g0(str);
    }

    public void setImageBitmap(Bitmap bitmap) {
        l();
        super.setImageBitmap(bitmap);
    }

    public void setImageDrawable(Drawable drawable) {
        l();
        super.setImageDrawable(drawable);
    }

    public void setImageResource(int i2) {
        l();
        super.setImageResource(i2);
    }

    public void setMaxFrame(int i2) {
        this.d3.h0(i2);
    }

    public void setMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        this.d3.j0(f2);
    }

    public void setMinAndMaxFrame(String str) {
        this.d3.l0(str);
    }

    public void setMinFrame(int i2) {
        this.d3.o0(i2);
    }

    public void setMinProgress(float f2) {
        this.d3.q0(f2);
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        this.d3.r0(z);
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        this.d3.s0(f2);
    }

    public void setRenderMode(RenderMode renderMode) {
        this.m3 = renderMode;
        p();
    }

    public void setRepeatCount(int i2) {
        this.d3.t0(i2);
    }

    public void setRepeatMode(int i2) {
        this.d3.u0(i2);
    }

    public void setSafeMode(boolean z) {
        this.d3.v0(z);
    }

    public void setScale(float f2) {
        this.d3.w0(f2);
        if (getDrawable() == this.d3) {
            setImageDrawable((Drawable) null);
            setImageDrawable(this.d3);
        }
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        super.setScaleType(scaleType);
        LottieDrawable lottieDrawable = this.d3;
        if (lottieDrawable != null) {
            lottieDrawable.x0(scaleType);
        }
    }

    public void setSpeed(float f2) {
        this.d3.y0(f2);
    }

    public void setTextDelegate(TextDelegate textDelegate) {
        this.d3.A0(textDelegate);
    }

    public boolean t() {
        return this.d3.N();
    }

    public boolean u() {
        return this.d3.Q();
    }

    @Deprecated
    public void v(boolean z) {
        this.d3.t0(z ? -1 : 0);
    }

    @MainThread
    public void w() {
        this.k3 = false;
        this.j3 = false;
        this.i3 = false;
        this.h3 = false;
        this.d3.S();
        p();
    }

    @MainThread
    public void x() {
        if (isShown()) {
            this.d3.T();
            p();
            return;
        }
        this.h3 = true;
    }

    public void y() {
        this.d3.U();
    }

    public void z() {
        this.n3.clear();
    }

    private static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* renamed from: b */
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }
        };
        int X;
        String X2;
        float Y;
        int Y2;
        boolean Z;
        int Z2;
        String s;

        private SavedState(Parcel parcel) {
            super(parcel);
            this.s = parcel.readString();
            this.Y = parcel.readFloat();
            this.Z = parcel.readInt() != 1 ? false : true;
            this.X2 = parcel.readString();
            this.Y2 = parcel.readInt();
            this.Z2 = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeString(this.s);
            parcel.writeFloat(this.Y);
            parcel.writeInt(this.Z ? 1 : 0);
            parcel.writeString(this.X2);
            parcel.writeInt(this.Y2);
            parcel.writeInt(this.Z2);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        s(attributeSet, R.attr.i2);
    }

    public void setAnimation(String str) {
        this.f3 = str;
        this.g3 = 0;
        setCompositionTask(this.l3 ? LottieCompositionFactory.e(getContext(), str) : LottieCompositionFactory.f(getContext(), str, (String) null));
    }

    public void setMaxFrame(String str) {
        this.d3.i0(str);
    }

    public void setMinFrame(String str) {
        this.d3.p0(str);
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        s(attributeSet, i2);
    }
}
