package com.google.android.gms.dynamic;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.zac;
import com.google.android.gms.dynamic.LifecycleDelegate;
import java.util.LinkedList;

@KeepForSdk
public abstract class DeferredLifecycleHelper<T extends LifecycleDelegate> {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public T f20443a;
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public Bundle f20444b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public LinkedList<zah> f20445c;

    /* renamed from: d  reason: collision with root package name */
    private final OnDelegateCreatedListener<T> f20446d = new zaa(this);

    @KeepForSdk
    public static void o(@NonNull FrameLayout frameLayout) {
        GoogleApiAvailability x = GoogleApiAvailability.x();
        Context context = frameLayout.getContext();
        int j2 = x.j(context);
        String d2 = zac.d(context, j2);
        String c2 = zac.c(context, j2);
        LinearLayout linearLayout = new LinearLayout(frameLayout.getContext());
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        frameLayout.addView(linearLayout);
        TextView textView = new TextView(frameLayout.getContext());
        textView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        textView.setText(d2);
        linearLayout.addView(textView);
        Intent e2 = x.e(context, j2, (String) null);
        if (e2 != null) {
            Button button = new Button(context);
            button.setId(16908313);
            button.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            button.setText(c2);
            linearLayout.addView(button);
            button.setOnClickListener(new zae(context, e2));
        }
    }

    private final void t(int i2) {
        while (!this.f20445c.isEmpty() && this.f20445c.getLast().b() >= i2) {
            this.f20445c.removeLast();
        }
    }

    private final void u(@Nullable Bundle bundle, zah zah) {
        T t = this.f20443a;
        if (t != null) {
            zah.a(t);
            return;
        }
        if (this.f20445c == null) {
            this.f20445c = new LinkedList<>();
        }
        this.f20445c.add(zah);
        if (bundle != null) {
            Bundle bundle2 = this.f20444b;
            if (bundle2 == null) {
                this.f20444b = (Bundle) bundle.clone();
            } else {
                bundle2.putAll(bundle);
            }
        }
        a(this.f20446d);
    }

    /* access modifiers changed from: protected */
    @KeepForSdk
    public abstract void a(@NonNull OnDelegateCreatedListener<T> onDelegateCreatedListener);

    @NonNull
    @KeepForSdk
    public T b() {
        return this.f20443a;
    }

    /* access modifiers changed from: protected */
    @KeepForSdk
    public void c(@NonNull FrameLayout frameLayout) {
        o(frameLayout);
    }

    @KeepForSdk
    public void d(@Nullable Bundle bundle) {
        u(bundle, new zac(this, bundle));
    }

    @NonNull
    @KeepForSdk
    public View e(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        FrameLayout frameLayout = new FrameLayout(layoutInflater.getContext());
        u(bundle, new zad(this, frameLayout, layoutInflater, viewGroup, bundle));
        if (this.f20443a == null) {
            c(frameLayout);
        }
        return frameLayout;
    }

    @KeepForSdk
    public void f() {
        T t = this.f20443a;
        if (t != null) {
            t.b();
        } else {
            t(1);
        }
    }

    @KeepForSdk
    public void g() {
        T t = this.f20443a;
        if (t != null) {
            t.i();
        } else {
            t(2);
        }
    }

    @KeepForSdk
    public void h(@NonNull Activity activity, @NonNull Bundle bundle, @Nullable Bundle bundle2) {
        u(bundle2, new zab(this, activity, bundle, bundle2));
    }

    @KeepForSdk
    public void i() {
        T t = this.f20443a;
        if (t != null) {
            t.onLowMemory();
        }
    }

    @KeepForSdk
    public void j() {
        T t = this.f20443a;
        if (t != null) {
            t.g();
        } else {
            t(5);
        }
    }

    @KeepForSdk
    public void k() {
        u((Bundle) null, new zag(this));
    }

    @KeepForSdk
    public void l(@NonNull Bundle bundle) {
        T t = this.f20443a;
        if (t != null) {
            t.h(bundle);
            return;
        }
        Bundle bundle2 = this.f20444b;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
    }

    @KeepForSdk
    public void m() {
        u((Bundle) null, new zaf(this));
    }

    @KeepForSdk
    public void n() {
        T t = this.f20443a;
        if (t != null) {
            t.d();
        } else {
            t(4);
        }
    }
}
