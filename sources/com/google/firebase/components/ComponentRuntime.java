package com.google.firebase.components;

import android.util.Log;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.lifecycle.g;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.firebase.dynamicloading.ComponentLoader;
import com.google.firebase.events.Publisher;
import com.google.firebase.events.Subscriber;
import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

public class ComponentRuntime implements ComponentContainer, ComponentLoader {

    /* renamed from: i  reason: collision with root package name */
    private static final Provider<Set<Object>> f23385i = new j();

    /* renamed from: a  reason: collision with root package name */
    private final Map<Component<?>, Provider<?>> f23386a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<Qualified<?>, Provider<?>> f23387b;

    /* renamed from: c  reason: collision with root package name */
    private final Map<Qualified<?>, LazySet<?>> f23388c;

    /* renamed from: d  reason: collision with root package name */
    private final List<Provider<ComponentRegistrar>> f23389d;

    /* renamed from: e  reason: collision with root package name */
    private Set<String> f23390e;

    /* renamed from: f  reason: collision with root package name */
    private final EventBus f23391f;

    /* renamed from: g  reason: collision with root package name */
    private final AtomicReference<Boolean> f23392g;

    /* renamed from: h  reason: collision with root package name */
    private final ComponentRegistrarProcessor f23393h;

    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private final Executor f23394a;

        /* renamed from: b  reason: collision with root package name */
        private final List<Provider<ComponentRegistrar>> f23395b = new ArrayList();

        /* renamed from: c  reason: collision with root package name */
        private final List<Component<?>> f23396c = new ArrayList();

        /* renamed from: d  reason: collision with root package name */
        private ComponentRegistrarProcessor f23397d = ComponentRegistrarProcessor.f23384a;

