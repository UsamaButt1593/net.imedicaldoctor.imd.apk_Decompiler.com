package net.imedicaldoctor.imd.Utils;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Property;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import net.imedicaldoctor.imd.R;

@SuppressLint({"ClickableViewAccessibility"})
public class MaterialRippleLayout extends FrameLayout {
    private static final int A3 = 75;
    private static final float B3 = 35.0f;
    private static final float C3 = 0.2f;
    private static final int D3 = -16777216;
    private static final int E3 = 0;
    private static final boolean F3 = true;
    private static final boolean G3 = true;
    private static final boolean H3 = false;
    private static final boolean I3 = false;
    private static final boolean J3 = false;
    private static final int K3 = 50;
    private static final long L3 = 2500;
    private static final int z3 = 550;
    private final Rect X2;
    private int Y2;
    private boolean Z2;
    /* access modifiers changed from: private */
    public boolean a3;
    private int b3;
    private int c3;
    /* access modifiers changed from: private */
    public int d3;
    /* access modifiers changed from: private */
    public boolean e3;
    private int f3;
    /* access modifiers changed from: private */
    public boolean g3;
    private Drawable h3;
    /* access modifiers changed from: private */
    public boolean i3;
    private float j3;
    private AdapterView<?> k3;
    /* access modifiers changed from: private */
    public View l3;
    private AnimatorSet m3;
    private ObjectAnimator n3;
    private final Point o3;
    private Point p3;
    private boolean q3;
    /* access modifiers changed from: private */
    public boolean r3;
    private final Paint s;
    private int s3;
    private final GestureDetector t3;
    private PerformClickEvent u3;
    private PressedEvent v3;
    private final GestureDetector.SimpleOnGestureListener w3;
    private final Property<MaterialRippleLayout, Float> x3;
    private final Property<MaterialRippleLayout, Integer> y3;

    private class PerformClickEvent implements Runnable {
        private PerformClickEvent() {
        }

