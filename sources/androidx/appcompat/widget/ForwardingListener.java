package androidx.appcompat.widget;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.ShowableListMenu;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public abstract class ForwardingListener implements View.OnTouchListener, View.OnAttachStateChangeListener {
    private final int X;
    private Runnable X2;
    private final int Y;
    private Runnable Y2;
    final View Z;
    private boolean Z2;
    private int a3;
    private final int[] b3 = new int[2];
    private final float s;

    private class DisallowIntercept implements Runnable {
        DisallowIntercept() {
        }

        public void run() {
            ViewParent parent = ForwardingListener.this.Z.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }
    }

    private class TriggerLongPress implements Runnable {
        TriggerLongPress() {
        }

        public void run() {
            ForwardingListener.this.e();
        }
    }

    public ForwardingListener(View view) {
        this.Z = view;
        view.setLongClickable(true);
        view.addOnAttachStateChangeListener(this);
        this.s = (float) ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        int tapTimeout = ViewConfiguration.getTapTimeout();
        this.X = tapTimeout;
        this.Y = (tapTimeout + ViewConfiguration.getLongPressTimeout()) / 2;
    }

    private void a() {
        Runnable runnable = this.Y2;
        if (runnable != null) {
            this.Z.removeCallbacks(runnable);
        }
        Runnable runnable2 = this.X2;
        if (runnable2 != null) {
            this.Z.removeCallbacks(runnable2);
        }
    }

    private boolean f(MotionEvent motionEvent) {
        DropDownListView dropDownListView;
        View view = this.Z;
        ShowableListMenu b2 = b();
        if (b2 == null || !b2.b() || (dropDownListView = (DropDownListView) b2.k()) == null || !dropDownListView.isShown()) {
            return false;
        }
        MotionEvent obtainNoHistory = MotionEvent.obtainNoHistory(motionEvent);
        i(view, obtainNoHistory);
        j(dropDownListView, obtainNoHistory);
        boolean f2 = dropDownListView.f(obtainNoHistory, this.a3);
        obtainNoHistory.recycle();
        int actionMasked = motionEvent.getActionMasked();
        return f2 && (actionMasked != 1 && actionMasked != 3);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0017, code lost:
        if (r1 != 3) goto L_0x006d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean g(android.view.MotionEvent r6) {
        /*
            r5 = this;
            android.view.View r0 = r5.Z
            boolean r1 = r0.isEnabled()
            r2 = 0
            if (r1 != 0) goto L_0x000a
            return r2
        L_0x000a:
            int r1 = r6.getActionMasked()
            if (r1 == 0) goto L_0x0041
            r3 = 1
            if (r1 == r3) goto L_0x003d
            r4 = 2
            if (r1 == r4) goto L_0x001a
            r6 = 3
            if (r1 == r6) goto L_0x003d
            goto L_0x006d
        L_0x001a:
            int r1 = r5.a3
            int r1 = r6.findPointerIndex(r1)
            if (r1 < 0) goto L_0x006d
            float r4 = r6.getX(r1)
            float r6 = r6.getY(r1)
            float r1 = r5.s
            boolean r6 = h(r0, r4, r6, r1)
            if (r6 != 0) goto L_0x006d
            r5.a()
            android.view.ViewParent r6 = r0.getParent()
            r6.requestDisallowInterceptTouchEvent(r3)
            return r3
        L_0x003d:
            r5.a()
            goto L_0x006d
        L_0x0041:
            int r6 = r6.getPointerId(r2)
            r5.a3 = r6
            java.lang.Runnable r6 = r5.X2
            if (r6 != 0) goto L_0x0052
            androidx.appcompat.widget.ForwardingListener$DisallowIntercept r6 = new androidx.appcompat.widget.ForwardingListener$DisallowIntercept
            r6.<init>()
            r5.X2 = r6
        L_0x0052:
            java.lang.Runnable r6 = r5.X2
            int r1 = r5.X
            long r3 = (long) r1
            r0.postDelayed(r6, r3)
            java.lang.Runnable r6 = r5.Y2
            if (r6 != 0) goto L_0x0065
            androidx.appcompat.widget.ForwardingListener$TriggerLongPress r6 = new androidx.appcompat.widget.ForwardingListener$TriggerLongPress
            r6.<init>()
            r5.Y2 = r6
        L_0x0065:
            java.lang.Runnable r6 = r5.Y2
            int r1 = r5.Y
            long r3 = (long) r1
            r0.postDelayed(r6, r3)
        L_0x006d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ForwardingListener.g(android.view.MotionEvent):boolean");
    }

    private static boolean h(View view, float f2, float f3, float f4) {
        float f5 = -f4;
        return f2 >= f5 && f3 >= f5 && f2 < ((float) (view.getRight() - view.getLeft())) + f4 && f3 < ((float) (view.getBottom() - view.getTop())) + f4;
    }

    private boolean i(View view, MotionEvent motionEvent) {
        int[] iArr = this.b3;
        view.getLocationOnScreen(iArr);
        motionEvent.offsetLocation((float) iArr[0], (float) iArr[1]);
        return true;
    }

    private boolean j(View view, MotionEvent motionEvent) {
        int[] iArr = this.b3;
        view.getLocationOnScreen(iArr);
        motionEvent.offsetLocation((float) (-iArr[0]), (float) (-iArr[1]));
        return true;
    }

    public abstract ShowableListMenu b();

    /* access modifiers changed from: protected */
    public boolean c() {
        ShowableListMenu b2 = b();
        if (b2 == null || b2.b()) {
            return true;
        }
        b2.a();
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean d() {
        ShowableListMenu b2 = b();
        if (b2 == null || !b2.b()) {
            return true;
        }
        b2.dismiss();
        return true;
    }

    /* access modifiers changed from: package-private */
    public void e() {
        a();
        View view = this.Z;
        if (view.isEnabled() && !view.isLongClickable() && c()) {
            view.getParent().requestDisallowInterceptTouchEvent(true);
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
            view.onTouchEvent(obtain);
            obtain.recycle();
            this.Z2 = true;
        }
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z;
        boolean z2 = this.Z2;
        if (z2) {
            z = f(motionEvent) || !d();
        } else {
            z = g(motionEvent) && c();
            if (z) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                this.Z.onTouchEvent(obtain);
                obtain.recycle();
            }
        }
        this.Z2 = z;
        return z || z2;
    }

    public void onViewAttachedToWindow(View view) {
    }

    public void onViewDetachedFromWindow(View view) {
        this.Z2 = false;
        this.a3 = -1;
        Runnable runnable = this.X2;
        if (runnable != null) {
            this.Z.removeCallbacks(runnable);
        }
    }
}
