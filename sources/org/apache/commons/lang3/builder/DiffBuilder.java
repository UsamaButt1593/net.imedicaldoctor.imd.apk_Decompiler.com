package org.apache.commons.lang3.builder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.lang3.ArrayUtils;

public class DiffBuilder implements Builder<DiffResult> {
    private final List<Diff<?>> diffs;
    private final Object left;
    private final boolean objectsTriviallyEqual;
    private final Object right;
    private final ToStringStyle style;

    public DiffBuilder(Object obj, Object obj2, ToStringStyle toStringStyle) {
        if (obj == null) {
            throw new IllegalArgumentException("lhs cannot be null");
        } else if (obj2 != null) {
            this.diffs = new ArrayList();
            this.left = obj;
            this.right = obj2;
            this.style = toStringStyle;
            this.objectsTriviallyEqual = obj == obj2 || obj.equals(obj2);
        } else {
            throw new IllegalArgumentException("rhs cannot be null");
        }
    }

    public DiffBuilder append(String str, final byte b2, final byte b3) {
        if (str != null) {
            if (!this.objectsTriviallyEqual && b2 != b3) {
                this.diffs.add(new Diff<Byte>(str) {
                    private static final long serialVersionUID = 1;

                    public Byte getLeft() {
                        return Byte.valueOf(b2);
                    }

                    public Byte getRight() {
                        return Byte.valueOf(b3);
                    }
                });
            }
            return this;
        }
        throw new IllegalArgumentException("Field name cannot be null");
    }

    public DiffBuilder append(String str, final char c2, final char c3) {
        if (str != null) {
            if (!this.objectsTriviallyEqual && c2 != c3) {
                this.diffs.add(new Diff<Character>(str) {
                    private static final long serialVersionUID = 1;

                    public Character getLeft() {
                        return Character.valueOf(c2);
                    }

                    public Character getRight() {
                        return Character.valueOf(c3);
                    }
                });
            }
            return this;
        }
        throw new IllegalArgumentException("Field name cannot be null");
    }

    public DiffResult build() {
        return new DiffResult(this.left, this.right, this.diffs, this.style);
    }

    public DiffBuilder append(String str, double d2, double d3) {
        if (str != null) {
            if (!this.objectsTriviallyEqual && Double.doubleToLongBits(d2) != Double.doubleToLongBits(d3)) {
                final double d4 = d2;
                final double d5 = d3;
                this.diffs.add(new Diff<Double>(str) {
                    private static final long serialVersionUID = 1;

                    public Double getLeft() {
                        return Double.valueOf(d4);
                    }

                    public Double getRight() {
                        return Double.valueOf(d5);
                    }
                });
            }
            return this;
        }
        throw new IllegalArgumentException("Field name cannot be null");
    }

    public DiffBuilder append(String str, final float f2, final float f3) {
        if (str != null) {
            if (!this.objectsTriviallyEqual && Float.floatToIntBits(f2) != Float.floatToIntBits(f3)) {
                this.diffs.add(new Diff<Float>(str) {
                    private static final long serialVersionUID = 1;

                    public Float getLeft() {
                        return Float.valueOf(f2);
                    }

                    public Float getRight() {
                        return Float.valueOf(f3);
                    }
                });
            }
            return this;
        }
        throw new IllegalArgumentException("Field name cannot be null");
    }

    public DiffBuilder append(String str, final int i2, final int i3) {
        if (str != null) {
            if (!this.objectsTriviallyEqual && i2 != i3) {
                this.diffs.add(new Diff<Integer>(str) {
                    private static final long serialVersionUID = 1;

                    public Integer getLeft() {
                        return Integer.valueOf(i2);
                    }

                    public Integer getRight() {
                        return Integer.valueOf(i3);
                    }
                });
            }
            return this;
        }
        throw new IllegalArgumentException("Field name cannot be null");
    }