        /* JADX WARNING: type inference failed for: r5v0, types: [android.widget.AdapterView<?>, android.widget.AdapterView] */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void a(android.widget.AdapterView<?> r5) {
            /*
                r4 = this;
                net.imedicaldoctor.imd.Utils.MaterialRippleLayout r0 = net.imedicaldoctor.imd.Utils.MaterialRippleLayout.this
                int r0 = r5.getPositionForView(r0)
                android.widget.Adapter r1 = r5.getAdapter()
                if (r1 == 0) goto L_0x0015
                android.widget.Adapter r1 = r5.getAdapter()
                long r1 = r1.getItemId(r0)
                goto L_0x0017
            L_0x0015:
                r1 = 0
            L_0x0017:
                r3 = -1
                if (r0 == r3) goto L_0x001f
                net.imedicaldoctor.imd.Utils.MaterialRippleLayout r3 = net.imedicaldoctor.imd.Utils.MaterialRippleLayout.this
                r5.performItemClick(r3, r0, r1)
            L_0x001f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.imedicaldoctor.imd.Utils.MaterialRippleLayout.PerformClickEvent.a(android.widget.AdapterView):void");
        }

        public void run() {
            AdapterView h2;
            if (MaterialRippleLayout.this.getParent() instanceof AdapterView) {
                h2 = (AdapterView) MaterialRippleLayout.this.getParent();
            } else if (MaterialRippleLayout.this.i3) {
                h2 = MaterialRippleLayout.this.p();
            } else {
                MaterialRippleLayout.this.l3.performClick();
                return;
            }
            a(h2);
        }
    }

    private final class PressedEvent implements Runnable {
        private final MotionEvent s;

        public PressedEvent(MotionEvent motionEvent) {
            this.s = motionEvent;
        }

        public void run() {
            boolean unused = MaterialRippleLayout.this.r3 = false;
            MaterialRippleLayout.this.l3.onTouchEvent(this.s);
            MaterialRippleLayout.this.l3.setPressed(true);
            if (MaterialRippleLayout.this.a3) {
                MaterialRippleLayout.this.t();
            }
        }
    }

    public static class RippleBuilder {

        /* renamed from: a  reason: collision with root package name */
        private final Context f30437a;

        /* renamed from: b  reason: collision with root package name */
        private final View f30438b;

        /* renamed from: c  reason: collision with root package name */
        private int f30439c = -16777216;

        /* renamed from: d  reason: collision with root package name */
        private boolean f30440d = false;

        /* renamed from: e  reason: collision with root package name */
        private boolean f30441e = true;

        /* renamed from: f  reason: collision with root package name */
        private float f30442f = MaterialRippleLayout.B3;

        /* renamed from: g  reason: collision with root package name */
        private int f30443g = MaterialRippleLayout.z3;

        /* renamed from: h  reason: collision with root package name */
        private float f30444h = 0.2f;

        /* renamed from: i  reason: collision with root package name */
        private boolean f30445i = true;

        /* renamed from: j  reason: collision with root package name */
        private int f30446j = 75;

        /* renamed from: k  reason: collision with root package name */
        private boolean f30447k = false;

        /* renamed from: l  reason: collision with root package name */
        private int f30448l = 0;

        /* renamed from: m  reason: collision with root package name */
        private final boolean f30449m = false;

        public RippleBuilder(View view) {
            this.f30438b = view;
            this.f30437a = view.getContext();
        }

        public MaterialRippleLayout a() {
            MaterialRippleLayout materialRippleLayout = new MaterialRippleLayout(this.f30437a);
            materialRippleLayout.setRippleColor(this.f30439c);
            materialRippleLayout.setDefaultRippleAlpha((int) this.f30444h);
            materialRippleLayout.setRippleDelayClick(this.f30445i);
            materialRippleLayout.setRippleDiameter((int) MaterialRippleLayout.n(this.f30437a.getResources(), this.f30442f));
            materialRippleLayout.setRippleDuration(this.f30443g);
            materialRippleLayout.setRippleFadeDuration(this.f30446j);
            materialRippleLayout.setRippleHover(this.f30441e);
            materialRippleLayout.setRipplePersistent(this.f30447k);
            materialRippleLayout.setRippleOverlay(this.f30440d);
            materialRippleLayout.setRippleBackground(this.f30448l);
            int i2 = 0;
            materialRippleLayout.setRippleInAdapter(false);
            ViewGroup.LayoutParams layoutParams = this.f30438b.getLayoutParams();
            ViewGroup viewGroup = (ViewGroup) this.f30438b.getParent();
            if (viewGroup == null || !(viewGroup instanceof MaterialRippleLayout)) {
                if (viewGroup != null) {
                    i2 = viewGroup.indexOfChild(this.f30438b);
                    viewGroup.removeView(this.f30438b);
                }
                materialRippleLayout.addView(this.f30438b, new ViewGroup.LayoutParams(-1, -1));
                if (viewGroup != null) {
                    viewGroup.addView(materialRippleLayout, i2, layoutParams);
                }
                return materialRippleLayout;
            }
            throw new IllegalStateException("MaterialRippleLayout could not be created: parent of the view already is a MaterialRippleLayout");
        }

        public RippleBuilder b(float f2) {
            this.f30444h = f2 * 255.0f;
            return this;
        }

        public RippleBuilder c(int i2) {
            this.f30448l = i2;
            return this;
        }

        public RippleBuilder d(int i2) {
            this.f30439c = i2;
            return this;
        }

        public RippleBuilder e(boolean z) {
            this.f30445i = z;
            return this;
        }

        public RippleBuilder f(int i2) {
            this.f30442f = (float) i2;
            return this;
        }

        public RippleBuilder g(int i2) {
            this.f30443g = i2;
            return this;
        }

        public RippleBuilder h(int i2) {
            this.f30446j = i2;
            return this;
        }

        public RippleBuilder i(boolean z) {
            this.f30441e = z;
            return this;
        }

        public RippleBuilder j(boolean z) {
            j(z);
            return this;
        }

        public RippleBuilder k(boolean z) {
            this.f30440d = z;
            return this;
        }

        public RippleBuilder l(boolean z) {
            this.f30447k = z;
            return this;
        }
    }

    public MaterialRippleLayout(Context context) {
        this(context, (AttributeSet) null, 0);
    }

