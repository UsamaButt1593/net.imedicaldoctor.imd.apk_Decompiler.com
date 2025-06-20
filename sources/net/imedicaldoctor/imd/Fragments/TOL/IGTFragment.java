package net.imedicaldoctor.imd.Fragments.TOL;

import android.content.DialogInterface;
import android.os.Bundle;
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
import java.util.Date;
import java.util.Random;
import net.imedicaldoctor.imd.Data.CompressHelper;
import net.imedicaldoctor.imd.R;

public class IGTFragment extends Fragment {
    public int[] A4;
    public long e4;
    public TextView f4;
    public TextView g4;
    public TextView h4;
    public TextView i4;
    public LinearLayout j4;
    public LinearLayout k4;
    public LinearLayout l4;
    public LinearLayout m4;
    public RelativeLayout n4;
    public TextView o4;
    public TextView p4;
    public int q4;
    public int r4;
    public int s4;
    public int t4;
    public ImageView u4;
    public ImageView v4;
    public ImageView w4;
    public ImageView x4;
    public Long y4;
    public Random z4;

    public static IGTFragment J2() {
        return new IGTFragment();
    }

    public String K2(long j2) {
        return (j2 + "").replace(IcyHeaders.a3, "۱").replace(ExifInterface.Y4, "۲").replace(ExifInterface.Z4, "۳").replace("4", "۴").replace("5", "۵").replace("6", "۶").replace("7", "۷").replace("8", "۸").replace("9", "۹").replace("0", "۰");
    }

