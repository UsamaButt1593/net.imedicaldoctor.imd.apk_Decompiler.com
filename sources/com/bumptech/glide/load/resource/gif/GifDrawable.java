package com.bumptech.glide.load.resource.gif;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.bumptech.glide.Glide;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.gif.GifFrameLoader;
import com.bumptech.glide.util.Preconditions;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public class GifDrawable extends Drawable implements GifFrameLoader.FrameCallback, Animatable, Animatable2Compat {
    public static final int e3 = -1;
    public static final int f3 = 0;
    private static final int g3 = 119;
    private boolean X;
    private boolean X2;
    private boolean Y;
    private int Y2;
    private boolean Z;
    private int Z2;
    private boolean a3;
    private Paint b3;
    private Rect c3;
    private List<Animatable2Compat.AnimationCallback> d3;
    private final GifState s;

    static final class GifState extends Drawable.ConstantState {
        @VisibleForTesting

        /* renamed from: a  reason: collision with root package name */
        final GifFrameLoader f18378a;

        GifState(GifFrameLoader gifFrameLoader) {
            this.f18378a = gifFrameLoader;
        }

        public int getChangingConfigurations() {
            return 0;
        }

        @NonNull
        public Drawable newDrawable() {
            return new GifDrawable(this);
        }

        @NonNull
        public Drawable newDrawable(Resources resources) {
            return newDrawable();
        }
    }

    public GifDrawable(Context context, GifDecoder gifDecoder, Transformation<Bitmap> transformation, int i2, int i3, Bitmap bitmap) {
        this(new GifState(new GifFrameLoader(Glide.d(context), gifDecoder, i2, i3, transformation, bitmap)));
    }

    private Drawable.Callback e() {
        Drawable.Callback callback = getCallback();
        while (callback instanceof Drawable) {
            callback = ((Drawable) callback).getCallback();
        }
        return callback;
    }

    private Rect g() {
        if (this.c3 == null) {
            this.c3 = new Rect();
        }
        return this.c3;
    }

    private Paint l() {
        if (this.b3 == null) {
            this.b3 = new Paint(2);
        }
        return this.b3;
    }

    private void o() {
        List<Animatable2Compat.AnimationCallback> list = this.d3;
        if (list != null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.d3.get(i2).b(this);
            }
        }
    }

    private void q() {
        this.Y2 = 0;
    }

    private void v() {
        Preconditions.a(!this.Z, "You cannot start a recycled Drawable. Ensure thatyou clear any references to the Drawable when clearing the corresponding request.");
        if (this.s.f18378a.f() != 1) {
            if (!this.X) {
                this.X = true;
                this.s.f18378a.v(this);
            } else {
                return;
            }
        }
        invalidateSelf();
    }

    private void w() {
        this.X = false;
        this.s.f18378a.w(this);
    }

    public void a() {
        if (e() == null) {
            stop();
            invalidateSelf();
            return;
        }
        invalidateSelf();
        if (j() == i() - 1) {
            this.Y2++;
        }
        int i2 = this.Z2;
        if (i2 != -1 && this.Y2 >= i2) {
            o();
            stop();
        }
    }

    public void b(@NonNull Animatable2Compat.AnimationCallback animationCallback) {
        if (animationCallback != null) {
            if (this.d3 == null) {
                this.d3 = new ArrayList();
            }
            this.d3.add(animationCallback);
        }
    }

    public void c() {
        List<Animatable2Compat.AnimationCallback> list = this.d3;
        if (list != null) {
            list.clear();
        }
    }

    public boolean d(@NonNull Animatable2Compat.AnimationCallback animationCallback) {
        List<Animatable2Compat.AnimationCallback> list = this.d3;
        if (list == null || animationCallback == null) {
            return false;
        }
        return list.remove(animationCallback);
    }

    public void draw(@NonNull Canvas canvas) {
        if (!this.Z) {
            if (this.a3) {
                Gravity.apply(119, getIntrinsicWidth(), getIntrinsicHeight(), getBounds(), g());
                this.a3 = false;
            }
            canvas.drawBitmap(this.s.f18378a.c(), (Rect) null, g(), l());
        }
    }

    public ByteBuffer f() {
        return this.s.f18378a.b();
    }

    public Drawable.ConstantState getConstantState() {
        return this.s;
    }

    public int getIntrinsicHeight() {
        return this.s.f18378a.i();
    }

    public int getIntrinsicWidth() {
        return this.s.f18378a.m();
    }

    public int getOpacity() {
        return -2;
    }

    public Bitmap h() {
        return this.s.f18378a.e();
    }

    public int i() {
        return this.s.f18378a.f();
    }

    public boolean isRunning() {
        return this.X;
    }

    public int j() {
        return this.s.f18378a.d();
    }

    public Transformation<Bitmap> k() {
        return this.s.f18378a.h();
    }

    public int m() {
        return this.s.f18378a.l();
    }

    /* access modifiers changed from: package-private */
    public boolean n() {
        return this.Z;
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.a3 = true;
    }

    public void p() {
        this.Z = true;
        this.s.f18378a.a();
    }

    public void r(Transformation<Bitmap> transformation, Bitmap bitmap) {
        this.s.f18378a.q(transformation, bitmap);
    }

    /* access modifiers changed from: package-private */
    public void s(boolean z) {
        this.X = z;
    }

    public void setAlpha(int i2) {
        l().setAlpha(i2);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        l().setColorFilter(colorFilter);
    }

    public boolean setVisible(boolean z, boolean z2) {
        Preconditions.a(!this.Z, "Cannot change the visibility of a recycled resource. Ensure that you unset the Drawable from your View before changing the View's visibility.");
        this.X2 = z;
        if (!z) {
            w();
        } else if (this.Y) {
            v();
        }
        return super.setVisible(z, z2);
    }

    public void start() {
        this.Y = true;
        q();
        if (this.X2) {
            v();
        }
    }

    public void stop() {
        this.Y = false;
        w();
    }

    public void t(int i2) {
        int i3 = -1;
        if (i2 <= 0 && i2 != -1 && i2 != 0) {
            throw new IllegalArgumentException("Loop count must be greater than 0, or equal to GlideDrawable.LOOP_FOREVER, or equal to GlideDrawable.LOOP_INTRINSIC");
        } else if (i2 == 0) {
            int j2 = this.s.f18378a.j();
            if (j2 != 0) {
                i3 = j2;
            }
            this.Z2 = i3;
        } else {
            this.Z2 = i2;
        }
    }

    public void u() {
        Preconditions.a(!this.X, "You cannot restart a currently running animation.");
        this.s.f18378a.r();
        start();
    }

    @Deprecated
    public GifDrawable(Context context, GifDecoder gifDecoder, BitmapPool bitmapPool, Transformation<Bitmap> transformation, int i2, int i3, Bitmap bitmap) {
        this(context, gifDecoder, transformation, i2, i3, bitmap);
    }

    GifDrawable(GifState gifState) {
        this.X2 = true;
        this.Z2 = -1;
        this.s = (GifState) Preconditions.d(gifState);
    }

    @VisibleForTesting
    GifDrawable(GifFrameLoader gifFrameLoader, Paint paint) {
        this(new GifState(gifFrameLoader));
        this.b3 = paint;
    }
}
