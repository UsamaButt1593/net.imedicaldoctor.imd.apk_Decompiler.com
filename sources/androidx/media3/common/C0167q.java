package androidx.media3.common;

import androidx.media3.common.Format;
import java.util.function.Predicate;

/* renamed from: androidx.media3.common.q  reason: case insensitive filesystem */
public final /* synthetic */ class C0167q implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Format.Builder f9452a;

    public /* synthetic */ C0167q(Format.Builder builder) {
        this.f9452a = builder;
    }

    public final boolean test(Object obj) {
        return ((Label) obj).f9159b.equals(this.f9452a.f9126b);
    }
}
