package androidx.collection;

public final class CircularArray<E> {

    /* renamed from: a  reason: collision with root package name */
    private E[] f3542a;

    /* renamed from: b  reason: collision with root package name */
    private int f3543b;

    /* renamed from: c  reason: collision with root package name */
    private int f3544c;

    /* renamed from: d  reason: collision with root package name */
    private int f3545d;

    public CircularArray() {
        this(8);
    }

    private void d() {
        E[] eArr = this.f3542a;
        int length = eArr.length;
        int i2 = this.f3543b;
        int i3 = length - i2;
        int i4 = length << 1;
        if (i4 >= 0) {
            E[] eArr2 = new Object[i4];
            System.arraycopy(eArr, i2, eArr2, 0, i3);
            System.arraycopy(this.f3542a, 0, eArr2, i3, this.f3543b);
            this.f3542a = eArr2;
            this.f3543b = 0;
            this.f3544c = length;
            this.f3545d = i4 - 1;
            return;
        }
        throw new RuntimeException("Max array capacity exceeded");
    }

    public void a(E e2) {
        int i2 = (this.f3543b - 1) & this.f3545d;
        this.f3543b = i2;
        this.f3542a[i2] = e2;
        if (i2 == this.f3544c) {
            d();
        }
    }

    public void b(E e2) {
        E[] eArr = this.f3542a;
        int i2 = this.f3544c;
        eArr[i2] = e2;
        int i3 = this.f3545d & (i2 + 1);
        this.f3544c = i3;
        if (i3 == this.f3543b) {
            d();
        }
    }

    public void c() {
        l(m());
    }

    public E e(int i2) {
        if (i2 < 0 || i2 >= m()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return this.f3542a[this.f3545d & (this.f3543b + i2)];
    }

    public E f() {
        int i2 = this.f3543b;
        if (i2 != this.f3544c) {
            return this.f3542a[i2];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public E g() {
        int i2 = this.f3543b;
        int i3 = this.f3544c;
        if (i2 != i3) {
            return this.f3542a[(i3 - 1) & this.f3545d];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public boolean h() {
        return this.f3543b == this.f3544c;
    }

    public E i() {
        int i2 = this.f3543b;
        if (i2 != this.f3544c) {
            E[] eArr = this.f3542a;
            E e2 = eArr[i2];
            eArr[i2] = null;
            this.f3543b = (i2 + 1) & this.f3545d;
            return e2;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public E j() {
        int i2 = this.f3543b;
        int i3 = this.f3544c;
        if (i2 != i3) {
            int i4 = this.f3545d & (i3 - 1);
            E[] eArr = this.f3542a;
            E e2 = eArr[i4];
            eArr[i4] = null;
            this.f3544c = i4;
            return e2;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public void k(int i2) {
        int i3;
        if (i2 > 0) {
            if (i2 <= m()) {
                int i4 = this.f3544c;
                int i5 = i2 < i4 ? i4 - i2 : 0;
                int i6 = i5;
                while (true) {
                    i3 = this.f3544c;
                    if (i6 >= i3) {
                        break;
                    }
                    this.f3542a[i6] = null;
                    i6++;
                }
                int i7 = i3 - i5;
                int i8 = i2 - i7;
                this.f3544c = i3 - i7;
                if (i8 > 0) {
                    int length = this.f3542a.length;
                    this.f3544c = length;
                    int i9 = length - i8;
                    for (int i10 = i9; i10 < this.f3544c; i10++) {
                        this.f3542a[i10] = null;
                    }
                    this.f3544c = i9;
                    return;
                }
                return;
            }
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public void l(int i2) {
        if (i2 > 0) {
            if (i2 <= m()) {
                int length = this.f3542a.length;
                int i3 = this.f3543b;
                if (i2 < length - i3) {
                    length = i3 + i2;
                }
                while (i3 < length) {
                    this.f3542a[i3] = null;
                    i3++;
                }
                int i4 = this.f3543b;
                int i5 = length - i4;
                int i6 = i2 - i5;
                this.f3543b = this.f3545d & (i4 + i5);
                if (i6 > 0) {
                    for (int i7 = 0; i7 < i6; i7++) {
                        this.f3542a[i7] = null;
                    }
                    this.f3543b = i6;
                    return;
                }
                return;
            }
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public int m() {
        return (this.f3544c - this.f3543b) & this.f3545d;
    }

    public CircularArray(int i2) {
        if (i2 < 1) {
            throw new IllegalArgumentException("capacity must be >= 1");
        } else if (i2 <= 1073741824) {
            i2 = Integer.bitCount(i2) != 1 ? Integer.highestOneBit(i2 - 1) << 1 : i2;
            this.f3545d = i2 - 1;
            this.f3542a = new Object[i2];
        } else {
            throw new IllegalArgumentException("capacity must be <= 2^30");
        }
    }
}
