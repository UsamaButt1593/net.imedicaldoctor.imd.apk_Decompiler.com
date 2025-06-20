package androidx.core.view.autofill;

import android.view.autofill.AutofillId;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import c.a;

public class AutofillIdCompat {

    /* renamed from: a  reason: collision with root package name */
    private final Object f6700a;

    @RequiresApi(26)
    private AutofillIdCompat(@NonNull AutofillId autofillId) {
        this.f6700a = autofillId;
    }

    @RequiresApi(26)
    @NonNull
    public static AutofillIdCompat b(@NonNull AutofillId autofillId) {
        return new AutofillIdCompat(autofillId);
    }

    @RequiresApi(26)
    @NonNull
    public AutofillId a() {
        return a.a(this.f6700a);
    }
}
