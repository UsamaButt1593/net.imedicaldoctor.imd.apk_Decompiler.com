package androidx.appcompat.widget;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.text.Selection;
import android.text.Spannable;
import android.util.Log;
import android.view.DragEvent;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.view.ContentInfoCompat;
import androidx.core.view.ViewCompat;

final class AppCompatReceiveContentHelper {

    /* renamed from: a  reason: collision with root package name */
    private static final String f3127a = "ReceiveContent";

    @RequiresApi(24)
    private static final class OnDropApi24Impl {
        private OnDropApi24Impl() {
        }

        /* JADX INFO: finally extract failed */
        @DoNotInline
        static boolean a(@NonNull DragEvent dragEvent, @NonNull TextView textView, @NonNull Activity activity) {
            activity.requestDragAndDropPermissions(dragEvent);
            int offsetForPosition = textView.getOffsetForPosition(dragEvent.getX(), dragEvent.getY());
            textView.beginBatchEdit();
            try {
                Selection.setSelection((Spannable) textView.getText(), offsetForPosition);
                ViewCompat.s1(textView, new ContentInfoCompat.Builder(dragEvent.getClipData(), 3).a());
                textView.endBatchEdit();
                return true;
            } catch (Throwable th) {
                textView.endBatchEdit();
                throw th;
            }
        }

        @DoNotInline
        static boolean b(@NonNull DragEvent dragEvent, @NonNull View view, @NonNull Activity activity) {
            activity.requestDragAndDropPermissions(dragEvent);
            ViewCompat.s1(view, new ContentInfoCompat.Builder(dragEvent.getClipData(), 3).a());
            return true;
        }
    }

    private AppCompatReceiveContentHelper() {
    }

    static boolean a(@NonNull View view, @NonNull DragEvent dragEvent) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 31 && i2 >= 24 && dragEvent.getLocalState() == null && ViewCompat.k0(view) != null) {
            Activity c2 = c(view);
            if (c2 == null) {
                Log.i(f3127a, "Can't handle drop: no activity: view=" + view);
                return false;
            } else if (dragEvent.getAction() == 1) {
                return !(view instanceof TextView);
            } else {
                if (dragEvent.getAction() == 3) {
                    return view instanceof TextView ? OnDropApi24Impl.a(dragEvent, (TextView) view, c2) : OnDropApi24Impl.b(dragEvent, view, c2);
                }
            }
        }
        return false;
    }

    static boolean b(@NonNull TextView textView, int i2) {
        int i3 = 0;
        if (Build.VERSION.SDK_INT >= 31 || ViewCompat.k0(textView) == null || (i2 != 16908322 && i2 != 16908337)) {
            return false;
        }
        ClipboardManager clipboardManager = (ClipboardManager) textView.getContext().getSystemService("clipboard");
        ClipData primaryClip = clipboardManager == null ? null : clipboardManager.getPrimaryClip();
        if (primaryClip != null && primaryClip.getItemCount() > 0) {
            ContentInfoCompat.Builder builder = new ContentInfoCompat.Builder(primaryClip, 1);
            if (i2 != 16908322) {
                i3 = 1;
            }
            ViewCompat.s1(textView, builder.d(i3).a());
        }
        return true;
    }

    @Nullable
    static Activity c(@NonNull View view) {
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
        }
        return null;
    }
}
