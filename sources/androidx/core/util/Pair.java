package androidx.core.util;

import androidx.annotation.NonNull;
import org.apache.commons.lang3.StringUtils;

public class Pair<F, S> {

    /* renamed from: a  reason: collision with root package name */
    public final F f6296a;

    /* renamed from: b  reason: collision with root package name */
    public final S f6297b;

    public Pair(F f2, S s) {
        this.f6296a = f2;
        this.f6297b = s;
    }

    @NonNull
    public static <A, B> Pair<A, B> a(A a2, B b2) {
        return new Pair<>(a2, b2);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair) obj;
        return ObjectsCompat.a(pair.f6296a, this.f6296a) && ObjectsCompat.a(pair.f6297b, this.f6297b);
    }

    public int hashCode() {
        F f2 = this.f6296a;
        int i2 = 0;
        int hashCode = f2 == null ? 0 : f2.hashCode();
        S s = this.f6297b;
        if (s != null) {
            i2 = s.hashCode();
        }
        return hashCode ^ i2;
    }

    @NonNull
    public String toString() {
        return "Pair{" + this.f6296a + StringUtils.SPACE + this.f6297b + "}";
    }
}
