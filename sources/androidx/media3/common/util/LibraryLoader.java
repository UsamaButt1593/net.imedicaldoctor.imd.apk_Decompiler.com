package androidx.media3.common.util;

import java.util.Arrays;

@UnstableApi
public abstract class LibraryLoader {

    /* renamed from: d  reason: collision with root package name */
    private static final String f9553d = "LibraryLoader";

    /* renamed from: a  reason: collision with root package name */
    private String[] f9554a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f9555b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f9556c;

    public LibraryLoader(String... strArr) {
        this.f9554a = strArr;
    }

    public synchronized boolean a() {
        if (this.f9555b) {
            return this.f9556c;
        }
        this.f9555b = true;
        try {
            for (String b2 : this.f9554a) {
                b(b2);
            }
            this.f9556c = true;
        } catch (UnsatisfiedLinkError unused) {
            Log.n(f9553d, "Failed to load " + Arrays.toString(this.f9554a));
        }
        return this.f9556c;
    }

    /* access modifiers changed from: protected */
    public abstract void b(String str);

    public synchronized void c(String... strArr) {
        Assertions.j(!this.f9555b, "Cannot set libraries after loading");
        this.f9554a = strArr;
    }
}
