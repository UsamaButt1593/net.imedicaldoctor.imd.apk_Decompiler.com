package com.google.android.datatransport.cct.internal;

import android.util.SparseArray;
import androidx.annotation.Nullable;

public enum QosTier {
    DEFAULT(0),
    UNMETERED_ONLY(1),
    UNMETERED_OR_DAILY(2),
    FAST_IF_RADIO_AWAKE(3),
    NEVER(4),
    UNRECOGNIZED(-1);
    
    private static final SparseArray<QosTier> a3 = null;
    private final int s;

    static {
        QosTier qosTier;
        QosTier qosTier2;
        QosTier qosTier3;
        QosTier qosTier4;
        QosTier qosTier5;
        QosTier qosTier6;
        SparseArray<QosTier> sparseArray = new SparseArray<>();
        a3 = sparseArray;
        sparseArray.put(0, qosTier);
        sparseArray.put(1, qosTier2);
        sparseArray.put(2, qosTier3);
        sparseArray.put(3, qosTier4);
        sparseArray.put(4, qosTier5);
        sparseArray.put(-1, qosTier6);
    }

    private QosTier(int i2) {
        this.s = i2;
    }

    @Nullable
    public static QosTier a(int i2) {
        if (i2 == 0) {
            return DEFAULT;
        }
        if (i2 == 1) {
            return UNMETERED_ONLY;
        }
        if (i2 == 2) {
            return UNMETERED_OR_DAILY;
        }
        if (i2 == 3) {
            return FAST_IF_RADIO_AWAKE;
        }
        if (i2 != 4) {
            return null;
        }
        return NEVER;
    }

    public final int d() {
        return this.s;
    }
}
