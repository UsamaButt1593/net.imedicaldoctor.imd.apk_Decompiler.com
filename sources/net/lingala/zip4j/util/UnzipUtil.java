package net.lingala.zip4j.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import net.lingala.zip4j.io.inputstream.NumberedSplitInputStream;
import net.lingala.zip4j.io.inputstream.SplitInputStream;
import net.lingala.zip4j.io.inputstream.ZipStandardSplitInputStream;
import net.lingala.zip4j.model.FileHeader;
import net.lingala.zip4j.model.ZipModel;

public class UnzipUtil {
    public static void a(FileHeader fileHeader, File file) {
        try {
            Path a2 = file.toPath();
            FileUtils.G(a2, fileHeader.Q());
            FileUtils.H(a2, fileHeader.n());
        } catch (NoSuchMethodError unused) {
            FileUtils.I(file, fileHeader.n());
        }
    }

    public static SplitInputStream b(ZipModel zipModel) throws IOException {
        return zipModel.m().getName().endsWith(InternalZipConstants.v) ? new NumberedSplitInputStream(zipModel.m(), true, zipModel.e().d()) : new ZipStandardSplitInputStream(zipModel.m(), zipModel.o(), zipModel.e().d());
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0021  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static net.lingala.zip4j.io.inputstream.ZipInputStream c(net.lingala.zip4j.model.ZipModel r1, net.lingala.zip4j.model.FileHeader r2, char[] r3) throws java.io.IOException {
        /*
            net.lingala.zip4j.io.inputstream.SplitInputStream r1 = b(r1)     // Catch:{ IOException -> 0x001d }
            r1.d(r2)     // Catch:{ IOException -> 0x001b }
            net.lingala.zip4j.io.inputstream.ZipInputStream r0 = new net.lingala.zip4j.io.inputstream.ZipInputStream     // Catch:{ IOException -> 0x001b }
            r0.<init>((java.io.InputStream) r1, (char[]) r3)     // Catch:{ IOException -> 0x001b }
            net.lingala.zip4j.model.LocalFileHeader r2 = r0.i(r2)     // Catch:{ IOException -> 0x001b }
            if (r2 == 0) goto L_0x0013
            return r0
        L_0x0013:
            net.lingala.zip4j.exception.ZipException r2 = new net.lingala.zip4j.exception.ZipException     // Catch:{ IOException -> 0x001b }
            java.lang.String r3 = "Could not locate local file header for corresponding file header"
            r2.<init>((java.lang.String) r3)     // Catch:{ IOException -> 0x001b }
            throw r2     // Catch:{ IOException -> 0x001b }
        L_0x001b:
            r2 = move-exception
            goto L_0x001f
        L_0x001d:
            r2 = move-exception
            r1 = 0
        L_0x001f:
            if (r1 == 0) goto L_0x0024
            r1.close()
        L_0x0024:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: net.lingala.zip4j.util.UnzipUtil.c(net.lingala.zip4j.model.ZipModel, net.lingala.zip4j.model.FileHeader, char[]):net.lingala.zip4j.io.inputstream.ZipInputStream");
    }
}
