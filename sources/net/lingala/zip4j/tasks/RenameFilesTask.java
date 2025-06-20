package net.lingala.zip4j.tasks;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.headers.HeaderUtil;
import net.lingala.zip4j.headers.HeaderWriter;
import net.lingala.zip4j.io.outputstream.SplitOutputStream;
import net.lingala.zip4j.model.FileHeader;
import net.lingala.zip4j.model.ZipModel;
import net.lingala.zip4j.model.enums.RandomAccessFileMode;
import net.lingala.zip4j.progress.ProgressMonitor;
import net.lingala.zip4j.tasks.AsyncZipTask;
import net.lingala.zip4j.util.RawIO;
import net.lingala.zip4j.util.Zip4jUtil;

public class RenameFilesTask extends AbstractModifyFileTask<RenameFilesTaskParameters> {

    /* renamed from: d  reason: collision with root package name */
    private ZipModel f30697d;

    /* renamed from: e  reason: collision with root package name */
    private HeaderWriter f30698e;

    /* renamed from: f  reason: collision with root package name */
    private RawIO f30699f;

    /* renamed from: g  reason: collision with root package name */
    private Charset f30700g;

    public static class RenameFilesTaskParameters {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public Map<String, String> f30701a;

        public RenameFilesTaskParameters(Map<String, String> map) {
            this.f30701a = map;
        }
    }

    public RenameFilesTask(ZipModel zipModel, HeaderWriter headerWriter, RawIO rawIO, Charset charset, AsyncZipTask.AsyncTaskParameters asyncTaskParameters) {
        super(asyncTaskParameters);
        this.f30697d = zipModel;
        this.f30698e = headerWriter;
        this.f30699f = rawIO;
        this.f30700g = charset;
    }

    private long t(byte[] bArr, FileHeader fileHeader, long j2, long j3, RandomAccessFile randomAccessFile, OutputStream outputStream, ProgressMonitor progressMonitor) throws IOException {
        OutputStream outputStream2 = outputStream;
        ProgressMonitor progressMonitor2 = progressMonitor;
        this.f30699f.s(outputStream2, bArr.length);
        long l2 = j2 + l(randomAccessFile, outputStream, j2, 26, progressMonitor2) + 2;
        outputStream2.write(bArr);
        long l3 = l2 + l(randomAccessFile, outputStream, l2, 2, progressMonitor2) + ((long) fileHeader.l());
        return l3 + l(randomAccessFile, outputStream, l3, j3 - (l3 - j2), progressMonitor);
    }

    private Map<String, String> v(Map<String, String> map) throws ZipException {
        FileHeader c2;
        Object key;
        Object value;
        HashMap hashMap = new HashMap();
        for (Map.Entry next : map.entrySet()) {
            if (Zip4jUtil.h((String) next.getKey()) && (c2 = HeaderUtil.c(this.f30697d, (String) next.getKey())) != null) {
                if (!c2.t() || ((String) next.getValue()).endsWith("/")) {
                    key = next.getKey();
                    value = next.getValue();
                } else {
                    key = next.getKey();
                    value = ((String) next.getValue()) + "/";
                }
                hashMap.put(key, value);
            }
        }
        return hashMap;
    }

    private Map.Entry<String, String> w(FileHeader fileHeader, Map<String, String> map) {
        for (Map.Entry<String, String> next : map.entrySet()) {
            if (fileHeader.k().startsWith(next.getKey())) {
                return next;
            }
        }
        return null;
    }

    private String x(String str, String str2, String str3) throws ZipException {
        if (str3.equals(str2)) {
            return str;
        }
        if (str3.startsWith(str2)) {
            String substring = str3.substring(str2.length());
            return str + substring;
        }
        throw new ZipException("old file name was neither an exact match nor a partial match");
    }

    private void y(List<FileHeader> list, FileHeader fileHeader, String str, byte[] bArr, int i2) throws ZipException {
        FileHeader c2 = HeaderUtil.c(this.f30697d, fileHeader.k());
        if (c2 != null) {
            c2.H(str);
            c2.I(bArr.length);
            long j2 = (long) i2;
            r(list, this.f30697d, c2, j2);
            this.f30697d.e().o(this.f30697d.e().g() + j2);
            if (this.f30697d.p()) {
                this.f30697d.l().p(this.f30697d.l().f() + j2);
                this.f30697d.i().g(this.f30697d.i().d() + j2);
                return;
            }
            return;
        }
        throw new ZipException("could not find any header with name: " + fileHeader.k());
    }

    /* access modifiers changed from: protected */
    public ProgressMonitor.Task e() {
        return ProgressMonitor.Task.RENAME_FILE;
    }

    /* access modifiers changed from: protected */
    /* renamed from: s */
    public long b(RenameFilesTaskParameters renameFilesTaskParameters) {
        return this.f30697d.m().length();
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: protected */
    /* renamed from: u */
    public void d(RenameFilesTaskParameters renameFilesTaskParameters, ProgressMonitor progressMonitor) throws IOException {
        long j2;
        Throwable th;
        List<FileHeader> list;
        Map<String, String> v = v(renameFilesTaskParameters.f30701a);
        if (v.size() != 0) {
            File o = o(this.f30697d.m().getPath());
            boolean z = false;
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile(this.f30697d.m(), RandomAccessFileMode.WRITE.a());
                try {
                    SplitOutputStream splitOutputStream = new SplitOutputStream(o);
                    try {
                        List<FileHeader> k2 = k(this.f30697d.b().b());
                        long j3 = 0;
                        for (FileHeader next : k2) {
                            Map.Entry<String, String> w = w(next, v);
                            progressMonitor.r(next.k());
                            long n2 = n(k2, next, this.f30697d) - splitOutputStream.c();
                            if (w == null) {
                                j3 += l(randomAccessFile, splitOutputStream, j3, n2, progressMonitor);
                                list = k2;
                            } else {
                                String x = x(w.getValue(), w.getKey(), next.k());
                                byte[] bytes = x.getBytes(this.f30700g);
                                int length = bytes.length - next.l();
                                byte[] bArr = bytes;
                                list = k2;
                                th = t(bytes, next, j3, n2, randomAccessFile, splitOutputStream, progressMonitor);
                                y(list, next, x, bArr, length);
                            }
                            h();
                            k2 = list;
                        }
                        this.f30698e.d(this.f30697d, splitOutputStream, this.f30700g);
                        z = true;
                        splitOutputStream.close();
                        randomAccessFile.close();
                        j(true, this.f30697d.m(), o);
                    } catch (Throwable th2) {
                        Throwable th3 = th2;
                        splitOutputStream.close();
                        throw th3;
                    }
                } catch (Throwable th4) {
                    randomAccessFile.close();
                    throw j2;
                } finally {
                    j2 = th4;
                }
            } catch (Throwable th5) {
                j(z, this.f30697d.m(), o);
                throw th5;
            }
        }
    }
}
