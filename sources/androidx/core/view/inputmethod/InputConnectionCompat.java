package androidx.core.view.inputmethod;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.view.inputmethod.InputContentInfo;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Preconditions;
import androidx.core.view.ContentInfoCompat;
import androidx.core.view.ViewCompat;

@SuppressLint({"PrivateConstructorForUtilityClass"})
public final class InputConnectionCompat {

    /* renamed from: a  reason: collision with root package name */
    private static final String f6717a = "InputConnectionCompat";

    /* renamed from: b  reason: collision with root package name */
    private static final String f6718b = "androidx.core.view.inputmethod.InputConnectionCompat.COMMIT_CONTENT";

    /* renamed from: c  reason: collision with root package name */
    private static final String f6719c = "android.support.v13.view.inputmethod.InputConnectionCompat.COMMIT_CONTENT";

    /* renamed from: d  reason: collision with root package name */
    private static final String f6720d = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_URI";

    /* renamed from: e  reason: collision with root package name */
    private static final String f6721e = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_URI";

    /* renamed from: f  reason: collision with root package name */
    private static final String f6722f = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_DESCRIPTION";

    /* renamed from: g  reason: collision with root package name */
    private static final String f6723g = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_DESCRIPTION";

    /* renamed from: h  reason: collision with root package name */
    private static final String f6724h = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_LINK_URI";

    /* renamed from: i  reason: collision with root package name */
    private static final String f6725i = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_LINK_URI";

    /* renamed from: j  reason: collision with root package name */
    private static final String f6726j = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_OPTS";

    /* renamed from: k  reason: collision with root package name */
    private static final String f6727k = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_OPTS";

    /* renamed from: l  reason: collision with root package name */
    private static final String f6728l = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_FLAGS";

    /* renamed from: m  reason: collision with root package name */
    private static final String f6729m = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_FLAGS";

    /* renamed from: n  reason: collision with root package name */
    private static final String f6730n = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_RESULT_RECEIVER";
    private static final String o = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_RESULT_RECEIVER";
    public static final int p = 1;
    private static final String q = "androidx.core.view.extra.INPUT_CONTENT_INFO";

    @RequiresApi(25)
    static class Api25Impl {
        private Api25Impl() {
        }

        @DoNotInline
        static boolean a(InputConnection inputConnection, InputContentInfo inputContentInfo, int i2, Bundle bundle) {
            return inputConnection.commitContent(inputContentInfo, i2, bundle);
        }
    }

    public interface OnCommitContentListener {
        boolean a(@NonNull InputContentInfoCompat inputContentInfoCompat, int i2, @Nullable Bundle bundle);
    }

