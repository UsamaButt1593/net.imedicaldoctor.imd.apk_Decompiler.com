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
import net.lingala.zip4j.util.FileUtils;

public class AddFolderToZipTask extends AbstractAddFileToZipTask<AddFolderToZipTaskParameters> {

    public static class AddFolderToZipTaskParameters extends AbstractZipTaskParameters {
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public File f30673b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public ZipParameters f30674c;

        public AddFolderToZipTaskParameters(File file, ZipParameters zipParameters, Charset charset) {
            super(charset);
            this.f30673b = file;
            this.f30674c = zipParameters;
        }
    }

    public AddFolderToZipTask(ZipModel zipModel, char[] cArr, HeaderWriter headerWriter, AsyncZipTask.AsyncTaskParameters asyncTaskParameters) {
        super(zipModel, cArr, headerWriter, asyncTaskParameters);
    }

    private List<File> y(AddFolderToZipTaskParameters addFolderToZipTaskParameters) throws ZipException {
        List<File> p = FileUtils.p(addFolderToZipTaskParameters.f30673b, addFolderToZipTaskParameters.f30674c.r(), addFolderToZipTaskParameters.f30674c.s(), addFolderToZipTaskParameters.f30674c.i());
        if (addFolderToZipTaskParameters.f30674c.p()) {
            p.add(addFolderToZipTaskParameters.f30673b);
        }
        return p;
    }

    private void z(AddFolderToZipTaskParameters addFolderToZipTaskParameters) throws IOException {
        File b2 = addFolderToZipTaskParameters.f30673b;
        if (addFolderToZipTaskParameters.f30674c.p() && b2.getCanonicalFile().getParentFile() != null) {
            b2 = b2.getCanonicalFile().getParentFile();
        }
        addFolderToZipTaskParameters.f30674c.z(b2.getCanonicalPath());
    }

    /* access modifiers changed from: protected */
    /* renamed from: w */
    public long b(AddFolderToZipTaskParameters addFolderToZipTaskParameters) throws ZipException {
        List<File> p = FileUtils.p(addFolderToZipTaskParameters.f30673b, addFolderToZipTaskParameters.f30674c.r(), addFolderToZipTaskParameters.f30674c.s(), addFolderToZipTaskParameters.f30674c.i());
        if (addFolderToZipTaskParameters.f30674c.p()) {
            p.add(addFolderToZipTaskParameters.f30673b);
        }
        return m(p, addFolderToZipTaskParameters.f30674c);
    }

    /* access modifiers changed from: protected */
    /* renamed from: x */
    public void d(AddFolderToZipTaskParameters addFolderToZipTaskParameters, ProgressMonitor progressMonitor) throws IOException {
        List<File> y = y(addFolderToZipTaskParameters);
        z(addFolderToZipTaskParameters);
        j(y, progressMonitor, addFolderToZipTaskParameters.f30674c, addFolderToZipTaskParameters.f30670a);
    }
}
