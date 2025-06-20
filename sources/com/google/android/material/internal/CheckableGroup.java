package com.google.android.material.internal;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.UiThread;
import com.google.android.material.internal.MaterialCheckable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@UiThread
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class CheckableGroup<T extends MaterialCheckable<T>> {

    /* renamed from: a  reason: collision with root package name */
    private final Map<Integer, T> f21482a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private final Set<Integer> f21483b = new HashSet();

    /* renamed from: c  reason: collision with root package name */
    private OnCheckedStateChangeListener f21484c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f21485d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public boolean f21486e;

    public interface OnCheckedStateChangeListener {
        void a(@NonNull Set<Integer> set);
    }

    /* access modifiers changed from: private */
    public boolean g(@NonNull MaterialCheckable<T> materialCheckable) {
        int id = materialCheckable.getId();
        if (this.f21483b.contains(Integer.valueOf(id))) {
            return false;
        }
        MaterialCheckable materialCheckable2 = (MaterialCheckable) this.f21482a.get(Integer.valueOf(k()));
        if (materialCheckable2 != null) {
            t(materialCheckable2, false);
        }
        boolean add = this.f21483b.add(Integer.valueOf(id));
        if (!materialCheckable.isChecked()) {
            materialCheckable.setChecked(true);
        }
        return add;
    }

    /* access modifiers changed from: private */
    public void n() {
        OnCheckedStateChangeListener onCheckedStateChangeListener = this.f21484c;
        if (onCheckedStateChangeListener != null) {
            onCheckedStateChangeListener.a(i());
        }
    }

    /* access modifiers changed from: private */
    public boolean t(@NonNull MaterialCheckable<T> materialCheckable, boolean z) {
        int id = materialCheckable.getId();
        if (!this.f21483b.contains(Integer.valueOf(id))) {
            return false;
        }
        if (!z || this.f21483b.size() != 1 || !this.f21483b.contains(Integer.valueOf(id))) {
            boolean remove = this.f21483b.remove(Integer.valueOf(id));
            if (materialCheckable.isChecked()) {
                materialCheckable.setChecked(false);
            }
            return remove;
        }
        materialCheckable.setChecked(true);
        return false;
    }

    public void e(T t) {
        this.f21482a.put(Integer.valueOf(t.getId()), t);
        if (t.isChecked()) {
            g(t);
        }
        t.setInternalOnCheckedChangeListener(new MaterialCheckable.OnCheckedChangeListener<T>() {
            /* renamed from: b */
            public void a(T t, boolean z) {
                if (!z) {
                    CheckableGroup checkableGroup = CheckableGroup.this;
                    if (!checkableGroup.t(t, checkableGroup.f21486e)) {
                        return;
                    }
                } else if (!CheckableGroup.this.g(t)) {
                    return;
                }
                CheckableGroup.this.n();
            }
        });
    }

    public void f(@IdRes int i2) {
        MaterialCheckable materialCheckable = (MaterialCheckable) this.f21482a.get(Integer.valueOf(i2));
        if (materialCheckable != null && g(materialCheckable)) {
            n();
        }
    }

    public void h() {
        boolean z = !this.f21483b.isEmpty();
        for (T t : this.f21482a.values()) {
            t(t, false);
        }
        if (z) {
            n();
        }
    }

    @NonNull
    public Set<Integer> i() {
        return new HashSet(this.f21483b);
    }

    @NonNull
    public List<Integer> j(@NonNull ViewGroup viewGroup) {
        Set<Integer> i2 = i();
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
            View childAt = viewGroup.getChildAt(i3);
            if ((childAt instanceof MaterialCheckable) && i2.contains(Integer.valueOf(childAt.getId()))) {
                arrayList.add(Integer.valueOf(childAt.getId()));
            }
        }
        return arrayList;
    }

    @IdRes
    public int k() {
        if (!this.f21485d || this.f21483b.isEmpty()) {
            return -1;
        }
        return this.f21483b.iterator().next().intValue();
    }

    public boolean l() {
        return this.f21486e;
    }

    public boolean m() {
        return this.f21485d;
    }

    public void o(T t) {
        t.setInternalOnCheckedChangeListener((MaterialCheckable.OnCheckedChangeListener) null);
        this.f21482a.remove(Integer.valueOf(t.getId()));
        this.f21483b.remove(Integer.valueOf(t.getId()));
    }

    public void p(@Nullable OnCheckedStateChangeListener onCheckedStateChangeListener) {
        this.f21484c = onCheckedStateChangeListener;
    }

    public void q(boolean z) {
        this.f21486e = z;
    }

    public void r(boolean z) {
        if (this.f21485d != z) {
            this.f21485d = z;
            h();
        }
    }

    public void s(@IdRes int i2) {
        MaterialCheckable materialCheckable = (MaterialCheckable) this.f21482a.get(Integer.valueOf(i2));
        if (materialCheckable != null && t(materialCheckable, this.f21486e)) {
            n();
        }
    }
}
