package net.lingala.zip4j.tasks;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.List;
import net.lingala.zip4j.headers.HeaderUtil;
import net.lingala.zip4j.io.inputstream.SplitInputStream;
import net.lingala.zip4j.io.inputstream.ZipInputStream;
import net.lingala.zip4j.model.FileHeader;
import net.lingala.zip4j.model.ZipModel;
import net.lingala.zip4j.tasks.AsyncZipTask;
import net.lingala.zip4j.util.UnzipUtil;
import net.lingala.zip4j.util.Zip4jUtil;

public class ExtractFileTask extends AbstractExtractFileTask<ExtractFileTaskParameters> {

    /* renamed from: f  reason: collision with root package name */
    private char[] f30686f;

    /* renamed from: g  reason: collision with root package name */
    private SplitInputStream f30687g;

    public static class ExtractFileTaskParameters extends AbstractZipTaskParameters {
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public String f30688b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public FileHeader f30689c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public String f30690d;

        public ExtractFileTaskParameters(String str, FileHeader fileHeader, String str2, Charset charset) {
            super(charset);
            this.f30688b = str;
            this.f30689c = fileHeader;
            this.f30690d = str2;
        }
    }

    public ExtractFileTask(ZipModel zipModel, char[] cArr, AsyncZipTask.AsyncTaskParameters asyncTaskParameters) {
        super(zipModel, asyncTaskParameters);
        this.f30686f = cArr;
    }

    private ZipInputStream t(FileHeader fileHeader, Charset charset) throws IOException {
        SplitInputStream b2 = UnzipUtil.b(n());
        this.f30687g = b2;
        b2.d(fileHeader);
        return new ZipInputStream(this.f30687g, this.f30686f, charset);
    }

    private String u(String str, FileHeader fileHeader, FileHeader fileHeader2) {
        if (!Zip4jUtil.h(str) || !fileHeader.t()) {
            return str;
        }
        String str2 = "/";
        if (str.endsWith(str2)) {
            str2 = "";
        }
        String k2 = fileHeader2.k();
        String k3 = fileHeader.k();
        return k2.replaceFirst(k3, str + str2);
    }

    private List<FileHeader> w(FileHeader fileHeader) {
        return !fileHeader.t() ? Collections.singletonList(fileHeader) : HeaderUtil.e(n().b().b(), fileHeader);
    }

    /* access modifiers changed from: protected */
    /* renamed from: s */
    public long b(ExtractFileTaskParameters extractFileTaskParameters) {
        return HeaderUtil.g(w(extractFileTaskParameters.f30689c));
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x004d, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004e, code lost:
        if (r0 != null) goto L_0x0050;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0058, code lost:
        throw r10;
     */
    /* renamed from: v */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void d(net.lingala.zip4j.tasks.ExtractFileTask.ExtractFileTaskParameters r9, net.lingala.zip4j.progress.ProgressMonitor r10) throws java.io.IOException {
        /*
            r8 = this;
            net.lingala.zip4j.model.FileHeader r0 = r9.f30689c     // Catch:{ all -> 0x0042 }
            java.nio.charset.Charset r1 = r9.f30670a     // Catch:{ all -> 0x0042 }
            net.lingala.zip4j.io.inputstream.ZipInputStream r0 = r8.t(r0, r1)     // Catch:{ all -> 0x0042 }
            net.lingala.zip4j.model.FileHeader r1 = r9.f30689c     // Catch:{ all -> 0x003a }
            java.util.List r1 = r8.w(r1)     // Catch:{ all -> 0x003a }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x003a }
        L_0x0016:
            boolean r2 = r1.hasNext()     // Catch:{ all -> 0x003a }
            if (r2 == 0) goto L_0x003c
            java.lang.Object r2 = r1.next()     // Catch:{ all -> 0x003a }
            r4 = r2
            net.lingala.zip4j.model.FileHeader r4 = (net.lingala.zip4j.model.FileHeader) r4     // Catch:{ all -> 0x003a }
            java.lang.String r2 = r9.f30690d     // Catch:{ all -> 0x003a }
            net.lingala.zip4j.model.FileHeader r3 = r9.f30689c     // Catch:{ all -> 0x003a }
            java.lang.String r6 = r8.u(r2, r3, r4)     // Catch:{ all -> 0x003a }
            java.lang.String r5 = r9.f30688b     // Catch:{ all -> 0x003a }
            r2 = r8
            r3 = r0
            r7 = r10
            r2.l(r3, r4, r5, r6, r7)     // Catch:{ all -> 0x003a }
            goto L_0x0016
        L_0x003a:
            r9 = move-exception
            goto L_0x004c
        L_0x003c:
            if (r0 == 0) goto L_0x0044
            r0.close()     // Catch:{ all -> 0x0042 }
            goto L_0x0044
        L_0x0042:
            r9 = move-exception
            goto L_0x0059
        L_0x0044:
            net.lingala.zip4j.io.inputstream.SplitInputStream r9 = r8.f30687g
            if (r9 == 0) goto L_0x004b
            r9.close()
        L_0x004b:
            return
        L_0x004c:
            throw r9     // Catch:{ all -> 0x004d }
        L_0x004d:
            r10 = move-exception
            if (r0 == 0) goto L_0x0058
            r0.close()     // Catch:{ all -> 0x0054 }
            goto L_0x0058
        L_0x0054:
            r0 = move-exception
            r9.addSuppressed(r0)     // Catch:{ all -> 0x0042 }
        L_0x0058:
            throw r10     // Catch:{ all -> 0x0042 }
        L_0x0059:
            net.lingala.zip4j.io.inputstream.SplitInputStream r10 = r8.f30687g
            if (r10 == 0) goto L_0x0060
            r10.close()
        L_0x0060:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: net.lingala.zip4j.tasks.ExtractFileTask.d(net.lingala.zip4j.tasks.ExtractFileTask$ExtractFileTaskParameters, net.lingala.zip4j.progress.ProgressMonitor):void");
    }
}
