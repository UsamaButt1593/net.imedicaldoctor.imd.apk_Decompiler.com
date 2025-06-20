package net.imedicaldoctor.imd.Fragments.VisualDDX;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import com.bumptech.glide.Glide;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import info.hoang8f.android.segmented.SegmentedGroup;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import net.imedicaldoctor.imd.Data.CompressHelper;
import net.imedicaldoctor.imd.R;
import net.imedicaldoctor.imd.iMDLogger;
import org.json.JSONObject;

public class VDDxBodyPartDialog extends DialogFragment {
    public RelativeLayout F4;
    /* access modifiers changed from: private */
    public Bundle G4;
    /* access modifiers changed from: private */
    public Bundle H4;
    private SegmentedGroup I4;
    /* access modifiers changed from: private */
    public ArrayList<Bundle> J4;
    /* access modifiers changed from: private */
    public ArrayList<Bundle> K4;
    /* access modifiers changed from: private */
    public String L4;

    public Dialog U2(Bundle bundle) {
        AlertDialog.Builder builder = new AlertDialog.Builder(r());
        View inflate = r().getLayoutInflater().inflate(R.layout.f1279fragment_vddx_body_part_dialog, (ViewGroup) null);
        final CompressHelper compressHelper = new CompressHelper(r());
        final ListView listView = (ListView) inflate.findViewById(R.id.f996list_view);
        this.F4 = (RelativeLayout) inflate.findViewById(R.id.f840body_parts);
        RadioButton radioButton = (RadioButton) inflate.findViewById(R.id.f852button1);
        RadioButton radioButton2 = (RadioButton) inflate.findViewById(R.id.f853button2);
        this.I4 = (SegmentedGroup) inflate.findViewById(R.id.f1070segment);
        RadioButton radioButton3 = (RadioButton) inflate.findViewById(R.id.f860buttongender1);
        RadioButton radioButton4 = (RadioButton) inflate.findViewById(R.id.f861buttongender2);
        SegmentedGroup segmentedGroup = (SegmentedGroup) inflate.findViewById(R.id.f1071segmentgender);
        this.G4 = y().getBundle("db");
        final Bundle bundle2 = y().getBundle("allFindings");
        this.J4 = y().getParcelableArrayList("distribution");
        this.K4 = y().getParcelableArrayList("location");
        final String string = y().getString("bodyFolder");
        this.L4 = CompressHelper.h1(this.G4, string, "BodyLocation");
        String str = this.L4 + "/info.js";
        this.I4.setSelected(true);
        try {
            JSONObject jSONObject = new JSONObject(CompressHelper.e2(new File(str)));
            o3(this.L4 + "/homunculus.gif");
            Bundle G = compressHelper.G(jSONObject);
            this.H4 = G;
            if (G.getParcelableArrayList("bodyDistribution").size() == 0) {
                radioButton2.setVisibility(8);
            }
            if (!bundle2.keySet().contains("20200")) {
                radioButton2.setVisibility(8);
            }
            final AnonymousClass1 r4 = new ArrayAdapter<Bundle>(r(), R.layout.f1369list_view_item_simple_text_check) {
                /* renamed from: a */
                public Bundle getItem(int i2) {
                    return (Bundle) VDDxBodyPartDialog.this.H4.getParcelableArrayList("bodyLocation").get(i2);
                }

                public int getCount() {
                    return VDDxBodyPartDialog.this.H4.getParcelableArrayList("bodyLocation").size();
                }

                public View getView(int i2, View view, ViewGroup viewGroup) {
                    if (view == null) {
                        view = LayoutInflater.from(VDDxBodyPartDialog.this.r()).inflate(R.layout.f1369list_view_item_simple_text_check, viewGroup, false);
                    }
                    Bundle a2 = getItem(i2);
                    TextView textView = (TextView) view.findViewById(R.id.text);
                    ImageView imageView = (ImageView) view.findViewById(R.id.f872check_icon);
                    String string = a2.getString("title");
                    if (string.length() == 0) {
                        string = bundle2.getString(a2.getStringArrayList("findingIds").get(0));
                    }
                    textView.setText(string);
                    if (CompressHelper.b(VDDxBodyPartDialog.this.K4, a2, "imageName") > -1 || CompressHelper.b(VDDxBodyPartDialog.this.J4, a2, "imageName") > -1) {
                        imageView.setVisibility(0);
                    } else {
                        imageView.setVisibility(4);
                    }
                    return view;
                }
            };
            final AnonymousClass2 r9 = new ArrayAdapter<Bundle>(r(), R.layout.f1369list_view_item_simple_text_check) {
                /* renamed from: a */
                public Bundle getItem(int i2) {
                    return (Bundle) VDDxBodyPartDialog.this.H4.getParcelableArrayList("bodyDistribution").get(i2);
                }

                public int getCount() {
                    return VDDxBodyPartDialog.this.H4.getParcelableArrayList("bodyDistribution").size();
                }

                public View getView(int i2, View view, ViewGroup viewGroup) {
                    if (view == null) {
                        view = LayoutInflater.from(VDDxBodyPartDialog.this.r()).inflate(R.layout.f1369list_view_item_simple_text_check, viewGroup, false);
                    }
                    Bundle a2 = getItem(i2);
                    TextView textView = (TextView) view.findViewById(R.id.text);
                    ImageView imageView = (ImageView) view.findViewById(R.id.f872check_icon);
                    String string = a2.getString("title");
                    if (string.length() == 0) {
                        string = bundle2.getString(a2.getStringArrayList("findingIds").get(0));
                    }
                    textView.setText(string);
                    if (CompressHelper.b(VDDxBodyPartDialog.this.K4, a2, "imageName") > -1 || CompressHelper.b(VDDxBodyPartDialog.this.J4, a2, "imageName") > -1) {
                        imageView.setVisibility(0);
                    } else {
                        imageView.setVisibility(4);
                    }
                    return view;
                }
            };
            listView.setAdapter(r4);
            this.I4.check(R.id.f852button1);
            segmentedGroup.check(R.id.f860buttongender1);
            this.I4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                public void onCheckedChanged(RadioGroup radioGroup, int i2) {
                    ListView listView;
                    ArrayAdapter arrayAdapter;
                    if (i2 == R.id.f852button1) {
                        listView = listView;
                        arrayAdapter = r4;
                    } else {
                        listView = listView;
                        arrayAdapter = r9;
                    }
                    listView.setAdapter(arrayAdapter);
                    VDDxBodyPartDialog.this.p3();
                }
            });
            segmentedGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                public void onCheckedChanged(RadioGroup radioGroup, int i2) {
                    VDDxBodyPartDialog vDDxBodyPartDialog;
                    Bundle m3;
                    String replace;
                    if (i2 == R.id.f860buttongender1) {
                        vDDxBodyPartDialog = VDDxBodyPartDialog.this;
                        m3 = vDDxBodyPartDialog.G4;
                        replace = string.replace("Female", "Male");
                    } else {
                        vDDxBodyPartDialog = VDDxBodyPartDialog.this;
                        m3 = vDDxBodyPartDialog.G4;
                        replace = string.replace("Male", "Female");
                    }
                    String unused = vDDxBodyPartDialog.L4 = CompressHelper.h1(m3, replace, "BodyLocation");
                    try {
                        Bundle unused2 = VDDxBodyPartDialog.this.H4 = compressHelper.G(new JSONObject(CompressHelper.e2(new File(VDDxBodyPartDialog.this.L4 + "/info.js"))));
                        VDDxBodyPartDialog vDDxBodyPartDialog2 = VDDxBodyPartDialog.this;
                        vDDxBodyPartDialog2.o3(VDDxBodyPartDialog.this.L4 + "/homunculus.gif");
                        VDDxBodyPartDialog.this.F4.removeAllViews();
                        VDDxBodyPartDialog vDDxBodyPartDialog3 = VDDxBodyPartDialog.this;
                        vDDxBodyPartDialog3.o3(VDDxBodyPartDialog.this.L4 + "/homunculus.gif");
                        ListView listView = listView;
                        listView.setAdapter(listView.getAdapter());
                        VDDxBodyPartDialog.this.p3();
                    } catch (Exception unused3) {
                    }
                }
            });
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                /* JADX WARNING: type inference failed for: r3v0, types: [android.widget.AdapterView<?>, android.widget.AdapterView] */
                /* JADX WARNING: Unknown variable types count: 1 */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void onItemClick(android.widget.AdapterView<?> r3, android.view.View r4, int r5, long r6) {
                    /*
                        r2 = this;
                        net.imedicaldoctor.imd.Fragments.VisualDDX.VDDxBodyPartDialog r4 = net.imedicaldoctor.imd.Fragments.VisualDDX.VDDxBodyPartDialog.this
                        androidx.fragment.app.Fragment r4 = r4.l0()
                        net.imedicaldoctor.imd.Fragments.VisualDDX.VDDxBuilderActivity$VDDXBuilderFragment r4 = (net.imedicaldoctor.imd.Fragments.VisualDDX.VDDxBuilderActivity.VDDXBuilderFragment) r4
                        android.widget.Adapter r6 = r3.getAdapter()
                        android.widget.ArrayAdapter r7 = r4
                        r0 = -1
                        java.lang.String r1 = "imageName"
                        if (r6 != r7) goto L_0x0037
                        android.widget.Adapter r6 = r3.getAdapter()
                        java.lang.Object r5 = r6.getItem(r5)
                        android.os.Bundle r5 = (android.os.Bundle) r5
                        net.imedicaldoctor.imd.Fragments.VisualDDX.VDDxBodyPartDialog r6 = net.imedicaldoctor.imd.Fragments.VisualDDX.VDDxBodyPartDialog.this
                        java.util.ArrayList r6 = r6.K4
                        int r6 = net.imedicaldoctor.imd.Data.CompressHelper.b(r6, r5, r1)
                        if (r6 <= r0) goto L_0x0030
                        net.imedicaldoctor.imd.Fragments.VisualDDX.VDDxBodyPartDialog r5 = net.imedicaldoctor.imd.Fragments.VisualDDX.VDDxBodyPartDialog.this
                        java.util.ArrayList r5 = r5.K4
                        goto L_0x0053
                    L_0x0030:
                        net.imedicaldoctor.imd.Fragments.VisualDDX.VDDxBodyPartDialog r6 = net.imedicaldoctor.imd.Fragments.VisualDDX.VDDxBodyPartDialog.this
                        java.util.ArrayList r6 = r6.K4
                        goto L_0x0060
                    L_0x0037:
                        android.widget.Adapter r6 = r3.getAdapter()
                        java.lang.Object r5 = r6.getItem(r5)
                        android.os.Bundle r5 = (android.os.Bundle) r5
                        net.imedicaldoctor.imd.Fragments.VisualDDX.VDDxBodyPartDialog r6 = net.imedicaldoctor.imd.Fragments.VisualDDX.VDDxBodyPartDialog.this
                        java.util.ArrayList r6 = r6.J4
                        int r6 = net.imedicaldoctor.imd.Data.CompressHelper.b(r6, r5, r1)
                        if (r6 <= r0) goto L_0x005a
                        net.imedicaldoctor.imd.Fragments.VisualDDX.VDDxBodyPartDialog r5 = net.imedicaldoctor.imd.Fragments.VisualDDX.VDDxBodyPartDialog.this
                        java.util.ArrayList r5 = r5.J4
                    L_0x0053:
                        r5.remove(r6)
                    L_0x0056:
                        r4.J4()
                        goto L_0x0064
                    L_0x005a:
                        net.imedicaldoctor.imd.Fragments.VisualDDX.VDDxBodyPartDialog r6 = net.imedicaldoctor.imd.Fragments.VisualDDX.VDDxBodyPartDialog.this
                        java.util.ArrayList r6 = r6.J4
                    L_0x0060:
                        r6.add(r5)
                        goto L_0x0056
                    L_0x0064:
                        android.widget.Adapter r3 = r3.getAdapter()
                        android.widget.ArrayAdapter r3 = (android.widget.ArrayAdapter) r3
                        r3.notifyDataSetChanged()
                        net.imedicaldoctor.imd.Fragments.VisualDDX.VDDxBodyPartDialog r3 = net.imedicaldoctor.imd.Fragments.VisualDDX.VDDxBodyPartDialog.this
                        r3.p3()
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: net.imedicaldoctor.imd.Fragments.VisualDDX.VDDxBodyPartDialog.AnonymousClass5.onItemClick(android.widget.AdapterView, android.view.View, int, long):void");
                }
            });
        } catch (Exception e2) {
            FirebaseCrashlytics.d().g(e2);
            iMDLogger.f("VDDxBodyDialog", "Error in dialog : " + e2);
        }
        builder.setView(inflate);
        return builder.create();
    }

    public void n3(String str) {
        String str2 = this.L4 + "/" + str + "_highlight.png";
        if (!new File(str2).exists()) {
            str2 = this.L4 + "/" + str + ".png";
        }
        View findViewWithTag = this.F4.findViewWithTag(str2);
        if (findViewWithTag != null) {
            findViewWithTag.setVisibility(0);
            return;
        }
        ImageView imageView = new ImageView(r());
        Glide.G(r()).i(new File(str2)).B2(imageView);
        imageView.setTag(str2);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setLayoutParams(layoutParams);
        this.F4.addView(imageView);
    }

    public void o3(String str) {
        if (this.F4.findViewWithTag(str) == null) {
            ImageView imageView = new ImageView(r());
            Glide.G(r()).i(new File(str)).B2(imageView);
            imageView.setTag(str);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setLayoutParams(layoutParams);
            this.F4.addView(imageView);
        }
    }

    public void p3() {
        ArrayList<Bundle> arrayList = this.I4.getCheckedRadioButtonId() == R.id.f852button1 ? this.K4 : this.J4;
        Iterator it2 = this.H4.getParcelableArrayList("bodyLocation").iterator();
        while (it2.hasNext()) {
            Bundle bundle = (Bundle) it2.next();
            int b2 = CompressHelper.b(arrayList, bundle, "imageName");
            String string = bundle.getString("imageName");
            if (b2 > -1) {
                n3(string);
            } else {
                q3(string);
            }
        }
        Iterator it3 = this.H4.getParcelableArrayList("bodyDistribution").iterator();
        while (it3.hasNext()) {
            Bundle bundle2 = (Bundle) it3.next();
            int b3 = CompressHelper.b(arrayList, bundle2, "imageName");
            String string2 = bundle2.getString("imageName");
            if (b3 > -1) {
                n3(string2);
            } else {
                q3(string2);
            }
        }
    }

    public void q3(String str) {
        String str2 = this.L4 + "/" + str + "_highlight.png";
        if (!new File(str2).exists()) {
            str2 = this.L4 + "/" + str + ".png";
        }
        View findViewWithTag = this.F4.findViewWithTag(str2);
        if (findViewWithTag != null) {
            findViewWithTag.setVisibility(4);
        }
    }
}
