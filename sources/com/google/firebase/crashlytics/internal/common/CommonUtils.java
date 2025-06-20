package com.google.firebase.crashlytics.internal.common;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Debug;
import android.os.StatFs;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.firebase.crashlytics.internal.Logger;
import com.itextpdf.text.pdf.Barcode128;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class CommonUtils {

    /* renamed from: a  reason: collision with root package name */
    private static final String f23555a = "SHA-1";

    /* renamed from: b  reason: collision with root package name */
    private static final String f23556b = "goldfish";

    /* renamed from: c  reason: collision with root package name */
    private static final String f23557c = "ranchu";

    /* renamed from: d  reason: collision with root package name */
    private static final String f23558d = "sdk";

    /* renamed from: e  reason: collision with root package name */
    public static final String f23559e = "com.google.firebase.crashlytics";

    /* renamed from: f  reason: collision with root package name */
    public static final String f23560f = "com.crashlytics.prefs";

    /* renamed from: g  reason: collision with root package name */
    private static final char[] f23561g = {'0', '1', PdfWriter.p4, PdfWriter.q4, PdfWriter.r4, PdfWriter.s4, PdfWriter.t4, PdfWriter.u4, '8', '9', 'a', 'b', Barcode128.F, Barcode128.G, Barcode128.H, Barcode128.I};

    /* renamed from: h  reason: collision with root package name */
    static final String f23562h = "com.google.firebase.crashlytics.mapping_file_id";

    /* renamed from: i  reason: collision with root package name */
    static final String f23563i = "com.crashlytics.android.build_id";

    /* renamed from: j  reason: collision with root package name */
    static final String f23564j = "com.google.firebase.crashlytics.build_ids_lib";

    /* renamed from: k  reason: collision with root package name */
    static final String f23565k = "com.google.firebase.crashlytics.build_ids_arch";

    /* renamed from: l  reason: collision with root package name */
    static final String f23566l = "com.google.firebase.crashlytics.build_ids_build_id";

    /* renamed from: m  reason: collision with root package name */
    public static final int f23567m = 1;

    /* renamed from: n  reason: collision with root package name */
    public static final int f23568n = 2;
    public static final int o = 4;
    public static final int p = 8;
    public static final int q = 16;
    public static final int r = 32;

    enum Architecture {
        X86_32,
        X86_64,
        ARM_UNKNOWN,
        PPC,
        PPC64,
        ARMV6,
        ARMV7,
        UNKNOWN,
        ARMV7S,
        ARM64;
        
        private static final Map<String, Architecture> d3 = null;

        static {
            Architecture architecture;
            Architecture architecture2;
            Architecture architecture3;
            Architecture architecture4;
            HashMap hashMap = new HashMap(4);
            d3 = hashMap;
            hashMap.put("armeabi-v7a", architecture3);
            hashMap.put("armeabi", architecture2);
            hashMap.put("arm64-v8a", architecture4);
            hashMap.put("x86", architecture);
        }

        static Architecture b() {
            String str = Build.CPU_ABI;
            if (TextUtils.isEmpty(str)) {
                Logger.f().k("Architecture#getValue()::Build.CPU_ABI returned null or empty");
                return UNKNOWN;
            }
            Architecture architecture = d3.get(str.toLowerCase(Locale.US));
            return architecture == null ? UNKNOWN : architecture;
        }
    }

    public static boolean A(@Nullable String str, @Nullable String str2) {
        if (str == null) {
            return str2 == null;
        }
        return str.equals(str2);
    }

    public static String B(int i2) {
        if (i2 >= 0) {
            return String.format(Locale.US, "%1$10s", new Object[]{Integer.valueOf(i2)}).replace(' ', '0');
        }
        throw new IllegalArgumentException("value must be zero or greater");
    }

    public static String C(String str) {
        return s(str, "SHA-1");
    }

    public static String D(InputStream inputStream) {
        Scanner useDelimiter = new Scanner(inputStream).useDelimiter("\\A");
        return useDelimiter.hasNext() ? useDelimiter.next() : "";
    }

    public static long a(Context context) {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
        return memoryInfo.availMem;
    }

    public static synchronized long b(Context context) {
        long j2;
        synchronized (CommonUtils.class) {
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
            j2 = memoryInfo.totalMem;
        }
        return j2;
    }

    public static long c(String str) {
        StatFs statFs = new StatFs(str);
        long blockSize = (long) statFs.getBlockSize();
        return (((long) statFs.getBlockCount()) * blockSize) - (blockSize * ((long) statFs.getAvailableBlocks()));
    }

    @SuppressLint({"MissingPermission"})
    public static boolean d(Context context) {
        if (!e(context, "android.permission.ACCESS_NETWORK_STATE")) {
            return true;
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }

    public static boolean e(Context context, String str) {
        return context.checkCallingOrSelfPermission(str) == 0;
    }

    public static void f(Closeable closeable, String str) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e2) {
                Logger.f().e(str, e2);
            }
        }
    }

    public static void g(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception unused) {
            }
        }
    }

    public static String h(String... strArr) {
        if (strArr == null || strArr.length == 0) {
            return null;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        for (String str : strArr) {
            if (str != null) {
                arrayList.add(str.replace("-", "").toLowerCase(Locale.US));
            }
        }
        Collections.sort(arrayList);
        StringBuilder sb = new StringBuilder();
        for (String append : arrayList) {
            sb.append(append);
        }
        String sb2 = sb.toString();
        if (sb2.length() > 0) {
            return C(sb2);
        }
        return null;
    }

    public static boolean i(Context context, String str, boolean z) {
        Resources resources;
        if (!(context == null || (resources = context.getResources()) == null)) {
            int q2 = q(context, str, "bool");
            if (q2 > 0) {
                return resources.getBoolean(q2);
            }
            int q3 = q(context, str, TypedValues.Custom.f3952e);
            if (q3 > 0) {
                return Boolean.parseBoolean(context.getString(q3));
            }
        }
        return z;
    }

    public static List<BuildIdInfo> j(Context context) {
        ArrayList arrayList = new ArrayList();
        int q2 = q(context, f23564j, "array");
        int q3 = q(context, f23565k, "array");
        int q4 = q(context, f23566l, "array");
        if (q2 == 0 || q3 == 0 || q4 == 0) {
            Logger.f().b(String.format("Could not find resources: %d %d %d", new Object[]{Integer.valueOf(q2), Integer.valueOf(q3), Integer.valueOf(q4)}));
            return arrayList;
        }
        String[] stringArray = context.getResources().getStringArray(q2);
        String[] stringArray2 = context.getResources().getStringArray(q3);
        String[] stringArray3 = context.getResources().getStringArray(q4);
        if (stringArray.length == stringArray3.length && stringArray2.length == stringArray3.length) {
            for (int i2 = 0; i2 < stringArray3.length; i2++) {
                arrayList.add(new BuildIdInfo(stringArray[i2], stringArray2[i2], stringArray3[i2]));
            }
            return arrayList;
        }
        Logger.f().b(String.format("Lengths did not match: %d %d %d", new Object[]{Integer.valueOf(stringArray.length), Integer.valueOf(stringArray2.length), Integer.valueOf(stringArray3.length)}));
        return arrayList;
    }

    public static int k() {
        return Architecture.b().ordinal();
    }

    public static int l() {
        boolean x = x();
        if (z()) {
            x |= true;
        }
        return w() ? x | true ? 1 : 0 : x ? 1 : 0;
    }

    public static SharedPreferences m(Context context) {
        return context.getSharedPreferences(f23560f, 0);
    }

    public static String n(Context context) {
        int q2 = q(context, f23562h, TypedValues.Custom.f3952e);
        if (q2 == 0) {
            q2 = q(context, f23563i, TypedValues.Custom.f3952e);
        }
        if (q2 != 0) {
            return context.getResources().getString(q2);
        }
        return null;
    }

    public static boolean o(Context context) {
        return !x() && ((SensorManager) context.getSystemService("sensor")).getDefaultSensor(8) != null;
    }

    public static String p(Context context) {
        int i2 = context.getApplicationContext().getApplicationInfo().icon;
        if (i2 > 0) {
            try {
                String resourcePackageName = context.getResources().getResourcePackageName(i2);
                return "android".equals(resourcePackageName) ? context.getPackageName() : resourcePackageName;
            } catch (Resources.NotFoundException unused) {
            }
        }
        return context.getPackageName();
    }

    public static int q(Context context, String str, String str2) {
        return context.getResources().getIdentifier(str, str2, p(context));
    }

    public static SharedPreferences r(Context context) {
        return context.getSharedPreferences("com.google.firebase.crashlytics", 0);
    }

    private static String s(String str, String str2) {
        return t(str.getBytes(), str2);
    }

    private static String t(byte[] bArr, String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance(str);
            instance.update(bArr);
            return u(instance.digest());
        } catch (NoSuchAlgorithmException e2) {
            Logger f2 = Logger.f();
            f2.e("Could not create hashing algorithm: " + str + ", returning empty string.", e2);
            return "";
        }
    }

    public static String u(byte[] bArr) {
        char[] cArr = new char[(bArr.length * 2)];
        for (int i2 = 0; i2 < bArr.length; i2++) {
            byte b2 = bArr[i2];
            int i3 = i2 * 2;
            char[] cArr2 = f23561g;
            cArr[i3] = cArr2[(b2 & 255) >>> 4];
            cArr[i3 + 1] = cArr2[b2 & 15];
        }
        return new String(cArr);
    }

    public static boolean v(Context context) {
        return (context.getApplicationInfo().flags & 2) != 0;
    }

    public static boolean w() {
        return Debug.isDebuggerConnected() || Debug.waitingForDebugger();
    }

    public static boolean x() {
        if (!Build.PRODUCT.contains(f23558d)) {
            String str = Build.HARDWARE;
            return str.contains(f23556b) || str.contains(f23557c);
        }
    }

    @Deprecated
    public static boolean y(Context context) {
        return false;
    }

    public static boolean z() {
        boolean x = x();
        String str = Build.TAGS;
        if ((!x && str != null && str.contains("test-keys")) || new File("/system/app/Superuser.apk").exists()) {
            return true;
        }
        return !x && new File("/system/xbin/su").exists();
    }
}
