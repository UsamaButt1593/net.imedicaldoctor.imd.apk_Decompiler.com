package okhttp3.internal.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import okio.Okio;
import okio.Sink;
import okio.Source;

public interface FileSystem {

    /* renamed from: a  reason: collision with root package name */
    public static final FileSystem f31224a = new FileSystem() {
        public Source a(File file) throws FileNotFoundException {
            return Okio.t(file);
        }

        public Sink b(File file) throws FileNotFoundException {
            try {
                return Okio.n(file);
            } catch (FileNotFoundException unused) {
                file.getParentFile().mkdirs();
                return Okio.n(file);
            }
        }

        public void c(File file) throws IOException {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                int length = listFiles.length;
                int i2 = 0;
                while (i2 < length) {
                    File file2 = listFiles[i2];
                    if (file2.isDirectory()) {
                        c(file2);
                    }
                    if (file2.delete()) {
                        i2++;
                    } else {
                        throw new IOException("failed to delete " + file2);
                    }
                }
                return;
            }
            throw new IOException("not a readable directory: " + file);
        }

        public boolean d(File file) {
            return file.exists();
        }

        public void e(File file, File file2) throws IOException {
            f(file2);
            if (!file.renameTo(file2)) {
                throw new IOException("failed to rename " + file + " to " + file2);
            }
        }

        public void f(File file) throws IOException {
            if (!file.delete() && file.exists()) {
                throw new IOException("failed to delete " + file);
            }
        }

        public Sink g(File file) throws FileNotFoundException {
            try {
                return Okio.a(file);
            } catch (FileNotFoundException unused) {
                file.getParentFile().mkdirs();
                return Okio.a(file);
            }
        }

        public long h(File file) {
            return file.length();
        }
    };

    Source a(File file) throws FileNotFoundException;

    Sink b(File file) throws FileNotFoundException;

    void c(File file) throws IOException;

    boolean d(File file);

    void e(File file, File file2) throws IOException;

    void f(File file) throws IOException;

    Sink g(File file) throws FileNotFoundException;

    long h(File file);
}
