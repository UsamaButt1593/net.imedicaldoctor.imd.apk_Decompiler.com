package net.lingala.zip4j.util;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.attribute.DosFileAttributeView;
import java.nio.file.attribute.DosFileAttributes;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.PosixFilePermission;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import m.A;
import m.c;
import m.d;
import m.o;
import m.p;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.ExcludeFileFilter;
import net.lingala.zip4j.model.ZipModel;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.progress.ProgressMonitor;

public class FileUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f30705a = {0, 0, Byte.MIN_VALUE, -127};

    /* renamed from: b  reason: collision with root package name */
    public static final byte[] f30706b = {0, 0, Byte.MIN_VALUE, 65};

    public static boolean A() {
        return System.getProperty("os.name").toLowerCase().contains("nux");
    }

    public static boolean B() {
        return System.getProperty("os.name").toLowerCase().contains("win");
    }

    public static boolean C(String str) {
        return str.endsWith("/") || str.endsWith("\\");
    }

    public static String E(File file) {
        try {
            return Files.readSymbolicLink(file.toPath()).toString();
        } catch (Error | Exception unused) {
            return "";
        }
    }

    private static byte F(boolean z, byte b2, int i2) {
        return z ? BitUtils.b(b2, i2) : b2;
    }

    public static void G(Path path, byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            if (B()) {
                d(path, bArr);
            } else if (x() || A()) {
                c(path, bArr);
            }
        }
    }

    public static void H(Path path, long j2) {
        if (j2 > 0 && Files.exists(path, new LinkOption[0])) {
            try {
                Path unused = Files.setLastModifiedTime(path, FileTime.fromMillis(Zip4jUtil.d(j2)));
            } catch (Exception unused2) {
            }
        }
    }

    public static void I(File file, long j2) {
        file.setLastModified(Zip4jUtil.d(j2));
    }

    private static void b(byte b2, int i2, Set<PosixFilePermission> set, PosixFilePermission posixFilePermission) {
        if (BitUtils.a(b2, i2)) {
            set.add(posixFilePermission);
        }
    }

    private static void c(Path path, byte[] bArr) {
        if (bArr[2] != 0 || bArr[3] != 0) {
            try {
                HashSet hashSet = new HashSet();
                b(bArr[3], 0, hashSet, PosixFilePermission.OWNER_READ);
                b(bArr[2], 7, hashSet, PosixFilePermission.OWNER_WRITE);
                b(bArr[2], 6, hashSet, PosixFilePermission.OWNER_EXECUTE);
                b(bArr[2], 5, hashSet, PosixFilePermission.GROUP_READ);
                b(bArr[2], 4, hashSet, PosixFilePermission.GROUP_WRITE);
                b(bArr[2], 3, hashSet, PosixFilePermission.GROUP_EXECUTE);
                b(bArr[2], 2, hashSet, PosixFilePermission.OTHERS_READ);
                b(bArr[2], 1, hashSet, PosixFilePermission.OTHERS_WRITE);
                b(bArr[2], 0, hashSet, PosixFilePermission.OTHERS_EXECUTE);
                Path unused = Files.setPosixFilePermissions(path, hashSet);
            } catch (IOException unused2) {
            }
        }
    }

    private static void d(Path path, byte[] bArr) {
        if (bArr[0] != 0) {
            DosFileAttributeView a2 = d.a(Files.getFileAttributeView(path, c.a(), new LinkOption[]{LinkOption.NOFOLLOW_LINKS}));
            try {
                a2.setReadOnly(BitUtils.a(bArr[0], 0));
                a2.setHidden(BitUtils.a(bArr[0], 1));
                a2.setSystem(BitUtils.a(bArr[0], 2));
                a2.setArchive(BitUtils.a(bArr[0], 5));
            } catch (IOException unused) {
            }
        }
    }

    private static void e(File file) throws ZipException {
        if (!file.exists()) {
            throw new ZipException("File does not exist: " + file);
        }
    }

    public static void f(List<File> list, ZipParameters.SymbolicLinkAction symbolicLinkAction) throws ZipException {
        for (File next : list) {
            if (!z(next)) {
                e(next);
            } else if (symbolicLinkAction.equals(ZipParameters.SymbolicLinkAction.INCLUDE_LINK_AND_LINKED_FILE) || symbolicLinkAction.equals(ZipParameters.SymbolicLinkAction.INCLUDE_LINKED_FILE_ONLY)) {
                g(next);
            }
        }
    }

    private static void g(File file) throws ZipException {
        if (!file.exists()) {
            throw new ZipException("Symlink target '" + E(file) + "' does not exist for link '" + file + "'");
        }
    }

    public static void h(RandomAccessFile randomAccessFile, OutputStream outputStream, long j2, long j3, ProgressMonitor progressMonitor) throws ZipException {
        int i2;
        long j4 = 0;
        if (j2 < 0 || j3 < 0 || j2 > j3) {
            throw new ZipException("invalid offsets");
        } else if (i2 != 0) {
            try {
                randomAccessFile.seek(j2);
                long j5 = j3 - j2;
                byte[] bArr = j5 < PlaybackStateCompat.r3 ? new byte[((int) j5)] : new byte[4096];
                while (true) {
                    int read = randomAccessFile.read(bArr);
                    if (read != -1) {
                        outputStream.write(bArr, 0, read);
                        long j6 = (long) read;
                        progressMonitor.x(j6);
                        if (progressMonitor.l()) {
                            progressMonitor.u(ProgressMonitor.Result.CANCELLED);
                            return;
                        }
                        j4 += j6;
                        if (j4 != j5) {
                            if (((long) bArr.length) + j4 > j5) {
                                bArr = new byte[((int) (j5 - j4))];
                            }
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                }
            } catch (IOException e2) {
                throw new ZipException((Exception) e2);
            }
        }
    }

    public static File[] i(File file) {
        File[] listFiles = file.getParentFile().listFiles(new A(n(file.getName())));
        if (listFiles == null) {
            return new File[0];
        }
        Arrays.sort(listFiles);
        return listFiles;
    }

    public static byte[] j(boolean z) {
        byte[] bArr = new byte[4];
        if (A() || x()) {
            if (z) {
                System.arraycopy(f30706b, 0, bArr, 0, 4);
            } else {
                System.arraycopy(f30705a, 0, bArr, 0, 4);
            }
        }
        return bArr;
    }

    private static String k(int i2) {
        if (i2 < 9) {
            return "00";
        }
        return i2 < 99 ? "0" : "";
    }

    public static byte[] l(File file) {
        if (file != null) {
            try {
                if (Files.isSymbolicLink(file.toPath()) || file.exists()) {
                    Path a2 = file.toPath();
                    if (B()) {
                        return v(a2);
                    }
                    if (!x()) {
                        if (!A()) {
                            return new byte[4];
                        }
                    }
                    return s(a2);
                }
            } catch (NoSuchMethodError unused) {
                return new byte[4];
            }
        }
        return new byte[4];
    }

    public static String m(File file) {
        String name = file.getName();
        return !name.contains(".") ? "" : name.substring(name.lastIndexOf(".") + 1);
    }

    public static String n(String str) {
        int lastIndexOf = str.lastIndexOf(".");
        return lastIndexOf == -1 ? str : str.substring(0, lastIndexOf);
    }

    public static List<File> o(File file, boolean z, boolean z2) throws ZipException {
        return p(file, z, z2, (ExcludeFileFilter) null);
    }

    public static List<File> p(File file, boolean z, boolean z2, ExcludeFileFilter excludeFileFilter) throws ZipException {
        if (file != null) {
            ArrayList arrayList = new ArrayList();
            File[] listFiles = file.listFiles();
            if (file.isDirectory() && file.canRead() && listFiles != null) {
                for (File file2 : listFiles) {
                    if (excludeFileFilter == null || !excludeFileFilter.a(file2)) {
                        if (file2.isHidden()) {
                            if (file2.isDirectory()) {
                                if (!z2) {
                                }
                            } else if (!z) {
                            }
                        }
                        arrayList.add(file2);
                        if (file2.isDirectory()) {
                            arrayList.addAll(p(file2, z, z2, excludeFileFilter));
                        }
                    }
                }
            }
            return arrayList;
        }
        throw new ZipException("input path is null, cannot read files in the directory");
    }

    private static String q(File file, String str) throws IOException {
        if (Zip4jUtil.h(str)) {
            return str;
        }
        if (!z(file)) {
            return file.getName();
        }
        return file.toPath().toRealPath(new LinkOption[]{LinkOption.NOFOLLOW_LINKS}).getFileName().toString();
    }

    public static String r(int i2) {
        return "." + k(i2) + (i2 + 1);
    }

    private static byte[] s(Path path) {
        byte[] bArr = new byte[4];
        try {
            Set a2 = p.a(Files.getFileAttributeView(path, o.a(), new LinkOption[]{LinkOption.NOFOLLOW_LINKS})).readAttributes().permissions();
            bArr[3] = F(Files.isRegularFile(path, new LinkOption[0]), bArr[3], 7);
            bArr[3] = F(Files.isDirectory(path, new LinkOption[0]), bArr[3], 6);
            bArr[3] = F(Files.isSymbolicLink(path), bArr[3], 5);
            bArr[3] = F(a2.contains(PosixFilePermission.OWNER_READ), bArr[3], 0);
            bArr[2] = F(a2.contains(PosixFilePermission.OWNER_WRITE), bArr[2], 7);
            bArr[2] = F(a2.contains(PosixFilePermission.OWNER_EXECUTE), bArr[2], 6);
            bArr[2] = F(a2.contains(PosixFilePermission.GROUP_READ), bArr[2], 5);
            bArr[2] = F(a2.contains(PosixFilePermission.GROUP_WRITE), bArr[2], 4);
            bArr[2] = F(a2.contains(PosixFilePermission.GROUP_EXECUTE), bArr[2], 3);
            bArr[2] = F(a2.contains(PosixFilePermission.OTHERS_READ), bArr[2], 2);
            bArr[2] = F(a2.contains(PosixFilePermission.OTHERS_WRITE), bArr[2], 1);
            bArr[2] = F(a2.contains(PosixFilePermission.OTHERS_EXECUTE), bArr[2], 0);
        } catch (IOException unused) {
        }
        return bArr;
    }

    public static String t(File file, ZipParameters zipParameters) throws ZipException {
        String str;
        String str2;
        StringBuilder sb;
        try {
            String canonicalPath = file.getCanonicalPath();
            if (Zip4jUtil.h(zipParameters.e())) {
                String canonicalPath2 = new File(zipParameters.e()).getCanonicalPath();
                String str3 = InternalZipConstants.r;
                if (!canonicalPath2.endsWith(str3)) {
                    canonicalPath2 = canonicalPath2 + str3;
                }
                if (z(file)) {
                    str2 = new File(file.getParentFile().getCanonicalFile().getPath() + File.separator + file.getCanonicalFile().getName()).getPath().substring(canonicalPath2.length());
                } else {
                    str2 = canonicalPath.substring(canonicalPath2.length());
                }
                if (str2.startsWith(System.getProperty("file.separator"))) {
                    str2 = str2.substring(1);
                }
                File file2 = new File(canonicalPath);
                if (file2.isDirectory()) {
                    String replaceAll = str2.replaceAll("\\\\", "/");
                    sb = new StringBuilder();
                    sb.append(replaceAll);
                    sb.append("/");
                } else {
                    String replaceAll2 = str2.substring(0, str2.lastIndexOf(file2.getName())).replaceAll("\\\\", "/");
                    sb = new StringBuilder();
                    sb.append(replaceAll2);
                    sb.append(q(file2, zipParameters.k()));
                }
                str = sb.toString();
            } else {
                File file3 = new File(canonicalPath);
                String q = q(file3, zipParameters.k());
                if (file3.isDirectory()) {
                    str = q + "/";
                } else {
                    str = q;
                }
            }
            String m2 = zipParameters.m();
            if (!Zip4jUtil.h(m2)) {
                return str;
            }
            if (!m2.endsWith("\\") && !m2.endsWith("/")) {
                m2 = m2 + InternalZipConstants.r;
            }
            return m2.replaceAll("\\\\", "/") + str;
        } catch (IOException e2) {
            throw new ZipException((Exception) e2);
        }
    }

    public static List<File> u(ZipModel zipModel) throws ZipException {
        if (zipModel == null) {
            throw new ZipException("cannot get split zip files: zipmodel is null");
        } else if (zipModel.e() == null) {
            return null;
        } else {
            if (zipModel.m().exists()) {
                ArrayList arrayList = new ArrayList();
                File m2 = zipModel.m();
                if (!zipModel.o()) {
                    arrayList.add(m2);
                    return arrayList;
                }
                int d2 = zipModel.e().d();
                if (d2 == 0) {
                    arrayList.add(m2);
                    return arrayList;
                }
                int i2 = 0;
                while (i2 <= d2) {
                    if (i2 == d2) {
                        arrayList.add(zipModel.m());
                    } else {
                        String str = i2 >= 9 ? ".z" : ".z0";
                        String substring = m2.getName().contains(".") ? m2.getPath().substring(0, m2.getPath().lastIndexOf(".")) : m2.getPath();
                        arrayList.add(new File(substring + str + (i2 + 1)));
                    }
                    i2++;
                }
                return arrayList;
            }
            throw new ZipException("zip file does not exist");
        }
    }

    private static byte[] v(Path path) {
        byte[] bArr = new byte[4];
        try {
            DosFileAttributes a2 = d.a(Files.getFileAttributeView(path, c.a(), new LinkOption[]{LinkOption.NOFOLLOW_LINKS})).readAttributes();
            bArr[0] = F(a2.isArchive(), F(a2.isSystem(), F(a2.isHidden(), F(a2.isReadOnly(), (byte) 0, 0), 1), 2), 5);
        } catch (IOException unused) {
        }
        return bArr;
    }

    public static String w(String str) throws ZipException {
        if (Zip4jUtil.h(str)) {
            if (str.contains(System.getProperty("file.separator"))) {
                str = str.substring(str.lastIndexOf(System.getProperty("file.separator")) + 1);
            }
            return str.endsWith(".zip") ? str.substring(0, str.lastIndexOf(".")) : str;
        }
        throw new ZipException("zip file name is empty or null, cannot determine zip file name");
    }

    public static boolean x() {
        return System.getProperty("os.name").toLowerCase().contains("mac");
    }

    public static boolean y(File file) {
        return file.getName().endsWith(InternalZipConstants.v);
    }

    public static boolean z(File file) {
        try {
            return Files.isSymbolicLink(file.toPath());
        } catch (Error | Exception unused) {
            return false;
        }
    }
}
