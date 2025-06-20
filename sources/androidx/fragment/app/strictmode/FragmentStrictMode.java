package androidx.fragment.app.strictmode;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.ViewGroup;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import d.a;
import d.b;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\bÆ\u0002\u0018\u00002\u00020\u0001:\u0003<=>B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0004\b\f\u0010\rJ!\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0014\u0010\u0013J\u001f\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015H\u0007¢\u0006\u0004\b\u0017\u0010\u0018J'\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001bH\u0007¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u001f\u0010\u0013J\u0017\u0010 \u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b \u0010\u0013J\u001f\u0010!\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0007¢\u0006\u0004\b!\u0010\u0011J\u0017\u0010$\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\"H\u0002¢\u0006\u0004\b$\u0010%J7\u0010*\u001a\u00020\u00152\u0006\u0010&\u001a\u00020\u00062\u000e\u0010(\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040'2\u000e\u0010)\u001a\n\u0012\u0006\b\u0001\u0012\u00020\"0'H\u0002¢\u0006\u0004\b*\u0010+J\u001f\u0010,\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\"H\u0002¢\u0006\u0004\b,\u0010-J\u001f\u00100\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010/\u001a\u00020.H\u0002¢\u0006\u0004\b0\u00101J\u0017\u00102\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\"H\u0007¢\u0006\u0004\b2\u0010%R\u0014\u00105\u001a\u00020\t8\u0002XT¢\u0006\u0006\n\u0004\b3\u00104R\"\u0010;\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b6\u00108\"\u0004\b9\u0010:¨\u0006?"}, d2 = {"Landroidx/fragment/app/strictmode/FragmentStrictMode;", "", "<init>", "()V", "Landroidx/fragment/app/Fragment;", "fragment", "Landroidx/fragment/app/strictmode/FragmentStrictMode$Policy;", "d", "(Landroidx/fragment/app/Fragment;)Landroidx/fragment/app/strictmode/FragmentStrictMode$Policy;", "", "previousFragmentId", "", "i", "(Landroidx/fragment/app/Fragment;Ljava/lang/String;)V", "Landroid/view/ViewGroup;", "container", "j", "(Landroidx/fragment/app/Fragment;Landroid/view/ViewGroup;)V", "o", "(Landroidx/fragment/app/Fragment;)V", "k", "", "isVisibleToUser", "q", "(Landroidx/fragment/app/Fragment;Z)V", "violatingFragment", "targetFragment", "", "requestCode", "p", "(Landroidx/fragment/app/Fragment;Landroidx/fragment/app/Fragment;I)V", "m", "l", "r", "Landroidx/fragment/app/strictmode/Violation;", "violation", "h", "(Landroidx/fragment/app/strictmode/Violation;)V", "policy", "Ljava/lang/Class;", "fragmentClass", "violationClass", "u", "(Landroidx/fragment/app/strictmode/FragmentStrictMode$Policy;Ljava/lang/Class;Ljava/lang/Class;)Z", "e", "(Landroidx/fragment/app/strictmode/FragmentStrictMode$Policy;Landroidx/fragment/app/strictmode/Violation;)V", "Ljava/lang/Runnable;", "runnable", "s", "(Landroidx/fragment/app/Fragment;Ljava/lang/Runnable;)V", "n", "b", "Ljava/lang/String;", "TAG", "c", "Landroidx/fragment/app/strictmode/FragmentStrictMode$Policy;", "()Landroidx/fragment/app/strictmode/FragmentStrictMode$Policy;", "t", "(Landroidx/fragment/app/strictmode/FragmentStrictMode$Policy;)V", "defaultPolicy", "Flag", "OnViolationListener", "Policy", "fragment_release"}, k = 1, mv = {1, 6, 0})
public final class FragmentStrictMode {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final FragmentStrictMode f8054a = new FragmentStrictMode();
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private static final String f8055b = "FragmentStrictMode";
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private static Policy f8056c = Policy.f8058e;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Landroidx/fragment/app/strictmode/FragmentStrictMode$Flag;", "", "<init>", "(Ljava/lang/String;I)V", "s", "X", "Y", "Z", "X2", "Y2", "Z2", "a3", "fragment_release"}, k = 1, mv = {1, 6, 0})
    public enum Flag {
        PENALTY_LOG,
        PENALTY_DEATH,
        DETECT_FRAGMENT_REUSE,
        DETECT_FRAGMENT_TAG_USAGE,
        DETECT_RETAIN_INSTANCE_USAGE,
        DETECT_SET_USER_VISIBLE_HINT,
        DETECT_TARGET_FRAGMENT_USAGE,
        DETECT_WRONG_FRAGMENT_CONTAINER
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bæ\u0001\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/fragment/app/strictmode/FragmentStrictMode$OnViolationListener;", "", "Landroidx/fragment/app/strictmode/Violation;", "violation", "", "a", "(Landroidx/fragment/app/strictmode/Violation;)V", "fragment_release"}, k = 1, mv = {1, 6, 0})
    public interface OnViolationListener {
        void a(@NotNull Violation violation);
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 \u00192\u00020\u0001:\u0002\u001a\u001bBC\b\u0000\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012 \u0010\f\u001a\u001c\u0012\u0004\u0012\u00020\b\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u000b0\n0\t0\u0007¢\u0006\u0004\b\r\u0010\u000eR \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0000X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0000X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0012\u0010\u0014R4\u0010\u0018\u001a\u001c\u0012\u0004\u0012\u00020\b\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u000b0\n0\u00020\u00078\u0000X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0015\u0010\u0017¨\u0006\u001c"}, d2 = {"Landroidx/fragment/app/strictmode/FragmentStrictMode$Policy;", "", "", "Landroidx/fragment/app/strictmode/FragmentStrictMode$Flag;", "flags", "Landroidx/fragment/app/strictmode/FragmentStrictMode$OnViolationListener;", "listener", "", "", "", "Ljava/lang/Class;", "Landroidx/fragment/app/strictmode/Violation;", "allowedViolations", "<init>", "(Ljava/util/Set;Landroidx/fragment/app/strictmode/FragmentStrictMode$OnViolationListener;Ljava/util/Map;)V", "a", "Ljava/util/Set;", "()Ljava/util/Set;", "b", "Landroidx/fragment/app/strictmode/FragmentStrictMode$OnViolationListener;", "()Landroidx/fragment/app/strictmode/FragmentStrictMode$OnViolationListener;", "c", "Ljava/util/Map;", "()Ljava/util/Map;", "mAllowedViolations", "d", "Builder", "Companion", "fragment_release"}, k = 1, mv = {1, 6, 0})
    public static final class Policy {
        @NotNull

