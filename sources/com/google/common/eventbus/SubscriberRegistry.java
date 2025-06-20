package com.google.common.eventbus;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.primitives.Primitives;
import com.google.common.reflect.TypeToken;
import com.google.common.util.concurrent.UncheckedExecutionException;
import com.google.j2objc.annotations.Weak;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArraySet;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
final class SubscriberRegistry {

    /* renamed from: c  reason: collision with root package name */
    private static final LoadingCache<Class<?>, ImmutableList<Method>> f22571c = CacheBuilder.D().M().b(new CacheLoader<Class<?>, ImmutableList<Method>>() {
        /* renamed from: g */
        public ImmutableList<Method> d(Class<?> cls) throws Exception {
            return SubscriberRegistry.e(cls);
        }
    });

    /* renamed from: d  reason: collision with root package name */
    private static final LoadingCache<Class<?>, ImmutableSet<Class<?>>> f22572d = CacheBuilder.D().M().b(new CacheLoader<Class<?>, ImmutableSet<Class<?>>>() {
        /* renamed from: g */
        public ImmutableSet<Class<?>> d(Class<?> cls) {
            return ImmutableSet.C(TypeToken.T(cls).D().L1());
        }
    });

    /* renamed from: a  reason: collision with root package name */
    private final ConcurrentMap<Class<?>, CopyOnWriteArraySet<Subscriber>> f22573a = Maps.V();
    @Weak

    /* renamed from: b  reason: collision with root package name */
    private final EventBus f22574b;

    private static final class MethodIdentifier {

        /* renamed from: a  reason: collision with root package name */
        private final String f22575a;

        /* renamed from: b  reason: collision with root package name */
        private final List<Class<?>> f22576b;

        MethodIdentifier(Method method) {
            this.f22575a = method.getName();
            this.f22576b = Arrays.asList(method.getParameterTypes());
        }

        public boolean equals(@CheckForNull Object obj) {
            if (!(obj instanceof MethodIdentifier)) {
                return false;
            }
            MethodIdentifier methodIdentifier = (MethodIdentifier) obj;
            return this.f22575a.equals(methodIdentifier.f22575a) && this.f22576b.equals(methodIdentifier.f22576b);
        }

        public int hashCode() {
            return Objects.b(this.f22575a, this.f22576b);
        }
    }

    SubscriberRegistry(EventBus eventBus) {
        this.f22574b = (EventBus) Preconditions.E(eventBus);
    }

    private Multimap<Class<?>, Subscriber> b(Object obj) {
        HashMultimap J = HashMultimap.J();
        UnmodifiableIterator<Method> k2 = d(obj.getClass()).iterator();
        while (k2.hasNext()) {
            Method next = k2.next();
            J.put(next.getParameterTypes()[0], Subscriber.c(this.f22574b, obj, next));
        }
        return J;
    }

    @VisibleForTesting
    static ImmutableSet<Class<?>> c(Class<?> cls) {
        try {
            return f22572d.H(cls);
        } catch (UncheckedExecutionException e2) {
            throw Throwables.q(e2.getCause());
        }
    }

    private static ImmutableList<Method> d(Class<?> cls) {
        try {
            return f22571c.H(cls);
        } catch (UncheckedExecutionException e2) {
            Throwables.w(e2.getCause());
            throw e2;
        }
    }

    /* access modifiers changed from: private */
    public static ImmutableList<Method> e(Class<?> cls) {
        Set<Class> L1 = TypeToken.T(cls).D().L1();
        HashMap Y = Maps.Y();
        for (Class declaredMethods : L1) {
            for (Method method : declaredMethods.getDeclaredMethods()) {
                if (method.isAnnotationPresent(Subscribe.class) && !method.isSynthetic()) {
                    Class[] parameterTypes = method.getParameterTypes();
                    Preconditions.w(parameterTypes.length == 1, "Method %s has @Subscribe annotation but has %s parameters. Subscriber methods must have exactly 1 parameter.", method, parameterTypes.length);
                    Preconditions.z(!parameterTypes[0].isPrimitive(), "@Subscribe method %s's parameter is %s. Subscriber methods cannot accept primitives. Consider changing the parameter to %s.", method, parameterTypes[0].getName(), Primitives.f(parameterTypes[0]).getSimpleName());
                    MethodIdentifier methodIdentifier = new MethodIdentifier(method);
                    if (!Y.containsKey(methodIdentifier)) {
                        Y.put(methodIdentifier, method);
                    }
                }
            }
        }
        return ImmutableList.B(Y.values());
    }

