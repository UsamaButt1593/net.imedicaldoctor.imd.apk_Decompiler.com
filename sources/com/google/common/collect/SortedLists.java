package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;

@GwtCompatible
@ElementTypesAreNonnullByDefault
final class SortedLists {

    enum KeyAbsentBehavior {
        NEXT_LOWER {
            /* access modifiers changed from: package-private */
            public int b(int i2) {
                return i2 - 1;
            }
        },
        NEXT_HIGHER {
            public int b(int i2) {
                return i2;
            }
        },
        INVERTED_INSERTION_INDEX {
            public int b(int i2) {
                return ~i2;
            }
        };

        /* access modifiers changed from: package-private */
        public abstract int b(int i2);
    }

    enum KeyPresentBehavior {
        ANY_PRESENT {
            /* access modifiers changed from: package-private */
            public <E> int b(Comparator<? super E> comparator, @ParametricNullness E e2, List<? extends E> list, int i2) {
                return i2;
            }
        },
        LAST_PRESENT {
            /* access modifiers changed from: package-private */
            public <E> int b(Comparator<? super E> comparator, @ParametricNullness E e2, List<? extends E> list, int i2) {
                int size = list.size() - 1;
                while (i2 < size) {
                    int i3 = ((i2 + size) + 1) >>> 1;
                    if (comparator.compare(list.get(i3), e2) > 0) {
                        size = i3 - 1;
                    } else {
                        i2 = i3;
                    }
                }
                return i2;
            }
        },
        FIRST_PRESENT {
            /* access modifiers changed from: package-private */
            public <E> int b(Comparator<? super E> comparator, @ParametricNullness E e2, List<? extends E> list, int i2) {
                int i3 = 0;
                while (i3 < i2) {
                    int i4 = (i3 + i2) >>> 1;
                    if (comparator.compare(list.get(i4), e2) < 0) {
                        i3 = i4 + 1;
                    } else {
                        i2 = i4;
                    }
                }
                return i3;
            }
        },
        FIRST_AFTER {
            public <E> int b(Comparator<? super E> comparator, @ParametricNullness E e2, List<? extends E> list, int i2) {
                return KeyPresentBehavior.LAST_PRESENT.b(comparator, e2, list, i2) + 1;
            }
        },
        LAST_BEFORE {
            public <E> int b(Comparator<? super E> comparator, @ParametricNullness E e2, List<? extends E> list, int i2) {
                return KeyPresentBehavior.FIRST_PRESENT.b(comparator, e2, list, i2) - 1;
            }
        };

        /* access modifiers changed from: package-private */
        public abstract <E> int b(Comparator<? super E> comparator, @ParametricNullness E e2, List<? extends E> list, int i2);
    }

    private SortedLists() {
    }

    public static <E, K extends Comparable> int a(List<E> list, Function<? super E, K> function, K k2, KeyPresentBehavior keyPresentBehavior, KeyAbsentBehavior keyAbsentBehavior) {
        Preconditions.E(k2);
        return b(list, function, k2, Ordering.z(), keyPresentBehavior, keyAbsentBehavior);
    }

    public static <E, K> int b(List<E> list, Function<? super E, K> function, @ParametricNullness K k2, Comparator<? super K> comparator, KeyPresentBehavior keyPresentBehavior, KeyAbsentBehavior keyAbsentBehavior) {
        return d(Lists.D(list, function), k2, comparator, keyPresentBehavior, keyAbsentBehavior);
    }

    public static <E extends Comparable> int c(List<? extends E> list, E e2, KeyPresentBehavior keyPresentBehavior, KeyAbsentBehavior keyAbsentBehavior) {
        Preconditions.E(e2);
        return d(list, e2, Ordering.z(), keyPresentBehavior, keyAbsentBehavior);
    }

    public static <E> int d(List<? extends E> list, @ParametricNullness E e2, Comparator<? super E> comparator, KeyPresentBehavior keyPresentBehavior, KeyAbsentBehavior keyAbsentBehavior) {
        Preconditions.E(comparator);
        Preconditions.E(list);
        Preconditions.E(keyPresentBehavior);
        Preconditions.E(keyAbsentBehavior);
        boolean z = list instanceof RandomAccess;
        ArrayList<? extends E> arrayList = list;
        if (!z) {
            arrayList = Lists.r(list);
        }
        int size = arrayList.size() - 1;
        int i2 = 0;
        while (i2 <= size) {
            int i3 = (i2 + size) >>> 1;
            int compare = comparator.compare(e2, arrayList.get(i3));
            if (compare < 0) {
                size = i3 - 1;
            } else if (compare <= 0) {
                return i2 + keyPresentBehavior.b(comparator, e2, arrayList.subList(i2, size + 1), i3 - i2);
            } else {
                i2 = i3 + 1;
            }
        }
        return keyAbsentBehavior.b(i2);
    }
}
