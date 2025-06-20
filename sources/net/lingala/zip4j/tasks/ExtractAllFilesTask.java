package net.lingala.zip4j.tasks;

import java.io.IOException;
import java.nio.charset.Charset;
import net.lingala.zip4j.headers.HeaderUtil;
import net.lingala.zip4j.io.inputstream.SplitInputStream;
import net.lingala.zip4j.io.inputstream.ZipInputStream;
import net.lingala.zip4j.model.FileHeader;
import net.lingala.zip4j.model.ZipModel;
import net.lingala.zip4j.progress.ProgressMonitor;
import net.lingala.zip4j.tasks.AsyncZipTask;
import net.lingala.zip4j.util.UnzipUtil;

public class ExtractAllFilesTask extends AbstractExtractFileTask<ExtractAllFilesTaskParameters> {

    /* renamed from: f  reason: collision with root package name */
    private char[] f30683f;

    /* renamed from: g  reason: collision with root package name */
    private SplitInputStream f30684g;

    public static class ExtractAllFilesTaskParameters extends AbstractZipTaskParameters {
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public String f30685b;

        public ExtractAllFilesTaskParameters(String str, Charset charset) {
            super(charset);
            this.f30685b = str;
        }
    }

    public ExtractAllFilesTask(ZipModel zipModel, char[] cArr, AsyncZipTask.AsyncTaskParameters asyncTaskParameters) {
        super(zipModel, asyncTaskParameters);
        this.f30683f = cArr;
    }

    private FileHeader u(ZipModel zipModel) {
        if (zipModel.b() == null || zipModel.b().b() == null || zipModel.b().b().size() == 0) {
            return null;
        }
        return zipModel.b().b().get(0);
    }

    private ZipInputStream v(Charset charset) throws IOException {
        this.f30684g = UnzipUtil.b(n());
        FileHeader u = u(n());
        if (u != null) {
            this.f30684g.d(u);
        }
        return new ZipInputStream(this.f30684g, this.f30683f, charset);
    }

    /* access modifiers changed from: protected */
    /* renamed from: s */
    public long b(ExtractAllFilesTaskParameters extractAllFilesTaskParameters) {
        return HeaderUtil.g(n().b().b());
    }

    /* access modifiers changed from: protected */
    /* renamed from: t */
    public void d(ExtractAllFilesTaskParameters extractAllFilesTaskParameters, ProgressMonitor progressMonitor) throws IOException {
        try {
            ZipInputStream v = v(extractAllFilesTaskParameters.f30670a);
            try {
                for (FileHeader next : n().b().b()) {
                    if (next.k().startsWith("__MACOSX")) {
                        progressMonitor.x(next.p());
                    } else {
                        this.f30684g.d(next);
                        l(v, next, extractAllFilesTaskParameters.f30685b, (String) null, progressMonitor);
                        h();
                    }
                }
                if (v != null) {
                    v.close();
                }
                SplitInputStream splitInputStream = this.f30684g;
                if (splitInputStream != null) {
                    splitInputStream.close();
                }
            } catch (Throwable th) {
                if (v != null) {
                    v.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            SplitInputStream splitInputStream2 = this.f30684g;
            if (splitInputStream2 != null) {
                splitInputStream2.close();
            }
            throw th2;
        }
    }
}
