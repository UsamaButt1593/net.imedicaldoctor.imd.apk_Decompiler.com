package net.imedicaldoctor.imd.Fragments.TOL;

import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.media3.extractor.metadata.icy.IcyHeaders;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import net.imedicaldoctor.imd.Data.CompressHelper;
import net.imedicaldoctor.imd.R;
import org.apache.commons.lang3.StringUtils;

public class TolFragment extends Fragment {
    public LinearLayout e4;
    public LinearLayout f4;
    public LinearLayout g4;
    public LinearLayout h4;
    public LinearLayout i4;
    public LinearLayout j4;
    public RelativeLayout k4;
    public TextView l4;
    public TextView m4;
    public ImageView n4;
    public TextView o4;
    public ArrayList<String> p4;
    public int q4;
    public String[] r4;
    public String[] s4;
    public long t4;
    public long u4;
    public long v4;

    public static TolFragment P2() {
        return new TolFragment();
    }

    /* access modifiers changed from: private */
    public void Q2(int i2) {
        this.v4++;
        if (this.n4.getVisibility() == 0) {
            this.s4[i2] = this.s4[i2] + this.n4.getTag().toString();
            this.n4.setVisibility(8);
        } else if (this.s4[i2].length() > 0) {
            String str = this.s4[i2];
            String substring = str.substring(str.length() - 1);
            String[] strArr = this.s4;
            String str2 = strArr[i2];
            strArr[i2] = str2.substring(0, str2.length() - 1);
            this.n4.setImageDrawable(N2(substring));
            this.n4.setVisibility(0);
            this.n4.setTag(substring);
        } else {
            return;
        }
        U2();
    }

    /* access modifiers changed from: private */
    public void R2() {
        if (this.q4 < this.p4.size() - 1) {
            O2();
            this.k4.setVisibility(8);
        }
    }

    public void L2(LinearLayout linearLayout, String str) {
        ImageView imageView = new ImageView(r());
        imageView.setImageDrawable(N2(str));
        Math.round(TypedValue.applyDimension(1, 150.0f, b0().getDisplayMetrics()));
        imageView.setLayoutParams(new LinearLayout.LayoutParams(-1, Math.round(TypedValue.applyDimension(1, 50.0f, b0().getDisplayMetrics()))));
        linearLayout.addView(imageView, 0);
    }

    public void M2(LinearLayout linearLayout, String str) {
        linearLayout.removeAllViews();
        for (char valueOf : str.toCharArray()) {
            L2(linearLayout, String.valueOf(valueOf));
        }
    }

    public Drawable N2(String str) {
        FragmentActivity r;
        int i2;
        if (str.equals("R")) {
            r = r();
            i2 = R.drawable.f768tolred;
        } else if (str.equals("B")) {
            r = r();
            i2 = R.drawable.f765tolblue;
        } else if (str.equals("G")) {
            r = r();
            i2 = R.drawable.f766tolgreen;
        } else if (str.equals("Y")) {
            r = r();
            i2 = R.drawable.f770tolyellow;
        } else if (!str.equals(ExifInterface.R4)) {
            return null;
        } else {
            r = r();
            i2 = R.drawable.f769tolyashmi;
        }
        return r.getDrawable(i2);
    }

    public void O2() {
        this.u4 = System.currentTimeMillis();
        this.q4++;
        this.o4.setText("مرحله " + S2((long) (this.q4 + 1)) + " از " + S2((long) this.p4.size()));
        String[] splitPreserveAllTokens = StringUtils.splitPreserveAllTokens(this.p4.get(this.q4), "-");
        this.r4 = new String[]{splitPreserveAllTokens[0], splitPreserveAllTokens[1], splitPreserveAllTokens[2]};
        this.s4 = new String[]{splitPreserveAllTokens[3], splitPreserveAllTokens[4], splitPreserveAllTokens[5]};
        U2();
    }

    public String S2(long j2) {
        return (j2 + "").replace(IcyHeaders.a3, "۱").replace(ExifInterface.Y4, "۲").replace(ExifInterface.Z4, "۳").replace("4", "۴").replace("5", "۵").replace("6", "۶").replace("7", "۷").replace("8", "۸").replace("9", "۹").replace("0", "۰");
    }

