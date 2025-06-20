package androidx.core.provider;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.provider.DocumentsContract;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.io.FileNotFoundException;
import java.util.List;

public final class DocumentsContractCompat {

    /* renamed from: a  reason: collision with root package name */
    private static final String f6086a = "tree";

    public static final class DocumentCompat {

        /* renamed from: a  reason: collision with root package name */
        public static final int f6087a = 512;

        private DocumentCompat() {
        }
    }

    @RequiresApi(21)
    private static class DocumentsContractApi21Impl {
        private DocumentsContractApi21Impl() {
        }

        @DoNotInline
        static Uri a(String str, String str2) {
            return DocumentsContract.buildChildDocumentsUri(str, str2);
        }

        @DoNotInline
        static Uri b(Uri uri, String str) {
            return DocumentsContract.buildChildDocumentsUriUsingTree(uri, str);
        }

        @DoNotInline
        static Uri c(Uri uri, String str) {
            return DocumentsContract.buildDocumentUriUsingTree(uri, str);
        }

        @DoNotInline
        public static Uri d(String str, String str2) {
            return DocumentsContract.buildTreeDocumentUri(str, str2);
        }

        @DoNotInline
        static Uri e(ContentResolver contentResolver, Uri uri, String str, String str2) throws FileNotFoundException {
            return DocumentsContract.createDocument(contentResolver, uri, str, str2);
        }

        @DoNotInline
        static String f(Uri uri) {
            return DocumentsContract.getTreeDocumentId(uri);
        }

        @DoNotInline
        static Uri g(@NonNull ContentResolver contentResolver, @NonNull Uri uri, @NonNull String str) throws FileNotFoundException {
            return DocumentsContract.renameDocument(contentResolver, uri, str);
        }
    }

    @RequiresApi(24)
    private static class DocumentsContractApi24Impl {
        private DocumentsContractApi24Impl() {
        }

        @DoNotInline
        static boolean a(@NonNull Uri uri) {
            return DocumentsContract.isTreeUri(uri);
        }

        @DoNotInline
        static boolean b(ContentResolver contentResolver, Uri uri, Uri uri2) throws FileNotFoundException {
            return DocumentsContract.removeDocument(contentResolver, uri, uri2);
        }
    }

    private DocumentsContractCompat() {
    }

    @Nullable
    public static Uri a(@NonNull String str, @Nullable String str2) {
        return DocumentsContractApi21Impl.a(str, str2);
    }

    @Nullable
    public static Uri b(@NonNull Uri uri, @NonNull String str) {
        return DocumentsContractApi21Impl.b(uri, str);
    }

    @Nullable
    public static Uri c(@NonNull String str, @NonNull String str2) {
        return DocumentsContract.buildDocumentUri(str, str2);
    }

    @Nullable
    public static Uri d(@NonNull Uri uri, @NonNull String str) {
        return DocumentsContractApi21Impl.c(uri, str);
    }

    @Nullable
    public static Uri e(@NonNull String str, @NonNull String str2) {
        return DocumentsContractApi21Impl.d(str, str2);
    }

    @Nullable
    public static Uri f(@NonNull ContentResolver contentResolver, @NonNull Uri uri, @NonNull String str, @NonNull String str2) throws FileNotFoundException {
        return DocumentsContractApi21Impl.e(contentResolver, uri, str, str2);
    }

    @Nullable
    public static String g(@NonNull Uri uri) {
        return DocumentsContract.getDocumentId(uri);
    }

    @Nullable
    public static String h(@NonNull Uri uri) {
        return DocumentsContractApi21Impl.f(uri);
    }

    public static boolean i(@NonNull Context context, @Nullable Uri uri) {
        return DocumentsContract.isDocumentUri(context, uri);
    }

    public static boolean j(@NonNull Uri uri) {
        if (Build.VERSION.SDK_INT >= 24) {
            return DocumentsContractApi24Impl.a(uri);
        }
        List<String> pathSegments = uri.getPathSegments();
        return pathSegments.size() >= 2 && f6086a.equals(pathSegments.get(0));
    }

    public static boolean k(@NonNull ContentResolver contentResolver, @NonNull Uri uri, @NonNull Uri uri2) throws FileNotFoundException {
        return Build.VERSION.SDK_INT >= 24 ? DocumentsContractApi24Impl.b(contentResolver, uri, uri2) : DocumentsContract.deleteDocument(contentResolver, uri);
    }

    @Nullable
    public static Uri l(@NonNull ContentResolver contentResolver, @NonNull Uri uri, @NonNull String str) throws FileNotFoundException {
        return DocumentsContractApi21Impl.g(contentResolver, uri, str);
    }
}
