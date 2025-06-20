package net.imedicaldoctor.imd.Fragments.VisualDXLookup;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import java.util.ArrayList;
import java.util.Iterator;
import net.imedicaldoctor.imd.Data.CompressHelper;
import net.imedicaldoctor.imd.R;

public class VDDxKeyQuestionsDialog extends DialogFragment {
    private Bundle F4;
    /* access modifiers changed from: private */
    public ArrayList<String> G4;
    /* access modifiers changed from: private */
    public ArrayList<Bundle> H4;
    /* access modifiers changed from: private */
    public Bundle I4;
    public ArrayList<String> J4;

    public Dialog U2(Bundle bundle) {
        AlertDialog.Builder builder = new AlertDialog.Builder(r());
        View inflate = r().getLayoutInflater().inflate(R.layout.f1233fragment_general_section_viewer, (ViewGroup) null);
        final ListView listView = (ListView) inflate.findViewById(R.id.f996list_view);
        this.F4 = y().getBundle("db");
        this.I4 = y().getBundle("allFindings");
        this.G4 = y().getStringArrayList("selectedKeyQuestions");
        this.H4 = y().getParcelableArrayList("allKeyQuestions");
        this.J4 = new ArrayList<>();
        Iterator<Bundle> it2 = this.H4.iterator();
        while (it2.hasNext()) {
            this.J4.add(it2.next().getString("title"));
        }
        new CompressHelper(r());
        AnonymousClass1 r2 = new BaseAdapter() {
            public boolean areAllItemsEnabled() {
                return false;
            }

            public int getCount() {
                VDDxKeyQuestionsDialog vDDxKeyQuestionsDialog = VDDxKeyQuestionsDialog.this;
                return vDDxKeyQuestionsDialog.l3(vDDxKeyQuestionsDialog.J4);
            }

            public Object getItem(int i2) {
                VDDxKeyQuestionsDialog vDDxKeyQuestionsDialog = VDDxKeyQuestionsDialog.this;
                return vDDxKeyQuestionsDialog.g3(i2, vDDxKeyQuestionsDialog.J4);
            }

            public long getItemId(int i2) {
                return 0;
            }

            public int getItemViewType(int i2) {
                return ((Bundle) getItem(i2)).getString("Type").equals("Header") ? 0 : 1;
            }

            public View getView(int i2, View view, ViewGroup viewGroup) {
                Bundle bundle = (Bundle) getItem(i2);
                if (bundle.getString("Type").equals("Header")) {
                    if (view == null) {
                        view = LayoutInflater.from(VDDxKeyQuestionsDialog.this.r()).inflate(R.layout.f1310list_view_item_database_header, viewGroup, false);
                        view.setTag(view.findViewById(R.id.f957header_text));
                    }
                    ((TextView) view.findViewById(R.id.f957header_text)).setText(bundle.getString("Text"));
                    return view;
                }
                if (view == null) {
                    view = LayoutInflater.from(VDDxKeyQuestionsDialog.this.r()).inflate(R.layout.f1369list_view_item_simple_text_check, viewGroup, false);
                }
                ImageView imageView = (ImageView) view.findViewById(R.id.f872check_icon);
                String string = bundle.getString("Section");
                String string2 = ((Bundle) ((Bundle) VDDxKeyQuestionsDialog.this.H4.get(VDDxKeyQuestionsDialog.this.J4.indexOf(string))).getParcelableArrayList("findings").get(bundle.getInt("Index"))).getString("findingId");
                ((TextView) view.findViewById(R.id.text)).setText(VDDxKeyQuestionsDialog.this.I4.getString(string2));
                if (VDDxKeyQuestionsDialog.this.G4.contains(string2)) {
                    imageView.setVisibility(0);
                } else {
                    imageView.setVisibility(4);
                }
                return view;
            }

            public int getViewTypeCount() {
                return 2;
            }

            public boolean hasStableIds() {
                return false;
            }

            public boolean isEmpty() {
                return false;
            }

            public boolean isEnabled(int i2) {
                return ((Bundle) getItem(i2)).getString("Type").equals("Item");
            }
        };
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* JADX WARNING: type inference failed for: r2v0, types: [android.widget.AdapterView<?>, android.widget.AdapterView] */
            /* JADX WARNING: Unknown variable types count: 1 */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void onItemClick(android.widget.AdapterView<?> r2, android.view.View r3, int r4, long r5) {
                /*
                    r1 = this;
                    android.widget.Adapter r2 = r2.getAdapter()
                    java.lang.Object r2 = r2.getItem(r4)
                    android.os.Bundle r2 = (android.os.Bundle) r2
                    java.lang.String r3 = "Type"
                    java.lang.String r3 = r2.getString(r3)
                    java.lang.String r4 = "Header"
                    boolean r3 = r3.equals(r4)
                    if (r3 == 0) goto L_0x0019
                    return
                L_0x0019:
                    java.lang.String r3 = "Index"
                    int r3 = r2.getInt(r3)
                    java.lang.String r4 = "Section"
                    java.lang.String r2 = r2.getString(r4)
                    net.imedicaldoctor.imd.Fragments.VisualDXLookup.VDDxKeyQuestionsDialog r4 = net.imedicaldoctor.imd.Fragments.VisualDXLookup.VDDxKeyQuestionsDialog.this
                    java.util.ArrayList<java.lang.String> r4 = r4.J4
                    int r2 = r4.indexOf(r2)
                    net.imedicaldoctor.imd.Fragments.VisualDXLookup.VDDxKeyQuestionsDialog r4 = net.imedicaldoctor.imd.Fragments.VisualDXLookup.VDDxKeyQuestionsDialog.this
                    java.util.ArrayList r4 = r4.H4
                    java.lang.Object r2 = r4.get(r2)
                    android.os.Bundle r2 = (android.os.Bundle) r2
                    java.lang.String r4 = "findings"
                    java.util.ArrayList r5 = r2.getParcelableArrayList(r4)
                    java.lang.Object r3 = r5.get(r3)
                    android.os.Bundle r3 = (android.os.Bundle) r3
                    java.lang.String r5 = "findingId"
                    java.lang.String r3 = r3.getString(r5)
                    net.imedicaldoctor.imd.Fragments.VisualDXLookup.VDDxKeyQuestionsDialog r6 = net.imedicaldoctor.imd.Fragments.VisualDXLookup.VDDxKeyQuestionsDialog.this
                    java.util.ArrayList r6 = r6.G4
                    boolean r6 = r6.contains(r3)
                    if (r6 == 0) goto L_0x0061
                    net.imedicaldoctor.imd.Fragments.VisualDXLookup.VDDxKeyQuestionsDialog r2 = net.imedicaldoctor.imd.Fragments.VisualDXLookup.VDDxKeyQuestionsDialog.this
                    java.util.ArrayList r2 = r2.G4
                    r2.remove(r3)
                    goto L_0x009a
                L_0x0061:
                    java.lang.String r6 = "type"
                    java.lang.String r6 = r2.getString(r6)
                    java.lang.String r0 = "radiogroup"
                    boolean r6 = r6.equals(r0)
                    if (r6 == 0) goto L_0x0091
                    java.util.ArrayList r2 = r2.getParcelableArrayList(r4)
                    java.util.Iterator r2 = r2.iterator()
                L_0x0077:
                    boolean r4 = r2.hasNext()
                    if (r4 == 0) goto L_0x0091
                    java.lang.Object r4 = r2.next()
                    android.os.Bundle r4 = (android.os.Bundle) r4
                    java.lang.String r4 = r4.getString(r5)
                    net.imedicaldoctor.imd.Fragments.VisualDXLookup.VDDxKeyQuestionsDialog r6 = net.imedicaldoctor.imd.Fragments.VisualDXLookup.VDDxKeyQuestionsDialog.this
                    java.util.ArrayList r6 = r6.G4
                    r6.remove(r4)
                    goto L_0x0077
                L_0x0091:
                    net.imedicaldoctor.imd.Fragments.VisualDXLookup.VDDxKeyQuestionsDialog r2 = net.imedicaldoctor.imd.Fragments.VisualDXLookup.VDDxKeyQuestionsDialog.this
                    java.util.ArrayList r2 = r2.G4
                    r2.add(r3)
                L_0x009a:
                    net.imedicaldoctor.imd.Fragments.VisualDXLookup.VDDxKeyQuestionsDialog r2 = net.imedicaldoctor.imd.Fragments.VisualDXLookup.VDDxKeyQuestionsDialog.this
                    androidx.fragment.app.Fragment r2 = r2.l0()
                    net.imedicaldoctor.imd.Fragments.VisualDDX.VDDxBuilderActivity$VDDXBuilderFragment r2 = (net.imedicaldoctor.imd.Fragments.VisualDDX.VDDxBuilderActivity.VDDXBuilderFragment) r2
                    r2.J4()
                    android.widget.ListView r2 = r1
                    android.widget.ListAdapter r2 = r2.getAdapter()
                    android.widget.BaseAdapter r2 = (android.widget.BaseAdapter) r2
                    r2.notifyDataSetChanged()
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: net.imedicaldoctor.imd.Fragments.VisualDXLookup.VDDxKeyQuestionsDialog.AnonymousClass2.onItemClick(android.widget.AdapterView, android.view.View, int, long):void");
            }
        });
        listView.setAdapter(r2);
        builder.setView(inflate);
        return builder.create();
    }

    public Bundle g3(int i2, ArrayList<String> arrayList) {
        Iterator<String> it2 = arrayList.iterator();
        int i3 = 0;
        while (it2.hasNext()) {
            String next = it2.next();
            if (i2 == i3) {
                Bundle bundle = new Bundle();
                bundle.putString("Text", next);
                bundle.putString("Type", "Header");
                return bundle;
            }
            int k3 = i3 + k3(next);
            if (i2 <= k3) {
                Bundle bundle2 = new Bundle();
                bundle2.putString("Section", next);
                bundle2.putInt("Index", (i2 - (k3 - k3(next))) - 1);
                bundle2.putString("Type", "Item");
                return bundle2;
            }
            i3 = k3 + 1;
        }
        return null;
    }

    public int k3(String str) {
        return this.H4.get(this.J4.indexOf(str)).getStringArrayList("findings").size();
    }

    public int l3(ArrayList<String> arrayList) {
        int i2 = 0;
        if (arrayList == null) {
            return 0;
        }
        Iterator<String> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            i2 = i2 + k3(it2.next()) + 1;
        }
        return i2;
    }
}
