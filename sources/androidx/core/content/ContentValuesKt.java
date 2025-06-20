package androidx.core.content;

import android.content.ContentValues;
import kotlin.Metadata;
import kotlin.Pair;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a=\u0010\u0006\u001a\u00020\u00052.\u0010\u0004\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00010\u0000\"\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"", "Lkotlin/Pair;", "", "", "pairs", "Landroid/content/ContentValues;", "a", "([Lkotlin/Pair;)Landroid/content/ContentValues;", "core-ktx_release"}, k = 2, mv = {1, 8, 0})
public final class ContentValuesKt {
    @NotNull
    public static final ContentValues a(@NotNull Pair<String, ? extends Object>... pairArr) {
        ContentValues contentValues = new ContentValues(pairArr.length);
        for (Pair<String, ? extends Object> pair : pairArr) {
            String a2 = pair.a();
            Object b2 = pair.b();
            if (b2 == null) {
                contentValues.putNull(a2);
            } else if (b2 instanceof String) {
                contentValues.put(a2, (String) b2);
            } else if (b2 instanceof Integer) {
                contentValues.put(a2, (Integer) b2);
            } else if (b2 instanceof Long) {
                contentValues.put(a2, (Long) b2);
            } else if (b2 instanceof Boolean) {
                contentValues.put(a2, (Boolean) b2);
            } else if (b2 instanceof Float) {
                contentValues.put(a2, (Float) b2);
            } else if (b2 instanceof Double) {
                contentValues.put(a2, (Double) b2);
            } else if (b2 instanceof byte[]) {
                contentValues.put(a2, (byte[]) b2);
            } else if (b2 instanceof Byte) {
                contentValues.put(a2, (Byte) b2);
            } else if (b2 instanceof Short) {
                contentValues.put(a2, (Short) b2);
            } else {
                throw new IllegalArgumentException("Illegal value type " + b2.getClass().getCanonicalName() + " for key \"" + a2 + '\"');
            }
        }
        return contentValues;
    }
}
