package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.os.CancellationSignal;
import androidx.core.view.ViewCompat;
import androidx.fragment.R;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

abstract class SpecialEffectsController {

    /* renamed from: a  reason: collision with root package name */
    private final ViewGroup f8035a;

    /* renamed from: b  reason: collision with root package name */
    final ArrayList<Operation> f8036b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    final ArrayList<Operation> f8037c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    boolean f8038d = false;

    /* renamed from: e  reason: collision with root package name */
    boolean f8039e = false;

    /* renamed from: androidx.fragment.app.SpecialEffectsController$3  reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f8040a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f8041b;

        /* JADX WARNING: Can't wrap try/catch for region: R(17:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|15|16|17|18|19|20|22) */
        /* JADX WARNING: Can't wrap try/catch for region: R(19:0|1|2|3|5|6|7|9|10|11|13|14|15|16|17|18|19|20|22) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0039 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0043 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x004d */
        static {
            /*
                androidx.fragment.app.SpecialEffectsController$Operation$LifecycleImpact[] r0 = androidx.fragment.app.SpecialEffectsController.Operation.LifecycleImpact.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f8041b = r0
                r1 = 1
                androidx.fragment.app.SpecialEffectsController$Operation$LifecycleImpact r2 = androidx.fragment.app.SpecialEffectsController.Operation.LifecycleImpact.ADDING     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f8041b     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.fragment.app.SpecialEffectsController$Operation$LifecycleImpact r3 = androidx.fragment.app.SpecialEffectsController.Operation.LifecycleImpact.REMOVING     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = f8041b     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.fragment.app.SpecialEffectsController$Operation$LifecycleImpact r4 = androidx.fragment.app.SpecialEffectsController.Operation.LifecycleImpact.NONE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                androidx.fragment.app.SpecialEffectsController$Operation$State[] r3 = androidx.fragment.app.SpecialEffectsController.Operation.State.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                f8040a = r3
                androidx.fragment.app.SpecialEffectsController$Operation$State r4 = androidx.fragment.app.SpecialEffectsController.Operation.State.REMOVED     // Catch:{ NoSuchFieldError -> 0x0039 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0039 }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0039 }
            L_0x0039:
                int[] r1 = f8040a     // Catch:{ NoSuchFieldError -> 0x0043 }
                androidx.fragment.app.SpecialEffectsController$Operation$State r3 = androidx.fragment.app.SpecialEffectsController.Operation.State.VISIBLE     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r1[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                int[] r0 = f8040a     // Catch:{ NoSuchFieldError -> 0x004d }
                androidx.fragment.app.SpecialEffectsController$Operation$State r1 = androidx.fragment.app.SpecialEffectsController.Operation.State.GONE     // Catch:{ NoSuchFieldError -> 0x004d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004d }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004d }
            L_0x004d:
                int[] r0 = f8040a     // Catch:{ NoSuchFieldError -> 0x0058 }
                androidx.fragment.app.SpecialEffectsController$Operation$State r1 = androidx.fragment.app.SpecialEffectsController.Operation.State.INVISIBLE     // Catch:{ NoSuchFieldError -> 0x0058 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0058 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0058 }
            L_0x0058:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.SpecialEffectsController.AnonymousClass3.<clinit>():void");
        }
    }

    private static class FragmentStateManagerOperation extends Operation {
        @NonNull

        /* renamed from: h  reason: collision with root package name */
        private final FragmentStateManager f8042h;

        FragmentStateManagerOperation(@NonNull Operation.State state, @NonNull Operation.LifecycleImpact lifecycleImpact, @NonNull FragmentStateManager fragmentStateManager, @NonNull CancellationSignal cancellationSignal) {
            super(state, lifecycleImpact, fragmentStateManager.k(), cancellationSignal);
            this.f8042h = fragmentStateManager;
        }

        public void c() {
            super.c();
            this.f8042h.m();
        }

        /* access modifiers changed from: package-private */
        public void l() {
            if (g() == Operation.LifecycleImpact.ADDING) {
                Fragment k2 = this.f8042h.k();
                View findFocus = k2.B3.findFocus();
                if (findFocus != null) {
                    k2.n2(findFocus);
                    if (FragmentManager.W0(2)) {
                        Log.v(FragmentManager.Y, "requestFocus: Saved focused view " + findFocus + " for Fragment " + k2);
                    }
                }
                View b2 = f().b2();
                if (b2.getParent() == null) {
                    this.f8042h.b();
                    b2.setAlpha(0.0f);
                }
                if (b2.getAlpha() == 0.0f && b2.getVisibility() == 0) {
                    b2.setVisibility(4);
                }
                b2.setAlpha(k2.Z());
            } else if (g() == Operation.LifecycleImpact.REMOVING) {
                Fragment k3 = this.f8042h.k();
                View b22 = k3.b2();
                if (FragmentManager.W0(2)) {
                    Log.v(FragmentManager.Y, "Clearing focus " + b22.findFocus() + " on view " + b22 + " for Fragment " + k3);
                }
                b22.clearFocus();
            }
        }
    }

