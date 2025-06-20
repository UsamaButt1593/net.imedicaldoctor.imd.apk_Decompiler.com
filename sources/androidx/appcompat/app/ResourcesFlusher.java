package androidx.appcompat.app;

import android.content.res.Resources;
import android.os.Build;
import android.util.Log;
import android.util.LongSparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.lang.reflect.Field;
import java.util.Map;

class ResourcesFlusher {

    /* renamed from: a  reason: collision with root package name */
    private static final String f2796a = "ResourcesFlusher";

    /* renamed from: b  reason: collision with root package name */
    private static Field f2797b;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f2798c;

    /* renamed from: d  reason: collision with root package name */
    private static Class<?> f2799d;

    /* renamed from: e  reason: collision with root package name */
    private static boolean f2800e;

    /* renamed from: f  reason: collision with root package name */
    private static Field f2801f;

    /* renamed from: g  reason: collision with root package name */
    private static boolean f2802g;

    /* renamed from: h  reason: collision with root package name */
    private static Field f2803h;

    /* renamed from: i  reason: collision with root package name */
    private static boolean f2804i;

    private ResourcesFlusher() {
    }

    static void a(@NonNull Resources resources) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 28) {
            if (i2 >= 24) {
                d(resources);
            } else if (i2 >= 23) {
                c(resources);
            } else {
                b(resources);
            }
        }
    }

    @RequiresApi(21)
    private static void b(@NonNull Resources resources) {
        Map map;
        if (!f2798c) {
            try {
                Field declaredField = Resources.class.getDeclaredField("mDrawableCache");
                f2797b = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e2) {
                Log.e(f2796a, "Could not retrieve Resources#mDrawableCache field", e2);
            }
            f2798c = true;
        }
        Field field = f2797b;
        if (field != null) {
            try {
                map = (Map) field.get(resources);
            } catch (IllegalAccessException e3) {
                Log.e(f2796a, "Could not retrieve value from Resources#mDrawableCache", e3);
                map = null;
            }
            if (map != null) {
                map.clear();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x002f A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0030  */
    @androidx.annotation.RequiresApi(23)
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void c(@androidx.annotation.NonNull android.content.res.Resources r4) {
        /*
            boolean r0 = f2798c
            java.lang.String r1 = "ResourcesFlusher"
            if (r0 != 0) goto L_0x001d
            r0 = 1
            java.lang.Class<android.content.res.Resources> r2 = android.content.res.Resources.class
            java.lang.String r3 = "mDrawableCache"
            java.lang.reflect.Field r2 = r2.getDeclaredField(r3)     // Catch:{ NoSuchFieldException -> 0x0015 }
            f2797b = r2     // Catch:{ NoSuchFieldException -> 0x0015 }
            r2.setAccessible(r0)     // Catch:{ NoSuchFieldException -> 0x0015 }
            goto L_0x001b
        L_0x0015:
            r2 = move-exception
            java.lang.String r3 = "Could not retrieve Resources#mDrawableCache field"
            android.util.Log.e(r1, r3, r2)
        L_0x001b:
            f2798c = r0
        L_0x001d:
            java.lang.reflect.Field r0 = f2797b
            if (r0 == 0) goto L_0x002c
            java.lang.Object r4 = r0.get(r4)     // Catch:{ IllegalAccessException -> 0x0026 }
            goto L_0x002d
        L_0x0026:
            r4 = move-exception
            java.lang.String r0 = "Could not retrieve value from Resources#mDrawableCache"
            android.util.Log.e(r1, r0, r4)
        L_0x002c:
            r4 = 0
        L_0x002d:
            if (r4 != 0) goto L_0x0030
            return
        L_0x0030:
            e(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.ResourcesFlusher.c(android.content.res.Resources):void");
    }

    @RequiresApi(24)
    private static void d(@NonNull Resources resources) {
        Object obj;
        if (!f2804i) {
            try {
                Field declaredField = Resources.class.getDeclaredField("mResourcesImpl");
                f2803h = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e2) {
                Log.e(f2796a, "Could not retrieve Resources#mResourcesImpl field", e2);
            }
            f2804i = true;
        }
        Field field = f2803h;
        if (field != null) {
            Object obj2 = null;
            try {
                obj = field.get(resources);
            } catch (IllegalAccessException e3) {
                Log.e(f2796a, "Could not retrieve value from Resources#mResourcesImpl", e3);
                obj = null;
            }
            if (obj != null) {
                if (!f2798c) {
                    try {
                        Field declaredField2 = obj.getClass().getDeclaredField("mDrawableCache");
                        f2797b = declaredField2;
                        declaredField2.setAccessible(true);
                    } catch (NoSuchFieldException e4) {
                        Log.e(f2796a, "Could not retrieve ResourcesImpl#mDrawableCache field", e4);
                    }
                    f2798c = true;
                }
                Field field2 = f2797b;
                if (field2 != null) {
                    try {
                        obj2 = field2.get(obj);
                    } catch (IllegalAccessException e5) {
                        Log.e(f2796a, "Could not retrieve value from ResourcesImpl#mDrawableCache", e5);
                    }
                }
                if (obj2 != null) {
                    e(obj2);
                }
            }
        }
    }

    private static void e(@NonNull Object obj) {
        LongSparseArray longSparseArray;
        if (!f2800e) {
            try {
                f2799d = Class.forName("android.content.res.ThemedResourceCache");
            } catch (ClassNotFoundException e2) {
                Log.e(f2796a, "Could not find ThemedResourceCache class", e2);
            }
            f2800e = true;
        }
        Class<?> cls = f2799d;
        if (cls != null) {
            if (!f2802g) {
                try {
                    Field declaredField = cls.getDeclaredField("mUnthemedEntries");
                    f2801f = declaredField;
                    declaredField.setAccessible(true);
                } catch (NoSuchFieldException e3) {
                    Log.e(f2796a, "Could not retrieve ThemedResourceCache#mUnthemedEntries field", e3);
                }
                f2802g = true;
            }
            Field field = f2801f;
            if (field != null) {
                try {
                    longSparseArray = (LongSparseArray) field.get(obj);
                } catch (IllegalAccessException e4) {
                    Log.e(f2796a, "Could not retrieve value from ThemedResourceCache#mUnthemedEntries", e4);
                    longSparseArray = null;
                }
                if (longSparseArray != null) {
                    longSparseArray.clear();
                }
            }
        }
    }
}
