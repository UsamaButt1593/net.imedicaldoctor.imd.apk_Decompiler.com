package androidx.fragment.app;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.l;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.dd.plist.ASCIIPropertyListParser;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

final class FragmentManagerViewModel extends ViewModel {

    /* renamed from: k  reason: collision with root package name */
    private static final String f7944k = "FragmentManager";

    /* renamed from: l  reason: collision with root package name */
    private static final ViewModelProvider.Factory f7945l = new ViewModelProvider.Factory() {
        @NonNull
        public <T extends ViewModel> T a(@NonNull Class<T> cls) {
            return new FragmentManagerViewModel(true);
        }

        public /* synthetic */ ViewModel b(Class cls, CreationExtras creationExtras) {
            return l.b(this, cls, creationExtras);
        }
    };

    /* renamed from: d  reason: collision with root package name */
    private final HashMap<String, Fragment> f7946d = new HashMap<>();

    /* renamed from: e  reason: collision with root package name */
    private final HashMap<String, FragmentManagerViewModel> f7947e = new HashMap<>();

    /* renamed from: f  reason: collision with root package name */
    private final HashMap<String, ViewModelStore> f7948f = new HashMap<>();

    /* renamed from: g  reason: collision with root package name */
    private final boolean f7949g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f7950h = false;

    /* renamed from: i  reason: collision with root package name */
    private boolean f7951i = false;

    /* renamed from: j  reason: collision with root package name */
    private boolean f7952j = false;

    FragmentManagerViewModel(boolean z) {
        this.f7949g = z;
    }

    private void j(@NonNull String str) {
        FragmentManagerViewModel fragmentManagerViewModel = this.f7947e.get(str);
        if (fragmentManagerViewModel != null) {
            fragmentManagerViewModel.e();
            this.f7947e.remove(str);
        }
        ViewModelStore viewModelStore = this.f7948f.get(str);
        if (viewModelStore != null) {
            viewModelStore.a();
            this.f7948f.remove(str);
        }
    }

    @NonNull
    static FragmentManagerViewModel m(ViewModelStore viewModelStore) {
        return (FragmentManagerViewModel) new ViewModelProvider(viewModelStore, f7945l).a(FragmentManagerViewModel.class);
    }

