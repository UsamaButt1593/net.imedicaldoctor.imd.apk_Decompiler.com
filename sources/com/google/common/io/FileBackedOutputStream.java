package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Objects;
import javax.annotation.CheckForNull;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
@Beta
@J2ktIncompatible
public final class FileBackedOutputStream extends OutputStream {
    private final boolean X;
    @CheckForNull
    @GuardedBy("this")
    private MemoryOutput X2;
    private final ByteSource Y;
    @CheckForNull
    @GuardedBy("this")
    private File Y2;
    @GuardedBy("this")
    private OutputStream Z;
    private final int s;

    private static class MemoryOutput extends ByteArrayOutputStream {
        private MemoryOutput() {
        }

        /* access modifiers changed from: package-private */
        public byte[] b() {
            return this.buf;
        }

        /* access modifiers changed from: package-private */
        public int getCount() {
            return this.count;
        }
    }

    public FileBackedOutputStream(int i2) {
        this(i2, false);
    }

    /* access modifiers changed from: private */
    public synchronized InputStream e() throws IOException {
        if (this.Y2 != null) {
            return new FileInputStream(this.Y2);
        }
        Objects.requireNonNull(this.X2);
        return new ByteArrayInputStream(this.X2.b(), 0, this.X2.getCount());
    }

    @GuardedBy("this")
    private void h(int i2) throws IOException {
        MemoryOutput memoryOutput = this.X2;
        if (memoryOutput != null && memoryOutput.getCount() + i2 > this.s) {
            File b2 = TempFileCreator.f22799a.b("FileBackedOutputStream");
            if (this.X) {
                b2.deleteOnExit();
            }
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(b2);
                fileOutputStream.write(this.X2.b(), 0, this.X2.getCount());
                fileOutputStream.flush();
                this.Z = fileOutputStream;
                this.Y2 = b2;
                this.X2 = null;
            } catch (IOException e2) {
                b2.delete();
                throw e2;
            }
        }
    }

    public ByteSource c() {
        return this.Y;
    }

    public synchronized void close() throws IOException {
        this.Z.close();
    }

    /* access modifiers changed from: package-private */
    @CheckForNull
    @VisibleForTesting
    public synchronized File d() {
        return this.Y2;
    }

    public synchronized void f() throws IOException {
        try {
            close();
            MemoryOutput memoryOutput = this.X2;
            if (memoryOutput == null) {
                this.X2 = new MemoryOutput();
            } else {
                memoryOutput.reset();
            }
            this.Z = this.X2;
            File file = this.Y2;
            if (file != null) {
                this.Y2 = null;
                if (!file.delete()) {
                    throw new IOException("Could not delete: " + file);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void flush() throws IOException {
        this.Z.flush();
    }

    public synchronized void write(int i2) throws IOException {
        h(1);
        this.Z.write(i2);
    }

    public FileBackedOutputStream(int i2, boolean z) {
        Preconditions.k(i2 >= 0, "fileThreshold must be non-negative, but was %s", i2);
        this.s = i2;
        this.X = z;
        MemoryOutput memoryOutput = new MemoryOutput();
        this.X2 = memoryOutput;
        this.Z = memoryOutput;
        this.Y = z ? new ByteSource() {
            /* access modifiers changed from: protected */
            public void finalize() {
                try {
                    FileBackedOutputStream.this.f();
                } catch (Throwable th) {
                    th.printStackTrace(System.err);
                }
            }

            public InputStream m() throws IOException {
                return FileBackedOutputStream.this.e();
            }
        } : new ByteSource() {
            public InputStream m() throws IOException {
                return FileBackedOutputStream.this.e();
            }
        };
    }

    public synchronized void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    public synchronized void write(byte[] bArr, int i2, int i3) throws IOException {
        h(i3);
        this.Z.write(bArr, i2, i3);
    }
}
