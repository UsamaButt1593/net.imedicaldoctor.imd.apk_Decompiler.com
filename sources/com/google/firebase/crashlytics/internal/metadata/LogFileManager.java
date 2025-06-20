package com.google.firebase.crashlytics.internal.metadata;

import androidx.annotation.Nullable;
import com.google.firebase.crashlytics.internal.persistence.FileStore;
import java.io.File;

public class LogFileManager {

    /* renamed from: c  reason: collision with root package name */
    private static final String f23711c = "userlog";

    /* renamed from: d  reason: collision with root package name */
    private static final NoopLogStore f23712d = new NoopLogStore();

    /* renamed from: e  reason: collision with root package name */
    static final int f23713e = 65536;

    /* renamed from: a  reason: collision with root package name */
    private final FileStore f23714a;

    /* renamed from: b  reason: collision with root package name */
    private FileLogStore f23715b;

    private static final class NoopLogStore implements FileLogStore {
        private NoopLogStore() {
        }

        public void a() {
        }

        public String b() {
            return null;
        }

        public byte[] c() {
            return null;
        }

        public void d() {
        }

        public void e(long j2, String str) {
        }
    }

    public LogFileManager(FileStore fileStore) {
        this.f23714a = fileStore;
        this.f23715b = f23712d;
    }

    private File d(String str) {
        return this.f23714a.r(str, f23711c);
    }

    public void a() {
        this.f23715b.d();
    }

    public byte[] b() {
        return this.f23715b.c();
    }

    @Nullable
    public String c() {
        return this.f23715b.b();
    }

    public final void e(String str) {
        this.f23715b.a();
        this.f23715b = f23712d;
        if (str != null) {
            f(d(str), 65536);
        }
    }

    /* access modifiers changed from: package-private */
    public void f(File file, int i2) {
        this.f23715b = new QueueFileLogStore(file, i2);
    }

    public void g(long j2, String str) {
        this.f23715b.e(j2, str);
    }

    public LogFileManager(FileStore fileStore, String str) {
        this(fileStore);
        e(str);
    }
}
