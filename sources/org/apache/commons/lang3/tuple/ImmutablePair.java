package org.apache.commons.lang3.tuple;

public final class ImmutablePair<L, R> extends Pair<L, R> {
    private static final long serialVersionUID = 4954918890077093841L;
    public final L left;
    public final R right;

    public ImmutablePair(L l2, R r) {
        this.left = l2;
        this.right = r;
    }

    public static <L, R> ImmutablePair<L, R> of(L l2, R r) {
        return new ImmutablePair<>(l2, r);
    }

    public L getLeft() {
        return this.left;
    }

    public R getRight() {
        return this.right;
    }

    public R setValue(R r) {
        throw new UnsupportedOperationException();
    }
}