    static class Operation {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        private State f8043a;
        @NonNull

        /* renamed from: b  reason: collision with root package name */
        private LifecycleImpact f8044b;
        @NonNull

        /* renamed from: c  reason: collision with root package name */
        private final Fragment f8045c;
        @NonNull

        /* renamed from: d  reason: collision with root package name */
        private final List<Runnable> f8046d = new ArrayList();
        @NonNull

        /* renamed from: e  reason: collision with root package name */
        private final HashSet<CancellationSignal> f8047e = new HashSet<>();

        /* renamed from: f  reason: collision with root package name */
        private boolean f8048f = false;

        /* renamed from: g  reason: collision with root package name */
        private boolean f8049g = false;

        enum LifecycleImpact {
            NONE,
            ADDING,
            REMOVING
        }

        enum State {
            REMOVED,
            VISIBLE,
            GONE,
            INVISIBLE;

            @NonNull
            static State b(int i2) {
                if (i2 == 0) {
                    return VISIBLE;
                }
                if (i2 == 4) {
                    return INVISIBLE;
                }
                if (i2 == 8) {
                    return GONE;
                }
                throw new IllegalArgumentException("Unknown visibility " + i2);
            }

            @NonNull
            static State c(@NonNull View view) {
                return (view.getAlpha() == 0.0f && view.getVisibility() == 0) ? INVISIBLE : b(view.getVisibility());
            }

            /* access modifiers changed from: package-private */
            public void a(@NonNull View view) {
                int i2;
                int i3 = AnonymousClass3.f8040a[ordinal()];
                if (i3 != 1) {
                    if (i3 == 2) {
                        if (FragmentManager.W0(2)) {
                            Log.v(FragmentManager.Y, "SpecialEffectsController: Setting view " + view + " to VISIBLE");
                        }
                        i2 = 0;
                    } else if (i3 == 3) {
                        if (FragmentManager.W0(2)) {
                            Log.v(FragmentManager.Y, "SpecialEffectsController: Setting view " + view + " to GONE");
                        }
                        i2 = 8;
                    } else if (i3 == 4) {
                        if (FragmentManager.W0(2)) {
                            Log.v(FragmentManager.Y, "SpecialEffectsController: Setting view " + view + " to INVISIBLE");
                        }
                        view.setVisibility(4);
                        return;
                    } else {
                        return;
                    }
                    view.setVisibility(i2);
                    return;
                }
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                if (viewGroup != null) {
                    if (FragmentManager.W0(2)) {
                        Log.v(FragmentManager.Y, "SpecialEffectsController: Removing view " + view + " from container " + viewGroup);
                    }
                    viewGroup.removeView(view);
                }
            }
        }

        Operation(@NonNull State state, @NonNull LifecycleImpact lifecycleImpact, @NonNull Fragment fragment, @NonNull CancellationSignal cancellationSignal) {
            this.f8043a = state;
            this.f8044b = lifecycleImpact;
            this.f8045c = fragment;
            cancellationSignal.d(new CancellationSignal.OnCancelListener() {
                public void onCancel() {
                    Operation.this.b();
                }
            });
        }

        /* access modifiers changed from: package-private */
        public final void a(@NonNull Runnable runnable) {
            this.f8046d.add(runnable);
        }

