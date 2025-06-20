package com.airbnb.lottie.model;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.util.Pair;
import org.apache.commons.lang3.StringUtils;

@RestrictTo({RestrictTo.Scope.LIBRARY})
public class MutablePair<T> {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    T f17127a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    T f17128b;

    private static boolean a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public void b(T t, T t2) {
        this.f17127a = t;
        this.f17128b = t2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair) obj;
        return a(pair.f6296a, this.f17127a) && a(pair.f6297b, this.f17128b);
    }

    public int hashCode() {
        T t = this.f17127a;
        int i2 = 0;
        int hashCode = t == null ? 0 : t.hashCode();
        T t2 = this.f17128b;
        if (t2 != null) {
            i2 = t2.hashCode();
        }
        return hashCode ^ i2;
    }

    public String toString() {
        return "Pair{" + String.valueOf(this.f17127a) + StringUtils.SPACE + String.valueOf(this.f17128b) + "}";
    }
}