        /* renamed from: d  reason: collision with root package name */
        public static final Companion f8057d = new Companion((DefaultConstructorMarker) null);
        @NotNull
        @JvmField

        /* renamed from: e  reason: collision with root package name */
        public static final Policy f8058e = new Policy(SetsKt.k(), (OnViolationListener) null, MapsKt.z());
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        private final Set<Flag> f8059a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        private final OnViolationListener f8060b;
        @NotNull

        /* renamed from: c  reason: collision with root package name */
        private final Map<String, Set<Class<? extends Violation>>> f8061c;

        @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0004\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u0006\u0010\u0005J\u0017\u0010\t\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u000b\u0010\u0005J\u000f\u0010\f\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\f\u0010\u0005J\u000f\u0010\r\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\r\u0010\u0005J\u000f\u0010\u000e\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u000e\u0010\u0005J\u000f\u0010\u000f\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u000f\u0010\u0005J\u000f\u0010\u0010\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u0010\u0010\u0005J/\u0010\u0016\u001a\u00020\u00002\u000e\u0010\u0013\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00120\u00112\u000e\u0010\u0015\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u0011H\u0007¢\u0006\u0004\b\u0016\u0010\u0017J'\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u00182\u000e\u0010\u0015\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u0011H\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ\r\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001c\u0010\u001dR\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010 R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\"R.\u0010%\u001a\u001c\u0012\u0004\u0012\u00020\u0018\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u00110\u001e0#8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010$¨\u0006&"}, d2 = {"Landroidx/fragment/app/strictmode/FragmentStrictMode$Policy$Builder;", "", "<init>", "()V", "l", "()Landroidx/fragment/app/strictmode/FragmentStrictMode$Policy$Builder;", "j", "Landroidx/fragment/app/strictmode/FragmentStrictMode$OnViolationListener;", "listener", "k", "(Landroidx/fragment/app/strictmode/FragmentStrictMode$OnViolationListener;)Landroidx/fragment/app/strictmode/FragmentStrictMode$Policy$Builder;", "d", "e", "f", "g", "h", "i", "Ljava/lang/Class;", "Landroidx/fragment/app/Fragment;", "fragmentClass", "Landroidx/fragment/app/strictmode/Violation;", "violationClass", "a", "(Ljava/lang/Class;Ljava/lang/Class;)Landroidx/fragment/app/strictmode/FragmentStrictMode$Policy$Builder;", "", "b", "(Ljava/lang/String;Ljava/lang/Class;)Landroidx/fragment/app/strictmode/FragmentStrictMode$Policy$Builder;", "Landroidx/fragment/app/strictmode/FragmentStrictMode$Policy;", "c", "()Landroidx/fragment/app/strictmode/FragmentStrictMode$Policy;", "", "Landroidx/fragment/app/strictmode/FragmentStrictMode$Flag;", "Ljava/util/Set;", "flags", "Landroidx/fragment/app/strictmode/FragmentStrictMode$OnViolationListener;", "", "Ljava/util/Map;", "mAllowedViolations", "fragment_release"}, k = 1, mv = {1, 6, 0})
        public static final class Builder {
            @NotNull

