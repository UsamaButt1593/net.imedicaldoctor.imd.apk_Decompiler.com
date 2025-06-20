package com.google.android.material.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

class ViewOverlayApi14 implements ViewOverlayImpl {

    /* renamed from: a  reason: collision with root package name */
    protected OverlayViewGroup f21580a;

    @SuppressLint({"ViewConstructor", "PrivateApi"})
    static class OverlayViewGroup extends ViewGroup {
        static Method b3;
        View X2;
        ArrayList<Drawable> Y2 = null;
        ViewOverlayApi14 Z2;
        private boolean a3;
        ViewGroup s;

        static {
            Class<ViewGroup> cls = ViewGroup.class;
            try {
                Class cls2 = Integer.TYPE;
                b3 = cls.getDeclaredMethod("invalidateChildInParentFast", new Class[]{cls2, cls2, Rect.class});
            } catch (NoSuchMethodException unused) {
            }
        }

        OverlayViewGroup(Context context, ViewGroup viewGroup, View view, ViewOverlayApi14 viewOverlayApi14) {
            super(context);
            this.s = viewGroup;
            this.X2 = view;
            setRight(viewGroup.getWidth());
            setBottom(viewGroup.getHeight());
            viewGroup.addView(this);
            this.Z2 = viewOverlayApi14;
        }

        private void c() {
            if (this.a3) {
                throw new IllegalStateException("This overlay was disposed already. Please use a new one via ViewGroupUtils.getOverlay()");
            }
        }

        private void d() {
            if (getChildCount() == 0) {
                ArrayList<Drawable> arrayList = this.Y2;
                if (arrayList == null || arrayList.size() == 0) {
                    this.a3 = true;
                    this.s.removeView(this);
                }
            }
        }

        private void e(int[] iArr) {
            int[] iArr2 = new int[2];
            int[] iArr3 = new int[2];
            this.s.getLocationOnScreen(iArr2);
            this.X2.getLocationOnScreen(iArr3);
            iArr[0] = iArr3[0] - iArr2[0];
            iArr[1] = iArr3[1] - iArr2[1];
        }

        public void a(Drawable drawable) {
            c();
            if (this.Y2 == null) {
                this.Y2 = new ArrayList<>();
            }
            if (!this.Y2.contains(drawable)) {
                this.Y2.add(drawable);
                invalidate(drawable.getBounds());
                drawable.setCallback(this);
            }
        }

        public void b(View view) {
            c();
            if (view.getParent() instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                if (!(viewGroup == this.s || viewGroup.getParent() == null || !ViewCompat.R0(viewGroup))) {
                    int[] iArr = new int[2];
                    int[] iArr2 = new int[2];
                    viewGroup.getLocationOnScreen(iArr);
                    this.s.getLocationOnScreen(iArr2);
                    ViewCompat.i1(view, iArr[0] - iArr2[0]);
                    ViewCompat.j1(view, iArr[1] - iArr2[1]);
                }
                viewGroup.removeView(view);
                if (view.getParent() != null) {
                    viewGroup.removeView(view);
                }
            }
            super.addView(view);
        }

        /* access modifiers changed from: protected */
        public void dispatchDraw(Canvas canvas) {
            int[] iArr = new int[2];
            int[] iArr2 = new int[2];
            this.s.getLocationOnScreen(iArr);
            this.X2.getLocationOnScreen(iArr2);
            canvas.translate((float) (iArr2[0] - iArr[0]), (float) (iArr2[1] - iArr[1]));
            canvas.clipRect(new Rect(0, 0, this.X2.getWidth(), this.X2.getHeight()));
            super.dispatchDraw(canvas);
            ArrayList<Drawable> arrayList = this.Y2;
            int size = arrayList == null ? 0 : arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.Y2.get(i2).draw(canvas);
            }
        }

        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            return false;
        }

        /* access modifiers changed from: protected */
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public ViewParent f(int i2, int i3, Rect rect) {
            if (this.s == null || b3 == null) {
                return null;
            }
            try {
                e(new int[2]);
                b3.invoke(this.s, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), rect});
                return null;
            } catch (IllegalAccessException | InvocationTargetException e2) {
                e2.printStackTrace();
                return null;
            }
        }

        public void g(Drawable drawable) {
            ArrayList<Drawable> arrayList = this.Y2;
            if (arrayList != null) {
                arrayList.remove(drawable);
                invalidate(drawable.getBounds());
                drawable.setCallback((Drawable.Callback) null);
                d();
            }
        }

        public void h(View view) {
            super.removeView(view);
            d();
        }

        public ViewParent invalidateChildInParent(int[] iArr, Rect rect) {
            if (this.s == null) {
                return null;
            }
            rect.offset(iArr[0], iArr[1]);
            if (this.s != null) {
                iArr[0] = 0;
                iArr[1] = 0;
                int[] iArr2 = new int[2];
                e(iArr2);
                rect.offset(iArr2[0], iArr2[1]);
                return super.invalidateChildInParent(iArr, rect);
            }
            invalidate(rect);
            return null;
        }

        public void invalidateDrawable(@NonNull Drawable drawable) {
            invalidate(drawable.getBounds());
        }

        /* access modifiers changed from: protected */
        public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
            r0 = r1.Y2;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean verifyDrawable(@androidx.annotation.NonNull android.graphics.drawable.Drawable r2) {
            /*
                r1 = this;
                boolean r0 = super.verifyDrawable(r2)
                if (r0 != 0) goto L_0x0013
                java.util.ArrayList<android.graphics.drawable.Drawable> r0 = r1.Y2
                if (r0 == 0) goto L_0x0011
                boolean r2 = r0.contains(r2)
                if (r2 == 0) goto L_0x0011
                goto L_0x0013
            L_0x0011:
                r2 = 0
                goto L_0x0014
            L_0x0013:
                r2 = 1
            L_0x0014:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.internal.ViewOverlayApi14.OverlayViewGroup.verifyDrawable(android.graphics.drawable.Drawable):boolean");
        }
    }

    ViewOverlayApi14(Context context, ViewGroup viewGroup, View view) {
        this.f21580a = new OverlayViewGroup(context, viewGroup, view, this);
    }

    static ViewOverlayApi14 e(View view) {
        ViewGroup l2 = ViewUtils.l(view);
        if (l2 == null) {
            return null;
        }
        int childCount = l2.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = l2.getChildAt(i2);
            if (childAt instanceof OverlayViewGroup) {
                return ((OverlayViewGroup) childAt).Z2;
            }
        }
        return new ViewGroupOverlayApi14(l2.getContext(), l2, view);
    }

    public void a(@NonNull Drawable drawable) {
        this.f21580a.a(drawable);
    }

    public void b(@NonNull Drawable drawable) {
        this.f21580a.g(drawable);
    }
}
