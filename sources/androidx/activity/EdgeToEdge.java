package androidx.activity;

import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.Window;
import androidx.activity.SystemBarStyle;
import androidx.annotation.VisibleForTesting;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nEdgeToEdge.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EdgeToEdge.kt\nandroidx/activity/EdgeToEdge\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,301:1\n1#2:302\n*E\n"})
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a'\u0010\u0005\u001a\u00020\u0004*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\" \u0010\u000e\u001a\u00020\u00078\u0000X\u0004¢\u0006\u0012\n\u0004\b\b\u0010\t\u0012\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000b\" \u0010\u0012\u001a\u00020\u00078\u0000X\u0004¢\u0006\u0012\n\u0004\b\u000f\u0010\t\u0012\u0004\b\u0011\u0010\r\u001a\u0004\b\u0010\u0010\u000b\"\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0014¨\u0006\u0016"}, d2 = {"Landroidx/activity/ComponentActivity;", "Landroidx/activity/SystemBarStyle;", "statusBarStyle", "navigationBarStyle", "", "c", "(Landroidx/activity/ComponentActivity;Landroidx/activity/SystemBarStyle;Landroidx/activity/SystemBarStyle;)V", "", "a", "I", "g", "()I", "h", "()V", "DefaultLightScrim", "b", "e", "f", "DefaultDarkScrim", "Landroidx/activity/EdgeToEdgeImpl;", "Landroidx/activity/EdgeToEdgeImpl;", "Impl", "activity_release"}, k = 2, mv = {1, 8, 0})
@JvmName(name = "EdgeToEdge")
public final class EdgeToEdge {

    /* renamed from: a  reason: collision with root package name */
    private static final int f2423a = Color.argb(230, 255, 255, 255);

    /* renamed from: b  reason: collision with root package name */
    private static final int f2424b = Color.argb(128, 27, 27, 27);
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private static EdgeToEdgeImpl f2425c;

    @JvmOverloads
    @JvmName(name = "enable")
    public static final void a(@NotNull ComponentActivity componentActivity) {
        Intrinsics.p(componentActivity, "<this>");
        d(componentActivity, (SystemBarStyle) null, (SystemBarStyle) null, 3, (Object) null);
    }

    @JvmOverloads
    @JvmName(name = "enable")
    public static final void b(@NotNull ComponentActivity componentActivity, @NotNull SystemBarStyle systemBarStyle) {
        Intrinsics.p(componentActivity, "<this>");
        Intrinsics.p(systemBarStyle, "statusBarStyle");
        d(componentActivity, systemBarStyle, (SystemBarStyle) null, 2, (Object) null);
    }

    @JvmOverloads
    @JvmName(name = "enable")
    public static final void c(@NotNull ComponentActivity componentActivity, @NotNull SystemBarStyle systemBarStyle, @NotNull SystemBarStyle systemBarStyle2) {
        Intrinsics.p(componentActivity, "<this>");
        Intrinsics.p(systemBarStyle, "statusBarStyle");
        Intrinsics.p(systemBarStyle2, "navigationBarStyle");
        View decorView = componentActivity.getWindow().getDecorView();
        Intrinsics.o(decorView, "window.decorView");
        Function1<Resources, Boolean> e2 = systemBarStyle.e();
        Resources resources = decorView.getResources();
        Intrinsics.o(resources, "view.resources");
        boolean booleanValue = e2.f(resources).booleanValue();
        Function1<Resources, Boolean> e3 = systemBarStyle2.e();
        Resources resources2 = decorView.getResources();
        Intrinsics.o(resources2, "view.resources");
        boolean booleanValue2 = e3.f(resources2).booleanValue();
        EdgeToEdgeImpl edgeToEdgeImpl = f2425c;
        if (edgeToEdgeImpl == null) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 29) {
                edgeToEdgeImpl = new EdgeToEdgeApi29();
            } else if (i2 >= 26) {
                edgeToEdgeImpl = new EdgeToEdgeApi26();
            } else if (i2 >= 23) {
                edgeToEdgeImpl = new EdgeToEdgeApi23();
            } else {
                edgeToEdgeImpl = new EdgeToEdgeApi21();
                f2425c = edgeToEdgeImpl;
            }
        }
        EdgeToEdgeImpl edgeToEdgeImpl2 = edgeToEdgeImpl;
        Window window = componentActivity.getWindow();
        Intrinsics.o(window, "window");
        edgeToEdgeImpl2.a(systemBarStyle, systemBarStyle2, window, decorView, booleanValue, booleanValue2);
    }

    public static /* synthetic */ void d(ComponentActivity componentActivity, SystemBarStyle systemBarStyle, SystemBarStyle systemBarStyle2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            systemBarStyle = SystemBarStyle.Companion.c(SystemBarStyle.f2454e, 0, 0, (Function1) null, 4, (Object) null);
        }
        if ((i2 & 2) != 0) {
            systemBarStyle2 = SystemBarStyle.Companion.c(SystemBarStyle.f2454e, f2423a, f2424b, (Function1) null, 4, (Object) null);
        }
        c(componentActivity, systemBarStyle, systemBarStyle2);
    }

    public static final int e() {
        return f2424b;
    }

    @VisibleForTesting
    public static /* synthetic */ void f() {
    }

    public static final int g() {
        return f2423a;
    }

    @VisibleForTesting
    public static /* synthetic */ void h() {
    }
}
