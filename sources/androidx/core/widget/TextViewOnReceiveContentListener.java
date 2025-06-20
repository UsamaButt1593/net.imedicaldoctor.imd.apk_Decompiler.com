package androidx.core.widget;

import android.content.ClipData;
import android.content.Context;
import android.text.Editable;
import android.text.Selection;
import android.text.Spanned;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.view.ContentInfoCompat;
import androidx.core.view.OnReceiveContentListener;
import org.apache.commons.lang3.StringUtils;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class TextViewOnReceiveContentListener implements OnReceiveContentListener {

    /* renamed from: a  reason: collision with root package name */
    private static final String f6773a = "ReceiveContent";

    private static CharSequence b(@NonNull Context context, @NonNull ClipData.Item item, int i2) {
        if ((i2 & 1) == 0) {
            return item.coerceToStyledText(context);
        }
        CharSequence coerceToText = item.coerceToText(context);
        return coerceToText instanceof Spanned ? coerceToText.toString() : coerceToText;
    }

    private static void c(@NonNull Editable editable, @NonNull CharSequence charSequence) {
        int selectionStart = Selection.getSelectionStart(editable);
        int selectionEnd = Selection.getSelectionEnd(editable);
        int max = Math.max(0, Math.min(selectionStart, selectionEnd));
        int max2 = Math.max(0, Math.max(selectionStart, selectionEnd));
        Selection.setSelection(editable, max2);
        editable.replace(max, max2, charSequence);
    }

    @Nullable
    public ContentInfoCompat a(@NonNull View view, @NonNull ContentInfoCompat contentInfoCompat) {
        if (Log.isLoggable(f6773a, 3)) {
            Log.d(f6773a, "onReceive: " + contentInfoCompat);
        }
        if (contentInfoCompat.g() == 2) {
            return contentInfoCompat;
        }
        ClipData c2 = contentInfoCompat.c();
        int e2 = contentInfoCompat.e();
        TextView textView = (TextView) view;
        Editable editable = (Editable) textView.getText();
        Context context = textView.getContext();
        boolean z = false;
        for (int i2 = 0; i2 < c2.getItemCount(); i2++) {
            CharSequence b2 = b(context, c2.getItemAt(i2), e2);
            if (b2 != null) {
                if (!z) {
                    c(editable, b2);
                    z = true;
                } else {
                    editable.insert(Selection.getSelectionEnd(editable), StringUtils.LF);
                    editable.insert(Selection.getSelectionEnd(editable), b2);
                }
            }
        }
        return null;
    }
}
