package androidx.core.content;

import android.content.ComponentName;
import androidx.core.content.IntentSanitizer;
import androidx.core.util.Predicate;
import androidx.core.util.k;

public final /* synthetic */ class j implements Predicate {
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
        return IntentSanitizer.Builder.X((ComponentName) obj);
    }
}
