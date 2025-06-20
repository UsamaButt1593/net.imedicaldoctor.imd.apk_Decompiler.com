package com.prolificinteractive.materialcalendarview;

import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class DayViewFacade {

    /* renamed from: a  reason: collision with root package name */
    private boolean f27966a = false;

    /* renamed from: b  reason: collision with root package name */
    private Drawable f27967b = null;

    /* renamed from: c  reason: collision with root package name */
    private Drawable f27968c = null;

    /* renamed from: d  reason: collision with root package name */
    private final LinkedList<Span> f27969d = new LinkedList<>();

    /* renamed from: e  reason: collision with root package name */
    private boolean f27970e = false;

    static class Span {

        /* renamed from: a  reason: collision with root package name */
        final Object f27971a;

        public Span(Object obj) {
            this.f27971a = obj;
        }
    }

    DayViewFacade() {
    }

    public void a(@NonNull Object obj) {
        LinkedList<Span> linkedList = this.f27969d;
        if (linkedList != null) {
            linkedList.add(new Span(obj));
            this.f27966a = true;
        }
    }

    /* access modifiers changed from: package-private */
    public void b(DayViewFacade dayViewFacade) {
        Drawable drawable = this.f27968c;
        if (drawable != null) {
            dayViewFacade.k(drawable);
        }
        Drawable drawable2 = this.f27967b;
        if (drawable2 != null) {
            dayViewFacade.i(drawable2);
        }
        dayViewFacade.f27969d.addAll(this.f27969d);
        dayViewFacade.f27966a |= this.f27966a;
        dayViewFacade.f27970e = this.f27970e;
    }

    public boolean c() {
        return this.f27970e;
    }

    /* access modifiers changed from: package-private */
    public Drawable d() {
        return this.f27967b;
    }

    /* access modifiers changed from: package-private */
    public Drawable e() {
        return this.f27968c;
    }

    /* access modifiers changed from: package-private */
    public List<Span> f() {
        return Collections.unmodifiableList(this.f27969d);
    }

    /* access modifiers changed from: package-private */
    public boolean g() {
        return this.f27966a;
    }

    /* access modifiers changed from: package-private */
    public void h() {
        this.f27967b = null;
        this.f27968c = null;
        this.f27969d.clear();
        this.f27966a = false;
        this.f27970e = false;
    }

    public void i(@NonNull Drawable drawable) {
        if (drawable != null) {
            this.f27967b = drawable;
            this.f27966a = true;
            return;
        }
        throw new IllegalArgumentException("Cannot be null");
    }

    public void j(boolean z) {
        this.f27970e = z;
        this.f27966a = true;
    }

    public void k(@NonNull Drawable drawable) {
        if (drawable != null) {
            this.f27968c = drawable;
            this.f27966a = true;
            return;
        }
        throw new IllegalArgumentException("Cannot be null");
    }
}
