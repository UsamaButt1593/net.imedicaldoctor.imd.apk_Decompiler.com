package net.imedicaldoctor.imd;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import java.util.Timer;
import java.util.TimerTask;

public class extractingFragment extends DialogFragment {
    /* access modifiers changed from: private */
    public int F4 = 0;

    static /* synthetic */ int i3(extractingFragment extractingfragment, int i2) {
        int i3 = extractingfragment.F4 + i2;
        extractingfragment.F4 = i3;
        return i3;
    }

    public Dialog U2(Bundle bundle) {
        AlertDialog.Builder builder = new AlertDialog.Builder(r());
        View inflate = r().getLayoutInflater().inflate(R.layout.f1229fragment_extracting, (ViewGroup) null);
        r().setFinishOnTouchOutside(false);
        final TextView textView = (TextView) inflate.findViewById(R.id.f1136title_text);
        final String string = y().getString("MESSAGE");
        textView.setText(string);
        new Timer().schedule(new TimerTask() {
            public void run() {
                extractingFragment.i3(extractingFragment.this, 1);
                final String str = "";
                for (int i2 = 0; i2 < extractingFragment.this.F4; i2++) {
                    str = str + ".";
                }
                textView.post(new Runnable() {
                    public void run() {
                        TextView textView = textView;
                        textView.setText(string + str);
                    }
                });
                if (extractingFragment.this.F4 >= 3) {
                    int unused = extractingFragment.this.F4 = 0;
                }
            }
        }, 0, 1000);
        builder.setView(inflate);
        return builder.create();
    }
}