    private float getEndRadius() {
        int width = getWidth();
        int height = getHeight();
        int i2 = width / 2;
        int i4 = height / 2;
        Point point = this.o3;
        int i5 = point.x;
        float f2 = i2 > i5 ? (float) (width - i5) : (float) i5;
        int i6 = point.y;
        return ((float) Math.sqrt(Math.pow((double) f2, 2.0d) + Math.pow((double) (i4 > i6 ? (float) (height - i6) : (float) i6), 2.0d))) * 1.2f;
    }

    /* access modifiers changed from: private */
    public float getRadius() {
        return this.j3;
    }

    private boolean k() {
        if (!this.i3) {
            return false;
        }
        int positionForView = p().getPositionForView(this);
        boolean z = positionForView != this.s3;
        this.s3 = positionForView;
        if (z) {
            m();
            l();
            this.l3.setPressed(false);
            setRadius(0.0f);
        }
        return z;
    }

    private void l() {
        AnimatorSet animatorSet = this.m3;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.m3.removeAllListeners();
        }
        ObjectAnimator objectAnimator = this.n3;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    private void m() {
        PressedEvent pressedEvent = this.v3;
        if (pressedEvent != null) {
            removeCallbacks(pressedEvent);
            this.r3 = false;
        }
    }

    static float n(Resources resources, float f2) {
        return TypedValue.applyDimension(1, f2, resources.getDisplayMetrics());
    }

