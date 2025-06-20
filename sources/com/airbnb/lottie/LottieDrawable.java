package com.airbnb.lottie;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.airbnb.lottie.manager.FontAssetManager;
import com.airbnb.lottie.manager.ImageAssetManager;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.Marker;
import com.airbnb.lottie.model.layer.CompositionLayer;
import com.airbnb.lottie.parser.LayerParser;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.LottieValueAnimator;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieFrameInfo;
import com.airbnb.lottie.value.LottieValueCallback;
import com.airbnb.lottie.value.SimpleLottieValueCallback;
import com.itextpdf.text.pdf.codec.wmf.MetaDo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class LottieDrawable extends Drawable implements Drawable.Callback, Animatable {
    private static final String q3 = "LottieDrawable";
    public static final int r3 = 1;
    public static final int s3 = 2;
    public static final int t3 = -1;
    private LottieComposition X;
    private boolean X2;
    /* access modifiers changed from: private */
    public final LottieValueAnimator Y;
    private boolean Y2;
    private float Z;
    private final Set<ColorFilterData> Z2;
    private final ArrayList<LazyCompositionTask> a3;
    private final ValueAnimator.AnimatorUpdateListener b3;
    @Nullable
    private ImageView.ScaleType c3;
    @Nullable
    private ImageAssetManager d3;
    @Nullable
    private String e3;
    @Nullable
    private ImageAssetDelegate f3;
    @Nullable
    private FontAssetManager g3;
    @Nullable
    FontAssetDelegate h3;
    @Nullable
    TextDelegate i3;
    private boolean j3;
    /* access modifiers changed from: private */
    @Nullable
    public CompositionLayer k3;
    private int l3;
    private boolean m3;
    private boolean n3;
    private boolean o3;
    private boolean p3;
    private final Matrix s = new Matrix();

    private static class ColorFilterData {

        /* renamed from: a  reason: collision with root package name */
        final String f16738a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        final String f16739b;
        @Nullable

        /* renamed from: c  reason: collision with root package name */
        final ColorFilter f16740c;

        ColorFilterData(@Nullable String str, @Nullable String str2, @Nullable ColorFilter colorFilter) {
            this.f16738a = str;
            this.f16739b = str2;
            this.f16740c = colorFilter;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ColorFilterData)) {
                return false;
            }
            ColorFilterData colorFilterData = (ColorFilterData) obj;
            return hashCode() == colorFilterData.hashCode() && this.f16740c == colorFilterData.f16740c;
        }

        public int hashCode() {
            String str = this.f16738a;
            int hashCode = str != null ? MetaDo.w * str.hashCode() : 17;
            String str2 = this.f16739b;
            return str2 != null ? hashCode * 31 * str2.hashCode() : hashCode;
        }
    }

    private interface LazyCompositionTask {
        void a(LottieComposition lottieComposition);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface RepeatMode {
    }

    public LottieDrawable() {
        LottieValueAnimator lottieValueAnimator = new LottieValueAnimator();
        this.Y = lottieValueAnimator;
        this.Z = 1.0f;
        this.X2 = true;
        this.Y2 = false;
        this.Z2 = new HashSet();
        this.a3 = new ArrayList<>();
        AnonymousClass1 r32 = new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (LottieDrawable.this.k3 != null) {
                    LottieDrawable.this.k3.G(LottieDrawable.this.Y.h());
                }
            }
        };
        this.b3 = r32;
        this.l3 = 255;
        this.o3 = true;
        this.p3 = false;
        lottieValueAnimator.addUpdateListener(r32);
    }

    private float B(@NonNull Canvas canvas) {
        return Math.min(((float) canvas.getWidth()) / ((float) this.X.b().width()), ((float) canvas.getHeight()) / ((float) this.X.b().height()));
    }

    private void C0() {
        if (this.X != null) {
            float H = H();
            setBounds(0, 0, (int) (((float) this.X.b().width()) * H), (int) (((float) this.X.b().height()) * H));
        }
    }

    private void j() {
        this.k3 = new CompositionLayer(this, LayerParser.a(this.X), this.X.j(), this.X);
    }

    private void n(@NonNull Canvas canvas) {
        if (ImageView.ScaleType.FIT_XY == this.c3) {
            o(canvas);
        } else {
            p(canvas);
        }
    }

    private void o(Canvas canvas) {
        float f2;
        if (this.k3 != null) {
            Rect bounds = getBounds();
            float width = ((float) bounds.width()) / ((float) this.X.b().width());
            float height = ((float) bounds.height()) / ((float) this.X.b().height());
            int i2 = -1;
            if (this.o3) {
                float min = Math.min(width, height);
                if (min < 1.0f) {
                    f2 = 1.0f / min;
                    width /= f2;
                    height /= f2;
                } else {
                    f2 = 1.0f;
                }
                if (f2 > 1.0f) {
                    i2 = canvas.save();
                    float width2 = ((float) bounds.width()) / 2.0f;
                    float height2 = ((float) bounds.height()) / 2.0f;
                    float f4 = width2 * min;
                    float f5 = min * height2;
                    canvas.translate(width2 - f4, height2 - f5);
                    canvas.scale(f2, f2, f4, f5);
                }
            }
            this.s.reset();
            this.s.preScale(width, height);
            this.k3.f(canvas, this.s, this.l3);
            if (i2 > 0) {
                canvas.restoreToCount(i2);
            }
        }
    }

    private void p(Canvas canvas) {
        float f2;
        int i2;
        if (this.k3 != null) {
            float f4 = this.Z;
            float B = B(canvas);
            if (f4 > B) {
                f2 = this.Z / B;
            } else {
                B = f4;
                f2 = 1.0f;
            }
            if (f2 > 1.0f) {
                i2 = canvas.save();
                float width = ((float) this.X.b().width()) / 2.0f;
                float height = ((float) this.X.b().height()) / 2.0f;
                float f5 = width * B;
                float f6 = height * B;
                canvas.translate((H() * width) - f5, (H() * height) - f6);
                canvas.scale(f2, f2, f5, f6);
            } else {
                i2 = -1;
            }
            this.s.reset();
            this.s.preScale(B, B);
            this.k3.f(canvas, this.s, this.l3);
            if (i2 > 0) {
                canvas.restoreToCount(i2);
            }
        }
    }

    @Nullable
    private Context u() {
        Drawable.Callback callback = getCallback();
        if (callback != null && (callback instanceof View)) {
            return ((View) callback).getContext();
        }
        return null;
    }

    private FontAssetManager v() {
        if (getCallback() == null) {
            return null;
        }
        if (this.g3 == null) {
            this.g3 = new FontAssetManager(getCallback(), this.h3);
        }
        return this.g3;
    }

    private ImageAssetManager y() {
        if (getCallback() == null) {
            return null;
        }
        ImageAssetManager imageAssetManager = this.d3;
        if (imageAssetManager != null && !imageAssetManager.b(u())) {
            this.d3 = null;
        }
        if (this.d3 == null) {
            this.d3 = new ImageAssetManager(getCallback(), this.e3, this.f3, this.X.i());
        }
        return this.d3;
    }

    public float A() {
        return this.Y.m();
    }

    public void A0(TextDelegate textDelegate) {
        this.i3 = textDelegate;
    }

    @Nullable
    public Bitmap B0(String str, @Nullable Bitmap bitmap) {
        ImageAssetManager y = y();
        if (y == null) {
            Logger.e("Cannot update bitmap. Most likely the drawable is not added to a View which prevents Lottie from getting a Context.");
            return null;
        }
        Bitmap e2 = y.e(str, bitmap);
        invalidateSelf();
        return e2;
    }

    public float C() {
        return this.Y.n();
    }

    @Nullable
    public PerformanceTracker D() {
        LottieComposition lottieComposition = this.X;
        if (lottieComposition != null) {
            return lottieComposition.n();
        }
        return null;
    }

    public boolean D0() {
        return this.i3 == null && this.X.c().z() > 0;
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float E() {
        return this.Y.h();
    }

    public int F() {
        return this.Y.getRepeatCount();
    }

    public int G() {
        return this.Y.getRepeatMode();
    }

    public float H() {
        return this.Z;
    }

    public float I() {
        return this.Y.o();
    }

    @Nullable
    public TextDelegate J() {
        return this.i3;
    }

    @Nullable
    public Typeface K(String str, String str2) {
        FontAssetManager v = v();
        if (v != null) {
            return v.b(str, str2);
        }
        return null;
    }

    public boolean L() {
        CompositionLayer compositionLayer = this.k3;
        return compositionLayer != null && compositionLayer.J();
    }

    public boolean M() {
        CompositionLayer compositionLayer = this.k3;
        return compositionLayer != null && compositionLayer.K();
    }

    public boolean N() {
        LottieValueAnimator lottieValueAnimator = this.Y;
        if (lottieValueAnimator == null) {
            return false;
        }
        return lottieValueAnimator.isRunning();
    }

    public boolean O() {
        return this.n3;
    }

    public boolean P() {
        return this.Y.getRepeatCount() == -1;
    }

    public boolean Q() {
        return this.j3;
    }

    @Deprecated
    public void R(boolean z) {
        this.Y.setRepeatCount(z ? -1 : 0);
    }

    public void S() {
        this.a3.clear();
        this.Y.q();
    }

    @MainThread
    public void T() {
        if (this.k3 == null) {
            this.a3.add(new LazyCompositionTask() {
                public void a(LottieComposition lottieComposition) {
                    LottieDrawable.this.T();
                }
            });
            return;
        }
        if (this.X2 || F() == 0) {
            this.Y.r();
        }
        if (!this.X2) {
            e0((int) (I() < 0.0f ? C() : A()));
            this.Y.g();
        }
    }

    public void U() {
        this.Y.removeAllListeners();
    }

    public void V() {
        this.Y.removeAllUpdateListeners();
        this.Y.addUpdateListener(this.b3);
    }

    public void W(Animator.AnimatorListener animatorListener) {
        this.Y.removeListener(animatorListener);
    }

    public void X(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.Y.removeUpdateListener(animatorUpdateListener);
    }

    public List<KeyPath> Y(KeyPath keyPath) {
        if (this.k3 == null) {
            Logger.e("Cannot resolve KeyPath. Composition is not set yet.");
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        this.k3.c(keyPath, 0, arrayList, new KeyPath(new String[0]));
        return arrayList;
    }

    @MainThread
    public void Z() {
        if (this.k3 == null) {
            this.a3.add(new LazyCompositionTask() {
                public void a(LottieComposition lottieComposition) {
                    LottieDrawable.this.Z();
                }
            });
            return;
        }
        if (this.X2 || F() == 0) {
            this.Y.v();
        }
        if (!this.X2) {
            e0((int) (I() < 0.0f ? C() : A()));
            this.Y.g();
        }
    }

    public void a0() {
        this.Y.w();
    }

    public void b0(boolean z) {
        this.n3 = z;
    }

    public boolean c0(LottieComposition lottieComposition) {
        if (this.X == lottieComposition) {
            return false;
        }
        this.p3 = false;
        l();
        this.X = lottieComposition;
        j();
        this.Y.x(lottieComposition);
        s0(this.Y.getAnimatedFraction());
        w0(this.Z);
        C0();
        Iterator it2 = new ArrayList(this.a3).iterator();
        while (it2.hasNext()) {
            ((LazyCompositionTask) it2.next()).a(lottieComposition);
            it2.remove();
        }
        this.a3.clear();
        lottieComposition.x(this.m3);
        Drawable.Callback callback = getCallback();
        if (!(callback instanceof ImageView)) {
            return true;
        }
        ImageView imageView = (ImageView) callback;
        imageView.setImageDrawable((Drawable) null);
        imageView.setImageDrawable(this);
        return true;
    }

    public void d0(FontAssetDelegate fontAssetDelegate) {
        this.h3 = fontAssetDelegate;
        FontAssetManager fontAssetManager = this.g3;
        if (fontAssetManager != null) {
            fontAssetManager.d(fontAssetDelegate);
        }
    }

    public void draw(@NonNull Canvas canvas) {
        this.p3 = false;
        L.a("Drawable#draw");
        if (this.Y2) {
            try {
                n(canvas);
            } catch (Throwable th) {
                Logger.c("Lottie crashed in draw!", th);
            }
        } else {
            n(canvas);
        }
        L.b("Drawable#draw");
    }

    public void e0(final int i2) {
        if (this.X == null) {
            this.a3.add(new LazyCompositionTask() {
                public void a(LottieComposition lottieComposition) {
                    LottieDrawable.this.e0(i2);
                }
            });
        } else {
            this.Y.y((float) i2);
        }
    }

    public void f(Animator.AnimatorListener animatorListener) {
        this.Y.addListener(animatorListener);
    }

    public void f0(ImageAssetDelegate imageAssetDelegate) {
        this.f3 = imageAssetDelegate;
        ImageAssetManager imageAssetManager = this.d3;
        if (imageAssetManager != null) {
            imageAssetManager.d(imageAssetDelegate);
        }
    }

    public void g(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.Y.addUpdateListener(animatorUpdateListener);
    }

    public void g0(@Nullable String str) {
        this.e3 = str;
    }

    public int getAlpha() {
        return this.l3;
    }

    public int getIntrinsicHeight() {
        LottieComposition lottieComposition = this.X;
        if (lottieComposition == null) {
            return -1;
        }
        return (int) (((float) lottieComposition.b().height()) * H());
    }

    public int getIntrinsicWidth() {
        LottieComposition lottieComposition = this.X;
        if (lottieComposition == null) {
            return -1;
        }
        return (int) (((float) lottieComposition.b().width()) * H());
    }

    public int getOpacity() {
        return -3;
    }

    public <T> void h(final KeyPath keyPath, final T t, final LottieValueCallback<T> lottieValueCallback) {
        CompositionLayer compositionLayer = this.k3;
        if (compositionLayer == null) {
            this.a3.add(new LazyCompositionTask() {
                public void a(LottieComposition lottieComposition) {
                    LottieDrawable.this.h(keyPath, t, lottieValueCallback);
                }
            });
            return;
        }
        boolean z = true;
        if (keyPath == KeyPath.f17118c) {
            compositionLayer.g(t, lottieValueCallback);
        } else if (keyPath.d() != null) {
            keyPath.d().g(t, lottieValueCallback);
        } else {
            List<KeyPath> Y3 = Y(keyPath);
            for (int i2 = 0; i2 < Y3.size(); i2++) {
                Y3.get(i2).d().g(t, lottieValueCallback);
            }
            z = true ^ Y3.isEmpty();
        }
        if (z) {
            invalidateSelf();
            if (t == LottieProperty.A) {
                s0(E());
            }
        }
    }

    public void h0(final int i2) {
        if (this.X == null) {
            this.a3.add(new LazyCompositionTask() {
                public void a(LottieComposition lottieComposition) {
                    LottieDrawable.this.h0(i2);
                }
            });
        } else {
            this.Y.z(((float) i2) + 0.99f);
        }
    }

    public <T> void i(KeyPath keyPath, T t, final SimpleLottieValueCallback<T> simpleLottieValueCallback) {
        h(keyPath, t, new LottieValueCallback<T>() {
            public T a(LottieFrameInfo<T> lottieFrameInfo) {
                return simpleLottieValueCallback.a(lottieFrameInfo);
            }
        });
    }

    public void i0(final String str) {
        LottieComposition lottieComposition = this.X;
        if (lottieComposition == null) {
            this.a3.add(new LazyCompositionTask() {
                public void a(LottieComposition lottieComposition) {
                    LottieDrawable.this.i0(str);
                }
            });
            return;
        }
        Marker k2 = lottieComposition.k(str);
        if (k2 != null) {
            h0((int) (k2.f17125b + k2.f17126c));
            return;
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
    }

    public void invalidateDrawable(@NonNull Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    public void invalidateSelf() {
        if (!this.p3) {
            this.p3 = true;
            Drawable.Callback callback = getCallback();
            if (callback != null) {
                callback.invalidateDrawable(this);
            }
        }
    }

    public boolean isRunning() {
        return N();
    }

    public void j0(@FloatRange(from = 0.0d, to = 1.0d) final float f2) {
        LottieComposition lottieComposition = this.X;
        if (lottieComposition == null) {
            this.a3.add(new LazyCompositionTask() {
                public void a(LottieComposition lottieComposition) {
                    LottieDrawable.this.j0(f2);
                }
            });
        } else {
            h0((int) MiscUtils.j(lottieComposition.p(), this.X.f(), f2));
        }
    }

    public void k() {
        this.a3.clear();
        this.Y.cancel();
    }

    public void k0(final int i2, final int i4) {
        if (this.X == null) {
            this.a3.add(new LazyCompositionTask() {
                public void a(LottieComposition lottieComposition) {
                    LottieDrawable.this.k0(i2, i4);
                }
            });
        } else {
            this.Y.A((float) i2, ((float) i4) + 0.99f);
        }
    }

    public void l() {
        if (this.Y.isRunning()) {
            this.Y.cancel();
        }
        this.X = null;
        this.k3 = null;
        this.d3 = null;
        this.Y.f();
        invalidateSelf();
    }

    public void l0(final String str) {
        LottieComposition lottieComposition = this.X;
        if (lottieComposition == null) {
            this.a3.add(new LazyCompositionTask() {
                public void a(LottieComposition lottieComposition) {
                    LottieDrawable.this.l0(str);
                }
            });
            return;
        }
        Marker k2 = lottieComposition.k(str);
        if (k2 != null) {
            int i2 = (int) k2.f17125b;
            k0(i2, ((int) k2.f17126c) + i2);
            return;
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
    }

    public void m() {
        this.o3 = false;
    }

    public void m0(final String str, final String str2, final boolean z) {
        LottieComposition lottieComposition = this.X;
        if (lottieComposition == null) {
            this.a3.add(new LazyCompositionTask() {
                public void a(LottieComposition lottieComposition) {
                    LottieDrawable.this.m0(str, str2, z);
                }
            });
            return;
        }
        Marker k2 = lottieComposition.k(str);
        if (k2 != null) {
            int i2 = (int) k2.f17125b;
            Marker k4 = this.X.k(str2);
            if (str2 != null) {
                k0(i2, (int) (k4.f17125b + (z ? 1.0f : 0.0f)));
                return;
            }
            throw new IllegalArgumentException("Cannot find marker with name " + str2 + ".");
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
    }

    public void n0(@FloatRange(from = 0.0d, to = 1.0d) final float f2, @FloatRange(from = 0.0d, to = 1.0d) final float f4) {
        LottieComposition lottieComposition = this.X;
        if (lottieComposition == null) {
            this.a3.add(new LazyCompositionTask() {
                public void a(LottieComposition lottieComposition) {
                    LottieDrawable.this.n0(f2, f4);
                }
            });
        } else {
            k0((int) MiscUtils.j(lottieComposition.p(), this.X.f(), f2), (int) MiscUtils.j(this.X.p(), this.X.f(), f4));
        }
    }

    public void o0(final int i2) {
        if (this.X == null) {
            this.a3.add(new LazyCompositionTask() {
                public void a(LottieComposition lottieComposition) {
                    LottieDrawable.this.o0(i2);
                }
            });
        } else {
            this.Y.B(i2);
        }
    }

    public void p0(final String str) {
        LottieComposition lottieComposition = this.X;
        if (lottieComposition == null) {
            this.a3.add(new LazyCompositionTask() {
                public void a(LottieComposition lottieComposition) {
                    LottieDrawable.this.p0(str);
                }
            });
            return;
        }
        Marker k2 = lottieComposition.k(str);
        if (k2 != null) {
            o0((int) k2.f17125b);
            return;
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
    }

    public void q(boolean z) {
        if (this.j3 != z) {
            this.j3 = z;
            if (this.X != null) {
                j();
            }
        }
    }

    public void q0(final float f2) {
        LottieComposition lottieComposition = this.X;
        if (lottieComposition == null) {
            this.a3.add(new LazyCompositionTask() {
                public void a(LottieComposition lottieComposition) {
                    LottieDrawable.this.q0(f2);
                }
            });
        } else {
            o0((int) MiscUtils.j(lottieComposition.p(), this.X.f(), f2));
        }
    }

    public boolean r() {
        return this.j3;
    }

    public void r0(boolean z) {
        this.m3 = z;
        LottieComposition lottieComposition = this.X;
        if (lottieComposition != null) {
            lottieComposition.x(z);
        }
    }

    @MainThread
    public void s() {
        this.a3.clear();
        this.Y.g();
    }

    public void s0(@FloatRange(from = 0.0d, to = 1.0d) final float f2) {
        if (this.X == null) {
            this.a3.add(new LazyCompositionTask() {
                public void a(LottieComposition lottieComposition) {
                    LottieDrawable.this.s0(f2);
                }
            });
            return;
        }
        L.a("Drawable#setProgress");
        this.Y.y(MiscUtils.j(this.X.p(), this.X.f(), f2));
        L.b("Drawable#setProgress");
    }

    public void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j2) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j2);
        }
    }

    public void setAlpha(@IntRange(from = 0, to = 255) int i2) {
        this.l3 = i2;
        invalidateSelf();
    }

    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        Logger.e("Use addColorFilter instead.");
    }

    @MainThread
    public void start() {
        T();
    }

    @MainThread
    public void stop() {
        s();
    }

    public LottieComposition t() {
        return this.X;
    }

    public void t0(int i2) {
        this.Y.setRepeatCount(i2);
    }

    public void u0(int i2) {
        this.Y.setRepeatMode(i2);
    }

    public void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }

    public void v0(boolean z) {
        this.Y2 = z;
    }

    public int w() {
        return (int) this.Y.i();
    }

    public void w0(float f2) {
        this.Z = f2;
        C0();
    }

    @Nullable
    public Bitmap x(String str) {
        ImageAssetManager y = y();
        if (y != null) {
            return y.a(str);
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void x0(ImageView.ScaleType scaleType) {
        this.c3 = scaleType;
    }

    public void y0(float f2) {
        this.Y.D(f2);
    }

    @Nullable
    public String z() {
        return this.e3;
    }

    /* access modifiers changed from: package-private */
    public void z0(Boolean bool) {
        this.X2 = bool.booleanValue();
    }
}
