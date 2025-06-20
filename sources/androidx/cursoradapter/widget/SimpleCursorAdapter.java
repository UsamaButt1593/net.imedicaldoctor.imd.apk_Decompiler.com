package androidx.cursoradapter.widget;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.RestrictTo;

public class SimpleCursorAdapter extends ResourceCursorAdapter {
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected int[] h3;
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected int[] i3;
    private int j3 = -1;
    private CursorToStringConverter k3;
    private ViewBinder l3;
    String[] m3;

    public interface CursorToStringConverter {
        CharSequence a(Cursor cursor);
    }

    public interface ViewBinder {
        boolean a(View view, Cursor cursor, int i2);
    }

    @Deprecated
    public SimpleCursorAdapter(Context context, int i2, Cursor cursor, String[] strArr, int[] iArr) {
        super(context, i2, cursor);
        this.i3 = iArr;
        this.m3 = strArr;
        q(cursor, strArr);
    }

    private void q(Cursor cursor, String[] strArr) {
        if (cursor != null) {
            int length = strArr.length;
            int[] iArr = this.h3;
            if (iArr == null || iArr.length != length) {
                this.h3 = new int[length];
            }
            for (int i2 = 0; i2 < length; i2++) {
                this.h3[i2] = cursor.getColumnIndexOrThrow(strArr[i2]);
            }
            return;
        }
        this.h3 = null;
    }

    public CharSequence a(Cursor cursor) {
        CursorToStringConverter cursorToStringConverter = this.k3;
        if (cursorToStringConverter != null) {
            return cursorToStringConverter.a(cursor);
        }
        int i2 = this.j3;
        return i2 > -1 ? cursor.getString(i2) : super.a(cursor);
    }

    public void e(View view, Context context, Cursor cursor) {
        ViewBinder viewBinder = this.l3;
        int[] iArr = this.i3;
        int length = iArr.length;
        int[] iArr2 = this.h3;
        for (int i2 = 0; i2 < length; i2++) {
            View findViewById = view.findViewById(iArr[i2]);
            if (findViewById != null) {
                if (viewBinder != null ? viewBinder.a(findViewById, cursor, iArr2[i2]) : false) {
                    continue;
                } else {
                    String string = cursor.getString(iArr2[i2]);
                    if (string == null) {
                        string = "";
                    }
                    if (findViewById instanceof TextView) {
                        y((TextView) findViewById, string);
                    } else if (findViewById instanceof ImageView) {
                        x((ImageView) findViewById, string);
                    } else {
                        throw new IllegalStateException(findViewById.getClass().getName() + " is not a " + " view that can be bounds by this SimpleCursorAdapter");
                    }
                }
            }
        }
    }

    public Cursor m(Cursor cursor) {
        q(cursor, this.m3);
        return super.m(cursor);
    }

    public void p(Cursor cursor, String[] strArr, int[] iArr) {
        this.m3 = strArr;
        this.i3 = iArr;
        q(cursor, strArr);
        super.b(cursor);
    }

    public CursorToStringConverter r() {
        return this.k3;
    }

    public int s() {
        return this.j3;
    }

    public ViewBinder t() {
        return this.l3;
    }

    public void u(CursorToStringConverter cursorToStringConverter) {
        this.k3 = cursorToStringConverter;
    }

    public void v(int i2) {
        this.j3 = i2;
    }

    public void w(ViewBinder viewBinder) {
        this.l3 = viewBinder;
    }

    public void x(ImageView imageView, String str) {
        try {
            imageView.setImageResource(Integer.parseInt(str));
        } catch (NumberFormatException unused) {
            imageView.setImageURI(Uri.parse(str));
        }
    }

    public void y(TextView textView, String str) {
        textView.setText(str);
    }

    public SimpleCursorAdapter(Context context, int i2, Cursor cursor, String[] strArr, int[] iArr, int i4) {
        super(context, i2, cursor, i4);
        this.i3 = iArr;
        this.m3 = strArr;
        q(cursor, strArr);
    }
}
