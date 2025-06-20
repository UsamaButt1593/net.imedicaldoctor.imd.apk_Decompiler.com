package androidx.lifecycle;

import android.os.Binder;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import androidx.annotation.MainThread;
import androidx.annotation.RestrictTo;
import androidx.core.os.BundleKt;
import androidx.savedstate.SavedStateRegistry;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nSavedStateHandle.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SavedStateHandle.kt\nandroidx/lifecycle/SavedStateHandle\n+ 2 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,450:1\n361#2,3:451\n364#2,4:455\n1#3:454\n*S KotlinDebug\n*F\n+ 1 SavedStateHandle.kt\nandroidx/lifecycle/SavedStateHandle\n*L\n198#1:451,3\n198#1:455,4\n*E\n"})
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010%\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u00029:B\u001f\b\u0016\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006B\t\b\u0016¢\u0006\u0004\b\u0005\u0010\u0007J3\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\r\"\u0004\b\u0000\u0010\b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0013\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J#\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\r\"\u0004\b\u0000\u0010\b2\u0006\u0010\t\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u0015\u0010\u0016J+\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\r\"\u0004\b\u0000\u0010\b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\f\u001a\u00028\u0000H\u0007¢\u0006\u0004\b\u0017\u0010\u0018J+\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019\"\u0004\b\u0000\u0010\b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\f\u001a\u00028\u0000H\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\u0015\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\u001cH\u0007¢\u0006\u0004\b\u001d\u0010\u001eJ \u0010\u001f\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\b2\u0006\u0010\t\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u001f\u0010 J(\u0010#\u001a\u00020\"\"\u0004\b\u0000\u0010\b2\u0006\u0010\t\u001a\u00020\u00032\b\u0010!\u001a\u0004\u0018\u00018\u0000H\u0002¢\u0006\u0004\b#\u0010$J\u001f\u0010%\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\b2\u0006\u0010\t\u001a\u00020\u0003H\u0007¢\u0006\u0004\b%\u0010 J\u001f\u0010'\u001a\u00020\"2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\u0010H\u0007¢\u0006\u0004\b'\u0010(J\u0017\u0010)\u001a\u00020\"2\u0006\u0010\t\u001a\u00020\u0003H\u0007¢\u0006\u0004\b)\u0010*R\"\u0010.\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010+8\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010-R \u00100\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00100+8\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u0010-R$\u00103\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\b\u0012\u0006\u0012\u0002\b\u0003010+8\u0002X\u0004¢\u0006\u0006\n\u0004\b2\u0010-R(\u00106\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u0001040+8\u0002X\u0004¢\u0006\u0006\n\u0004\b5\u0010-R\u0014\u00108\u001a\u00020\u00108\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u00107¨\u0006;"}, d2 = {"Landroidx/lifecycle/SavedStateHandle;", "", "", "", "initialState", "<init>", "(Ljava/util/Map;)V", "()V", "T", "key", "", "hasInitialValue", "initialValue", "Landroidx/lifecycle/MutableLiveData;", "k", "(Ljava/lang/String;ZLjava/lang/Object;)Landroidx/lifecycle/MutableLiveData;", "Landroidx/savedstate/SavedStateRegistry$SavedStateProvider;", "o", "()Landroidx/savedstate/SavedStateRegistry$SavedStateProvider;", "f", "(Ljava/lang/String;)Z", "i", "(Ljava/lang/String;)Landroidx/lifecycle/MutableLiveData;", "j", "(Ljava/lang/String;Ljava/lang/Object;)Landroidx/lifecycle/MutableLiveData;", "Lkotlinx/coroutines/flow/StateFlow;", "l", "(Ljava/lang/String;Ljava/lang/Object;)Lkotlinx/coroutines/flow/StateFlow;", "", "m", "()Ljava/util/Set;", "h", "(Ljava/lang/String;)Ljava/lang/Object;", "value", "", "q", "(Ljava/lang/String;Ljava/lang/Object;)V", "n", "provider", "r", "(Ljava/lang/String;Landroidx/savedstate/SavedStateRegistry$SavedStateProvider;)V", "e", "(Ljava/lang/String;)V", "", "a", "Ljava/util/Map;", "regular", "b", "savedStateProviders", "Landroidx/lifecycle/SavedStateHandle$SavingStateLiveData;", "c", "liveDatas", "Lkotlinx/coroutines/flow/MutableStateFlow;", "d", "flows", "Landroidx/savedstate/SavedStateRegistry$SavedStateProvider;", "savedStateProvider", "Companion", "SavingStateLiveData", "lifecycle-viewmodel-savedstate_release"}, k = 1, mv = {1, 8, 0})
public final class SavedStateHandle {
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    public static final Companion f8567f = new Companion((DefaultConstructorMarker) null);
    @NotNull

