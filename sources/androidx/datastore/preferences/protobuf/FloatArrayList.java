package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.Internal;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class FloatArrayList extends AbstractProtobufList<Float> implements Internal.FloatList, RandomAccess, PrimitiveNonBoxingCollection {
    private static final FloatArrayList X2;
    private float[] Y;
    private int Z;

    static {
        FloatArrayList floatArrayList = new FloatArrayList(new float[0], 0);
        X2 = floatArrayList;
        floatArrayList.S();
    }

    FloatArrayList() {
        this(new float[10], 0);
    }

    private void g(int i2, float f2) {
        int i3;
        b();
        if (i2 < 0 || i2 > (i3 = this.Z)) {
            throw new IndexOutOfBoundsException(m(i2));
        }
        float[] fArr = this.Y;
        if (i3 < fArr.length) {
            System.arraycopy(fArr, i2, fArr, i2 + 1, i3 - i2);
        } else {
            float[] fArr2 = new float[(((i3 * 3) / 2) + 1)];
            System.arraycopy(fArr, 0, fArr2, 0, i2);
            System.arraycopy(this.Y, i2, fArr2, i2 + 1, this.Z - i2);
            this.Y = fArr2;
        }
        this.Y[i2] = f2;
        this.Z++;
        this.modCount++;
    }

    public static FloatArrayList h() {
        return X2;
    }

    private void j(int i2) {
        if (i2 < 0 || i2 >= this.Z) {
            throw new IndexOutOfBoundsException(m(i2));
        }
    }

    private String m(int i2) {
        return "Index:" + i2 + ", Size:" + this.Z;
    }

    public void J(float f2) {
        b();
        int i2 = this.Z;
        float[] fArr = this.Y;
        if (i2 == fArr.length) {
            float[] fArr2 = new float[(((i2 * 3) / 2) + 1)];
            System.arraycopy(fArr, 0, fArr2, 0, i2);
            this.Y = fArr2;
        }
        float[] fArr3 = this.Y;
        int i3 = this.Z;
        this.Z = i3 + 1;
        fArr3[i3] = f2;
    }

    public boolean addAll(Collection<? extends Float> collection) {
        b();
        Internal.d(collection);
        if (!(collection instanceof FloatArrayList)) {
            return super.addAll(collection);
        }
        FloatArrayList floatArrayList = (FloatArrayList) collection;
        int i2 = floatArrayList.Z;
        if (i2 == 0) {
            return false;
        }
        int i3 = this.Z;
        if (Integer.MAX_VALUE - i3 >= i2) {
            int i4 = i3 + i2;
            float[] fArr = this.Y;
            if (i4 > fArr.length) {
                this.Y = Arrays.copyOf(fArr, i4);
            }
            System.arraycopy(floatArrayList.Y, 0, this.Y, this.Z, floatArrayList.Z);
            this.Z = i4;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    /* renamed from: c */
    public void add(int i2, Float f2) {
        g(i2, f2.floatValue());
    }

    /* renamed from: d */
    public boolean add(Float f2) {
        J(f2.floatValue());
        return true;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FloatArrayList)) {
            return super.equals(obj);
        }
        FloatArrayList floatArrayList = (FloatArrayList) obj;
        if (this.Z != floatArrayList.Z) {
            return false;
        }
        float[] fArr = floatArrayList.Y;
        for (int i2 = 0; i2 < this.Z; i2++) {
            if (Float.floatToIntBits(this.Y[i2]) != Float.floatToIntBits(fArr[i2])) {
                return false;
            }
        }
        return true;
    }

    public Internal.FloatList f(int i2) {
        if (i2 >= this.Z) {
            return new FloatArrayList(Arrays.copyOf(this.Y, i2), this.Z);
        }
        throw new IllegalArgumentException();
    }

    public float getFloat(int i2) {
        j(i2);
        return this.Y[i2];
    }

    public int hashCode() {
        int i2 = 1;
        for (int i3 = 0; i3 < this.Z; i3++) {
            i2 = (i2 * 31) + Float.floatToIntBits(this.Y[i3]);
        }
        return i2;
    }

    /* renamed from: k */
    public Float get(int i2) {
        return Float.valueOf(getFloat(i2));
    }

    /* renamed from: n */
    public Float remove(int i2) {
        b();
        j(i2);
        float[] fArr = this.Y;
        float f2 = fArr[i2];
        int i3 = this.Z;
        if (i2 < i3 - 1) {
            System.arraycopy(fArr, i2 + 1, fArr, i2, (i3 - i2) - 1);
        }
        this.Z--;
        this.modCount++;
        return Float.valueOf(f2);
    }

    /* renamed from: o */
    public Float set(int i2, Float f2) {
        return Float.valueOf(w(i2, f2.floatValue()));
    }

    /* access modifiers changed from: protected */
    public void removeRange(int i2, int i3) {
        b();
        if (i3 >= i2) {
            float[] fArr = this.Y;
            System.arraycopy(fArr, i3, fArr, i2, this.Z - i3);
            this.Z -= i3 - i2;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public int size() {
        return this.Z;
    }

    public float w(int i2, float f2) {
        b();
        j(i2);
        float[] fArr = this.Y;
        float f3 = fArr[i2];
        fArr[i2] = f2;
        return f3;
    }

    private FloatArrayList(float[] fArr, int i2) {
        this.Y = fArr;
        this.Z = i2;
    }

    public boolean remove(Object obj) {
        b();
        for (int i2 = 0; i2 < this.Z; i2++) {
            if (obj.equals(Float.valueOf(this.Y[i2]))) {
                float[] fArr = this.Y;
                System.arraycopy(fArr, i2 + 1, fArr, i2, (this.Z - i2) - 1);
                this.Z--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }
}
