package com.bumptech.glide.load.model;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.dd.plist.ASCIIPropertyListParser;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class LazyHeaders implements Headers {

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, List<LazyHeaderFactory>> f18146c;

    /* renamed from: d  reason: collision with root package name */
    private volatile Map<String, String> f18147d;

    public static final class Builder {

        /* renamed from: d  reason: collision with root package name */
        private static final String f18148d = "User-Agent";

        /* renamed from: e  reason: collision with root package name */
        private static final String f18149e;

        /* renamed from: f  reason: collision with root package name */
        private static final Map<String, List<LazyHeaderFactory>> f18150f;

        /* renamed from: a  reason: collision with root package name */
        private boolean f18151a = true;

        /* renamed from: b  reason: collision with root package name */
        private Map<String, List<LazyHeaderFactory>> f18152b = f18150f;

        /* renamed from: c  reason: collision with root package name */
        private boolean f18153c = true;

        static {
            String g2 = g();
            f18149e = g2;
            HashMap hashMap = new HashMap(2);
            if (!TextUtils.isEmpty(g2)) {
                hashMap.put("User-Agent", Collections.singletonList(new StringHeaderFactory(g2)));
            }
            f18150f = Collections.unmodifiableMap(hashMap);
        }

        private Map<String, List<LazyHeaderFactory>> d() {
            HashMap hashMap = new HashMap(this.f18152b.size());
            for (Map.Entry next : this.f18152b.entrySet()) {
                hashMap.put(next.getKey(), new ArrayList((Collection) next.getValue()));
            }
            return hashMap;
        }

        private void e() {
            if (this.f18151a) {
                this.f18151a = false;
                this.f18152b = d();
            }
        }

        private List<LazyHeaderFactory> f(String str) {
            List<LazyHeaderFactory> list = this.f18152b.get(str);
            if (list != null) {
                return list;
            }
            ArrayList arrayList = new ArrayList();
            this.f18152b.put(str, arrayList);
            return arrayList;
        }

        @VisibleForTesting
        static String g() {
            String property = System.getProperty("http.agent");
            if (TextUtils.isEmpty(property)) {
                return property;
            }
            int length = property.length();
            StringBuilder sb = new StringBuilder(property.length());
            for (int i2 = 0; i2 < length; i2++) {
                char charAt = property.charAt(i2);
                if ((charAt <= 31 && charAt != 9) || charAt >= 127) {
                    charAt = '?';
                }
                sb.append(charAt);
            }
            return sb.toString();
        }

        public Builder a(@NonNull String str, @NonNull LazyHeaderFactory lazyHeaderFactory) {
            if (this.f18153c && "User-Agent".equalsIgnoreCase(str)) {
                return h(str, lazyHeaderFactory);
            }
            e();
            f(str).add(lazyHeaderFactory);
            return this;
        }

        public Builder b(@NonNull String str, @NonNull String str2) {
            return a(str, new StringHeaderFactory(str2));
        }

        public LazyHeaders c() {
            this.f18151a = true;
            return new LazyHeaders(this.f18152b);
        }

        public Builder h(@NonNull String str, @Nullable LazyHeaderFactory lazyHeaderFactory) {
            e();
            if (lazyHeaderFactory == null) {
                this.f18152b.remove(str);
            } else {
                List<LazyHeaderFactory> f2 = f(str);
                f2.clear();
                f2.add(lazyHeaderFactory);
            }
            if (this.f18153c && "User-Agent".equalsIgnoreCase(str)) {
                this.f18153c = false;
            }
            return this;
        }

        public Builder i(@NonNull String str, @Nullable String str2) {
            return h(str, str2 == null ? null : new StringHeaderFactory(str2));
        }
    }

    static final class StringHeaderFactory implements LazyHeaderFactory {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        private final String f18154a;

        StringHeaderFactory(@NonNull String str) {
            this.f18154a = str;
        }

        public String a() {
            return this.f18154a;
        }

        public boolean equals(Object obj) {
            if (obj instanceof StringHeaderFactory) {
                return this.f18154a.equals(((StringHeaderFactory) obj).f18154a);
            }
            return false;
        }

        public int hashCode() {
            return this.f18154a.hashCode();
        }

        public String toString() {
            return "StringHeaderFactory{value='" + this.f18154a + '\'' + ASCIIPropertyListParser.f18653k;
        }
    }

    LazyHeaders(Map<String, List<LazyHeaderFactory>> map) {
        this.f18146c = Collections.unmodifiableMap(map);
    }

    @NonNull
    private String b(@NonNull List<LazyHeaderFactory> list) {
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            String a2 = list.get(i2).a();
            if (!TextUtils.isEmpty(a2)) {
                sb.append(a2);
                if (i2 != list.size() - 1) {
                    sb.append(ASCIIPropertyListParser.f18651i);
                }
            }
        }
        return sb.toString();
    }

    private Map<String, String> c() {
        HashMap hashMap = new HashMap();
        for (Map.Entry next : this.f18146c.entrySet()) {
            String b2 = b((List) next.getValue());
            if (!TextUtils.isEmpty(b2)) {
                hashMap.put(next.getKey(), b2);
            }
        }
        return hashMap;
    }

    public Map<String, String> a() {
        if (this.f18147d == null) {
            synchronized (this) {
                try {
                    if (this.f18147d == null) {
                        this.f18147d = Collections.unmodifiableMap(c());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return this.f18147d;
    }

    public boolean equals(Object obj) {
        if (obj instanceof LazyHeaders) {
            return this.f18146c.equals(((LazyHeaders) obj).f18146c);
        }
        return false;
    }

    public int hashCode() {
        return this.f18146c.hashCode();
    }

    public String toString() {
        return "LazyHeaders{headers=" + this.f18146c + ASCIIPropertyListParser.f18653k;
    }
}
