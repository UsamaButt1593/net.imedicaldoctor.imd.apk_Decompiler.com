package androidx.core.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.SharedElementCallback;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.Display;
import android.view.DragEvent;
import android.view.View;
import androidx.annotation.DoNotInline;
import androidx.annotation.IdRes;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.content.ContextCompat;
import androidx.core.content.LocusIdCompat;
import androidx.core.view.DragAndDropPermissionsCompat;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class ActivityCompat extends ContextCompat {

    /* renamed from: g  reason: collision with root package name */
    private static PermissionCompatDelegate f5209g;

    @RequiresApi(21)
    static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        static void a(Activity activity) {
            activity.finishAfterTransition();
        }

        @DoNotInline
        static void b(Activity activity) {
            activity.postponeEnterTransition();
        }

        @DoNotInline
        static void c(Activity activity, SharedElementCallback sharedElementCallback) {
            activity.setEnterSharedElementCallback(sharedElementCallback);
        }

        @DoNotInline
        static void d(Activity activity, SharedElementCallback sharedElementCallback) {
            activity.setExitSharedElementCallback(sharedElementCallback);
        }

        @DoNotInline
        static void e(Activity activity) {
            activity.startPostponedEnterTransition();
        }
    }

    @RequiresApi(22)
    static class Api22Impl {
        private Api22Impl() {
        }

        @DoNotInline
        static Uri a(Activity activity) {
            return activity.getReferrer();
        }
    }

    @RequiresApi(23)
    static class Api23Impl {
        private Api23Impl() {
        }

        /* access modifiers changed from: package-private */
        @DoNotInline
        public static void a(Object obj) {
            ((SharedElementCallback.OnSharedElementsReadyListener) obj).onSharedElementsReady();
        }

        @DoNotInline
        static void b(Activity activity, String[] strArr, int i2) {
            activity.requestPermissions(strArr, i2);
        }

        @DoNotInline
        static boolean c(Activity activity, String str) {
            return activity.shouldShowRequestPermissionRationale(str);
        }
    }

    @RequiresApi(28)
    static class Api28Impl {
        private Api28Impl() {
        }

        @DoNotInline
        static <T> T a(Activity activity, int i2) {
            return activity.requireViewById(i2);
        }
    }

    @RequiresApi(30)
    static class Api30Impl {
        private Api30Impl() {
        }

        @DoNotInline
        static Display a(ContextWrapper contextWrapper) {
            return contextWrapper.getDisplay();
        }

        @DoNotInline
        static void b(@NonNull Activity activity, @Nullable LocusIdCompat locusIdCompat, @Nullable Bundle bundle) {
            activity.setLocusContext(locusIdCompat == null ? null : locusIdCompat.c(), bundle);
        }
    }

    @RequiresApi(31)
    static class Api31Impl {
        private Api31Impl() {
        }

        @DoNotInline
        static boolean a(@NonNull Activity activity) {
            return activity.isLaunchedFromBubble();
        }

        @DoNotInline
        @SuppressLint({"BanUncheckedReflection"})
        static boolean b(Activity activity, String str) {
            try {
                PackageManager packageManager = activity.getApplication().getPackageManager();
                return ((Boolean) PackageManager.class.getMethod("shouldShowRequestPermissionRationale", new Class[]{String.class}).invoke(packageManager, new Object[]{str})).booleanValue();
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
                return activity.shouldShowRequestPermissionRationale(str);
            }
        }
    }

    @RequiresApi(32)
    static class Api32Impl {
        private Api32Impl() {
        }

        @DoNotInline
        static boolean a(Activity activity, String str) {
            return activity.shouldShowRequestPermissionRationale(str);
        }
    }

    public interface OnRequestPermissionsResultCallback {
        void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr);
    }

    public interface PermissionCompatDelegate {
        boolean a(@NonNull Activity activity, @IntRange(from = 0) int i2, int i3, @Nullable Intent intent);

        boolean b(@NonNull Activity activity, @NonNull String[] strArr, @IntRange(from = 0) int i2);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public interface RequestPermissionsRequestCodeValidator {
        void d(int i2);
    }

    @RequiresApi(21)
    static class SharedElementCallback21Impl extends SharedElementCallback {

        /* renamed from: a  reason: collision with root package name */
        private final SharedElementCallback f5210a;

        SharedElementCallback21Impl(SharedElementCallback sharedElementCallback) {
            this.f5210a = sharedElementCallback;
        }

        public Parcelable onCaptureSharedElementSnapshot(View view, Matrix matrix, RectF rectF) {
            return this.f5210a.b(view, matrix, rectF);
        }

        public View onCreateSnapshotView(Context context, Parcelable parcelable) {
            return this.f5210a.c(context, parcelable);
        }

        public void onMapSharedElements(List<String> list, Map<String, View> map) {
            this.f5210a.d(list, map);
        }

        public void onRejectSharedElements(List<View> list) {
            this.f5210a.e(list);
        }

        public void onSharedElementEnd(List<String> list, List<View> list2, List<View> list3) {
            this.f5210a.f(list, list2, list3);
        }

        public void onSharedElementStart(List<String> list, List<View> list2, List<View> list3) {
            this.f5210a.g(list, list2, list3);
        }

        @RequiresApi(23)
        public void onSharedElementsArrived(List<String> list, List<View> list2, SharedElementCallback.OnSharedElementsReadyListener onSharedElementsReadyListener) {
            this.f5210a.h(list, list2, new b(onSharedElementsReadyListener));
        }
    }

    protected ActivityCompat() {
    }

    public static void D(@NonNull Activity activity) {
        activity.finishAffinity();
    }

    public static void E(@NonNull Activity activity) {
        Api21Impl.a(activity);
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static PermissionCompatDelegate F() {
        return f5209g;
    }

    @Nullable
    public static Uri G(@NonNull Activity activity) {
        if (Build.VERSION.SDK_INT >= 22) {
            return Api22Impl.a(activity);
        }
        Intent intent = activity.getIntent();
        Uri uri = (Uri) intent.getParcelableExtra("android.intent.extra.REFERRER");
        if (uri != null) {
            return uri;
        }
        String stringExtra = intent.getStringExtra("android.intent.extra.REFERRER_NAME");
        if (stringExtra != null) {
            return Uri.parse(stringExtra);
        }
        return null;
    }

    @Deprecated
    public static boolean H(Activity activity) {
        activity.invalidateOptionsMenu();
        return true;
    }

    public static boolean I(@NonNull Activity activity) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 31) {
            return Api31Impl.a(activity);
        }
        return i2 == 30 ? (Api30Impl.a(activity) == null || Api30Impl.a(activity).getDisplayId() == 0) ? false : true : (i2 != 29 || activity.getWindowManager().getDefaultDisplay() == null || activity.getWindowManager().getDefaultDisplay().getDisplayId() == 0) ? false : true;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void J(Activity activity) {
        if (!activity.isFinishing() && !ActivityRecreator.i(activity)) {
            activity.recreate();
        }
    }

    public static void K(@NonNull Activity activity) {
        Api21Impl.b(activity);
    }

    public static void L(@NonNull Activity activity) {
        if (Build.VERSION.SDK_INT >= 28) {
            activity.recreate();
        } else {
            new Handler(activity.getMainLooper()).post(new a(activity));
        }
    }

    @Nullable
    public static DragAndDropPermissionsCompat M(@NonNull Activity activity, @NonNull DragEvent dragEvent) {
        return DragAndDropPermissionsCompat.b(activity, dragEvent);
    }

    public static void N(@NonNull final Activity activity, @NonNull String[] strArr, @IntRange(from = 0) final int i2) {
        PermissionCompatDelegate permissionCompatDelegate = f5209g;
        if (permissionCompatDelegate == null || !permissionCompatDelegate.b(activity, strArr, i2)) {
            HashSet hashSet = new HashSet();
            int i3 = 0;
            while (i3 < strArr.length) {
                if (!TextUtils.isEmpty(strArr[i3])) {
                    if (Build.VERSION.SDK_INT < 33 && TextUtils.equals(strArr[i3], "android.permission.POST_NOTIFICATIONS")) {
                        hashSet.add(Integer.valueOf(i3));
                    }
                    i3++;
                } else {
                    throw new IllegalArgumentException("Permission request for permissions " + Arrays.toString(strArr) + " must not contain null or empty values");
                }
            }
            int size = hashSet.size();
            final String[] strArr2 = size > 0 ? new String[(strArr.length - size)] : strArr;
            if (size > 0) {
                if (size != strArr.length) {
                    int i4 = 0;
                    for (int i5 = 0; i5 < strArr.length; i5++) {
                        if (!hashSet.contains(Integer.valueOf(i5))) {
                            strArr2[i4] = strArr[i5];
                            i4++;
                        }
                    }
                } else {
                    return;
                }
            }
            if (Build.VERSION.SDK_INT >= 23) {
                if (activity instanceof RequestPermissionsRequestCodeValidator) {
                    ((RequestPermissionsRequestCodeValidator) activity).d(i2);
                }
                Api23Impl.b(activity, strArr, i2);
            } else if (activity instanceof OnRequestPermissionsResultCallback) {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    public void run() {
                        int[] iArr = new int[strArr2.length];
                        PackageManager packageManager = activity.getPackageManager();
                        String packageName = activity.getPackageName();
                        int length = strArr2.length;
                        for (int i2 = 0; i2 < length; i2++) {
                            iArr[i2] = packageManager.checkPermission(strArr2[i2], packageName);
                        }
                        ((OnRequestPermissionsResultCallback) activity).onRequestPermissionsResult(i2, strArr2, iArr);
                    }
                });
            }
        }
    }

    @NonNull
    public static <T extends View> T O(@NonNull Activity activity, @IdRes int i2) {
        if (Build.VERSION.SDK_INT >= 28) {
            return (View) Api28Impl.a(activity, i2);
        }
        T findViewById = activity.findViewById(i2);
        if (findViewById != null) {
            return findViewById;
        }
        throw new IllegalArgumentException("ID does not reference a View inside this Activity");
    }

    public static void P(@NonNull Activity activity, @Nullable SharedElementCallback sharedElementCallback) {
        Api21Impl.c(activity, sharedElementCallback != null ? new SharedElementCallback21Impl(sharedElementCallback) : null);
    }

    public static void Q(@NonNull Activity activity, @Nullable SharedElementCallback sharedElementCallback) {
        Api21Impl.d(activity, sharedElementCallback != null ? new SharedElementCallback21Impl(sharedElementCallback) : null);
    }

    public static void R(@NonNull Activity activity, @Nullable LocusIdCompat locusIdCompat, @Nullable Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 30) {
            Api30Impl.b(activity, locusIdCompat, bundle);
        }
    }

    public static void S(@Nullable PermissionCompatDelegate permissionCompatDelegate) {
        f5209g = permissionCompatDelegate;
    }

    public static boolean T(@NonNull Activity activity, @NonNull String str) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 33 && TextUtils.equals("android.permission.POST_NOTIFICATIONS", str)) {
            return false;
        }
        if (i2 >= 32) {
            return Api32Impl.a(activity, str);
        }
        if (i2 == 31) {
            return Api31Impl.b(activity, str);
        }
        if (i2 >= 23) {
            return Api23Impl.c(activity, str);
        }
        return false;
    }

    public static void U(@NonNull Activity activity, @NonNull Intent intent, int i2, @Nullable Bundle bundle) {
        activity.startActivityForResult(intent, i2, bundle);
    }

    public static void V(@NonNull Activity activity, @NonNull IntentSender intentSender, int i2, @Nullable Intent intent, int i3, int i4, int i5, @Nullable Bundle bundle) throws IntentSender.SendIntentException {
        activity.startIntentSenderForResult(intentSender, i2, intent, i3, i4, i5, bundle);
    }

    public static void W(@NonNull Activity activity) {
        Api21Impl.e(activity);
    }
}
