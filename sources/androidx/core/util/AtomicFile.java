package androidx.core.util;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class AtomicFile {

    /* renamed from: d  reason: collision with root package name */
    private static final String f6289d = "AtomicFile";

    /* renamed from: a  reason: collision with root package name */
    private final File f6290a;

    /* renamed from: b  reason: collision with root package name */
    private final File f6291b;

    /* renamed from: c  reason: collision with root package name */
    private final File f6292c;

    public AtomicFile(@NonNull File file) {
        this.f6290a = file;
        this.f6291b = new File(file.getPath() + ".new");
        this.f6292c = new File(file.getPath() + ".bak");
    }

    private static void g(@NonNull File file, @NonNull File file2) {
        if (file2.isDirectory() && !file2.delete()) {
            Log.e(f6289d, "Failed to delete file which is a directory " + file2);
        }
        if (!file.renameTo(file2)) {
            Log.e(f6289d, "Failed to rename " + file + " to " + file2);
        }
    }

    private static boolean i(@NonNull FileOutputStream fileOutputStream) {
        try {
            fileOutputStream.getFD().sync();
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    public void a() {
        this.f6290a.delete();
        this.f6291b.delete();
        this.f6292c.delete();
    }

    public void b(@Nullable FileOutputStream fileOutputStream) {
        if (fileOutputStream != null) {
            if (!i(fileOutputStream)) {
                Log.e(f6289d, "Failed to sync file output stream");
            }
            try {
                fileOutputStream.close();
            } catch (IOException e2) {
                Log.e(f6289d, "Failed to close file output stream", e2);
            }
            if (!this.f6291b.delete()) {
                Log.e(f6289d, "Failed to delete new file " + this.f6291b);
            }
        }
    }

    public void c(@Nullable FileOutputStream fileOutputStream) {
        if (fileOutputStream != null) {
            if (!i(fileOutputStream)) {
                Log.e(f6289d, "Failed to sync file output stream");
            }
            try {
                fileOutputStream.close();
            } catch (IOException e2) {
                Log.e(f6289d, "Failed to close file output stream", e2);
            }
            g(this.f6291b, this.f6290a);
        }
    }

    @NonNull
    public File d() {
        return this.f6290a;
    }

    @NonNull
    public FileInputStream e() throws FileNotFoundException {
        if (this.f6292c.exists()) {
            g(this.f6292c, this.f6290a);
        }
        if (this.f6291b.exists() && this.f6290a.exists() && !this.f6291b.delete()) {
            Log.e(f6289d, "Failed to delete outdated new file " + this.f6291b);
        }
        return new FileInputStream(this.f6290a);
    }

    @NonNull
    public byte[] f() throws IOException {
        FileInputStream e2 = e();
        try {
            byte[] bArr = new byte[e2.available()];
            int i2 = 0;
            while (true) {
                int read = e2.read(bArr, i2, bArr.length - i2);
                if (read <= 0) {
                    return bArr;
                }
                i2 += read;
                int available = e2.available();
                if (available > bArr.length - i2) {
                    byte[] bArr2 = new byte[(available + i2)];
                    System.arraycopy(bArr, 0, bArr2, 0, i2);
                    bArr = bArr2;
                }
            }
        } finally {
            e2.close();
        }
    }

    @NonNull
    public FileOutputStream h() throws IOException {
        if (this.f6292c.exists()) {
            g(this.f6292c, this.f6290a);
        }
        try {
            return new FileOutputStream(this.f6291b);
        } catch (FileNotFoundException unused) {
            if (this.f6291b.getParentFile().mkdirs()) {
                try {
                    return new FileOutputStream(this.f6291b);
                } catch (FileNotFoundException e2) {
                    throw new IOException("Failed to create new file " + this.f6291b, e2);
                }
            } else {
                throw new IOException("Failed to create directory for " + this.f6291b);
            }
        }
    }
}
