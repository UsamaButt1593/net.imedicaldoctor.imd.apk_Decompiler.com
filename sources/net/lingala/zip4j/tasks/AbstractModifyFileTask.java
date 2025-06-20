package net.lingala.zip4j.tasks;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.headers.HeaderUtil;
import net.lingala.zip4j.model.FileHeader;
import net.lingala.zip4j.model.ZipModel;
import net.lingala.zip4j.progress.ProgressMonitor;
import net.lingala.zip4j.tasks.AsyncZipTask;
import net.lingala.zip4j.util.FileUtils;

abstract class AbstractModifyFileTask<T> extends AsyncZipTask<T> {
    AbstractModifyFileTask(AsyncZipTask.AsyncTaskParameters asyncTaskParameters) {
        super(asyncTaskParameters);
    }

    private int m(List<FileHeader> list, FileHeader fileHeader) throws ZipException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (list.get(i2).equals(fileHeader)) {
                return i2;
            }
        }
        throw new ZipException("Could not find file header in list of central directory file headers");
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ int p(FileHeader fileHeader, FileHeader fileHeader2) {
        if (fileHeader.k().equals(fileHeader2.k())) {
            return 0;
        }
        return fileHeader.U() < fileHeader2.U() ? -1 : 1;
    }

    private void q(File file, File file2) throws ZipException {
        if (!file.delete()) {
            throw new ZipException("cannot delete old zip file");
        } else if (!file2.renameTo(file)) {
            throw new ZipException("cannot rename modified zip file");
        }
    }

    /* access modifiers changed from: package-private */
    public void j(boolean z, File file, File file2) throws ZipException {
        if (z) {
            q(file, file2);
        } else if (!file2.delete()) {
            throw new ZipException("Could not delete temporary file");
        }
    }

    /* access modifiers changed from: package-private */
    public List<FileHeader> k(List<FileHeader> list) {
        ArrayList arrayList = new ArrayList(list);
        Collections.sort(arrayList, new b());
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public long l(RandomAccessFile randomAccessFile, OutputStream outputStream, long j2, long j3, ProgressMonitor progressMonitor) throws IOException {
        FileUtils.h(randomAccessFile, outputStream, j2, j2 + j3, progressMonitor);
        return j3;
    }

    /* access modifiers changed from: package-private */
    public long n(List<FileHeader> list, FileHeader fileHeader, ZipModel zipModel) throws ZipException {
        int m2 = m(list, fileHeader);
        return m2 == list.size() + -1 ? HeaderUtil.f(zipModel) : list.get(m2 + 1).U();
    }

    /* access modifiers changed from: package-private */
    public File o(String str) {
        Random random = new Random();
        File file = new File(str + random.nextInt(10000));
        while (file.exists()) {
            file = new File(str + random.nextInt(10000));
        }
        return file;
    }

    /* access modifiers changed from: package-private */
    public void r(List<FileHeader> list, ZipModel zipModel, FileHeader fileHeader, long j2) throws ZipException {
        int m2 = m(list, fileHeader);
        if (m2 != -1) {
            while (true) {
                m2++;
                if (m2 < list.size()) {
                    FileHeader fileHeader2 = list.get(m2);
                    fileHeader2.b0(fileHeader2.U() + j2);
                    if (!(!zipModel.p() || fileHeader2.r() == null || fileHeader2.r().e() == -1)) {
                        fileHeader2.r().j(fileHeader2.r().e() + j2);
                    }
                } else {
                    return;
                }
            }
        } else {
            throw new ZipException("Could not locate modified file header in zipModel");
        }
    }
}
