package androidx.documentfile.provider;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.DocumentsContract;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.util.ArrayList;

@RequiresApi(21)
class TreeDocumentFile extends DocumentFile {

    /* renamed from: c  reason: collision with root package name */
    private Context f7323c;

    /* renamed from: d  reason: collision with root package name */
    private Uri f7324d;

    TreeDocumentFile(@Nullable DocumentFile documentFile, Context context, Uri uri) {
        super(documentFile);
        this.f7323c = context;
        this.f7324d = uri;
    }

    private static void w(@Nullable AutoCloseable autoCloseable) {
        if (autoCloseable != null) {
            try {
                autoCloseable.close();
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception unused) {
            }
        }
    }

    @Nullable
    private static Uri x(Context context, Uri uri, String str, String str2) {
        try {
            return DocumentsContract.createDocument(context.getContentResolver(), uri, str, str2);
        } catch (Exception unused) {
            return null;
        }
    }

    public boolean a() {
        return DocumentsContractApi19.a(this.f7323c, this.f7324d);
    }

    public boolean b() {
        return DocumentsContractApi19.b(this.f7323c, this.f7324d);
    }

    @Nullable
    public DocumentFile c(String str) {
        Uri x = x(this.f7323c, this.f7324d, "vnd.android.document/directory", str);
        if (x != null) {
            return new TreeDocumentFile(this, this.f7323c, x);
        }
        return null;
    }

    @Nullable
    public DocumentFile d(String str, String str2) {
        Uri x = x(this.f7323c, this.f7324d, str, str2);
        if (x != null) {
            return new TreeDocumentFile(this, this.f7323c, x);
        }
        return null;
    }

    public boolean e() {
        try {
            return DocumentsContract.deleteDocument(this.f7323c.getContentResolver(), this.f7324d);
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean f() {
        return DocumentsContractApi19.d(this.f7323c, this.f7324d);
    }

    @Nullable
    public String k() {
        return DocumentsContractApi19.f(this.f7323c, this.f7324d);
    }

    @Nullable
    public String m() {
        return DocumentsContractApi19.h(this.f7323c, this.f7324d);
    }

    public Uri n() {
        return this.f7324d;
    }

    public boolean o() {
        return DocumentsContractApi19.i(this.f7323c, this.f7324d);
    }

    public boolean q() {
        return DocumentsContractApi19.j(this.f7323c, this.f7324d);
    }

    public boolean r() {
        return DocumentsContractApi19.k(this.f7323c, this.f7324d);
    }

    public long s() {
        return DocumentsContractApi19.l(this.f7323c, this.f7324d);
    }

    public long t() {
        return DocumentsContractApi19.m(this.f7323c, this.f7324d);
    }

    public DocumentFile[] u() {
        ContentResolver contentResolver = this.f7323c.getContentResolver();
        Uri uri = this.f7324d;
        Uri buildChildDocumentsUriUsingTree = DocumentsContract.buildChildDocumentsUriUsingTree(uri, DocumentsContract.getDocumentId(uri));
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            cursor = contentResolver.query(buildChildDocumentsUriUsingTree, new String[]{"document_id"}, (String) null, (String[]) null, (String) null);
            while (cursor.moveToNext()) {
                arrayList.add(DocumentsContract.buildDocumentUriUsingTree(this.f7324d, cursor.getString(0)));
            }
        } catch (Exception e2) {
            Log.w("DocumentFile", "Failed query: " + e2);
        } catch (Throwable th) {
            w((AutoCloseable) null);
            throw th;
        }
        w(cursor);
        Uri[] uriArr = (Uri[]) arrayList.toArray(new Uri[arrayList.size()]);
        DocumentFile[] documentFileArr = new DocumentFile[uriArr.length];
        for (int i2 = 0; i2 < uriArr.length; i2++) {
            documentFileArr[i2] = new TreeDocumentFile(this, this.f7323c, uriArr[i2]);
        }
        return documentFileArr;
    }

    public boolean v(String str) {
        try {
            Uri renameDocument = DocumentsContract.renameDocument(this.f7323c.getContentResolver(), this.f7324d, str);
            if (renameDocument != null) {
                this.f7324d = renameDocument;
                return true;
            }
        } catch (Exception unused) {
        }
        return false;
    }
}
