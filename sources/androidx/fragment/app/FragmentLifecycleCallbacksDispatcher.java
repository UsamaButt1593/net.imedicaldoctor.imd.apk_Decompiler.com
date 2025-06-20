package androidx.fragment.app;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

class FragmentLifecycleCallbacksDispatcher {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final CopyOnWriteArrayList<FragmentLifecycleCallbacksHolder> f7903a = new CopyOnWriteArrayList<>();
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final FragmentManager f7904b;

    private static final class FragmentLifecycleCallbacksHolder {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        final FragmentManager.FragmentLifecycleCallbacks f7905a;

        /* renamed from: b  reason: collision with root package name */
        final boolean f7906b;

        FragmentLifecycleCallbacksHolder(@NonNull FragmentManager.FragmentLifecycleCallbacks fragmentLifecycleCallbacks, boolean z) {
            this.f7905a = fragmentLifecycleCallbacks;
            this.f7906b = z;
        }
    }

    FragmentLifecycleCallbacksDispatcher(@NonNull FragmentManager fragmentManager) {
        this.f7904b = fragmentManager;
    }

    /* access modifiers changed from: package-private */
    public void a(@NonNull Fragment fragment, @Nullable Bundle bundle, boolean z) {
        Fragment M0 = this.f7904b.M0();
        if (M0 != null) {
            M0.V().L0().a(fragment, bundle, true);
        }
        Iterator<FragmentLifecycleCallbacksHolder> it2 = this.f7903a.iterator();
        while (it2.hasNext()) {
            FragmentLifecycleCallbacksHolder next = it2.next();
            if (!z || next.f7906b) {
                next.f7905a.a(this.f7904b, fragment, bundle);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void b(@NonNull Fragment fragment, boolean z) {
        Context m2 = this.f7904b.J0().m();
        Fragment M0 = this.f7904b.M0();
        if (M0 != null) {
            M0.V().L0().b(fragment, true);
        }
        Iterator<FragmentLifecycleCallbacksHolder> it2 = this.f7903a.iterator();
        while (it2.hasNext()) {
            FragmentLifecycleCallbacksHolder next = it2.next();
            if (!z || next.f7906b) {
                next.f7905a.b(this.f7904b, fragment, m2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void c(@NonNull Fragment fragment, @Nullable Bundle bundle, boolean z) {
        Fragment M0 = this.f7904b.M0();
        if (M0 != null) {
            M0.V().L0().c(fragment, bundle, true);
        }
        Iterator<FragmentLifecycleCallbacksHolder> it2 = this.f7903a.iterator();
        while (it2.hasNext()) {
            FragmentLifecycleCallbacksHolder next = it2.next();
            if (!z || next.f7906b) {
                next.f7905a.c(this.f7904b, fragment, bundle);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void d(@NonNull Fragment fragment, boolean z) {
        Fragment M0 = this.f7904b.M0();
        if (M0 != null) {
            M0.V().L0().d(fragment, true);
        }
        Iterator<FragmentLifecycleCallbacksHolder> it2 = this.f7903a.iterator();
        while (it2.hasNext()) {
            FragmentLifecycleCallbacksHolder next = it2.next();
            if (!z || next.f7906b) {
                next.f7905a.d(this.f7904b, fragment);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void e(@NonNull Fragment fragment, boolean z) {
        Fragment M0 = this.f7904b.M0();
        if (M0 != null) {
            M0.V().L0().e(fragment, true);
        }
        Iterator<FragmentLifecycleCallbacksHolder> it2 = this.f7903a.iterator();
        while (it2.hasNext()) {
            FragmentLifecycleCallbacksHolder next = it2.next();
            if (!z || next.f7906b) {
                next.f7905a.e(this.f7904b, fragment);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void f(@NonNull Fragment fragment, boolean z) {
        Fragment M0 = this.f7904b.M0();
        if (M0 != null) {
            M0.V().L0().f(fragment, true);
        }
        Iterator<FragmentLifecycleCallbacksHolder> it2 = this.f7903a.iterator();
        while (it2.hasNext()) {
            FragmentLifecycleCallbacksHolder next = it2.next();
            if (!z || next.f7906b) {
                next.f7905a.f(this.f7904b, fragment);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void g(@NonNull Fragment fragment, boolean z) {
        Context m2 = this.f7904b.J0().m();
        Fragment M0 = this.f7904b.M0();
        if (M0 != null) {
            M0.V().L0().g(fragment, true);
        }
        Iterator<FragmentLifecycleCallbacksHolder> it2 = this.f7903a.iterator();
        while (it2.hasNext()) {
            FragmentLifecycleCallbacksHolder next = it2.next();
            if (!z || next.f7906b) {
                next.f7905a.g(this.f7904b, fragment, m2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void h(@NonNull Fragment fragment, @Nullable Bundle bundle, boolean z) {
        Fragment M0 = this.f7904b.M0();
        if (M0 != null) {
            M0.V().L0().h(fragment, bundle, true);
        }
        Iterator<FragmentLifecycleCallbacksHolder> it2 = this.f7903a.iterator();
        while (it2.hasNext()) {
            FragmentLifecycleCallbacksHolder next = it2.next();
            if (!z || next.f7906b) {
                next.f7905a.h(this.f7904b, fragment, bundle);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void i(@NonNull Fragment fragment, boolean z) {
        Fragment M0 = this.f7904b.M0();
        if (M0 != null) {
            M0.V().L0().i(fragment, true);
        }
        Iterator<FragmentLifecycleCallbacksHolder> it2 = this.f7903a.iterator();
        while (it2.hasNext()) {
            FragmentLifecycleCallbacksHolder next = it2.next();
            if (!z || next.f7906b) {
                next.f7905a.i(this.f7904b, fragment);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void j(@NonNull Fragment fragment, @NonNull Bundle bundle, boolean z) {
        Fragment M0 = this.f7904b.M0();
        if (M0 != null) {
            M0.V().L0().j(fragment, bundle, true);
        }
        Iterator<FragmentLifecycleCallbacksHolder> it2 = this.f7903a.iterator();
        while (it2.hasNext()) {
            FragmentLifecycleCallbacksHolder next = it2.next();
            if (!z || next.f7906b) {
                next.f7905a.j(this.f7904b, fragment, bundle);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void k(@NonNull Fragment fragment, boolean z) {
        Fragment M0 = this.f7904b.M0();
        if (M0 != null) {
            M0.V().L0().k(fragment, true);
        }
        Iterator<FragmentLifecycleCallbacksHolder> it2 = this.f7903a.iterator();
        while (it2.hasNext()) {
            FragmentLifecycleCallbacksHolder next = it2.next();
            if (!z || next.f7906b) {
                next.f7905a.k(this.f7904b, fragment);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void l(@NonNull Fragment fragment, boolean z) {
        Fragment M0 = this.f7904b.M0();
        if (M0 != null) {
            M0.V().L0().l(fragment, true);
        }
        Iterator<FragmentLifecycleCallbacksHolder> it2 = this.f7903a.iterator();
        while (it2.hasNext()) {
            FragmentLifecycleCallbacksHolder next = it2.next();
            if (!z || next.f7906b) {
                next.f7905a.l(this.f7904b, fragment);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void m(@NonNull Fragment fragment, @NonNull View view, @Nullable Bundle bundle, boolean z) {
        Fragment M0 = this.f7904b.M0();
        if (M0 != null) {
            M0.V().L0().m(fragment, view, bundle, true);
        }
        Iterator<FragmentLifecycleCallbacksHolder> it2 = this.f7903a.iterator();
        while (it2.hasNext()) {
            FragmentLifecycleCallbacksHolder next = it2.next();
            if (!z || next.f7906b) {
                next.f7905a.m(this.f7904b, fragment, view, bundle);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void n(@NonNull Fragment fragment, boolean z) {
        Fragment M0 = this.f7904b.M0();
        if (M0 != null) {
            M0.V().L0().n(fragment, true);
        }
        Iterator<FragmentLifecycleCallbacksHolder> it2 = this.f7903a.iterator();
        while (it2.hasNext()) {
            FragmentLifecycleCallbacksHolder next = it2.next();
            if (!z || next.f7906b) {
                next.f7905a.n(this.f7904b, fragment);
            }
        }
    }

    public void o(@NonNull FragmentManager.FragmentLifecycleCallbacks fragmentLifecycleCallbacks, boolean z) {
        this.f7903a.add(new FragmentLifecycleCallbacksHolder(fragmentLifecycleCallbacks, z));
    }

    public void p(@NonNull FragmentManager.FragmentLifecycleCallbacks fragmentLifecycleCallbacks) {
        synchronized (this.f7903a) {
            try {
                int size = this.f7903a.size();
                int i2 = 0;
                while (true) {
                    if (i2 >= size) {
                        break;
                    } else if (this.f7903a.get(i2).f7905a == fragmentLifecycleCallbacks) {
                        this.f7903a.remove(i2);
                        break;
                    } else {
                        i2++;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
