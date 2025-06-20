package androidx.core.content;

import androidx.core.content.IntentSanitizer;
import androidx.core.util.Predicate;
import androidx.core.util.k;

public final /* synthetic */ class h implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Class f5696a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Predicate f5697b;

    public /* synthetic */ h(Class cls, Predicate predicate) {
        this.f5696a = cls;
        this.f5697b = predicate;
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
        return IntentSanitizer.Builder.c0(this.f5696a, this.f5697b, obj);
    }
}
