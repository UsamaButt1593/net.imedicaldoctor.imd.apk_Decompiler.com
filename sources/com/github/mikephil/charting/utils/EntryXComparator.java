package com.github.mikephil.charting.utils;

import com.github.mikephil.charting.data.Entry;
import java.util.Comparator;

public class EntryXComparator implements Comparator<Entry> {
    /* renamed from: a */
    public int compare(Entry entry, Entry entry2) {
        int i2 = ((entry.m() - entry2.m()) > 0.0f ? 1 : ((entry.m() - entry2.m()) == 0.0f ? 0 : -1));
        if (i2 == 0) {
            return 0;
        }
        return i2 > 0 ? 1 : -1;
    }
}
