package androidx.transition;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

@SuppressLint({"ViewConstructor"})
class GhostViewPort extends ViewGroup implements GhostView {
    View X2;
    final View Y2;
    int Z2;
    @Nullable
    private Matrix a3;
    private final ViewTreeObserver.OnPreDrawListener b3 = new ViewTreeObserver.OnPreDrawListener() {
        public boolean onPreDraw() {
            View view;
            GhostViewPort.this.postInvalidateOnAnimation();
            GhostViewPort ghostViewPort = GhostViewPort.this;
            ViewGroup viewGroup = ghostViewPort.s;
            if (viewGroup == null || (view = ghostViewPort.X2) == null) {
                return true;
            }
            viewGroup.endViewTransition(view);
            GhostViewPort.this.s.postInvalidateOnAnimation();
            GhostViewPort ghostViewPort2 = GhostViewPort.this;
            ghostViewPort2.s = null;
            ghostViewPort2.X2 = null;
            return true;
        }
    };
    ViewGroup s;

    GhostViewPort(View view) {
        super(view.getContext());
        this.Y2 = view;
        setWillNotDraw(false);
        setClipChildren(false);
        setLayerType(2, (Paint) null);
    }

    static GhostViewPort b(View view, ViewGroup viewGroup, Matrix matrix) {
        int i2;
        GhostViewHolder ghostViewHolder;
        if (view.getParent() instanceof ViewGroup) {
            GhostViewHolder b2 = GhostViewHolder.b(viewGroup);
            GhostViewPort e2 = e(view);
            if (e2 == null || (ghostViewHolder = (GhostViewHolder) e2.getParent()) == b2) {
                i2 = 0;
            } else {
                i2 = e2.Z2;
                ghostViewHolder.removeView(e2);
                e2 = null;
            }
            if (e2 == null) {
                if (matrix == null) {
                    matrix = new Matrix();
                    c(view, viewGroup, matrix);
                }
                e2 = new GhostViewPort(view);
                e2.h(matrix);
                if (b2 == null) {
                    b2 = new GhostViewHolder(viewGroup);
                } else {
                    b2.g();
                }
                d(viewGroup, b2);
                d(viewGroup, e2);
                b2.a(e2);
                e2.Z2 = i2;
            } else if (matrix != null) {
                e2.h(matrix);
            }
            e2.Z2++;
            return e2;
        }
        throw new IllegalArgumentException("Ghosted views must be parented by a ViewGroup");
    }

    static void c(View view, ViewGroup viewGroup, Matrix matrix) {
        ViewGroup viewGroup2 = (ViewGroup) view.getParent();
        matrix.reset();
        ViewUtils.h(viewGroup2, matrix);
        matrix.preTranslate((float) (-viewGroup2.getScrollX()), (float) (-viewGroup2.getScrollY()));
        ViewUtils.i(viewGroup, matrix);
    }

    static void d(View view, View view2) {
        ViewUtils.e(view2, view2.getLeft(), view2.getTop(), view2.getLeft() + view.getWidth(), view2.getTop() + view.getHeight());
    }

    static GhostViewPort e(View view) {
        return (GhostViewPort) view.getTag(R.id.f16012a);
    }

    static void f(View view) {
        GhostViewPort e2 = e(view);
        if (e2 != null) {
            int i2 = e2.Z2 - 1;
            e2.Z2 = i2;
            if (i2 <= 0) {
                ((GhostViewHolder) e2.getParent()).removeView(e2);
            }
        }
    }

    static void g(@NonNull View view, @Nullable GhostViewPort ghostViewPort) {
        view.setTag(R.id.f16012a, ghostViewPort);
    }

    public void a(ViewGroup viewGroup, View view) {
        this.s = viewGroup;
        this.X2 = view;
    }

    /* access modifiers changed from: package-private */
    public void h(@NonNull Matrix matrix) {
        this.a3 = matrix;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        g(this.Y2, this);
        this.Y2.getViewTreeObserver().addOnPreDrawListener(this.b3);
        ViewUtils.g(this.Y2, 4);
        if (this.Y2.getParent() != null) {
            ((View) this.Y2.getParent()).invalidate();
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        this.Y2.getViewTreeObserver().removeOnPreDrawListener(this.b3);
        ViewUtils.g(this.Y2, 0);
        g(this.Y2, (GhostViewPort) null);
        if (this.Y2.getParent() != null) {
            ((View) this.Y2.getParent()).invalidate();
        }
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public void onDraw(@NonNull Canvas canvas) {
        CanvasUtils.a(canvas, true);
        canvas.setMatrix(this.a3);
        ViewUtils.g(this.Y2, 0);
        this.Y2.invalidate();
        ViewUtils.g(this.Y2, 4);
        drawChild(canvas, this.Y2, getDrawingTime());
        CanvasUtils.a(canvas, false);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
    }

    public void setVisibility(int i2) {
        super.setVisibility(i2);
        if (e(this.Y2) == this) {
            ViewUtils.g(this.Y2, i2 == 0 ? 4 : 0);
        }
    }
}
