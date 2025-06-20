package com.google.android.gms.common.internal.safeparcel;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.util.SparseLongArray;
import androidx.annotation.NonNull;
import androidx.core.internal.view.SupportMenu;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

public class SafeParcelWriter {
    private SafeParcelWriter() {
    }

    public static void A(@NonNull Parcel parcel, int i2, @NonNull SparseArray<Float> sparseArray, boolean z) {
        if (sparseArray != null) {
            int f0 = f0(parcel, i2);
            int size = sparseArray.size();
            parcel.writeInt(size);
            for (int i3 = 0; i3 < size; i3++) {
                parcel.writeInt(sparseArray.keyAt(i3));
                parcel.writeFloat(sparseArray.valueAt(i3).floatValue());
            }
            g0(parcel, f0);
        } else if (z) {
            h0(parcel, i2, 0);
        }
    }

    public static void B(@NonNull Parcel parcel, int i2, @NonNull IBinder iBinder, boolean z) {
        if (iBinder != null) {
            int f0 = f0(parcel, i2);
            parcel.writeStrongBinder(iBinder);
            g0(parcel, f0);
        } else if (z) {
            h0(parcel, i2, 0);
        }
    }

    public static void C(@NonNull Parcel parcel, int i2, @NonNull IBinder[] iBinderArr, boolean z) {
        if (iBinderArr != null) {
            int f0 = f0(parcel, i2);
            parcel.writeBinderArray(iBinderArr);
            g0(parcel, f0);
        } else if (z) {
            h0(parcel, i2, 0);
        }
    }

    public static void D(@NonNull Parcel parcel, int i2, @NonNull List<IBinder> list, boolean z) {
        if (list != null) {
            int f0 = f0(parcel, i2);
            parcel.writeBinderList(list);
            g0(parcel, f0);
        } else if (z) {
            h0(parcel, i2, 0);
        }
    }

    public static void E(@NonNull Parcel parcel, int i2, @NonNull SparseArray<IBinder> sparseArray, boolean z) {
        if (sparseArray != null) {
            int f0 = f0(parcel, i2);
            int size = sparseArray.size();
            parcel.writeInt(size);
            for (int i3 = 0; i3 < size; i3++) {
                parcel.writeInt(sparseArray.keyAt(i3));
                parcel.writeStrongBinder(sparseArray.valueAt(i3));
            }
            g0(parcel, f0);
        } else if (z) {
            h0(parcel, i2, 0);
        }
    }

    public static void F(@NonNull Parcel parcel, int i2, int i3) {
        h0(parcel, i2, 4);
        parcel.writeInt(i3);
    }

    public static void G(@NonNull Parcel parcel, int i2, @NonNull int[] iArr, boolean z) {
        if (iArr != null) {
            int f0 = f0(parcel, i2);
            parcel.writeIntArray(iArr);
            g0(parcel, f0);
        } else if (z) {
            h0(parcel, i2, 0);
        }
    }

    public static void H(@NonNull Parcel parcel, int i2, @NonNull List<Integer> list, boolean z) {
        if (list != null) {
            int f0 = f0(parcel, i2);
            int size = list.size();
            parcel.writeInt(size);
            for (int i3 = 0; i3 < size; i3++) {
                parcel.writeInt(list.get(i3).intValue());
            }
            g0(parcel, f0);
        } else if (z) {
            h0(parcel, i2, 0);
        }
    }

    public static void I(@NonNull Parcel parcel, int i2, @NonNull Integer num, boolean z) {
        if (num != null) {
            h0(parcel, i2, 4);
            parcel.writeInt(num.intValue());
        } else if (z) {
            h0(parcel, i2, 0);
        }
    }

    public static void J(@NonNull Parcel parcel, int i2, @NonNull List list, boolean z) {
        if (list != null) {
            int f0 = f0(parcel, i2);
            parcel.writeList(list);
            g0(parcel, f0);
        } else if (z) {
            h0(parcel, i2, 0);
        }
    }

    public static void K(@NonNull Parcel parcel, int i2, long j2) {
        h0(parcel, i2, 8);
        parcel.writeLong(j2);
    }

    public static void L(@NonNull Parcel parcel, int i2, @NonNull long[] jArr, boolean z) {
        if (jArr != null) {
            int f0 = f0(parcel, i2);
            parcel.writeLongArray(jArr);
            g0(parcel, f0);
        } else if (z) {
            h0(parcel, i2, 0);
        }
    }

