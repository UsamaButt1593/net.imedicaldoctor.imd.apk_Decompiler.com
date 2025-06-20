package androidx.legacy.content;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.util.Log;
import android.util.SparseArray;

@Deprecated
public abstract class WakefulBroadcastReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private static final String f8106a = "androidx.contentpager.content.wakelockid";

    /* renamed from: b  reason: collision with root package name */
    private static final SparseArray<PowerManager.WakeLock> f8107b = new SparseArray<>();

    /* renamed from: c  reason: collision with root package name */
    private static int f8108c = 1;

    public static boolean a(Intent intent) {
        int intExtra = intent.getIntExtra(f8106a, 0);
        if (intExtra == 0) {
            return false;
        }
        SparseArray<PowerManager.WakeLock> sparseArray = f8107b;
        synchronized (sparseArray) {
            try {
                PowerManager.WakeLock wakeLock = sparseArray.get(intExtra);
                if (wakeLock != null) {
                    wakeLock.release();
                    sparseArray.remove(intExtra);
                    return true;
                }
                Log.w("WakefulBroadcastReceiv.", "No active wake lock id #" + intExtra);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static ComponentName b(Context context, Intent intent) {
        SparseArray<PowerManager.WakeLock> sparseArray = f8107b;
        synchronized (sparseArray) {
            try {
                int i2 = f8108c;
                int i3 = i2 + 1;
                f8108c = i3;
                if (i3 <= 0) {
                    f8108c = 1;
                }
                intent.putExtra(f8106a, i2);
                ComponentName startService = context.startService(intent);
                if (startService == null) {
                    return null;
                }
                PowerManager.WakeLock newWakeLock = ((PowerManager) context.getSystemService("power")).newWakeLock(1, "androidx.core:wake:" + startService.flattenToShortString());
                newWakeLock.setReferenceCounted(false);
                newWakeLock.acquire(60000);
                sparseArray.put(i2, newWakeLock);
                return startService;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
