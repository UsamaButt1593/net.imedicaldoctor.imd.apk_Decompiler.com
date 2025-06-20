package androidx.customview.widget;

import android.graphics.Rect;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class FocusStrategy {

    public interface BoundsAdapter<T> {
        void a(T t, Rect rect);
    }

    public interface CollectionAdapter<T, V> {
        V a(T t, int i2);

        int b(T t);
    }

    private static class SequentialComparator<T> implements Comparator<T> {
        private final Rect X = new Rect();
        private final boolean Y;
        private final BoundsAdapter<T> Z;
        private final Rect s = new Rect();

        SequentialComparator(boolean z, BoundsAdapter<T> boundsAdapter) {
            this.Y = z;
            this.Z = boundsAdapter;
        }

        public int compare(T t, T t2) {
            Rect rect = this.s;
            Rect rect2 = this.X;
            this.Z.a(t, rect);
            this.Z.a(t2, rect2);
            int i2 = rect.top;
            int i3 = rect2.top;
            if (i2 < i3) {
                return -1;
            }
            if (i2 > i3) {
                return 1;
            }
            int i4 = rect.left;
            int i5 = rect2.left;
            if (i4 < i5) {
                return this.Y ? 1 : -1;
            }
            if (i4 > i5) {
                return this.Y ? -1 : 1;
            }
            int i6 = rect.bottom;
            int i7 = rect2.bottom;
            if (i6 < i7) {
                return -1;
            }
            if (i6 > i7) {
                return 1;
            }
            int i8 = rect.right;
            int i9 = rect2.right;
            if (i8 < i9) {
                return this.Y ? 1 : -1;
            }
            if (i8 > i9) {
                return this.Y ? -1 : 1;
            }
            return 0;
        }
    }

    private FocusStrategy() {
    }

    private static boolean a(int i2, @NonNull Rect rect, @NonNull Rect rect2, @NonNull Rect rect3) {
        boolean b2 = b(i2, rect, rect2);
        if (b(i2, rect, rect3) || !b2) {
            return false;
        }
        return !j(i2, rect, rect3) || i2 == 17 || i2 == 66 || k(i2, rect, rect2) < m(i2, rect, rect3);
    }

    private static boolean b(int i2, @NonNull Rect rect, @NonNull Rect rect2) {
        if (i2 != 17) {
            if (i2 != 33) {
                if (i2 != 66) {
                    if (i2 != 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                }
            }
            return rect2.right >= rect.left && rect2.left <= rect.right;
        }
        return rect2.bottom >= rect.top && rect2.top <= rect.bottom;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x004e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <L, T> T c(@androidx.annotation.NonNull L r7, @androidx.annotation.NonNull androidx.customview.widget.FocusStrategy.CollectionAdapter<L, T> r8, @androidx.annotation.NonNull androidx.customview.widget.FocusStrategy.BoundsAdapter<T> r9, @androidx.annotation.Nullable T r10, @androidx.annotation.NonNull android.graphics.Rect r11, int r12) {
        /*
            android.graphics.Rect r0 = new android.graphics.Rect
            r0.<init>(r11)
            r1 = 17
            r2 = 0
            if (r12 == r1) goto L_0x003b
            r1 = 33
            if (r12 == r1) goto L_0x0034
            r1 = 66
            if (r12 == r1) goto L_0x0029
            r1 = 130(0x82, float:1.82E-43)
            if (r12 != r1) goto L_0x0021
            int r1 = r11.height()
            int r1 = r1 + 1
            int r1 = -r1
        L_0x001d:
            r0.offset(r2, r1)
            goto L_0x0042
        L_0x0021:
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
            java.lang.String r8 = "direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}."
            r7.<init>(r8)
            throw r7
        L_0x0029:
            int r1 = r11.width()
            int r1 = r1 + 1
            int r1 = -r1
        L_0x0030:
            r0.offset(r1, r2)
            goto L_0x0042
        L_0x0034:
            int r1 = r11.height()
            int r1 = r1 + 1
            goto L_0x001d
        L_0x003b:
            int r1 = r11.width()
            int r1 = r1 + 1
            goto L_0x0030
        L_0x0042:
            int r1 = r8.b(r7)
            android.graphics.Rect r3 = new android.graphics.Rect
            r3.<init>()
            r4 = 0
        L_0x004c:
            if (r2 >= r1) goto L_0x0065
            java.lang.Object r5 = r8.a(r7, r2)
            if (r5 != r10) goto L_0x0055
            goto L_0x0062
        L_0x0055:
            r9.a(r5, r3)
            boolean r6 = h(r12, r11, r3, r0)
            if (r6 == 0) goto L_0x0062
            r0.set(r3)
            r4 = r5
        L_0x0062:
            int r2 = r2 + 1
            goto L_0x004c
        L_0x0065:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.customview.widget.FocusStrategy.c(java.lang.Object, androidx.customview.widget.FocusStrategy$CollectionAdapter, androidx.customview.widget.FocusStrategy$BoundsAdapter, java.lang.Object, android.graphics.Rect, int):java.lang.Object");
    }

    public static <L, T> T d(@NonNull L l2, @NonNull CollectionAdapter<L, T> collectionAdapter, @NonNull BoundsAdapter<T> boundsAdapter, @Nullable T t, int i2, boolean z, boolean z2) {
        int b2 = collectionAdapter.b(l2);
        ArrayList arrayList = new ArrayList(b2);
        for (int i3 = 0; i3 < b2; i3++) {
            arrayList.add(collectionAdapter.a(l2, i3));
        }
        Collections.sort(arrayList, new SequentialComparator(z, boundsAdapter));
        if (i2 == 1) {
            return f(t, arrayList, z2);
        }
        if (i2 == 2) {
            return e(t, arrayList, z2);
        }
        throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD}.");
    }

    private static <T> T e(T t, ArrayList<T> arrayList, boolean z) {
        int size = arrayList.size();
        int lastIndexOf = (t == null ? -1 : arrayList.lastIndexOf(t)) + 1;
        if (lastIndexOf < size) {
            return arrayList.get(lastIndexOf);
        }
        if (!z || size <= 0) {
            return null;
        }
        return arrayList.get(0);
    }

    private static <T> T f(T t, ArrayList<T> arrayList, boolean z) {
        int size = arrayList.size();
        int indexOf = (t == null ? size : arrayList.indexOf(t)) - 1;
        if (indexOf >= 0) {
            return arrayList.get(indexOf);
        }
        if (!z || size <= 0) {
            return null;
        }
        return arrayList.get(size - 1);
    }

    private static int g(int i2, int i3) {
        return (i2 * 13 * i2) + (i3 * i3);
    }

    private static boolean h(int i2, @NonNull Rect rect, @NonNull Rect rect2, @NonNull Rect rect3) {
        if (!i(rect, rect2, i2)) {
            return false;
        }
        if (i(rect, rect3, i2) && !a(i2, rect, rect2, rect3)) {
            return !a(i2, rect, rect3, rect2) && g(k(i2, rect, rect2), o(i2, rect, rect2)) < g(k(i2, rect, rect3), o(i2, rect, rect3));
        }
        return true;
    }

    private static boolean i(@NonNull Rect rect, @NonNull Rect rect2, int i2) {
        if (i2 == 17) {
            int i3 = rect.right;
            int i4 = rect2.right;
            return (i3 > i4 || rect.left >= i4) && rect.left > rect2.left;
        } else if (i2 == 33) {
            int i5 = rect.bottom;
            int i6 = rect2.bottom;
            return (i5 > i6 || rect.top >= i6) && rect.top > rect2.top;
        } else if (i2 == 66) {
            int i7 = rect.left;
            int i8 = rect2.left;
            return (i7 < i8 || rect.right <= i8) && rect.right < rect2.right;
        } else if (i2 == 130) {
            int i9 = rect.top;
            int i10 = rect2.top;
            return (i9 < i10 || rect.bottom <= i10) && rect.bottom < rect2.bottom;
        } else {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
    }

    private static boolean j(int i2, @NonNull Rect rect, @NonNull Rect rect2) {
        if (i2 == 17) {
            return rect.left >= rect2.right;
        }
        if (i2 == 33) {
            return rect.top >= rect2.bottom;
        }
        if (i2 == 66) {
            return rect.right <= rect2.left;
        }
        if (i2 == 130) {
            return rect.bottom <= rect2.top;
        }
        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    }

    private static int k(int i2, @NonNull Rect rect, @NonNull Rect rect2) {
        return Math.max(0, l(i2, rect, rect2));
    }

    private static int l(int i2, @NonNull Rect rect, @NonNull Rect rect2) {
        int i3;
        int i4;
        if (i2 == 17) {
            i3 = rect.left;
            i4 = rect2.right;
        } else if (i2 == 33) {
            i3 = rect.top;
            i4 = rect2.bottom;
        } else if (i2 == 66) {
            i3 = rect2.left;
            i4 = rect.right;
        } else if (i2 == 130) {
            i3 = rect2.top;
            i4 = rect.bottom;
        } else {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        return i3 - i4;
    }

    private static int m(int i2, @NonNull Rect rect, @NonNull Rect rect2) {
        return Math.max(1, n(i2, rect, rect2));
    }

    private static int n(int i2, @NonNull Rect rect, @NonNull Rect rect2) {
        int i3;
        int i4;
        if (i2 == 17) {
            i3 = rect.left;
            i4 = rect2.left;
        } else if (i2 == 33) {
            i3 = rect.top;
            i4 = rect2.top;
        } else if (i2 == 66) {
            i3 = rect2.right;
            i4 = rect.right;
        } else if (i2 == 130) {
            i3 = rect2.bottom;
            i4 = rect.bottom;
        } else {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        return i3 - i4;
    }

    private static int o(int i2, @NonNull Rect rect, @NonNull Rect rect2) {
        int height;
        int i3;
        int height2;
        if (i2 != 17) {
            if (i2 != 33) {
                if (i2 != 66) {
                    if (i2 != 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                }
            }
            height = rect.left + (rect.width() / 2);
            i3 = rect2.left;
            height2 = rect2.width();
            return Math.abs(height - (i3 + (height2 / 2)));
        }
        height = rect.top + (rect.height() / 2);
        i3 = rect2.top;
        height2 = rect2.height();
        return Math.abs(height - (i3 + (height2 / 2)));
    }
}