    public static void M(@NonNull Parcel parcel, int i2, @NonNull List<Long> list, boolean z) {
        if (list != null) {
            int f0 = f0(parcel, i2);
            int size = list.size();
            parcel.writeInt(size);
            for (int i3 = 0; i3 < size; i3++) {
                parcel.writeLong(list.get(i3).longValue());
            }
            g0(parcel, f0);
        } else if (z) {
            h0(parcel, i2, 0);
        }
    }

    public static void N(@NonNull Parcel parcel, int i2, @NonNull Long l2, boolean z) {
        if (l2 != null) {
            h0(parcel, i2, 8);
            parcel.writeLong(l2.longValue());
        } else if (z) {
            h0(parcel, i2, 0);
        }
    }

    public static void O(@NonNull Parcel parcel, int i2, @NonNull Parcel parcel2, boolean z) {
        if (parcel2 != null) {
            int f0 = f0(parcel, i2);
            parcel.appendFrom(parcel2, 0, parcel2.dataSize());
            g0(parcel, f0);
        } else if (z) {
            h0(parcel, i2, 0);
        }
    }

    public static void P(@NonNull Parcel parcel, int i2, @NonNull Parcel[] parcelArr, boolean z) {
        if (parcelArr != null) {
            int f0 = f0(parcel, i2);
            parcel.writeInt(r7);
            for (Parcel parcel2 : parcelArr) {
                if (parcel2 != null) {
                    parcel.writeInt(parcel2.dataSize());
                    parcel.appendFrom(parcel2, 0, parcel2.dataSize());
                } else {
                    parcel.writeInt(0);
                }
            }
            g0(parcel, f0);
        } else if (z) {
            h0(parcel, i2, 0);
        }
    }

    public static void Q(@NonNull Parcel parcel, int i2, @NonNull List<Parcel> list, boolean z) {
        if (list != null) {
            int f0 = f0(parcel, i2);
            int size = list.size();
            parcel.writeInt(size);
            for (int i3 = 0; i3 < size; i3++) {
                Parcel parcel2 = list.get(i3);
                if (parcel2 != null) {
                    parcel.writeInt(parcel2.dataSize());
                    parcel.appendFrom(parcel2, 0, parcel2.dataSize());
                } else {
                    parcel.writeInt(0);
                }
            }
            g0(parcel, f0);
        } else if (z) {
            h0(parcel, i2, 0);
        }
    }

    public static void R(@NonNull Parcel parcel, int i2, @NonNull SparseArray<Parcel> sparseArray, boolean z) {
        if (sparseArray != null) {
            int f0 = f0(parcel, i2);
            int size = sparseArray.size();
            parcel.writeInt(size);
            for (int i3 = 0; i3 < size; i3++) {
                parcel.writeInt(sparseArray.keyAt(i3));
                Parcel valueAt = sparseArray.valueAt(i3);
                if (valueAt != null) {
                    parcel.writeInt(valueAt.dataSize());
                    parcel.appendFrom(valueAt, 0, valueAt.dataSize());
                } else {
                    parcel.writeInt(0);
                }
            }
            g0(parcel, f0);
        } else if (z) {
            h0(parcel, i2, 0);
        }
    }

    public static void S(@NonNull Parcel parcel, int i2, @NonNull Parcelable parcelable, int i3, boolean z) {
        if (parcelable != null) {
            int f0 = f0(parcel, i2);
            parcelable.writeToParcel(parcel, i3);
            g0(parcel, f0);
        } else if (z) {
            h0(parcel, i2, 0);
        }
    }

    public static void T(@NonNull Parcel parcel, int i2, @NonNull PendingIntent pendingIntent, boolean z) {
        if (pendingIntent != null) {
            int f0 = f0(parcel, i2);
            PendingIntent.writePendingIntentOrNullToParcel(pendingIntent, parcel);
            g0(parcel, f0);
        } else if (z) {
            h0(parcel, i2, 0);
        }
    }

    public static void U(@NonNull Parcel parcel, int i2, short s) {
        h0(parcel, i2, 4);
        parcel.writeInt(s);
    }

    public static void V(@NonNull Parcel parcel, int i2, @NonNull SparseBooleanArray sparseBooleanArray, boolean z) {
        if (sparseBooleanArray != null) {
            int f0 = f0(parcel, i2);
            parcel.writeSparseBooleanArray(sparseBooleanArray);
            g0(parcel, f0);
        } else if (z) {
            h0(parcel, i2, 0);
        }
    }

    public static void W(@NonNull Parcel parcel, int i2, @NonNull SparseIntArray sparseIntArray, boolean z) {
        if (sparseIntArray != null) {
            int f0 = f0(parcel, i2);
            int size = sparseIntArray.size();
            parcel.writeInt(size);
            for (int i3 = 0; i3 < size; i3++) {
                parcel.writeInt(sparseIntArray.keyAt(i3));
                parcel.writeInt(sparseIntArray.valueAt(i3));
            }
            g0(parcel, f0);
        } else if (z) {
            h0(parcel, i2, 0);
        }
    }

