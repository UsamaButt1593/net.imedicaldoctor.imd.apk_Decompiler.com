package com.bumptech.glide.load.model;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.util.Preconditions;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.util.Map;

public class GlideUrl implements Key {

    /* renamed from: j  reason: collision with root package name */
    private static final String f18136j = "@#&=*+-_.,:!?()/~'%;$";

    /* renamed from: c  reason: collision with root package name */
    private final Headers f18137c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private final URL f18138d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private final String f18139e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private String f18140f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private URL f18141g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private volatile byte[] f18142h;

    /* renamed from: i  reason: collision with root package name */
    private int f18143i;

    public GlideUrl(String str) {
        this(str, Headers.f18145b);
    }

    private byte[] d() {
        if (this.f18142h == null) {
            this.f18142h = c().getBytes(Key.f17830b);
        }
        return this.f18142h;
    }

    private String f() {
        if (TextUtils.isEmpty(this.f18140f)) {
            String str = this.f18139e;
            if (TextUtils.isEmpty(str)) {
                str = ((URL) Preconditions.d(this.f18138d)).toString();
            }
            this.f18140f = Uri.encode(str, f18136j);
        }
        return this.f18140f;
    }

    private URL g() throws MalformedURLException {
        if (this.f18141g == null) {
            this.f18141g = new URL(f());
        }
        return this.f18141g;
    }

    public void a(@NonNull MessageDigest messageDigest) {
        messageDigest.update(d());
    }

    public String c() {
        String str = this.f18139e;
        return str != null ? str : ((URL) Preconditions.d(this.f18138d)).toString();
    }

    public Map<String, String> e() {
        return this.f18137c.a();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof GlideUrl)) {
            return false;
        }
        GlideUrl glideUrl = (GlideUrl) obj;
        return c().equals(glideUrl.c()) && this.f18137c.equals(glideUrl.f18137c);
    }

    public String h() {
        return f();
    }

    public int hashCode() {
        if (this.f18143i == 0) {
            int hashCode = c().hashCode();
            this.f18143i = hashCode;
            this.f18143i = (hashCode * 31) + this.f18137c.hashCode();
        }
        return this.f18143i;
    }

    public URL i() throws MalformedURLException {
        return g();
    }

    public String toString() {
        return c();
    }

    public GlideUrl(String str, Headers headers) {
        this.f18138d = null;
        this.f18139e = Preconditions.b(str);
        this.f18137c = (Headers) Preconditions.d(headers);
    }

    public GlideUrl(URL url) {
        this(url, Headers.f18145b);
    }

    public GlideUrl(URL url, Headers headers) {
        this.f18138d = (URL) Preconditions.d(url);
        this.f18139e = null;
        this.f18137c = (Headers) Preconditions.d(headers);
    }
}
