package androidx.activity.result;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityOptionsCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.random.Random;

public abstract class ActivityResultRegistry {

    /* renamed from: h  reason: collision with root package name */
    private static final String f2466h = "KEY_COMPONENT_ACTIVITY_REGISTERED_RCS";

    /* renamed from: i  reason: collision with root package name */
    private static final String f2467i = "KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS";

    /* renamed from: j  reason: collision with root package name */
    private static final String f2468j = "KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS";

    /* renamed from: k  reason: collision with root package name */
    private static final String f2469k = "KEY_COMPONENT_ACTIVITY_PENDING_RESULT";

    /* renamed from: l  reason: collision with root package name */
    private static final String f2470l = "ActivityResultRegistry";

    /* renamed from: m  reason: collision with root package name */
    private static final int f2471m = 65536;

    /* renamed from: a  reason: collision with root package name */
    private final Map<Integer, String> f2472a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    final Map<String, Integer> f2473b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, LifecycleContainer> f2474c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    ArrayList<String> f2475d = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    final transient Map<String, CallbackAndContract<?>> f2476e = new HashMap();

    /* renamed from: f  reason: collision with root package name */
    final Map<String, Object> f2477f = new HashMap();

    /* renamed from: g  reason: collision with root package name */
    final Bundle f2478g = new Bundle();

    private static class CallbackAndContract<O> {

        /* renamed from: a  reason: collision with root package name */
        final ActivityResultCallback<O> f2485a;

        /* renamed from: b  reason: collision with root package name */
        final ActivityResultContract<?, O> f2486b;

        CallbackAndContract(ActivityResultCallback<O> activityResultCallback, ActivityResultContract<?, O> activityResultContract) {
            this.f2485a = activityResultCallback;
            this.f2486b = activityResultContract;
        }
    }

    private static class LifecycleContainer {

        /* renamed from: a  reason: collision with root package name */
        final Lifecycle f2487a;

        /* renamed from: b  reason: collision with root package name */
        private final ArrayList<LifecycleEventObserver> f2488b = new ArrayList<>();

        LifecycleContainer(@NonNull Lifecycle lifecycle) {
            this.f2487a = lifecycle;
        }

        /* access modifiers changed from: package-private */
        public void a(@NonNull LifecycleEventObserver lifecycleEventObserver) {
            this.f2487a.a(lifecycleEventObserver);
            this.f2488b.add(lifecycleEventObserver);
        }

        /* access modifiers changed from: package-private */
        public void b() {
            Iterator<LifecycleEventObserver> it2 = this.f2488b.iterator();
            while (it2.hasNext()) {
                this.f2487a.d(it2.next());
            }
            this.f2488b.clear();
        }
    }

    private void a(int i2, String str) {
        this.f2472a.put(Integer.valueOf(i2), str);
        this.f2473b.put(str, Integer.valueOf(i2));
    }

    private <O> void d(String str, int i2, @Nullable Intent intent, @Nullable CallbackAndContract<O> callbackAndContract) {
        if (callbackAndContract == null || callbackAndContract.f2485a == null || !this.f2475d.contains(str)) {
            this.f2477f.remove(str);
            this.f2478g.putParcelable(str, new ActivityResult(i2, intent));
            return;
        }
        callbackAndContract.f2485a.a(callbackAndContract.f2486b.c(i2, intent));
        this.f2475d.remove(str);
    }

    private int e() {
        int m2 = Random.s.m(2147418112);
        while (true) {
            int i2 = m2 + 65536;
            if (!this.f2472a.containsKey(Integer.valueOf(i2))) {
                return i2;
            }
            m2 = Random.s.m(2147418112);
        }
    }

    private void k(String str) {
        if (this.f2473b.get(str) == null) {
            a(e(), str);
        }
    }

    @MainThread
    public final boolean b(int i2, int i3, @Nullable Intent intent) {
        String str = this.f2472a.get(Integer.valueOf(i2));
        if (str == null) {
            return false;
        }
        d(str, i3, intent, this.f2476e.get(str));
        return true;
    }