    public static void X(@NonNull Parcel parcel, int i2, @NonNull SparseLongArray sparseLongArray, boolean z) {
        if (sparseLongArray != null) {
            int f0 = f0(parcel, i2);
            int size = sparseLongArray.size();
            parcel.writeInt(size);
            for (int i3 = 0; i3 < size; i3++) {
                parcel.writeInt(sparseLongArray.keyAt(i3));
                parcel.writeLong(sparseLongArray.valueAt(i3));
            }
            g0(parcel, f0);
        } else if (z) {
            h0(parcel, i2, 0);
        }
    }

    public static void Y(@NonNull Parcel parcel, int i2, @NonNull String str, boolean z) {
        if (str != null) {
            int f0 = f0(parcel, i2);
            parcel.writeString(str);
            g0(parcel, f0);
        } else if (z) {
            h0(parcel, i2, 0);
        }
    }

    public static void Z(@NonNull Parcel parcel, int i2, @NonNull String[] strArr, boolean z) {
        if (strArr != null) {
            int f0 = f0(parcel, i2);
            parcel.writeStringArray(strArr);
            g0(parcel, f0);
        } else if (z) {
            h0(parcel, i2, 0);
        }
    }

    public static int a(@NonNull Parcel parcel) {
        return f0(parcel, 20293);
    }

    public static void a0(@NonNull Parcel parcel, int i2, @NonNull List<String> list, boolean z) {
        if (list != null) {
            int f0 = f0(parcel, i2);
            parcel.writeStringList(list);
            g0(parcel, f0);
        } else if (z) {
            h0(parcel, i2, 0);
        }
    }

    public static void b(@NonNull Parcel parcel, int i2) {
        g0(parcel, i2);
    }

    public static void b0(@NonNull Parcel parcel, int i2, @NonNull SparseArray<String> sparseArray, boolean z) {
        if (sparseArray != null) {
            int f0 = f0(parcel, i2);
            int size = sparseArray.size();
            parcel.writeInt(size);
            for (int i3 = 0; i3 < size; i3++) {
                parcel.writeInt(sparseArray.keyAt(i3));
                parcel.writeString(sparseArray.valueAt(i3));
            }
            g0(parcel, f0);
        } else if (z) {
            h0(parcel, i2, 0);
        }
    }

    public static void c(@NonNull Parcel parcel, int i2, @NonNull BigDecimal bigDecimal, boolean z) {
        if (bigDecimal != null) {
            int f0 = f0(parcel, i2);
            parcel.writeByteArray(bigDecimal.unscaledValue().toByteArray());
            parcel.writeInt(bigDecimal.scale());
            g0(parcel, f0);
        } else if (z) {
            h0(parcel, i2, 0);
        }
    }

    public static <T extends Parcelable> void c0(@NonNull Parcel parcel, int i2, @NonNull T[] tArr, int i3, boolean z) {
        if (tArr != null) {
            int f0 = f0(parcel, i2);
            parcel.writeInt(r7);
            for (T t : tArr) {
                if (t == null) {
                    parcel.writeInt(0);
                } else {
                    i0(parcel, t, i3);
                }
            }
            g0(parcel, f0);
        } else if (z) {
            h0(parcel, i2, 0);
        }
    }

    public static void d(@NonNull Parcel parcel, int i2, @NonNull BigDecimal[] bigDecimalArr, boolean z) {
        if (bigDecimalArr != null) {
            int f0 = f0(parcel, i2);
            int length = bigDecimalArr.length;
            parcel.writeInt(length);
            for (int i3 = 0; i3 < length; i3++) {
                parcel.writeByteArray(bigDecimalArr[i3].unscaledValue().toByteArray());
                parcel.writeInt(bigDecimalArr[i3].scale());
            }
            g0(parcel, f0);
        } else if (z) {
            h0(parcel, i2, 0);
        }
    }

    public static <T extends Parcelable> void d0(@NonNull Parcel parcel, int i2, @NonNull List<T> list, boolean z) {
        if (list != null) {
            int f0 = f0(parcel, i2);
            int size = list.size();
            parcel.writeInt(size);
            for (int i3 = 0; i3 < size; i3++) {
                Parcelable parcelable = (Parcelable) list.get(i3);
                if (parcelable == null) {
                    parcel.writeInt(0);
                } else {
                    i0(parcel, parcelable, 0);
                }
            }
            g0(parcel, f0);
        } else if (z) {
            h0(parcel, i2, 0);
        }
    }

