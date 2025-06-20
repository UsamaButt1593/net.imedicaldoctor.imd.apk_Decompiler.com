package androidx.core.app;

import android.app.Activity;
import android.app.Application;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

@RestrictTo({RestrictTo.Scope.LIBRARY})
final class ActivityRecreator {

    /* renamed from: a  reason: collision with root package name */
    private static final String f5214a = "ActivityRecreator";

    /* renamed from: b  reason: collision with root package name */
    protected static final Class<?> f5215b;

    /* renamed from: c  reason: collision with root package name */
    protected static final Field f5216c = b();

    /* renamed from: d  reason: collision with root package name */
    protected static final Field f5217d = f();

    /* renamed from: e  reason: collision with root package name */
    protected static final Method f5218e;

    /* renamed from: f  reason: collision with root package name */
    protected static final Method f5219f;

    /* renamed from: g  reason: collision with root package name */
    protected static final Method f5220g;

    /* renamed from: h  reason: collision with root package name */
    private static final Handler f5221h = new Handler(Looper.getMainLooper());

    private static final class LifecycleCheckCallbacks implements Application.ActivityLifecycleCallbacks {
        private Activity X;
        private boolean X2 = false;
        private final int Y;
        private boolean Y2 = false;
        private boolean Z = false;
        Object s;

        LifecycleCheckCallbacks(@NonNull Activity activity) {
            this.X = activity;
            this.Y = activity.hashCode();
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public void onActivityDestroyed(Activity activity) {
            if (this.X == activity) {
                this.X = null;
                this.X2 = true;
            }
        }

        public void onActivityPaused(Activity activity) {
            if (this.X2 && !this.Y2 && !this.Z && ActivityRecreator.h(this.s, this.Y, activity)) {
                this.Y2 = true;
                this.s = null;
            }
        }

        public void onActivityResumed(Activity activity) {
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
            if (this.X == activity) {
                this.Z = true;
            }
        }

        public void onActivityStopped(Activity activity) {
        }
    }

    static {
        Class<?> a2 = a();
        f5215b = a2;
        f5218e = d(a2);
        f5219f = c(a2);
        f5220g = e(a2);
    }

    private ActivityRecreator() {
    }

    private static Class<?> a() {
        try {
            return Class.forName("android.app.ActivityThread");
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Field b() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mMainThread");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Method c(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        try {
            Method declaredMethod = cls.getDeclaredMethod("performStopActivity", new Class[]{IBinder.class, Boolean.TYPE});
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Method d(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        try {
            Method declaredMethod = cls.getDeclaredMethod("performStopActivity", new Class[]{IBinder.class, Boolean.TYPE, String.class});
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Method e(Class<?> cls) {
        if (g() && cls != null) {
            try {
                Class<List> cls2 = List.class;
                Class cls3 = Boolean.TYPE;
                Class<Configuration> cls4 = Configuration.class;
                Method declaredMethod = cls.getDeclaredMethod("requestRelaunchActivity", new Class[]{IBinder.class, cls2, cls2, Integer.TYPE, cls3, cls4, cls4, cls3, cls3});
                declaredMethod.setAccessible(true);
                return declaredMethod;
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    private static Field f() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mToken");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean g() {
        int i2 = Build.VERSION.SDK_INT;
        return i2 == 26 || i2 == 27;
    }

    protected static boolean h(Object obj, int i2, Activity activity) {
        try {
            final Object obj2 = f5217d.get(activity);
            if (obj2 == obj) {
                if (activity.hashCode() == i2) {
                    final Object obj3 = f5216c.get(activity);
                    f5221h.postAtFrontOfQueue(new Runnable() {
                        public void run() {
                            try {
                                Method method = ActivityRecreator.f5218e;
                                if (method != null) {
                                    method.invoke(obj3, new Object[]{obj2, Boolean.FALSE, "AppCompat recreation"});
                                    return;
                                }
                                ActivityRecreator.f5219f.invoke(obj3, new Object[]{obj2, Boolean.FALSE});
                            } catch (RuntimeException e2) {
                                if (e2.getClass() == RuntimeException.class && e2.getMessage() != null && e2.getMessage().startsWith("Unable to stop")) {
                                    throw e2;
                                }
                            } catch (Throwable th) {
                                Log.e(ActivityRecreator.f5214a, "Exception while invoking performStopActivity", th);
                            }
                        }
                    });
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            Log.e(f5214a, "Exception while fetching field values", th);
            return false;
        }
    }

    static boolean i(@NonNull Activity activity) {
        Object obj;
        final Application application;
        final LifecycleCheckCallbacks lifecycleCheckCallbacks;
        if (Build.VERSION.SDK_INT >= 28) {
            activity.recreate();
            return true;
        } else if (g() && f5220g == null) {
            return false;
        } else {
            if (f5219f == null && f5218e == null) {
                return false;
            }
            try {
                final Object obj2 = f5217d.get(activity);
                if (obj2 == null || (obj = f5216c.get(activity)) == null) {
                    return false;
                }
                application = activity.getApplication();
                lifecycleCheckCallbacks = new LifecycleCheckCallbacks(activity);
                application.registerActivityLifecycleCallbacks(lifecycleCheckCallbacks);
                Handler handler = f5221h;
                handler.post(new Runnable() {
                    public void run() {
                        LifecycleCheckCallbacks.this.s = obj2;
                    }
                });
                if (g()) {
                    Method method = f5220g;
                    Boolean bool = Boolean.FALSE;
                    method.invoke(obj, new Object[]{obj2, null, null, 0, bool, null, null, bool, bool});
                } else {
                    activity.recreate();
                }
                handler.post(new Runnable() {
                    public void run() {
                        application.unregisterActivityLifecycleCallbacks(lifecycleCheckCallbacks);
                    }
                });
                return true;
            } catch (Throwable unused) {
                return false;
            }
        }
    }
}