            /* renamed from: a  reason: collision with root package name */
            private final Set<Flag> f8062a = new LinkedHashSet();
            @Nullable

            /* renamed from: b  reason: collision with root package name */
            private OnViolationListener f8063b;
            @NotNull

            /* renamed from: c  reason: collision with root package name */
            private final Map<String, Set<Class<? extends Violation>>> f8064c = new LinkedHashMap();

            @NotNull
            @SuppressLint({"BuilderSetStyle"})
            public final Builder a(@NotNull Class<? extends Fragment> cls, @NotNull Class<? extends Violation> cls2) {
                Intrinsics.p(cls, "fragmentClass");
                Intrinsics.p(cls2, "violationClass");
                String name = cls.getName();
                Intrinsics.o(name, "fragmentClassString");
                return b(name, cls2);
            }

            @NotNull
            @SuppressLint({"BuilderSetStyle"})
            public final Builder b(@NotNull String str, @NotNull Class<? extends Violation> cls) {
                Intrinsics.p(str, "fragmentClass");
                Intrinsics.p(cls, "violationClass");
                Set set = this.f8064c.get(str);
                if (set == null) {
                    set = new LinkedHashSet();
                }
                set.add(cls);
                this.f8064c.put(str, set);
                return this;
            }

            @NotNull
            public final Policy c() {
                if (this.f8063b == null && !this.f8062a.contains(Flag.PENALTY_DEATH)) {
                    l();
                }
                return new Policy(this.f8062a, this.f8063b, this.f8064c);
            }

            @NotNull
            @SuppressLint({"BuilderSetStyle"})
            public final Builder d() {
                this.f8062a.add(Flag.DETECT_FRAGMENT_REUSE);
                return this;
            }

            @NotNull
            @SuppressLint({"BuilderSetStyle"})
            public final Builder e() {
                this.f8062a.add(Flag.DETECT_FRAGMENT_TAG_USAGE);
                return this;
            }

            @NotNull
            @SuppressLint({"BuilderSetStyle"})
            public final Builder f() {
                this.f8062a.add(Flag.DETECT_RETAIN_INSTANCE_USAGE);
                return this;
            }

            @NotNull
            @SuppressLint({"BuilderSetStyle"})
            public final Builder g() {
                this.f8062a.add(Flag.DETECT_SET_USER_VISIBLE_HINT);
                return this;
            }

