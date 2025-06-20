package net.lingala.zip4j.tasks;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.headers.HeaderUtil;
import net.lingala.zip4j.headers.HeaderWriter;
import net.lingala.zip4j.io.outputstream.SplitOutputStream;
import net.lingala.zip4j.io.outputstream.ZipOutputStream;
import net.lingala.zip4j.model.FileHeader;
import net.lingala.zip4j.model.ZipModel;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.model.enums.CompressionMethod;
import net.lingala.zip4j.model.enums.EncryptionMethod;
import net.lingala.zip4j.progress.ProgressMonitor;
import net.lingala.zip4j.tasks.AsyncZipTask;
import net.lingala.zip4j.tasks.RemoveFilesFromZipTask;
import net.lingala.zip4j.util.BitUtils;
import net.lingala.zip4j.util.CrcUtil;
import net.lingala.zip4j.util.FileUtils;
import net.lingala.zip4j.util.Zip4jUtil;

public abstract class AbstractAddFileToZipTask<T> extends AsyncZipTask<T> {

    /* renamed from: d  reason: collision with root package name */
    private ZipModel f30663d;

    /* renamed from: e  reason: collision with root package name */
    private char[] f30664e;

    /* renamed from: f  reason: collision with root package name */
    private HeaderWriter f30665f;

    /* renamed from: g  reason: collision with root package name */
    private byte[] f30666g = new byte[4096];

    /* renamed from: h  reason: collision with root package name */
    private int f30667h = -1;