    @MainThread
    public final <O> boolean c(int i2, @SuppressLint({"UnknownNullness"}) O o) {
        ActivityResultCallback<O> activityResultCallback;
        String str = this.f2472a.get(Integer.valueOf(i2));
        if (str == null) {
            return false;
        }
        CallbackAndContract callbackAndContract = this.f2476e.get(str);
        if (callbackAndContract == null || (activityResultCallback = callbackAndContract.f2485a) == null) {
            this.f2478g.remove(str);
            this.f2477f.put(str, o);
            return true;
        } else if (!this.f2475d.remove(str)) {
            return true;
        } else {
            activityResultCallback.a(o);
            return true;
        }
    }

    @MainThread
    public abstract <I, O> void f(int i2, @NonNull ActivityResultContract<I, O> activityResultContract, @SuppressLint({"UnknownNullness"}) I i3, @Nullable ActivityOptionsCompat activityOptionsCompat);

    public final void g(@Nullable Bundle bundle) {
        if (bundle != null) {
            ArrayList<Integer> integerArrayList = bundle.getIntegerArrayList(f2466h);
            ArrayList<String> stringArrayList = bundle.getStringArrayList(f2467i);
            if (stringArrayList != null && integerArrayList != null) {
                this.f2475d = bundle.getStringArrayList(f2468j);
                this.f2478g.putAll(bundle.getBundle(f2469k));
                for (int i2 = 0; i2 < stringArrayList.size(); i2++) {
                    String str = stringArrayList.get(i2);
                    if (this.f2473b.containsKey(str)) {
                        Integer remove = this.f2473b.remove(str);
                        if (!this.f2478g.containsKey(str)) {
                            this.f2472a.remove(remove);
                        }
                    }
                    a(integerArrayList.get(i2).intValue(), stringArrayList.get(i2));
                }
            }
        }
    }

    public final void h(@NonNull Bundle bundle) {
        bundle.putIntegerArrayList(f2466h, new ArrayList(this.f2473b.values()));
        bundle.putStringArrayList(f2467i, new ArrayList(this.f2473b.keySet()));
        bundle.putStringArrayList(f2468j, new ArrayList(this.f2475d));
        bundle.putBundle(f2469k, (Bundle) this.f2478g.clone());
    }

    @NonNull
    public final <I, O> ActivityResultLauncher<I> i(@NonNull final String str, @NonNull final ActivityResultContract<I, O> activityResultContract, @NonNull ActivityResultCallback<O> activityResultCallback) {
        k(str);
        this.f2476e.put(str, new CallbackAndContract(activityResultCallback, activityResultContract));
        if (this.f2477f.containsKey(str)) {
            Object obj = this.f2477f.get(str);
            this.f2477f.remove(str);
            activityResultCallback.a(obj);
        }
        ActivityResult activityResult = (ActivityResult) this.f2478g.getParcelable(str);
        if (activityResult != null) {
            this.f2478g.remove(str);
            activityResultCallback.a(activityResultContract.c(activityResult.b(), activityResult.a()));
        }
        return new ActivityResultLauncher<I>() {
            @NonNull
            public ActivityResultContract<I, ?> a() {
                return activityResultContract;
            }

            public void c(I i2, @Nullable ActivityOptionsCompat activityOptionsCompat) {
                Integer num = ActivityResultRegistry.this.f2473b.get(str);
                if (num != null) {
                    ActivityResultRegistry.this.f2475d.add(str);
                    try {
                        ActivityResultRegistry.this.f(num.intValue(), activityResultContract, i2, activityOptionsCompat);
                    } catch (Exception e2) {
                        ActivityResultRegistry.this.f2475d.remove(str);
                        throw e2;
                    }
                } else {
                    throw new IllegalStateException("Attempting to launch an unregistered ActivityResultLauncher with contract " + activityResultContract + " and input " + i2 + ". You must ensure the ActivityResultLauncher is registered before calling launch().");
                }
            }

            public void d() {
                ActivityResultRegistry.this.l(str);
            }
        };
    }

