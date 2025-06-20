package net.imedicaldoctor.imd.Fragments;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;

public class DynamicListView extends ListView {
    private static final TypeEvaluator<Rect> u3 = new TypeEvaluator<Rect>() {
        /* renamed from: a */
        public Rect evaluate(float f2, Rect rect, Rect rect2) {
            return new Rect(b(rect.left, rect2.left, f2), b(rect.top, rect2.top, f2), b(rect.right, rect2.right, f2), b(rect.bottom, rect2.bottom, f2));
        }

        public int b(int i2, int i3, float f2) {
            return (int) (((float) i2) + (f2 * ((float) (i3 - i2))));
        }
    };
    private final int X2 = 150;
    private final int Y2 = 15;
    public ArrayList<String> Z2;
    private int a3 = -1;
    /* access modifiers changed from: private */
    public int b3 = -1;
    /* access modifiers changed from: private */
    public int c3 = -1;
    /* access modifiers changed from: private */
    public int d3 = 0;
    /* access modifiers changed from: private */
    public boolean e3 = false;
    /* access modifiers changed from: private */
    public boolean f3 = false;
    private int g3 = 0;
    private final int h3 = -1;
    /* access modifiers changed from: private */
    public long i3 = -1;
    /* access modifiers changed from: private */
    public long j3 = -1;
    /* access modifiers changed from: private */
    public long k3 = -1;
    /* access modifiers changed from: private */
    public BitmapDrawable l3;
    private Rect m3;
    private Rect n3;
    private final int o3 = -1;
    private int p3 = -1;
    /* access modifiers changed from: private */
    public boolean q3 = false;
    /* access modifiers changed from: private */
    public int r3 = 0;
    private final int s = 15;
    private final AdapterView.OnItemLongClickListener s3 = new AdapterView.OnItemLongClickListener() {
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            int unused = DynamicListView.this.d3 = 0;
            DynamicListView dynamicListView = DynamicListView.this;
            int pointToPosition = dynamicListView.pointToPosition(dynamicListView.c3, DynamicListView.this.b3);
            View childAt = DynamicListView.this.getChildAt(pointToPosition - DynamicListView.this.getFirstVisiblePosition());
            DynamicListView dynamicListView2 = DynamicListView.this;
            long unused2 = dynamicListView2.j3 = dynamicListView2.getAdapter().getItemId(pointToPosition);
            DynamicListView dynamicListView3 = DynamicListView.this;
            BitmapDrawable unused3 = dynamicListView3.l3 = dynamicListView3.t(childAt);
            childAt.setVisibility(4);
            boolean unused4 = DynamicListView.this.e3 = true;
            DynamicListView dynamicListView4 = DynamicListView.this;
            dynamicListView4.F(dynamicListView4.j3);
            return true;
        }
    };
    private final AbsListView.OnScrollListener t3 = new AbsListView.OnScrollListener() {

        /* renamed from: a  reason: collision with root package name */
        private int f29708a = -1;

        /* renamed from: b  reason: collision with root package name */
        private int f29709b = -1;

        /* renamed from: c  reason: collision with root package name */
        private int f29710c;

        /* renamed from: d  reason: collision with root package name */
        private int f29711d;

        /* renamed from: e  reason: collision with root package name */
        private int f29712e;

        private void c() {
            if (this.f29711d > 0 && this.f29712e == 0) {
                if (DynamicListView.this.e3 && DynamicListView.this.f3) {
                    DynamicListView.this.z();
                } else if (DynamicListView.this.q3) {
                    DynamicListView.this.E();
                }
            }
        }

        public void a() {
            if (this.f29710c != this.f29708a && DynamicListView.this.e3 && DynamicListView.this.j3 != -1) {
                DynamicListView dynamicListView = DynamicListView.this;
                dynamicListView.F(dynamicListView.j3);
                DynamicListView.this.y();
            }
        }

        public void b() {
            if (this.f29710c + this.f29711d != this.f29708a + this.f29709b && DynamicListView.this.e3 && DynamicListView.this.j3 != -1) {
                DynamicListView dynamicListView = DynamicListView.this;
                dynamicListView.F(dynamicListView.j3);
                DynamicListView.this.y();
            }
        }

        public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            this.f29710c = i2;
            this.f29711d = i3;
            int i5 = this.f29708a;
            if (i5 != -1) {
                i2 = i5;
            }
            this.f29708a = i2;
            int i6 = this.f29709b;
            if (i6 != -1) {
                i3 = i6;
            }
            this.f29709b = i3;
            a();
            b();
            this.f29708a = this.f29710c;
            this.f29709b = this.f29711d;
        }

        public void onScrollStateChanged(AbsListView absListView, int i2) {
            this.f29712e = i2;
            int unused = DynamicListView.this.r3 = i2;
            c();
        }
    };

    public DynamicListView(Context context) {
        super(context);
        B(context);
    }

    private void C(ArrayList arrayList, int i2, int i4) {
        Object obj = arrayList.get(i2);
        arrayList.set(i2, arrayList.get(i4));
        arrayList.set(i4, obj);
    }

    private void D() {
        View x = x(this.j3);
        if (this.e3) {
            this.i3 = -1;
            this.j3 = -1;
            this.k3 = -1;
            x.setVisibility(0);
            this.l3 = null;
            invalidate();
        }
        this.e3 = false;
        this.f3 = false;
        this.p3 = -1;
    }

    /* access modifiers changed from: private */
    public void E() {
        final View x = x(this.j3);
        if (this.e3 || this.q3) {
            this.e3 = false;
            this.q3 = false;
            this.f3 = false;
            this.p3 = -1;
            if (this.r3 != 0) {
                this.q3 = true;
                return;
            }
            this.m3.offsetTo(this.n3.left, x.getTop());
            ObjectAnimator ofObject = ObjectAnimator.ofObject(this.l3, "bounds", u3, new Object[]{this.m3});
            ofObject.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    DynamicListView.this.invalidate();
                }
            });
            ofObject.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    long unused = DynamicListView.this.i3 = -1;
                    long unused2 = DynamicListView.this.j3 = -1;
                    long unused3 = DynamicListView.this.k3 = -1;
                    x.setVisibility(0);
                    BitmapDrawable unused4 = DynamicListView.this.l3 = null;
                    DynamicListView.this.setEnabled(true);
                    DynamicListView.this.invalidate();
                }

                public void onAnimationStart(Animator animator) {
                    DynamicListView.this.setEnabled(false);
                }
            });
            ofObject.start();
            return;
        }
        D();
    }

    /* access modifiers changed from: private */
    public void F(long j2) {
        int w = w(j2);
        StableArrayAdapter stableArrayAdapter = (StableArrayAdapter) getAdapter();
        this.i3 = stableArrayAdapter.getItemId(w - 1);
        this.k3 = stableArrayAdapter.getItemId(w + 1);
    }

    static /* synthetic */ int b(DynamicListView dynamicListView, int i2) {
        int i4 = dynamicListView.d3 + i2;
        dynamicListView.d3 = i4;
        return i4;
    }

    /* access modifiers changed from: private */
    public BitmapDrawable t(View view) {
        int width = view.getWidth();
        int height = view.getHeight();
        int top = view.getTop();
        int left = view.getLeft();
        BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(), v(view));
        this.n3 = new Rect(left, top, width + left, height + top);
        Rect rect = new Rect(this.n3);
        this.m3 = rect;
        bitmapDrawable.setBounds(rect);
        return bitmapDrawable;
    }

    private Bitmap u(View view) {
        Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        view.draw(new Canvas(createBitmap));
        return createBitmap;
    }

    private Bitmap v(View view) {
        Bitmap u = u(view);
        Canvas canvas = new Canvas(u);
        Rect rect = new Rect(0, 0, u.getWidth(), u.getHeight());
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(15.0f);
        paint.setColor(ViewCompat.y);
        canvas.drawBitmap(u, 0.0f, 0.0f, (Paint) null);
        canvas.drawRect(rect, paint);
        return u;
    }

    /* access modifiers changed from: private */
    public void y() {
        final int i2 = this.a3 - this.b3;
        int i4 = this.n3.top + this.d3 + i2;
        View x = x(this.k3);
        View x2 = x(this.j3);
        View x3 = x(this.i3);
        boolean z = true;
        boolean z2 = x != null && i4 > x.getTop();
        if (x3 == null || i4 >= x3.getTop()) {
            z = false;
        }
        if (z2 || z) {
            long j2 = z2 ? this.k3 : this.i3;
            if (!z2) {
                x = x3;
            }
            int positionForView = getPositionForView(x2);
            if (x == null) {
                F(this.j3);
                return;
            }
            C(this.Z2, positionForView, getPositionForView(x));
            ((BaseAdapter) getAdapter()).notifyDataSetChanged();
            this.b3 = this.a3;
            int top = x.getTop();
            x2.setVisibility(0);
            x.setVisibility(4);
            F(this.j3);
            ViewTreeObserver viewTreeObserver = getViewTreeObserver();
            final ViewTreeObserver viewTreeObserver2 = viewTreeObserver;
            final long j4 = j2;
            final int i5 = top;
            viewTreeObserver.addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
                public boolean onPreDraw() {
                    viewTreeObserver2.removeOnPreDrawListener(this);
                    View x = DynamicListView.this.x(j4);
                    DynamicListView.b(DynamicListView.this, i2);
                    x.setTranslationY((float) (i5 - x.getTop()));
                    ObjectAnimator ofFloat = ObjectAnimator.ofFloat(x, View.TRANSLATION_Y, new float[]{0.0f});
                    ofFloat.setDuration(150);
                    ofFloat.start();
                    return true;
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void z() {
        this.f3 = A(this.m3);
    }

    public boolean A(Rect rect) {
        int i2;
        int computeVerticalScrollOffset = computeVerticalScrollOffset();
        int height = getHeight();
        int computeVerticalScrollExtent = computeVerticalScrollExtent();
        int computeVerticalScrollRange = computeVerticalScrollRange();
        int i4 = rect.top;
        int height2 = rect.height();
        if (i4 <= 0 && computeVerticalScrollOffset > 0) {
            i2 = -this.g3;
        } else if (i4 + height2 < height || computeVerticalScrollOffset + computeVerticalScrollExtent >= computeVerticalScrollRange) {
            return false;
        } else {
            i2 = this.g3;
        }
        smoothScrollBy(i2, 0);
        return true;
    }

    public void B(Context context) {
        setOnItemLongClickListener(this.s3);
        setOnScrollListener(this.t3);
        this.g3 = (int) (15.0f / context.getResources().getDisplayMetrics().density);
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        BitmapDrawable bitmapDrawable = this.l3;
        if (bitmapDrawable != null) {
            bitmapDrawable.draw(canvas);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0026, code lost:
        if (r5.getPointerId((r5.getAction() & androidx.core.view.MotionEventCompat.f6446f) >> 8) != r4.p3) goto L_0x007e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r5) {
        /*
            r4 = this;
            int r0 = r5.getAction()
            r0 = r0 & 255(0xff, float:3.57E-43)
            r1 = 0
            if (r0 == 0) goto L_0x006a
            r2 = 1
            if (r0 == r2) goto L_0x0028
            r2 = 2
            if (r0 == r2) goto L_0x0030
            r1 = 3
            if (r0 == r1) goto L_0x002c
            r1 = 6
            if (r0 == r1) goto L_0x0016
            goto L_0x007e
        L_0x0016:
            int r0 = r5.getAction()
            r1 = 65280(0xff00, float:9.1477E-41)
            r0 = r0 & r1
            int r0 = r0 >> 8
            int r0 = r5.getPointerId(r0)
            int r1 = r4.p3
            if (r0 != r1) goto L_0x007e
        L_0x0028:
            r4.E()
            goto L_0x007e
        L_0x002c:
            r4.D()
            goto L_0x007e
        L_0x0030:
            int r0 = r4.p3
            r2 = -1
            if (r0 != r2) goto L_0x0036
            goto L_0x007e
        L_0x0036:
            int r0 = r5.findPointerIndex(r0)
            float r0 = r5.getY(r0)
            int r0 = (int) r0
            r4.a3 = r0
            int r2 = r4.b3
            int r0 = r0 - r2
            boolean r2 = r4.e3
            if (r2 == 0) goto L_0x007e
            android.graphics.Rect r5 = r4.m3
            android.graphics.Rect r2 = r4.n3
            int r3 = r2.left
            int r2 = r2.top
            int r2 = r2 + r0
            int r0 = r4.d3
            int r2 = r2 + r0
            r5.offsetTo(r3, r2)
            android.graphics.drawable.BitmapDrawable r5 = r4.l3
            android.graphics.Rect r0 = r4.m3
            r5.setBounds(r0)
            r4.invalidate()
            r4.y()
            r4.f3 = r1
            r4.z()
            return r1
        L_0x006a:
            float r0 = r5.getX()
            int r0 = (int) r0
            r4.c3 = r0
            float r0 = r5.getY()
            int r0 = (int) r0
            r4.b3 = r0
            int r0 = r5.getPointerId(r1)
            r4.p3 = r0
        L_0x007e:
            boolean r5 = super.onTouchEvent(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: net.imedicaldoctor.imd.Fragments.DynamicListView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setCheeseList(ArrayList<String> arrayList) {
        this.Z2 = arrayList;
    }

    public int w(long j2) {
        View x = x(j2);
        if (x == null) {
            return -1;
        }
        return getPositionForView(x);
    }

    public View x(long j2) {
        int firstVisiblePosition = getFirstVisiblePosition();
        StableArrayAdapter stableArrayAdapter = (StableArrayAdapter) getAdapter();
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (stableArrayAdapter.getItemId(firstVisiblePosition + i2) == j2) {
                return childAt;
            }
        }
        return null;
    }

    public DynamicListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        B(context);
    }

    public DynamicListView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        B(context);
    }
}