    AbstractAddFileToZipTask(ZipModel zipModel, char[] cArr, HeaderWriter headerWriter, AsyncZipTask.AsyncTaskParameters asyncTaskParameters) {
        super(asyncTaskParameters);
        this.f30663d = zipModel;
        this.f30664e = cArr;
        this.f30665f = headerWriter;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0036, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        r6.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003b, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003c, code lost:
        r4.addSuppressed(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003f, code lost:
        throw r5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void i(java.io.File r4, net.lingala.zip4j.io.outputstream.ZipOutputStream r5, net.lingala.zip4j.model.ZipParameters r6, net.lingala.zip4j.io.outputstream.SplitOutputStream r7, net.lingala.zip4j.progress.ProgressMonitor r8) throws java.io.IOException {
        /*
            r3 = this;
            r5.n(r6)
            boolean r6 = r4.exists()
            r0 = 0
            if (r6 == 0) goto L_0x0040
            boolean r6 = r4.isDirectory()
            if (r6 != 0) goto L_0x0040
            java.io.FileInputStream r6 = new java.io.FileInputStream
            r6.<init>(r4)
        L_0x0015:
            byte[] r1 = r3.f30666g     // Catch:{ all -> 0x002f }
            int r1 = r6.read(r1)     // Catch:{ all -> 0x002f }
            r3.f30667h = r1     // Catch:{ all -> 0x002f }
            r2 = -1
            if (r1 == r2) goto L_0x0031
            byte[] r2 = r3.f30666g     // Catch:{ all -> 0x002f }
            r5.write(r2, r0, r1)     // Catch:{ all -> 0x002f }
            int r1 = r3.f30667h     // Catch:{ all -> 0x002f }
            long r1 = (long) r1     // Catch:{ all -> 0x002f }
            r8.x(r1)     // Catch:{ all -> 0x002f }
            r3.h()     // Catch:{ all -> 0x002f }
            goto L_0x0015
        L_0x002f:
            r4 = move-exception
            goto L_0x0035
        L_0x0031:
            r6.close()
            goto L_0x0040
        L_0x0035:
            throw r4     // Catch:{ all -> 0x0036 }
        L_0x0036:
            r5 = move-exception
            r6.close()     // Catch:{ all -> 0x003b }
            goto L_0x003f
        L_0x003b:
            r6 = move-exception
            r4.addSuppressed(r6)
        L_0x003f:
            throw r5
        L_0x0040:
            r3.o(r5, r7, r4, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.lingala.zip4j.tasks.AbstractAddFileToZipTask.i(java.io.File, net.lingala.zip4j.io.outputstream.ZipOutputStream, net.lingala.zip4j.model.ZipParameters, net.lingala.zip4j.io.outputstream.SplitOutputStream, net.lingala.zip4j.progress.ProgressMonitor):void");
    }

    private boolean k(ZipParameters zipParameters) {
        return ZipParameters.SymbolicLinkAction.INCLUDE_LINK_ONLY.equals(zipParameters.n()) || ZipParameters.SymbolicLinkAction.INCLUDE_LINK_AND_LINKED_FILE.equals(zipParameters.n());
    }

    private void l(File file, ZipOutputStream zipOutputStream, ZipParameters zipParameters, SplitOutputStream splitOutputStream) throws IOException {
        ZipParameters zipParameters2 = new ZipParameters(zipParameters);
        zipParameters2.G(t(zipParameters.k(), file.getName()));
        zipParameters2.A(false);
        zipParameters2.y(CompressionMethod.STORE);
        zipOutputStream.n(zipParameters2);
        zipOutputStream.write(FileUtils.E(file).getBytes());
        o(zipOutputStream, splitOutputStream, file, true);
    }

    private ZipParameters n(ZipParameters zipParameters, File file, ProgressMonitor progressMonitor) throws IOException {
        ZipParameters zipParameters2 = new ZipParameters(zipParameters);
        zipParameters2.I(Zip4jUtil.f(file.lastModified()));
        if (file.isDirectory()) {
            zipParameters2.D(0);
        } else {
            zipParameters2.D(file.length());
        }
        zipParameters2.P(false);
        zipParameters2.I(file.lastModified());
        if (!Zip4jUtil.h(zipParameters.k())) {
            zipParameters2.G(FileUtils.t(file, zipParameters));
        }
        if (file.isDirectory()) {
            zipParameters2.y(CompressionMethod.STORE);
            zipParameters2.B(EncryptionMethod.NONE);
            zipParameters2.A(false);
        } else {
            if (zipParameters2.o() && zipParameters2.f() == EncryptionMethod.ZIP_STANDARD) {
                progressMonitor.p(ProgressMonitor.Task.CALCULATE_CRC);
                zipParameters2.C(CrcUtil.a(file, progressMonitor));
                progressMonitor.p(ProgressMonitor.Task.ADD_ENTRY);
            }
            if (file.length() == 0) {
                zipParameters2.y(CompressionMethod.STORE);
            }
        }
        return zipParameters2;
    }

    private void o(ZipOutputStream zipOutputStream, SplitOutputStream splitOutputStream, File file, boolean z) throws IOException {
        FileHeader b2 = zipOutputStream.b();
        byte[] l2 = FileUtils.l(file);
        if (!z) {
            l2[3] = BitUtils.c(l2[3], 5);
        }
        b2.X(l2);
        u(b2, splitOutputStream);
    }

    private List<File> s(List<File> list, ZipParameters zipParameters, ProgressMonitor progressMonitor, Charset charset) throws ZipException {
        ArrayList arrayList = new ArrayList(list);
        if (!this.f30663d.m().exists()) {
            return arrayList;
        }
        for (File next : list) {
            FileHeader c2 = HeaderUtil.c(this.f30663d, FileUtils.t(next, zipParameters));
            if (c2 != null) {
                if (zipParameters.q()) {
                    progressMonitor.p(ProgressMonitor.Task.REMOVE_ENTRY);
                    r(c2, progressMonitor, charset);
                    h();
                    progressMonitor.p(ProgressMonitor.Task.ADD_ENTRY);
                } else {
                    arrayList.remove(next);
                }
            }
        }
        return arrayList;
    }

    private String t(String str, String str2) {
        if (!str.contains("/")) {
            return str2;
        }
        return str.substring(0, str.lastIndexOf("/") + 1) + str2;
    }

    /* access modifiers changed from: protected */
    public ProgressMonitor.Task e() {
        return ProgressMonitor.Task.ADD_ENTRY;
    }

    /* access modifiers changed from: package-private */
    public void j(List<File> list, ProgressMonitor progressMonitor, ZipParameters zipParameters, Charset charset) throws IOException {
        FileUtils.f(list, zipParameters.n());
        List<File> s = s(list, zipParameters, progressMonitor, charset);
        SplitOutputStream splitOutputStream = new SplitOutputStream(this.f30663d.m(), this.f30663d.g());
        ZipOutputStream q = q(splitOutputStream, charset);
        try {
            for (File next : s) {
                h();
                ZipParameters n2 = n(zipParameters, next, progressMonitor);
                progressMonitor.r(next.getAbsolutePath());
                if (FileUtils.z(next) && k(n2)) {
                    l(next, q, n2, splitOutputStream);
                    if (ZipParameters.SymbolicLinkAction.INCLUDE_LINK_ONLY.equals(n2.n())) {
                    }
                }
                i(next, q, n2, splitOutputStream, progressMonitor);
            }
            if (q != null) {
                q.close();
            }
            splitOutputStream.close();
        } catch (Throwable th) {
            if (q != null) {
                try {
                    q.close();
                } catch (Throwable th2) {
                    try {
                        splitOutputStream.close();
                    } catch (Throwable th3) {
                        r8.addSuppressed(th3);
                    }
                    throw th2;
                }
            }
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    public long m(List<File> list, ZipParameters zipParameters) throws ZipException {
        long j2 = 0;
        for (File next : list) {
            if (next.exists()) {
                j2 += (!zipParameters.o() || zipParameters.f() != EncryptionMethod.ZIP_STANDARD) ? next.length() : next.length() * 2;
                FileHeader c2 = HeaderUtil.c(p(), FileUtils.t(next, zipParameters));
                if (c2 != null) {
                    j2 += p().m().length() - c2.d();
                }
            }
        }
        return j2;
    }

    /* access modifiers changed from: protected */
    public ZipModel p() {
        return this.f30663d;
    }

    /* access modifiers changed from: package-private */
    public ZipOutputStream q(SplitOutputStream splitOutputStream, Charset charset) throws IOException {
        if (this.f30663d.m().exists()) {
            splitOutputStream.k(HeaderUtil.f(this.f30663d));
        }
        return new ZipOutputStream(splitOutputStream, this.f30664e, charset, this.f30663d);
    }

    /* access modifiers changed from: package-private */
    public void r(FileHeader fileHeader, ProgressMonitor progressMonitor, Charset charset) throws ZipException {
        new RemoveFilesFromZipTask(this.f30663d, this.f30665f, new AsyncZipTask.AsyncTaskParameters((ExecutorService) null, false, progressMonitor)).c(new RemoveFilesFromZipTask.RemoveFilesFromZipTaskParameters(Collections.singletonList(fileHeader.k()), charset));
    }

    /* access modifiers changed from: package-private */
    public void u(FileHeader fileHeader, SplitOutputStream splitOutputStream) throws IOException {
        this.f30665f.l(fileHeader, p(), splitOutputStream);
    }

    /* access modifiers changed from: package-private */
    public void v(ZipParameters zipParameters) throws ZipException {
        if (zipParameters == null) {
            throw new ZipException("cannot validate zip parameters");
        } else if (zipParameters.d() != CompressionMethod.STORE && zipParameters.d() != CompressionMethod.DEFLATE) {
            throw new ZipException("unsupported compression type");
        } else if (!zipParameters.o()) {
            zipParameters.B(EncryptionMethod.NONE);
        } else if (zipParameters.f() != EncryptionMethod.NONE) {
            char[] cArr = this.f30664e;
            if (cArr == null || cArr.length <= 0) {
                throw new ZipException("input password is empty or null");
            }
        } else {
            throw new ZipException("Encryption method has to be set, when encrypt files flag is set");
        }
    }
}
