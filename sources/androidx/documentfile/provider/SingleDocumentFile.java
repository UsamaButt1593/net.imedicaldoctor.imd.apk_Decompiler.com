package androidx.documentfile.provider;

import android.content.Context;
import android.net.Uri;
import android.provider.DocumentsContract;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

@RequiresApi(19)
class SingleDocumentFile extends DocumentFile {

    /* renamed from: c  reason: collision with root package name */
    private Context f7321c;

    /* renamed from: d  reason: collision with root package name */
    private Uri f7322d;

    SingleDocumentFile(@Nullable DocumentFile documentFile, Context context, Uri uri) {
        super(documentFile);
        this.f7321c = context;
        this.f7322d = uri;
    }

    public boolean a() {
        return DocumentsContractApi19.a(this.f7321c, this.f7322d);
    }

    public boolean b() {
        return DocumentsContractApi19.b(this.f7321c, this.f7322d);
    }

    public DocumentFile c(String str) {
        throw new UnsupportedOperationException();
    }

    public DocumentFile d(String str, String str2) {
        throw new UnsupportedOperationException();
    }

    public boolean e() {
        try {
            return DocumentsContract.deleteDocument(this.f7321c.getContentResolver(), this.f7322d);
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean f() {
        return DocumentsContractApi19.d(this.f7321c, this.f7322d);
    }

    @Nullable
    public String k() {
        return DocumentsContractApi19.f(this.f7321c, this.f7322d);
    }

    @Nullable
    public String m() {
        return DocumentsContractApi19.h(this.f7321c, this.f7322d);
    }

    public Uri n() {
        return this.f7322d;
    }

    public boolean o() {
        return DocumentsContractApi19.i(this.f7321c, this.f7322d);
    }

    public boolean q() {
        return DocumentsContractApi19.j(this.f7321c, this.f7322d);
    }

    public boolean r() {
        return DocumentsContractApi19.k(this.f7321c, this.f7322d);
    }

    public long s() {
        return DocumentsContractApi19.l(this.f7321c, this.f7322d);
    }

    public long t() {
        return DocumentsContractApi19.m(this.f7321c, this.f7322d);
    }

    public DocumentFile[] u() {
        throw new UnsupportedOperationException();
    }

    public boolean v(String str) {
        throw new UnsupportedOperationException();
    }
}
