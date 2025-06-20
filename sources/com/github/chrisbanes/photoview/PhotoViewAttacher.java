package com.github.chrisbanes.photoview;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.OverScroller;
import net.imedicaldoctor.imd.BuildConfig;

public class PhotoViewAttacher implements View.OnTouchListener, View.OnLayoutChangeListener {
    /* access modifiers changed from: private */
    public static float A3 = 1.0f;
    private static int B3 = 200;
    private static final int C3 = -1;
    private static final int D3 = 0;
    private static final int E3 = 1;
    private static final int F3 = 2;
    private static final int G3 = -1;
    private static final int H3 = 0;
    private static final int I3 = 1;
    private static final int J3 = 2;
    /* access modifiers changed from: private */
    public static int K3 = 1;
    private static float y3 = 3.0f;
    private static float z3 = 1.75f;
    /* access modifiers changed from: private */
    public int X = B3;
    /* access modifiers changed from: private */
    public float X2 = y3;
    private float Y = A3;
    /* access modifiers changed from: private */
    public boolean Y2 = true;
    private float Z = z3;
    /* access modifiers changed from: private */
    public boolean Z2 = false;
    /* access modifiers changed from: private */
    public ImageView a3;
    private GestureDetector b3;
    /* access modifiers changed from: private */
    public CustomGestureDetector c3;
    private final Matrix d3 = new Matrix();
    private final Matrix e3 = new Matrix();
    /* access modifiers changed from: private */
    public final Matrix f3 = new Matrix();
    private final RectF g3 = new RectF();
    private final float[] h3 = new float[9];
    private OnMatrixChangedListener i3;
    /* access modifiers changed from: private */
    public OnPhotoTapListener j3;
    /* access modifiers changed from: private */
    public OnOutsidePhotoTapListener k3;
    /* access modifiers changed from: private */
    public OnViewTapListener l3;
    /* access modifiers changed from: private */
    public View.OnClickListener m3;
    /* access modifiers changed from: private */
    public View.OnLongClickListener n3;
    /* access modifiers changed from: private */
    public OnScaleChangedListener o3;
    /* access modifiers changed from: private */
    public OnSingleFlingListener p3;
    /* access modifiers changed from: private */
    public OnViewDragListener q3;
    /* access modifiers changed from: private */
    public FlingRunnable r3;
    /* access modifiers changed from: private */
    public Interpolator s = new AccelerateDecelerateInterpolator();
    /* access modifiers changed from: private */
    public int s3 = 2;
    /* access modifiers changed from: private */
    public int t3 = 2;
    private float u3;
    private boolean v3 = true;
    private ImageView.ScaleType w3 = ImageView.ScaleType.FIT_CENTER;
    /* access modifiers changed from: private */
    public OnGestureListener x3 = new OnGestureListener() {
        public void a(float f2, float f3) {
            if (!PhotoViewAttacher.this.c3.e()) {
                if (PhotoViewAttacher.this.q3 != null) {
                    PhotoViewAttacher.this.q3.a(f2, f3);
                }
                PhotoViewAttacher.this.f3.postTranslate(f2, f3);
                PhotoViewAttacher.this.B();
                ViewParent parent = PhotoViewAttacher.this.a3.getParent();
                if (!PhotoViewAttacher.this.Y2 || PhotoViewAttacher.this.c3.e() || PhotoViewAttacher.this.Z2) {
                    if (parent != null) {
                        parent.requestDisallowInterceptTouchEvent(true);
                    }
                } else if ((PhotoViewAttacher.this.s3 == 2 || ((PhotoViewAttacher.this.s3 == 0 && f2 >= 1.0f) || ((PhotoViewAttacher.this.s3 == 1 && f2 <= -1.0f) || ((PhotoViewAttacher.this.t3 == 0 && f3 >= 1.0f) || (PhotoViewAttacher.this.t3 == 1 && f3 <= -1.0f))))) && parent != null) {
                    parent.requestDisallowInterceptTouchEvent(false);
                }
            }
        }

        public void b(float f2, float f3, float f4) {
            if (PhotoViewAttacher.this.N() < PhotoViewAttacher.this.X2 || f2 < 1.0f) {
                if (PhotoViewAttacher.this.o3 != null) {
                    PhotoViewAttacher.this.o3.a(f2, f3, f4);
                }
                PhotoViewAttacher.this.f3.postScale(f2, f2, f3, f4);
                PhotoViewAttacher.this.B();
            }
        }

        public void c(float f2, float f3, float f4, float f5) {
            PhotoViewAttacher photoViewAttacher = PhotoViewAttacher.this;
            FlingRunnable unused = photoViewAttacher.r3 = new FlingRunnable(photoViewAttacher.a3.getContext());
            FlingRunnable y = PhotoViewAttacher.this.r3;
            PhotoViewAttacher photoViewAttacher2 = PhotoViewAttacher.this;
            int c2 = photoViewAttacher2.J(photoViewAttacher2.a3);
            PhotoViewAttacher photoViewAttacher3 = PhotoViewAttacher.this;
            y.b(c2, photoViewAttacher3.I(photoViewAttacher3.a3), (int) f4, (int) f5);
            PhotoViewAttacher.this.a3.post(PhotoViewAttacher.this.r3);
        }
    };

