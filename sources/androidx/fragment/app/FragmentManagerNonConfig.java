package androidx.fragment.app;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelStore;
import java.util.Collection;
import java.util.Map;

@Deprecated
public class FragmentManagerNonConfig {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private final Collection<Fragment> f7941a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, FragmentManagerNonConfig> f7942b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, ViewModelStore> f7943c;

    FragmentManagerNonConfig(@Nullable Collection<Fragment> collection, @Nullable Map<String, FragmentManagerNonConfig> map, @Nullable Map<String, ViewModelStore> map2) {
        this.f7941a = collection;
        this.f7942b = map;
        this.f7943c = map2;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public Map<String, FragmentManagerNonConfig> a() {
        return this.f7942b;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public Collection<Fragment> b() {
        return this.f7941a;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public Map<String, ViewModelStore> c() {
        return this.f7943c;
    }

    /* access modifiers changed from: package-private */
    public boolean d(Fragment fragment) {
        Collection<Fragment> collection = this.f7941a;
        if (collection == null) {
            return false;
        }
        return collection.contains(fragment);
    }
}