            @NotNull
            @SuppressLint({"BuilderSetStyle"})
            public final Builder h() {
                this.f8062a.add(Flag.DETECT_TARGET_FRAGMENT_USAGE);
                return this;
            }

            @NotNull
            @SuppressLint({"BuilderSetStyle"})
            public final Builder i() {
                this.f8062a.add(Flag.DETECT_WRONG_FRAGMENT_CONTAINER);
                return this;
            }

            @NotNull
            @SuppressLint({"BuilderSetStyle"})
            public final Builder j() {
                this.f8062a.add(Flag.PENALTY_DEATH);
                return this;
            }

            @NotNull
            @SuppressLint({"BuilderSetStyle"})
            public final Builder k(@NotNull OnViolationListener onViolationListener) {
                Intrinsics.p(onViolationListener, ServiceSpecificExtraArgs.CastExtraArgs.f20260a);
                this.f8063b = onViolationListener;
                return this;
            }

            @NotNull
            @SuppressLint({"BuilderSetStyle"})
            public final Builder l() {
                this.f8062a.add(Flag.PENALTY_LOG);
                return this;
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Landroidx/fragment/app/strictmode/FragmentStrictMode$Policy$Companion;", "", "()V", "LAX", "Landroidx/fragment/app/strictmode/FragmentStrictMode$Policy;", "fragment_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Policy(@NotNull Set<? extends Flag> set, @Nullable OnViolationListener onViolationListener, @NotNull Map<String, ? extends Set<Class<? extends Violation>>> map) {
            Intrinsics.p(set, "flags");
            Intrinsics.p(map, "allowedViolations");
            this.f8059a = set;
            this.f8060b = onViolationListener;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry next : map.entrySet()) {
                linkedHashMap.put((String) next.getKey(), (Set) next.getValue());
            }
            this.f8061c = linkedHashMap;
        }

        @NotNull
        public final Set<Flag> a() {
            return this.f8059a;
        }

        @Nullable
        public final OnViolationListener b() {
            return this.f8060b;
        }

        @NotNull
        public final Map<String, Set<Class<? extends Violation>>> c() {
            return this.f8061c;
        }
    }

    private FragmentStrictMode() {
    }

    private final Policy d(Fragment fragment) {
        while (fragment != null) {
            if (fragment.y0()) {
                FragmentManager V = fragment.V();
                Intrinsics.o(V, "declaringFragment.parentFragmentManager");
                if (V.P0() != null) {
                    Policy P0 = V.P0();
                    Intrinsics.m(P0);
                    return P0;
                }
            }
            fragment = fragment.U();
        }
        return f8056c;
    }

    private final void e(Policy policy, Violation violation) {
        Fragment a2 = violation.a();
        String name = a2.getClass().getName();
        if (policy.a().contains(Flag.PENALTY_LOG)) {
            Log.d(f8055b, "Policy violation in " + name, violation);
        }
        if (policy.b() != null) {
            s(a2, new a(policy, violation));
        }
        if (policy.a().contains(Flag.PENALTY_DEATH)) {
            s(a2, new b(name, violation));
        }
    }

    /* access modifiers changed from: private */
    public static final void f(Policy policy, Violation violation) {
        Intrinsics.p(policy, "$policy");
        Intrinsics.p(violation, "$violation");
        policy.b().a(violation);
    }

    /* access modifiers changed from: private */
    public static final void g(String str, Violation violation) {
        Intrinsics.p(violation, "$violation");
        Log.e(f8055b, "Policy violation with PENALTY_DEATH in " + str, violation);
        throw violation;
    }

    private final void h(Violation violation) {
        if (FragmentManager.W0(3)) {
            Log.d(FragmentManager.Y, "StrictMode violation in " + violation.a().getClass().getName(), violation);
        }
    }

    @JvmStatic
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final void i(@NotNull Fragment fragment, @NotNull String str) {
        Intrinsics.p(fragment, "fragment");
        Intrinsics.p(str, "previousFragmentId");
        FragmentReuseViolation fragmentReuseViolation = new FragmentReuseViolation(fragment, str);
        FragmentStrictMode fragmentStrictMode = f8054a;
        fragmentStrictMode.h(fragmentReuseViolation);
        Policy d2 = fragmentStrictMode.d(fragment);
        if (d2.a().contains(Flag.DETECT_FRAGMENT_REUSE) && fragmentStrictMode.u(d2, fragment.getClass(), fragmentReuseViolation.getClass())) {
            fragmentStrictMode.e(d2, fragmentReuseViolation);
        }
    }

