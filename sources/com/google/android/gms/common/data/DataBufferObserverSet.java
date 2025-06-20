package com.google.android.gms.common.data;

import androidx.annotation.NonNull;
import com.google.android.gms.common.data.DataBufferObserver;
import java.util.HashSet;
import java.util.Iterator;

public final class DataBufferObserverSet implements DataBufferObserver, DataBufferObserver.Observable {

    /* renamed from: a  reason: collision with root package name */
    private HashSet<DataBufferObserver> f20189a = new HashSet<>();

    public void a(int i2, int i3) {
        Iterator<DataBufferObserver> it2 = this.f20189a.iterator();
        while (it2.hasNext()) {
            it2.next().a(i2, i3);
        }
    }

    public void b(int i2, int i3, int i4) {
        Iterator<DataBufferObserver> it2 = this.f20189a.iterator();
        while (it2.hasNext()) {
            it2.next().b(i2, i3, i4);
        }
    }

    public void c(int i2, int i3) {
        Iterator<DataBufferObserver> it2 = this.f20189a.iterator();
        while (it2.hasNext()) {
            it2.next().c(i2, i3);
        }
    }

    public void d(int i2, int i3) {
        Iterator<DataBufferObserver> it2 = this.f20189a.iterator();
        while (it2.hasNext()) {
            it2.next().d(i2, i3);
        }
    }

    public void e(@NonNull DataBufferObserver dataBufferObserver) {
        this.f20189a.remove(dataBufferObserver);
    }

    public void f(@NonNull DataBufferObserver dataBufferObserver) {
        this.f20189a.add(dataBufferObserver);
    }

    public void g() {
        Iterator<DataBufferObserver> it2 = this.f20189a.iterator();
        while (it2.hasNext()) {
            it2.next().g();
        }
    }

    public void h() {
        this.f20189a.clear();
    }

    public boolean i() {
        return !this.f20189a.isEmpty();
    }
}