    @NonNull
    public final <I, O> ActivityResultLauncher<I> j(@NonNull final String str, @NonNull LifecycleOwner lifecycleOwner, @NonNull final ActivityResultContract<I, O> activityResultContract, @NonNull final ActivityResultCallback<O> activityResultCallback) {
        Lifecycle a2 = lifecycleOwner.a();
        if (!a2.b().b(Lifecycle.State.STARTED)) {
            k(str);
            LifecycleContainer lifecycleContainer = this.f2474c.get(str);
            if (lifecycleContainer == null) {
                lifecycleContainer = new LifecycleContainer(a2);
            }
            lifecycleContainer.a(new LifecycleEventObserver() {
                public void d(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.Event event) {
                    if (Lifecycle.Event.ON_START.equals(event)) {
                        ActivityResultRegistry.this.f2476e.put(str, new CallbackAndContract(activityResultCallback, activityResultContract));
                        if (ActivityResultRegistry.this.f2477f.containsKey(str)) {
                            Object obj = ActivityResultRegistry.this.f2477f.get(str);
                            ActivityResultRegistry.this.f2477f.remove(str);
                            activityResultCallback.a(obj);
                        }
                        ActivityResult activityResult = (ActivityResult) ActivityResultRegistry.this.f2478g.getParcelable(str);
                        if (activityResult != null) {
                            ActivityResultRegistry.this.f2478g.remove(str);
                            activityResultCallback.a(activityResultContract.c(activityResult.b(), activityResult.a()));
                        }
                    } else if (Lifecycle.Event.ON_STOP.equals(event)) {
                        ActivityResultRegistry.this.f2476e.remove(str);
                    } else if (Lifecycle.Event.ON_DESTROY.equals(event)) {
                        ActivityResultRegistry.this.l(str);
                    }
                }
            });
            this.f2474c.put(str, lifecycleContainer);
            return new ActivityResultLauncher<I>() {
                @NonNull
                public ActivityResultContract<I, ?> a() {
                    return activityResultContract;
                }

                public void c(I i2, @Nullable ActivityOptionsCompat activityOptionsCompat) {
                    Integer num = ActivityResultRegistry.this.f2473b.get(str);
                    if (num != null) {
                        ActivityResultRegistry.this.f2475d.add(str);
                        try {
                            ActivityResultRegistry.this.f(num.intValue(), activityResultContract, i2, activityOptionsCompat);
                        } catch (Exception e2) {
                            ActivityResultRegistry.this.f2475d.remove(str);
                            throw e2;
                        }
                    } else {
                        throw new IllegalStateException("Attempting to launch an unregistered ActivityResultLauncher with contract " + activityResultContract + " and input " + i2 + ". You must ensure the ActivityResultLauncher is registered before calling launch().");
                    }
                }

                public void d() {
                    ActivityResultRegistry.this.l(str);
                }
            };
        }
        throw new IllegalStateException("LifecycleOwner " + lifecycleOwner + " is attempting to register while current state is " + a2.b() + ". LifecycleOwners must call register before they are STARTED.");
    }

    /* access modifiers changed from: package-private */
    @MainThread
    public final void l(@NonNull String str) {
        Integer remove;
        if (!this.f2475d.contains(str) && (remove = this.f2473b.remove(str)) != null) {
            this.f2472a.remove(remove);
        }
        this.f2476e.remove(str);
        if (this.f2477f.containsKey(str)) {
            Log.w(f2470l, "Dropping pending result for request " + str + ": " + this.f2477f.get(str));
            this.f2477f.remove(str);
        }
        if (this.f2478g.containsKey(str)) {
            Log.w(f2470l, "Dropping pending result for request " + str + ": " + this.f2478g.getParcelable(str));
            this.f2478g.remove(str);
        }
        LifecycleContainer lifecycleContainer = this.f2474c.get(str);
        if (lifecycleContainer != null) {
            lifecycleContainer.b();
            this.f2474c.remove(str);
        }
    }
}
