package net.lingala.zip4j.tasks;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.headers.HeaderWriter;
import net.lingala.zip4j.model.ZipModel;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.progress.ProgressMonitor;
import net.lingala.zip4j.tasks.AsyncZipTask;

public class AddFilesToZipTask extends AbstractAddFileToZipTask<AddFilesToZipTaskParameters> {

    public static class AddFilesToZipTaskParameters extends AbstractZipTaskParameters {
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public List<File> f30671b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public ZipParameters f30672c;

        public AddFilesToZipTaskParameters(List<File> list, ZipParameters zipParameters, Charset charset) {
            super(charset);
            this.f30671b = list;
            this.f30672c = zipParameters;
        }
    }

    public AddFilesToZipTask(ZipModel zipModel, char[] cArr, HeaderWriter headerWriter, AsyncZipTask.AsyncTaskParameters asyncTaskParameters) {
        super(zipModel, cArr, headerWriter, asyncTaskParameters);
    }

    /* access modifiers changed from: protected */
    public ProgressMonitor.Task e() {
        return super.e();
    }

    /* access modifiers changed from: protected */
    /* renamed from: w */
    public long b(AddFilesToZipTaskParameters addFilesToZipTaskParameters) throws ZipException {
        return m(addFilesToZipTaskParameters.f30671b, addFilesToZipTaskParameters.f30672c);
    }

    /* access modifiers changed from: protected */
    /* renamed from: x */
    public void d(AddFilesToZipTaskParameters addFilesToZipTaskParameters, ProgressMonitor progressMonitor) throws IOException {
        v(addFilesToZipTaskParameters.f30672c);
        j(addFilesToZipTaskParameters.f30671b, progressMonitor, addFilesToZipTaskParameters.f30672c, addFilesToZipTaskParameters.f30670a);
    }
}
