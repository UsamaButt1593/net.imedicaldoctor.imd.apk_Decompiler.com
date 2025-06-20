package org.apache.commons.lang3.tuple;

import com.dd.plist.ASCIIPropertyListParser;
import java.io.Serializable;
import java.util.Map;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.builder.CompareToBuilder;

public abstract class Pair<L, R> implements Map.Entry<L, R>, Comparable<Pair<L, R>>, Serializable {
    private static final long serialVersionUID = 4954918890077093841L;

    public static <L, R> Pair<L, R> of(L l2, R r) {
        return new ImmutablePair(l2, r);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        return ObjectUtils.equals(getKey(), entry.getKey()) && ObjectUtils.equals(getValue(), entry.getValue());
    }

    public final L getKey() {
        return getLeft();
    }

    public abstract L getLeft();

    public abstract R getRight();

    public R getValue() {
        return getRight();
    }

    public int hashCode() {
        int i2 = 0;
        int hashCode = getKey() == null ? 0 : getKey().hashCode();
        if (getValue() != null) {
            i2 = getValue().hashCode();
        }
        return hashCode ^ i2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(ASCIIPropertyListParser.f18649g);
        sb.append(getLeft());
        sb.append(ASCIIPropertyListParser.f18651i);
        sb.append(getRight());
        sb.append(ASCIIPropertyListParser.f18650h);
        return sb.toString();
    }

    public int compareTo(Pair<L, R> pair) {
        return new CompareToBuilder().append(getLeft(), (Object) pair.getLeft()).append(getRight(), (Object) pair.getRight()).toComparison();
    }

    public String toString(String str) {
        return String.format(str, new Object[]{getLeft(), getRight()});
    }
}