    @JvmStatic
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final void j(@NotNull Fragment fragment, @Nullable ViewGroup viewGroup) {
        Intrinsics.p(fragment, "fragment");
        FragmentTagUsageViolation fragmentTagUsageViolation = new FragmentTagUsageViolation(fragment, viewGroup);
        FragmentStrictMode fragmentStrictMode = f8054a;
        fragmentStrictMode.h(fragmentTagUsageViolation);
        Policy d2 = fragmentStrictMode.d(fragment);
        if (d2.a().contains(Flag.DETECT_FRAGMENT_TAG_USAGE) && fragmentStrictMode.u(d2, fragment.getClass(), fragmentTagUsageViolation.getClass())) {
            fragmentStrictMode.e(d2, fragmentTagUsageViolation);
        }
    }

    @JvmStatic
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final void k(@NotNull Fragment fragment) {
        Intrinsics.p(fragment, "fragment");
        GetRetainInstanceUsageViolation getRetainInstanceUsageViolation = new GetRetainInstanceUsageViolation(fragment);
        FragmentStrictMode fragmentStrictMode = f8054a;
        fragmentStrictMode.h(getRetainInstanceUsageViolation);
        Policy d2 = fragmentStrictMode.d(fragment);
        if (d2.a().contains(Flag.DETECT_RETAIN_INSTANCE_USAGE) && fragmentStrictMode.u(d2, fragment.getClass(), getRetainInstanceUsageViolation.getClass())) {
            fragmentStrictMode.e(d2, getRetainInstanceUsageViolation);
        }
    }

    @JvmStatic
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final void l(@NotNull Fragment fragment) {
        Intrinsics.p(fragment, "fragment");
        GetTargetFragmentRequestCodeUsageViolation getTargetFragmentRequestCodeUsageViolation = new GetTargetFragmentRequestCodeUsageViolation(fragment);
        FragmentStrictMode fragmentStrictMode = f8054a;
        fragmentStrictMode.h(getTargetFragmentRequestCodeUsageViolation);
        Policy d2 = fragmentStrictMode.d(fragment);
        if (d2.a().contains(Flag.DETECT_TARGET_FRAGMENT_USAGE) && fragmentStrictMode.u(d2, fragment.getClass(), getTargetFragmentRequestCodeUsageViolation.getClass())) {
            fragmentStrictMode.e(d2, getTargetFragmentRequestCodeUsageViolation);
        }
    }

    @JvmStatic
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final void m(@NotNull Fragment fragment) {
        Intrinsics.p(fragment, "fragment");
        GetTargetFragmentUsageViolation getTargetFragmentUsageViolation = new GetTargetFragmentUsageViolation(fragment);
        FragmentStrictMode fragmentStrictMode = f8054a;
        fragmentStrictMode.h(getTargetFragmentUsageViolation);
        Policy d2 = fragmentStrictMode.d(fragment);
        if (d2.a().contains(Flag.DETECT_TARGET_FRAGMENT_USAGE) && fragmentStrictMode.u(d2, fragment.getClass(), getTargetFragmentUsageViolation.getClass())) {
            fragmentStrictMode.e(d2, getTargetFragmentUsageViolation);
        }
    }

    @JvmStatic
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final void o(@NotNull Fragment fragment) {
        Intrinsics.p(fragment, "fragment");
        SetRetainInstanceUsageViolation setRetainInstanceUsageViolation = new SetRetainInstanceUsageViolation(fragment);
        FragmentStrictMode fragmentStrictMode = f8054a;
        fragmentStrictMode.h(setRetainInstanceUsageViolation);
        Policy d2 = fragmentStrictMode.d(fragment);
        if (d2.a().contains(Flag.DETECT_RETAIN_INSTANCE_USAGE) && fragmentStrictMode.u(d2, fragment.getClass(), setRetainInstanceUsageViolation.getClass())) {
            fragmentStrictMode.e(d2, setRetainInstanceUsageViolation);
        }
    }

