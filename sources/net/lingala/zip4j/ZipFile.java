package net.lingala.zip4j;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.headers.HeaderUtil;
import net.lingala.zip4j.headers.HeaderWriter;
import net.lingala.zip4j.io.inputstream.NumberedSplitRandomAccessFile;
import net.lingala.zip4j.io.inputstream.ZipInputStream;
import net.lingala.zip4j.model.FileHeader;
import net.lingala.zip4j.model.ZipModel;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.model.enums.RandomAccessFileMode;
import net.lingala.zip4j.progress.ProgressMonitor;
import net.lingala.zip4j.tasks.AddFilesToZipTask;
import net.lingala.zip4j.tasks.AddFolderToZipTask;
import net.lingala.zip4j.tasks.AddStreamToZipTask;
import net.lingala.zip4j.tasks.AsyncZipTask;
import net.lingala.zip4j.tasks.ExtractAllFilesTask;
import net.lingala.zip4j.tasks.ExtractFileTask;
import net.lingala.zip4j.tasks.MergeSplitZipFileTask;
import net.lingala.zip4j.tasks.RemoveFilesFromZipTask;
import net.lingala.zip4j.tasks.RenameFilesTask;
import net.lingala.zip4j.tasks.SetCommentTask;
import net.lingala.zip4j.util.FileUtils;
import net.lingala.zip4j.util.InternalZipConstants;
import net.lingala.zip4j.util.RawIO;
import net.lingala.zip4j.util.UnzipUtil;
import net.lingala.zip4j.util.Zip4jUtil;

public class ZipFile {

    /* renamed from: a  reason: collision with root package name */
    private File f30515a;

    /* renamed from: b  reason: collision with root package name */
    private ZipModel f30516b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f30517c;

    /* renamed from: d  reason: collision with root package name */
    private ProgressMonitor f30518d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f30519e;

    /* renamed from: f  reason: collision with root package name */
    private char[] f30520f;

    /* renamed from: g  reason: collision with root package name */
    private HeaderWriter f30521g;

    /* renamed from: h  reason: collision with root package name */
    private Charset f30522h;

    /* renamed from: i  reason: collision with root package name */
    private ThreadFactory f30523i;

    /* renamed from: j  reason: collision with root package name */
    private ExecutorService f30524j;

    public ZipFile(File file) {
        this(file, (char[]) null);
    }

