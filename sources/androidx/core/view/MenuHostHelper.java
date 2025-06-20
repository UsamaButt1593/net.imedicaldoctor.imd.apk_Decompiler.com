package androidx.core.view;

import android.annotation.SuppressLint;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public class MenuHostHelper {

    /* renamed from: a  reason: collision with root package name */
    private final Runnable f6428a;

    /* renamed from: b  reason: collision with root package name */
    private final CopyOnWriteArrayList<MenuProvider> f6429b = new CopyOnWriteArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    private final Map<MenuProvider, LifecycleContainer> f6430c = new HashMap();

    private static class LifecycleContainer {

        /* renamed from: a  reason: collision with root package name */
        final Lifecycle f6431a;

        /* renamed from: b  reason: collision with root package name */
        private LifecycleEventObserver f6432b;

        LifecycleContainer(@NonNull Lifecycle lifecycle, @NonNull LifecycleEventObserver lifecycleEventObserver) {
            this.f6431a = lifecycle;
            this.f6432b = lifecycleEventObserver;
            lifecycle.a(lifecycleEventObserver);
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.f6431a.d(this.f6432b);
            this.f6432b = null;
        }
    }

    public MenuHostHelper(@NonNull Runnable runnable) {
        this.f6428a = runnable;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void f(MenuProvider menuProvider, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        if (event == Lifecycle.Event.ON_DESTROY) {
            l(menuProvider);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void g(Lifecycle.State state, MenuProvider menuProvider, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        if (event == Lifecycle.Event.g(state)) {
            c(menuProvider);
        } else if (event == Lifecycle.Event.ON_DESTROY) {
            l(menuProvider);
        } else if (event == Lifecycle.Event.b(state)) {
            this.f6429b.remove(menuProvider);
            this.f6428a.run();
        }
    }

    public void c(@NonNull MenuProvider menuProvider) {
        this.f6429b.add(menuProvider);
        this.f6428a.run();
    }

    public void d(@NonNull MenuProvider menuProvider, @NonNull LifecycleOwner lifecycleOwner) {
        c(menuProvider);
        Lifecycle a2 = lifecycleOwner.a();
        LifecycleContainer remove = this.f6430c.remove(menuProvider);
        if (remove != null) {
            remove.a();
        }
        this.f6430c.put(menuProvider, new LifecycleContainer(a2, new C0130w(this, menuProvider)));
    }

    @SuppressLint({"LambdaLast"})
    public void e(@NonNull MenuProvider menuProvider, @NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.State state) {
        Lifecycle a2 = lifecycleOwner.a();
        LifecycleContainer remove = this.f6430c.remove(menuProvider);
        if (remove != null) {
            remove.a();
        }
        this.f6430c.put(menuProvider, new LifecycleContainer(a2, new C0128v(this, state, menuProvider)));
    }

    public void h(@NonNull Menu menu, @NonNull MenuInflater menuInflater) {
        Iterator<MenuProvider> it2 = this.f6429b.iterator();
        while (it2.hasNext()) {
            it2.next().c(menu, menuInflater);
        }
    }

    public void i(@NonNull Menu menu) {
        Iterator<MenuProvider> it2 = this.f6429b.iterator();
        while (it2.hasNext()) {
            it2.next().b(menu);
        }
    }

    public boolean j(@NonNull MenuItem menuItem) {
        Iterator<MenuProvider> it2 = this.f6429b.iterator();
        while (it2.hasNext()) {
            if (it2.next().a(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public void k(@NonNull Menu menu) {
        Iterator<MenuProvider> it2 = this.f6429b.iterator();
        while (it2.hasNext()) {
            it2.next().d(menu);
        }
    }

    public void l(@NonNull MenuProvider menuProvider) {
        this.f6429b.remove(menuProvider);
        LifecycleContainer remove = this.f6430c.remove(menuProvider);
        if (remove != null) {
            remove.a();
        }
        this.f6428a.run();
    }
}