    /* renamed from: com.github.chrisbanes.photoview.PhotoViewAttacher$4  reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f18734a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                android.widget.ImageView$ScaleType[] r0 = android.widget.ImageView.ScaleType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f18734a = r0
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_CENTER     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f18734a     // Catch:{ NoSuchFieldError -> 0x001d }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_START     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f18734a     // Catch:{ NoSuchFieldError -> 0x0028 }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_END     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f18734a     // Catch:{ NoSuchFieldError -> 0x0033 }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_XY     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.github.chrisbanes.photoview.PhotoViewAttacher.AnonymousClass4.<clinit>():void");
        }
    }

    private class AnimatedZoomRunnable implements Runnable {
        private final float X;
        private final float X2;
        private final long Y = System.currentTimeMillis();
        private final float Z;
        private final float s;

        public AnimatedZoomRunnable(float f2, float f3, float f4, float f5) {
            this.s = f4;
            this.X = f5;
            this.Z = f2;
            this.X2 = f3;
        }

        private float a() {
            return PhotoViewAttacher.this.s.getInterpolation(Math.min(1.0f, (((float) (System.currentTimeMillis() - this.Y)) * 1.0f) / ((float) PhotoViewAttacher.this.X)));
        }

        public void run() {
            float a2 = a();
            float f2 = this.Z;
            PhotoViewAttacher.this.x3.b((f2 + ((this.X2 - f2) * a2)) / PhotoViewAttacher.this.N(), this.s, this.X);
            if (a2 < 1.0f) {
                Compat.a(PhotoViewAttacher.this.a3, this);
            }
        }
    }

    private class FlingRunnable implements Runnable {
        private int X;
        private int Y;
        private final OverScroller s;

        public FlingRunnable(Context context) {
            this.s = new OverScroller(context);
        }

        public void a() {
            this.s.forceFinished(true);
        }

        public void b(int i2, int i3, int i4, int i5) {
            int i6;
            int i7;
            int i8;
            int i9;
            RectF E = PhotoViewAttacher.this.E();
            if (E != null) {
                int round = Math.round(-E.left);
                float f2 = (float) i2;
                if (f2 < E.width()) {
                    i6 = Math.round(E.width() - f2);
                    i7 = 0;
                } else {
                    i7 = round;
                    i6 = i7;
                }
                int round2 = Math.round(-E.top);
                float f3 = (float) i3;
                if (f3 < E.height()) {
                    i8 = Math.round(E.height() - f3);
                    i9 = 0;
                } else {
                    i9 = round2;
                    i8 = i9;
                }
                this.X = round;
                this.Y = round2;
                if (round != i6 || round2 != i8) {
                    this.s.fling(round, round2, i4, i5, i7, i6, i9, i8, 0, 0);
                }
            }
        }

        public void run() {
            if (!this.s.isFinished() && this.s.computeScrollOffset()) {
                int currX = this.s.getCurrX();
                int currY = this.s.getCurrY();
                PhotoViewAttacher.this.f3.postTranslate((float) (this.X - currX), (float) (this.Y - currY));
                PhotoViewAttacher.this.B();
                this.X = currX;
                this.Y = currY;
                Compat.a(PhotoViewAttacher.this.a3, this);
            }
        }
    }

    public PhotoViewAttacher(ImageView imageView) {
        this.a3 = imageView;
        imageView.setOnTouchListener(this);
        imageView.addOnLayoutChangeListener(this);
        if (!imageView.isInEditMode()) {
            this.u3 = 0.0f;
            this.c3 = new CustomGestureDetector(imageView.getContext(), this.x3);
            GestureDetector gestureDetector = new GestureDetector(imageView.getContext(), new GestureDetector.SimpleOnGestureListener() {
                public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
                    if (PhotoViewAttacher.this.p3 == null || PhotoViewAttacher.this.N() > PhotoViewAttacher.A3 || motionEvent.getPointerCount() > PhotoViewAttacher.K3 || motionEvent2.getPointerCount() > PhotoViewAttacher.K3) {
                        return false;
                    }
                    return PhotoViewAttacher.this.p3.onFling(motionEvent, motionEvent2, f2, f3);
                }

                public void onLongPress(MotionEvent motionEvent) {
                    if (PhotoViewAttacher.this.n3 != null) {
                        PhotoViewAttacher.this.n3.onLongClick(PhotoViewAttacher.this.a3);
                    }
                }
            });
            this.b3 = gestureDetector;
            gestureDetector.setOnDoubleTapListener(new GestureDetector.OnDoubleTapListener() {
                public boolean onDoubleTap(MotionEvent motionEvent) {
                    PhotoViewAttacher photoViewAttacher;
                    float M;
                    try {
                        float N = PhotoViewAttacher.this.N();
                        float x = motionEvent.getX();
                        float y = motionEvent.getY();
                        if (N < PhotoViewAttacher.this.L()) {
                            photoViewAttacher = PhotoViewAttacher.this;
                            M = photoViewAttacher.L();
                        } else if (N < PhotoViewAttacher.this.L() || N >= PhotoViewAttacher.this.K()) {
                            photoViewAttacher = PhotoViewAttacher.this;
                            M = photoViewAttacher.M();
                        } else {
                            photoViewAttacher = PhotoViewAttacher.this;
                            M = photoViewAttacher.K();
                        }
                        photoViewAttacher.o0(M, x, y, true);
                    } catch (ArrayIndexOutOfBoundsException unused) {
                    }
                    return true;
                }

                public boolean onDoubleTapEvent(MotionEvent motionEvent) {
                    return false;
                }

                public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                    if (PhotoViewAttacher.this.m3 != null) {
                        PhotoViewAttacher.this.m3.onClick(PhotoViewAttacher.this.a3);
                    }
                    RectF E = PhotoViewAttacher.this.E();
                    float x = motionEvent.getX();
                    float y = motionEvent.getY();
                    if (PhotoViewAttacher.this.l3 != null) {
                        PhotoViewAttacher.this.l3.a(PhotoViewAttacher.this.a3, x, y);
                    }
                    if (E == null) {
                        return false;
                    }
                    if (E.contains(x, y)) {
                        float width = (x - E.left) / E.width();
                        float height = (y - E.top) / E.height();
                        if (PhotoViewAttacher.this.j3 == null) {
                            return true;
                        }
                        PhotoViewAttacher.this.j3.a(PhotoViewAttacher.this.a3, width, height);
                        return true;
                    } else if (PhotoViewAttacher.this.k3 == null) {
                        return false;
                    } else {
                        PhotoViewAttacher.this.k3.a(PhotoViewAttacher.this.a3);
                        return false;
                    }
                }
            });
        }
    }

    private void A() {
        FlingRunnable flingRunnable = this.r3;
        if (flingRunnable != null) {
            flingRunnable.a();
            this.r3 = null;
        }
    }

    /* access modifiers changed from: private */
    public void B() {
        if (C()) {
            X(G());
        }
    }

