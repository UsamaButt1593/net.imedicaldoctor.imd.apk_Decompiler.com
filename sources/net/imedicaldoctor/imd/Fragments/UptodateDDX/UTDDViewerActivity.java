package net.imedicaldoctor.imd.Fragments.UptodateDDX;

import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import java.util.ArrayList;
import net.imedicaldoctor.imd.Data.CompressHelper;
import net.imedicaldoctor.imd.Fragments.ViewerHelperActivity;
import net.imedicaldoctor.imd.Fragments.ViewerHelperFragment;
import net.imedicaldoctor.imd.R;

public class UTDDViewerActivity extends ViewerHelperActivity {

    public static class UTDDViewerFragment extends ViewerHelperFragment {
        /* access modifiers changed from: private */
        public ArrayList<Bundle> X4;
        /* access modifiers changed from: private */
        public ArrayList<Bundle> Y4;
        /* access modifiers changed from: private */
        public ArrayList<Bundle> Z4;
        private ListView a5;
        /* access modifiers changed from: private */
        public BaseAdapter b5;

        public void M4() {
            ((ListView) this.C4.findViewById(R.id.f996list_view)).setVisibility(0);
            ((TextView) this.C4.findViewById(R.id.f1086status_label)).setVisibility(8);
            ((LinearLayout) this.C4.findViewById(R.id.f1087status_layout)).setVisibility(8);
        }

        public void T0(Menu menu, MenuInflater menuInflater) {
            menuInflater.inflate(R.menu.f1483menu_utddviewer, menu);
            q4(menu);
        }

