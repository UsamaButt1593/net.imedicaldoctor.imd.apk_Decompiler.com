package com.h6ah4i.android.widget.advrecyclerview.draggable;

import com.dd.plist.ASCIIPropertyListParser;

public class ItemDraggableRange {

    /* renamed from: a  reason: collision with root package name */
    private final int f25404a;

    /* renamed from: b  reason: collision with root package name */
    private final int f25405b;

    public ItemDraggableRange(int i2, int i3) {
        if (i2 <= i3) {
            this.f25404a = i2;
            this.f25405b = i3;
            return;
        }
        throw new IllegalArgumentException("end position (= " + i3 + ") is smaller than start position (=" + i2 + ")");
    }

    public boolean a(int i2) {
        return i2 >= this.f25404a && i2 <= this.f25405b;
    }

    /* access modifiers changed from: protected */
    public String b() {
        return "ItemDraggableRange";
    }

    public int c() {
        return this.f25405b;
    }

    public int d() {
        return this.f25404a;
    }

    public String toString() {
        return b() + "{" + "mStart=" + this.f25404a + ", mEnd=" + this.f25405b + ASCIIPropertyListParser.f18653k;
    }
}
