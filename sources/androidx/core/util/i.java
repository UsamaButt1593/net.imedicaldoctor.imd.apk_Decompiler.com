package androidx.core.util;

public final /* synthetic */ class i implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Predicate f6328a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Predicate f6329b;

    public /* synthetic */ i(Predicate predicate, Predicate predicate2) {
        this.f6328a = predicate;
        this.f6329b = predicate2;
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
        return k.d(this.f6328a, this.f6329b, obj);
    }
}
