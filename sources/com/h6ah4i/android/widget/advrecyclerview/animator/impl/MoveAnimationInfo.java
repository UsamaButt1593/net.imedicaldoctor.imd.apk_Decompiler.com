package com.h6ah4i.android.widget.advrecyclerview.animator.impl;

import androidx.recyclerview.widget.RecyclerView;
import com.dd.plist.ASCIIPropertyListParser;

public class MoveAnimationInfo extends ItemAnimationInfo {

    /* renamed from: a  reason: collision with root package name */
    public RecyclerView.ViewHolder f25363a;

    /* renamed from: b  reason: collision with root package name */
    public int f25364b;

    /* renamed from: c  reason: collision with root package name */
    public int f25365c;

    /* renamed from: d  reason: collision with root package name */
    public int f25366d;

    /* renamed from: e  reason: collision with root package name */
    public int f25367e;

    public MoveAnimationInfo(RecyclerView.ViewHolder viewHolder, int i2, int i3, int i4, int i5) {
        this.f25363a = viewHolder;
        this.f25364b = i2;
        this.f25365c = i3;
        this.f25366d = i4;
        this.f25367e = i5;
    }

    public void a(RecyclerView.ViewHolder viewHolder) {
        if (this.f25363a == viewHolder) {
            this.f25363a = null;
        }
    }

    public RecyclerView.ViewHolder b() {
        return this.f25363a;
    }

    public String toString() {
        return "MoveAnimationInfo{holder=" + this.f25363a + ", fromX=" + this.f25364b + ", fromY=" + this.f25365c + ", toX=" + this.f25366d + ", toY=" + this.f25367e + ASCIIPropertyListParser.f18653k;
    }
}
