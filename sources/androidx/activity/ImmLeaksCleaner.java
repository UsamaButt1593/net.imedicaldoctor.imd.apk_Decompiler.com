package androidx.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.inputmethod.InputMethodManager;
import androidx.annotation.MainThread;
import androidx.annotation.RequiresApi;
import androidx.lifecycle.LifecycleEventObserver;
import java.lang.reflect.Field;

@RequiresApi(19)
final class ImmLeaksCleaner implements LifecycleEventObserver {
    private static final int X = 0;
    private static int X2 = 0;
    private static final int Y = 1;
    private static Field Y2 = null;
    private static final int Z = 2;
    private static Field Z2;
    private static Field a3;
    private Activity s;

    ImmLeaksCleaner(Activity activity) {
        this.s = activity;
    }

    @SuppressLint({"SoonBlockedPrivateApi"})
    @MainThread
    private static void a() {
        Class<InputMethodManager> cls = InputMethodManager.class;
        try {
            X2 = 2;
            Field declaredField = cls.getDeclaredField("mServedView");
            Z2 = declaredField;
            declaredField.setAccessible(true);
            Field declaredField2 = cls.getDeclaredField("mNextServedView");
            a3 = declaredField2;
            declaredField2.setAccessible(true);
            Field declaredField3 = cls.getDeclaredField("mH");
            Y2 = declaredField3;
            declaredField3.setAccessible(true);
            X2 = 1;
        } catch (NoSuchFieldException unused) {
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:31|32|33) */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0047, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0046 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void d(@androidx.annotation.NonNull androidx.lifecycle.LifecycleOwner r3, @androidx.annotation.NonNull androidx.lifecycle.Lifecycle.Event r4) {
        /*
            r2 = this;
            androidx.lifecycle.Lifecycle$Event r3 = androidx.lifecycle.Lifecycle.Event.ON_DESTROY
            if (r4 == r3) goto L_0x0005
            return
        L_0x0005:
            int r3 = X2
            if (r3 != 0) goto L_0x000c
            a()
        L_0x000c:
            int r3 = X2
            r4 = 1
            if (r3 != r4) goto L_0x004e
            android.app.Activity r3 = r2.s
            java.lang.String r4 = "input_method"
            java.lang.Object r3 = r3.getSystemService(r4)
            android.view.inputmethod.InputMethodManager r3 = (android.view.inputmethod.InputMethodManager) r3
            java.lang.reflect.Field r4 = Y2     // Catch:{ IllegalAccessException -> 0x004e }
            java.lang.Object r4 = r4.get(r3)     // Catch:{ IllegalAccessException -> 0x004e }
            if (r4 != 0) goto L_0x0024
            return
        L_0x0024:
            monitor-enter(r4)
            java.lang.reflect.Field r0 = Z2     // Catch:{ IllegalAccessException -> 0x004a, ClassCastException -> 0x0048 }
            java.lang.Object r0 = r0.get(r3)     // Catch:{ IllegalAccessException -> 0x004a, ClassCastException -> 0x0048 }
            android.view.View r0 = (android.view.View) r0     // Catch:{ IllegalAccessException -> 0x004a, ClassCastException -> 0x0048 }
            if (r0 != 0) goto L_0x0033
            monitor-exit(r4)     // Catch:{ all -> 0x0031 }
            return
        L_0x0031:
            r3 = move-exception
            goto L_0x004c
        L_0x0033:
            boolean r0 = r0.isAttachedToWindow()     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x003b
            monitor-exit(r4)     // Catch:{ all -> 0x0031 }
            return
        L_0x003b:
            java.lang.reflect.Field r0 = a3     // Catch:{ IllegalAccessException -> 0x0046 }
            r1 = 0
            r0.set(r3, r1)     // Catch:{ IllegalAccessException -> 0x0046 }
            monitor-exit(r4)     // Catch:{ all -> 0x0031 }
            r3.isActive()
            goto L_0x004e
        L_0x0046:
            monitor-exit(r4)     // Catch:{ all -> 0x0031 }
            return
        L_0x0048:
            monitor-exit(r4)     // Catch:{ all -> 0x0031 }
            return
        L_0x004a:
            monitor-exit(r4)     // Catch:{ all -> 0x0031 }
            return
        L_0x004c:
            monitor-exit(r4)     // Catch:{ all -> 0x0031 }
            throw r3
        L_0x004e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.activity.ImmLeaksCleaner.d(androidx.lifecycle.LifecycleOwner, androidx.lifecycle.Lifecycle$Event):void");
    }
}