    private boolean C() {
        float f2;
        RectF F = F(G());
        if (F == null) {
            return false;
        }
        float height = F.height();
        float width = F.width();
        float I = (float) I(this.a3);
        float f4 = 0.0f;
        if (height <= I) {
            int i2 = AnonymousClass4.f18734a[this.w3.ordinal()];
            if (i2 != 2) {
                float f5 = I - height;
                if (i2 != 3) {
                    f5 /= 2.0f;
                }
                f2 = f5 - F.top;
            } else {
                f2 = -F.top;
            }
            this.t3 = 2;
        } else {
            float f6 = F.top;
            if (f6 > 0.0f) {
                this.t3 = 0;
                f2 = -f6;
            } else {
                float f7 = F.bottom;
                if (f7 < I) {
                    this.t3 = 1;
                    f2 = I - f7;
                } else {
                    this.t3 = -1;
                    f2 = 0.0f;
                }
            }
        }
        float J = (float) J(this.a3);
        if (width <= J) {
            int i4 = AnonymousClass4.f18734a[this.w3.ordinal()];
            if (i4 != 2) {
                float f8 = J - width;
                if (i4 != 3) {
                    f8 /= 2.0f;
                }
                f4 = f8 - F.left;
            } else {
                f4 = -F.left;
            }
            this.s3 = 2;
        } else {
            float f9 = F.left;
            if (f9 > 0.0f) {
                this.s3 = 0;
                f4 = -f9;
            } else {
                float f10 = F.right;
                if (f10 < J) {
                    f4 = J - f10;
                    this.s3 = 1;
                } else {
                    this.s3 = -1;
                }
            }
        }
        this.f3.postTranslate(f4, f2);
        return true;
    }

