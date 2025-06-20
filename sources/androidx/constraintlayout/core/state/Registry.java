package androidx.constraintlayout.core.state;

import java.util.HashMap;
import java.util.Set;

public class Registry {

    /* renamed from: b  reason: collision with root package name */
    private static final Registry f4100b = new Registry();

    /* renamed from: a  reason: collision with root package name */
    private HashMap<String, RegistryCallback> f4101a = new HashMap<>();

    public static Registry c() {
        return f4100b;
    }

    public String a(String str) {
        RegistryCallback registryCallback = this.f4101a.get(str);
        if (registryCallback != null) {
            return registryCallback.b();
        }
        return null;
    }

    public String b(String str) {
        RegistryCallback registryCallback = this.f4101a.get(str);
        if (registryCallback != null) {
            return registryCallback.g();
        }
        return null;
    }

    public long d(String str) {
        RegistryCallback registryCallback = this.f4101a.get(str);
        if (registryCallback != null) {
            return registryCallback.h();
        }
        return Long.MAX_VALUE;
    }

    public Set<String> e() {
        return this.f4101a.keySet();
    }

    public void f(String str, RegistryCallback registryCallback) {
        this.f4101a.put(str, registryCallback);
    }

    public void g(String str, int i2) {
        RegistryCallback registryCallback = this.f4101a.get(str);
        if (registryCallback != null) {
            registryCallback.c(i2);
        }
    }

    public void h(String str, int i2) {
        RegistryCallback registryCallback = this.f4101a.get(str);
        if (registryCallback != null) {
            registryCallback.d(i2);
        }
    }

    public void i(String str, RegistryCallback registryCallback) {
        this.f4101a.remove(str);
    }

    public void j(String str, String str2) {
        RegistryCallback registryCallback = this.f4101a.get(str);
        if (registryCallback != null) {
            registryCallback.a(str2);
        }
    }

    public void k(String str, int i2, int i3) {
        RegistryCallback registryCallback = this.f4101a.get(str);
        if (registryCallback != null) {
            registryCallback.f(i2, i3);
        }
    }

    public void l(String str, float f2) {
        RegistryCallback registryCallback = this.f4101a.get(str);
        if (registryCallback != null) {
            registryCallback.e(f2);
        }
    }
}
