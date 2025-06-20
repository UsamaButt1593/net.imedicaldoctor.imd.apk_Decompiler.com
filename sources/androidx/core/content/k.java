package androidx.core.content;

import android.net.Uri;
import androidx.core.util.Predicate;

public final /* synthetic */ class k implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f5699a;

    public /* synthetic */ k(String str) {
        this.f5699a = str;
    }

    public /* synthetic */ Predicate a(Predicate predicate) {
        return androidx.core.util.k.a(this, predicate);
    }

    public /* synthetic */ Predicate b(Predicate predicate) {
        return androidx.core.util.k.c(this, predicate);
    }

    public /* synthetic */ Predicate negate() {
        return androidx.core.util.k.b(this);
    }

    public final boolean test(Object obj) {
        return this.f5699a.equals(((Uri) obj).getAuthority());
    }
}
