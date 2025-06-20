package org.jsoup.helper;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class DescendableLinkedList<E> extends LinkedList<E> {

    private class DescendingIterator<E> implements Iterator<E> {
        private final ListIterator<E> s;

        private DescendingIterator(int i2) {
            this.s = DescendableLinkedList.this.listIterator(i2);
        }

        public boolean hasNext() {
            return this.s.hasPrevious();
        }

        public E next() {
            return this.s.previous();
        }

        public void remove() {
            this.s.remove();
        }
    }

    public Iterator<E> descendingIterator() {
        return new DescendingIterator(size());
    }

    public E peekLast() {
        if (size() == 0) {
            return null;
        }
        return getLast();
    }

    public E pollLast() {
        if (size() == 0) {
            return null;
        }
        return removeLast();
    }

    public void push(E e2) {
        addFirst(e2);
    }
}