    /* access modifiers changed from: protected */
    public void e() {
        if (FragmentManager.W0(3)) {
            Log.d("FragmentManager", "onCleared called for " + this);
        }
        this.f7950h = true;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || FragmentManagerViewModel.class != obj.getClass()) {
            return false;
        }
        FragmentManagerViewModel fragmentManagerViewModel = (FragmentManagerViewModel) obj;
        return this.f7946d.equals(fragmentManagerViewModel.f7946d) && this.f7947e.equals(fragmentManagerViewModel.f7947e) && this.f7948f.equals(fragmentManagerViewModel.f7948f);
    }

    /* access modifiers changed from: package-private */
    public void g(@NonNull Fragment fragment) {
        if (this.f7952j) {
            if (FragmentManager.W0(2)) {
                Log.v("FragmentManager", "Ignoring addRetainedFragment as the state is already saved");
            }
        } else if (!this.f7946d.containsKey(fragment.Y2)) {
            this.f7946d.put(fragment.Y2, fragment);
            if (FragmentManager.W0(2)) {
                Log.v("FragmentManager", "Updating retained Fragments: Added " + fragment);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void h(@NonNull Fragment fragment) {
        if (FragmentManager.W0(3)) {
            Log.d("FragmentManager", "Clearing non-config state for " + fragment);
        }
        j(fragment.Y2);
    }

    public int hashCode() {
        return (((this.f7946d.hashCode() * 31) + this.f7947e.hashCode()) * 31) + this.f7948f.hashCode();
    }

    /* access modifiers changed from: package-private */
    public void i(@NonNull String str) {
        if (FragmentManager.W0(3)) {
            Log.d("FragmentManager", "Clearing non-config state for saved state of Fragment " + str);
        }
        j(str);
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public Fragment k(String str) {
        return this.f7946d.get(str);
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public FragmentManagerViewModel l(@NonNull Fragment fragment) {
        FragmentManagerViewModel fragmentManagerViewModel = this.f7947e.get(fragment.Y2);
        if (fragmentManagerViewModel != null) {
            return fragmentManagerViewModel;
        }
        FragmentManagerViewModel fragmentManagerViewModel2 = new FragmentManagerViewModel(this.f7949g);
        this.f7947e.put(fragment.Y2, fragmentManagerViewModel2);
        return fragmentManagerViewModel2;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public Collection<Fragment> n() {
        return new ArrayList(this.f7946d.values());
    }

    /* access modifiers changed from: package-private */
    @Deprecated
    @Nullable
    public FragmentManagerNonConfig o() {
        if (this.f7946d.isEmpty() && this.f7947e.isEmpty() && this.f7948f.isEmpty()) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (Map.Entry next : this.f7947e.entrySet()) {
            FragmentManagerNonConfig o = ((FragmentManagerViewModel) next.getValue()).o();
            if (o != null) {
                hashMap.put((String) next.getKey(), o);
            }
        }
        this.f7951i = true;
        if (!this.f7946d.isEmpty() || !hashMap.isEmpty() || !this.f7948f.isEmpty()) {
            return new FragmentManagerNonConfig(new ArrayList(this.f7946d.values()), hashMap, new HashMap(this.f7948f));
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public ViewModelStore p(@NonNull Fragment fragment) {
        ViewModelStore viewModelStore = this.f7948f.get(fragment.Y2);
        if (viewModelStore != null) {
            return viewModelStore;
        }
        ViewModelStore viewModelStore2 = new ViewModelStore();
        this.f7948f.put(fragment.Y2, viewModelStore2);
        return viewModelStore2;
    }

    /* access modifiers changed from: package-private */
    public boolean q() {
        return this.f7950h;
    }

    /* access modifiers changed from: package-private */
    public void r(@NonNull Fragment fragment) {
        if (this.f7952j) {
            if (FragmentManager.W0(2)) {
                Log.v("FragmentManager", "Ignoring removeRetainedFragment as the state is already saved");
            }
        } else if (this.f7946d.remove(fragment.Y2) != null && FragmentManager.W0(2)) {
            Log.v("FragmentManager", "Updating retained Fragments: Removed " + fragment);
        }
    }

    /* access modifiers changed from: package-private */
    @Deprecated
    public void s(@Nullable FragmentManagerNonConfig fragmentManagerNonConfig) {
        this.f7946d.clear();
        this.f7947e.clear();
        this.f7948f.clear();
        if (fragmentManagerNonConfig != null) {
            Collection<Fragment> b2 = fragmentManagerNonConfig.b();
            if (b2 != null) {
                for (Fragment next : b2) {
                    if (next != null) {
                        this.f7946d.put(next.Y2, next);
                    }
                }
            }
            Map<String, FragmentManagerNonConfig> a2 = fragmentManagerNonConfig.a();
            if (a2 != null) {
                for (Map.Entry next2 : a2.entrySet()) {
                    FragmentManagerViewModel fragmentManagerViewModel = new FragmentManagerViewModel(this.f7949g);
                    fragmentManagerViewModel.s((FragmentManagerNonConfig) next2.getValue());
                    this.f7947e.put((String) next2.getKey(), fragmentManagerViewModel);
                }
            }
            Map<String, ViewModelStore> c2 = fragmentManagerNonConfig.c();
            if (c2 != null) {
                this.f7948f.putAll(c2);
            }
        }
        this.f7951i = false;
    }

    /* access modifiers changed from: package-private */
    public void t(boolean z) {
        this.f7952j = z;
    }

    @NonNull
    public String toString() {
        StringBuilder sb = new StringBuilder("FragmentManagerViewModel{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} Fragments (");
        Iterator<Fragment> it2 = this.f7946d.values().iterator();
        while (it2.hasNext()) {
            sb.append(it2.next());
            if (it2.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") Child Non Config (");
        Iterator<String> it3 = this.f7947e.keySet().iterator();
        while (it3.hasNext()) {
            sb.append(it3.next());
            if (it3.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") ViewModelStores (");
        Iterator<String> it4 = this.f7948f.keySet().iterator();
        while (it4.hasNext()) {
            sb.append(it4.next());
            if (it4.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(ASCIIPropertyListParser.f18650h);
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    public boolean u(@NonNull Fragment fragment) {
        if (!this.f7946d.containsKey(fragment.Y2)) {
            return true;
        }
        return this.f7949g ? this.f7950h : !this.f7951i;
    }
}
