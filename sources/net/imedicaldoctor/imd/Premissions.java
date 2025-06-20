package net.imedicaldoctor.imd;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;

public class Premissions extends Activity {
    private static final int X = 1;
    private final Context s;

    public Premissions(Context context) {
        this.s = context;
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        Context context;
        String str;
        if (i2 == 1) {
            if (iArr.length <= 0 || iArr[0] != 0) {
                context = this.s;
                str = "Permission Denied";
            } else {
                context = this.s;
                str = "Permission Granted";
            }
            Toast.makeText(context, str, 0).show();
        }
    }
}