    public void L2() {
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
                    r = IGTFragment.this.r();
                    str = "لطفا یک نام وارد کنید";
                } else {
                    CompressHelper compressHelper = compressHelper;
                    String R = compressHelper.R();
                    compressHelper.q(R, "Insert into igt values (null, '" + a1 + "', " + IGTFragment.this.r4 + ", " + IGTFragment.this.y4 + ", " + IGTFragment.this.A4[0] + ", " + IGTFragment.this.A4[1] + ", " + IGTFragment.this.A4[2] + ", " + IGTFragment.this.A4[3] + ", " + IGTFragment.this.t4 + ", " + IGTFragment.this.s4 + ", '" + format + "')");
                    r = IGTFragment.this.r();
                    str = "با موفقیت ذخیره شد";
                }
                CompressHelper.x2(r, str, 1);
            }
        }).p("بستن", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i2) {
            }
        }).I();
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00b0  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00f8  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x01fa  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void M2(int r13) {
        /*
            r12 = this;
            r0 = 1
            if (r13 != r0) goto L_0x0006
            android.widget.ImageView r1 = r12.u4
            goto L_0x0007
        L_0x0006:
            r1 = 0
        L_0x0007:
            r2 = 2
            if (r13 != r2) goto L_0x000c
            android.widget.ImageView r1 = r12.v4
        L_0x000c:
            r3 = 3
            if (r13 != r3) goto L_0x0011
            android.widget.ImageView r1 = r12.w4
        L_0x0011:
            r4 = 4
            if (r13 != r4) goto L_0x0016
            android.widget.ImageView r1 = r12.x4
        L_0x0016:
            r5 = 2131230954(0x7f0800ea, float:1.8077975E38)
            r1.setImageResource(r5)
            java.util.Timer r5 = new java.util.Timer
            r5.<init>()
            net.imedicaldoctor.imd.Fragments.TOL.IGTFragment$9 r6 = new net.imedicaldoctor.imd.Fragments.TOL.IGTFragment$9
            r6.<init>(r1)
            r7 = 300(0x12c, double:1.48E-321)
            r5.schedule(r6, r7)
            java.util.Random r1 = r12.z4
            boolean r1 = r1.nextBoolean()
            if (r1 == 0) goto L_0x0039
            int r5 = r12.s4
            int r5 = r5 + r0
            r12.s4 = r5
            goto L_0x003e
        L_0x0039:
            int r5 = r12.t4
            int r5 = r5 + r0
            r12.t4 = r5
        L_0x003e:
            r5 = 0
            if (r13 == r0) goto L_0x0053
            if (r13 != r2) goto L_0x0044
            goto L_0x0053
        L_0x0044:
            if (r13 == r3) goto L_0x004c
            if (r13 != r4) goto L_0x0049
            goto L_0x004c
        L_0x0049:
            r4 = 0
        L_0x004a:
            r6 = 0
            goto L_0x0059
        L_0x004c:
            r4 = 50
            if (r1 == 0) goto L_0x004a
            r6 = 50
            goto L_0x0059
        L_0x0053:
            r4 = 100
            if (r1 == 0) goto L_0x004a
            r6 = 250(0xfa, float:3.5E-43)
        L_0x0059:
            android.widget.TextView r7 = r12.g4
            r7.setVisibility(r5)
            android.widget.TextView r7 = r12.g4
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            long r9 = (long) r4
            java.lang.String r9 = r12.K2(r9)
            r8.append(r9)
            java.lang.String r9 = " دلار جایزه گرفتید"
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            r7.setText(r8)
            if (r1 == 0) goto L_0x009c
            android.widget.TextView r1 = r12.h4
            r1.setVisibility(r5)
            android.widget.TextView r1 = r12.h4
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            long r8 = (long) r6
            java.lang.String r8 = r12.K2(r8)
            r7.append(r8)
            java.lang.String r8 = " دلار جریمه شدید"
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            r1.setText(r7)
            goto L_0x00a3
        L_0x009c:
            android.widget.TextView r1 = r12.h4
            r7 = 8
            r1.setVisibility(r7)
        L_0x00a3:
            int r4 = r4 - r6
            if (r4 <= 0) goto L_0x00b0
            androidx.fragment.app.FragmentActivity r1 = r12.r()
            java.lang.String r6 = "win.mp3"
        L_0x00ac:
            net.imedicaldoctor.imd.Data.CompressHelper.V1(r1, r6)
            goto L_0x00c2
        L_0x00b0:
            if (r4 != 0) goto L_0x00b9
            androidx.fragment.app.FragmentActivity r1 = r12.r()
            java.lang.String r6 = "nothing.mp3"
            goto L_0x00ac
        L_0x00b9:
            if (r4 >= 0) goto L_0x00c2
            androidx.fragment.app.FragmentActivity r1 = r12.r()
            java.lang.String r6 = "lose.mp3"
            goto L_0x00ac
        L_0x00c2:
            int r1 = r12.r4
            int r1 = r1 + r4
            r12.r4 = r1
            android.widget.TextView r1 = r12.f4
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r6 = "موجودی شما : "
            r4.append(r6)
            int r7 = r12.r4
            long r7 = (long) r7
            java.lang.String r7 = r12.K2(r7)
            r4.append(r7)
            java.lang.String r7 = " دلار"
            r4.append(r7)
            java.lang.String r4 = r4.toString()
            r1.setText(r4)
            int r1 = r12.q4
            int r1 = r1 - r0
            r12.q4 = r1
            int[] r4 = r12.A4
            int r13 = r13 - r0
            r8 = r4[r13]
            int r8 = r8 + r0
            r4[r13] = r8
            if (r1 != 0) goto L_0x01fa
            long r8 = java.lang.System.currentTimeMillis()
            long r10 = r12.e4
            long r8 = r8 - r10
            java.lang.Long r13 = java.lang.Long.valueOf(r8)
            r12.y4 = r13
            android.widget.RelativeLayout r13 = r12.n4
            r13.setVisibility(r5)
            android.widget.TextView r13 = r12.o4
            java.lang.String r1 = "آزمون به پایان رسید.\n با تشکر از همراهی شما"
            r13.setText(r1)
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            r13.append(r6)
            int r1 = r12.r4
            long r10 = (long) r1
            java.lang.String r1 = r12.K2(r10)
            r13.append(r1)
            r13.append(r7)
            java.lang.String r13 = r13.toString()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r13)
            java.lang.String r13 = "\nزمان آزمون : "
            r1.append(r13)
            r6 = 1000(0x3e8, double:4.94E-321)
            long r8 = r8 / r6
            java.lang.String r13 = r12.K2(r8)
            r1.append(r13)
            java.lang.String r13 = " ثانیه"
            r1.append(r13)
            java.lang.String r13 = r1.toString()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r13)
            java.lang.String r13 = "\nتعداد انتخاب ستون ۱ : "
            r1.append(r13)
            int[] r13 = r12.A4
            r13 = r13[r5]
            long r4 = (long) r13
            java.lang.String r13 = r12.K2(r4)
            r1.append(r13)
            java.lang.String r13 = r1.toString()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r13)
            java.lang.String r13 = "\nتعداد انتخاب ستون ۲ : "
            r1.append(r13)
            int[] r13 = r12.A4
            r13 = r13[r0]
            long r4 = (long) r13
            java.lang.String r13 = r12.K2(r4)
            r1.append(r13)
            java.lang.String r13 = r1.toString()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r13)
            java.lang.String r13 = "\nتعداد انتخاب ستون ۳ : "
            r0.append(r13)
            int[] r13 = r12.A4
            r13 = r13[r2]
            long r1 = (long) r13
            java.lang.String r13 = r12.K2(r1)
            r0.append(r13)
            java.lang.String r13 = r0.toString()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r13)
            java.lang.String r13 = "\nتعداد انتخاب ستون ۴ : "
            r0.append(r13)
            int[] r13 = r12.A4
            r13 = r13[r3]
            long r1 = (long) r13
            java.lang.String r13 = r12.K2(r1)
            r0.append(r13)
            java.lang.String r13 = r0.toString()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r13)
            java.lang.String r13 = "\nتعداد سود : "
            r0.append(r13)
            int r13 = r12.t4
            long r1 = (long) r13
            java.lang.String r13 = r12.K2(r1)
            r0.append(r13)
            java.lang.String r13 = r0.toString()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r13)
            java.lang.String r13 = "\nتعداد جریمه : "
            r0.append(r13)
            int r13 = r12.s4
            long r1 = (long) r13
            java.lang.String r13 = r12.K2(r1)
            r0.append(r13)
            java.lang.String r13 = r0.toString()
            android.widget.TextView r0 = r12.p4
            r0.setText(r13)
            goto L_0x0217
        L_0x01fa:
            android.widget.TextView r13 = r12.i4
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "انتخاب باقی مانده : "
            r0.append(r1)
            int r1 = r12.q4
            long r1 = (long) r1
            java.lang.String r1 = r12.K2(r1)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r13.setText(r0)
        L_0x0217:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.imedicaldoctor.imd.Fragments.TOL.IGTFragment.M2(int):void");
    }

    @Nullable
    public View onFragmentBind(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.f1292igt_fragment, viewGroup, false);
        r().getWindow().setFlags(1024, 1024);
        this.f4 = (TextView) inflate.findViewById(R.id.f1013money);
        this.g4 = (TextView) inflate.findViewById(R.id.f832benefit);
        this.h4 = (TextView) inflate.findViewById(R.id.f1162zarar);
        this.i4 = (TextView) inflate.findViewById(R.id.f1151trials);
        this.j4 = (LinearLayout) inflate.findViewById(R.id.f1082stack1);
        this.k4 = (LinearLayout) inflate.findViewById(R.id.f1083stack2);
        this.l4 = (LinearLayout) inflate.findViewById(R.id.f1084stack3);
        this.m4 = (LinearLayout) inflate.findViewById(R.id.f1085stack4);
        this.u4 = (ImageView) inflate.findViewById(R.id.f976image1);
        this.v4 = (ImageView) inflate.findViewById(R.id.f977image2);
        this.w4 = (ImageView) inflate.findViewById(R.id.f978image3);
        this.x4 = (ImageView) inflate.findViewById(R.id.f979image4);
        this.o4 = (TextView) inflate.findViewById(R.id.f1034overlay_text_1);
        this.p4 = (TextView) inflate.findViewById(R.id.f1035overlay_text_2);
        this.n4 = (RelativeLayout) inflate.findViewById(R.id.f1033overlay_layout);
        this.q4 = 100;
        this.A4 = new int[]{0, 0, 0, 0};
        this.s4 = 0;
        this.t4 = 0;
        this.g4.setVisibility(8);
        this.h4.setVisibility(8);
        this.n4.setVisibility(0);
        this.r4 = 2000;
        this.f4.setText("موجودی شما : " + K2((long) this.r4) + " دلار");
        this.f4.setVisibility(0);
        this.o4.setText("به آزمون تصمیم گیری آیوا خوش آمدید");
        this.p4.setText(((("در این آزمون شما یکی از ۴ دسته موجود را انتخاب می کنید" + "\nبا انتخاب هر دسته مبلغی را برنده می شوید و گاهی مقداری جریمه می شوید که ممکن است از میزان برد شما بیشتر باشد.") + "\nشما در شروع ۲۰۰۰ دلار پول دارید و ۱۰۰ بار می توانید از بین ۴ دسته انتخاب کنید") + "\nهدف آزمون به دست آوردن بیشترین سود می باشد") + "\n\nبرای شروع کلیک کنید");
        this.n4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                IGTFragment iGTFragment = IGTFragment.this;
                if (iGTFragment.q4 > 0) {
                    iGTFragment.n4.setVisibility(8);
                    IGTFragment.this.e4 = System.currentTimeMillis();
                }
            }
        });
        this.n4.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                IGTFragment iGTFragment = IGTFragment.this;
                if (iGTFragment.q4 != 0) {
                    return false;
                }
                iGTFragment.L2();
                return true;
            }
        });
        this.z4 = new Random();
        this.j4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                IGTFragment.this.M2(1);
            }
        });
        this.k4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                IGTFragment.this.M2(2);
            }
        });
        this.l4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                IGTFragment.this.M2(3);
            }
        });
        this.m4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                IGTFragment.this.M2(4);
            }
        });
        return inflate;
    }
}
