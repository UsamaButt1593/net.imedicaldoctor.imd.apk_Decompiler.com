package net.imedicaldoctor.imd;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.itextpdf.text.Annotation;
import com.itextpdf.tool.xml.html.HTML;
import net.imedicaldoctor.imd.Data.CompressHelper;

public class NotificationActivity extends AppCompatActivity implements View.OnClickListener {
    Button A3;
    TextView B3;
    TextView C3;
    String D3 = "StartCompaignDialogActivity";
    Dialog y3;
    Button z3;

    public void onClick(View view) {
        if (view.getId() == R.id.f1014moreinfo) {
            finish();
            this.y3.dismiss();
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    new CompressHelper(NotificationActivity.this).P(NotificationActivity.this.getIntent().getStringExtra(HTML.Tag.C));
                }
            }, 1000);
        } else if (view.getId() == R.id.f865cancel) {
            this.y3.dismiss();
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.f1393nothing);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View inflate = getLayoutInflater().inflate(R.layout.f1183activity_notification, (ViewGroup) null);
        builder.setView(inflate);
        AlertDialog create = builder.create();
        this.y3 = create;
        create.show();
        setFinishOnTouchOutside(false);
        this.y3.setCanceledOnTouchOutside(false);
        this.z3 = (Button) inflate.findViewById(R.id.f1014moreinfo);
        this.A3 = (Button) inflate.findViewById(R.id.f865cancel);
        this.B3 = (TextView) inflate.findViewById(R.id.f1022notification_title);
        this.C3 = (TextView) inflate.findViewById(R.id.f1021notification_content);
        this.B3.setText(getIntent().getStringExtra("title"));
        this.C3.setText(getIntent().getStringExtra(Annotation.i3));
        this.z3.setOnClickListener(this);
        this.A3.setOnClickListener(this);
        if (getIntent().getStringExtra(HTML.Tag.C).length() < 4) {
            this.z3.setVisibility(8);
        }
        this.y3.setOnDismissListener(new DialogInterface.OnDismissListener() {
            public void onDismiss(DialogInterface dialogInterface) {
                NotificationActivity.this.finish();
            }
        });
    }
}
