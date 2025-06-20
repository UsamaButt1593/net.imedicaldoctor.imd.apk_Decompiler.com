package com.google.common.primitives;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
public final class Bytes {

    @GwtCompatible
    private static class ByteArrayAsList extends AbstractList<Byte> implements RandomAccess, Serializable {
        private static final long Z = 0;
        final int X;
        final int Y;
        final byte[] s;

        ByteArrayAsList(byte[] bArr) {
            this(bArr, 0, bArr.length);
        }

        /* renamed from: b */
        public Byte get(int i2) {
            Preconditions.C(i2, size());
            return Byte.valueOf(this.s[this.X + i2]);
        }

        /* renamed from: c */
        public Byte set(int i2, Byte b2) {
            Preconditions.C(i2, size());
            byte[] bArr = this.s;
            int i3 = this.X;
            byte b3 = bArr[i3 + i2];
            bArr[i3 + i2] = ((Byte) Preconditions.E(b2)).byteValue();
            return Byte.valueOf(b3);
        }

        public boolean contains(@CheckForNull Object obj) {
            return (obj instanceof Byte) && Bytes.i(this.s, ((Byte) obj).byteValue(), this.X, this.Y) != -1;
        }

        /* access modifiers changed from: package-private */
        public byte[] d() {
            return Arrays.copyOfRange(this.s, this.X, this.Y);
        }

        public boolean equals(@CheckForNull Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ByteArrayAsList)) {
                return super.equals(obj);
            }
            ByteArrayAsList byteArrayAsList = (ByteArrayAsList) obj;
            int size = size();
            if (byteArrayAsList.size() != size) {
                return false;
            }
            for (int i2 = 0; i2 < size; i2++) {
                if (this.s[this.X + i2] != byteArrayAsList.s[byteArrayAsList.X + i2]) {
                    return false;
                }
            }
            return true;
        }

        public int hashCode() {
            int i2 = 1;
            for (int i3 = this.X; i3 < this.Y; i3++) {
                i2 = (i2 * 31) + Bytes.g(this.s[i3]);
            }
            return i2;
        }

        public int indexOf(@CheckForNull Object obj) {
            int a2;
            if (!(obj instanceof Byte) || (a2 = Bytes.i(this.s, ((Byte) obj).byteValue(), this.X, this.Y)) < 0) {
                return -1;
            }
            return a2 - this.X;
        }

        public boolean isEmpty() {
            return false;
        }

        public int lastIndexOf(@CheckForNull Object obj) {
            int b2;
            if (!(obj instanceof Byte) || (b2 = Bytes.l(this.s, ((Byte) obj).byteValue(), this.X, this.Y)) < 0) {
                return -1;
            }
            return b2 - this.X;
        }

        public int size() {
            return this.Y - this.X;
        }

        public List<Byte> subList(int i2, int i3) {
            Preconditions.f0(i2, i3, size());
            if (i2 == i3) {
                return Collections.emptyList();
            }
            byte[] bArr = this.s;
            int i4 = this.X;
            return new ByteArrayAsList(bArr, i2 + i4, i4 + i3);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(size() * 5);
            sb.append('[');
            sb.append(this.s[this.X]);
            int i2 = this.X;
            while (true) {
                i2++;
                if (i2 < this.Y) {
                    sb.append(", ");
                    sb.append(this.s[i2]);
                } else {
                    sb.append(']');
                    return sb.toString();
                }
            }
        }

        ByteArrayAsList(byte[] bArr, int i2, int i3) {
            this.s = bArr;
            this.X = i2;
            this.Y = i3;
        }
    }

    private Bytes() {
    }

    public static List<Byte> c(byte... bArr) {
        return bArr.length == 0 ? Collections.emptyList() : new ByteArrayAsList(bArr);
    }

    public static byte[] d(byte[]... bArr) {
        int i2 = 0;
        for (byte[] length : bArr) {
            i2 += length.length;
        }
        byte[] bArr2 = new byte[i2];
        int i3 = 0;
        for (byte[] bArr3 : bArr) {
            System.arraycopy(bArr3, 0, bArr2, i3, bArr3.length);
            i3 += bArr3.length;
        }
        return bArr2;
    }

    public static boolean e(byte[] bArr, byte b2) {
        for (byte b3 : bArr) {
            if (b3 == b2) {
                return true;
            }
        }
        return false;
    }

    public static byte[] f(byte[] bArr, int i2, int i3) {
        boolean z = false;
        Preconditions.k(i2 >= 0, "Invalid minLength: %s", i2);
        if (i3 >= 0) {
            z = true;
        }
        Preconditions.k(z, "Invalid padding: %s", i3);
        return bArr.length < i2 ? Arrays.copyOf(bArr, i2 + i3) : bArr;
    }

    public static int g(byte b2) {
        return b2;
    }

    public static int h(byte[] bArr, byte b2) {
        return i(bArr, b2, 0, bArr.length);
    }

    /* access modifiers changed from: private */
    public static int i(byte[] bArr, byte b2, int i2, int i3) {
        while (i2 < i3) {
            if (bArr[i2] == b2) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public static int j(byte[] bArr, byte[] bArr2) {
        Preconditions.F(bArr, "array");
        Preconditions.F(bArr2, TypedValues.AttributesType.M);
        if (bArr2.length == 0) {
            return 0;
        }
        int i2 = 0;
        while (i2 < (bArr.length - bArr2.length) + 1) {
            int i3 = 0;
            while (i3 < bArr2.length) {
                if (bArr[i2 + i3] != bArr2[i3]) {
                    i2++;
                } else {
                    i3++;
                }
            }
            return i2;
        }
        return -1;
    }

    public static int k(byte[] bArr, byte b2) {
        return l(bArr, b2, 0, bArr.length);
    }

    /* access modifiers changed from: private */
    public static int l(byte[] bArr, byte b2, int i2, int i3) {
        for (int i4 = i3 - 1; i4 >= i2; i4--) {
            if (bArr[i4] == b2) {
                return i4;
            }
        }
        return -1;
    }

    public static void m(byte[] bArr) {
        Preconditions.E(bArr);
        n(bArr, 0, bArr.length);
    }

    public static void n(byte[] bArr, int i2, int i3) {
        Preconditions.E(bArr);
        Preconditions.f0(i2, i3, bArr.length);
        for (int i4 = i3 - 1; i2 < i4; i4--) {
            byte b2 = bArr[i2];
            bArr[i2] = bArr[i4];
            bArr[i4] = b2;
            i2++;
        }
    }

    public static void o(byte[] bArr, int i2) {
        p(bArr, i2, 0, bArr.length);
    }

    public static void p(byte[] bArr, int i2, int i3, int i4) {
        Preconditions.E(bArr);
        Preconditions.f0(i3, i4, bArr.length);
        if (bArr.length > 1) {
            int i5 = i4 - i3;
            int i6 = (-i2) % i5;
            if (i6 < 0) {
                i6 += i5;
            }
            int i7 = i6 + i3;
            if (i7 != i3) {
                n(bArr, i3, i7);
                n(bArr, i7, i4);
                n(bArr, i3, i4);
            }
        }
    }

    public static byte[] q(Collection<? extends Number> collection) {
        if (collection instanceof ByteArrayAsList) {
            return ((ByteArrayAsList) collection).d();
        }
        Object[] array = collection.toArray();
        int length = array.length;
        byte[] bArr = new byte[length];
        for (int i2 = 0; i2 < length; i2++) {
            bArr[i2] = ((Number) Preconditions.E(array[i2])).byteValue();
        }
        return bArr;
    }
}