        /* access modifiers changed from: package-private */
        public final void b() {
            if (!h()) {
                this.f8048f = true;
                if (this.f8047e.isEmpty()) {
                    c();
                    return;
                }
                Iterator it2 = new ArrayList(this.f8047e).iterator();
                while (it2.hasNext()) {
                    ((CancellationSignal) it2.next()).a();
                }
            }
        }

        @CallSuper
        public void c() {
            if (!this.f8049g) {
                if (FragmentManager.W0(2)) {
                    Log.v(FragmentManager.Y, "SpecialEffectsController: " + this + " has called complete.");
                }
                this.f8049g = true;
                for (Runnable run : this.f8046d) {
                    run.run();
                }
            }
        }

        public final void d(@NonNull CancellationSignal cancellationSignal) {
            if (this.f8047e.remove(cancellationSignal) && this.f8047e.isEmpty()) {
                c();
            }
        }

        @NonNull
        public State e() {
            return this.f8043a;
        }

        @NonNull
        public final Fragment f() {
            return this.f8045c;
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public LifecycleImpact g() {
            return this.f8044b;
        }

        /* access modifiers changed from: package-private */
        public final boolean h() {
            return this.f8048f;
        }

        /* access modifiers changed from: package-private */
        public final boolean i() {
            return this.f8049g;
        }

        public final void j(@NonNull CancellationSignal cancellationSignal) {
            l();
            this.f8047e.add(cancellationSignal);
        }

        /* access modifiers changed from: package-private */
        public final void k(@NonNull State state, @NonNull LifecycleImpact lifecycleImpact) {
            LifecycleImpact lifecycleImpact2;
            int i2 = AnonymousClass3.f8041b[lifecycleImpact.ordinal()];
            if (i2 != 1) {
                if (i2 == 2) {
                    if (FragmentManager.W0(2)) {
                        Log.v(FragmentManager.Y, "SpecialEffectsController: For fragment " + this.f8045c + " mFinalState = " + this.f8043a + " -> REMOVED. mLifecycleImpact  = " + this.f8044b + " to REMOVING.");
                    }
                    this.f8043a = State.REMOVED;
                    lifecycleImpact2 = LifecycleImpact.REMOVING;
                } else if (i2 == 3 && this.f8043a != State.REMOVED) {
                    if (FragmentManager.W0(2)) {
                        Log.v(FragmentManager.Y, "SpecialEffectsController: For fragment " + this.f8045c + " mFinalState = " + this.f8043a + " -> " + state + ". ");
                    }
                    this.f8043a = state;
                    return;
                } else {
                    return;
                }
            } else if (this.f8043a == State.REMOVED) {
                if (FragmentManager.W0(2)) {
                    Log.v(FragmentManager.Y, "SpecialEffectsController: For fragment " + this.f8045c + " mFinalState = REMOVED -> VISIBLE. mLifecycleImpact = " + this.f8044b + " to ADDING.");
                }
                this.f8043a = State.VISIBLE;
                lifecycleImpact2 = LifecycleImpact.ADDING;
            } else {
                return;
            }
            this.f8044b = lifecycleImpact2;
        }

        /* access modifiers changed from: package-private */
        public void l() {
        }

        @NonNull
        public String toString() {
            return "Operation " + "{" + Integer.toHexString(System.identityHashCode(this)) + "} " + "{" + "mFinalState = " + this.f8043a + "} " + "{" + "mLifecycleImpact = " + this.f8044b + "} " + "{" + "mFragment = " + this.f8045c + "}";
        }
    }

    SpecialEffectsController(@NonNull ViewGroup viewGroup) {
        this.f8035a = viewGroup;
    }

