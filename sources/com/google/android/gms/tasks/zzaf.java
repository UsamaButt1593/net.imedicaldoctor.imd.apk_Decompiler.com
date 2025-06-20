package com.google.android.gms.tasks;

import androidx.annotation.NonNull;
import java.util.concurrent.ExecutionException;

final class zzaf<T> implements zzae<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Object f20528a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private final int f20529b;

    /* renamed from: c  reason: collision with root package name */
    private final zzw f20530c;

    /* renamed from: d  reason: collision with root package name */
    private int f20531d;

    /* renamed from: e  reason: collision with root package name */
    private int f20532e;

    /* renamed from: f  reason: collision with root package name */
    private int f20533f;

    /* renamed from: g  reason: collision with root package name */
    private Exception f20534g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f20535h;

    public zzaf(int i2, zzw zzw) {
        this.f20529b = i2;
        this.f20530c = zzw;
    }

    private final void b() {
        if (this.f20531d + this.f20532e + this.f20533f != this.f20529b) {
            return;
        }
        if (this.f20534g != null) {
            zzw zzw = this.f20530c;
            int i2 = this.f20532e;
            int i3 = this.f20529b;
            zzw.y(new ExecutionException(i2 + " out of " + i3 + " underlying tasks failed", this.f20534g));
        } else if (this.f20535h) {
            this.f20530c.A();
        } else {
            this.f20530c.z((Object) null);
        }
    }

    public final void a(T t) {
        synchronized (this.f20528a) {
            this.f20531d++;
            b();
        }
    }

    public final void c() {
        synchronized (this.f20528a) {
            this.f20533f++;
            this.f20535h = true;
            b();
        }
    }

    public final void e(@NonNull Exception exc) {
        synchronized (this.f20528a) {
            this.f20532e++;
            this.f20534g = exc;
            b();
        }
    }
}