    /* renamed from: g  reason: collision with root package name */
    private static final String f8568g = "values";
    @NotNull

    /* renamed from: h  reason: collision with root package name */
    private static final String f8569h = "keys";
    /* access modifiers changed from: private */
    @NotNull

    /* renamed from: i  reason: collision with root package name */
    public static final Class<? extends Object>[] f8570i = {Boolean.TYPE, boolean[].class, Double.TYPE, double[].class, Integer.TYPE, int[].class, Long.TYPE, long[].class, String.class, String[].class, Binder.class, Bundle.class, Byte.TYPE, byte[].class, Character.TYPE, char[].class, CharSequence.class, CharSequence[].class, ArrayList.class, Float.TYPE, float[].class, Parcelable.class, Parcelable[].class, Serializable.class, Short.TYPE, short[].class, SparseArray.class, Size.class, SizeF.class};
    /* access modifiers changed from: private */
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, Object> f8571a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, SavedStateRegistry.SavedStateProvider> f8572b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, SavingStateLiveData<?>> f8573c;
    /* access modifiers changed from: private */
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    public final Map<String, MutableStateFlow<Object>> f8574d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private final SavedStateRegistry.SavedStateProvider f8575e;

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\b\u001a\u00020\u00072\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0004\b\f\u0010\rR$\u0010\u0010\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\b\u0001\u0012\u00020\u0001\u0018\u00010\u000f0\u000e8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u00128\u0002XT¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00128\u0002XT¢\u0006\u0006\n\u0004\b\u0015\u0010\u0014¨\u0006\u0016"}, d2 = {"Landroidx/lifecycle/SavedStateHandle$Companion;", "", "<init>", "()V", "Landroid/os/Bundle;", "restoredState", "defaultState", "Landroidx/lifecycle/SavedStateHandle;", "a", "(Landroid/os/Bundle;Landroid/os/Bundle;)Landroidx/lifecycle/SavedStateHandle;", "value", "", "b", "(Ljava/lang/Object;)Z", "", "Ljava/lang/Class;", "ACCEPTABLE_CLASSES", "[Ljava/lang/Class;", "", "KEYS", "Ljava/lang/String;", "VALUES", "lifecycle-viewmodel-savedstate_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        private Companion() {
        }

        @JvmStatic
        @NotNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public final SavedStateHandle a(@Nullable Bundle bundle, @Nullable Bundle bundle2) {
            if (bundle != null) {
                ArrayList parcelableArrayList = bundle.getParcelableArrayList("keys");
                ArrayList parcelableArrayList2 = bundle.getParcelableArrayList(SavedStateHandle.f8568g);
                if (parcelableArrayList == null || parcelableArrayList2 == null || parcelableArrayList.size() != parcelableArrayList2.size()) {
                    throw new IllegalStateException("Invalid bundle passed as restored state".toString());
                }
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                int size = parcelableArrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    Object obj = parcelableArrayList.get(i2);
                    Intrinsics.n(obj, "null cannot be cast to non-null type kotlin.String");
                    linkedHashMap.put((String) obj, parcelableArrayList2.get(i2));
                }
                return new SavedStateHandle(linkedHashMap);
            } else if (bundle2 == null) {
                return new SavedStateHandle();
            } else {
                HashMap hashMap = new HashMap();
                for (String next : bundle2.keySet()) {
                    Intrinsics.o(next, "key");
                    hashMap.put(next, bundle2.get(next));
                }
                return new SavedStateHandle(hashMap);
            }
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public final boolean b(@Nullable Object obj) {
            if (obj == null) {
                return true;
            }
            for (Class cls : SavedStateHandle.f8570i) {
                Intrinsics.m(cls);
                if (cls.isInstance(obj)) {
                    return true;
                }
            }
            return false;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\t\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B#\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00028\u0000¢\u0006\u0004\b\b\u0010\tB\u001b\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\nJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Landroidx/lifecycle/SavedStateHandle$SavingStateLiveData;", "T", "Landroidx/lifecycle/MutableLiveData;", "Landroidx/lifecycle/SavedStateHandle;", "handle", "", "key", "value", "<init>", "(Landroidx/lifecycle/SavedStateHandle;Ljava/lang/String;Ljava/lang/Object;)V", "(Landroidx/lifecycle/SavedStateHandle;Ljava/lang/String;)V", "", "r", "(Ljava/lang/Object;)V", "s", "()V", "m", "Ljava/lang/String;", "n", "Landroidx/lifecycle/SavedStateHandle;", "lifecycle-viewmodel-savedstate_release"}, k = 1, mv = {1, 8, 0})
    public static final class SavingStateLiveData<T> extends MutableLiveData<T> {
        @NotNull

        /* renamed from: m  reason: collision with root package name */
        private String f8576m;
        @Nullable

        /* renamed from: n  reason: collision with root package name */
        private SavedStateHandle f8577n;

        public SavingStateLiveData(@Nullable SavedStateHandle savedStateHandle, @NotNull String str) {
            Intrinsics.p(str, "key");
            this.f8576m = str;
            this.f8577n = savedStateHandle;
        }

        public void r(T t) {
            SavedStateHandle savedStateHandle = this.f8577n;
            if (savedStateHandle != null) {
                savedStateHandle.f8571a.put(this.f8576m, t);
                MutableStateFlow mutableStateFlow = (MutableStateFlow) savedStateHandle.f8574d.get(this.f8576m);
                if (mutableStateFlow != null) {
                    mutableStateFlow.setValue(t);
                }
            }
            super.r(t);
        }

        public final void s() {
            this.f8577n = null;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SavingStateLiveData(@Nullable SavedStateHandle savedStateHandle, @NotNull String str, T t) {
            super(t);
            Intrinsics.p(str, "key");
            this.f8576m = str;
            this.f8577n = savedStateHandle;
        }
    }

    public SavedStateHandle() {
        this.f8571a = new LinkedHashMap();
        this.f8572b = new LinkedHashMap();
        this.f8573c = new LinkedHashMap();
        this.f8574d = new LinkedHashMap();
        this.f8575e = new k(this);
    }

    @JvmStatic
    @NotNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final SavedStateHandle g(@Nullable Bundle bundle, @Nullable Bundle bundle2) {
        return f8567f.a(bundle, bundle2);
    }

    private final <T> MutableLiveData<T> k(String str, boolean z, T t) {
        SavingStateLiveData savingStateLiveData;
        SavingStateLiveData<?> savingStateLiveData2 = this.f8573c.get(str);
        MutableLiveData<T> mutableLiveData = savingStateLiveData2 instanceof MutableLiveData ? savingStateLiveData2 : null;
        if (mutableLiveData != null) {
            return mutableLiveData;
        }
        if (this.f8571a.containsKey(str)) {
            savingStateLiveData = new SavingStateLiveData(this, str, this.f8571a.get(str));
        } else if (z) {
            this.f8571a.put(str, t);
            savingStateLiveData = new SavingStateLiveData(this, str, t);
        } else {
            savingStateLiveData = new SavingStateLiveData(this, str);
        }
        this.f8573c.put(str, savingStateLiveData);
        return savingStateLiveData;
    }

    /* access modifiers changed from: private */
    public static final Bundle p(SavedStateHandle savedStateHandle) {
        Intrinsics.p(savedStateHandle, "this$0");
        for (Map.Entry next : MapsKt.D0(savedStateHandle.f8572b).entrySet()) {
            savedStateHandle.q((String) next.getKey(), ((SavedStateRegistry.SavedStateProvider) next.getValue()).a());
        }
        Set<String> keySet = savedStateHandle.f8571a.keySet();
        ArrayList arrayList = new ArrayList(keySet.size());
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        for (String next2 : keySet) {
            arrayList.add(next2);
            arrayList2.add(savedStateHandle.f8571a.get(next2));
        }
        return BundleKt.b(TuplesKt.a("keys", arrayList), TuplesKt.a(f8568g, arrayList2));
    }

    @MainThread
    public final void e(@NotNull String str) {
        Intrinsics.p(str, "key");
        this.f8572b.remove(str);
    }

    @MainThread
    public final boolean f(@NotNull String str) {
        Intrinsics.p(str, "key");
        return this.f8571a.containsKey(str);
    }

    @Nullable
    @MainThread
    public final <T> T h(@NotNull String str) {
        Intrinsics.p(str, "key");
        try {
            return this.f8571a.get(str);
        } catch (ClassCastException unused) {
            n(str);
            return null;
        }
    }

    @NotNull
    @MainThread
    public final <T> MutableLiveData<T> i(@NotNull String str) {
        Intrinsics.p(str, "key");
        MutableLiveData<T> k2 = k(str, false, (Object) null);
        Intrinsics.n(k2, "null cannot be cast to non-null type androidx.lifecycle.MutableLiveData<T of androidx.lifecycle.SavedStateHandle.getLiveData>");
        return k2;
    }

    @NotNull
    @MainThread
    public final <T> MutableLiveData<T> j(@NotNull String str, T t) {
        Intrinsics.p(str, "key");
        return k(str, true, t);
    }

    @NotNull
    @MainThread
    public final <T> StateFlow<T> l(@NotNull String str, T t) {
        Intrinsics.p(str, "key");
        Map<String, MutableStateFlow<Object>> map = this.f8574d;
        MutableStateFlow<Object> mutableStateFlow = map.get(str);
        if (mutableStateFlow == null) {
            if (!this.f8571a.containsKey(str)) {
                this.f8571a.put(str, t);
            }
            mutableStateFlow = StateFlowKt.a(this.f8571a.get(str));
            this.f8574d.put(str, mutableStateFlow);
            map.put(str, mutableStateFlow);
        }
        StateFlow<T> m2 = FlowKt.m(mutableStateFlow);
        Intrinsics.n(m2, "null cannot be cast to non-null type kotlinx.coroutines.flow.StateFlow<T of androidx.lifecycle.SavedStateHandle.getStateFlow>");
        return m2;
    }

    @NotNull
    @MainThread
    public final Set<String> m() {
        return SetsKt.C(SetsKt.C(this.f8571a.keySet(), this.f8572b.keySet()), this.f8573c.keySet());
    }

    @Nullable
    @MainThread
    public final <T> T n(@NotNull String str) {
        Intrinsics.p(str, "key");
        T remove = this.f8571a.remove(str);
        SavingStateLiveData remove2 = this.f8573c.remove(str);
        if (remove2 != null) {
            remove2.s();
        }
        this.f8574d.remove(str);
        return remove;
    }

    @NotNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final SavedStateRegistry.SavedStateProvider o() {
        return this.f8575e;
    }

    @MainThread
    public final <T> void q(@NotNull String str, @Nullable T t) {
        Intrinsics.p(str, "key");
        if (f8567f.b(t)) {
            SavingStateLiveData<?> savingStateLiveData = this.f8573c.get(str);
            MutableLiveData mutableLiveData = savingStateLiveData instanceof MutableLiveData ? savingStateLiveData : null;
            if (mutableLiveData != null) {
                mutableLiveData.r(t);
            } else {
                this.f8571a.put(str, t);
            }
            MutableStateFlow mutableStateFlow = this.f8574d.get(str);
            if (mutableStateFlow != null) {
                mutableStateFlow.setValue(t);
                return;
            }
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Can't put value with type ");
        Intrinsics.m(t);
        sb.append(t.getClass());
        sb.append(" into saved state");
        throw new IllegalArgumentException(sb.toString());
    }

    @MainThread
    public final void r(@NotNull String str, @NotNull SavedStateRegistry.SavedStateProvider savedStateProvider) {
        Intrinsics.p(str, "key");
        Intrinsics.p(savedStateProvider, "provider");
        this.f8572b.put(str, savedStateProvider);
    }

    public SavedStateHandle(@NotNull Map<String, ? extends Object> map) {
        Intrinsics.p(map, "initialState");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.f8571a = linkedHashMap;
        this.f8572b = new LinkedHashMap();
        this.f8573c = new LinkedHashMap();
        this.f8574d = new LinkedHashMap();
        this.f8575e = new k(this);
        linkedHashMap.putAll(map);
    }
}
