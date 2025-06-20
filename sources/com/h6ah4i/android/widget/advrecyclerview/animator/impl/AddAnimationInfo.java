package com.h6ah4i.android.widget.advrecyclerview.animator.impl;

import androidx.recyclerview.widget.RecyclerView;
import com.dd.plist.ASCIIPropertyListParser;

public class AddAnimationInfo extends ItemAnimationInfo {

    /* renamed from: a  reason: collision with root package name */
    public RecyclerView.ViewHolder f25344a;

    public AddAnimationInfo(RecyclerView.ViewHolder viewHolder) {
        this.f25344a = viewHolder;
    }

    public void a(RecyclerView.ViewHolder viewHolder) {
        if (this.f25344a == null) {
            this.f25344a = null;
        }
    }

    public RecyclerView.ViewHolder b() {
        return this.f25344a;
    }

    public String toString() {
        return "AddAnimationInfo{holder=" + this.f25344a + ASCIIPropertyListParser.f18653k;
    }
}
