package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Joiner;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.graph.SuccessorsFunction;
import com.google.common.graph.Traverser;
import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.InlineMe;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.CheckForNull;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
@J2ktIncompatible
public final class Files {

    /* renamed from: a  reason: collision with root package name */
    private static final SuccessorsFunction<File> f22781a = new SuccessorsFunction<File>() {
        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
            r2 = r2.listFiles();
         */
        /* renamed from: N */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Iterable<java.io.File> b(java.io.File r2) {
            /*
                r1 = this;
                boolean r0 = r2.isDirectory()
                if (r0 == 0) goto L_0x0015
                java.io.File[] r2 = r2.listFiles()
                if (r2 == 0) goto L_0x0015
                java.util.List r2 = java.util.Arrays.asList(r2)
                java.util.List r2 = java.util.Collections.unmodifiableList(r2)
                return r2
            L_0x0015:
                com.google.common.collect.ImmutableList r2 = com.google.common.collect.ImmutableList.I()
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.io.Files.AnonymousClass2.b(java.io.File):java.lang.Iterable");
        }
    };

    private static final class FileByteSink extends ByteSink {

        /* renamed from: a  reason: collision with root package name */
        private final File f22783a;

        /* renamed from: b  reason: collision with root package name */
        private final ImmutableSet<FileWriteMode> f22784b;

        private FileByteSink(File file, FileWriteMode... fileWriteModeArr) {
            this.f22783a = (File) Preconditions.E(file);
            this.f22784b = ImmutableSet.E(fileWriteModeArr);
        }

        /* renamed from: f */
        public FileOutputStream c() throws IOException {
            return new FileOutputStream(this.f22783a, this.f22784b.contains(FileWriteMode.APPEND));
        }

        public String toString() {
            return "Files.asByteSink(" + this.f22783a + ", " + this.f22784b + ")";
        }
    }

    private static final class FileByteSource extends ByteSource {

        /* renamed from: a  reason: collision with root package name */
        private final File f22785a;

        private FileByteSource(File file) {
            this.f22785a = (File) Preconditions.E(file);
        }

        public byte[] o() throws IOException {
            Closer b2 = Closer.b();
            try {
                FileInputStream fileInputStream = (FileInputStream) b2.c(m());
                byte[] v = ByteStreams.v(fileInputStream, fileInputStream.getChannel().size());
                b2.close();
                return v;
            } catch (Throwable th) {
                b2.close();
                throw th;
            }
        }

        public long p() throws IOException {
            if (this.f22785a.isFile()) {
                return this.f22785a.length();
            }
            throw new FileNotFoundException(this.f22785a.toString());
        }

        public Optional<Long> q() {
            return this.f22785a.isFile() ? Optional.f(Long.valueOf(this.f22785a.length())) : Optional.a();
        }

        /* renamed from: t */
        public FileInputStream m() throws IOException {
            return new FileInputStream(this.f22785a);
        }

        public String toString() {
            return "Files.asByteSource(" + this.f22785a + ")";
        }
    }

    private enum FilePredicate implements Predicate<File> {
        IS_DIRECTORY {
            /* renamed from: b */
            public boolean apply(File file) {
                return file.isDirectory();
            }

            public String toString() {
                return "Files.isDirectory()";
            }
        },
        IS_FILE {
            /* renamed from: b */
            public boolean apply(File file) {
                return file.isFile();
            }

            public String toString() {
                return "Files.isFile()";
            }
        }
    }

    private Files() {
    }

    @InlineMe(imports = {"com.google.common.io.Files"}, replacement = "Files.asCharSource(file, charset).readLines(callback)")
    @ParametricNullness
    @Deprecated
    @CanIgnoreReturnValue
    public static <T> T A(File file, Charset charset, LineProcessor<T> lineProcessor) throws IOException {
        return e(file, charset).q(lineProcessor);
    }

    public static List<String> B(File file, Charset charset) throws IOException {
        return (List) e(file, charset).q(new LineProcessor<List<String>>() {

            /* renamed from: a  reason: collision with root package name */
            final List<String> f22782a = Lists.q();

            public boolean b(String str) {
                this.f22782a.add(str);
                return true;
            }

            /* renamed from: c */
            public List<String> a() {
                return this.f22782a;
            }
        });
    }

    public static String C(String str) {
        Preconditions.E(str);
        if (str.length() == 0) {
            return ".";
        }
        Iterable<String> n2 = Splitter.h('/').g().n(str);
        ArrayList arrayList = new ArrayList();
        for (String next : n2) {
            next.hashCode();
            if (!next.equals(".")) {
                if (!next.equals("..")) {
                    arrayList.add(next);
                } else if (arrayList.size() <= 0 || ((String) arrayList.get(arrayList.size() - 1)).equals("..")) {
                    arrayList.add("..");
                } else {
                    arrayList.remove(arrayList.size() - 1);
                }
            }
        }
        String k2 = Joiner.o('/').k(arrayList);
        if (str.charAt(0) == '/') {
            k2 = "/" + k2;
        }
        while (k2.startsWith("/../")) {
            k2 = k2.substring(3);
        }
        if (k2.equals("/..")) {
            return "/";
        }
        return "".equals(k2) ? "." : k2;
    }

    public static byte[] D(File file) throws IOException {
        return c(file).o();
    }

    @InlineMe(imports = {"com.google.common.io.Files"}, replacement = "Files.asCharSource(file, charset).read()")
    @Deprecated
    public static String E(File file, Charset charset) throws IOException {
        return e(file, charset).n();
    }

    public static void F(File file) throws IOException {
        Preconditions.E(file);
        if (!file.createNewFile() && !file.setLastModified(System.currentTimeMillis())) {
            throw new IOException("Unable to update modification time of " + file);
        }
    }

    @InlineMe(imports = {"com.google.common.io.Files"}, replacement = "Files.asCharSink(to, charset).write(from)")
    @Deprecated
    public static void G(CharSequence charSequence, File file, Charset charset) throws IOException {
        d(file, charset, new FileWriteMode[0]).c(charSequence);
    }

    public static void H(byte[] bArr, File file) throws IOException {
        b(file, new FileWriteMode[0]).d(bArr);
    }

    @InlineMe(imports = {"com.google.common.io.FileWriteMode", "com.google.common.io.Files"}, replacement = "Files.asCharSink(to, charset, FileWriteMode.APPEND).write(from)")
    @Deprecated
    public static void a(CharSequence charSequence, File file, Charset charset) throws IOException {
        d(file, charset, FileWriteMode.APPEND).c(charSequence);
    }

    public static ByteSink b(File file, FileWriteMode... fileWriteModeArr) {
        return new FileByteSink(file, fileWriteModeArr);
    }

    public static ByteSource c(File file) {
        return new FileByteSource(file);
    }

    public static CharSink d(File file, Charset charset, FileWriteMode... fileWriteModeArr) {
        return b(file, fileWriteModeArr).a(charset);
    }

    public static CharSource e(File file, Charset charset) {
        return c(file).a(charset);
    }

    public static void f(File file, File file2) throws IOException {
        Preconditions.y(!file.equals(file2), "Source %s and destination %s must be different", file, file2);
        c(file).f(b(file2, new FileWriteMode[0]));
    }

    public static void g(File file, OutputStream outputStream) throws IOException {
        c(file).g(outputStream);
    }

    @InlineMe(imports = {"com.google.common.io.Files"}, replacement = "Files.asCharSource(from, charset).copyTo(to)")
    @Deprecated
    public static void h(File file, Charset charset, Appendable appendable) throws IOException {
        e(file, charset).f(appendable);
    }

    public static void i(File file) throws IOException {
        Preconditions.E(file);
        File parentFile = file.getCanonicalFile().getParentFile();
        if (parentFile != null) {
            parentFile.mkdirs();
            if (!parentFile.isDirectory()) {
                throw new IOException("Unable to create parent directories of " + file);
            }
        }
    }

    @Deprecated
    @Beta
    public static File j() {
        return TempFileCreator.f22799a.a();
    }

    public static boolean k(File file, File file2) throws IOException {
        Preconditions.E(file);
        Preconditions.E(file2);
        if (file == file2 || file.equals(file2)) {
            return true;
        }
        long length = file.length();
        long length2 = file2.length();
        if (length == 0 || length2 == 0 || length == length2) {
            return c(file).e(c(file2));
        }
        return false;
    }

    public static Traverser<File> l() {
        return Traverser.h(f22781a);
    }

    public static String m(String str) {
        Preconditions.E(str);
        String name = new File(str).getName();
        int lastIndexOf = name.lastIndexOf(46);
        return lastIndexOf == -1 ? "" : name.substring(lastIndexOf + 1);
    }

    public static String n(String str) {
        Preconditions.E(str);
        String name = new File(str).getName();
        int lastIndexOf = name.lastIndexOf(46);
        return lastIndexOf == -1 ? name : name.substring(0, lastIndexOf);
    }

    @InlineMe(imports = {"com.google.common.io.Files"}, replacement = "Files.asByteSource(file).hash(hashFunction)")
    @Deprecated
    public static HashCode o(File file, HashFunction hashFunction) throws IOException {
        return c(file).j(hashFunction);
    }

    public static Predicate<File> p() {
        return FilePredicate.IS_DIRECTORY;
    }

    public static Predicate<File> q() {
        return FilePredicate.IS_FILE;
    }

    public static MappedByteBuffer r(File file) throws IOException {
        Preconditions.E(file);
        return s(file, FileChannel.MapMode.READ_ONLY);
    }

    public static MappedByteBuffer s(File file, FileChannel.MapMode mapMode) throws IOException {
        return u(file, mapMode, -1);
    }

    public static MappedByteBuffer t(File file, FileChannel.MapMode mapMode, long j2) throws IOException {
        Preconditions.p(j2 >= 0, "size (%s) may not be negative", j2);
        return u(file, mapMode, j2);
    }

    private static MappedByteBuffer u(File file, FileChannel.MapMode mapMode, long j2) throws IOException {
        Preconditions.E(file);
        Preconditions.E(mapMode);
        Closer b2 = Closer.b();
        try {
            FileChannel fileChannel = (FileChannel) b2.c(((RandomAccessFile) b2.c(new RandomAccessFile(file, mapMode == FileChannel.MapMode.READ_ONLY ? "r" : "rw"))).getChannel());
            if (j2 == -1) {
                j2 = fileChannel.size();
            }
            MappedByteBuffer map = fileChannel.map(mapMode, 0, j2);
            b2.close();
            return map;
        } catch (Throwable th) {
            b2.close();
            throw th;
        }
    }

    public static void v(File file, File file2) throws IOException {
        Preconditions.E(file);
        Preconditions.E(file2);
        Preconditions.y(!file.equals(file2), "Source %s and destination %s must be different", file, file2);
        if (!file.renameTo(file2)) {
            f(file, file2);
            if (file.delete()) {
                return;
            }
            if (!file2.delete()) {
                throw new IOException("Unable to delete " + file2);
            }
            throw new IOException("Unable to delete " + file);
        }
    }

    public static BufferedReader w(File file, Charset charset) throws FileNotFoundException {
        Preconditions.E(file);
        Preconditions.E(charset);
        return new BufferedReader(new InputStreamReader(new FileInputStream(file), charset));
    }

    public static BufferedWriter x(File file, Charset charset) throws FileNotFoundException {
        Preconditions.E(file);
        Preconditions.E(charset);
        return new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), charset));
    }

    @InlineMe(imports = {"com.google.common.io.Files"}, replacement = "Files.asByteSource(file).read(processor)")
    @ParametricNullness
    @Deprecated
    @CanIgnoreReturnValue
    public static <T> T y(File file, ByteProcessor<T> byteProcessor) throws IOException {
        return c(file).n(byteProcessor);
    }

    @InlineMe(imports = {"com.google.common.io.Files"}, replacement = "Files.asCharSource(file, charset).readFirstLine()")
    @CheckForNull
    @Deprecated
    public static String z(File file, Charset charset) throws IOException {
        return e(file, charset).o();
    }
}
