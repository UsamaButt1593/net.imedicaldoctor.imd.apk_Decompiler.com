package androidx.documentfile.provider;

import android.content.Context;
import android.net.Uri;
import android.provider.DocumentsContract;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.File;

public abstract class DocumentFile {

    /* renamed from: b  reason: collision with root package name */
    static final String f7316b = "DocumentFile";
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private final DocumentFile f7317a;

    DocumentFile(@Nullable DocumentFile documentFile) {
        this.f7317a = documentFile;
    }

    @NonNull
    public static DocumentFile h(@NonNull File file) {
        return new RawDocumentFile((DocumentFile) null, file);
    }

    @Nullable
    public static DocumentFile i(@NonNull Context context, @NonNull Uri uri) {
        return new SingleDocumentFile((DocumentFile) null, context, uri);
    }

    @Nullable
    public static DocumentFile j(@NonNull Context context, @NonNull Uri uri) {
        return new TreeDocumentFile((DocumentFile) null, context, DocumentsContract.buildDocumentUriUsingTree(uri, DocumentsContract.getTreeDocumentId(uri)));
    }

    public static boolean p(@NonNull Context context, @Nullable Uri uri) {
        return DocumentsContract.isDocumentUri(context, uri);
    }

    public abstract boolean a();

    public abstract boolean b();

    @Nullable
    public abstract DocumentFile c(@NonNull String str);

    @Nullable
    public abstract DocumentFile d(@NonNull String str, @NonNull String str2);

    public abstract boolean e();

    public abstract boolean f();

    @Nullable
    public DocumentFile g(@NonNull String str) {
        for (DocumentFile documentFile : u()) {
            if (str.equals(documentFile.k())) {
                return documentFile;
            }
        }
        return null;
    }

    @Nullable
    public abstract String k();

    @Nullable
    public DocumentFile l() {
        return this.f7317a;
    }

    @Nullable
    public abstract String m();

    @NonNull
    public abstract Uri n();

    public abstract boolean o();

    public abstract boolean q();

    public abstract boolean r();

    public abstract long s();

    public abstract long t();

    @NonNull
    public abstract DocumentFile[] u();

    public abstract boolean v(@NonNull String str);
}
