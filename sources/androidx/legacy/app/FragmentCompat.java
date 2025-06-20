package androidx.legacy.app;

import android.app.Activity;
import android.app.Fragment;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.util.Arrays;

@Deprecated
public class FragmentCompat {

    /* renamed from: a  reason: collision with root package name */
    static final FragmentCompatImpl f8087a;

    /* renamed from: b  reason: collision with root package name */
    private static PermissionCompatDelegate f8088b;

    @RequiresApi(15)
    static class FragmentCompatApi15Impl extends FragmentCompatBaseImpl {
        FragmentCompatApi15Impl() {
        }

        public void c(Fragment fragment, boolean z) {
            fragment.setUserVisibleHint(z);
        }
    }

    @RequiresApi(23)
    static class FragmentCompatApi23Impl extends FragmentCompatApi15Impl {
        FragmentCompatApi23Impl() {
        }

        public void a(Fragment fragment, String[] strArr, int i2) {
            fragment.requestPermissions(strArr, i2);
        }

        public boolean b(Fragment fragment, String str) {
            return fragment.shouldShowRequestPermissionRationale(str);
        }
    }

    @RequiresApi(24)
    static class FragmentCompatApi24Impl extends FragmentCompatApi23Impl {
        FragmentCompatApi24Impl() {
        }

        public void c(Fragment fragment, boolean z) {
            fragment.setUserVisibleHint(z);
        }
    }

    static class FragmentCompatBaseImpl implements FragmentCompatImpl {
        FragmentCompatBaseImpl() {
        }

        public void a(final Fragment fragment, final String[] strArr, final int i2) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                public void run() {
                    int[] iArr = new int[strArr.length];
                    Activity activity = fragment.getActivity();
                    if (activity != null) {
                        PackageManager packageManager = activity.getPackageManager();
                        String packageName = activity.getPackageName();
                        int length = strArr.length;
                        for (int i2 = 0; i2 < length; i2++) {
                            iArr[i2] = packageManager.checkPermission(strArr[i2], packageName);
                        }
                    } else {
                        Arrays.fill(iArr, -1);
                    }
                    ((OnRequestPermissionsResultCallback) fragment).onRequestPermissionsResult(i2, strArr, iArr);
                }
            });
        }

        public boolean b(Fragment fragment, String str) {
            return false;
        }

        public void c(Fragment fragment, boolean z) {
        }
    }

    interface FragmentCompatImpl {
        void a(Fragment fragment, String[] strArr, int i2);

        boolean b(Fragment fragment, String str);

        void c(Fragment fragment, boolean z);
    }

    @Deprecated
    public interface OnRequestPermissionsResultCallback {
        @Deprecated
        void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr);
    }

    @Deprecated
    public interface PermissionCompatDelegate {
        @Deprecated
        boolean a(Fragment fragment, String[] strArr, int i2);
    }

    static {
        int i2 = Build.VERSION.SDK_INT;
        f8087a = i2 >= 24 ? new FragmentCompatApi24Impl() : i2 >= 23 ? new FragmentCompatApi23Impl() : new FragmentCompatApi15Impl();
    }

    @Deprecated
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static PermissionCompatDelegate a() {
        return f8088b;
    }

    @Deprecated
    public static void b(@NonNull Fragment fragment, @NonNull String[] strArr, int i2) {
        PermissionCompatDelegate permissionCompatDelegate = f8088b;
        if (permissionCompatDelegate == null || !permissionCompatDelegate.a(fragment, strArr, i2)) {
            f8087a.a(fragment, strArr, i2);
        }
    }

    @Deprecated
    public static void c(Fragment fragment, boolean z) {
        fragment.setMenuVisibility(z);
    }

    @Deprecated
    public static void d(PermissionCompatDelegate permissionCompatDelegate) {
        f8088b = permissionCompatDelegate;
    }

    @Deprecated
    public static void e(Fragment fragment, boolean z) {
        f8087a.c(fragment, z);
    }

    @Deprecated
    public static boolean f(@NonNull Fragment fragment, @NonNull String str) {
        return f8087a.b(fragment, str);
    }
}
