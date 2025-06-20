package org.apache.commons.lang3.tuple;

public class MutableTriple<L, M, R> extends Triple<L, M, R> {
    private static final long serialVersionUID = 1;
    public L left;
    public M middle;
    public R right;

    public MutableTriple() {
    }

    public static <L, M, R> MutableTriple<L, M, R> of(L l2, M m2, R r) {
        return new MutableTriple<>(l2, m2, r);
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

    public void setLeft(L l2) {
        this.left = l2;
    }

    public void setMiddle(M m2) {
        this.middle = m2;
    }

    public void setRight(R r) {
        this.right = r;
    }

    public MutableTriple(L l2, M m2, R r) {
        this.left = l2;
        this.middle = m2;
        this.right = r;
    }
}
