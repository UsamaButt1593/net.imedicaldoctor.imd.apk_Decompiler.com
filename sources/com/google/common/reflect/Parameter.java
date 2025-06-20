package com.google.common.reflect;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.UnmodifiableIterator;
import com.google.errorprone.annotations.DoNotCall;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.AnnotatedType;
import java.util.Objects;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
public final class Parameter implements AnnotatedElement {

    /* renamed from: a  reason: collision with root package name */
    private final Invokable<?, ?> f22995a;

    /* renamed from: b  reason: collision with root package name */
    private final int f22996b;

    /* renamed from: c  reason: collision with root package name */
    private final TypeToken<?> f22997c;

    /* renamed from: d  reason: collision with root package name */
    private final ImmutableList<Annotation> f22998d;

    /* renamed from: e  reason: collision with root package name */
    private final Object f22999e;

    Parameter(Invokable<?, ?> invokable, int i2, TypeToken<?> typeToken, Annotation[] annotationArr, Object obj) {
        this.f22995a = invokable;
        this.f22996b = i2;
        this.f22997c = typeToken;
        this.f22998d = ImmutableList.D(annotationArr);
        this.f22999e = obj;
    }

    @IgnoreJRERequirement
    @DoNotCall("fails under Android VMs; do not use from guava-android")
    @Deprecated
    @Beta
    public AnnotatedType a() {
        AnnotatedType annotatedType = (AnnotatedType) this.f22999e;
        Objects.requireNonNull(annotatedType);
        AnnotatedType annotatedType2 = annotatedType;
        return annotatedType;
    }

    public Invokable<?, ?> b() {
        return this.f22995a;
    }

    public TypeToken<?> c() {
        return this.f22997c;
    }

    public boolean equals(@CheckForNull Object obj) {
        if (!(obj instanceof Parameter)) {
            return false;
        }
        Parameter parameter = (Parameter) obj;
        return this.f22996b == parameter.f22996b && this.f22995a.equals(parameter.f22995a);
    }

    @CheckForNull
    public <A extends Annotation> A getAnnotation(Class<A> cls) {
        Preconditions.E(cls);
        UnmodifiableIterator<Annotation> k2 = this.f22998d.iterator();
        while (k2.hasNext()) {
            Annotation next = k2.next();
            if (cls.isInstance(next)) {
                return (Annotation) cls.cast(next);
            }
        }
        return null;
    }

    public Annotation[] getAnnotations() {
        return getDeclaredAnnotations();
    }

    public <A extends Annotation> A[] getAnnotationsByType(Class<A> cls) {
        return getDeclaredAnnotationsByType(cls);
    }

    @CheckForNull
    public <A extends Annotation> A getDeclaredAnnotation(Class<A> cls) {
        Preconditions.E(cls);
        return (Annotation) FluentIterable.D(this.f22998d).x(cls).z().j();
    }

    public Annotation[] getDeclaredAnnotations() {
        return (Annotation[]) this.f22998d.toArray(new Annotation[0]);
    }

    public <A extends Annotation> A[] getDeclaredAnnotationsByType(Class<A> cls) {
        return (Annotation[]) FluentIterable.D(this.f22998d).x(cls).P(cls);
    }

    public int hashCode() {
        return this.f22996b;
    }

    public boolean isAnnotationPresent(Class<? extends Annotation> cls) {
        return getAnnotation(cls) != null;
    }

    public String toString() {
        return this.f22997c + " arg" + this.f22996b;
    }
}
