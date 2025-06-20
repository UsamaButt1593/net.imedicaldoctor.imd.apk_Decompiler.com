package androidx.core.util;

public final /* synthetic */ class h implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Object f6327a;

    public /* synthetic */ h(Object obj) {
        this.f6327a = obj;
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
        return this.f6327a.equals(obj);
    }
}
