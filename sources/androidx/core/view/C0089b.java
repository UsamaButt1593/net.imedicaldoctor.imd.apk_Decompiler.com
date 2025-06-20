package androidx.core.view;

import android.content.ClipData;
import androidx.core.util.Predicate;
import androidx.core.util.k;

/* renamed from: androidx.core.view.b  reason: case insensitive filesystem */
public final /* synthetic */ class C0089b implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ java.util.function.Predicate f6701a;

    public /* synthetic */ C0089b(java.util.function.Predicate predicate) {
        this.f6701a = predicate;
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
        return this.f6701a.test((ClipData.Item) obj);
    }
}
