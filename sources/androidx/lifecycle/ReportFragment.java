package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.Lifecycle;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0017\u0018\u0000 \u001c2\u00020\u0001:\u0003\u001d\u001e\u001fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\t\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\t\u0010\bJ\u0019\u0010\n\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\n\u0010\bJ\u0017\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0011\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0013\u0010\u0003J\u000f\u0010\u0014\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0014\u0010\u0003J\u000f\u0010\u0015\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0015\u0010\u0003J\u000f\u0010\u0016\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0016\u0010\u0003J\u000f\u0010\u0017\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0017\u0010\u0003J\u0017\u0010\u0019\u001a\u00020\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0019\u0010\bR\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006 "}, d2 = {"Landroidx/lifecycle/ReportFragment;", "Landroid/app/Fragment;", "<init>", "()V", "Landroidx/lifecycle/ReportFragment$ActivityInitializationListener;", "listener", "", "c", "(Landroidx/lifecycle/ReportFragment$ActivityInitializationListener;)V", "e", "d", "Landroidx/lifecycle/Lifecycle$Event;", "event", "a", "(Landroidx/lifecycle/Lifecycle$Event;)V", "Landroid/os/Bundle;", "savedInstanceState", "onActivityCreated", "(Landroid/os/Bundle;)V", "onStart", "onResume", "onPause", "onStop", "onDestroy", "processListener", "h", "s", "Landroidx/lifecycle/ReportFragment$ActivityInitializationListener;", "X", "ActivityInitializationListener", "Companion", "LifecycleCallbacks", "lifecycle-runtime_release"}, k = 1, mv = {1, 8, 0})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class ReportFragment extends Fragment {
    @NotNull
    public static final Companion X = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String Y = "androidx.lifecycle.LifecycleDispatcher.report_fragment_tag";
    @Nullable
    private ActivityInitializationListener s;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0004ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0001"}, d2 = {"Landroidx/lifecycle/ReportFragment$ActivityInitializationListener;", "", "", "b", "()V", "a", "c", "lifecycle-runtime_release"}, k = 1, mv = {1, 8, 0})
    public interface ActivityInitializationListener {
        void a();

        void b();

        void c();
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0001¢\u0006\u0004\b\u000b\u0010\fR\u001e\u0010\u0011\u001a\u00020\r*\u00020\u00048GX\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\b\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\u00128\u0002XT¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Landroidx/lifecycle/ReportFragment$Companion;", "", "<init>", "()V", "Landroid/app/Activity;", "activity", "", "d", "(Landroid/app/Activity;)V", "Landroidx/lifecycle/Lifecycle$Event;", "event", "a", "(Landroid/app/Activity;Landroidx/lifecycle/Lifecycle$Event;)V", "Landroidx/lifecycle/ReportFragment;", "b", "(Landroid/app/Activity;)Landroidx/lifecycle/ReportFragment;", "c", "reportFragment", "", "REPORT_FRAGMENT_TAG", "Ljava/lang/String;", "lifecycle-runtime_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        private Companion() {
        }

        @JvmStatic
        public static /* synthetic */ void c(Activity activity) {
        }

        @JvmStatic
        public final void a(@NotNull Activity activity, @NotNull Lifecycle.Event event) {
            Intrinsics.p(activity, "activity");
            Intrinsics.p(event, NotificationCompat.I0);
            if (activity instanceof LifecycleRegistryOwner) {
                ((LifecycleRegistryOwner) activity).a().l(event);
            } else if (activity instanceof LifecycleOwner) {
                Lifecycle a2 = ((LifecycleOwner) activity).a();
                if (a2 instanceof LifecycleRegistry) {
                    ((LifecycleRegistry) a2).l(event);
                }
            }
        }

        @NotNull
        @JvmName(name = "get")
        public final ReportFragment b(@NotNull Activity activity) {
            Intrinsics.p(activity, "<this>");
            Fragment findFragmentByTag = activity.getFragmentManager().findFragmentByTag(ReportFragment.Y);
            Intrinsics.n(findFragmentByTag, "null cannot be cast to non-null type androidx.lifecycle.ReportFragment");
            return (ReportFragment) findFragmentByTag;
        }

        @JvmStatic
        public final void d(@NotNull Activity activity) {
            Intrinsics.p(activity, "activity");
            if (Build.VERSION.SDK_INT >= 29) {
                LifecycleCallbacks.Companion.a(activity);
            }
            FragmentManager fragmentManager = activity.getFragmentManager();
            if (fragmentManager.findFragmentByTag(ReportFragment.Y) == null) {
                fragmentManager.beginTransaction().add(new ReportFragment(), ReportFragment.Y).commit();
                fragmentManager.executePendingTransactions();
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @RequiresApi(29)
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0001\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001a\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0018\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0017"}, d2 = {"Landroidx/lifecycle/ReportFragment$LifecycleCallbacks;", "Landroid/app/Application$ActivityLifecycleCallbacks;", "()V", "onActivityCreated", "", "activity", "Landroid/app/Activity;", "bundle", "Landroid/os/Bundle;", "onActivityDestroyed", "onActivityPaused", "onActivityPostCreated", "savedInstanceState", "onActivityPostResumed", "onActivityPostStarted", "onActivityPreDestroyed", "onActivityPrePaused", "onActivityPreStopped", "onActivityResumed", "onActivitySaveInstanceState", "onActivityStarted", "onActivityStopped", "Companion", "lifecycle-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class LifecycleCallbacks implements Application.ActivityLifecycleCallbacks {
        @NotNull
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroidx/lifecycle/ReportFragment$LifecycleCallbacks$Companion;", "", "<init>", "()V", "Landroid/app/Activity;", "activity", "", "a", "(Landroid/app/Activity;)V", "lifecycle-runtime_release"}, k = 1, mv = {1, 8, 0})
        public static final class Companion {
            private Companion() {
            }

            @JvmStatic
            public final void a(@NotNull Activity activity) {
                Intrinsics.p(activity, "activity");
                j.a(activity, new LifecycleCallbacks());
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        @JvmStatic
        public static final void registerIn(@NotNull Activity activity) {
            Companion.a(activity);
        }

        public void onActivityCreated(@NotNull Activity activity, @Nullable Bundle bundle) {
            Intrinsics.p(activity, "activity");
        }

        public void onActivityDestroyed(@NotNull Activity activity) {
            Intrinsics.p(activity, "activity");
        }

        public void onActivityPaused(@NotNull Activity activity) {
            Intrinsics.p(activity, "activity");
        }

        public void onActivityPostCreated(@NotNull Activity activity, @Nullable Bundle bundle) {
            Intrinsics.p(activity, "activity");
            ReportFragment.X.a(activity, Lifecycle.Event.ON_CREATE);
        }

        public void onActivityPostResumed(@NotNull Activity activity) {
            Intrinsics.p(activity, "activity");
            ReportFragment.X.a(activity, Lifecycle.Event.ON_RESUME);
        }

        public void onActivityPostStarted(@NotNull Activity activity) {
            Intrinsics.p(activity, "activity");
            ReportFragment.X.a(activity, Lifecycle.Event.ON_START);
        }

        public void onActivityPreDestroyed(@NotNull Activity activity) {
            Intrinsics.p(activity, "activity");
            ReportFragment.X.a(activity, Lifecycle.Event.ON_DESTROY);
        }

        public void onActivityPrePaused(@NotNull Activity activity) {
            Intrinsics.p(activity, "activity");
            ReportFragment.X.a(activity, Lifecycle.Event.ON_PAUSE);
        }

        public void onActivityPreStopped(@NotNull Activity activity) {
            Intrinsics.p(activity, "activity");
            ReportFragment.X.a(activity, Lifecycle.Event.ON_STOP);
        }

        public void onActivityResumed(@NotNull Activity activity) {
            Intrinsics.p(activity, "activity");
        }

        public void onActivitySaveInstanceState(@NotNull Activity activity, @NotNull Bundle bundle) {
            Intrinsics.p(activity, "activity");
            Intrinsics.p(bundle, "bundle");
        }

        public void onActivityStarted(@NotNull Activity activity) {
            Intrinsics.p(activity, "activity");
        }

        public void onActivityStopped(@NotNull Activity activity) {
            Intrinsics.p(activity, "activity");
        }
    }

    private final void a(Lifecycle.Event event) {
        if (Build.VERSION.SDK_INT < 29) {
            Companion companion = X;
            Activity activity = getActivity();
            Intrinsics.o(activity, "activity");
            companion.a(activity, event);
        }
    }

    @JvmStatic
    public static final void b(@NotNull Activity activity, @NotNull Lifecycle.Event event) {
        X.a(activity, event);
    }

    private final void c(ActivityInitializationListener activityInitializationListener) {
        if (activityInitializationListener != null) {
            activityInitializationListener.b();
        }
    }

    private final void d(ActivityInitializationListener activityInitializationListener) {
        if (activityInitializationListener != null) {
            activityInitializationListener.c();
        }
    }

    private final void e(ActivityInitializationListener activityInitializationListener) {
        if (activityInitializationListener != null) {
            activityInitializationListener.a();
        }
    }

    @NotNull
    @JvmName(name = "get")
    public static final ReportFragment f(@NotNull Activity activity) {
        return X.b(activity);
    }

    @JvmStatic
    public static final void g(@NotNull Activity activity) {
        X.d(activity);
    }

    public final void h(@Nullable ActivityInitializationListener activityInitializationListener) {
        this.s = activityInitializationListener;
    }

    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        c(this.s);
        a(Lifecycle.Event.ON_CREATE);
    }

    public void onDestroy() {
        super.onDestroy();
        a(Lifecycle.Event.ON_DESTROY);
        this.s = null;
    }

    public void onPause() {
        super.onPause();
        a(Lifecycle.Event.ON_PAUSE);
    }

    public void onResume() {
        super.onResume();
        d(this.s);
        a(Lifecycle.Event.ON_RESUME);
    }

    public void onStart() {
        super.onStart();
        e(this.s);
        a(Lifecycle.Event.ON_START);
    }

    public void onStop() {
        super.onStop();
        a(Lifecycle.Event.ON_STOP);
    }
}
