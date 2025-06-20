package androidx.appcompat.view;

import android.view.View;
import android.view.animation.Interpolator;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;
import java.util.ArrayList;
import java.util.Iterator;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class ViewPropertyAnimatorCompatSet {

    /* renamed from: a  reason: collision with root package name */
    final ArrayList<ViewPropertyAnimatorCompat> f2946a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private long f2947b = -1;

    /* renamed from: c  reason: collision with root package name */
    private Interpolator f2948c;

    /* renamed from: d  reason: collision with root package name */
    ViewPropertyAnimatorListener f2949d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f2950e;

    /* renamed from: f  reason: collision with root package name */
    private final ViewPropertyAnimatorListenerAdapter f2951f = new ViewPropertyAnimatorListenerAdapter() {

        /* renamed from: a  reason: collision with root package name */
        private boolean f2952a = false;

        /* renamed from: b  reason: collision with root package name */
        private int f2953b = 0;

        public void b(View view) {
            int i2 = this.f2953b + 1;
            this.f2953b = i2;
            if (i2 == ViewPropertyAnimatorCompatSet.this.f2946a.size()) {
                ViewPropertyAnimatorListener viewPropertyAnimatorListener = ViewPropertyAnimatorCompatSet.this.f2949d;
                if (viewPropertyAnimatorListener != null) {
                    viewPropertyAnimatorListener.b((View) null);
                }
                d();
            }
        }

        public void c(View view) {
            if (!this.f2952a) {
                this.f2952a = true;
                ViewPropertyAnimatorListener viewPropertyAnimatorListener = ViewPropertyAnimatorCompatSet.this.f2949d;
                if (viewPropertyAnimatorListener != null) {
                    viewPropertyAnimatorListener.c((View) null);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void d() {
            this.f2953b = 0;
            this.f2952a = false;
            ViewPropertyAnimatorCompatSet.this.b();
        }
    };

    public void a() {
        if (this.f2950e) {
            Iterator<ViewPropertyAnimatorCompat> it2 = this.f2946a.iterator();
            while (it2.hasNext()) {
                it2.next().d();
            }
            this.f2950e = false;
        }
    }

    /* access modifiers changed from: package-private */
    public void b() {
        this.f2950e = false;
    }

    public ViewPropertyAnimatorCompatSet c(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat) {
        if (!this.f2950e) {
            this.f2946a.add(viewPropertyAnimatorCompat);
        }
        return this;
    }

    public ViewPropertyAnimatorCompatSet d(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2) {
        this.f2946a.add(viewPropertyAnimatorCompat);
        viewPropertyAnimatorCompat2.w(viewPropertyAnimatorCompat.e());
        this.f2946a.add(viewPropertyAnimatorCompat2);
        return this;
    }

    public ViewPropertyAnimatorCompatSet e(long j2) {
        if (!this.f2950e) {
            this.f2947b = j2;
        }
        return this;
    }

    public ViewPropertyAnimatorCompatSet f(Interpolator interpolator) {
        if (!this.f2950e) {
            this.f2948c = interpolator;
        }
        return this;
    }

    public ViewPropertyAnimatorCompatSet g(ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
        if (!this.f2950e) {
            this.f2949d = viewPropertyAnimatorListener;
        }
        return this;
    }

    public void h() {
        if (!this.f2950e) {
            Iterator<ViewPropertyAnimatorCompat> it2 = this.f2946a.iterator();
            while (it2.hasNext()) {
                ViewPropertyAnimatorCompat next = it2.next();
                long j2 = this.f2947b;
                if (j2 >= 0) {
                    next.s(j2);
                }
                Interpolator interpolator = this.f2948c;
                if (interpolator != null) {
                    next.t(interpolator);
                }
                if (this.f2949d != null) {
                    next.u(this.f2951f);
                }
                next.y();
            }
            this.f2950e = true;
        }
    }
}
