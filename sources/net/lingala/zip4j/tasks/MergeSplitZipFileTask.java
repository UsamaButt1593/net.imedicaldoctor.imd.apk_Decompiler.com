package net.lingala.zip4j.tasks;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.util.List;
import net.lingala.zip4j.headers.HeaderWriter;
import net.lingala.zip4j.model.EndOfCentralDirectoryRecord;
import net.lingala.zip4j.model.FileHeader;
import net.lingala.zip4j.model.Zip64EndOfCentralDirectoryLocator;
import net.lingala.zip4j.model.Zip64EndOfCentralDirectoryRecord;
import net.lingala.zip4j.model.ZipModel;
import net.lingala.zip4j.model.enums.RandomAccessFileMode;
import net.lingala.zip4j.progress.ProgressMonitor;
import net.lingala.zip4j.tasks.AsyncZipTask;
import net.lingala.zip4j.util.RawIO;

public class MergeSplitZipFileTask extends AsyncZipTask<MergeSplitZipFileTaskParameters> {

    /* renamed from: d  reason: collision with root package name */
    private ZipModel f30691d;

    /* renamed from: e  reason: collision with root package name */
    private RawIO f30692e = new RawIO();

    public static class MergeSplitZipFileTaskParameters extends AbstractZipTaskParameters {
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public File f30693b;

        public MergeSplitZipFileTaskParameters(File file, Charset charset) {
            super(charset);
            this.f30693b = file;
        }
    }

    public MergeSplitZipFileTask(ZipModel zipModel, AsyncZipTask.AsyncTaskParameters asyncTaskParameters) {
        super(asyncTaskParameters);
        this.f30691d = zipModel;
    }

    private RandomAccessFile j(ZipModel zipModel, int i2) throws FileNotFoundException {
        return new RandomAccessFile(l(zipModel, i2), RandomAccessFileMode.READ.a());
    }

    private File l(ZipModel zipModel, int i2) {
        if (i2 == zipModel.e().d()) {
            return zipModel.m();
        }
        String str = i2 >= 9 ? ".z" : ".z0";
        String path = zipModel.m().getPath();
        return new File(zipModel.m().getPath().substring(0, path.lastIndexOf(".")) + str + (i2 + 1));
    }

    private void m(List<FileHeader> list, long j2, int i2, int i3) {
        for (FileHeader next : list) {
            if (next.P() == i2) {
                next.b0((next.U() + j2) - ((long) i3));
                next.W(0);
            }
        }
    }

    private void n(ZipModel zipModel, long j2, OutputStream outputStream, Charset charset) throws IOException, CloneNotSupportedException {
        ZipModel zipModel2 = (ZipModel) zipModel.clone();
        zipModel2.e().o(j2);
        r(zipModel2, j2);
        new HeaderWriter().e(zipModel2, outputStream, charset);
    }

    private void o(ZipModel zipModel) {
        int size = zipModel.b().b().size();
        EndOfCentralDirectoryRecord e2 = zipModel.e();
        e2.l(0);
        e2.m(0);
        e2.q(size);
        e2.r(size);
    }

    private void p(ZipModel zipModel, long j2) {
        if (zipModel.i() != null) {
            Zip64EndOfCentralDirectoryLocator i2 = zipModel.i();
            i2.f(0);
            i2.g(i2.d() + j2);
            i2.h(1);
        }
    }

    private void q(ZipModel zipModel, long j2) {
        if (zipModel.l() != null) {
            Zip64EndOfCentralDirectoryRecord l2 = zipModel.l();
            l2.n(0);
            l2.o(0);
            l2.t((long) zipModel.e().i());
            l2.p(l2.f() + j2);
        }
    }

    private void r(ZipModel zipModel, long j2) {
        zipModel.x(false);
        o(zipModel);
        if (zipModel.p()) {
            p(zipModel, j2);
            q(zipModel, j2);
        }
    }

    /* access modifiers changed from: protected */
    public ProgressMonitor.Task e() {
        return ProgressMonitor.Task.MERGE_ZIP_FILES;
    }

