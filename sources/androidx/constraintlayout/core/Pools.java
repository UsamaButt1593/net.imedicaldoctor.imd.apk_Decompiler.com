package androidx.constraintlayout.core;

final class Pools {

    /* renamed from: a  reason: collision with root package name */
    private static final boolean f3630a = false;

    interface Pool<T> {
        T b();

        boolean c(T t);

        void d(T[] tArr, int i2);
    }

    static class SimplePool<T> implements Pool<T> {

        /* renamed from: a  reason: collision with root package name */
        private final Object[] f3631a;

        /* renamed from: b  reason: collision with root package name */
        private int f3632b;

        SimplePool(int i2) {
            if (i2 > 0) {
                this.f3631a = new Object[i2];
                return;
            }
            throw new IllegalArgumentException("The max pool size must be > 0");
        }

        private boolean a(T t) {
            for (int i2 = 0; i2 < this.f3632b; i2++) {
                if (this.f3631a[i2] == t) {
                    return true;
                }
            }
            return false;
        }

        public T b() {
            int i2 = this.f3632b;
            if (i2 <= 0) {
                return null;
            }
            int i3 = i2 - 1;
            T[] tArr = this.f3631a;
            T t = tArr[i3];
            tArr[i3] = null;
            this.f3632b = i2 - 1;
            return t;
        }

        public boolean c(T t) {
            int i2 = this.f3632b;
            Object[] objArr = this.f3631a;
            if (i2 >= objArr.length) {
                return false;
            }
            objArr[i2] = t;
            this.f3632b = i2 + 1;
            return true;
        }

        public void d(T[] tArr, int i2) {
            if (i2 > tArr.length) {
                i2 = tArr.length;
            }
            for (int i3 = 0; i3 < i2; i3++) {
                T t = tArr[i3];
                int i4 = this.f3632b;
                Object[] objArr = this.f3631a;
                if (i4 < objArr.length) {
                    objArr[i4] = t;
                    this.f3632b = i4 + 1;
                }
            }
        }
    }

    private Pools() {
    }
}
