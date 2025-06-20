package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

class FragmentStore {

    /* renamed from: e  reason: collision with root package name */
    private static final String f7984e = "FragmentManager";

    /* renamed from: a  reason: collision with root package name */
    private final ArrayList<Fragment> f7985a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private final HashMap<String, FragmentStateManager> f7986b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    private final HashMap<String, FragmentState> f7987c = new HashMap<>();

    /* renamed from: d  reason: collision with root package name */
    private FragmentManagerViewModel f7988d;

    FragmentStore() {
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public ArrayList<String> A() {
        synchronized (this.f7985a) {
            try {
                if (this.f7985a.isEmpty()) {
                    return null;
                }
                ArrayList<String> arrayList = new ArrayList<>(this.f7985a.size());
                Iterator<Fragment> it2 = this.f7985a.iterator();
                while (it2.hasNext()) {
                    Fragment next = it2.next();
                    arrayList.add(next.Y2);
                    if (FragmentManager.W0(2)) {
                        Log.v("FragmentManager", "saveAllState: adding fragment (" + next.Y2 + "): " + next);
                    }
                }
                return arrayList;
            } finally {
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void B(@NonNull FragmentManagerViewModel fragmentManagerViewModel) {
        this.f7988d = fragmentManagerViewModel;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public FragmentState C(@NonNull String str, @Nullable FragmentState fragmentState) {
        return (FragmentState) (fragmentState != null ? this.f7987c.put(str, fragmentState) : this.f7987c.remove(str));
    }

    /* access modifiers changed from: package-private */
    public void a(@NonNull Fragment fragment) {
        if (!this.f7985a.contains(fragment)) {
            synchronized (this.f7985a) {
                this.f7985a.add(fragment);
            }
            fragment.e3 = true;
            return;
        }
        throw new IllegalStateException("Fragment already added: " + fragment);
    }

    /* access modifiers changed from: package-private */
    public void b() {
        this.f7986b.values().removeAll(Collections.singleton((Object) null));
    }

    /* access modifiers changed from: package-private */
    public boolean c(@NonNull String str) {
        return this.f7986b.get(str) != null;
    }

    /* access modifiers changed from: package-private */
    public void d(int i2) {
        for (FragmentStateManager next : this.f7986b.values()) {
            if (next != null) {
                next.u(i2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void e(@NonNull String str, @Nullable FileDescriptor fileDescriptor, @NonNull PrintWriter printWriter, @Nullable String[] strArr) {
        String str2 = str + "    ";
        if (!this.f7986b.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Active Fragments:");
            for (FragmentStateManager next : this.f7986b.values()) {
                printWriter.print(str);
                if (next != null) {
                    Fragment k2 = next.k();
                    printWriter.println(k2);
                    k2.l(str2, fileDescriptor, printWriter, strArr);
                } else {
                    printWriter.println("null");
                }
            }
        }
        int size = this.f7985a.size();
        if (size > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i2 = 0; i2 < size; i2++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.println(this.f7985a.get(i2).toString());
            }
        }
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public Fragment f(@NonNull String str) {
        FragmentStateManager fragmentStateManager = this.f7986b.get(str);
        if (fragmentStateManager != null) {
            return fragmentStateManager.k();
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public Fragment g(@IdRes int i2) {
        for (int size = this.f7985a.size() - 1; size >= 0; size--) {
            Fragment fragment = this.f7985a.get(size);
            if (fragment != null && fragment.q3 == i2) {
                return fragment;
            }
        }
        for (FragmentStateManager next : this.f7986b.values()) {
            if (next != null) {
                Fragment k2 = next.k();
                if (k2.q3 == i2) {
                    return k2;
                }
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public Fragment h(@Nullable String str) {
        if (str != null) {
            for (int size = this.f7985a.size() - 1; size >= 0; size--) {
                Fragment fragment = this.f7985a.get(size);
                if (fragment != null && str.equals(fragment.s3)) {
                    return fragment;
                }
            }
        }
        if (str == null) {
            return null;
        }
        for (FragmentStateManager next : this.f7986b.values()) {
            if (next != null) {
                Fragment k2 = next.k();
                if (str.equals(k2.s3)) {
                    return k2;
                }
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public Fragment i(@NonNull String str) {
        Fragment p;
        for (FragmentStateManager next : this.f7986b.values()) {
            if (next != null && (p = next.k().p(str)) != null) {
                return p;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public int j(@NonNull Fragment fragment) {
        View view;
        View view2;
        ViewGroup viewGroup = fragment.A3;
        if (viewGroup == null) {
            return -1;
        }
        int indexOf = this.f7985a.indexOf(fragment);
        for (int i2 = indexOf - 1; i2 >= 0; i2--) {
            Fragment fragment2 = this.f7985a.get(i2);
            if (fragment2.A3 == viewGroup && (view2 = fragment2.B3) != null) {
                return viewGroup.indexOfChild(view2) + 1;
            }
        }
        while (true) {
            indexOf++;
            if (indexOf >= this.f7985a.size()) {
                return -1;
            }
            Fragment fragment3 = this.f7985a.get(indexOf);
            if (fragment3.A3 == viewGroup && (view = fragment3.B3) != null) {
                return viewGroup.indexOfChild(view);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public int k() {
        return this.f7986b.size();
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public List<FragmentStateManager> l() {
        ArrayList arrayList = new ArrayList();
        for (FragmentStateManager next : this.f7986b.values()) {
            if (next != null) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public List<Fragment> m() {
        ArrayList arrayList = new ArrayList();
        Iterator<FragmentStateManager> it2 = this.f7986b.values().iterator();
        while (it2.hasNext()) {
            FragmentStateManager next = it2.next();
            arrayList.add(next != null ? next.k() : null);
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public ArrayList<FragmentState> n() {
        return new ArrayList<>(this.f7987c.values());
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public FragmentStateManager o(@NonNull String str) {
        return this.f7986b.get(str);
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public List<Fragment> p() {
        ArrayList arrayList;
        if (this.f7985a.isEmpty()) {
            return Collections.emptyList();
        }
        synchronized (this.f7985a) {
            arrayList = new ArrayList(this.f7985a);
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public FragmentManagerViewModel q() {
        return this.f7988d;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public FragmentState r(@NonNull String str) {
        return this.f7987c.get(str);
    }

    /* access modifiers changed from: package-private */
    public void s(@NonNull FragmentStateManager fragmentStateManager) {
        Fragment k2 = fragmentStateManager.k();
        if (!c(k2.Y2)) {
            this.f7986b.put(k2.Y2, fragmentStateManager);
            if (k2.w3) {
                if (k2.v3) {
                    this.f7988d.g(k2);
                } else {
                    this.f7988d.r(k2);
                }
                k2.w3 = false;
            }
            if (FragmentManager.W0(2)) {
                Log.v("FragmentManager", "Added fragment to active set " + k2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void t(@NonNull FragmentStateManager fragmentStateManager) {
        Fragment k2 = fragmentStateManager.k();
        if (k2.v3) {
            this.f7988d.r(k2);
        }
        if (this.f7986b.put(k2.Y2, (Object) null) != null && FragmentManager.W0(2)) {
            Log.v("FragmentManager", "Removed fragment from active set " + k2);
        }
    }

    /* access modifiers changed from: package-private */
    public void u() {
        Iterator<Fragment> it2 = this.f7985a.iterator();
        while (it2.hasNext()) {
            FragmentStateManager fragmentStateManager = this.f7986b.get(it2.next().Y2);
            if (fragmentStateManager != null) {
                fragmentStateManager.m();
            }
        }
        for (FragmentStateManager next : this.f7986b.values()) {
            if (next != null) {
                next.m();
                Fragment k2 = next.k();
                if (k2.f3 && !k2.B0()) {
                    if (k2.g3 && !this.f7987c.containsKey(k2.Y2)) {
                        next.s();
                    }
                    t(next);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void v(@NonNull Fragment fragment) {
        synchronized (this.f7985a) {
            this.f7985a.remove(fragment);
        }
        fragment.e3 = false;
    }

    /* access modifiers changed from: package-private */
    public void w() {
        this.f7986b.clear();
    }

    /* access modifiers changed from: package-private */
    public void x(@Nullable List<String> list) {
        this.f7985a.clear();
        if (list != null) {
            for (String next : list) {
                Fragment f2 = f(next);
                if (f2 != null) {
                    if (FragmentManager.W0(2)) {
                        Log.v("FragmentManager", "restoreSaveState: added (" + next + "): " + f2);
                    }
                    a(f2);
                } else {
                    throw new IllegalStateException("No instantiated fragment for (" + next + ")");
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void y(@NonNull ArrayList<FragmentState> arrayList) {
        this.f7987c.clear();
        Iterator<FragmentState> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            FragmentState next = it2.next();
            this.f7987c.put(next.X, next);
        }
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public ArrayList<String> z() {
        ArrayList<String> arrayList = new ArrayList<>(this.f7986b.size());
        for (FragmentStateManager next : this.f7986b.values()) {
            if (next != null) {
                Fragment k2 = next.k();
                next.s();
                arrayList.add(k2.Y2);
                if (FragmentManager.W0(2)) {
                    Log.v("FragmentManager", "Saved state of " + k2 + ": " + k2.X);
                }
            }
        }
        return arrayList;
    }
}
