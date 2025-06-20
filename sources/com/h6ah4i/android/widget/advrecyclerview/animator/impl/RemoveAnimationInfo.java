package com.h6ah4i.android.widget.advrecyclerview.animator.impl;

import androidx.recyclerview.widget.RecyclerView;
import com.dd.plist.ASCIIPropertyListParser;

public class RemoveAnimationInfo extends ItemAnimationInfo {

    /* renamed from: a  reason: collision with root package name */
    public RecyclerView.ViewHolder f25368a;

    public RemoveAnimationInfo(RecyclerView.ViewHolder viewHolder) {
        this.f25368a = viewHolder;
    }

    public void a(RecyclerView.ViewHolder viewHolder) {
        if (this.f25368a == viewHolder) {
            this.f25368a = null;
        }
    }

    public RecyclerView.ViewHolder b() {
        return this.f25368a;
    }

    public String toString() {
        return "RemoveAnimationInfo{holder=" + this.f25368a + ASCIIPropertyListParser.f18653k;
    }
}