    public DiffBuilder append(String str, long j2, long j3) {
        if (str != null) {
            if (!this.objectsTriviallyEqual && j2 != j3) {
                final long j4 = j2;
                final long j5 = j3;
                this.diffs.add(new Diff<Long>(str) {
                    private static final long serialVersionUID = 1;

                    public Long getLeft() {
                        return Long.valueOf(j4);
                    }

                    public Long getRight() {
                        return Long.valueOf(j5);
                    }
                });
            }
            return this;
        }
        throw new IllegalArgumentException("Field name cannot be null");
    }

    public DiffBuilder append(String str, final Object obj, final Object obj2) {
        if (this.objectsTriviallyEqual || obj == obj2) {
            return this;
        }
        Object obj3 = obj != null ? obj : obj2;
        if (!obj3.getClass().isArray()) {
            this.diffs.add(new Diff<Object>(str) {
                private static final long serialVersionUID = 1;

                public Object getLeft() {
                    return obj;
                }

                public Object getRight() {
                    return obj2;
                }
            });
            return this;
        } else if (obj3 instanceof boolean[]) {
            return append(str, (boolean[]) obj, (boolean[]) obj2);
        } else {
            if (obj3 instanceof byte[]) {
                return append(str, (byte[]) obj, (byte[]) obj2);
            }
            if (obj3 instanceof char[]) {
                return append(str, (char[]) obj, (char[]) obj2);
            }
            if (obj3 instanceof double[]) {
                return append(str, (double[]) obj, (double[]) obj2);
            }
            if (obj3 instanceof float[]) {
                return append(str, (float[]) obj, (float[]) obj2);
            }
            if (obj3 instanceof int[]) {
                return append(str, (int[]) obj, (int[]) obj2);
            }
            if (obj3 instanceof long[]) {
                return append(str, (long[]) obj, (long[]) obj2);
            }
            return obj3 instanceof short[] ? append(str, (short[]) obj, (short[]) obj2) : append(str, (Object[]) obj, (Object[]) obj2);
        }
    }

    public DiffBuilder append(String str, final short s, final short s2) {
        if (str != null) {
            if (!this.objectsTriviallyEqual && s != s2) {
                this.diffs.add(new Diff<Short>(str) {
                    private static final long serialVersionUID = 1;

                    public Short getLeft() {
                        return Short.valueOf(s);
                    }

                    public Short getRight() {
                        return Short.valueOf(s2);
                    }
                });
            }
            return this;
        }
        throw new IllegalArgumentException("Field name cannot be null");
    }

    public DiffBuilder append(String str, final boolean z, final boolean z2) {
        if (str != null) {
            if (!this.objectsTriviallyEqual && z != z2) {
                this.diffs.add(new Diff<Boolean>(str) {
                    private static final long serialVersionUID = 1;

                    public Boolean getLeft() {
                        return Boolean.valueOf(z);
                    }

                    public Boolean getRight() {
                        return Boolean.valueOf(z2);
                    }
                });
            }
            return this;
        }
        throw new IllegalArgumentException("Field name cannot be null");
    }

    public DiffBuilder append(String str, final byte[] bArr, final byte[] bArr2) {
        if (str != null) {
            if (!this.objectsTriviallyEqual && !Arrays.equals(bArr, bArr2)) {
                this.diffs.add(new Diff<Byte[]>(str) {
                    private static final long serialVersionUID = 1;

                    public Byte[] getLeft() {
                        return ArrayUtils.toObject(bArr);
                    }

                    public Byte[] getRight() {
                        return ArrayUtils.toObject(bArr2);
                    }
                });
            }
            return this;
        }
        throw new IllegalArgumentException("Field name cannot be null");
    }

    public DiffBuilder append(String str, final char[] cArr, final char[] cArr2) {
        if (str != null) {
            if (!this.objectsTriviallyEqual && !Arrays.equals(cArr, cArr2)) {
                this.diffs.add(new Diff<Character[]>(str) {
                    private static final long serialVersionUID = 1;

                    public Character[] getLeft() {
                        return ArrayUtils.toObject(cArr);
                    }

                    public Character[] getRight() {
                        return ArrayUtils.toObject(cArr2);
                    }
                });
            }
            return this;
        }
        throw new IllegalArgumentException("Field name cannot be null");
    }

