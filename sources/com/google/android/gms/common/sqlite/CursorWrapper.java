package com.google.android.gms.common.sqlite;

import android.database.AbstractWindowedCursor;
import android.database.CrossProcessCursor;
import android.database.Cursor;
import android.database.CursorWindow;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;

@KeepForSdk
public class CursorWrapper extends android.database.CursorWrapper implements CrossProcessCursor {
    private AbstractWindowedCursor s;

    @KeepForSdk
    public CursorWrapper(@NonNull Cursor cursor) {
        super(cursor);
        for (int i2 = 0; i2 < 10 && (cursor instanceof android.database.CursorWrapper); i2++) {
            cursor = ((android.database.CursorWrapper) cursor).getWrappedCursor();
        }
        if (cursor instanceof AbstractWindowedCursor) {
            this.s = (AbstractWindowedCursor) cursor;
            return;
        }
        throw new IllegalArgumentException("Unknown type: ".concat(cursor.getClass().getName()));
    }

    @KeepForSdk
    public void b(@Nullable CursorWindow cursorWindow) {
        this.s.setWindow(cursorWindow);
    }

    @KeepForSdk
    public void fillWindow(int i2, @NonNull CursorWindow cursorWindow) {
        this.s.fillWindow(i2, cursorWindow);
    }

    @ResultIgnorabilityUnspecified
    @KeepForSdk
    @Nullable
    public CursorWindow getWindow() {
        return this.s.getWindow();
    }

    @NonNull
    public final /* synthetic */ Cursor getWrappedCursor() {
        return this.s;
    }

    @ResultIgnorabilityUnspecified
    public final boolean onMove(int i2, int i3) {
        return this.s.onMove(i2, i3);
    }
}