    /* access modifiers changed from: package-private */
    public Iterator<Subscriber> f(Object obj) {
        ImmutableSet<Class<?>> c2 = c(obj.getClass());
        ArrayList u = Lists.u(c2.size());
        UnmodifiableIterator<Class<?>> k2 = c2.iterator();
        while (k2.hasNext()) {
            CopyOnWriteArraySet copyOnWriteArraySet = this.f22573a.get(k2.next());
            if (copyOnWriteArraySet != null) {
                u.add(copyOnWriteArraySet.iterator());
            }
        }
        return Iterators.i(u.iterator());
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public Set<Subscriber> g(Class<?> cls) {
        return (Set) MoreObjects.a(this.f22573a.get(cls), ImmutableSet.K());
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: java.util.concurrent.CopyOnWriteArraySet} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void h(java.lang.Object r5) {
        /*
            r4 = this;
            com.google.common.collect.Multimap r5 = r4.b(r5)
            java.util.Map r5 = r5.g()
            java.util.Set r5 = r5.entrySet()
            java.util.Iterator r5 = r5.iterator()
        L_0x0010:
            boolean r0 = r5.hasNext()
            if (r0 == 0) goto L_0x004a
            java.lang.Object r0 = r5.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            java.lang.Object r1 = r0.getKey()
            java.lang.Class r1 = (java.lang.Class) r1
            java.lang.Object r0 = r0.getValue()
            java.util.Collection r0 = (java.util.Collection) r0
            java.util.concurrent.ConcurrentMap<java.lang.Class<?>, java.util.concurrent.CopyOnWriteArraySet<com.google.common.eventbus.Subscriber>> r2 = r4.f22573a
            java.lang.Object r2 = r2.get(r1)
            java.util.concurrent.CopyOnWriteArraySet r2 = (java.util.concurrent.CopyOnWriteArraySet) r2
            if (r2 != 0) goto L_0x0046
            java.util.concurrent.CopyOnWriteArraySet r2 = new java.util.concurrent.CopyOnWriteArraySet
            r2.<init>()
            java.util.concurrent.ConcurrentMap<java.lang.Class<?>, java.util.concurrent.CopyOnWriteArraySet<com.google.common.eventbus.Subscriber>> r3 = r4.f22573a
            java.lang.Object r1 = r3.putIfAbsent(r1, r2)
            java.util.concurrent.CopyOnWriteArraySet r1 = (java.util.concurrent.CopyOnWriteArraySet) r1
            java.lang.Object r1 = com.google.common.base.MoreObjects.a(r1, r2)
            r2 = r1
            java.util.concurrent.CopyOnWriteArraySet r2 = (java.util.concurrent.CopyOnWriteArraySet) r2
        L_0x0046:
            r2.addAll(r0)
            goto L_0x0010
        L_0x004a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.eventbus.SubscriberRegistry.h(java.lang.Object):void");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:3:0x0016  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void i(java.lang.Object r5) {
        /*
            r4 = this;
            com.google.common.collect.Multimap r0 = r4.b(r5)
            java.util.Map r0 = r0.g()
            java.util.Set r0 = r0.entrySet()
            java.util.Iterator r0 = r0.iterator()
        L_0x0010:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0055
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r2 = r1.getKey()
            java.lang.Class r2 = (java.lang.Class) r2
            java.lang.Object r1 = r1.getValue()
            java.util.Collection r1 = (java.util.Collection) r1
            java.util.concurrent.ConcurrentMap<java.lang.Class<?>, java.util.concurrent.CopyOnWriteArraySet<com.google.common.eventbus.Subscriber>> r3 = r4.f22573a
            java.lang.Object r2 = r3.get(r2)
            java.util.concurrent.CopyOnWriteArraySet r2 = (java.util.concurrent.CopyOnWriteArraySet) r2
            if (r2 == 0) goto L_0x0039
            boolean r1 = r2.removeAll(r1)
            if (r1 == 0) goto L_0x0039
            goto L_0x0010
        L_0x0039:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "missing event subscriber for an annotated method. Is "
            r1.append(r2)
            r1.append(r5)
            java.lang.String r5 = " registered?"
            r1.append(r5)
            java.lang.String r5 = r1.toString()
            r0.<init>(r5)
            throw r0
        L_0x0055:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.eventbus.SubscriberRegistry.i(java.lang.Object):void");
    }
}
