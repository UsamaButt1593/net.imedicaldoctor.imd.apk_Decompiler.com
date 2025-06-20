package androidx.documentfile.provider;

import android.net.Uri;
import android.util.Log;
import android.webkit.MimeTypeMap;
import androidx.annotation.Nullable;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

class RawDocumentFile extends DocumentFile {

    /* renamed from: c  reason: collision with root package name */
    private File f7320c;

    RawDocumentFile(@Nullable DocumentFile documentFile, File file) {
        super(documentFile);
        this.f7320c = file;
    }

    private static boolean w(File file) {
        File[] listFiles = file.listFiles();
        boolean z = true;
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    z &= w(file2);
                }
                if (!file2.delete()) {
                    Log.w("DocumentFile", "Failed to delete " + file2);
                    z = false;
                }
            }
        }
        return z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0008, code lost:
        r1 = android.webkit.MimeTypeMap.getSingleton().getMimeTypeFromExtension(r1.substring(r0 + 1).toLowerCase());
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String x(java.lang.String r1) {
        /*
            r0 = 46
            int r0 = r1.lastIndexOf(r0)
            if (r0 < 0) goto L_0x001d
            int r0 = r0 + 1
            java.lang.String r1 = r1.substring(r0)
            java.lang.String r1 = r1.toLowerCase()
            android.webkit.MimeTypeMap r0 = android.webkit.MimeTypeMap.getSingleton()
            java.lang.String r1 = r0.getMimeTypeFromExtension(r1)
            if (r1 == 0) goto L_0x001d
            return r1
        L_0x001d:
            java.lang.String r1 = "application/octet-stream"
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.documentfile.provider.RawDocumentFile.x(java.lang.String):java.lang.String");
    }

    public boolean a() {
        return this.f7320c.canRead();
    }

    public boolean b() {
        return this.f7320c.canWrite();
    }

    @Nullable
    public DocumentFile c(String str) {
        File file = new File(this.f7320c, str);
        if (file.isDirectory() || file.mkdir()) {
            return new RawDocumentFile(this, file);
        }
        return null;
    }

    @Nullable
    public DocumentFile d(String str, String str2) {
        String extensionFromMimeType = MimeTypeMap.getSingleton().getExtensionFromMimeType(str);
        if (extensionFromMimeType != null) {
            str2 = str2 + "." + extensionFromMimeType;
        }
        File file = new File(this.f7320c, str2);
        try {
            file.createNewFile();
            return new RawDocumentFile(this, file);
        } catch (IOException e2) {
            Log.w("DocumentFile", "Failed to createFile: " + e2);
            return null;
        }
    }

    public boolean e() {
        w(this.f7320c);
        return this.f7320c.delete();
    }

    public boolean f() {
        return this.f7320c.exists();
    }

    public String k() {
        return this.f7320c.getName();
    }

    @Nullable
    public String m() {
        if (this.f7320c.isDirectory()) {
            return null;
        }
        return x(this.f7320c.getName());
    }

    public Uri n() {
        return Uri.fromFile(this.f7320c);
    }

    public boolean o() {
        return this.f7320c.isDirectory();
    }

    public boolean q() {
        return this.f7320c.isFile();
    }

    public boolean r() {
        return false;
    }

    public long s() {
        return this.f7320c.lastModified();
    }

    public long t() {
        return this.f7320c.length();
    }

    public DocumentFile[] u() {
        ArrayList arrayList = new ArrayList();
        File[] listFiles = this.f7320c.listFiles();
        if (listFiles != null) {
            for (File rawDocumentFile : listFiles) {
                arrayList.add(new RawDocumentFile(this, rawDocumentFile));
            }
        }
        return (DocumentFile[]) arrayList.toArray(new DocumentFile[arrayList.size()]);
    }

    public boolean v(String str) {
        File file = new File(this.f7320c.getParentFile(), str);
        if (!this.f7320c.renameTo(file)) {
            return false;
        }
        this.f7320c = file;
        return true;
    }
}
