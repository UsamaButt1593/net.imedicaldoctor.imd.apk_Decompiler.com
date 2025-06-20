package androidx.core.view.inputmethod;

import android.os.Bundle;
import android.view.View;
import androidx.core.view.inputmethod.InputConnectionCompat;

public final /* synthetic */ class d implements InputConnectionCompat.OnCommitContentListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ View f6738a;

    public /* synthetic */ d(View view) {
        this.f6738a = view;
    }

    public final boolean a(InputContentInfoCompat inputContentInfoCompat, int i2, Bundle bundle) {
        return InputConnectionCompat.g(this.f6738a, inputContentInfoCompat, i2, bundle);
    }
}
