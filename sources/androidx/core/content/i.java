package androidx.core.content;

import android.content.ComponentName;
import androidx.core.util.Predicate;
import androidx.core.util.k;

public final /* synthetic */ class i implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ComponentName f5698a;

    public /* synthetic */ i(ComponentName componentName) {
        this.f5698a = componentName;
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
        return this.f5698a.equals((ComponentName) obj);
    }
}
