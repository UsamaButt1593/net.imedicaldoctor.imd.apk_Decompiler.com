package org.apache.commons.lang3.tuple;

public final class ImmutableTriple<L, M, R> extends Triple<L, M, R> {
    private static final long serialVersionUID = 1;
    public final L left;
    public final M middle;
    public final R right;

    public ImmutableTriple(L l2, M m2, R r) {
        this.left = l2;
        this.middle = m2;
        this.right = r;
    }

    public static <L, M, R> ImmutableTriple<L, M, R> of(L l2, M m2, R r) {
        return new ImmutableTriple<>(l2, m2, r);
    }

    public L getLeft() {
        return this.left;
    }

    public M getMiddle() {
        return this.middle;
    }

    public R getRight() {
        return this.right;
    }
}