    public static void e(@NonNull Parcel parcel, int i2, @NonNull BigInteger bigInteger, boolean z) {
        if (bigInteger != null) {
            int f0 = f0(parcel, i2);
            parcel.writeByteArray(bigInteger.toByteArray());
            g0(parcel, f0);
        } else if (z) {
            h0(parcel, i2, 0);
        }
    }

    public static <T extends Parcelable> void e0(@NonNull Parcel parcel, int i2, @NonNull SparseArray<T> sparseArray, boolean z) {
        if (sparseArray != null) {
            int f0 = f0(parcel, i2);
            int size = sparseArray.size();
            parcel.writeInt(size);
            for (int i3 = 0; i3 < size; i3++) {
                parcel.writeInt(sparseArray.keyAt(i3));
                Parcelable parcelable = (Parcelable) sparseArray.valueAt(i3);
                if (parcelable == null) {
                    parcel.writeInt(0);
                } else {
                    i0(parcel, parcelable, 0);
                }
            }
            g0(parcel, f0);
        } else if (z) {
            h0(parcel, i2, 0);
        }
    }

    public static void f(@NonNull Parcel parcel, int i2, @NonNull BigInteger[] bigIntegerArr, boolean z) {
        if (bigIntegerArr != null) {
            int f0 = f0(parcel, i2);
            parcel.writeInt(r5);
            for (BigInteger byteArray : bigIntegerArr) {
                parcel.writeByteArray(byteArray.toByteArray());
            }
            g0(parcel, f0);
        } else if (z) {
            h0(parcel, i2, 0);
        }
    }

