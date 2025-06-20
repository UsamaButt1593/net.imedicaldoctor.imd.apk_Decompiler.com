package androidx.media3.exoplayer.source;

import androidx.media3.common.util.UnstableApi;
import java.util.Arrays;
import java.util.Random;

@UnstableApi
public interface ShuffleOrder {

    public static class DefaultShuffleOrder implements ShuffleOrder {

        /* renamed from: a  reason: collision with root package name */
        private final Random f12230a;

        /* renamed from: b  reason: collision with root package name */
        private final int[] f12231b;

        /* renamed from: c  reason: collision with root package name */
        private final int[] f12232c;

        public DefaultShuffleOrder(int i2) {
            this(i2, new Random());
        }

        private static int[] h(int i2, Random random) {
            int[] iArr = new int[i2];
            int i3 = 0;
            while (i3 < i2) {
                int i4 = i3 + 1;
                int nextInt = random.nextInt(i4);
                iArr[i3] = iArr[nextInt];
                iArr[nextInt] = i3;
                i3 = i4;
            }
            return iArr;
        }

        public ShuffleOrder a(int i2, int i3) {
            int i4 = i3 - i2;
            int[] iArr = new int[(this.f12231b.length - i4)];
            int i5 = 0;
            int i6 = 0;
            while (true) {
                int[] iArr2 = this.f12231b;
                if (i5 >= iArr2.length) {
                    return new DefaultShuffleOrder(iArr, new Random(this.f12230a.nextLong()));
                }
                int i7 = iArr2[i5];
                if (i7 < i2 || i7 >= i3) {
                    int i8 = i5 - i6;
                    if (i7 >= i2) {
                        i7 -= i4;
                    }
                    iArr[i8] = i7;
                } else {
                    i6++;
                }
                i5++;
            }
        }

        public int b() {
            int[] iArr = this.f12231b;
            if (iArr.length > 0) {
                return iArr[0];
            }
            return -1;
        }

        public int c(int i2) {
            int i3 = this.f12232c[i2] - 1;
            if (i3 >= 0) {
                return this.f12231b[i3];
            }
            return -1;
        }

        public int d(int i2) {
            int i3 = this.f12232c[i2] + 1;
            int[] iArr = this.f12231b;
            if (i3 < iArr.length) {
                return iArr[i3];
            }
            return -1;
        }

        public ShuffleOrder e(int i2, int i3) {
            int[] iArr = new int[i3];
            int[] iArr2 = new int[i3];
            int i4 = 0;
            int i5 = 0;
            while (i5 < i3) {
                iArr[i5] = this.f12230a.nextInt(this.f12231b.length + 1);
                int i6 = i5 + 1;
                int nextInt = this.f12230a.nextInt(i6);
                iArr2[i5] = iArr2[nextInt];
                iArr2[nextInt] = i5 + i2;
                i5 = i6;
            }
            Arrays.sort(iArr);
            int[] iArr3 = new int[(this.f12231b.length + i3)];
            int i7 = 0;
            int i8 = 0;
            while (true) {
                int[] iArr4 = this.f12231b;
                if (i4 >= iArr4.length + i3) {
                    return new DefaultShuffleOrder(iArr3, new Random(this.f12230a.nextLong()));
                }
                if (i7 >= i3 || i8 != iArr[i7]) {
                    int i9 = i8 + 1;
                    int i10 = iArr4[i8];
                    iArr3[i4] = i10;
                    if (i10 >= i2) {
                        iArr3[i4] = i10 + i3;
                    }
                    i8 = i9;
                } else {
                    iArr3[i4] = iArr2[i7];
                    i7++;
                }
                i4++;
            }
        }

        public int f() {
            int[] iArr = this.f12231b;
            if (iArr.length > 0) {
                return iArr[iArr.length - 1];
            }
            return -1;
        }

        public ShuffleOrder g() {
            return new DefaultShuffleOrder(0, new Random(this.f12230a.nextLong()));
        }

        public int getLength() {
            return this.f12231b.length;
        }

        public DefaultShuffleOrder(int i2, long j2) {
            this(i2, new Random(j2));
        }

        private DefaultShuffleOrder(int i2, Random random) {
            this(h(i2, random), random);
        }

        public DefaultShuffleOrder(int[] iArr, long j2) {
            this(Arrays.copyOf(iArr, iArr.length), new Random(j2));
        }

        private DefaultShuffleOrder(int[] iArr, Random random) {
            this.f12231b = iArr;
            this.f12230a = random;
            this.f12232c = new int[iArr.length];
            for (int i2 = 0; i2 < iArr.length; i2++) {
                this.f12232c[iArr[i2]] = i2;
            }
        }
    }

    public static final class UnshuffledShuffleOrder implements ShuffleOrder {

        /* renamed from: a  reason: collision with root package name */
        private final int f12233a;

        public UnshuffledShuffleOrder(int i2) {
            this.f12233a = i2;
        }

        public ShuffleOrder a(int i2, int i3) {
            return new UnshuffledShuffleOrder((this.f12233a - i3) + i2);
        }

        public int b() {
            return this.f12233a > 0 ? 0 : -1;
        }

        public int c(int i2) {
            int i3 = i2 - 1;
            if (i3 >= 0) {
                return i3;
            }
            return -1;
        }

        public int d(int i2) {
            int i3 = i2 + 1;
            if (i3 < this.f12233a) {
                return i3;
            }
            return -1;
        }

        public ShuffleOrder e(int i2, int i3) {
            return new UnshuffledShuffleOrder(this.f12233a + i3);
        }

        public int f() {
            int i2 = this.f12233a;
            if (i2 > 0) {
                return i2 - 1;
            }
            return -1;
        }

        public ShuffleOrder g() {
            return new UnshuffledShuffleOrder(0);
        }

        public int getLength() {
            return this.f12233a;
        }
    }

    ShuffleOrder a(int i2, int i3);

    int b();

    int c(int i2);

    int d(int i2);

    ShuffleOrder e(int i2, int i3);

    int f();

    ShuffleOrder g();

    int getLength();
}
