package androidx.core.content;

import android.net.Uri;
import androidx.core.util.Predicate;
import androidx.core.util.k;

public final /* synthetic */ class m implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f5700a;

    public /* synthetic */ m(String str) {
        this.f5700a = str;
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
        return this.f5700a.equals(((Uri) obj).getAuthority());
    }
}
