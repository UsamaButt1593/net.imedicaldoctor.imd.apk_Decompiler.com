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
import java.util.ArrayList;
import java.util.List;

public class SafeParcelReader {

    public static class ParseException extends RuntimeException {
        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public ParseException(@androidx.annotation.NonNull java.lang.String r3, @androidx.annotation.NonNull android.os.Parcel r4) {
            /*
                r2 = this;
                int r0 = r4.dataPosition()
                int r4 = r4.dataSize()
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                r1.append(r3)
                java.lang.String r3 = " Parcel: pos="
                r1.append(r3)
                r1.append(r0)
                java.lang.String r3 = " size="
                r1.append(r3)
                r1.append(r4)
                java.lang.String r3 = r1.toString()
                r2.<init>(r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.safeparcel.SafeParcelReader.ParseException.<init>(java.lang.String, android.os.Parcel):void");
        }
    }

    private SafeParcelReader() {
    }

    @NonNull
    public static ArrayList<Parcel> A(@NonNull Parcel parcel, int i2) {
        int g0 = g0(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (g0 == 0) {
            return null;
        }
        int readInt = parcel.readInt();
        ArrayList<Parcel> arrayList = new ArrayList<>();
        for (int i3 = 0; i3 < readInt; i3++) {
            int readInt2 = parcel.readInt();
            if (readInt2 != 0) {
                int dataPosition2 = parcel.dataPosition();
                Parcel obtain = Parcel.obtain();
                obtain.appendFrom(parcel, dataPosition2, readInt2);
                arrayList.add(obtain);
                parcel.setDataPosition(dataPosition2 + readInt2);
            } else {
                arrayList.add((Object) null);
            }
        }
        parcel.setDataPosition(dataPosition + g0);
        return arrayList;
    }

    @NonNull
    public static SparseArray<Parcel> B(@NonNull Parcel parcel, int i2) {
        int g0 = g0(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (g0 == 0) {
            return null;
        }
        int readInt = parcel.readInt();
        SparseArray<Parcel> sparseArray = new SparseArray<>();
        for (int i3 = 0; i3 < readInt; i3++) {
            int readInt2 = parcel.readInt();
            int readInt3 = parcel.readInt();
            if (readInt3 != 0) {
                int dataPosition2 = parcel.dataPosition();
                Parcel obtain = Parcel.obtain();
                obtain.appendFrom(parcel, dataPosition2, readInt3);
                sparseArray.append(readInt2, obtain);
                parcel.setDataPosition(dataPosition2 + readInt3);
            } else {
                sparseArray.append(readInt2, (Object) null);
            }
        }
        parcel.setDataPosition(dataPosition + g0);
        return sparseArray;
    }

    @NonNull
    public static <T extends Parcelable> T C(@NonNull Parcel parcel, int i2, @NonNull Parcelable.Creator<T> creator) {
        int g0 = g0(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (g0 == 0) {
            return null;
        }
        T t = (Parcelable) creator.createFromParcel(parcel);
        parcel.setDataPosition(dataPosition + g0);
        return t;
    }

    @NonNull
    public static SparseBooleanArray D(@NonNull Parcel parcel, int i2) {
        int g0 = g0(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (g0 == 0) {
            return null;
        }
        SparseBooleanArray readSparseBooleanArray = parcel.readSparseBooleanArray();
        parcel.setDataPosition(dataPosition + g0);
        return readSparseBooleanArray;
    }

    @NonNull
    public static SparseIntArray E(@NonNull Parcel parcel, int i2) {
        int g0 = g0(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (g0 == 0) {
            return null;
        }
        SparseIntArray sparseIntArray = new SparseIntArray();
        int readInt = parcel.readInt();
        for (int i3 = 0; i3 < readInt; i3++) {
            sparseIntArray.append(parcel.readInt(), parcel.readInt());
        }
        parcel.setDataPosition(dataPosition + g0);
        return sparseIntArray;
    }

    @NonNull
    public static SparseLongArray F(@NonNull Parcel parcel, int i2) {
        int g0 = g0(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (g0 == 0) {
            return null;
        }
        SparseLongArray sparseLongArray = new SparseLongArray();
        int readInt = parcel.readInt();
        for (int i3 = 0; i3 < readInt; i3++) {
            sparseLongArray.append(parcel.readInt(), parcel.readLong());
        }
        parcel.setDataPosition(dataPosition + g0);
        return sparseLongArray;
    }

    @NonNull
    public static String G(@NonNull Parcel parcel, int i2) {
        int g0 = g0(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (g0 == 0) {
            return null;
        }
        String readString = parcel.readString();
        parcel.setDataPosition(dataPosition + g0);
        return readString;
    }

    @NonNull
    public static String[] H(@NonNull Parcel parcel, int i2) {
        int g0 = g0(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (g0 == 0) {
            return null;
        }
        String[] createStringArray = parcel.createStringArray();
        parcel.setDataPosition(dataPosition + g0);
        return createStringArray;
    }

    @NonNull
    public static ArrayList<String> I(@NonNull Parcel parcel, int i2) {
        int g0 = g0(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (g0 == 0) {
            return null;
        }
        ArrayList<String> createStringArrayList = parcel.createStringArrayList();
        parcel.setDataPosition(dataPosition + g0);
        return createStringArrayList;
    }

    @NonNull
    public static SparseArray<String> J(@NonNull Parcel parcel, int i2) {
        int g0 = g0(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (g0 == 0) {
            return null;
        }
        SparseArray<String> sparseArray = new SparseArray<>();
        int readInt = parcel.readInt();
        for (int i3 = 0; i3 < readInt; i3++) {
            sparseArray.append(parcel.readInt(), parcel.readString());
        }
        parcel.setDataPosition(dataPosition + g0);
        return sparseArray;
    }

    @NonNull
    public static <T> T[] K(@NonNull Parcel parcel, int i2, @NonNull Parcelable.Creator<T> creator) {
        int g0 = g0(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (g0 == 0) {
            return null;
        }
        T[] createTypedArray = parcel.createTypedArray(creator);
        parcel.setDataPosition(dataPosition + g0);
        return createTypedArray;
    }

    @NonNull
    public static <T> ArrayList<T> L(@NonNull Parcel parcel, int i2, @NonNull Parcelable.Creator<T> creator) {
        int g0 = g0(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (g0 == 0) {
            return null;
        }
        ArrayList<T> createTypedArrayList = parcel.createTypedArrayList(creator);
        parcel.setDataPosition(dataPosition + g0);
        return createTypedArrayList;
    }

    @NonNull
    public static <T> SparseArray<T> M(@NonNull Parcel parcel, int i2, @NonNull Parcelable.Creator<T> creator) {
        int g0 = g0(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (g0 == 0) {
            return null;
        }
        int readInt = parcel.readInt();
        SparseArray<T> sparseArray = new SparseArray<>();
        for (int i3 = 0; i3 < readInt; i3++) {
            sparseArray.append(parcel.readInt(), parcel.readInt() != 0 ? creator.createFromParcel(parcel) : null);
        }
        parcel.setDataPosition(dataPosition + g0);
        return sparseArray;
    }

    public static void N(@NonNull Parcel parcel, int i2) {
        if (parcel.dataPosition() != i2) {
            throw new ParseException("Overread allowed size end=" + i2, parcel);
        }
    }

    public static int O(int i2) {
        return (char) i2;
    }

    public static boolean P(@NonNull Parcel parcel, int i2) {
        k0(parcel, i2, 4);
        return parcel.readInt() != 0;
    }

    @NonNull
    public static Boolean Q(@NonNull Parcel parcel, int i2) {
        int g0 = g0(parcel, i2);
        if (g0 == 0) {
            return null;
        }
        j0(parcel, i2, g0, 4);
        return Boolean.valueOf(parcel.readInt() != 0);
    }

    public static byte R(@NonNull Parcel parcel, int i2) {
        k0(parcel, i2, 4);
        return (byte) parcel.readInt();
    }

    public static char S(@NonNull Parcel parcel, int i2) {
        k0(parcel, i2, 4);
        return (char) parcel.readInt();
    }

    public static double T(@NonNull Parcel parcel, int i2) {
        k0(parcel, i2, 8);
        return parcel.readDouble();
    }

    @NonNull
    public static Double U(@NonNull Parcel parcel, int i2) {
        int g0 = g0(parcel, i2);
        if (g0 == 0) {
            return null;
        }
        j0(parcel, i2, g0, 8);
        return Double.valueOf(parcel.readDouble());
    }

    public static float V(@NonNull Parcel parcel, int i2) {
        k0(parcel, i2, 4);
        return parcel.readFloat();
    }

    @NonNull
    public static Float W(@NonNull Parcel parcel, int i2) {
        int g0 = g0(parcel, i2);
        if (g0 == 0) {
            return null;
        }
        j0(parcel, i2, g0, 4);
        return Float.valueOf(parcel.readFloat());
    }

    public static int X(@NonNull Parcel parcel) {
        return parcel.readInt();
    }

    @NonNull
    public static IBinder Y(@NonNull Parcel parcel, int i2) {
        int g0 = g0(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (g0 == 0) {
            return null;
        }
        IBinder readStrongBinder = parcel.readStrongBinder();
        parcel.setDataPosition(dataPosition + g0);
        return readStrongBinder;
    }

    public static int Z(@NonNull Parcel parcel, int i2) {
        k0(parcel, i2, 4);
        return parcel.readInt();
    }

    @NonNull
    public static BigDecimal a(@NonNull Parcel parcel, int i2) {
        int g0 = g0(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (g0 == 0) {
            return null;
        }
        byte[] createByteArray = parcel.createByteArray();
        int readInt = parcel.readInt();
        parcel.setDataPosition(dataPosition + g0);
        return new BigDecimal(new BigInteger(createByteArray), readInt);
    }

    @NonNull
    public static Integer a0(@NonNull Parcel parcel, int i2) {
        int g0 = g0(parcel, i2);
        if (g0 == 0) {
            return null;
        }
        j0(parcel, i2, g0, 4);
        return Integer.valueOf(parcel.readInt());
    }

    @NonNull
    public static BigDecimal[] b(@NonNull Parcel parcel, int i2) {
        int g0 = g0(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (g0 == 0) {
            return null;
        }
        int readInt = parcel.readInt();
        BigDecimal[] bigDecimalArr = new BigDecimal[readInt];
        for (int i3 = 0; i3 < readInt; i3++) {
            byte[] createByteArray = parcel.createByteArray();
            bigDecimalArr[i3] = new BigDecimal(new BigInteger(createByteArray), parcel.readInt());
        }
        parcel.setDataPosition(dataPosition + g0);
        return bigDecimalArr;
    }

    public static void b0(@NonNull Parcel parcel, int i2, @NonNull List list, @NonNull ClassLoader classLoader) {
        int g0 = g0(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (g0 != 0) {
            parcel.readList(list, classLoader);
            parcel.setDataPosition(dataPosition + g0);
        }
    }

    @NonNull
    public static BigInteger c(@NonNull Parcel parcel, int i2) {
        int g0 = g0(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (g0 == 0) {
            return null;
        }
        byte[] createByteArray = parcel.createByteArray();
        parcel.setDataPosition(dataPosition + g0);
        return new BigInteger(createByteArray);
    }

    public static long c0(@NonNull Parcel parcel, int i2) {
        k0(parcel, i2, 8);
        return parcel.readLong();
    }

    @NonNull
    public static BigInteger[] d(@NonNull Parcel parcel, int i2) {
        int g0 = g0(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (g0 == 0) {
            return null;
        }
        int readInt = parcel.readInt();
        BigInteger[] bigIntegerArr = new BigInteger[readInt];
        for (int i3 = 0; i3 < readInt; i3++) {
            bigIntegerArr[i3] = new BigInteger(parcel.createByteArray());
        }
        parcel.setDataPosition(dataPosition + g0);
        return bigIntegerArr;
    }

    @NonNull
    public static Long d0(@NonNull Parcel parcel, int i2) {
        int g0 = g0(parcel, i2);
        if (g0 == 0) {
            return null;
        }
        j0(parcel, i2, g0, 8);
        return Long.valueOf(parcel.readLong());
    }

    @NonNull
    public static boolean[] e(@NonNull Parcel parcel, int i2) {
        int g0 = g0(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (g0 == 0) {
            return null;
        }
        boolean[] createBooleanArray = parcel.createBooleanArray();
        parcel.setDataPosition(dataPosition + g0);
        return createBooleanArray;
    }

    @NonNull
    public static PendingIntent e0(@NonNull Parcel parcel, int i2) {
        int g0 = g0(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (g0 == 0) {
            return null;
        }
        PendingIntent readPendingIntentOrNullFromParcel = PendingIntent.readPendingIntentOrNullFromParcel(parcel);
        parcel.setDataPosition(dataPosition + g0);
        return readPendingIntentOrNullFromParcel;
    }

    @NonNull
    public static ArrayList<Boolean> f(@NonNull Parcel parcel, int i2) {
        int g0 = g0(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (g0 == 0) {
            return null;
        }
        ArrayList<Boolean> arrayList = new ArrayList<>();
        int readInt = parcel.readInt();
        for (int i3 = 0; i3 < readInt; i3++) {
            arrayList.add(Boolean.valueOf(parcel.readInt() != 0));
        }
        parcel.setDataPosition(dataPosition + g0);
        return arrayList;
    }

    public static short f0(@NonNull Parcel parcel, int i2) {
        k0(parcel, i2, 4);
        return (short) parcel.readInt();
    }

    @NonNull
    public static Bundle g(@NonNull Parcel parcel, int i2) {
        int g0 = g0(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (g0 == 0) {
            return null;
        }
        Bundle readBundle = parcel.readBundle();
        parcel.setDataPosition(dataPosition + g0);
        return readBundle;
    }

    public static int g0(@NonNull Parcel parcel, int i2) {
        return (i2 & SupportMenu.f5941c) != -65536 ? (char) (i2 >> 16) : parcel.readInt();
    }

    @NonNull
    public static byte[] h(@NonNull Parcel parcel, int i2) {
        int g0 = g0(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (g0 == 0) {
            return null;
        }
        byte[] createByteArray = parcel.createByteArray();
        parcel.setDataPosition(dataPosition + g0);
        return createByteArray;
    }

    public static void h0(@NonNull Parcel parcel, int i2) {
        parcel.setDataPosition(parcel.dataPosition() + g0(parcel, i2));
    }

    @NonNull
    public static byte[][] i(@NonNull Parcel parcel, int i2) {
        int g0 = g0(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (g0 == 0) {
            return null;
        }
        int readInt = parcel.readInt();
        byte[][] bArr = new byte[readInt][];
        for (int i3 = 0; i3 < readInt; i3++) {
            bArr[i3] = parcel.createByteArray();
        }
        parcel.setDataPosition(dataPosition + g0);
        return bArr;
    }

    public static int i0(@NonNull Parcel parcel) {
        int X = X(parcel);
        int g0 = g0(parcel, X);
        int O = O(X);
        int dataPosition = parcel.dataPosition();
        if (O == 20293) {
            int i2 = g0 + dataPosition;
            if (i2 >= dataPosition && i2 <= parcel.dataSize()) {
                return i2;
            }
            throw new ParseException("Size read is invalid start=" + dataPosition + " end=" + i2, parcel);
        }
        throw new ParseException("Expected object header. Got 0x".concat(String.valueOf(Integer.toHexString(X))), parcel);
    }

    @NonNull
    public static SparseArray<byte[]> j(@NonNull Parcel parcel, int i2) {
        int g0 = g0(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (g0 == 0) {
            return null;
        }
        int readInt = parcel.readInt();
        SparseArray<byte[]> sparseArray = new SparseArray<>(readInt);
        for (int i3 = 0; i3 < readInt; i3++) {
            sparseArray.append(parcel.readInt(), parcel.createByteArray());
        }
        parcel.setDataPosition(dataPosition + g0);
        return sparseArray;
    }

    private static void j0(Parcel parcel, int i2, int i3, int i4) {
        if (i3 != i4) {
            String hexString = Integer.toHexString(i3);
            throw new ParseException("Expected size " + i4 + " got " + i3 + " (0x" + hexString + ")", parcel);
        }
    }

    @NonNull
    public static char[] k(@NonNull Parcel parcel, int i2) {
        int g0 = g0(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (g0 == 0) {
            return null;
        }
        char[] createCharArray = parcel.createCharArray();
        parcel.setDataPosition(dataPosition + g0);
        return createCharArray;
    }

    private static void k0(Parcel parcel, int i2, int i3) {
        int g0 = g0(parcel, i2);
        if (g0 != i3) {
            String hexString = Integer.toHexString(g0);
            throw new ParseException("Expected size " + i3 + " got " + g0 + " (0x" + hexString + ")", parcel);
        }
    }

    @NonNull
    public static double[] l(@NonNull Parcel parcel, int i2) {
        int g0 = g0(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (g0 == 0) {
            return null;
        }
        double[] createDoubleArray = parcel.createDoubleArray();
        parcel.setDataPosition(dataPosition + g0);
        return createDoubleArray;
    }

    @NonNull
    public static ArrayList<Double> m(@NonNull Parcel parcel, int i2) {
        int g0 = g0(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (g0 == 0) {
            return null;
        }
        ArrayList<Double> arrayList = new ArrayList<>();
        int readInt = parcel.readInt();
        for (int i3 = 0; i3 < readInt; i3++) {
            arrayList.add(Double.valueOf(parcel.readDouble()));
        }
        parcel.setDataPosition(dataPosition + g0);
        return arrayList;
    }

    @NonNull
    public static SparseArray<Double> n(@NonNull Parcel parcel, int i2) {
        int g0 = g0(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (g0 == 0) {
            return null;
        }
        SparseArray<Double> sparseArray = new SparseArray<>();
        int readInt = parcel.readInt();
        for (int i3 = 0; i3 < readInt; i3++) {
            sparseArray.append(parcel.readInt(), Double.valueOf(parcel.readDouble()));
        }
        parcel.setDataPosition(dataPosition + g0);
        return sparseArray;
    }

    @NonNull
    public static float[] o(@NonNull Parcel parcel, int i2) {
        int g0 = g0(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (g0 == 0) {
            return null;
        }
        float[] createFloatArray = parcel.createFloatArray();
        parcel.setDataPosition(dataPosition + g0);
        return createFloatArray;
    }

    @NonNull
    public static ArrayList<Float> p(@NonNull Parcel parcel, int i2) {
        int g0 = g0(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (g0 == 0) {
            return null;
        }
        ArrayList<Float> arrayList = new ArrayList<>();
        int readInt = parcel.readInt();
        for (int i3 = 0; i3 < readInt; i3++) {
            arrayList.add(Float.valueOf(parcel.readFloat()));
        }
        parcel.setDataPosition(dataPosition + g0);
        return arrayList;
    }

    @NonNull
    public static SparseArray<Float> q(@NonNull Parcel parcel, int i2) {
        int g0 = g0(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (g0 == 0) {
            return null;
        }
        SparseArray<Float> sparseArray = new SparseArray<>();
        int readInt = parcel.readInt();
        for (int i3 = 0; i3 < readInt; i3++) {
            sparseArray.append(parcel.readInt(), Float.valueOf(parcel.readFloat()));
        }
        parcel.setDataPosition(dataPosition + g0);
        return sparseArray;
    }

    @NonNull
    public static IBinder[] r(@NonNull Parcel parcel, int i2) {
        int g0 = g0(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (g0 == 0) {
            return null;
        }
        IBinder[] createBinderArray = parcel.createBinderArray();
        parcel.setDataPosition(dataPosition + g0);
        return createBinderArray;
    }

    @NonNull
    public static ArrayList<IBinder> s(@NonNull Parcel parcel, int i2) {
        int g0 = g0(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (g0 == 0) {
            return null;
        }
        ArrayList<IBinder> createBinderArrayList = parcel.createBinderArrayList();
        parcel.setDataPosition(dataPosition + g0);
        return createBinderArrayList;
    }

    @NonNull
    public static SparseArray<IBinder> t(@NonNull Parcel parcel, int i2) {
        int g0 = g0(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (g0 == 0) {
            return null;
        }
        int readInt = parcel.readInt();
        SparseArray<IBinder> sparseArray = new SparseArray<>(readInt);
        for (int i3 = 0; i3 < readInt; i3++) {
            sparseArray.append(parcel.readInt(), parcel.readStrongBinder());
        }
        parcel.setDataPosition(dataPosition + g0);
        return sparseArray;
    }

    @NonNull
    public static int[] u(@NonNull Parcel parcel, int i2) {
        int g0 = g0(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (g0 == 0) {
            return null;
        }
        int[] createIntArray = parcel.createIntArray();
        parcel.setDataPosition(dataPosition + g0);
        return createIntArray;
    }

    @NonNull
    public static ArrayList<Integer> v(@NonNull Parcel parcel, int i2) {
        int g0 = g0(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (g0 == 0) {
            return null;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        int readInt = parcel.readInt();
        for (int i3 = 0; i3 < readInt; i3++) {
            arrayList.add(Integer.valueOf(parcel.readInt()));
        }
        parcel.setDataPosition(dataPosition + g0);
        return arrayList;
    }

    @NonNull
    public static long[] w(@NonNull Parcel parcel, int i2) {
        int g0 = g0(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (g0 == 0) {
            return null;
        }
        long[] createLongArray = parcel.createLongArray();
        parcel.setDataPosition(dataPosition + g0);
        return createLongArray;
    }

    @NonNull
    public static ArrayList<Long> x(@NonNull Parcel parcel, int i2) {
        int g0 = g0(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (g0 == 0) {
            return null;
        }
        ArrayList<Long> arrayList = new ArrayList<>();
        int readInt = parcel.readInt();
        for (int i3 = 0; i3 < readInt; i3++) {
            arrayList.add(Long.valueOf(parcel.readLong()));
        }
        parcel.setDataPosition(dataPosition + g0);
        return arrayList;
    }

    @NonNull
    public static Parcel y(@NonNull Parcel parcel, int i2) {
        int g0 = g0(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (g0 == 0) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        obtain.appendFrom(parcel, dataPosition, g0);
        parcel.setDataPosition(dataPosition + g0);
        return obtain;
    }

    @NonNull
    public static Parcel[] z(@NonNull Parcel parcel, int i2) {
        int g0 = g0(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (g0 == 0) {
            return null;
        }
        int readInt = parcel.readInt();
        Parcel[] parcelArr = new Parcel[readInt];
        for (int i3 = 0; i3 < readInt; i3++) {
            int readInt2 = parcel.readInt();
            if (readInt2 != 0) {
                int dataPosition2 = parcel.dataPosition();
                Parcel obtain = Parcel.obtain();
                obtain.appendFrom(parcel, dataPosition2, readInt2);
                parcelArr[i3] = obtain;
                parcel.setDataPosition(dataPosition2 + readInt2);
            } else {
                parcelArr[i3] = null;
            }
        }
        parcel.setDataPosition(dataPosition + g0);
        return parcelArr;
    }
}