        Builder(Executor executor) {
            this.f23394a = executor;
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ ComponentRegistrar f(ComponentRegistrar componentRegistrar) {
            return componentRegistrar;
        }

        @CanIgnoreReturnValue
        public Builder b(Component<?> component) {
            this.f23396c.add(component);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder c(ComponentRegistrar componentRegistrar) {
            this.f23395b.add(new n(componentRegistrar));
            return this;
        }

        @CanIgnoreReturnValue
        public Builder d(Collection<Provider<ComponentRegistrar>> collection) {
            this.f23395b.addAll(collection);
            return this;
        }

        public ComponentRuntime e() {
            return new ComponentRuntime(this.f23394a, this.f23395b, this.f23396c, this.f23397d);
        }

        @CanIgnoreReturnValue
        public Builder g(ComponentRegistrarProcessor componentRegistrarProcessor) {
            this.f23397d = componentRegistrarProcessor;
            return this;
        }
    }

    private ComponentRuntime(Executor executor, Iterable<Provider<ComponentRegistrar>> iterable, Collection<Component<?>> collection, ComponentRegistrarProcessor componentRegistrarProcessor) {
        this.f23386a = new HashMap();
        this.f23387b = new HashMap();
        this.f23388c = new HashMap();
        this.f23390e = new HashSet();
        this.f23392g = new AtomicReference<>();
        EventBus eventBus = new EventBus(executor);
        this.f23391f = eventBus;
        this.f23393h = componentRegistrarProcessor;
        ArrayList arrayList = new ArrayList();
        arrayList.add(Component.D(eventBus, EventBus.class, Subscriber.class, Publisher.class));
        arrayList.add(Component.D(this, ComponentLoader.class, new Class[0]));
        for (Component next : collection) {
            if (next != null) {
                arrayList.add(next);
            }
        }
        this.f23389d = v(iterable);
        q(arrayList);
    }

    private void A() {
        Boolean bool = this.f23392g.get();
        if (bool != null) {
            r(this.f23386a, bool.booleanValue());
        }
    }

    private void B() {
        Map map;
        Qualified<?> d2;
        Object e2;
        for (Component next : this.f23386a.keySet()) {
            Iterator<Dependency> it2 = next.j().iterator();
            while (true) {
                if (it2.hasNext()) {
                    Dependency next2 = it2.next();
                    if (next2.h() && !this.f23388c.containsKey(next2.d())) {
                        map = this.f23388c;
                        d2 = next2.d();
                        e2 = LazySet.b(Collections.emptySet());
                    } else if (this.f23387b.containsKey(next2.d())) {
                        continue;
                    } else if (next2.g()) {
                        throw new MissingDependencyException(String.format("Unsatisfied dependency for component %s: %s", new Object[]{next, next2.d()}));
                    } else if (!next2.h()) {
                        map = this.f23387b;
                        d2 = next2.d();
                        e2 = OptionalProvider.e();
                    }
                    map.put(d2, e2);
                }
            }
        }
    }

    private List<Runnable> C(List<Component<?>> list) {
        ArrayList arrayList = new ArrayList();
        for (Component next : list) {
            if (next.v()) {
                Provider provider = this.f23386a.get(next);
                for (Qualified qualified : next.m()) {
                    if (!this.f23387b.containsKey(qualified)) {
                        this.f23387b.put(qualified, provider);
                    } else {
                        arrayList.add(new l((OptionalProvider) this.f23387b.get(qualified), provider));
                    }
                }
            }
        }
        return arrayList;
    }

    private List<Runnable> D() {
        ArrayList arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
        for (Map.Entry next : this.f23386a.entrySet()) {
            Component component = (Component) next.getKey();
            if (!component.v()) {
                Provider provider = (Provider) next.getValue();
                for (Qualified qualified : component.m()) {
                    if (!hashMap.containsKey(qualified)) {
                        hashMap.put(qualified, new HashSet());
                    }
                    ((Set) hashMap.get(qualified)).add(provider);
                }
            }
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            if (!this.f23388c.containsKey(entry.getKey())) {
                this.f23388c.put((Qualified) entry.getKey(), LazySet.b((Collection) entry.getValue()));
            } else {
                LazySet lazySet = this.f23388c.get(entry.getKey());
                for (Provider mVar : (Set) entry.getValue()) {
                    arrayList.add(new m(lazySet, mVar));
                }
            }
        }
        return arrayList;
    }

    private static Iterable<Provider<ComponentRegistrar>> E(Iterable<ComponentRegistrar> iterable) {
        ArrayList arrayList = new ArrayList();
        for (ComponentRegistrar iVar : iterable) {
            arrayList.add(new i(iVar));
        }
        return arrayList;
    }

    public static Builder p(Executor executor) {
        return new Builder(executor);
    }

    private void q(List<Component<?>> list) {
        ArrayList<Runnable> arrayList = new ArrayList<>();
        synchronized (this) {
            Iterator<Provider<ComponentRegistrar>> it2 = this.f23389d.iterator();
            while (it2.hasNext()) {
                try {
                    ComponentRegistrar componentRegistrar = (ComponentRegistrar) it2.next().get();
                    if (componentRegistrar != null) {
                        list.addAll(this.f23393h.a(componentRegistrar));
                        it2.remove();
                    }
                } catch (InvalidRegistrarException e2) {
                    it2.remove();
                    Log.w("ComponentDiscovery", "Invalid component registrar.", e2);
                }
            }
            Iterator<Component<?>> it3 = list.iterator();
            while (it3.hasNext()) {
                Object[] array = it3.next().m().toArray();
                int length = array.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    }
                    Object obj = array[i2];
                    if (obj.toString().contains("kotlinx.coroutines.CoroutineDispatcher")) {
                        if (this.f23390e.contains(obj.toString())) {
                            it3.remove();
                            break;
                        }
                        this.f23390e.add(obj.toString());
                    }
                    i2++;
                }
            }
            if (this.f23386a.isEmpty()) {
                CycleDetector.a(list);
            } else {
                ArrayList arrayList2 = new ArrayList(this.f23386a.keySet());
                arrayList2.addAll(list);
                CycleDetector.a(arrayList2);
            }
            for (Component next : list) {
                this.f23386a.put(next, new Lazy(new k(this, next)));
            }
            arrayList.addAll(C(list));
            arrayList.addAll(D());
            B();
        }
        for (Runnable run : arrayList) {
            run.run();
        }
        A();
    }

    private void r(Map<Component<?>, Provider<?>> map, boolean z) {
        for (Map.Entry next : map.entrySet()) {
            Component component = (Component) next.getKey();
            Provider provider = (Provider) next.getValue();
            if (component.s() || (component.t() && z)) {
                provider.get();
            }
        }
        this.f23391f.f();
    }

    private static <T> List<T> v(Iterable<T> iterable) {
        ArrayList arrayList = new ArrayList();
        for (T add : iterable) {
            arrayList.add(add);
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object w(Component component) {
        return component.k().a(new RestrictedComponentContainer(component, this));
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ ComponentRegistrar z(ComponentRegistrar componentRegistrar) {
        return componentRegistrar;
    }

    public /* synthetic */ Object a(Class cls) {
        return f.b(this, cls);
    }

    public synchronized <T> Provider<T> b(Qualified<T> qualified) {
        Preconditions.c(qualified, "Null interface requested.");
        return this.f23387b.get(qualified);
    }

    public /* synthetic */ Provider c(Class cls) {
        return f.d(this, cls);
    }

    public void d() {
        synchronized (this) {
            try {
                if (!this.f23389d.isEmpty()) {
                    q(new ArrayList());
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
    }

    public /* synthetic */ Provider e(Class cls) {
        return f.g(this, cls);
    }

    public /* synthetic */ Set f(Qualified qualified) {
        return f.e(this, qualified);
    }

    public synchronized <T> Provider<Set<T>> g(Qualified<T> qualified) {
        LazySet lazySet = this.f23388c.get(qualified);
        if (lazySet != null) {
            return lazySet;
        }
        return f23385i;
    }

    public /* synthetic */ Object h(Qualified qualified) {
        return f.a(this, qualified);
    }

    public /* synthetic */ Set i(Class cls) {
        return f.f(this, cls);
    }

    public <T> Deferred<T> j(Qualified<T> qualified) {
        Provider<T> b2 = b(qualified);
        if (b2 == null) {
            return OptionalProvider.e();
        }
        return b2 instanceof OptionalProvider ? (OptionalProvider) b2 : OptionalProvider.i(b2);
    }

    public /* synthetic */ Deferred k(Class cls) {
        return f.c(this, cls);
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public Collection<Component<?>> s() {
        return this.f23386a.keySet();
    }

    @VisibleForTesting
    @RestrictTo({RestrictTo.Scope.TESTS})
    public void t() {
        for (Provider<?> provider : this.f23386a.values()) {
            provider.get();
        }
    }

    public void u(boolean z) {
        HashMap hashMap;
        if (g.a(this.f23392g, (Object) null, Boolean.valueOf(z))) {
            synchronized (this) {
                hashMap = new HashMap(this.f23386a);
            }
            r(hashMap, z);
        }
    }

    @Deprecated
    public ComponentRuntime(Executor executor, Iterable<ComponentRegistrar> iterable, Component<?>... componentArr) {
        this(executor, E(iterable), Arrays.asList(componentArr), ComponentRegistrarProcessor.f23384a);
    }
}
