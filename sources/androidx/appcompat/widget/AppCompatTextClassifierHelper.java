package androidx.appcompat.widget;

import android.view.textclassifier.TextClassificationManager;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.util.Preconditions;

final class AppCompatTextClassifierHelper {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private TextView f3137a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private TextClassifier f3138b;

    @RequiresApi(26)
    private static final class Api26Impl {
        private Api26Impl() {
        }

        @DoNotInline
        @NonNull
        static TextClassifier a(@NonNull TextView textView) {
            TextClassificationManager textClassificationManager = (TextClassificationManager) textView.getContext().getSystemService(TextClassificationManager.class);
            return textClassificationManager != null ? textClassificationManager.getTextClassifier() : TextClassifier.NO_OP;
        }
    }

    AppCompatTextClassifierHelper(@NonNull TextView textView) {
        this.f3137a = (TextView) Preconditions.l(textView);
    }

    @RequiresApi(api = 26)
    @NonNull
    public TextClassifier a() {
        TextClassifier textClassifier = this.f3138b;
        return textClassifier == null ? Api26Impl.a(this.f3137a) : textClassifier;
    }

    @RequiresApi(api = 26)
    public void b(@Nullable TextClassifier textClassifier) {
        this.f3138b = textClassifier;
    }
}
