package androidx.core.content;

import android.content.ComponentName;
import androidx.core.util.Predicate;
import androidx.core.util.k;

public final /* synthetic */ class f implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f5694a;

    public /* synthetic */ f(String str) {
        this.f5694a = str;
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
        return this.f5694a.equals(((ComponentName) obj).getPackageName());
    }
}