    public DiffBuilder append(String str, final double[] dArr, final double[] dArr2) {
        if (str != null) {
            if (!this.objectsTriviallyEqual && !Arrays.equals(dArr, dArr2)) {
                this.diffs.add(new Diff<Double[]>(str) {
                    private static final long serialVersionUID = 1;

                    public Double[] getLeft() {
                        return ArrayUtils.toObject(dArr);
                    }

                    public Double[] getRight() {
                        return ArrayUtils.toObject(dArr2);
                    }
                });
            }
            return this;
        }
        throw new IllegalArgumentException("Field name cannot be null");
    }

    public DiffBuilder append(String str, final float[] fArr, final float[] fArr2) {
        if (str != null) {
            if (!this.objectsTriviallyEqual && !Arrays.equals(fArr, fArr2)) {
                this.diffs.add(new Diff<Float[]>(str) {
                    private static final long serialVersionUID = 1;

                    public Float[] getLeft() {
                        return ArrayUtils.toObject(fArr);
                    }

                    public Float[] getRight() {
                        return ArrayUtils.toObject(fArr2);
                    }
                });
            }
            return this;
        }
        throw new IllegalArgumentException("Field name cannot be null");
    }

    public DiffBuilder append(String str, final int[] iArr, final int[] iArr2) {
        if (str != null) {
            if (!this.objectsTriviallyEqual && !Arrays.equals(iArr, iArr2)) {
                this.diffs.add(new Diff<Integer[]>(str) {
                    private static final long serialVersionUID = 1;

                    public Integer[] getLeft() {
                        return ArrayUtils.toObject(iArr);
                    }

                    public Integer[] getRight() {
                        return ArrayUtils.toObject(iArr2);
                    }
                });
            }
            return this;
        }
        throw new IllegalArgumentException("Field name cannot be null");
    }

    public DiffBuilder append(String str, final long[] jArr, final long[] jArr2) {
        if (str != null) {
            if (!this.objectsTriviallyEqual && !Arrays.equals(jArr, jArr2)) {
                this.diffs.add(new Diff<Long[]>(str) {
                    private static final long serialVersionUID = 1;

                    public Long[] getLeft() {
                        return ArrayUtils.toObject(jArr);
                    }

                    public Long[] getRight() {
                        return ArrayUtils.toObject(jArr2);
                    }
                });
            }
            return this;
        }
        throw new IllegalArgumentException("Field name cannot be null");
    }

    public DiffBuilder append(String str, final Object[] objArr, final Object[] objArr2) {
        if (!this.objectsTriviallyEqual && !Arrays.equals(objArr, objArr2)) {
            this.diffs.add(new Diff<Object[]>(str) {
                private static final long serialVersionUID = 1;

                public Object[] getLeft() {
                    return objArr;
                }

                public Object[] getRight() {
                    return objArr2;
                }
            });
        }
        return this;
    }

    public DiffBuilder append(String str, final short[] sArr, final short[] sArr2) {
        if (str != null) {
            if (!this.objectsTriviallyEqual && !Arrays.equals(sArr, sArr2)) {
                this.diffs.add(new Diff<Short[]>(str) {
                    private static final long serialVersionUID = 1;

                    public Short[] getLeft() {
                        return ArrayUtils.toObject(sArr);
                    }

                    public Short[] getRight() {
                        return ArrayUtils.toObject(sArr2);
                    }
                });
            }
            return this;
        }
        throw new IllegalArgumentException("Field name cannot be null");
    }

    public DiffBuilder append(String str, final boolean[] zArr, final boolean[] zArr2) {
        if (str != null) {
            if (!this.objectsTriviallyEqual && !Arrays.equals(zArr, zArr2)) {
                this.diffs.add(new Diff<Boolean[]>(str) {
                    private static final long serialVersionUID = 1;

                    public Boolean[] getLeft() {
                        return ArrayUtils.toObject(zArr);
                    }

                    public Boolean[] getRight() {
                        return ArrayUtils.toObject(zArr2);
                    }
                });
            }
            return this;
        }
        throw new IllegalArgumentException("Field name cannot be null");
    }
}