    public void T2() {
        final String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        final CompressHelper compressHelper = new CompressHelper(r());
        final EditText editText = new EditText(r());
        editText.setTextColor(b0().getColor(R.color.f140black));
        new AlertDialog.Builder(r(), R.style.f2185alertDialogTheme).l("لطفا نام و نام خانوادگی را وارد کنید").setView(editText).y("ذخیره", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i2) {
                FragmentActivity r;
                String str;
                String a1 = compressHelper.a1(editText.getText().toString());
                if (a1.length() == 0) {
                    r = TolFragment.this.r();
                    str = "لطفا یک نام وارد کنید";
                } else {
                    CompressHelper compressHelper = compressHelper;
                    String R = compressHelper.R();
                    compressHelper.q(R, "Insert into tol values (null, '" + a1 + "', " + TolFragment.this.t4 + ", " + TolFragment.this.v4 + ", '" + format + "')");
                    r = TolFragment.this.r();
                    str = "با موفقیت ذخیره شد";
                }
                CompressHelper.x2(r, str, 1);
            }
        }).p("بستن", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i2) {
            }
        }).I();
    }

    @Nullable
    public View onFragmentBind(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.f1391main_tol, viewGroup, false);
        r().getWindow().setFlags(1024, 1024);
        this.e4 = (LinearLayout) inflate.findViewById(R.id.f1144topleft);
        this.f4 = (LinearLayout) inflate.findViewById(R.id.f1145topmiddle);
        this.g4 = (LinearLayout) inflate.findViewById(R.id.f1146topright);
        this.h4 = (LinearLayout) inflate.findViewById(R.id.f846bottomleft);
        this.i4 = (LinearLayout) inflate.findViewById(R.id.f845bottomcenter);
        this.j4 = (LinearLayout) inflate.findViewById(R.id.f847bottomright);
        this.o4 = (TextView) inflate.findViewById(R.id.f1136title_text);
        this.l4 = (TextView) inflate.findViewById(R.id.f1034overlay_text_1);
        this.m4 = (TextView) inflate.findViewById(R.id.f1035overlay_text_2);
        this.k4 = (RelativeLayout) inflate.findViewById(R.id.f1033overlay_layout);
        this.n4 = (ImageView) inflate.findViewById(R.id.f981imagehand);
        this.p4 = new ArrayList<>(Arrays.asList(StringUtils.splitPreserveAllTokens(new CompressHelper(r()).f2(CompressHelper.g1(y().getBundle("DB"), "tol.txt")), StringUtils.LF)));
        this.q4 = -1;
        this.t4 = 0;
        this.v4 = 0;
        this.l4.setText("به بازی برج های لندن خوش آمدید");
        this.m4.setText((("هدف از این بازی جابجایی مهره ها در سه ستون پایین است تا مشابه ستون های بالا شوند." + "\nبا کلیک بر روی هر ستون ، مهره را می توانید بردارید") + "\nو با کلیک بر روی ستون دیگر آن مهره را به آنجا منتقل کنید.") + "\n\nبرای شروع کلیک کنید");
        this.k4.setVisibility(0);
        this.k4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                TolFragment.this.R2();
            }
        });
        this.k4.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                TolFragment tolFragment = TolFragment.this;
                if (tolFragment.q4 != tolFragment.p4.size() - 1) {
                    return false;
                }
                TolFragment.this.T2();
                return true;
            }
        });
        this.h4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                TolFragment.this.Q2(0);
            }
        });
        this.i4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                TolFragment.this.Q2(1);
            }
        });
        this.j4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                TolFragment.this.Q2(2);
            }
        });
        return inflate;
    }

    public void U2() {
        TextView textView;
        String str;
        M2(this.e4, this.r4[0]);
        M2(this.f4, this.r4[1]);
        M2(this.g4, this.r4[2]);
        M2(this.h4, this.s4[0]);
        M2(this.i4, this.s4[1]);
        M2(this.j4, this.s4[2]);
        if (StringUtils.join((Object[]) this.r4, "-").equals(StringUtils.join((Object[]) this.s4, "-"))) {
            CompressHelper.V1(r(), "success.mp3");
            this.t4 += System.currentTimeMillis() - this.u4;
            this.k4.setVisibility(0);
            if (this.q4 < this.p4.size() - 1) {
                this.l4.setText("مرحله با موفقیت به پایان رسید.");
                textView = this.m4;
                str = "برای ادامه کلیک کنید";
            } else {
                this.l4.setText("آزمون به پایان رسید .\n با تشکر فراوان از شما");
                textView = this.m4;
                str = "مجموع زمان : " + S2(this.t4 / 1000) + " ثانیه\nمجموع حرکات : " + S2(this.v4) + " تا";
            }
            textView.setText(str);
        }
    }

    public void V2(String str) {
        String[] splitPreserveAllTokens = StringUtils.splitPreserveAllTokens(str, "-");
        M2(this.e4, splitPreserveAllTokens[0]);
        M2(this.f4, splitPreserveAllTokens[1]);
        M2(this.g4, splitPreserveAllTokens[2]);
        M2(this.h4, splitPreserveAllTokens[3]);
        M2(this.i4, splitPreserveAllTokens[4]);
        M2(this.j4, splitPreserveAllTokens[5]);
    }
}
