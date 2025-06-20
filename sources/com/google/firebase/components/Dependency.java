package com.google.firebase.components;

public final class Dependency {

    /* renamed from: a  reason: collision with root package name */
    private final Qualified<?> f23403a;

    /* renamed from: b  reason: collision with root package name */
    private final int f23404b;

    /* renamed from: c  reason: collision with root package name */
    private final int f23405c;

    private Dependency(Qualified<?> qualified, int i2, int i3) {
        this.f23403a = (Qualified) Preconditions.c(qualified, "Null dependency anInterface.");
        this.f23404b = i2;
        this.f23405c = i3;
    }

    public static Dependency a(Qualified<?> qualified) {
        return new Dependency(qualified, 0, 2);
    }

    public static Dependency b(Class<?> cls) {
        return new Dependency(cls, 0, 2);
    }

    private static String c(int i2) {
        if (i2 == 0) {
            return "direct";
        }
        if (i2 == 1) {
            return "provider";
        }
        if (i2 == 2) {
            return "deferred";
        }
        throw new AssertionError("Unsupported injection: " + i2);
    }

    @Deprecated
    public static Dependency i(Class<?> cls) {
        return new Dependency(cls, 0, 0);
    }

    public static Dependency j(Qualified<?> qualified) {
        return new Dependency(qualified, 0, 1);
    }

    public static Dependency k(Class<?> cls) {
        return new Dependency(cls, 0, 1);
    }

    public static Dependency l(Qualified<?> qualified) {
        return new Dependency(qualified, 1, 0);
    }

    public static Dependency m(Class<?> cls) {
        return new Dependency(cls, 1, 0);
    }

    public static Dependency n(Qualified<?> qualified) {
        return new Dependency(qualified, 1, 1);
    }

    public static Dependency o(Class<?> cls) {
        return new Dependency(cls, 1, 1);
    }

    public static Dependency p(Qualified<?> qualified) {
        return new Dependency(qualified, 2, 0);
    }

    public static Dependency q(Class<?> cls) {
        return new Dependency(cls, 2, 0);
    }

    public static Dependency r(Qualified<?> qualified) {
        return new Dependency(qualified, 2, 1);
    }

    public static Dependency s(Class<?> cls) {
        return new Dependency(cls, 2, 1);
    }

    public Qualified<?> d() {
        return this.f23403a;
    }

    public boolean e() {
        return this.f23405c == 2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Dependency)) {
            return false;
        }
        Dependency dependency = (Dependency) obj;
        return this.f23403a.equals(dependency.f23403a) && this.f23404b == dependency.f23404b && this.f23405c == dependency.f23405c;
    }

    public boolean f() {
        return this.f23405c == 0;
    }

    public boolean g() {
        return this.f23404b == 1;
    }

    public boolean h() {
        return this.f23404b == 2;
    }

    public int hashCode() {
        return ((((this.f23403a.hashCode() ^ 1000003) * 1000003) ^ this.f23404b) * 1000003) ^ this.f23405c;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Dependency{anInterface=");
        sb.append(this.f23403a);
        sb.append(", type=");
        int i2 = this.f23404b;
        sb.append(i2 == 1 ? "required" : i2 == 0 ? "optional" : "set");
        sb.append(", injection=");
        sb.append(c(this.f23405c));
        sb.append("}");
        return sb.toString();
    }

    private Dependency(Class<?> cls, int i2, int i3) {
        this(Qualified.b(cls), i2, i3);
    }
}
