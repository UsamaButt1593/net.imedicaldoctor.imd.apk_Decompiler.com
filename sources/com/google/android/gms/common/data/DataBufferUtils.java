package com.google.android.gms.common.data;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.ArrayList;

public final class DataBufferUtils {
    @NonNull
    @KeepForSdk

    /* renamed from: a  reason: collision with root package name */
    public static final String f20193a = "next_page_token";
    @NonNull
    @KeepForSdk

    /* renamed from: b  reason: collision with root package name */
    public static final String f20194b = "prev_page_token";

    private DataBufferUtils() {
    }

    @NonNull
    public static <T, E extends Freezable<T>> ArrayList<T> a(@NonNull DataBuffer<E> dataBuffer) {
        ArrayList<T> arrayList = new ArrayList<>(dataBuffer.getCount());
        try {
            for (E b2 : dataBuffer) {
                arrayList.add(b2.b());
            }
            return arrayList;
        } finally {
            dataBuffer.close();
        }
    }

    public static boolean b(@NonNull DataBuffer<?> dataBuffer) {
        return dataBuffer != null && dataBuffer.getCount() > 0;
    }

    public static boolean c(@NonNull DataBuffer<?> dataBuffer) {
        Bundle l2 = dataBuffer.l();
        return (l2 == null || l2.getString(f20193a) == null) ? false : true;
    }

    public static boolean d(@NonNull DataBuffer<?> dataBuffer) {
        Bundle l2 = dataBuffer.l();
        return (l2 == null || l2.getString(f20194b) == null) ? false : true;
    }
}