    private boolean o(View view, int i2, int i4) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i5 = 0; i5 < viewGroup.getChildCount(); i5++) {
                View childAt = viewGroup.getChildAt(i5);
                Rect rect = new Rect();
                childAt.getHitRect(rect);
                if (rect.contains(i2, i4)) {
                    return o(childAt, i2 - rect.left, i4 - rect.top);
                }
            }
        } else if (view != this.l3) {
            if (view.isEnabled()) {
                return view.isClickable() || view.isLongClickable() || view.isFocusableInTouchMode();
            }
            return false;
        }
        return view.isFocusableInTouchMode();
    }

    /* access modifiers changed from: private */
    public AdapterView<?> p() {
        AdapterView<?> adapterView = this.k3;
        if (adapterView != null) {
            return adapterView;
        }
        ViewParent parent = getParent();
        while (!(parent instanceof AdapterView)) {
            try {
                parent = parent.getParent();
            } catch (NullPointerException unused) {
                throw new RuntimeException("Could not find a parent AdapterView");
            }
        }
        AdapterView<?> adapterView2 = (AdapterView) parent;
        this.k3 = adapterView2;
        return adapterView2;
    }

    private boolean q() {
        ViewParent parent = getParent();
        while (parent != null && (parent instanceof ViewGroup)) {
            if (((ViewGroup) parent).shouldDelayChildPressedState()) {
                return true;
            }
            parent = parent.getParent();
        }
        return false;
    }

    public static RippleBuilder r(View view) {
        return new RippleBuilder(view);
    }

    private void s() {
        if (this.i3) {
            this.s3 = p().getPositionForView(this);
        }
    }

    /* access modifiers changed from: private */
    public void t() {
        if (!this.q3) {
            ObjectAnimator objectAnimator = this.n3;
            if (objectAnimator != null) {
                objectAnimator.cancel();
            }
            ObjectAnimator duration = ObjectAnimator.ofFloat(this, this.x3, new float[]{(float) this.b3, (float) (Math.sqrt(Math.pow((double) getWidth(), 2.0d) + Math.pow((double) getHeight(), 2.0d)) * 1.2000000476837158d)}).setDuration(L3);
            this.n3 = duration;
            duration.setInterpolator(new LinearInterpolator());
            this.n3.start();
        }
    }

    private void u(final Runnable runnable) {
        if (!this.q3) {
            float endRadius = getEndRadius();
            l();
            AnimatorSet animatorSet = new AnimatorSet();
            this.m3 = animatorSet;
            animatorSet.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    if (!MaterialRippleLayout.this.g3) {
                        MaterialRippleLayout.this.setRadius(0.0f);
                        MaterialRippleLayout materialRippleLayout = MaterialRippleLayout.this;
                        materialRippleLayout.setRippleAlpha(Integer.valueOf(materialRippleLayout.d3));
                    }
                    if (runnable != null && MaterialRippleLayout.this.e3) {
                        try {
                            runnable.run();
                        } catch (Exception unused) {
                        }
                    }
                    MaterialRippleLayout.this.l3.setPressed(false);
                }
            });
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, this.x3, new float[]{this.j3, endRadius});
            ofFloat.setDuration((long) this.c3);
            ofFloat.setInterpolator(new DecelerateInterpolator());
            ObjectAnimator ofInt = ObjectAnimator.ofInt(this, this.y3, new int[]{this.d3, 0});
            ofInt.setDuration((long) this.f3);
            ofInt.setInterpolator(new AccelerateInterpolator());
            ofInt.setStartDelay((long) ((this.c3 - this.f3) - 50));
            if (this.g3) {
                this.m3.play(ofFloat);
            } else if (getRadius() > endRadius) {
                ofInt.setStartDelay(0);
                this.m3.play(ofInt);
            } else {
                this.m3.playTogether(new Animator[]{ofFloat, ofInt});
            }
            this.m3.start();
        }
    }

    public final void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            this.l3 = view;
            super.addView(view, i2, layoutParams);
            return;
        }
        throw new IllegalStateException("MaterialRippleLayout can host only one child");
    }

    public void draw(Canvas canvas) {
        boolean k2 = k();
        if (this.Z2) {
            if (!k2) {
                this.h3.draw(canvas);
            }
            super.draw(canvas);
            if (!k2) {
                Point point = this.o3;
                canvas.drawCircle((float) point.x, (float) point.y, this.j3, this.s);
                return;
            }
            return;
        }
        if (!k2) {
            this.h3.draw(canvas);
            Point point2 = this.o3;
            canvas.drawCircle((float) point2.x, (float) point2.y, this.j3, this.s);
        }
        super.draw(canvas);
    }

    public <T extends View> T getChildView() {
        return this.l3;
    }

    public int getRippleAlpha() {
        return this.s.getAlpha();
    }

    public boolean isInEditMode() {
        return true;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return !o(this.l3, (int) motionEvent.getX(), (int) motionEvent.getY());
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i4, int i5, int i6) {
        super.onSizeChanged(i2, i4, i5, i6);
        this.X2.set(0, 0, i2, i4);
        this.h3.setBounds(this.X2);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        if (!isEnabled() || !this.l3.isEnabled()) {
            return onTouchEvent;
        }
        boolean contains = this.X2.contains((int) motionEvent.getX(), (int) motionEvent.getY());
        if (contains) {
            Point point = this.p3;
            Point point2 = this.o3;
            point.set(point2.x, point2.y);
            this.o3.set((int) motionEvent.getX(), (int) motionEvent.getY());
        }
        if (this.t3.onTouchEvent(motionEvent)) {
            return true;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked == 1) {
                this.u3 = new PerformClickEvent();
                if (this.r3) {
                    this.l3.setPressed(true);
                    postDelayed(new Runnable() {
                        public void run() {
                            MaterialRippleLayout.this.l3.setPressed(false);
                        }
                    }, (long) ViewConfiguration.getPressedStateDuration());
                }
                if (contains) {
                    u(this.u3);
                } else if (!this.a3) {
                    setRadius(0.0f);
                }
                if (!this.e3 && contains) {
                    this.u3.run();
                }
            } else if (actionMasked == 2) {
                if (this.a3) {
                    if (contains && !this.q3) {
                        invalidate();
                    } else if (!contains) {
                        u((Runnable) null);
                    }
                }
                if (!contains) {
                    m();
                    ObjectAnimator objectAnimator = this.n3;
                    if (objectAnimator != null) {
                        objectAnimator.cancel();
                    }
                    this.l3.onTouchEvent(motionEvent);
                    this.q3 = true;
                }
            } else if (actionMasked == 3) {
                if (this.i3) {
                    Point point3 = this.o3;
                    Point point4 = this.p3;
                    point3.set(point4.x, point4.y);
                    this.p3 = new Point();
                }
                this.l3.onTouchEvent(motionEvent);
                if (!this.a3) {
                    this.l3.setPressed(false);
                } else if (!this.r3) {
                    u((Runnable) null);
                }
            }
            m();
        } else {
            s();
            this.q3 = false;
            if (q()) {
                m();
                this.r3 = true;
                PressedEvent pressedEvent = new PressedEvent(motionEvent);
                this.v3 = pressedEvent;
                postDelayed(pressedEvent, (long) ViewConfiguration.getTapTimeout());
            } else {
                this.l3.onTouchEvent(motionEvent);
                this.l3.setPressed(true);
                if (this.a3) {
                    t();
                }
            }
        }
        return true;
    }

    public void setDefaultRippleAlpha(int i2) {
        this.d3 = i2;
        this.s.setAlpha(i2);
        invalidate();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        View view = this.l3;
        if (view != null) {
            view.setOnClickListener(onClickListener);
            return;
        }
        throw new IllegalStateException("MaterialRippleLayout must have a child view to handle clicks");
    }

    public void setRadius(float f2) {
        this.j3 = f2;
        invalidate();
    }

    public void setRippleAlpha(Integer num) {
        this.s.setAlpha(num.intValue());
        invalidate();
    }

    public void setRippleBackground(int i2) {
        ColorDrawable colorDrawable = new ColorDrawable(i2);
        this.h3 = colorDrawable;
        colorDrawable.setBounds(this.X2);
        invalidate();
    }

    public void setRippleColor(int i2) {
        this.Y2 = i2;
        this.s.setColor(i2);
        this.s.setAlpha(this.d3);
        invalidate();
    }

    public void setRippleDelayClick(boolean z) {
        this.e3 = z;
    }

    public void setRippleDiameter(int i2) {
        this.b3 = i2;
    }

    public void setRippleDuration(int i2) {
        this.c3 = i2;
    }

    public void setRippleFadeDuration(int i2) {
        this.f3 = i2;
    }

    public void setRippleHover(boolean z) {
        this.a3 = z;
    }

    public void setRippleInAdapter(boolean z) {
        this.i3 = z;
    }

    public void setRippleOverlay(boolean z) {
        this.Z2 = z;
    }

    public void setRipplePersistent(boolean z) {
        this.g3 = z;
    }

    public MaterialRippleLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MaterialRippleLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Paint paint = new Paint(1);
        this.s = paint;
        this.X2 = new Rect();
        this.o3 = new Point();
        this.p3 = new Point();
        AnonymousClass2 r1 = new GestureDetector.SimpleOnGestureListener() {
            public void onLongPress(MotionEvent motionEvent) {
                MaterialRippleLayout.this.l3.performLongClick();
            }
        };
        this.w3 = r1;
        this.x3 = new Property<MaterialRippleLayout, Float>(Float.class, "radius") {
            /* renamed from: a */
            public Float get(MaterialRippleLayout materialRippleLayout) {
                return Float.valueOf(materialRippleLayout.getRadius());
            }

            /* renamed from: b */
            public void set(MaterialRippleLayout materialRippleLayout, Float f2) {
                materialRippleLayout.setRadius(f2.floatValue());
            }
        };
        this.y3 = new Property<MaterialRippleLayout, Integer>(Integer.class, "rippleAlpha") {
            /* renamed from: a */
            public Integer get(MaterialRippleLayout materialRippleLayout) {
                return Integer.valueOf(materialRippleLayout.getRippleAlpha());
            }

            /* renamed from: b */
            public void set(MaterialRippleLayout materialRippleLayout, Integer num) {
                materialRippleLayout.setRippleAlpha(num);
            }
        };
        setWillNotDraw(false);
        this.t3 = new GestureDetector(context, r1);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.wt);
        this.Y2 = obtainStyledAttributes.getColor(2, -16777216);
        this.b3 = obtainStyledAttributes.getDimensionPixelSize(4, (int) n(getResources(), B3));
        this.Z2 = obtainStyledAttributes.getBoolean(9, false);
        this.a3 = obtainStyledAttributes.getBoolean(7, true);
        this.c3 = obtainStyledAttributes.getInt(5, z3);
        this.d3 = (int) (obtainStyledAttributes.getFloat(0, 0.2f) * 255.0f);
        this.e3 = obtainStyledAttributes.getBoolean(3, true);
        this.f3 = obtainStyledAttributes.getInteger(6, 75);
        this.h3 = new ColorDrawable(obtainStyledAttributes.getColor(1, 0));
        this.g3 = obtainStyledAttributes.getBoolean(10, false);
        this.i3 = obtainStyledAttributes.getBoolean(8, false);
        obtainStyledAttributes.recycle();
        paint.setColor(this.Y2);
        paint.setAlpha(this.d3);
    }
}
