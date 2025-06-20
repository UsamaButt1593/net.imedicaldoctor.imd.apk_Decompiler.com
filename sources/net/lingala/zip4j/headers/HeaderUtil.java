package net.lingala.zip4j.headers;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import l.b;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.FileHeader;
import net.lingala.zip4j.model.ZipModel;
import net.lingala.zip4j.util.InternalZipConstants;
import net.lingala.zip4j.util.Zip4jUtil;

public class HeaderUtil {
    public static String b(byte[] bArr, boolean z, Charset charset) {
        String str;
        Charset charset2 = InternalZipConstants.u;
        if (charset2.equals(charset) && !z) {
            try {
                return new String(bArr, InternalZipConstants.q);
            } catch (UnsupportedEncodingException unused) {
                return new String(bArr);
            }
        } else if (charset != null) {
            return str;
        } else {
            str = new String(bArr, charset2);
            return str;
        }
    }

    public static FileHeader c(ZipModel zipModel, String str) throws ZipException {
        FileHeader d2 = d(zipModel, str);
        if (d2 != null) {
            return d2;
        }
        String replaceAll = str.replaceAll("\\\\", "/");
        FileHeader d3 = d(zipModel, replaceAll);
        return d3 == null ? d(zipModel, replaceAll.replaceAll("/", "\\\\")) : d3;
    }

    private static FileHeader d(ZipModel zipModel, String str) throws ZipException {
        if (zipModel == null) {
            throw new ZipException("zip model is null, cannot determine file header with exact match for fileName: " + str);
        } else if (!Zip4jUtil.h(str)) {
            throw new ZipException("file name is null, cannot determine file header with exact match for fileName: " + str);
        } else if (zipModel.b() == null) {
            throw new ZipException("central directory is null, cannot determine file header with exact match for fileName: " + str);
        } else if (zipModel.b().b() == null) {
            throw new ZipException("file Headers are null, cannot determine file header with exact match for fileName: " + str);
        } else if (zipModel.b().b().size() == 0) {
            return null;
        } else {
            for (FileHeader next : zipModel.b().b()) {
                String k2 = next.k();
                if (Zip4jUtil.h(k2) && str.equalsIgnoreCase(k2)) {
                    return next;
                }
            }
            return null;
        }
    }

    public static List<FileHeader> e(List<FileHeader> list, FileHeader fileHeader) {
        return !fileHeader.t() ? Collections.emptyList() : (List) list.stream().filter(new b(fileHeader)).collect(Collectors.toList());
    }

    public static long f(ZipModel zipModel) {
        return zipModel.p() ? zipModel.l().f() : zipModel.e().g();
    }

    public static long g(List<FileHeader> list) {
        long j2 = 0;
        for (FileHeader next : list) {
            j2 += (next.r() == null || next.r().g() <= 0) ? next.p() : next.r().g();
        }
        return j2;
    }
}