    public static boolean b(@NonNull InputConnection inputConnection, @NonNull EditorInfo editorInfo, @NonNull InputContentInfoCompat inputContentInfoCompat, int i2, @Nullable Bundle bundle) {
        boolean z;
        if (Build.VERSION.SDK_INT >= 25) {
            return Api25Impl.a(inputConnection, c.a(inputContentInfoCompat.f()), i2, bundle);
        }
        int e2 = EditorInfoCompat.e(editorInfo);
        if (e2 != 2) {
            z = false;
            if (!(e2 == 3 || e2 == 4)) {
                return false;
            }
        } else {
            z = true;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable(z ? f6721e : f6720d, inputContentInfoCompat.a());
        bundle2.putParcelable(z ? f6723g : f6722f, inputContentInfoCompat.b());
        bundle2.putParcelable(z ? f6725i : f6724h, inputContentInfoCompat.c());
        bundle2.putInt(z ? f6729m : f6728l, i2);
        bundle2.putParcelable(z ? f6727k : f6726j, bundle);
        return inputConnection.performPrivateCommand(z ? f6719c : f6718b, bundle2);
    }

    @NonNull
    private static OnCommitContentListener c(@NonNull View view) {
        Preconditions.l(view);
        return new d(view);
    }

    @NonNull
    public static InputConnection d(@NonNull View view, @NonNull InputConnection inputConnection, @NonNull EditorInfo editorInfo) {
        return e(inputConnection, editorInfo, c(view));
    }

    @NonNull
    @Deprecated
    public static InputConnection e(@NonNull InputConnection inputConnection, @NonNull EditorInfo editorInfo, @NonNull final OnCommitContentListener onCommitContentListener) {
        ObjectsCompat.e(inputConnection, "inputConnection must be non-null");
        ObjectsCompat.e(editorInfo, "editorInfo must be non-null");
        ObjectsCompat.e(onCommitContentListener, "onCommitContentListener must be non-null");
        if (Build.VERSION.SDK_INT >= 25) {
            return new InputConnectionWrapper(inputConnection, false) {
                public boolean commitContent(InputContentInfo inputContentInfo, int i2, Bundle bundle) {
                    if (onCommitContentListener.a(InputContentInfoCompat.g(inputContentInfo), i2, bundle)) {
                        return true;
                    }
                    return super.commitContent(inputContentInfo, i2, bundle);
                }
            };
        }
        return EditorInfoCompat.a(editorInfo).length == 0 ? inputConnection : new InputConnectionWrapper(inputConnection, false) {
            public boolean performPrivateCommand(String str, Bundle bundle) {
                if (InputConnectionCompat.f(str, bundle, onCommitContentListener)) {
                    return true;
                }
                return super.performPrivateCommand(str, bundle);
            }
        };
    }

    /* JADX WARNING: Removed duplicated region for block: B:46:0x007e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static boolean f(@androidx.annotation.Nullable java.lang.String r7, @androidx.annotation.Nullable android.os.Bundle r8, @androidx.annotation.NonNull androidx.core.view.inputmethod.InputConnectionCompat.OnCommitContentListener r9) {
        /*
            r0 = 0
            if (r8 != 0) goto L_0x0004
            return r0
        L_0x0004:
            java.lang.String r1 = "androidx.core.view.inputmethod.InputConnectionCompat.COMMIT_CONTENT"
            boolean r1 = android.text.TextUtils.equals(r1, r7)
            if (r1 == 0) goto L_0x000e
            r7 = 0
            goto L_0x0017
        L_0x000e:
            java.lang.String r1 = "android.support.v13.view.inputmethod.InputConnectionCompat.COMMIT_CONTENT"
            boolean r7 = android.text.TextUtils.equals(r1, r7)
            if (r7 == 0) goto L_0x0082
            r7 = 1
        L_0x0017:
            r1 = 0
            if (r7 == 0) goto L_0x0020
            java.lang.String r2 = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_RESULT_RECEIVER"
            goto L_0x0022
        L_0x001d:
            r7 = move-exception
            r2 = r1
            goto L_0x007c
        L_0x0020:
            java.lang.String r2 = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_RESULT_RECEIVER"
        L_0x0022:
            android.os.Parcelable r2 = r8.getParcelable(r2)     // Catch:{ all -> 0x001d }
            android.os.ResultReceiver r2 = (android.os.ResultReceiver) r2     // Catch:{ all -> 0x001d }
            if (r7 == 0) goto L_0x002f
            java.lang.String r3 = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_URI"
            goto L_0x0031
        L_0x002d:
            r7 = move-exception
            goto L_0x007c
        L_0x002f:
            java.lang.String r3 = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_URI"
        L_0x0031:
            android.os.Parcelable r3 = r8.getParcelable(r3)     // Catch:{ all -> 0x002d }
            android.net.Uri r3 = (android.net.Uri) r3     // Catch:{ all -> 0x002d }
            if (r7 == 0) goto L_0x003c
            java.lang.String r4 = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_DESCRIPTION"
            goto L_0x003e
        L_0x003c:
            java.lang.String r4 = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_DESCRIPTION"
        L_0x003e:
            android.os.Parcelable r4 = r8.getParcelable(r4)     // Catch:{ all -> 0x002d }
            android.content.ClipDescription r4 = (android.content.ClipDescription) r4     // Catch:{ all -> 0x002d }
            if (r7 == 0) goto L_0x0049
            java.lang.String r5 = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_LINK_URI"
            goto L_0x004b
        L_0x0049:
            java.lang.String r5 = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_LINK_URI"
        L_0x004b:
            android.os.Parcelable r5 = r8.getParcelable(r5)     // Catch:{ all -> 0x002d }
            android.net.Uri r5 = (android.net.Uri) r5     // Catch:{ all -> 0x002d }
            if (r7 == 0) goto L_0x0056
            java.lang.String r6 = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_FLAGS"
            goto L_0x0058
        L_0x0056:
            java.lang.String r6 = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_FLAGS"
        L_0x0058:
            int r6 = r8.getInt(r6)     // Catch:{ all -> 0x002d }
            if (r7 == 0) goto L_0x0061
            java.lang.String r7 = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_OPTS"
            goto L_0x0063
        L_0x0061:
            java.lang.String r7 = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_OPTS"
        L_0x0063:
            android.os.Parcelable r7 = r8.getParcelable(r7)     // Catch:{ all -> 0x002d }
            android.os.Bundle r7 = (android.os.Bundle) r7     // Catch:{ all -> 0x002d }
            if (r3 == 0) goto L_0x0076
            if (r4 == 0) goto L_0x0076
            androidx.core.view.inputmethod.InputContentInfoCompat r8 = new androidx.core.view.inputmethod.InputContentInfoCompat     // Catch:{ all -> 0x002d }
            r8.<init>(r3, r4, r5)     // Catch:{ all -> 0x002d }
            boolean r0 = r9.a(r8, r6, r7)     // Catch:{ all -> 0x002d }
        L_0x0076:
            if (r2 == 0) goto L_0x007b
            r2.send(r0, r1)
        L_0x007b:
            return r0
        L_0x007c:
            if (r2 == 0) goto L_0x0081
            r2.send(r0, r1)
        L_0x0081:
            throw r7
        L_0x0082:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.view.inputmethod.InputConnectionCompat.f(java.lang.String, android.os.Bundle, androidx.core.view.inputmethod.InputConnectionCompat$OnCommitContentListener):boolean");
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ boolean g(View view, InputContentInfoCompat inputContentInfoCompat, int i2, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 25 && (i2 & 1) != 0) {
            try {
                inputContentInfoCompat.e();
                Parcelable parcelable = (Parcelable) inputContentInfoCompat.f();
                bundle = bundle == null ? new Bundle() : new Bundle(bundle);
                bundle.putParcelable(q, parcelable);
            } catch (Exception e2) {
                Log.w(f6717a, "Can't insert content from IME; requestPermission() failed", e2);
                return false;
            }
        }
        return ViewCompat.s1(view, new ContentInfoCompat.Builder(new ClipData(inputContentInfoCompat.b(), new ClipData.Item(inputContentInfoCompat.a())), 2).e(inputContentInfoCompat.c()).c(bundle).a()) == null;
    }
}
