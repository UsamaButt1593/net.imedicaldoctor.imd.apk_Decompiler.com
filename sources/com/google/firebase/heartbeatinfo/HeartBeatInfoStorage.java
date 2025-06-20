package com.google.firebase.heartbeatinfo;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import java.text.SimpleDateFormat;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

class HeartBeatInfoStorage {

    /* renamed from: b  reason: collision with root package name */
    private static HeartBeatInfoStorage f24385b = null;

    /* renamed from: c  reason: collision with root package name */
    private static final String f24386c = "fire-global";

    /* renamed from: d  reason: collision with root package name */
    private static final String f24387d = "FirebaseAppHeartBeat";

    /* renamed from: e  reason: collision with root package name */
    private static final String f24388e = "FirebaseHeartBeat";

    /* renamed from: f  reason: collision with root package name */
    private static final String f24389f = "fire-count";

    /* renamed from: g  reason: collision with root package name */
    private static final String f24390g = "last-used-date";

    /* renamed from: h  reason: collision with root package name */
    private static final int f24391h = 30;

    /* renamed from: a  reason: collision with root package name */
    private final SharedPreferences f24392a;

    public HeartBeatInfoStorage(Context context, String str) {
        this.f24392a = context.getSharedPreferences(f24388e + str, 0);
    }

    private synchronized void a() {
        try {
            long j2 = this.f24392a.getLong(f24389f, 0);
            String str = "";
            String str2 = null;
            for (Map.Entry next : this.f24392a.getAll().entrySet()) {
                if (next.getValue() instanceof Set) {
                    for (String str3 : (Set) next.getValue()) {
                        if (str2 != null) {
                            if (str2.compareTo(str3) > 0) {
                            }
                        }
                        str = (String) next.getKey();
                        str2 = str3;
                    }
                }
            }
            HashSet hashSet = new HashSet(this.f24392a.getStringSet(str, new HashSet()));
            hashSet.remove(str2);
            this.f24392a.edit().putStringSet(str, hashSet).putLong(f24389f, j2 - 1).commit();
        } finally {
            while (true) {
            }
        }
    }

    private synchronized String d(long j2) {
        if (Build.VERSION.SDK_INT >= 26) {
            return new Date(j2).toInstant().atOffset(ZoneOffset.UTC).toLocalDateTime().format(DateTimeFormatter.ISO_LOCAL_DATE);
        }
        return new SimpleDateFormat("yyyy-MM-dd", Locale.UK).format(new Date(j2));
    }

    private synchronized String g(String str) {
        for (Map.Entry next : this.f24392a.getAll().entrySet()) {
            if (next.getValue() instanceof Set) {
                for (String equals : (Set) next.getValue()) {
                    if (str.equals(equals)) {
                        return (String) next.getKey();
                    }
                }
                continue;
            }
        }
        return null;
    }

    private synchronized void j(String str) {
        try {
            String g2 = g(str);
            if (g2 != null) {
                HashSet hashSet = new HashSet(this.f24392a.getStringSet(g2, new HashSet()));
                hashSet.remove(str);
                (hashSet.isEmpty() ? this.f24392a.edit().remove(g2) : this.f24392a.edit().putStringSet(g2, hashSet)).commit();
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
    }

    private synchronized void o(String str, String str2) {
        j(str2);
        HashSet hashSet = new HashSet(this.f24392a.getStringSet(str, new HashSet()));
        hashSet.add(str2);
        this.f24392a.edit().putStringSet(str, hashSet).commit();
    }

    /* access modifiers changed from: package-private */
    public synchronized void b() {
        try {
            SharedPreferences.Editor edit = this.f24392a.edit();
            int i2 = 0;
            for (Map.Entry next : this.f24392a.getAll().entrySet()) {
                if (next.getValue() instanceof Set) {
                    String d2 = d(System.currentTimeMillis());
                    String str = (String) next.getKey();
                    if (((Set) next.getValue()).contains(d2)) {
                        HashSet hashSet = new HashSet();
                        hashSet.add(d2);
                        i2++;
                        edit.putStringSet(str, hashSet);
                    } else {
                        edit.remove(str);
                    }
                }
            }
            if (i2 == 0) {
                edit.remove(f24389f);
            } else {
                edit.putLong(f24389f, (long) i2);
            }
            edit.commit();
        } finally {
            while (true) {
            }
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized List<HeartBeatResult> c() {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList();
            for (Map.Entry next : this.f24392a.getAll().entrySet()) {
                if (next.getValue() instanceof Set) {
                    HashSet hashSet = new HashSet((Set) next.getValue());
                    hashSet.remove(d(System.currentTimeMillis()));
                    if (!hashSet.isEmpty()) {
                        arrayList.add(HeartBeatResult.a((String) next.getKey(), new ArrayList(hashSet)));
                    }
                }
            }
            n(System.currentTimeMillis());
        } finally {
            while (true) {
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    @RestrictTo({RestrictTo.Scope.TESTS})
    public int e() {
        return (int) this.f24392a.getLong(f24389f, 0);
    }

    /* access modifiers changed from: package-private */
    public synchronized long f() {
        return this.f24392a.getLong(f24386c, -1);
    }

    /* access modifiers changed from: package-private */
    public synchronized boolean h(long j2, long j3) {
        return d(j2).equals(d(j3));
    }

    /* access modifiers changed from: package-private */
    public synchronized void i() {
        String d2 = d(System.currentTimeMillis());
        this.f24392a.edit().putString(f24390g, d2).commit();
        j(d2);
    }

    /* access modifiers changed from: package-private */
    public synchronized boolean k(long j2) {
        return l(f24386c, j2);
    }

    /* access modifiers changed from: package-private */
    public synchronized boolean l(String str, long j2) {
        if (!this.f24392a.contains(str)) {
            this.f24392a.edit().putLong(str, j2).commit();
            return true;
        } else if (h(this.f24392a.getLong(str, -1), j2)) {
            return false;
        } else {
            this.f24392a.edit().putLong(str, j2).commit();
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized void m(long j2, String str) {
        String d2 = d(j2);
        if (this.f24392a.getString(f24390g, "").equals(d2)) {
            String g2 = g(d2);
            if (g2 != null) {
                if (!g2.equals(str)) {
                    o(str, d2);
                    return;
                }
                return;
            }
            return;
        }
        long j3 = this.f24392a.getLong(f24389f, 0);
        if (j3 + 1 == 30) {
            a();
            j3 = this.f24392a.getLong(f24389f, 0);
        }
        HashSet hashSet = new HashSet(this.f24392a.getStringSet(str, new HashSet()));
        hashSet.add(d2);
        this.f24392a.edit().putStringSet(str, hashSet).putLong(f24389f, j3 + 1).putString(f24390g, d2).commit();
    }

    /* access modifiers changed from: package-private */
    public synchronized void n(long j2) {
        this.f24392a.edit().putLong(f24386c, j2).commit();
    }

    @VisibleForTesting
    @RestrictTo({RestrictTo.Scope.TESTS})
    HeartBeatInfoStorage(SharedPreferences sharedPreferences) {
        this.f24392a = sharedPreferences;
    }
}
