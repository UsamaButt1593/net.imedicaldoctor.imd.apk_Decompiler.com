package androidx.collection;

public final class CircularIntArray {

    /* renamed from: a  reason: collision with root package name */
    private int[] f3546a;

    /* renamed from: b  reason: collision with root package name */
    private int f3547b;

    /* renamed from: c  reason: collision with root package name */
    private int f3548c;

    /* renamed from: d  reason: collision with root package name */
    private int f3549d;

    public CircularIntArray() {
        this(8);
    }

    private void d() {
        int[] iArr = this.f3546a;
        int length = iArr.length;
        int i2 = this.f3547b;
        int i3 = length - i2;
        int i4 = length << 1;
        if (i4 >= 0) {
            int[] iArr2 = new int[i4];
            System.arraycopy(iArr, i2, iArr2, 0, i3);
            System.arraycopy(this.f3546a, 0, iArr2, i3, this.f3547b);
            this.f3546a = iArr2;
            this.f3547b = 0;
            this.f3548c = length;
            this.f3549d = i4 - 1;
            return;
        }
        throw new RuntimeException("Max array capacity exceeded");
    }

    public void a(int i2) {
        int i3 = (this.f3547b - 1) & this.f3549d;
        this.f3547b = i3;
        this.f3546a[i3] = i2;
        if (i3 == this.f3548c) {
            d();
        }
    }

    public void b(int i2) {
        int[] iArr = this.f3546a;
        int i3 = this.f3548c;
        iArr[i3] = i2;
        int i4 = this.f3549d & (i3 + 1);
        this.f3548c = i4;
        if (i4 == this.f3547b) {
            d();
        }
    }

    public void c() {
        this.f3548c = this.f3547b;
    }

    public int e(int i2) {
        if (i2 < 0 || i2 >= m()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return this.f3546a[this.f3549d & (this.f3547b + i2)];
    }

    public int f() {
        int i2 = this.f3547b;
        if (i2 != this.f3548c) {
            return this.f3546a[i2];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public int g() {
        int i2 = this.f3547b;
        int i3 = this.f3548c;
        if (i2 != i3) {
            return this.f3546a[(i3 - 1) & this.f3549d];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public boolean h() {
        return this.f3547b == this.f3548c;
    }

    public int i() {
        int i2 = this.f3547b;
        if (i2 != this.f3548c) {
            int i3 = this.f3546a[i2];
            this.f3547b = (i2 + 1) & this.f3549d;
            return i3;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public int j() {
        int i2 = this.f3547b;
        int i3 = this.f3548c;
        if (i2 != i3) {
            int i4 = this.f3549d & (i3 - 1);
            int i5 = this.f3546a[i4];
            this.f3548c = i4;
            return i5;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public void k(int i2) {
        if (i2 > 0) {
            if (i2 <= m()) {
                this.f3548c = this.f3549d & (this.f3548c - i2);
                return;
            }
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public void l(int i2) {
        if (i2 > 0) {
            if (i2 <= m()) {
                this.f3547b = this.f3549d & (this.f3547b + i2);
                return;
            }
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public int m() {
        return (this.f3548c - this.f3547b) & this.f3549d;
    }

    public CircularIntArray(int i2) {
        if (i2 < 1) {
            throw new IllegalArgumentException("capacity must be >= 1");
        } else if (i2 <= 1073741824) {
            i2 = Integer.bitCount(i2) != 1 ? Integer.highestOneBit(i2 - 1) << 1 : i2;
            this.f3549d = i2 - 1;
            this.f3546a = new int[i2];
        } else {
            throw new IllegalArgumentException("capacity must be <= 2^30");
        }
    }
}
