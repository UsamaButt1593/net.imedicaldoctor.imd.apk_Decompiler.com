package androidx.core.util;

public final /* synthetic */ class f implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Predicate f6325a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Predicate f6326b;

    public /* synthetic */ f(Predicate predicate, Predicate predicate2) {
        this.f6325a = predicate;
        this.f6326b = predicate2;
    }

    public /* synthetic */ Predicate a(Predicate predicate) {
        return k.a(this, predicate);
    }

    public /* synthetic */ Predicate b(Predicate predicate) {
        return k.c(this, predicate);
    }

    public /* synthetic */ Predicate negate() {
        return k.b(this);
    }

    public final boolean test(Object obj) {
        return k.f(this.f6325a, this.f6326b, obj);
    }
}