    private static int f0(Parcel parcel, int i2) {
        parcel.writeInt(i2 | SupportMenu.f5941c);
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    public static void g(@NonNull Parcel parcel, int i2, boolean z) {
        h0(parcel, i2, 4);
        parcel.writeInt(z ? 1 : 0);
    }

    private static void g0(Parcel parcel, int i2) {
        int dataPosition = parcel.dataPosition();
        parcel.setDataPosition(i2 - 4);
        parcel.writeInt(dataPosition - i2);
        parcel.setDataPosition(dataPosition);
    }

    public static void h(@NonNull Parcel parcel, int i2, @NonNull boolean[] zArr, boolean z) {
        if (zArr != null) {
            int f0 = f0(parcel, i2);
            parcel.writeBooleanArray(zArr);
            g0(parcel, f0);
        } else if (z) {
            h0(parcel, i2, 0);
        }
    }

    private static void h0(Parcel parcel, int i2, int i3) {
        parcel.writeInt(i2 | (i3 << 16));
    }

    public static void i(@NonNull Parcel parcel, int i2, @NonNull List<Boolean> list, boolean z) {
        if (list != null) {
            int f0 = f0(parcel, i2);
            int size = list.size();
            parcel.writeInt(size);
            for (int i3 = 0; i3 < size; i3++) {
                parcel.writeInt(list.get(i3).booleanValue() ? 1 : 0);
            }
            g0(parcel, f0);
        } else if (z) {
            h0(parcel, i2, 0);
        }
    }

    private static void i0(Parcel parcel, Parcelable parcelable, int i2) {
        int dataPosition = parcel.dataPosition();
        parcel.writeInt(1);
        int dataPosition2 = parcel.dataPosition();
        parcelable.writeToParcel(parcel, i2);
        int dataPosition3 = parcel.dataPosition();
        parcel.setDataPosition(dataPosition);
        parcel.writeInt(dataPosition3 - dataPosition2);
        parcel.setDataPosition(dataPosition3);
    }

    public static void j(@NonNull Parcel parcel, int i2, @NonNull Boolean bool, boolean z) {
        if (bool != null) {
            h0(parcel, i2, 4);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        } else if (z) {
            h0(parcel, i2, 0);
        }
    }

    public static void k(@NonNull Parcel parcel, int i2, @NonNull Bundle bundle, boolean z) {
        if (bundle != null) {
            int f0 = f0(parcel, i2);
            parcel.writeBundle(bundle);
            g0(parcel, f0);
        } else if (z) {
            h0(parcel, i2, 0);
        }
    }

    public static void l(@NonNull Parcel parcel, int i2, byte b2) {
        h0(parcel, i2, 4);
        parcel.writeInt(b2);
    }

    public static void m(@NonNull Parcel parcel, int i2, @NonNull byte[] bArr, boolean z) {
        if (bArr != null) {
            int f0 = f0(parcel, i2);
            parcel.writeByteArray(bArr);
            g0(parcel, f0);
        } else if (z) {
            h0(parcel, i2, 0);
        }
    }

    public static void n(@NonNull Parcel parcel, int i2, @NonNull byte[][] bArr, boolean z) {
        if (bArr != null) {
            int f0 = f0(parcel, i2);
            parcel.writeInt(r5);
            for (byte[] writeByteArray : bArr) {
                parcel.writeByteArray(writeByteArray);
            }
            g0(parcel, f0);
        } else if (z) {
            h0(parcel, i2, 0);
        }
    }

    public static void o(@NonNull Parcel parcel, int i2, @NonNull SparseArray<byte[]> sparseArray, boolean z) {
        if (sparseArray != null) {
            int f0 = f0(parcel, i2);
            int size = sparseArray.size();
            parcel.writeInt(size);
            for (int i3 = 0; i3 < size; i3++) {
                parcel.writeInt(sparseArray.keyAt(i3));
                parcel.writeByteArray(sparseArray.valueAt(i3));
            }
            g0(parcel, f0);
        } else if (z) {
            h0(parcel, i2, 0);
        }
    }

    public static void p(@NonNull Parcel parcel, int i2, char c2) {
        h0(parcel, i2, 4);
        parcel.writeInt(c2);
    }

    public static void q(@NonNull Parcel parcel, int i2, @NonNull char[] cArr, boolean z) {
        if (cArr != null) {
            int f0 = f0(parcel, i2);
            parcel.writeCharArray(cArr);
            g0(parcel, f0);
        } else if (z) {
            h0(parcel, i2, 0);
        }
    }

    public static void r(@NonNull Parcel parcel, int i2, double d2) {
        h0(parcel, i2, 8);
        parcel.writeDouble(d2);
    }

    public static void s(@NonNull Parcel parcel, int i2, @NonNull double[] dArr, boolean z) {
        if (dArr != null) {
            int f0 = f0(parcel, i2);
            parcel.writeDoubleArray(dArr);
            g0(parcel, f0);
        } else if (z) {
            h0(parcel, i2, 0);
        }
    }

    public static void t(@NonNull Parcel parcel, int i2, @NonNull List<Double> list, boolean z) {
        if (list != null) {
            int f0 = f0(parcel, i2);
            int size = list.size();
            parcel.writeInt(size);
            for (int i3 = 0; i3 < size; i3++) {
                parcel.writeDouble(list.get(i3).doubleValue());
            }
            g0(parcel, f0);
        } else if (z) {
            h0(parcel, i2, 0);
        }
    }

    public static void u(@NonNull Parcel parcel, int i2, @NonNull Double d2, boolean z) {
        if (d2 != null) {
            h0(parcel, i2, 8);
            parcel.writeDouble(d2.doubleValue());
        } else if (z) {
            h0(parcel, i2, 0);
        }
    }

    public static void v(@NonNull Parcel parcel, int i2, @NonNull SparseArray<Double> sparseArray, boolean z) {
        if (sparseArray != null) {
            int f0 = f0(parcel, i2);
            int size = sparseArray.size();
            parcel.writeInt(size);
            for (int i3 = 0; i3 < size; i3++) {
                parcel.writeInt(sparseArray.keyAt(i3));
                parcel.writeDouble(sparseArray.valueAt(i3).doubleValue());
            }
            g0(parcel, f0);
        } else if (z) {
            h0(parcel, i2, 0);
        }
    }

    public static void w(@NonNull Parcel parcel, int i2, float f2) {
        h0(parcel, i2, 4);
        parcel.writeFloat(f2);
    }

    public static void x(@NonNull Parcel parcel, int i2, @NonNull float[] fArr, boolean z) {
        if (fArr != null) {
            int f0 = f0(parcel, i2);
            parcel.writeFloatArray(fArr);
            g0(parcel, f0);
        } else if (z) {
            h0(parcel, i2, 0);
        }
    }

    public static void y(@NonNull Parcel parcel, int i2, @NonNull List<Float> list, boolean z) {
        if (list != null) {
            int f0 = f0(parcel, i2);
            int size = list.size();
            parcel.writeInt(size);
            for (int i3 = 0; i3 < size; i3++) {
                parcel.writeFloat(list.get(i3).floatValue());
            }
            g0(parcel, f0);
        } else if (z) {
            h0(parcel, i2, 0);
        }
    }

    public static void z(@NonNull Parcel parcel, int i2, @NonNull Float f2, boolean z) {
        if (f2 != null) {
            h0(parcel, i2, 4);
            parcel.writeFloat(f2.floatValue());
        } else if (z) {
            h0(parcel, i2, 0);
        }
    }
}