    private void a(@NonNull Operation.State state, @NonNull Operation.LifecycleImpact lifecycleImpact, @NonNull FragmentStateManager fragmentStateManager) {
        synchronized (this.f8036b) {
            try {
                CancellationSignal cancellationSignal = new CancellationSignal();
                Operation h2 = h(fragmentStateManager.k());
                if (h2 != null) {
                    h2.k(state, lifecycleImpact);
                    return;
                }
                final FragmentStateManagerOperation fragmentStateManagerOperation = new FragmentStateManagerOperation(state, lifecycleImpact, fragmentStateManager, cancellationSignal);
                this.f8036b.add(fragmentStateManagerOperation);
                fragmentStateManagerOperation.a(new Runnable() {
                    public void run() {
                        if (SpecialEffectsController.this.f8036b.contains(fragmentStateManagerOperation)) {
                            fragmentStateManagerOperation.e().a(fragmentStateManagerOperation.f().B3);
                        }
                    }
                });
                fragmentStateManagerOperation.a(new Runnable() {
                    public void run() {
                        SpecialEffectsController.this.f8036b.remove(fragmentStateManagerOperation);
                        SpecialEffectsController.this.f8037c.remove(fragmentStateManagerOperation);
                    }
                });
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Nullable
    private Operation h(@NonNull Fragment fragment) {
        Iterator<Operation> it2 = this.f8036b.iterator();
        while (it2.hasNext()) {
            Operation next = it2.next();
            if (next.f().equals(fragment) && !next.h()) {
                return next;
            }
        }
        return null;
    }

    @Nullable
    private Operation i(@NonNull Fragment fragment) {
        Iterator<Operation> it2 = this.f8037c.iterator();
        while (it2.hasNext()) {
            Operation next = it2.next();
            if (next.f().equals(fragment) && !next.h()) {
                return next;
            }
        }
        return null;
    }

    @NonNull
    static SpecialEffectsController n(@NonNull ViewGroup viewGroup, @NonNull FragmentManager fragmentManager) {
        return o(viewGroup, fragmentManager.O0());
    }

    @NonNull
    static SpecialEffectsController o(@NonNull ViewGroup viewGroup, @NonNull SpecialEffectsControllerFactory specialEffectsControllerFactory) {
        int i2 = R.id.f7840b;
        Object tag = viewGroup.getTag(i2);
        if (tag instanceof SpecialEffectsController) {
            return (SpecialEffectsController) tag;
        }
        SpecialEffectsController a2 = specialEffectsControllerFactory.a(viewGroup);
        viewGroup.setTag(i2, a2);
        return a2;
    }

    private void q() {
        Iterator<Operation> it2 = this.f8036b.iterator();
        while (it2.hasNext()) {
            Operation next = it2.next();
            if (next.g() == Operation.LifecycleImpact.ADDING) {
                next.k(Operation.State.b(next.f().b2().getVisibility()), Operation.LifecycleImpact.NONE);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void b(@NonNull Operation.State state, @NonNull FragmentStateManager fragmentStateManager) {
        if (FragmentManager.W0(2)) {
            Log.v(FragmentManager.Y, "SpecialEffectsController: Enqueuing add operation for fragment " + fragmentStateManager.k());
        }
        a(state, Operation.LifecycleImpact.ADDING, fragmentStateManager);
    }

    /* access modifiers changed from: package-private */
    public void c(@NonNull FragmentStateManager fragmentStateManager) {
        if (FragmentManager.W0(2)) {
            Log.v(FragmentManager.Y, "SpecialEffectsController: Enqueuing hide operation for fragment " + fragmentStateManager.k());
        }
        a(Operation.State.GONE, Operation.LifecycleImpact.NONE, fragmentStateManager);
    }

    /* access modifiers changed from: package-private */
    public void d(@NonNull FragmentStateManager fragmentStateManager) {
        if (FragmentManager.W0(2)) {
            Log.v(FragmentManager.Y, "SpecialEffectsController: Enqueuing remove operation for fragment " + fragmentStateManager.k());
        }
        a(Operation.State.REMOVED, Operation.LifecycleImpact.REMOVING, fragmentStateManager);
    }

    /* access modifiers changed from: package-private */
    public void e(@NonNull FragmentStateManager fragmentStateManager) {
        if (FragmentManager.W0(2)) {
            Log.v(FragmentManager.Y, "SpecialEffectsController: Enqueuing show operation for fragment " + fragmentStateManager.k());
        }
        a(Operation.State.VISIBLE, Operation.LifecycleImpact.NONE, fragmentStateManager);
    }

    /* access modifiers changed from: package-private */
    public abstract void f(@NonNull List<Operation> list, boolean z);

    /* access modifiers changed from: package-private */
    public void g() {
        if (!this.f8039e) {
            if (!ViewCompat.R0(this.f8035a)) {
                j();
                this.f8038d = false;
                return;
            }
            synchronized (this.f8036b) {
                try {
                    if (!this.f8036b.isEmpty()) {
                        ArrayList arrayList = new ArrayList(this.f8037c);
                        this.f8037c.clear();
                        Iterator it2 = arrayList.iterator();
                        while (it2.hasNext()) {
                            Operation operation = (Operation) it2.next();
                            if (FragmentManager.W0(2)) {
                                Log.v(FragmentManager.Y, "SpecialEffectsController: Cancelling operation " + operation);
                            }
                            operation.b();
                            if (!operation.i()) {
                                this.f8037c.add(operation);
                            }
                        }
                        q();
                        ArrayList arrayList2 = new ArrayList(this.f8036b);
                        this.f8036b.clear();
                        this.f8037c.addAll(arrayList2);
                        if (FragmentManager.W0(2)) {
                            Log.v(FragmentManager.Y, "SpecialEffectsController: Executing pending operations");
                        }
                        Iterator it3 = arrayList2.iterator();
                        while (it3.hasNext()) {
                            ((Operation) it3.next()).l();
                        }
                        f(arrayList2, this.f8038d);
                        this.f8038d = false;
                        if (FragmentManager.W0(2)) {
                            Log.v(FragmentManager.Y, "SpecialEffectsController: Finished executing pending operations");
                        }
                    }
                } finally {
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void j() {
        String str;
        String str2;
        if (FragmentManager.W0(2)) {
            Log.v(FragmentManager.Y, "SpecialEffectsController: Forcing all operations to complete");
        }
        boolean R0 = ViewCompat.R0(this.f8035a);
        synchronized (this.f8036b) {
            try {
                q();
                Iterator<Operation> it2 = this.f8036b.iterator();
                while (it2.hasNext()) {
                    it2.next().l();
                }
                Iterator it3 = new ArrayList(this.f8037c).iterator();
                while (it3.hasNext()) {
                    Operation operation = (Operation) it3.next();
                    if (FragmentManager.W0(2)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("SpecialEffectsController: ");
                        if (R0) {
                            str2 = "";
                        } else {
                            str2 = "Container " + this.f8035a + " is not attached to window. ";
                        }
                        sb.append(str2);
                        sb.append("Cancelling running operation ");
                        sb.append(operation);
                        Log.v(FragmentManager.Y, sb.toString());
                    }
                    operation.b();
                }
                Iterator it4 = new ArrayList(this.f8036b).iterator();
                while (it4.hasNext()) {
                    Operation operation2 = (Operation) it4.next();
                    if (FragmentManager.W0(2)) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("SpecialEffectsController: ");
                        if (R0) {
                            str = "";
                        } else {
                            str = "Container " + this.f8035a + " is not attached to window. ";
                        }
                        sb2.append(str);
                        sb2.append("Cancelling pending operation ");
                        sb2.append(operation2);
                        Log.v(FragmentManager.Y, sb2.toString());
                    }
                    operation2.b();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void k() {
        if (this.f8039e) {
            if (FragmentManager.W0(2)) {
                Log.v(FragmentManager.Y, "SpecialEffectsController: Forcing postponed operations");
            }
            this.f8039e = false;
            g();
        }
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public Operation.LifecycleImpact l(@NonNull FragmentStateManager fragmentStateManager) {
        Operation h2 = h(fragmentStateManager.k());
        Operation.LifecycleImpact g2 = h2 != null ? h2.g() : null;
        Operation i2 = i(fragmentStateManager.k());
        return (i2 == null || !(g2 == null || g2 == Operation.LifecycleImpact.NONE)) ? g2 : i2.g();
    }

    @NonNull
    public ViewGroup m() {
        return this.f8035a;
    }

    /* access modifiers changed from: package-private */
    public void p() {
        synchronized (this.f8036b) {
            try {
                q();
                this.f8039e = false;
                int size = this.f8036b.size() - 1;
                while (true) {
                    if (size < 0) {
                        break;
                    }
                    Operation operation = this.f8036b.get(size);
                    Operation.State c2 = Operation.State.c(operation.f().B3);
                    Operation.State e2 = operation.e();
                    Operation.State state = Operation.State.VISIBLE;
                    if (e2 == state && c2 != state) {
                        this.f8039e = operation.f().E0();
                        break;
                    }
                    size--;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void r(boolean z) {
        this.f8038d = z;
    }
}
