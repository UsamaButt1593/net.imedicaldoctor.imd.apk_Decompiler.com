package net.lingala.zip4j.tasks;

import java.io.IOException;
import java.nio.charset.Charset;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.headers.HeaderWriter;
import net.lingala.zip4j.io.outputstream.SplitOutputStream;
import net.lingala.zip4j.model.EndOfCentralDirectoryRecord;
import net.lingala.zip4j.model.ZipModel;
import net.lingala.zip4j.progress.ProgressMonitor;
import net.lingala.zip4j.tasks.AsyncZipTask;

public class SetCommentTask extends AsyncZipTask<SetCommentTaskTaskParameters> {

    /* renamed from: d  reason: collision with root package name */
    private ZipModel f30702d;

    public static class SetCommentTaskTaskParameters extends AbstractZipTaskParameters {
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public String f30703b;

        public SetCommentTaskTaskParameters(String str, Charset charset) {
            super(charset);
            this.f30703b = str;
        }
    }

    public SetCommentTask(ZipModel zipModel, AsyncZipTask.AsyncTaskParameters asyncTaskParameters) {
        super(asyncTaskParameters);
        this.f30702d = zipModel;
    }

    /* access modifiers changed from: protected */
    public ProgressMonitor.Task e() {
        return ProgressMonitor.Task.SET_COMMENT;
    }

    /* access modifiers changed from: protected */
    /* renamed from: i */
    public long b(SetCommentTaskTaskParameters setCommentTaskTaskParameters) {
        return 0;
    }

    /* access modifiers changed from: protected */
    /* renamed from: j */
    public void d(SetCommentTaskTaskParameters setCommentTaskTaskParameters, ProgressMonitor progressMonitor) throws IOException {
        if (setCommentTaskTaskParameters.f30703b != null) {
            EndOfCentralDirectoryRecord e2 = this.f30702d.e();
            e2.k(setCommentTaskTaskParameters.f30703b);
            SplitOutputStream splitOutputStream = new SplitOutputStream(this.f30702d.m());
            try {
                splitOutputStream.k(this.f30702d.p() ? this.f30702d.l().f() : e2.g());
                new HeaderWriter().e(this.f30702d, splitOutputStream, setCommentTaskTaskParameters.f30670a);
                splitOutputStream.close();
            } catch (Throwable th) {
                try {
                    splitOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } else {
            throw new ZipException("comment is null, cannot update Zip file with comment");
        }
    }
}
