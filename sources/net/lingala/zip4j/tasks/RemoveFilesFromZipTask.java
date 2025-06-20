package net.lingala.zip4j.tasks;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.headers.HeaderUtil;
import net.lingala.zip4j.headers.HeaderWriter;
import net.lingala.zip4j.io.outputstream.SplitOutputStream;
import net.lingala.zip4j.model.EndOfCentralDirectoryRecord;
import net.lingala.zip4j.model.FileHeader;
import net.lingala.zip4j.model.ZipModel;
import net.lingala.zip4j.model.enums.RandomAccessFileMode;
import net.lingala.zip4j.progress.ProgressMonitor;
import net.lingala.zip4j.tasks.AsyncZipTask;

public class RemoveFilesFromZipTask extends AbstractModifyFileTask<RemoveFilesFromZipTaskParameters> {

    /* renamed from: d  reason: collision with root package name */
    private ZipModel f30694d;

    /* renamed from: e  reason: collision with root package name */
    private HeaderWriter f30695e;

    public static class RemoveFilesFromZipTaskParameters extends AbstractZipTaskParameters {
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public List<String> f30696b;

        public RemoveFilesFromZipTaskParameters(List<String> list, Charset charset) {
            super(charset);
            this.f30696b = list;
        }
    }

    public RemoveFilesFromZipTask(ZipModel zipModel, HeaderWriter headerWriter, AsyncZipTask.AsyncTaskParameters asyncTaskParameters) {
        super(asyncTaskParameters);
        this.f30694d = zipModel;
        this.f30695e = headerWriter;
    }

    private List<String> u(List<String> list) throws ZipException {
        ArrayList arrayList = new ArrayList();
        for (String next : list) {
            if (HeaderUtil.c(this.f30694d, next) != null) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    private long v(long j2) {
        if (j2 != Long.MIN_VALUE) {
            return -j2;
        }
        throw new ArithmeticException("long overflow");
    }

    private boolean w(FileHeader fileHeader, List<String> list) {
        for (String startsWith : list) {
            if (fileHeader.k().startsWith(startsWith)) {
                return true;
            }
        }
        return false;
    }

    private void x(List<FileHeader> list, FileHeader fileHeader, long j2) throws ZipException {
        r(list, this.f30694d, fileHeader, v(j2));
        EndOfCentralDirectoryRecord e2 = this.f30694d.e();
        e2.o(e2.g() - j2);
        e2.q(e2.i() - 1);
        if (e2.j() > 0) {
            e2.r(e2.j() - 1);
        }
        if (this.f30694d.p()) {
            this.f30694d.l().p(this.f30694d.l().f() - j2);
            this.f30694d.l().t(this.f30694d.l().i() - 1);
            this.f30694d.i().g(this.f30694d.i().d() - j2);
        }
    }

    /* access modifiers changed from: protected */
    public ProgressMonitor.Task e() {
        return ProgressMonitor.Task.REMOVE_ENTRY;
    }

    /* access modifiers changed from: protected */
    /* renamed from: s */
    public long b(RemoveFilesFromZipTaskParameters removeFilesFromZipTaskParameters) {
        return this.f30694d.m().length();
    }

    /* access modifiers changed from: protected */
    /* renamed from: t */
    public void d(RemoveFilesFromZipTaskParameters removeFilesFromZipTaskParameters, ProgressMonitor progressMonitor) throws IOException {
        Throwable th;
        Throwable th2;
        if (!this.f30694d.o()) {
            List<String> u = u(removeFilesFromZipTaskParameters.f30696b);
            if (!u.isEmpty()) {
                File o = o(this.f30694d.m().getPath());
                boolean z = false;
                try {
                    SplitOutputStream splitOutputStream = new SplitOutputStream(o);
                    try {
                        RandomAccessFile randomAccessFile = new RandomAccessFile(this.f30694d.m(), RandomAccessFileMode.READ.a());
                        try {
                            List<FileHeader> k2 = k(this.f30694d.b().b());
                            long j2 = 0;
                            for (FileHeader next : k2) {
                                long n2 = n(k2, next, this.f30694d) - splitOutputStream.c();
                                if (w(next, u)) {
                                    x(k2, next, n2);
                                    if (this.f30694d.b().b().remove(next)) {
                                        j2 += n2;
                                    } else {
                                        throw new ZipException("Could not remove entry from list of central directory headers");
                                    }
                                } else {
                                    j2 += super.l(randomAccessFile, splitOutputStream, j2, n2, progressMonitor);
                                }
                                h();
                            }
                            this.f30695e.d(this.f30694d, splitOutputStream, removeFilesFromZipTaskParameters.f30670a);
                            z = true;
                            randomAccessFile.close();
                            splitOutputStream.close();
                            j(true, this.f30694d.m(), o);
                        } catch (Throwable th3) {
                            randomAccessFile.close();
                            throw th;
                        }
                    } catch (Throwable th32) {
                        splitOutputStream.close();
                        throw th;
                    } finally {
                        th = th32;
                    }
                } catch (Throwable th4) {
                    j(z, this.f30694d.m(), o);
                    throw th4;
                }
            }
        } else {
            throw new ZipException("This is a split archive. Zip file format does not allow updating split/spanned files");
        }
    }
}
