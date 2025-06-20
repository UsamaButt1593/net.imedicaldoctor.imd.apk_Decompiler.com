package net.lingala.zip4j.tasks;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.headers.HeaderUtil;
import net.lingala.zip4j.headers.HeaderWriter;
import net.lingala.zip4j.io.outputstream.SplitOutputStream;
import net.lingala.zip4j.io.outputstream.ZipOutputStream;
import net.lingala.zip4j.model.FileHeader;
import net.lingala.zip4j.model.ZipModel;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.model.enums.CompressionMethod;
import net.lingala.zip4j.progress.ProgressMonitor;
import net.lingala.zip4j.tasks.AsyncZipTask;
import net.lingala.zip4j.util.Zip4jUtil;

public class AddStreamToZipTask extends AbstractAddFileToZipTask<AddStreamToZipTaskParameters> {

    public static class AddStreamToZipTaskParameters extends AbstractZipTaskParameters {
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public InputStream f30675b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public ZipParameters f30676c;

        public AddStreamToZipTaskParameters(InputStream inputStream, ZipParameters zipParameters, Charset charset) {
            super(charset);
            this.f30675b = inputStream;
            this.f30676c = zipParameters;
        }
    }

    public AddStreamToZipTask(ZipModel zipModel, char[] cArr, HeaderWriter headerWriter, AsyncZipTask.AsyncTaskParameters asyncTaskParameters) {
        super(zipModel, cArr, headerWriter, asyncTaskParameters);
    }

    private void y(ZipModel zipModel, Charset charset, String str, ProgressMonitor progressMonitor) throws ZipException {
        FileHeader c2 = HeaderUtil.c(zipModel, str);
        if (c2 != null) {
            r(c2, progressMonitor, charset);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: w */
    public long b(AddStreamToZipTaskParameters addStreamToZipTaskParameters) {
        return 0;
    }

    /* access modifiers changed from: protected */
    /* renamed from: x */
    public void d(AddStreamToZipTaskParameters addStreamToZipTaskParameters, ProgressMonitor progressMonitor) throws IOException {
        v(addStreamToZipTaskParameters.f30676c);
        if (Zip4jUtil.h(addStreamToZipTaskParameters.f30676c.k())) {
            y(p(), addStreamToZipTaskParameters.f30670a, addStreamToZipTaskParameters.f30676c.k(), progressMonitor);
            addStreamToZipTaskParameters.f30676c.P(true);
            if (addStreamToZipTaskParameters.f30676c.d().equals(CompressionMethod.STORE)) {
                addStreamToZipTaskParameters.f30676c.D(0);
            }
            SplitOutputStream splitOutputStream = new SplitOutputStream(p().m(), p().g());
            ZipOutputStream q = q(splitOutputStream, addStreamToZipTaskParameters.f30670a);
            try {
                byte[] bArr = new byte[4096];
                ZipParameters a2 = addStreamToZipTaskParameters.f30676c;
                q.n(a2);
                if (!a2.k().endsWith("/") && !a2.k().endsWith("\\")) {
                    while (true) {
                        int read = addStreamToZipTaskParameters.f30675b.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        q.write(bArr, 0, read);
                    }
                }
                FileHeader b2 = q.b();
                if (b2.e().equals(CompressionMethod.STORE)) {
                    u(b2, splitOutputStream);
                }
                q.close();
                splitOutputStream.close();
            } catch (Throwable th) {
                if (q != null) {
                    try {
                        q.close();
                    } catch (Throwable th2) {
                        try {
                            splitOutputStream.close();
                        } catch (Throwable th3) {
                            r6.addSuppressed(th3);
                        }
                        throw th2;
                    }
                }
                throw th;
            }
        } else {
            throw new ZipException("fileNameInZip has to be set in zipParameters when adding stream");
        }
    }
}