    private RandomAccessFile C() throws IOException {
        if (!FileUtils.y(this.f30515a)) {
            return new RandomAccessFile(this.f30515a, RandomAccessFileMode.READ.a());
        }
        NumberedSplitRandomAccessFile numberedSplitRandomAccessFile = new NumberedSplitRandomAccessFile(this.f30515a, RandomAccessFileMode.READ.a(), FileUtils.i(this.f30515a));
        numberedSplitRandomAccessFile.c();
        return numberedSplitRandomAccessFile;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x003c, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x003d, code lost:
        if (r0 != null) goto L_0x003f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0047, code lost:
        throw r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void I() throws net.lingala.zip4j.exception.ZipException {
        /*
            r3 = this;
            net.lingala.zip4j.model.ZipModel r0 = r3.f30516b
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            java.io.File r0 = r3.f30515a
            boolean r0 = r0.exists()
            if (r0 != 0) goto L_0x0011
            r3.l()
            return
        L_0x0011:
            java.io.File r0 = r3.f30515a
            boolean r0 = r0.canRead()
            if (r0 == 0) goto L_0x004f
            java.io.RandomAccessFile r0 = r3.C()     // Catch:{ ZipException -> 0x0037, IOException -> 0x0035 }
            net.lingala.zip4j.headers.HeaderReader r1 = new net.lingala.zip4j.headers.HeaderReader     // Catch:{ all -> 0x003a }
            r1.<init>()     // Catch:{ all -> 0x003a }
            java.nio.charset.Charset r2 = r3.f30522h     // Catch:{ all -> 0x003a }
            net.lingala.zip4j.model.ZipModel r1 = r1.g(r0, r2)     // Catch:{ all -> 0x003a }
            r3.f30516b = r1     // Catch:{ all -> 0x003a }
            java.io.File r2 = r3.f30515a     // Catch:{ all -> 0x003a }
            r1.E(r2)     // Catch:{ all -> 0x003a }
            if (r0 == 0) goto L_0x0039
            r0.close()     // Catch:{ ZipException -> 0x0037, IOException -> 0x0035 }
            goto L_0x0039
        L_0x0035:
            r0 = move-exception
            goto L_0x0048
        L_0x0037:
            r0 = move-exception
            goto L_0x004e
        L_0x0039:
            return
        L_0x003a:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x003c }
        L_0x003c:
            r2 = move-exception
            if (r0 == 0) goto L_0x0047
            r0.close()     // Catch:{ all -> 0x0043 }
            goto L_0x0047
        L_0x0043:
            r0 = move-exception
            r1.addSuppressed(r0)     // Catch:{ ZipException -> 0x0037, IOException -> 0x0035 }
        L_0x0047:
            throw r2     // Catch:{ ZipException -> 0x0037, IOException -> 0x0035 }
        L_0x0048:
            net.lingala.zip4j.exception.ZipException r1 = new net.lingala.zip4j.exception.ZipException
            r1.<init>((java.lang.Exception) r0)
            throw r1
        L_0x004e:
            throw r0
        L_0x004f:
            net.lingala.zip4j.exception.ZipException r0 = new net.lingala.zip4j.exception.ZipException
            java.lang.String r1 = "no read access for the input zip file"
            r0.<init>((java.lang.String) r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.lingala.zip4j.ZipFile.I():void");
    }

    private boolean U(List<File> list) {
        for (File exists : list) {
            if (!exists.exists()) {
                return false;
            }
        }
        return true;
    }

    private void i(File file, ZipParameters zipParameters, boolean z) throws ZipException {
        I();
        ZipModel zipModel = this.f30516b;
        if (zipModel == null) {
            throw new ZipException("internal error: zip model is null");
        } else if (!z || !zipModel.o()) {
            new AddFolderToZipTask(this.f30516b, this.f30520f, this.f30521g, k()).c(new AddFolderToZipTask.AddFolderToZipTaskParameters(file, zipParameters, this.f30522h));
        } else {
            throw new ZipException("This is a split archive. Zip file format does not allow updating split/spanned files");
        }
    }

    private AsyncZipTask.AsyncTaskParameters k() {
        if (this.f30519e) {
            if (this.f30523i == null) {
                this.f30523i = Executors.defaultThreadFactory();
            }
            this.f30524j = Executors.newSingleThreadExecutor(this.f30523i);
        }
        return new AsyncZipTask.AsyncTaskParameters(this.f30524j, this.f30519e, this.f30518d);
    }

    private void l() {
        ZipModel zipModel = new ZipModel();
        this.f30516b = zipModel;
        zipModel.E(this.f30515a);
    }

    public ProgressMonitor A() {
        return this.f30518d;
    }

    public List<File> B() throws ZipException {
        I();
        return FileUtils.u(this.f30516b);
    }

    public boolean D() throws ZipException {
        if (this.f30516b == null) {
            I();
            if (this.f30516b == null) {
                throw new ZipException("Zip Model is null");
            }
        }
        if (this.f30516b.b() == null || this.f30516b.b().b() == null) {
            throw new ZipException("invalid zip file");
        }
        Iterator<FileHeader> it2 = this.f30516b.b().b().iterator();
        while (true) {
            if (it2.hasNext()) {
                FileHeader next = it2.next();
                if (next != null && next.u()) {
                    this.f30517c = true;
                    break;
                }
            } else {
                break;
            }
        }
        return this.f30517c;
    }

    public boolean E() {
        return this.f30519e;
    }

    public boolean F() throws ZipException {
        if (this.f30516b == null) {
            I();
            if (this.f30516b == null) {
                throw new ZipException("Zip Model is null");
            }
        }
        return this.f30516b.o();
    }

    public boolean G() {
        if (!this.f30515a.exists()) {
            return false;
        }
        try {
            I();
            return !this.f30516b.o() || U(B());
        } catch (Exception unused) {
            return false;
        }
    }

    public void H(File file) throws ZipException {
        if (file == null) {
            throw new ZipException("outputZipFile is null, cannot merge split files");
        } else if (!file.exists()) {
            I();
            ZipModel zipModel = this.f30516b;
            if (zipModel != null) {
                new MergeSplitZipFileTask(zipModel, k()).c(new MergeSplitZipFileTask.MergeSplitZipFileTaskParameters(file, this.f30522h));
                return;
            }
            throw new ZipException("zip model is null, corrupt zip file?");
        } else {
            throw new ZipException("output Zip File already exists");
        }
    }

    public void J(String str) throws ZipException {
        if (Zip4jUtil.h(str)) {
            L(Collections.singletonList(str));
            return;
        }
        throw new ZipException("file name is empty or null, cannot remove file");
    }

    public void K(FileHeader fileHeader) throws ZipException {
        if (fileHeader != null) {
            J(fileHeader.k());
            return;
        }
        throw new ZipException("input file header is null, cannot remove file");
    }

    public void L(List<String> list) throws ZipException {
        if (list == null) {
            throw new ZipException("fileNames list is null");
        } else if (!list.isEmpty()) {
            if (this.f30516b == null) {
                I();
            }
            if (!this.f30516b.o()) {
                new RemoveFilesFromZipTask(this.f30516b, this.f30521g, k()).c(new RemoveFilesFromZipTask.RemoveFilesFromZipTaskParameters(list, this.f30522h));
                return;
            }
            throw new ZipException("Zip file format does not allow updating split/spanned files");
        }
    }

    public void M(String str, String str2) throws ZipException {
        if (!Zip4jUtil.h(str)) {
            throw new ZipException("file name to be changed is null or empty");
        } else if (Zip4jUtil.h(str2)) {
            O(Collections.singletonMap(str, str2));
        } else {
            throw new ZipException("newFileName is null or empty");
        }
    }

    public void N(FileHeader fileHeader, String str) throws ZipException {
        if (fileHeader != null) {
            M(fileHeader.k(), str);
            return;
        }
        throw new ZipException("File header is null");
    }

    public void O(Map<String, String> map) throws ZipException {
        if (map == null) {
            throw new ZipException("fileNamesMap is null");
        } else if (map.size() != 0) {
            I();
            if (!this.f30516b.o()) {
                new RenameFilesTask(this.f30516b, this.f30521g, new RawIO(), this.f30522h, k()).c(new RenameFilesTask.RenameFilesTaskParameters(map));
                return;
            }
            throw new ZipException("Zip file format does not allow updating split/spanned files");
        }
    }

    public void P(Charset charset) throws IllegalArgumentException {
        if (charset != null) {
            this.f30522h = charset;
            return;
        }
        throw new IllegalArgumentException("charset cannot be null");
    }

    public void Q(String str) throws ZipException {
        if (str == null) {
            throw new ZipException("input comment is null, cannot update zip file");
        } else if (this.f30515a.exists()) {
            I();
            ZipModel zipModel = this.f30516b;
            if (zipModel == null) {
                throw new ZipException("zipModel is null, cannot update zip file");
            } else if (zipModel.e() != null) {
                new SetCommentTask(this.f30516b, k()).c(new SetCommentTask.SetCommentTaskTaskParameters(str, this.f30522h));
            } else {
                throw new ZipException("end of central directory is null, cannot set comment");
            }
        } else {
            throw new ZipException("zip file does not exist, cannot set comment for zip file");
        }
    }

    public void R(char[] cArr) {
        this.f30520f = cArr;
    }

    public void S(boolean z) {
        this.f30519e = z;
    }

    public void T(ThreadFactory threadFactory) {
        this.f30523i = threadFactory;
    }

    public void a(File file) throws ZipException {
        f(Collections.singletonList(file), new ZipParameters());
    }

    public void b(File file, ZipParameters zipParameters) throws ZipException {
        f(Collections.singletonList(file), zipParameters);
    }

    public void c(String str) throws ZipException {
        d(str, new ZipParameters());
    }

    public void d(String str, ZipParameters zipParameters) throws ZipException {
        if (Zip4jUtil.h(str)) {
            f(Collections.singletonList(new File(str)), zipParameters);
            return;
        }
        throw new ZipException("file to add is null or empty");
    }

    public void e(List<File> list) throws ZipException {
        f(list, new ZipParameters());
    }

    public void f(List<File> list, ZipParameters zipParameters) throws ZipException {
        if (list == null || list.size() == 0) {
            throw new ZipException("input file List is null or empty");
        } else if (zipParameters == null) {
            throw new ZipException("input parameters are null");
        } else if (this.f30518d.i() != ProgressMonitor.State.BUSY) {
            I();
            if (this.f30516b == null) {
                throw new ZipException("internal error: zip model is null");
            } else if (!this.f30515a.exists() || !this.f30516b.o()) {
                new AddFilesToZipTask(this.f30516b, this.f30520f, this.f30521g, k()).c(new AddFilesToZipTask.AddFilesToZipTaskParameters(list, zipParameters, this.f30522h));
            } else {
                throw new ZipException("Zip file already exists. Zip file format does not allow updating split/spanned files");
            }
        } else {
            throw new ZipException("invalid operation - Zip4j is in busy state");
        }
    }

    public void g(File file) throws ZipException {
        h(file, new ZipParameters());
    }

    public void h(File file, ZipParameters zipParameters) throws ZipException {
        if (file == null) {
            throw new ZipException("input path is null, cannot add folder to zip file");
        } else if (!file.exists()) {
            throw new ZipException("folder does not exist");
        } else if (!file.isDirectory()) {
            throw new ZipException("input folder is not a directory");
        } else if (!file.canRead()) {
            throw new ZipException("cannot read input folder");
        } else if (zipParameters != null) {
            i(file, zipParameters, true);
        } else {
            throw new ZipException("input parameters are null, cannot add folder to zip file");
        }
    }

    public void j(InputStream inputStream, ZipParameters zipParameters) throws ZipException {
        if (inputStream == null) {
            throw new ZipException("inputstream is null, cannot add file to zip");
        } else if (zipParameters != null) {
            S(false);
            I();
            if (this.f30516b == null) {
                throw new ZipException("internal error: zip model is null");
            } else if (!this.f30515a.exists() || !this.f30516b.o()) {
                new AddStreamToZipTask(this.f30516b, this.f30520f, this.f30521g, k()).c(new AddStreamToZipTask.AddStreamToZipTaskParameters(inputStream, zipParameters, this.f30522h));
            } else {
                throw new ZipException("Zip file already exists. Zip file format does not allow updating split/spanned files");
            }
        } else {
            throw new ZipException("zip parameters are null");
        }
    }

    public void m(List<File> list, ZipParameters zipParameters, boolean z, long j2) throws ZipException {
        if (this.f30515a.exists()) {
            throw new ZipException("zip file: " + this.f30515a + " already exists. To add files to existing zip file use addFile method");
        } else if (list == null || list.size() == 0) {
            throw new ZipException("input file List is null, cannot create zip file");
        } else {
            l();
            this.f30516b.x(z);
            this.f30516b.y(j2);
            new AddFilesToZipTask(this.f30516b, this.f30520f, this.f30521g, k()).c(new AddFilesToZipTask.AddFilesToZipTaskParameters(list, zipParameters, this.f30522h));
        }
    }

    public void n(File file, ZipParameters zipParameters, boolean z, long j2) throws ZipException {
        if (file == null) {
            throw new ZipException("folderToAdd is null, cannot create zip file from folder");
        } else if (zipParameters == null) {
            throw new ZipException("input parameters are null, cannot create zip file from folder");
        } else if (!this.f30515a.exists()) {
            l();
            this.f30516b.x(z);
            if (z) {
                this.f30516b.y(j2);
            }
            i(file, zipParameters, false);
        } else {
            throw new ZipException("zip file: " + this.f30515a + " already exists. To add files to existing zip file use addFolder method");
        }
    }

    public void o(String str) throws ZipException {
        if (!Zip4jUtil.h(str)) {
            throw new ZipException("output path is null or invalid");
        } else if (Zip4jUtil.b(new File(str))) {
            if (this.f30516b == null) {
                I();
            }
            if (this.f30516b == null) {
                throw new ZipException("Internal error occurred when extracting zip file");
            } else if (this.f30518d.i() != ProgressMonitor.State.BUSY) {
                new ExtractAllFilesTask(this.f30516b, this.f30520f, k()).c(new ExtractAllFilesTask.ExtractAllFilesTaskParameters(str, this.f30522h));
            } else {
                throw new ZipException("invalid operation - Zip4j is in busy state");
            }
        } else {
            throw new ZipException("invalid output path");
        }
    }

    public void p(String str, String str2) throws ZipException {
        q(str, str2, (String) null);
    }

    public void q(String str, String str2, String str3) throws ZipException {
        if (Zip4jUtil.h(str)) {
            I();
            FileHeader c2 = HeaderUtil.c(this.f30516b, str);
            if (c2 != null) {
                s(c2, str2, str3);
                return;
            }
            throw new ZipException("No file found with name " + str + " in zip file", ZipException.Type.FILE_NOT_FOUND);
        }
        throw new ZipException("file to extract is null or empty, cannot extract file");
    }

    public void r(FileHeader fileHeader, String str) throws ZipException {
        s(fileHeader, str, (String) null);
    }

    public void s(FileHeader fileHeader, String str, String str2) throws ZipException {
        if (fileHeader == null) {
            throw new ZipException("input file header is null, cannot extract file");
        } else if (!Zip4jUtil.h(str)) {
            throw new ZipException("destination path is empty or null, cannot extract file");
        } else if (this.f30518d.i() != ProgressMonitor.State.BUSY) {
            I();
            new ExtractFileTask(this.f30516b, this.f30520f, k()).c(new ExtractFileTask.ExtractFileTaskParameters(str, fileHeader, str2, this.f30522h));
        } else {
            throw new ZipException("invalid operation - Zip4j is in busy state");
        }
    }

    public Charset t() {
        return this.f30522h;
    }

    public String toString() {
        return this.f30515a.toString();
    }

    public String u() throws ZipException {
        if (this.f30515a.exists()) {
            I();
            ZipModel zipModel = this.f30516b;
            if (zipModel == null) {
                throw new ZipException("zip model is null, cannot read comment");
            } else if (zipModel.e() != null) {
                return this.f30516b.e().c();
            } else {
                throw new ZipException("end of central directory record is null, cannot read comment");
            }
        } else {
            throw new ZipException("zip file does not exist, cannot read comment");
        }
    }

    public ExecutorService v() {
        return this.f30524j;
    }

    public File w() {
        return this.f30515a;
    }

    public FileHeader x(String str) throws ZipException {
        if (Zip4jUtil.h(str)) {
            I();
            ZipModel zipModel = this.f30516b;
            if (zipModel == null || zipModel.b() == null) {
                return null;
            }
            return HeaderUtil.c(this.f30516b, str);
        }
        throw new ZipException("input file name is emtpy or null, cannot get FileHeader");
    }

    public List<FileHeader> y() throws ZipException {
        I();
        ZipModel zipModel = this.f30516b;
        return (zipModel == null || zipModel.b() == null) ? Collections.emptyList() : this.f30516b.b().b();
    }

    public ZipInputStream z(FileHeader fileHeader) throws IOException {
        if (fileHeader != null) {
            I();
            ZipModel zipModel = this.f30516b;
            if (zipModel != null) {
                return UnzipUtil.c(zipModel, fileHeader, this.f30520f);
            }
            throw new ZipException("zip model is null, cannot get inputstream");
        }
        throw new ZipException("FileHeader is null, cannot get InputStream");
    }

    public ZipFile(File file, char[] cArr) {
        this.f30521g = new HeaderWriter();
        this.f30522h = InternalZipConstants.u;
        this.f30515a = file;
        this.f30520f = cArr;
        this.f30519e = false;
        this.f30518d = new ProgressMonitor();
    }

    public ZipFile(String str) {
        this(new File(str), (char[]) null);
    }

    public ZipFile(String str, char[] cArr) {
        this(new File(str), cArr);
    }
}
