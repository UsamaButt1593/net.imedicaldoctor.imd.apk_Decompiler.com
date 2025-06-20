package com.h6ah4i.android.widget.advrecyclerview.animator.impl;

import androidx.recyclerview.widget.RecyclerView;
import com.dd.plist.ASCIIPropertyListParser;

public class ChangeAnimationInfo extends ItemAnimationInfo {

    /* renamed from: a  reason: collision with root package name */
    public RecyclerView.ViewHolder f25353a;

    /* renamed from: b  reason: collision with root package name */
    public RecyclerView.ViewHolder f25354b;

    /* renamed from: c  reason: collision with root package name */
    public int f25355c;

    /* renamed from: d  reason: collision with root package name */
    public int f25356d;

    /* renamed from: e  reason: collision with root package name */
    public int f25357e;

    /* renamed from: f  reason: collision with root package name */
    public int f25358f;

    public ChangeAnimationInfo(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2, int i2, int i3, int i4, int i5) {
        this.f25354b = viewHolder;
        this.f25353a = viewHolder2;
        this.f25355c = i2;
        this.f25356d = i3;
        this.f25357e = i4;
        this.f25358f = i5;
    }

    public void a(RecyclerView.ViewHolder viewHolder) {
        if (this.f25354b == viewHolder) {
            this.f25354b = null;
        }
        if (this.f25353a == viewHolder) {
            this.f25353a = null;
        }
        if (this.f25354b == null && this.f25353a == null) {
            this.f25355c = 0;
            this.f25356d = 0;
            this.f25357e = 0;
            this.f25358f = 0;
        }
    }

    public RecyclerView.ViewHolder b() {
        RecyclerView.ViewHolder viewHolder = this.f25354b;
        return viewHolder != null ? viewHolder : this.f25353a;
    }

    public String toString() {
        return "ChangeInfo{, oldHolder=" + this.f25354b + ", newHolder=" + this.f25353a + ", fromX=" + this.f25355c + ", fromY=" + this.f25356d + ", toX=" + this.f25357e + ", toY=" + this.f25358f + ASCIIPropertyListParser.f18653k;
    }
}
