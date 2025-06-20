package net.lingala.zip4j.tasks;

import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.io.inputstream.ZipInputStream;
import net.lingala.zip4j.model.FileHeader;
import net.lingala.zip4j.model.LocalFileHeader;
import net.lingala.zip4j.model.ZipModel;
import net.lingala.zip4j.progress.ProgressMonitor;
import net.lingala.zip4j.tasks.AsyncZipTask;
import net.lingala.zip4j.util.BitUtils;
import net.lingala.zip4j.util.InternalZipConstants;
import net.lingala.zip4j.util.Zip4jUtil;

public abstract class AbstractExtractFileTask<T> extends AsyncZipTask<T> {

    /* renamed from: d  reason: collision with root package name */
    private ZipModel f30668d;

    /* renamed from: e  reason: collision with root package name */
    private byte[] f30669e = new byte[4096];

    public AbstractExtractFileTask(ZipModel zipModel, AsyncZipTask.AsyncTaskParameters asyncTaskParameters) {
        super(asyncTaskParameters);
        this.f30668d = zipModel;
    }

    private void i(File file) throws ZipException {
        if (!file.getParentFile().exists() && !file.getParentFile().mkdirs()) {
            throw new ZipException("Unable to create parent directories: " + file.getParentFile());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x004c, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0051, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0052, code lost:
        r4.addSuppressed(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0055, code lost:
        throw r5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void j(net.lingala.zip4j.io.inputstream.ZipInputStream r3, net.lingala.zip4j.model.FileHeader r4, java.io.File r5, net.lingala.zip4j.progress.ProgressMonitor r6) throws java.io.IOException {
        /*
            r2 = this;
            java.lang.String r0 = new java.lang.String
            byte[] r3 = r2.p(r3, r4, r6)
            r0.<init>(r3)
            java.io.File r3 = r5.getParentFile()
            boolean r3 = r3.exists()
            if (r3 != 0) goto L_0x0026
            java.io.File r3 = r5.getParentFile()
            boolean r3 = r3.mkdirs()
            if (r3 == 0) goto L_0x001e
            goto L_0x0026
        L_0x001e:
            net.lingala.zip4j.exception.ZipException r3 = new net.lingala.zip4j.exception.ZipException
            java.lang.String r4 = "Could not create parent directories"
            r3.<init>((java.lang.String) r4)
            throw r3
        L_0x0026:
            r3 = 0
            java.lang.String[] r6 = new java.lang.String[r3]     // Catch:{ NoSuchMethodError -> 0x003a }
            java.nio.file.Path r6 = java.nio.file.Paths.get(r0, r6)     // Catch:{ NoSuchMethodError -> 0x003a }
            java.nio.file.Path r1 = r5.toPath()     // Catch:{ NoSuchMethodError -> 0x003a }
            java.nio.file.attribute.FileAttribute[] r3 = new java.nio.file.attribute.FileAttribute[r3]     // Catch:{ NoSuchMethodError -> 0x003a }
            java.nio.file.Path unused = java.nio.file.Files.createSymbolicLink(r1, r6, r3)     // Catch:{ NoSuchMethodError -> 0x003a }
            net.lingala.zip4j.util.UnzipUtil.a(r4, r5)     // Catch:{ NoSuchMethodError -> 0x003a }
            goto L_0x0049
        L_0x003a:
            java.io.FileOutputStream r3 = new java.io.FileOutputStream
            r3.<init>(r5)
            byte[] r4 = r0.getBytes()     // Catch:{ all -> 0x004a }
            r3.write(r4)     // Catch:{ all -> 0x004a }
            r3.close()
        L_0x0049:
            return
        L_0x004a:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x004c }
        L_0x004c:
            r5 = move-exception
            r3.close()     // Catch:{ all -> 0x0051 }
            goto L_0x0055
        L_0x0051:
            r3 = move-exception
            r4.addSuppressed(r3)
        L_0x0055:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: net.lingala.zip4j.tasks.AbstractExtractFileTask.j(net.lingala.zip4j.io.inputstream.ZipInputStream, net.lingala.zip4j.model.FileHeader, java.io.File, net.lingala.zip4j.progress.ProgressMonitor):void");
    }

    private File k(FileHeader fileHeader, String str, String str2) {
        if (!Zip4jUtil.h(str2)) {
            str2 = m(fileHeader.k());
        }
        return new File(str + InternalZipConstants.r + str2);
    }

    private String m(String str) {
        return str.replaceAll("[/\\\\]", Matcher.quoteReplacement(InternalZipConstants.r));
    }

    private boolean o(FileHeader fileHeader) {
        byte[] Q = fileHeader.Q();
        if (Q == null || Q.length < 4) {
            return false;
        }
        return BitUtils.a(Q[3], 5);
    }

    private byte[] p(ZipInputStream zipInputStream, FileHeader fileHeader, ProgressMonitor progressMonitor) throws IOException {
        int p = (int) fileHeader.p();
        byte[] bArr = new byte[p];
        if (zipInputStream.read(bArr) == p) {
            progressMonitor.x((long) p);
            return bArr;
        }
        throw new ZipException("Could not read complete entry");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0028, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0031, code lost:
        throw r6;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void q(net.lingala.zip4j.io.inputstream.ZipInputStream r5, net.lingala.zip4j.model.FileHeader r6, java.io.File r7, net.lingala.zip4j.progress.ProgressMonitor r8) throws java.io.IOException {
        /*
            r4 = this;
            java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0025 }
            r0.<init>(r7)     // Catch:{ Exception -> 0x0025 }
        L_0x0005:
            byte[] r1 = r4.f30669e     // Catch:{ all -> 0x001c }
            int r1 = r5.read(r1)     // Catch:{ all -> 0x001c }
            r2 = -1
            if (r1 == r2) goto L_0x001e
            byte[] r2 = r4.f30669e     // Catch:{ all -> 0x001c }
            r3 = 0
            r0.write(r2, r3, r1)     // Catch:{ all -> 0x001c }
            long r1 = (long) r1     // Catch:{ all -> 0x001c }
            r8.x(r1)     // Catch:{ all -> 0x001c }
            r4.h()     // Catch:{ all -> 0x001c }
            goto L_0x0005
        L_0x001c:
            r5 = move-exception
            goto L_0x0027
        L_0x001e:
            r0.close()     // Catch:{ Exception -> 0x0025 }
            net.lingala.zip4j.util.UnzipUtil.a(r6, r7)
            return
        L_0x0025:
            r5 = move-exception
            goto L_0x0032
        L_0x0027:
            throw r5     // Catch:{ all -> 0x0028 }
        L_0x0028:
            r6 = move-exception
            r0.close()     // Catch:{ all -> 0x002d }
            goto L_0x0031
        L_0x002d:
            r8 = move-exception
            r5.addSuppressed(r8)     // Catch:{ Exception -> 0x0025 }
        L_0x0031:
            throw r6     // Catch:{ Exception -> 0x0025 }
        L_0x0032:
            boolean r6 = r7.exists()
            if (r6 == 0) goto L_0x003b
            r7.delete()
        L_0x003b:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: net.lingala.zip4j.tasks.AbstractExtractFileTask.q(net.lingala.zip4j.io.inputstream.ZipInputStream, net.lingala.zip4j.model.FileHeader, java.io.File, net.lingala.zip4j.progress.ProgressMonitor):void");
    }

    private void r(ZipInputStream zipInputStream, FileHeader fileHeader) throws IOException {
        if (!BitUtils.a(fileHeader.m()[0], 6)) {
            LocalFileHeader i2 = zipInputStream.i(fileHeader);
            if (i2 == null) {
                throw new ZipException("Could not read corresponding local file header for file header: " + fileHeader.k());
            } else if (!fileHeader.k().equals(i2.k())) {
                throw new ZipException("File header and local file header mismatch");
            }
        } else {
            throw new ZipException("Entry with name " + fileHeader.k() + " is encrypted with Strong Encryption. Zip4j does not support Strong Encryption, as this is patented.");
        }
    }

    /* access modifiers changed from: protected */
    public ProgressMonitor.Task e() {
        return ProgressMonitor.Task.EXTRACT_ENTRY;
    }

    /* access modifiers changed from: protected */
    public void l(ZipInputStream zipInputStream, FileHeader fileHeader, String str, String str2, ProgressMonitor progressMonitor) throws IOException {
        String str3 = InternalZipConstants.r;
        if (!str.endsWith(str3)) {
            str = str + str3;
        }
        File k2 = k(fileHeader, str, str2);
        progressMonitor.r(k2.getAbsolutePath());
        if (k2.getCanonicalPath().startsWith(new File(str).getCanonicalPath() + File.separator)) {
            r(zipInputStream, fileHeader);
            if (fileHeader.t()) {
                if (!k2.exists() && !k2.mkdirs()) {
                    throw new ZipException("Could not create directory: " + k2);
                }
            } else if (o(fileHeader)) {
                j(zipInputStream, fileHeader, k2, progressMonitor);
            } else {
                i(k2);
                q(zipInputStream, fileHeader, k2, progressMonitor);
            }
        } else {
            throw new ZipException("illegal file name that breaks out of the target directory: " + fileHeader.k());
        }
    }

    public ZipModel n() {
        return this.f30668d;
    }
}
