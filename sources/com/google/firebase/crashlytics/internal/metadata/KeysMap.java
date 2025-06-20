package com.google.firebase.crashlytics.internal.metadata;

import androidx.annotation.NonNull;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class KeysMap {

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, String> f23708a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private final int f23709b;

    /* renamed from: c  reason: collision with root package name */
    private final int f23710c;

    public KeysMap(int i2, int i3) {
        this.f23709b = i2;
        this.f23710c = i3;
    }

    private String b(String str) {
        if (str != null) {
            return c(str, this.f23710c);
        }
        throw new IllegalArgumentException("Custom attribute key must not be null.");
    }

    public static String c(String str, int i2) {
        if (str == null) {
            return str;
        }
        String trim = str.trim();
        return trim.length() > i2 ? trim.substring(0, i2) : trim;
    }

    @NonNull
    public synchronized Map<String, String> a() {
        return Collections.unmodifiableMap(new HashMap(this.f23708a));
    }

    public synchronized boolean d(String str, String str2) {
        String b2 = b(str);
        if (this.f23708a.size() >= this.f23709b) {
            if (!this.f23708a.containsKey(b2)) {
                Logger f2 = Logger.f();
                f2.m("Ignored entry \"" + str + "\" when adding custom keys. Maximum allowable: " + this.f23709b);
                return false;
            }
        }
        String c2 = c(str2, this.f23710c);
        if (CommonUtils.A(this.f23708a.get(b2), c2)) {
            return false;
        }
        Map<String, String> map = this.f23708a;
        if (str2 == null) {
            c2 = "";
        }
        map.put(b2, c2);
        return true;
    }

    public synchronized void e(Map<String, String> map) {
        try {
            int i2 = 0;
            for (Map.Entry next : map.entrySet()) {
                String b2 = b((String) next.getKey());
                if (this.f23708a.size() >= this.f23709b) {
                    if (!this.f23708a.containsKey(b2)) {
                        i2++;
                    }
                }
                String str = (String) next.getValue();
                this.f23708a.put(b2, str == null ? "" : c(str, this.f23710c));
            }
            if (i2 > 0) {
                Logger f2 = Logger.f();
                f2.m("Ignored " + i2 + " entries when adding custom keys. Maximum allowable: " + this.f23709b);
            }
        } finally {
            while (true) {
            }
        }
    }
}