        public View onFragmentBind(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            View inflate = layoutInflater.inflate(R.layout.f1272fragment_utdd_viewer, viewGroup, false);
            if (bundle != null && bundle.containsKey("Restoring")) {
                this.e4 = true;
                if (bundle.containsKey("Find")) {
                    this.f4 = bundle.getString("Find");
                    this.o4 = bundle.getInt("FindIndex");
                }
                if (bundle.containsKey("mFinalHTML")) {
                    this.A4 = bundle.getString("mFinalHTML");
                }
                if (bundle.containsKey("mTitle")) {
                    this.F4 = bundle.getString("mTitle");
                }
                this.X4 = bundle.getParcelableArrayList("mDiagnoses");
                this.Y4 = bundle.getParcelableArrayList("mDiagnosesIn");
                this.Z4 = bundle.getParcelableArrayList("mDescriptions");
            }
            this.C4 = inflate;
            this.L4 = (Toolbar) inflate.findViewById(R.id.f1139toolbar);
            this.D4 = y().getBundle("DB");
            this.E4 = y().getString("URL");
            this.Q4 = new CompressHelper(r());
            TabHost tabHost = (TabHost) inflate.findViewById(R.id.f939findtabhost);
            this.x4 = tabHost;
            if (tabHost != null) {
                tabHost.setup();
            }
            this.a5 = (ListView) inflate.findViewById(R.id.f996list_view);
            if (y() == null) {
                return inflate;
            }
            try {
                if (this.X4 == null) {
                    CompressHelper compressHelper = this.Q4;
                    Bundle bundle2 = this.D4;
                    Bundle z = compressHelper.z(compressHelper.V(bundle2, "select * from diagnoses where id=" + this.E4));
                    CompressHelper compressHelper2 = this.Q4;
                    Bundle bundle3 = this.D4;
                    ArrayList<Bundle> V = compressHelper2.V(bundle3, "select * from ddx where id1=" + this.E4);
                    this.X4 = V;
                    if (V == null) {
                        this.X4 = new ArrayList<>();
                    }
                    CompressHelper compressHelper3 = this.Q4;
                    Bundle bundle4 = this.D4;
                    ArrayList<Bundle> V2 = compressHelper3.V(bundle4, "select * from ddx where id2=" + this.E4);
                    this.Y4 = V2;
                    if (V2 == null) {
                        this.Y4 = new ArrayList<>();
                    }
                    this.Z4 = new ArrayList<>();
                    this.F4 = z.getString("diagnosisName");
                    this.A4 = "";
                }
                AnonymousClass1 r6 = new BaseAdapter() {
                    /* JADX WARNING: Code restructure failed: missing block: B:22:0x00cf, code lost:
                        r0.putInt("TypeInteger", r11);
                     */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public android.os.Bundle a(int r11) {
                        /*
                            r10 = this;
                            android.os.Bundle r0 = new android.os.Bundle
                            r0.<init>()
                            net.imedicaldoctor.imd.Fragments.UptodateDDX.UTDDViewerActivity$UTDDViewerFragment r1 = net.imedicaldoctor.imd.Fragments.UptodateDDX.UTDDViewerActivity.UTDDViewerFragment.this
                            java.util.ArrayList r1 = r1.X4
                            int r1 = r1.size()
                            if (r1 != 0) goto L_0x0013
                            int r11 = r11 + 1
                        L_0x0013:
                            java.lang.String r1 = "Text"
                            java.lang.String r2 = "Header"
                            r3 = 0
                            java.lang.String r4 = "TypeInteger"
                            java.lang.String r5 = "Type"
                            if (r11 != 0) goto L_0x002b
                            r0.putString(r5, r2)
                            java.lang.String r11 = "DIFFERENTIAL DIAGNOSES:"
                        L_0x0023:
                            r0.putString(r1, r11)
                            r0.putInt(r4, r3)
                            goto L_0x00ef
                        L_0x002b:
                            net.imedicaldoctor.imd.Fragments.UptodateDDX.UTDDViewerActivity$UTDDViewerFragment r6 = net.imedicaldoctor.imd.Fragments.UptodateDDX.UTDDViewerActivity.UTDDViewerFragment.this
                            java.util.ArrayList r6 = r6.X4
                            int r6 = r6.size()
                            net.imedicaldoctor.imd.Fragments.UptodateDDX.UTDDViewerActivity$UTDDViewerFragment r7 = net.imedicaldoctor.imd.Fragments.UptodateDDX.UTDDViewerActivity.UTDDViewerFragment.this
                            java.util.ArrayList r7 = r7.Z4
                            int r7 = r7.size()
                            int r6 = r6 + r7
                            r7 = 1
                            int r6 = r6 + r7
                            if (r11 != r6) goto L_0x004a
                            r0.putString(r5, r2)
                            java.lang.String r11 = "IN DIFFERENTIAL DIAGNOSIS OF :"
                            goto L_0x0023
                        L_0x004a:
                            net.imedicaldoctor.imd.Fragments.UptodateDDX.UTDDViewerActivity$UTDDViewerFragment r1 = net.imedicaldoctor.imd.Fragments.UptodateDDX.UTDDViewerActivity.UTDDViewerFragment.this
                            java.util.ArrayList r1 = r1.X4
                            int r1 = r1.size()
                            net.imedicaldoctor.imd.Fragments.UptodateDDX.UTDDViewerActivity$UTDDViewerFragment r2 = net.imedicaldoctor.imd.Fragments.UptodateDDX.UTDDViewerActivity.UTDDViewerFragment.this
                            java.util.ArrayList r2 = r2.Z4
                            int r2 = r2.size()
                            int r1 = r1 + r2
                            int r1 = r1 + r7
                            r2 = 2
                            java.lang.String r6 = "Item"
                            if (r11 <= r1) goto L_0x0094
                            java.lang.String r1 = "InItem"
                            r0.putString(r5, r1)
                            net.imedicaldoctor.imd.Fragments.UptodateDDX.UTDDViewerActivity$UTDDViewerFragment r1 = net.imedicaldoctor.imd.Fragments.UptodateDDX.UTDDViewerActivity.UTDDViewerFragment.this
                            java.util.ArrayList r1 = r1.Y4
                            net.imedicaldoctor.imd.Fragments.UptodateDDX.UTDDViewerActivity$UTDDViewerFragment r3 = net.imedicaldoctor.imd.Fragments.UptodateDDX.UTDDViewerActivity.UTDDViewerFragment.this
                            java.util.ArrayList r3 = r3.X4
                            int r3 = r3.size()
                            net.imedicaldoctor.imd.Fragments.UptodateDDX.UTDDViewerActivity$UTDDViewerFragment r5 = net.imedicaldoctor.imd.Fragments.UptodateDDX.UTDDViewerActivity.UTDDViewerFragment.this
                            java.util.ArrayList r5 = r5.Z4
                            int r5 = r5.size()
                            int r3 = r3 + r5
                            int r3 = r3 + r2
                            int r11 = r11 - r3
                            java.lang.Object r11 = r1.get(r11)
                            android.os.Bundle r11 = (android.os.Bundle) r11
                            r0.putBundle(r6, r11)
                            r0.putInt(r4, r7)
                            goto L_0x00ef
                        L_0x0094:
                            net.imedicaldoctor.imd.Fragments.UptodateDDX.UTDDViewerActivity$UTDDViewerFragment r1 = net.imedicaldoctor.imd.Fragments.UptodateDDX.UTDDViewerActivity.UTDDViewerFragment.this
                            java.util.ArrayList r1 = r1.X4
                            java.util.Iterator r1 = r1.iterator()
                        L_0x009e:
                            boolean r7 = r1.hasNext()
                            if (r7 == 0) goto L_0x00ef
                            java.lang.Object r7 = r1.next()
                            android.os.Bundle r7 = (android.os.Bundle) r7
                            int r8 = r3 + 1
                            if (r11 != r8) goto L_0x00d3
                            net.imedicaldoctor.imd.Fragments.UptodateDDX.UTDDViewerActivity$UTDDViewerFragment r11 = net.imedicaldoctor.imd.Fragments.UptodateDDX.UTDDViewerActivity.UTDDViewerFragment.this
                            java.util.ArrayList r11 = r11.Z4
                            boolean r11 = r11.contains(r7)
                            if (r11 == 0) goto L_0x00c6
                            java.lang.String r11 = "DItemUp"
                            r0.putString(r5, r11)
                            r0.putBundle(r6, r7)
                            r0.putInt(r4, r2)
                            goto L_0x00ef
                        L_0x00c6:
                            java.lang.String r11 = "DItemDown"
                            r0.putString(r5, r11)
                            r0.putBundle(r6, r7)
                            r11 = 3
                        L_0x00cf:
                            r0.putInt(r4, r11)
                            goto L_0x00ef
                        L_0x00d3:
                            net.imedicaldoctor.imd.Fragments.UptodateDDX.UTDDViewerActivity$UTDDViewerFragment r9 = net.imedicaldoctor.imd.Fragments.UptodateDDX.UTDDViewerActivity.UTDDViewerFragment.this
                            java.util.ArrayList r9 = r9.Z4
                            boolean r9 = r9.contains(r7)
                            if (r9 == 0) goto L_0x00ed
                            int r3 = r3 + 2
                            if (r11 != r3) goto L_0x009e
                            java.lang.String r11 = "DItemDesc"
                            r0.putString(r5, r11)
                            r0.putBundle(r6, r7)
                            r11 = 4
                            goto L_0x00cf
                        L_0x00ed:
                            r3 = r8
                            goto L_0x009e
                        L_0x00ef:
                            return r0
                        */
                        throw new UnsupportedOperationException("Method not decompiled: net.imedicaldoctor.imd.Fragments.UptodateDDX.UTDDViewerActivity.UTDDViewerFragment.AnonymousClass1.a(int):android.os.Bundle");
                    }

                    public boolean areAllItemsEnabled() {
                        return false;
                    }

                    public int getCount() {
                        int size = (UTDDViewerFragment.this.X4.size() > 0 ? 1 : 0) + UTDDViewerFragment.this.X4.size() + UTDDViewerFragment.this.Z4.size();
                        return UTDDViewerFragment.this.Y4.size() > 0 ? size + 1 + UTDDViewerFragment.this.Y4.size() : size;
                    }

                    public Object getItem(int i2) {
                        return a(i2);
                    }

                    public long getItemId(int i2) {
                        return 0;
                    }

                    public int getItemViewType(int i2) {
                        return a(i2).getInt("TypeInteger");
                    }

                    public View getView(int i2, View view, ViewGroup viewGroup) {
                        TextView textView;
                        CharSequence fromHtml;
                        ImageView imageView;
                        View.OnClickListener r0;
                        String str;
                        Bundle bundle = (Bundle) getItem(i2);
                        String string = bundle.getString("Type");
                        if (string.equals("Header")) {
                            if (view == null) {
                                view = LayoutInflater.from(UTDDViewerFragment.this.r()).inflate(R.layout.f1310list_view_item_database_header, viewGroup, false);
                                view.setTag(view.findViewById(R.id.f957header_text));
                            }
                            textView = (TextView) view.getTag();
                            str = "Text";
                        } else if (string.equals("InItem")) {
                            if (view == null) {
                                view = LayoutInflater.from(UTDDViewerFragment.this.r()).inflate(R.layout.f1366list_view_item_simple_text_arrow, viewGroup, false);
                                view.setTag(view.findViewById(R.id.text));
                            }
                            bundle = bundle.getBundle("Item");
                            textView = (TextView) view.getTag();
                            str = "id1diagnosis";
                        } else {
                            if (string.equals("DItemUp")) {
                                if (view == null) {
                                    view = LayoutInflater.from(UTDDViewerFragment.this.r()).inflate(R.layout.f1368list_view_item_simple_text_arrow_up, viewGroup, false);
                                    TextView textView2 = (TextView) view.findViewById(R.id.text);
                                    textView2.setTextColor(-16776961);
                                    view.setTag(textView2);
                                }
                                final Bundle bundle2 = bundle.getBundle("Item");
                                ((TextView) view.getTag()).setText(bundle2.getString("id2diagnosis"));
                                imageView = (ImageView) view.findViewById(R.id.f1016next_icon);
                                r0 = new View.OnClickListener() {
                                    public void onClick(View view) {
                                        UTDDViewerFragment.this.Z4.remove(bundle2);
                                        UTDDViewerFragment.this.b5.notifyDataSetChanged();
                                    }
                                };
                            } else if (string.equals("DItemDown")) {
                                if (view == null) {
                                    view = LayoutInflater.from(UTDDViewerFragment.this.r()).inflate(R.layout.f1367list_view_item_simple_text_arrow_down, viewGroup, false);
                                    TextView textView3 = (TextView) view.findViewById(R.id.text);
                                    textView3.setTextColor(-16776961);
                                    view.setTag(textView3);
                                }
                                final Bundle bundle3 = bundle.getBundle("Item");
                                ((TextView) view.getTag()).setText(bundle3.getString("id2diagnosis"));
                                imageView = (ImageView) view.findViewById(R.id.f1016next_icon);
                                r0 = new View.OnClickListener() {
                                    public void onClick(View view) {
                                        UTDDViewerFragment.this.Z4.add(bundle3);
                                        UTDDViewerFragment.this.b5.notifyDataSetChanged();
                                    }
                                };
                            } else {
                                if (string.equals("DItemDesc")) {
                                    if (view == null) {
                                        view = LayoutInflater.from(UTDDViewerFragment.this.r()).inflate(R.layout.f1365list_view_item_simple_text, viewGroup, false);
                                        view.setTag(view.findViewById(R.id.text));
                                    }
                                    Bundle bundle4 = bundle.getBundle("Item");
                                    textView = (TextView) view.getTag();
                                    fromHtml = Html.fromHtml("<font color=\"red\"><b>Signs & Symptoms: </b></font></div>" + bundle4.getString("signs").replace("&deg;", "°") + "<font color=\"red\"><b><br/><br/>Tests: </b></div></font>" + bundle4.getString("tests").replace("&deg;", "°"));
                                    textView.setText(fromHtml);
                                }
                                return view;
                            }
                            imageView.setOnClickListener(r0);
                            return view;
                        }
                        fromHtml = bundle.getString(str);
                        textView.setText(fromHtml);
                        return view;
                    }

                    public int getViewTypeCount() {
                        return 5;
                    }

                    public boolean hasStableIds() {
                        return false;
                    }

                    public boolean isEmpty() {
                        return false;
                    }

                    public boolean isEnabled(int i2) {
                        return getItemViewType(i2) == 1;
                    }
                };
                this.b5 = r6;
                this.a5.setAdapter(r6);
                if (!this.Q4.x1()) {
                    m4(this.F4);
                }
                this.a5.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                        Bundle bundle = (Bundle) adapterView.getItemAtPosition(i2);
                        if (bundle.getString("Type").equals("InItem")) {
                            UTDDViewerFragment uTDDViewerFragment = UTDDViewerFragment.this;
                            uTDDViewerFragment.Q4.A1(uTDDViewerFragment.D4, bundle.getBundle("Item").getString("id1"), (String[]) null, (String) null);
                        }
                    }
                });
                r().setTitle(this.F4);
                o2(false);
                this.L4.setNavigationIcon((int) R.drawable.f539back_icon_small);
                this.L4.setNavigationOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        if (UTDDViewerFragment.this.y().containsKey("Dialog")) {
                            try {
                                UTDDViewerFragment.this.z().u().M(R.anim.f23to_fade_in, R.anim.f24to_fade_out).B(UTDDViewerFragment.this).r();
                            } catch (Exception e2) {
                                FirebaseCrashlytics.d().g(e2);
                                e2.printStackTrace();
                            }
                        } else {
                            UTDDViewerFragment.this.Q4.W1(false);
                        }
                    }
                });
                this.L4.setTitle((CharSequence) this.F4);
                this.L4.z(R.menu.f1483menu_utddviewer);
                q4(this.L4.getMenu());
                this.L4.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        UTDDViewerFragment.this.e1(menuItem);
                        return true;
                    }
                });
                g3();
                G3();
                return inflate;
            } catch (Exception e2) {
                FirebaseCrashlytics.d().g(e2);
                B4(e2);
                return inflate;
            }
        }

        public void l1() {
            super.l1();
            G3();
        }

        public void m1(Bundle bundle) {
            super.m1(bundle);
        }

        public void u4() {
            if (getActivity().getSharedPreferences("default_preferences", 0).getBoolean("HideStatusBar", false)) {
                float dimension = b0().getDimension(R.dimen.f522toolbar_padding);
                Toolbar toolbar = this.L4;
                if (toolbar != null) {
                    toolbar.setPadding(0, (int) dimension, 0, 0);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.f1175activity_general_viewer);
        Y0(new UTDDViewerFragment(), bundle);
    }
}
