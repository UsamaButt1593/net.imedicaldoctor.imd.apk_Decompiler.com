package com.google.android.datatransport.runtime.util;

import android.util.SparseArray;
import androidx.annotation.NonNull;
import com.google.android.datatransport.Priority;
import java.util.HashMap;

public final class PriorityMapping {

    /* renamed from: a  reason: collision with root package name */
    private static SparseArray<Priority> f19699a = new SparseArray<>();

    /* renamed from: b  reason: collision with root package name */
    private static HashMap<Priority, Integer> f19700b;

    static {
        HashMap<Priority, Integer> hashMap = new HashMap<>();
        f19700b = hashMap;
        hashMap.put(Priority.DEFAULT, 0);
        f19700b.put(Priority.VERY_LOW, 1);
        f19700b.put(Priority.HIGHEST, 2);
        for (Priority next : f19700b.keySet()) {
            f19699a.append(f19700b.get(next).intValue(), next);
        }
    }

    public static int a(@NonNull Priority priority) {
        Integer num = f19700b.get(priority);
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalStateException("PriorityMapping is missing known Priority value " + priority);
    }

    @NonNull
    public static Priority b(int i2) {
        Priority priority = f19699a.get(i2);
        if (priority != null) {
            return priority;
        }
        throw new IllegalArgumentException("Unknown Priority for value " + i2);
    }
}
