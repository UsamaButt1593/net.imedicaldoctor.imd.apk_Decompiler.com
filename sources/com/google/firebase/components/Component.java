package com.google.firebase.components;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class Component<T> {

    /* renamed from: a  reason: collision with root package name */
    private final String f23364a;

    /* renamed from: b  reason: collision with root package name */
    private final Set<Qualified<? super T>> f23365b;

    /* renamed from: c  reason: collision with root package name */
    private final Set<Dependency> f23366c;

    /* renamed from: d  reason: collision with root package name */
    private final int f23367d;

    /* renamed from: e  reason: collision with root package name */
    private final int f23368e;

    /* renamed from: f  reason: collision with root package name */
    private final ComponentFactory<T> f23369f;

    /* renamed from: g  reason: collision with root package name */
    private final Set<Class<?>> f23370g;

    private Component(@Nullable String str, Set<Qualified<? super T>> set, Set<Dependency> set2, int i2, int i3, ComponentFactory<T> componentFactory, Set<Class<?>> set3) {
        this.f23364a = str;
        this.f23365b = Collections.unmodifiableSet(set);
        this.f23366c = Collections.unmodifiableSet(set2);
        this.f23367d = i2;
        this.f23368e = i3;
        this.f23369f = componentFactory;
        this.f23370g = Collections.unmodifiableSet(set3);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Object A(Object obj, ComponentContainer componentContainer) {
        return obj;
    }

    @Deprecated
    public static <T> Component<T> B(Class<T> cls, T t) {
        return h(cls).f(new d(t)).d();
    }

    @SafeVarargs
    public static <T> Component<T> C(T t, Qualified<T> qualified, Qualified<? super T>... qualifiedArr) {
        return g(qualified, qualifiedArr).f(new a(t)).d();
    }

    @SafeVarargs
    public static <T> Component<T> D(T t, Class<T> cls, Class<? super T>... clsArr) {
        return i(cls, clsArr).f(new e(t)).d();
    }

    public static <T> Builder<T> f(Qualified<T> qualified) {
        return new Builder<>((Qualified) qualified, new Qualified[0]);
    }

    @SafeVarargs
    public static <T> Builder<T> g(Qualified<T> qualified, Qualified<? super T>... qualifiedArr) {
        return new Builder<>((Qualified) qualified, (Qualified[]) qualifiedArr);
    }

    public static <T> Builder<T> h(Class<T> cls) {
        return new Builder<>((Class) cls, new Class[0]);
    }

    @SafeVarargs
    public static <T> Builder<T> i(Class<T> cls, Class<? super T>... clsArr) {
        return new Builder<>((Class) cls, (Class[]) clsArr);
    }

    public static <T> Component<T> o(T t, Qualified<T> qualified) {
        return q(qualified).f(new b(t)).d();
    }

    public static <T> Component<T> p(T t, Class<T> cls) {
        return r(cls).f(new c(t)).d();
    }

    public static <T> Builder<T> q(Qualified<T> qualified) {
        return f(qualified).g();
    }

    public static <T> Builder<T> r(Class<T> cls) {
        return h(cls).g();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Object w(Object obj, ComponentContainer componentContainer) {
        return obj;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Object x(Object obj, ComponentContainer componentContainer) {
        return obj;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Object y(Object obj, ComponentContainer componentContainer) {
        return obj;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Object z(Object obj, ComponentContainer componentContainer) {
        return obj;
    }

    public Component<T> E(ComponentFactory<T> componentFactory) {
        return new Component(this.f23364a, this.f23365b, this.f23366c, this.f23367d, this.f23368e, componentFactory, this.f23370g);
    }

    public Set<Dependency> j() {
        return this.f23366c;
    }

    public ComponentFactory<T> k() {
        return this.f23369f;
    }

    @Nullable
    public String l() {
        return this.f23364a;
    }

    public Set<Qualified<? super T>> m() {
        return this.f23365b;
    }

    public Set<Class<?>> n() {
        return this.f23370g;
    }

    public boolean s() {
        return this.f23367d == 1;
    }

    public boolean t() {
        return this.f23367d == 2;
    }

    public String toString() {
        return "Component<" + Arrays.toString(this.f23365b.toArray()) + ">{" + this.f23367d + ", type=" + this.f23368e + ", deps=" + Arrays.toString(this.f23366c.toArray()) + "}";
    }

    public boolean u() {
        return this.f23367d == 0;
    }

    public boolean v() {
        return this.f23368e == 0;
    }

    public static class Builder<T> {

        /* renamed from: a  reason: collision with root package name */
        private String f23371a;

        /* renamed from: b  reason: collision with root package name */
        private final Set<Qualified<? super T>> f23372b;

        /* renamed from: c  reason: collision with root package name */
        private final Set<Dependency> f23373c;

        /* renamed from: d  reason: collision with root package name */
        private int f23374d;

        /* renamed from: e  reason: collision with root package name */
        private int f23375e;

        /* renamed from: f  reason: collision with root package name */
        private ComponentFactory<T> f23376f;

        /* renamed from: g  reason: collision with root package name */
        private final Set<Class<?>> f23377g;

        @SafeVarargs
        private Builder(Qualified<T> qualified, Qualified<? super T>... qualifiedArr) {
            this.f23371a = null;
            HashSet hashSet = new HashSet();
            this.f23372b = hashSet;
            this.f23373c = new HashSet();
            this.f23374d = 0;
            this.f23375e = 0;
            this.f23377g = new HashSet();
            Preconditions.c(qualified, "Null interface");
            hashSet.add(qualified);
            for (Qualified<? super T> c2 : qualifiedArr) {
                Preconditions.c(c2, "Null interface");
            }
            Collections.addAll(this.f23372b, qualifiedArr);
        }

        /* access modifiers changed from: private */
        @CanIgnoreReturnValue
        public Builder<T> g() {
            this.f23375e = 1;
            return this;
        }

        @CanIgnoreReturnValue
        private Builder<T> j(int i2) {
            Preconditions.d(this.f23374d == 0, "Instantiation type has already been set.");
            this.f23374d = i2;
            return this;
        }

        private void k(Qualified<?> qualified) {
            Preconditions.a(!this.f23372b.contains(qualified), "Components are not allowed to depend on interfaces they themselves provide.");
        }

        @CanIgnoreReturnValue
        public Builder<T> b(Dependency dependency) {
            Preconditions.c(dependency, "Null dependency");
            k(dependency.d());
            this.f23373c.add(dependency);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<T> c() {
            return j(1);
        }

        public Component<T> d() {
            Preconditions.d(this.f23376f != null, "Missing required property: factory.");
            return new Component(this.f23371a, new HashSet(this.f23372b), new HashSet(this.f23373c), this.f23374d, this.f23375e, this.f23376f, this.f23377g);
        }

        @CanIgnoreReturnValue
        public Builder<T> e() {
            return j(2);
        }

        @CanIgnoreReturnValue
        public Builder<T> f(ComponentFactory<T> componentFactory) {
            this.f23376f = (ComponentFactory) Preconditions.c(componentFactory, "Null factory");
            return this;
        }

        public Builder<T> h(@NonNull String str) {
            this.f23371a = str;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<T> i(Class<?> cls) {
            this.f23377g.add(cls);
            return this;
        }

        @SafeVarargs
        private Builder(Class<T> cls, Class<? super T>... clsArr) {
            this.f23371a = null;
            HashSet hashSet = new HashSet();
            this.f23372b = hashSet;
            this.f23373c = new HashSet();
            this.f23374d = 0;
            this.f23375e = 0;
            this.f23377g = new HashSet();
            Preconditions.c(cls, "Null interface");
            hashSet.add(Qualified.b(cls));
            for (Class<? super T> cls2 : clsArr) {
                Preconditions.c(cls2, "Null interface");
                this.f23372b.add(Qualified.b(cls2));
            }
        }
    }
}
