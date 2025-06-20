package com.google.firebase.components;

import com.google.firebase.events.Event;
import com.google.firebase.events.Publisher;
import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

final class RestrictedComponentContainer implements ComponentContainer {

    /* renamed from: a  reason: collision with root package name */
    private final Set<Qualified<?>> f23420a;

    /* renamed from: b  reason: collision with root package name */
    private final Set<Qualified<?>> f23421b;

    /* renamed from: c  reason: collision with root package name */
    private final Set<Qualified<?>> f23422c;

    /* renamed from: d  reason: collision with root package name */
    private final Set<Qualified<?>> f23423d;

    /* renamed from: e  reason: collision with root package name */
    private final Set<Qualified<?>> f23424e;

    /* renamed from: f  reason: collision with root package name */
    private final Set<Class<?>> f23425f;

    /* renamed from: g  reason: collision with root package name */
    private final ComponentContainer f23426g;

    private static class RestrictedPublisher implements Publisher {

        /* renamed from: a  reason: collision with root package name */
        private final Set<Class<?>> f23427a;

        /* renamed from: b  reason: collision with root package name */
        private final Publisher f23428b;

        public RestrictedPublisher(Set<Class<?>> set, Publisher publisher) {
            this.f23427a = set;
            this.f23428b = publisher;
        }

        public void c(Event<?> event) {
            if (this.f23427a.contains(event.b())) {
                this.f23428b.c(event);
            } else {
                throw new DependencyException(String.format("Attempting to publish an undeclared event %s.", new Object[]{event}));
            }
        }
    }

    RestrictedComponentContainer(Component<?> component, ComponentContainer componentContainer) {
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        HashSet hashSet4 = new HashSet();
        HashSet hashSet5 = new HashSet();
        for (Dependency next : component.j()) {
            if (next.f()) {
                boolean h2 = next.h();
                Qualified<?> d2 = next.d();
                if (h2) {
                    hashSet4.add(d2);
                } else {
                    hashSet.add(d2);
                }
            } else if (next.e()) {
                hashSet3.add(next.d());
            } else {
                boolean h3 = next.h();
                Qualified<?> d3 = next.d();
                if (h3) {
                    hashSet5.add(d3);
                } else {
                    hashSet2.add(d3);
                }
            }
        }
        if (!component.n().isEmpty()) {
            hashSet.add(Qualified.b(Publisher.class));
        }
        this.f23420a = Collections.unmodifiableSet(hashSet);
        this.f23421b = Collections.unmodifiableSet(hashSet2);
        this.f23422c = Collections.unmodifiableSet(hashSet3);
        this.f23423d = Collections.unmodifiableSet(hashSet4);
        this.f23424e = Collections.unmodifiableSet(hashSet5);
        this.f23425f = component.n();
        this.f23426g = componentContainer;
    }

    public <T> T a(Class<T> cls) {
        if (this.f23420a.contains(Qualified.b(cls))) {
            T a2 = this.f23426g.a(cls);
            return !cls.equals(Publisher.class) ? a2 : new RestrictedPublisher(this.f23425f, (Publisher) a2);
        }
        throw new DependencyException(String.format("Attempting to request an undeclared dependency %s.", new Object[]{cls}));
    }

    public <T> Provider<T> b(Qualified<T> qualified) {
        if (this.f23421b.contains(qualified)) {
            return this.f23426g.b(qualified);
        }
        throw new DependencyException(String.format("Attempting to request an undeclared dependency Provider<%s>.", new Object[]{qualified}));
    }

    public <T> Provider<T> c(Class<T> cls) {
        return b(Qualified.b(cls));
    }

    public <T> Provider<Set<T>> e(Class<T> cls) {
        return g(Qualified.b(cls));
    }

    public <T> Set<T> f(Qualified<T> qualified) {
        if (this.f23423d.contains(qualified)) {
            return this.f23426g.f(qualified);
        }
        throw new DependencyException(String.format("Attempting to request an undeclared dependency Set<%s>.", new Object[]{qualified}));
    }

    public <T> Provider<Set<T>> g(Qualified<T> qualified) {
        if (this.f23424e.contains(qualified)) {
            return this.f23426g.g(qualified);
        }
        throw new DependencyException(String.format("Attempting to request an undeclared dependency Provider<Set<%s>>.", new Object[]{qualified}));
    }

    public <T> T h(Qualified<T> qualified) {
        if (this.f23420a.contains(qualified)) {
            return this.f23426g.h(qualified);
        }
        throw new DependencyException(String.format("Attempting to request an undeclared dependency %s.", new Object[]{qualified}));
    }

    public /* synthetic */ Set i(Class cls) {
        return f.f(this, cls);
    }

    public <T> Deferred<T> j(Qualified<T> qualified) {
        if (this.f23422c.contains(qualified)) {
            return this.f23426g.j(qualified);
        }
        throw new DependencyException(String.format("Attempting to request an undeclared dependency Deferred<%s>.", new Object[]{qualified}));
    }

    public <T> Deferred<T> k(Class<T> cls) {
        return j(Qualified.b(cls));
    }
}