    /* access modifiers changed from: protected */
    /* renamed from: i */
    public long b(MergeSplitZipFileTaskParameters mergeSplitZipFileTaskParameters) {
        long j2 = 0;
        if (!this.f30691d.o()) {
            return 0;
        }
        for (int i2 = 0; i2 <= this.f30691d.e().d(); i2++) {
            j2 += l(this.f30691d, i2).length();
        }
        return j2;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0058 A[Catch:{ all -> 0x004d }] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0083 A[Catch:{ all -> 0x00a2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0085 A[Catch:{ all -> 0x00a2 }] */
    /* renamed from: k */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void d(net.lingala.zip4j.tasks.MergeSplitZipFileTask.MergeSplitZipFileTaskParameters r24, net.lingala.zip4j.progress.ProgressMonitor r25) throws java.io.IOException {
        /*
            r23 = this;
            r7 = r23
            net.lingala.zip4j.model.ZipModel r0 = r7.f30691d
            boolean r0 = r0.o()
            if (r0 == 0) goto L_0x00e8
            java.io.FileOutputStream r15 = new java.io.FileOutputStream     // Catch:{ CloneNotSupportedException -> 0x00cb }
            java.io.File r0 = r24.f30693b     // Catch:{ CloneNotSupportedException -> 0x00cb }
            r15.<init>(r0)     // Catch:{ CloneNotSupportedException -> 0x00cb }
            net.lingala.zip4j.model.ZipModel r0 = r7.f30691d     // Catch:{ all -> 0x009f }
            net.lingala.zip4j.model.EndOfCentralDirectoryRecord r0 = r0.e()     // Catch:{ all -> 0x009f }
            int r0 = r0.d()     // Catch:{ all -> 0x009f }
            if (r0 <= 0) goto L_0x00cd
            r16 = 0
            r5 = 0
            r3 = r5
            r1 = 0
            r2 = 0
        L_0x0026:
            if (r2 > r0) goto L_0x00b8
            net.lingala.zip4j.model.ZipModel r8 = r7.f30691d     // Catch:{ all -> 0x009f }
            java.io.RandomAccessFile r14 = r7.j(r8, r2)     // Catch:{ all -> 0x009f }
            long r8 = r14.length()     // Catch:{ all -> 0x00a5 }
            if (r2 != 0) goto L_0x0053
            net.lingala.zip4j.util.RawIO r10 = r7.f30692e     // Catch:{ all -> 0x004d }
            int r10 = r10.c(r14)     // Catch:{ all -> 0x004d }
            long r10 = (long) r10     // Catch:{ all -> 0x004d }
            net.lingala.zip4j.headers.HeaderSignature r12 = net.lingala.zip4j.headers.HeaderSignature.SPLIT_ZIP     // Catch:{ all -> 0x004d }
            long r12 = r12.a()     // Catch:{ all -> 0x004d }
            int r17 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r17 != 0) goto L_0x0049
            r1 = 4
            r17 = 4
            goto L_0x0056
        L_0x0049:
            r14.seek(r5)     // Catch:{ all -> 0x004d }
            goto L_0x0053
        L_0x004d:
            r0 = move-exception
            r1 = r0
            r22 = r14
            goto L_0x00a9
        L_0x0053:
            r17 = r1
            r1 = 0
        L_0x0056:
            if (r2 != r0) goto L_0x0062
            net.lingala.zip4j.model.ZipModel r8 = r7.f30691d     // Catch:{ all -> 0x004d }
            net.lingala.zip4j.model.EndOfCentralDirectoryRecord r8 = r8.e()     // Catch:{ all -> 0x004d }
            long r8 = r8.g()     // Catch:{ all -> 0x004d }
        L_0x0062:
            r18 = r8
            long r12 = (long) r1
            r8 = r14
            r9 = r15
            r10 = r12
            r20 = r12
            r12 = r18
            r22 = r14
            r14 = r25
            net.lingala.zip4j.util.FileUtils.h(r8, r9, r10, r12, r14)     // Catch:{ all -> 0x00a2 }
            long r18 = r18 - r20
            long r8 = r3 + r18
            net.lingala.zip4j.model.ZipModel r1 = r7.f30691d     // Catch:{ all -> 0x00a2 }
            net.lingala.zip4j.model.CentralDirectory r1 = r1.b()     // Catch:{ all -> 0x00a2 }
            java.util.List r3 = r1.b()     // Catch:{ all -> 0x00a2 }
            if (r2 != 0) goto L_0x0085
            r10 = r5
            goto L_0x0086
        L_0x0085:
            r10 = r8
        L_0x0086:
            r1 = r23
            r12 = r2
            r2 = r3
            r3 = r10
            r10 = r5
            r5 = r12
            r6 = r17
            r1.m(r2, r3, r5, r6)     // Catch:{ all -> 0x00a2 }
            r23.h()     // Catch:{ all -> 0x00a2 }
            r22.close()     // Catch:{ all -> 0x009f }
            int r2 = r12 + 1
            r3 = r8
            r5 = r10
            r1 = r17
            goto L_0x0026
        L_0x009f:
            r0 = move-exception
            r1 = r0
            goto L_0x00d5
        L_0x00a2:
            r0 = move-exception
        L_0x00a3:
            r1 = r0
            goto L_0x00a9
        L_0x00a5:
            r0 = move-exception
            r22 = r14
            goto L_0x00a3
        L_0x00a9:
            throw r1     // Catch:{ all -> 0x00aa }
        L_0x00aa:
            r0 = move-exception
            r2 = r0
            if (r22 == 0) goto L_0x00b7
            r22.close()     // Catch:{ all -> 0x00b2 }
            goto L_0x00b7
        L_0x00b2:
            r0 = move-exception
            r3 = r0
            r1.addSuppressed(r3)     // Catch:{ all -> 0x009f }
        L_0x00b7:
            throw r2     // Catch:{ all -> 0x009f }
        L_0x00b8:
            net.lingala.zip4j.model.ZipModel r2 = r7.f30691d     // Catch:{ all -> 0x009f }
            r0 = r24
            java.nio.charset.Charset r6 = r0.f30670a     // Catch:{ all -> 0x009f }
            r1 = r23
            r5 = r15
            r1.n(r2, r3, r5, r6)     // Catch:{ all -> 0x009f }
            r25.a()     // Catch:{ all -> 0x009f }
            r15.close()     // Catch:{ CloneNotSupportedException -> 0x00cb }
            return
        L_0x00cb:
            r0 = move-exception
            goto L_0x00e2
        L_0x00cd:
            net.lingala.zip4j.exception.ZipException r0 = new net.lingala.zip4j.exception.ZipException     // Catch:{ all -> 0x009f }
            java.lang.String r1 = "zip archive not a split zip file"
            r0.<init>((java.lang.String) r1)     // Catch:{ all -> 0x009f }
            throw r0     // Catch:{ all -> 0x009f }
        L_0x00d5:
            throw r1     // Catch:{ all -> 0x00d6 }
        L_0x00d6:
            r0 = move-exception
            r2 = r0
            r15.close()     // Catch:{ all -> 0x00dc }
            goto L_0x00e1
        L_0x00dc:
            r0 = move-exception
            r3 = r0
            r1.addSuppressed(r3)     // Catch:{ CloneNotSupportedException -> 0x00cb }
        L_0x00e1:
            throw r2     // Catch:{ CloneNotSupportedException -> 0x00cb }
        L_0x00e2:
            net.lingala.zip4j.exception.ZipException r1 = new net.lingala.zip4j.exception.ZipException
            r1.<init>((java.lang.Exception) r0)
            throw r1
        L_0x00e8:
            net.lingala.zip4j.exception.ZipException r0 = new net.lingala.zip4j.exception.ZipException
            java.lang.String r1 = "archive not a split zip file"
            r0.<init>((java.lang.String) r1)
            r1 = r25
            r1.b(r0)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.lingala.zip4j.tasks.MergeSplitZipFileTask.d(net.lingala.zip4j.tasks.MergeSplitZipFileTask$MergeSplitZipFileTaskParameters, net.lingala.zip4j.progress.ProgressMonitor):void");
    }
}
