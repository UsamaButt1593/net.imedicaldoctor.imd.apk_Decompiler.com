package androidx.activity;

import android.content.res.Resources;
import androidx.annotation.ColorInt;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0013\u0018\u0000 \u00182\u00020\u0001:\u0001\u001aB5\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\bH\u0000¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u000f\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\bH\u0000¢\u0006\u0004\b\u000f\u0010\u000eR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0004\u001a\u00020\u00028\u0000X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0011\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0005\u001a\u00020\u00028\u0000X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0011\u001a\u0004\b\u0016\u0010\u0014R&\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00068\u0000X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001b"}, d2 = {"Landroidx/activity/SystemBarStyle;", "", "", "lightScrim", "darkScrim", "nightMode", "Lkotlin/Function1;", "Landroid/content/res/Resources;", "", "detectDarkMode", "<init>", "(IIILkotlin/jvm/functions/Function1;)V", "isDark", "g", "(Z)I", "h", "a", "I", "b", "d", "()I", "c", "f", "Lkotlin/jvm/functions/Function1;", "e", "()Lkotlin/jvm/functions/Function1;", "Companion", "activity_release"}, k = 1, mv = {1, 8, 0})
public final class SystemBarStyle {
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    public static final Companion f2454e = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final int f2455a;

    /* renamed from: b  reason: collision with root package name */
    private final int f2456b;

    /* renamed from: c  reason: collision with root package name */
    private final int f2457c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final Function1<Resources, Boolean> f2458d;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J9\u0010\f\u001a\u00020\u000b2\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0006\u001a\u00020\u00042\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007H\u0007¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u000f\u001a\u00020\u000b2\b\b\u0001\u0010\u000e\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u000f\u0010\u0010J#\u0010\u0011\u001a\u00020\u000b2\b\b\u0001\u0010\u000e\u001a\u00020\u00042\b\b\u0001\u0010\u0006\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Landroidx/activity/SystemBarStyle$Companion;", "", "<init>", "()V", "", "lightScrim", "darkScrim", "Lkotlin/Function1;", "Landroid/content/res/Resources;", "", "detectDarkMode", "Landroidx/activity/SystemBarStyle;", "b", "(IILkotlin/jvm/functions/Function1;)Landroidx/activity/SystemBarStyle;", "scrim", "d", "(I)Landroidx/activity/SystemBarStyle;", "e", "(II)Landroidx/activity/SystemBarStyle;", "activity_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ SystemBarStyle c(Companion companion, int i2, int i3, Function1 function1, int i4, Object obj) {
            if ((i4 & 4) != 0) {
                function1 = SystemBarStyle$Companion$auto$1.X;
            }
            return companion.b(i2, i3, function1);
        }

        @JvmStatic
        @NotNull
        @JvmOverloads
        public final SystemBarStyle a(@ColorInt int i2, @ColorInt int i3) {
            return c(this, i2, i3, (Function1) null, 4, (Object) null);
        }

        @JvmStatic
        @NotNull
        @JvmOverloads
        public final SystemBarStyle b(@ColorInt int i2, @ColorInt int i3, @NotNull Function1<? super Resources, Boolean> function1) {
            Intrinsics.p(function1, "detectDarkMode");
            return new SystemBarStyle(i2, i3, 0, function1, (DefaultConstructorMarker) null);
        }

        @JvmStatic
        @NotNull
        public final SystemBarStyle d(@ColorInt int i2) {
            return new SystemBarStyle(i2, i2, 2, SystemBarStyle$Companion$dark$1.X, (DefaultConstructorMarker) null);
        }

        @JvmStatic
        @NotNull
        public final SystemBarStyle e(@ColorInt int i2, @ColorInt int i3) {
            return new SystemBarStyle(i2, i3, 1, SystemBarStyle$Companion$light$1.X, (DefaultConstructorMarker) null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private SystemBarStyle(int i2, int i3, int i4, Function1<? super Resources, Boolean> function1) {
        this.f2455a = i2;
        this.f2456b = i3;
        this.f2457c = i4;
        this.f2458d = function1;
    }

    @JvmStatic
    @NotNull
    @JvmOverloads
    public static final SystemBarStyle a(@ColorInt int i2, @ColorInt int i3) {
        return f2454e.a(i2, i3);
    }

    @JvmStatic
    @NotNull
    @JvmOverloads
    public static final SystemBarStyle b(@ColorInt int i2, @ColorInt int i3, @NotNull Function1<? super Resources, Boolean> function1) {
        return f2454e.b(i2, i3, function1);
    }

    @JvmStatic
    @NotNull
    public static final SystemBarStyle c(@ColorInt int i2) {
        return f2454e.d(i2);
    }

    @JvmStatic
    @NotNull
    public static final SystemBarStyle i(@ColorInt int i2, @ColorInt int i3) {
        return f2454e.e(i2, i3);
    }

    public final int d() {
        return this.f2456b;
    }

    @NotNull
    public final Function1<Resources, Boolean> e() {
        return this.f2458d;
    }

    public final int f() {
        return this.f2457c;
    }

    public final int g(boolean z) {
        return z ? this.f2456b : this.f2455a;
    }

    public final int h(boolean z) {
        if (this.f2457c == 0) {
            return 0;
        }
        return z ? this.f2456b : this.f2455a;
    }

    public /* synthetic */ SystemBarStyle(int i2, int i3, int i4, Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
        this(i2, i3, i4, function1);
    }
}
