package androidx.media3.common.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@UnstableApi
public final class AtomicFile {

    /* renamed from: c  reason: collision with root package name */
    private static final String f9496c = "AtomicFile";

    /* renamed from: a  reason: collision with root package name */
    private final File f9497a;

    /* renamed from: b  reason: collision with root package name */
    private final File f9498b;

    private static final class AtomicFileOutputStream extends OutputStream {
        private boolean X = false;
        private final FileOutputStream s;

        public AtomicFileOutputStream(File file) throws FileNotFoundException {
            this.s = new FileOutputStream(file);
        }

        public void close() throws IOException {
            if (!this.X) {
                this.X = true;
                flush();
                try {
                    this.s.getFD().sync();
                } catch (IOException e2) {
                    Log.o(AtomicFile.f9496c, "Failed to sync file descriptor:", e2);
                }
                this.s.close();
            }
        }

        public void flush() throws IOException {
            this.s.flush();
        }

        public void write(int i2) throws IOException {
            this.s.write(i2);
        }

        public void write(byte[] bArr) throws IOException {
            this.s.write(bArr);
        }

        public void write(byte[] bArr, int i2, int i3) throws IOException {
            this.s.write(bArr, i2, i3);
        }
    }

    public AtomicFile(File file) {
        this.f9497a = file;
        this.f9498b = new File(file.getPath() + ".bak");
    }

    private void e() {
        if (this.f9498b.exists()) {
            this.f9497a.delete();
            this.f9498b.renameTo(this.f9497a);
        }
    }

    public void a() {
        this.f9497a.delete();
        this.f9498b.delete();
    }

    public void b(OutputStream outputStream) throws IOException {
        outputStream.close();
        this.f9498b.delete();
    }

    public boolean c() {
        return this.f9497a.exists() || this.f9498b.exists();
    }

    public InputStream d() throws FileNotFoundException {
        e();
        return new FileInputStream(this.f9497a);
    }

    public OutputStream f() throws IOException {
        if (this.f9497a.exists()) {
            if (this.f9498b.exists()) {
                this.f9497a.delete();
            } else if (!this.f9497a.renameTo(this.f9498b)) {
                Log.n(f9496c, "Couldn't rename file " + this.f9497a + " to backup file " + this.f9498b);
            }
        }
        try {
            return new AtomicFileOutputStream(this.f9497a);
        } catch (FileNotFoundException e2) {
            File parentFile = this.f9497a.getParentFile();
            if (parentFile == null || !parentFile.mkdirs()) {
                throw new IOException("Couldn't create " + this.f9497a, e2);
            }
            try {
                return new AtomicFileOutputStream(this.f9497a);
            } catch (FileNotFoundException e3) {
                throw new IOException("Couldn't create " + this.f9497a, e3);
            }
        }
    }
}
