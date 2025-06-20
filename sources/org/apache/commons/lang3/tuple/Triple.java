package org.apache.commons.lang3.tuple;

import com.dd.plist.ASCIIPropertyListParser;
import java.io.Serializable;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.builder.CompareToBuilder;

public abstract class Triple<L, M, R> implements Comparable<Triple<L, M, R>>, Serializable {
    private static final long serialVersionUID = 1;

    public static <L, M, R> Triple<L, M, R> of(L l2, M m2, R r) {
        return new ImmutableTriple(l2, m2, r);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Triple)) {
            return false;
        }
        Triple triple = (Triple) obj;
        return ObjectUtils.equals(getLeft(), triple.getLeft()) && ObjectUtils.equals(getMiddle(), triple.getMiddle()) && ObjectUtils.equals(getRight(), triple.getRight());
    }

    public abstract L getLeft();

    public abstract M getMiddle();

    public abstract R getRight();

    public int hashCode() {
        int i2 = 0;
        int hashCode = (getLeft() == null ? 0 : getLeft().hashCode()) ^ (getMiddle() == null ? 0 : getMiddle().hashCode());
        if (getRight() != null) {
            i2 = getRight().hashCode();
        }
        return hashCode ^ i2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(ASCIIPropertyListParser.f18649g);
        sb.append(getLeft());
        sb.append(ASCIIPropertyListParser.f18651i);
        sb.append(getMiddle());
        sb.append(ASCIIPropertyListParser.f18651i);
        sb.append(getRight());
        sb.append(ASCIIPropertyListParser.f18650h);
        return sb.toString();
    }

    public int compareTo(Triple<L, M, R> triple) {
        return new CompareToBuilder().append(getLeft(), (Object) triple.getLeft()).append(getMiddle(), (Object) triple.getMiddle()).append(getRight(), (Object) triple.getRight()).toComparison();
    }

    public String toString(String str) {
        return String.format(str, new Object[]{getLeft(), getMiddle(), getRight()});
    }
}
