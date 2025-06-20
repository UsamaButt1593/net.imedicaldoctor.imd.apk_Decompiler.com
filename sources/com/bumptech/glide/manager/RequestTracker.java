package com.bumptech.glide.manager;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.util.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

public class RequestTracker {

    /* renamed from: d  reason: collision with root package name */
    private static final String f18420d = "RequestTracker";

    /* renamed from: a  reason: collision with root package name */
    private final Set<Request> f18421a = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: b  reason: collision with root package name */
    private final List<Request> f18422b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private boolean f18423c;

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public void a(Request request) {
        this.f18421a.add(request);
    }

    public boolean b(@Nullable Request request) {
        boolean z = true;
        if (request == null) {
            return true;
        }
        boolean remove = this.f18421a.remove(request);
        if (!this.f18422b.remove(request) && !remove) {
            z = false;
        }
        if (z) {
            request.clear();
        }
        return z;
    }

    public void c() {
        for (T b2 : Util.k(this.f18421a)) {
            b(b2);
        }
        this.f18422b.clear();
    }

    public boolean d() {
        return this.f18423c;
    }

    public void e() {
        this.f18423c = true;
        for (T t : Util.k(this.f18421a)) {
            if (t.isRunning() || t.isComplete()) {
                t.clear();
                this.f18422b.add(t);
            }
        }
    }

    public void f() {
        this.f18423c = true;
        for (T t : Util.k(this.f18421a)) {
            if (t.isRunning()) {
                t.h();
                this.f18422b.add(t);
            }
        }
    }

    public void g() {
        for (T t : Util.k(this.f18421a)) {
            if (!t.isComplete() && !t.f()) {
                t.clear();
                if (!this.f18423c) {
                    t.j();
                } else {
                    this.f18422b.add(t);
                }
            }
        }
    }

    public void h() {
        this.f18423c = false;
        for (T t : Util.k(this.f18421a)) {
            if (!t.isComplete() && !t.isRunning()) {
                t.j();
            }
        }
        this.f18422b.clear();
    }

    public void i(@NonNull Request request) {
        this.f18421a.add(request);
        if (!this.f18423c) {
            request.j();
            return;
        }
        request.clear();
        if (Log.isLoggable(f18420d, 2)) {
            Log.v(f18420d, "Paused, delaying request");
        }
        this.f18422b.add(request);
    }

    public String toString() {
        return super.toString() + "{numRequests=" + this.f18421a.size() + ", isPaused=" + this.f18423c + "}";
    }
}