    private RectF F(Matrix matrix) {
        Drawable drawable = this.a3.getDrawable();
        if (drawable == null) {
            return null;
        }
        this.g3.set(0.0f, 0.0f, (float) drawable.getIntrinsicWidth(), (float) drawable.getIntrinsicHeight());
        matrix.mapRect(this.g3);
        return this.g3;
    }

    private Matrix G() {
        this.e3.set(this.d3);
        this.e3.postConcat(this.f3);
        return this.e3;
    }

    /* access modifiers changed from: private */
    public int I(ImageView imageView) {
        return (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
    }

    /* access modifiers changed from: private */
    public int J(ImageView imageView) {
        return (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
    }

    private float Q(Matrix matrix, int i2) {
        matrix.getValues(this.h3);
        return this.h3[i2];
    }

    private void T() {
        this.f3.reset();
        l0(this.u3);
        X(G());
        C();
    }

    private void X(Matrix matrix) {
        RectF F;
        this.a3.setImageMatrix(matrix);
        if (this.i3 != null && (F = F(matrix)) != null) {
            this.i3.a(F);
        }
    }

    private void w0(Drawable drawable) {
        Matrix matrix;
        Matrix.ScaleToFit scaleToFit;
        float min;
        if (drawable != null) {
            float J = (float) J(this.a3);
            float I = (float) I(this.a3);
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            this.d3.reset();
            float f2 = (float) intrinsicWidth;
            float f4 = J / f2;
            float f5 = (float) intrinsicHeight;
            float f6 = I / f5;
            ImageView.ScaleType scaleType = this.w3;
            if (scaleType == ImageView.ScaleType.CENTER) {
                this.d3.postTranslate((J - f2) / 2.0f, (I - f5) / 2.0f);
            } else {
                if (scaleType == ImageView.ScaleType.CENTER_CROP) {
                    min = Math.max(f4, f6);
                } else if (scaleType == ImageView.ScaleType.CENTER_INSIDE) {
                    min = Math.min(1.0f, Math.min(f4, f6));
                } else {
                    RectF rectF = new RectF(0.0f, 0.0f, f2, f5);
                    RectF rectF2 = new RectF(0.0f, 0.0f, J, I);
                    if (((int) this.u3) % BuildConfig.f29478d != 0) {
                        rectF = new RectF(0.0f, 0.0f, f5, f2);
                    }
                    int i2 = AnonymousClass4.f18734a[this.w3.ordinal()];
                    if (i2 == 1) {
                        matrix = this.d3;
                        scaleToFit = Matrix.ScaleToFit.CENTER;
                    } else if (i2 == 2) {
                        matrix = this.d3;
                        scaleToFit = Matrix.ScaleToFit.START;
                    } else if (i2 == 3) {
                        matrix = this.d3;
                        scaleToFit = Matrix.ScaleToFit.END;
                    } else if (i2 == 4) {
                        matrix = this.d3;
                        scaleToFit = Matrix.ScaleToFit.FILL;
                    }
                    matrix.setRectToRect(rectF, rectF2, scaleToFit);
                }
                this.d3.postScale(min, min);
                this.d3.postTranslate((J - (f2 * min)) / 2.0f, (I - (f5 * min)) / 2.0f);
            }
            T();
        }
    }

    public void D(Matrix matrix) {
        matrix.set(G());
    }

    public RectF E() {
        C();
        return F(G());
    }

    public Matrix H() {
        return this.e3;
    }

    public float K() {
        return this.X2;
    }

    public float L() {
        return this.Z;
    }

    public float M() {
        return this.Y;
    }

    public float N() {
        return (float) Math.sqrt((double) (((float) Math.pow((double) Q(this.f3, 0), 2.0d)) + ((float) Math.pow((double) Q(this.f3, 3), 2.0d))));
    }

    public ImageView.ScaleType O() {
        return this.w3;
    }

    public void P(Matrix matrix) {
        matrix.set(this.f3);
    }

    @Deprecated
    public boolean R() {
        return this.v3;
    }

    public boolean S() {
        return this.v3;
    }

    public void U(boolean z) {
        this.Y2 = z;
    }

    public void V(float f2) {
        this.u3 = f2 % 360.0f;
        v0();
        l0(this.u3);
        B();
    }

    public boolean W(Matrix matrix) {
        if (matrix == null) {
            throw new IllegalArgumentException("Matrix cannot be null");
        } else if (this.a3.getDrawable() == null) {
            return false;
        } else {
            this.f3.set(matrix);
            B();
            return true;
        }
    }

    public void Y(float f2) {
        Util.a(this.Y, this.Z, f2);
        this.X2 = f2;
    }

    public void Z(float f2) {
        Util.a(this.Y, f2, this.X2);
        this.Z = f2;
    }

    public void a0(float f2) {
        Util.a(f2, this.Z, this.X2);
        this.Y = f2;
    }

    public void b0(View.OnClickListener onClickListener) {
        this.m3 = onClickListener;
    }

    public void c0(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.b3.setOnDoubleTapListener(onDoubleTapListener);
    }

    public void d0(View.OnLongClickListener onLongClickListener) {
        this.n3 = onLongClickListener;
    }

    public void e0(OnMatrixChangedListener onMatrixChangedListener) {
        this.i3 = onMatrixChangedListener;
    }

    public void f0(OnOutsidePhotoTapListener onOutsidePhotoTapListener) {
        this.k3 = onOutsidePhotoTapListener;
    }

    public void g0(OnPhotoTapListener onPhotoTapListener) {
        this.j3 = onPhotoTapListener;
    }

    public void h0(OnScaleChangedListener onScaleChangedListener) {
        this.o3 = onScaleChangedListener;
    }

    public void i0(OnSingleFlingListener onSingleFlingListener) {
        this.p3 = onSingleFlingListener;
    }

    public void j0(OnViewDragListener onViewDragListener) {
        this.q3 = onViewDragListener;
    }

    public void k0(OnViewTapListener onViewTapListener) {
        this.l3 = onViewTapListener;
    }

    public void l0(float f2) {
        this.f3.postRotate(f2 % 360.0f);
        B();
    }

    public void m0(float f2) {
        this.f3.setRotate(f2 % 360.0f);
        B();
    }

    public void n0(float f2) {
        p0(f2, false);
    }

    public void o0(float f2, float f4, float f5, boolean z) {
        if (f2 < this.Y || f2 > this.X2) {
            throw new IllegalArgumentException("Scale must be within the range of minScale and maxScale");
        } else if (z) {
            this.a3.post(new AnimatedZoomRunnable(N(), f2, f4, f5));
        } else {
            this.f3.setScale(f2, f2, f4, f5);
            B();
        }
    }

    public void onLayoutChange(View view, int i2, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        if (i2 != i7 || i4 != i8 || i5 != i9 || i6 != i10) {
            w0(this.a3.getDrawable());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00ba A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:51:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouch(android.view.View r11, android.view.MotionEvent r12) {
        /*
            r10 = this;
            boolean r0 = r10.v3
            r1 = 0
            if (r0 == 0) goto L_0x00bb
            r0 = r11
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            boolean r0 = com.github.chrisbanes.photoview.Util.c(r0)
            if (r0 == 0) goto L_0x00bb
            int r0 = r12.getAction()
            r2 = 1
            if (r0 == 0) goto L_0x006b
            if (r0 == r2) goto L_0x001b
            r3 = 3
            if (r0 == r3) goto L_0x001b
            goto L_0x0077
        L_0x001b:
            float r0 = r10.N()
            float r3 = r10.Y
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 >= 0) goto L_0x0041
            android.graphics.RectF r0 = r10.E()
            if (r0 == 0) goto L_0x0077
            com.github.chrisbanes.photoview.PhotoViewAttacher$AnimatedZoomRunnable r9 = new com.github.chrisbanes.photoview.PhotoViewAttacher$AnimatedZoomRunnable
            float r5 = r10.N()
            float r6 = r10.Y
            float r7 = r0.centerX()
            float r8 = r0.centerY()
            r3 = r9
            r4 = r10
            r3.<init>(r5, r6, r7, r8)
            goto L_0x0066
        L_0x0041:
            float r0 = r10.N()
            float r3 = r10.X2
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 <= 0) goto L_0x0077
            android.graphics.RectF r0 = r10.E()
            if (r0 == 0) goto L_0x0077
            com.github.chrisbanes.photoview.PhotoViewAttacher$AnimatedZoomRunnable r9 = new com.github.chrisbanes.photoview.PhotoViewAttacher$AnimatedZoomRunnable
            float r5 = r10.N()
            float r6 = r10.X2
            float r7 = r0.centerX()
            float r8 = r0.centerY()
            r3 = r9
            r4 = r10
            r3.<init>(r5, r6, r7, r8)
        L_0x0066:
            r11.post(r9)
            r11 = 1
            goto L_0x0078
        L_0x006b:
            android.view.ViewParent r11 = r11.getParent()
            if (r11 == 0) goto L_0x0074
            r11.requestDisallowInterceptTouchEvent(r2)
        L_0x0074:
            r10.A()
        L_0x0077:
            r11 = 0
        L_0x0078:
            com.github.chrisbanes.photoview.CustomGestureDetector r0 = r10.c3
            if (r0 == 0) goto L_0x00af
            boolean r11 = r0.e()
            com.github.chrisbanes.photoview.CustomGestureDetector r0 = r10.c3
            boolean r0 = r0.d()
            com.github.chrisbanes.photoview.CustomGestureDetector r3 = r10.c3
            boolean r3 = r3.f(r12)
            if (r11 != 0) goto L_0x0098
            com.github.chrisbanes.photoview.CustomGestureDetector r11 = r10.c3
            boolean r11 = r11.e()
            if (r11 != 0) goto L_0x0098
            r11 = 1
            goto L_0x0099
        L_0x0098:
            r11 = 0
        L_0x0099:
            if (r0 != 0) goto L_0x00a5
            com.github.chrisbanes.photoview.CustomGestureDetector r0 = r10.c3
            boolean r0 = r0.d()
            if (r0 != 0) goto L_0x00a5
            r0 = 1
            goto L_0x00a6
        L_0x00a5:
            r0 = 0
        L_0x00a6:
            if (r11 == 0) goto L_0x00ab
            if (r0 == 0) goto L_0x00ab
            r1 = 1
        L_0x00ab:
            r10.Z2 = r1
            r1 = r3
            goto L_0x00b0
        L_0x00af:
            r1 = r11
        L_0x00b0:
            android.view.GestureDetector r11 = r10.b3
            if (r11 == 0) goto L_0x00bb
            boolean r11 = r11.onTouchEvent(r12)
            if (r11 == 0) goto L_0x00bb
            r1 = 1
        L_0x00bb:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.chrisbanes.photoview.PhotoViewAttacher.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    public void p0(float f2, boolean z) {
        o0(f2, (float) (this.a3.getRight() / 2), (float) (this.a3.getBottom() / 2), z);
    }

    public void q0(float f2, float f4, float f5) {
        Util.a(f2, f4, f5);
        this.Y = f2;
        this.Z = f4;
        this.X2 = f5;
    }

    public void r0(ImageView.ScaleType scaleType) {
        if (Util.d(scaleType) && scaleType != this.w3) {
            this.w3 = scaleType;
            v0();
        }
    }

    public void s0(Interpolator interpolator) {
        this.s = interpolator;
    }

    public void t0(int i2) {
        this.X = i2;
    }

    public void u0(boolean z) {
        this.v3 = z;
        v0();
    }

    public void v0() {
        if (this.v3) {
            w0(this.a3.getDrawable());
        } else {
            T();
        }
    }
}
