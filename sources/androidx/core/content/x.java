package androidx.core.content;

import android.content.UriMatcher;
import android.net.Uri;
import androidx.core.util.Predicate;
import androidx.core.util.k;

public final /* synthetic */ class x implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UriMatcher f5811a;

    public /* synthetic */ x(UriMatcher uriMatcher) {
        this.f5811a = uriMatcher;
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
        return UriMatcherCompat.c(this.f5811a, (Uri) obj);
    }
}