    @JvmStatic
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final void p(@NotNull Fragment fragment, @NotNull Fragment fragment2, int i2) {
        Intrinsics.p(fragment, "violatingFragment");
        Intrinsics.p(fragment2, "targetFragment");
        SetTargetFragmentUsageViolation setTargetFragmentUsageViolation = new SetTargetFragmentUsageViolation(fragment, fragment2, i2);
        FragmentStrictMode fragmentStrictMode = f8054a;
        fragmentStrictMode.h(setTargetFragmentUsageViolation);
        Policy d2 = fragmentStrictMode.d(fragment);
        if (d2.a().contains(Flag.DETECT_TARGET_FRAGMENT_USAGE) && fragmentStrictMode.u(d2, fragment.getClass(), setTargetFragmentUsageViolation.getClass())) {
            fragmentStrictMode.e(d2, setTargetFragmentUsageViolation);
        }
    }

    @JvmStatic
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final void q(@NotNull Fragment fragment, boolean z) {
        Intrinsics.p(fragment, "fragment");
        SetUserVisibleHintViolation setUserVisibleHintViolation = new SetUserVisibleHintViolation(fragment, z);
        FragmentStrictMode fragmentStrictMode = f8054a;
        fragmentStrictMode.h(setUserVisibleHintViolation);
        Policy d2 = fragmentStrictMode.d(fragment);
        if (d2.a().contains(Flag.DETECT_SET_USER_VISIBLE_HINT) && fragmentStrictMode.u(d2, fragment.getClass(), setUserVisibleHintViolation.getClass())) {
            fragmentStrictMode.e(d2, setUserVisibleHintViolation);
        }
    }

    @JvmStatic
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final void r(@NotNull Fragment fragment, @NotNull ViewGroup viewGroup) {
        Intrinsics.p(fragment, "fragment");
        Intrinsics.p(viewGroup, TtmlNode.W);
        WrongFragmentContainerViolation wrongFragmentContainerViolation = new WrongFragmentContainerViolation(fragment, viewGroup);
        FragmentStrictMode fragmentStrictMode = f8054a;
        fragmentStrictMode.h(wrongFragmentContainerViolation);
        Policy d2 = fragmentStrictMode.d(fragment);
        if (d2.a().contains(Flag.DETECT_WRONG_FRAGMENT_CONTAINER) && fragmentStrictMode.u(d2, fragment.getClass(), wrongFragmentContainerViolation.getClass())) {
            fragmentStrictMode.e(d2, wrongFragmentContainerViolation);
        }
    }

    private final void s(Fragment fragment, Runnable runnable) {
        if (fragment.y0()) {
            Handler n2 = fragment.V().J0().n();
            Intrinsics.o(n2, "fragment.parentFragmentManager.host.handler");
            if (!Intrinsics.g(n2.getLooper(), Looper.myLooper())) {
                n2.post(runnable);
                return;
            }
        }
        runnable.run();
    }

    private final boolean u(Policy policy, Class<? extends Fragment> cls, Class<? extends Violation> cls2) {
        Set set = policy.c().get(cls.getName());
        if (set == null) {
            return true;
        }
        if (Intrinsics.g(cls2.getSuperclass(), Violation.class) || !CollectionsKt.T1(set, cls2.getSuperclass())) {
            return !set.contains(cls2);
        }
        return false;
    }

    @NotNull
    public final Policy c() {
        return f8056c;
    }

    @VisibleForTesting
    public final void n(@NotNull Violation violation) {
        Intrinsics.p(violation, "violation");
        h(violation);
        Fragment a2 = violation.a();
        Policy d2 = d(a2);
        if (u(d2, a2.getClass(), violation.getClass())) {
            e(d2, violation);
        }
    }

    public final void t(@NotNull Policy policy) {
        Intrinsics.p(policy, "<set-?>");
        f8056c = policy;
    }
}
