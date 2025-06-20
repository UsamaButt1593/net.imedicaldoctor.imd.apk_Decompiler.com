package androidx.appcompat.widget;

import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityManager;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewConfigurationCompat;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
class TooltipCompatHandler implements View.OnLongClickListener, View.OnHoverListener, View.OnAttachStateChangeListener {
    private static final String d3 = "TooltipCompatHandler";
    private static final long e3 = 2500;
    private static final long f3 = 15000;
    private static final long g3 = 3000;
    private static TooltipCompatHandler h3;
    private static TooltipCompatHandler i3;
    private final CharSequence X;
    private final Runnable X2 = new X(this);
    private final int Y;
    private int Y2;
    private final Runnable Z = new W(this);
    private int Z2;
    private TooltipPopup a3;
    private boolean b3;
    private boolean c3;
    private final View s;

    private TooltipCompatHandler(View view, CharSequence charSequence) {
        this.s = view;
        this.X = charSequence;
        this.Y = ViewConfigurationCompat.g(ViewConfiguration.get(view.getContext()));
        c();
        view.setOnLongClickListener(this);
        view.setOnHoverListener(this);
    }

    private void b() {
        this.s.removeCallbacks(this.Z);
    }

    private void c() {
        this.c3 = true;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void e() {
        i(false);
    }

    private void f() {
        this.s.postDelayed(this.Z, (long) ViewConfiguration.getLongPressTimeout());
    }

    private static void g(TooltipCompatHandler tooltipCompatHandler) {
        TooltipCompatHandler tooltipCompatHandler2 = h3;
        if (tooltipCompatHandler2 != null) {
            tooltipCompatHandler2.b();
        }
        h3 = tooltipCompatHandler;
        if (tooltipCompatHandler != null) {
            tooltipCompatHandler.f();
        }
    }

    public static void h(View view, CharSequence charSequence) {
        TooltipCompatHandler tooltipCompatHandler = h3;
        if (tooltipCompatHandler != null && tooltipCompatHandler.s == view) {
            g((TooltipCompatHandler) null);
        }
        if (TextUtils.isEmpty(charSequence)) {
            TooltipCompatHandler tooltipCompatHandler2 = i3;
            if (tooltipCompatHandler2 != null && tooltipCompatHandler2.s == view) {
                tooltipCompatHandler2.d();
            }
            view.setOnLongClickListener((View.OnLongClickListener) null);
            view.setLongClickable(false);
            view.setOnHoverListener((View.OnHoverListener) null);
            return;
        }
        new TooltipCompatHandler(view, charSequence);
    }

    private boolean j(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (!this.c3 && Math.abs(x - this.Y2) <= this.Y && Math.abs(y - this.Z2) <= this.Y) {
            return false;
        }
        this.Y2 = x;
        this.Z2 = y;
        this.c3 = false;
        return true;
    }

    /* access modifiers changed from: package-private */
    public void d() {
        if (i3 == this) {
            i3 = null;
            TooltipPopup tooltipPopup = this.a3;
            if (tooltipPopup != null) {
                tooltipPopup.c();
                this.a3 = null;
                c();
                this.s.removeOnAttachStateChangeListener(this);
            } else {
                Log.e(d3, "sActiveHandler.mPopup == null");
            }
        }
        if (h3 == this) {
            g((TooltipCompatHandler) null);
        }
        this.s.removeCallbacks(this.X2);
    }

    /* access modifiers changed from: package-private */
    public void i(boolean z) {
        long j2;
        long longPressTimeout;
        long j3;
        if (this.s.isAttachedToWindow()) {
            g((TooltipCompatHandler) null);
            TooltipCompatHandler tooltipCompatHandler = i3;
            if (tooltipCompatHandler != null) {
                tooltipCompatHandler.d();
            }
            i3 = this;
            this.b3 = z;
            TooltipPopup tooltipPopup = new TooltipPopup(this.s.getContext());
            this.a3 = tooltipPopup;
            tooltipPopup.e(this.s, this.Y2, this.Z2, this.b3, this.X);
            this.s.addOnAttachStateChangeListener(this);
            if (this.b3) {
                j2 = e3;
            } else {
                if ((ViewCompat.F0(this.s) & 1) == 1) {
                    longPressTimeout = (long) ViewConfiguration.getLongPressTimeout();
                    j3 = 3000;
                } else {
                    longPressTimeout = (long) ViewConfiguration.getLongPressTimeout();
                    j3 = 15000;
                }
                j2 = j3 - longPressTimeout;
            }
            this.s.removeCallbacks(this.X2);
            this.s.postDelayed(this.X2, j2);
        }
    }

    public boolean onHover(View view, MotionEvent motionEvent) {
        if (this.a3 != null && this.b3) {
            return false;
        }
        AccessibilityManager accessibilityManager = (AccessibilityManager) this.s.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 7) {
            if (action == 10) {
                c();
                d();
            }
        } else if (this.s.isEnabled() && this.a3 == null && j(motionEvent)) {
            g(this);
        }
        return false;
    }

    public boolean onLongClick(View view) {
        this.Y2 = view.getWidth() / 2;
        this.Z2 = view.getHeight() / 2;
        i(true);
        return true;
    }

    public void onViewAttachedToWindow(View view) {
    }

    public void onViewDetachedFromWindow(View view) {
        d();
    }
}
