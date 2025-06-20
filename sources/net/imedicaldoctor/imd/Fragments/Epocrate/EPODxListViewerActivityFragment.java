package net.imedicaldoctor.imd.Fragments.Epocrate;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.itextpdf.text.Annotation;
import com.itextpdf.tool.xml.html.HTML;
import java.io.File;
import java.util.ArrayList;
import net.imedicaldoctor.imd.Data.CompressHelper;
import net.imedicaldoctor.imd.Fragments.CustomItemDecoration;
import net.imedicaldoctor.imd.Fragments.ViewerHelperFragment;
import net.imedicaldoctor.imd.Gallery.GalleryActivity;
import net.imedicaldoctor.imd.R;
import net.imedicaldoctor.imd.ViewHolders.RippleTextImageArrowViewHolder;
import net.imedicaldoctor.imd.iMDLogger;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;

public class EPODxListViewerActivityFragment extends ViewerHelperFragment {
    public JSONObject X4;
    public String Y4;
    public RecyclerView Z4;
    public JSONObject a5;
    public ArrayList<Bundle> b5;
    public String c5;
    public String d5;

    public class EpocrateAdapter extends RecyclerView.Adapter {

        /* renamed from: d  reason: collision with root package name */
        public ArrayList<Bundle> f29732d;

        /* renamed from: e  reason: collision with root package name */
        public String f29733e;

        /* renamed from: f  reason: collision with root package name */
        public int f29734f;

        public EpocrateAdapter() {
        }

        public int C(int i2) {
            return EPODxListViewerActivityFragment.this.I4(i2).containsKey("Title") ? 1 : 0;
        }

        public void R(RecyclerView.ViewHolder viewHolder, int i2) {
            if (viewHolder.F() == 0) {
                RippleTextImageArrowViewHolder rippleTextImageArrowViewHolder = (RippleTextImageArrowViewHolder) viewHolder;
                final Bundle bundle = EPODxListViewerActivityFragment.this.I4(i2).getBundle("Item");
                if (bundle.containsKey(TypedValues.AttributesType.M)) {
                    rippleTextImageArrowViewHolder.I.setText(bundle.getString("title"));
                    rippleTextImageArrowViewHolder.J.setVisibility(8);
                    rippleTextImageArrowViewHolder.K.setVisibility(0);
                    rippleTextImageArrowViewHolder.L.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            try {
                                EPODxListViewerActivityFragment ePODxListViewerActivityFragment = EPODxListViewerActivityFragment.this;
                                JSONObject r1 = ePODxListViewerActivityFragment.Q4.r1(ePODxListViewerActivityFragment.X4.getJSONArray("views"), "id", bundle.getString(TypedValues.AttributesType.M));
                                if (r1.getString("type").equals("web")) {
                                    String string = r1.getString(HTML.Tag.y);
                                    Bundle bundle = new Bundle();
                                    bundle.putString("Title", r1.getString("title"));
                                    bundle.putString("Html", string);
                                    bundle.putString("DocAddress", EPODxListViewerActivityFragment.this.E4);
                                    bundle.putString("mDB", EPODxListViewerActivityFragment.this.c5);
                                    bundle.putParcelableArrayList("Images", EPODxListViewerActivityFragment.this.b5);
                                    EPODxListViewerActivityFragment ePODxListViewerActivityFragment2 = EPODxListViewerActivityFragment.this;
                                    CompressHelper compressHelper = ePODxListViewerActivityFragment2.Q4;
                                    Bundle bundle2 = ePODxListViewerActivityFragment2.D4;
                                    compressHelper.B1(bundle2, "web-" + EPODxListViewerActivityFragment.this.E4, (String[]) null, (String) null, bundle);
                                    return;
                                }
                                Bundle bundle3 = new Bundle();
                                bundle3.putBundle("DB", EPODxListViewerActivityFragment.this.D4);
                                bundle3.putString("ViewId", bundle.getString(TypedValues.AttributesType.M));
                                bundle3.putString("mDB", EPODxListViewerActivityFragment.this.c5);
                                bundle3.putString("URL", EPODxListViewerActivityFragment.this.E4);
                                EPODxListViewerActivityFragment.this.Q4.N(EPODxListViewerActivity.class, EPODxListViewerActivityFragment.class, bundle3);
                            } catch (Exception e2) {
                                FirebaseCrashlytics.d().g(e2);
                                e2.printStackTrace();
                            }
                        }
                    });
                } else if (bundle.containsKey("targetHTML")) {
                    rippleTextImageArrowViewHolder.I.setText(bundle.getString("title"));
                    rippleTextImageArrowViewHolder.J.setVisibility(8);
                    rippleTextImageArrowViewHolder.K.setVisibility(0);
                    rippleTextImageArrowViewHolder.L.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            String string = bundle.getString("targetHTML");
                            Bundle bundle = new Bundle();
                            bundle.putString("Title", bundle.getString("title"));
                            bundle.putString("Html", string);
                            bundle.putString("DocAddress", EPODxListViewerActivityFragment.this.E4);
                            bundle.putParcelableArrayList("Images", EPODxListViewerActivityFragment.this.b5);
                            EPODxListViewerActivityFragment ePODxListViewerActivityFragment = EPODxListViewerActivityFragment.this;
                            CompressHelper compressHelper = ePODxListViewerActivityFragment.Q4;
                            Bundle bundle2 = ePODxListViewerActivityFragment.D4;
                            compressHelper.B1(bundle2, "web-" + EPODxListViewerActivityFragment.this.E4, (String[]) null, (String) null, bundle);
                        }
                    });
                } else if (bundle.containsKey("targetURL")) {
                    rippleTextImageArrowViewHolder.I.setText(bundle.getString("title"));
                    String string = bundle.getString("targetURL");
                    String str = string.contains("rx/monograph/") ? "plus_rx.png" : string.contains("dx/monograph/") ? "plus_dx.png" : string.contains("lab/monograph/") ? "plus_lab.png" : string.contains("lab/list/panel/") ? "plus_panel.png" : "";
                    rippleTextImageArrowViewHolder.J.setVisibility(0);
                    ImageView imageView = rippleTextImageArrowViewHolder.J;
                    EPODxListViewerActivityFragment ePODxListViewerActivityFragment = EPODxListViewerActivityFragment.this;
                    imageView.setImageBitmap(ePODxListViewerActivityFragment.L4(ePODxListViewerActivityFragment.r(), str));
                    rippleTextImageArrowViewHolder.K.setVisibility(0);
                    rippleTextImageArrowViewHolder.L.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            String string = bundle.getString("targetURL");
                            EPODxListViewerActivityFragment ePODxListViewerActivityFragment = EPODxListViewerActivityFragment.this;
                            ePODxListViewerActivityFragment.Q4.N1(ePODxListViewerActivityFragment.D4, string);
                        }
                    });
                } else if (bundle.containsKey("flag")) {
                    rippleTextImageArrowViewHolder.I.setText(bundle.getString("title"));
                    rippleTextImageArrowViewHolder.J.setVisibility(0);
                    ImageView imageView2 = rippleTextImageArrowViewHolder.J;
                    EPODxListViewerActivityFragment ePODxListViewerActivityFragment2 = EPODxListViewerActivityFragment.this;
                    FragmentActivity r = ePODxListViewerActivityFragment2.r();
                    imageView2.setImageBitmap(ePODxListViewerActivityFragment2.L4(r, "orb" + bundle.getString("flag") + ".png"));
                    rippleTextImageArrowViewHolder.K.setVisibility(0);
                } else {
                    rippleTextImageArrowViewHolder.I.setText("title");
                    rippleTextImageArrowViewHolder.J.setVisibility(8);
                    rippleTextImageArrowViewHolder.K.setVisibility(8);
                }
            } else if (viewHolder.F() == 1) {
                ((HeaderCellViewHolder) viewHolder).I.setText(EPODxListViewerActivityFragment.this.I4(i2).getString("Title"));
            }
        }

        public RecyclerView.ViewHolder T(ViewGroup viewGroup, int i2) {
            if (i2 == 0) {
                return new RippleTextImageArrowViewHolder(LayoutInflater.from(EPODxListViewerActivityFragment.this.r()).inflate(R.layout.f1350list_view_item_ripple_text_image_arrow, viewGroup, false));
            }
            if (i2 == 1) {
                return new HeaderCellViewHolder(LayoutInflater.from(EPODxListViewerActivityFragment.this.r()).inflate(R.layout.f1318list_view_item_dx_list_header, viewGroup, false));
            }
            return null;
        }

        public int b() {
            return EPODxListViewerActivityFragment.this.O4();
        }

        public String d0(String str) {
            return str;
        }

        public void e0(Bundle bundle, int i2) {
        }
    }

    public static class HeaderCellViewHolder extends RecyclerView.ViewHolder {
        public TextView I;

        public HeaderCellViewHolder(View view) {
            super(view);
            this.I = (TextView) view.findViewById(R.id.f957header_text);
        }
    }

    private void N4(String str) {
        ArrayList<Bundle> arrayList = this.b5;
        if (arrayList == null || arrayList.size() == 0) {
            CompressHelper.x2(r(), "There is no media in this document", 1);
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        arrayList2.addAll(this.b5);
        int i2 = 0;
        for (int i3 = 0; i3 < arrayList2.size(); i3++) {
            if (((Bundle) arrayList2.get(i3)).getString("id").startsWith(str)) {
                i2 = i3;
            }
        }
        Intent intent = new Intent(r(), GalleryActivity.class);
        intent.putExtra("Images", arrayList2);
        intent.putExtra("Start", i2);
        D2(intent);
    }

    public Bundle I4(int i2) {
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i3 < this.a5.getJSONArray("sections").length()) {
            try {
                JSONObject jSONObject = this.a5.getJSONArray("sections").getJSONObject(i3);
                if (i2 == i4) {
                    Bundle bundle = new Bundle();
                    String str = "";
                    if (jSONObject.has("headerText")) {
                        str = jSONObject.getString("headerText");
                    }
                    if (jSONObject.has("headers")) {
                        str = jSONObject.getJSONArray("headers").getJSONObject(0).getString("title");
                    }
                    bundle.putString("Title", str);
                    bundle.putInt("Row", 0);
                    bundle.putInt("Section", i5);
                    bundle.putInt("Row2", 1);
                    bundle.putInt("Section2", i5 - 1);
                    return bundle;
                }
                int length = i4 + jSONObject.getJSONArray("cells").length();
                if (i2 <= length) {
                    int length2 = (i2 - (length - jSONObject.getJSONArray("cells").length())) - 1;
                    Bundle bundle2 = new Bundle();
                    bundle2.putBundle("Item", this.Q4.G(jSONObject.getJSONArray("cells").getJSONObject(length2)));
                    bundle2.putInt("Row", length2);
                    bundle2.putInt("Section", i5);
                    return bundle2;
                }
                i4 = length + 1;
                i5++;
                i3++;
            } catch (Exception e2) {
                FirebaseCrashlytics.d().g(e2);
                e2.printStackTrace();
                return null;
            }
        }
        return null;
    }

    public void J4() {
        this.Z4.setItemAnimator(new DefaultItemAnimator());
        this.Z4.setItemDecoration(new CustomItemDecoration(r()));
        this.Z4.setLayoutManager(new LinearLayoutManager(r(), 1, false));
    }

    public String K4(JSONObject jSONObject) {
        try {
            return jSONObject.has(TypedValues.AttributesType.M) ? jSONObject.getString(TypedValues.AttributesType.M) : jSONObject.getString("targetHTML");
        } catch (Exception e2) {
            FirebaseCrashlytics.d().g(e2);
            e2.printStackTrace();
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x001f A[SYNTHETIC, Splitter:B:17:0x001f] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0025 A[SYNTHETIC, Splitter:B:22:0x0025] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.graphics.Bitmap L4(android.content.Context r2, java.lang.String r3) {
        /*
            r1 = this;
            r0 = 0
            android.content.res.AssetManager r2 = r2.getAssets()     // Catch:{ Exception -> 0x001a, all -> 0x0018 }
            java.io.InputStream r2 = r2.open(r3)     // Catch:{ Exception -> 0x001a, all -> 0x0018 }
            android.graphics.Bitmap r3 = android.graphics.BitmapFactory.decodeStream(r2)     // Catch:{ Exception -> 0x0016, all -> 0x0013 }
            if (r2 == 0) goto L_0x0012
            r2.close()     // Catch:{ Exception -> 0x0012 }
        L_0x0012:
            return r3
        L_0x0013:
            r3 = move-exception
            r0 = r2
            goto L_0x001d
        L_0x0016:
            goto L_0x0023
        L_0x0018:
            r3 = move-exception
            goto L_0x001d
        L_0x001a:
            r2 = r0
            goto L_0x0023
        L_0x001d:
            if (r0 == 0) goto L_0x0022
            r0.close()     // Catch:{ Exception -> 0x0022 }
        L_0x0022:
            throw r3
        L_0x0023:
            if (r2 == 0) goto L_0x0028
            r2.close()     // Catch:{ Exception -> 0x0028 }
        L_0x0028:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.imedicaldoctor.imd.Fragments.Epocrate.EPODxListViewerActivityFragment.L4(android.content.Context, java.lang.String):android.graphics.Bitmap");
    }

    public void M4() {
        try {
            JSONObject r1 = this.Q4.r1(this.X4.getJSONArray("views"), "id", this.Y4);
            if (r1.getString("id").equals("root") && this.d5.length() > 0) {
                r1.getJSONArray("sections").put(new JSONObject("{\"cells\":[{\"type\":\"flex0\",\"title\":\"Citations\", \"targetHTML\":\"" + this.d5.replace("\"", "\\\"") + "\"}]}"));
            }
            this.a5 = r1;
        } catch (Exception e2) {
            FirebaseCrashlytics.d().g(e2);
            e2.printStackTrace();
        }
    }

    public int O4() {
        if (this.a5 == null) {
            return 0;
        }
        int i2 = 0;
        int i3 = 0;
        while (i2 < this.a5.getJSONArray("sections").length()) {
            try {
                i3 = i3 + this.a5.getJSONArray("sections").getJSONObject(i2).getJSONArray("cells").length() + 1;
                i2++;
            } catch (Exception e2) {
                FirebaseCrashlytics.d().g(e2);
                e2.printStackTrace();
                return 0;
            }
        }
        return i3;
    }

    public String R2() {
        ArrayList<Bundle> arrayList;
        Bundle v3;
        if (this.b5.size() <= 0 || (arrayList = this.b5) == null || arrayList.size() <= 0 || (v3 = v3(this.b5)) == null) {
            return null;
        }
        return v3.getString("ImagePath");
    }

    public View onFragmentBind(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str = "";
        View view = this.C4;
        if (view != null) {
            return view;
        }
        View inflate = layoutInflater.inflate(R.layout.f1248fragment_new_list_viewer, viewGroup, false);
        this.C4 = inflate;
        r4(inflate, bundle);
        this.Z4 = (RecyclerView) this.C4.findViewById(R.id.f1054recycler_view);
        if (y() == null) {
            return this.C4;
        }
        try {
            String str2 = this.A4;
            if (str2 != null) {
                if (str2.length() == 0) {
                }
                this.Z4.setAdapter(new EpocrateAdapter());
                J4();
                f3(R.menu.f1413epolistmenu);
                o2(false);
                G3();
                return this.C4;
            }
            if (y().containsKey("ViewId")) {
                this.Y4 = y().getString("ViewId");
            }
            if (y().containsKey("mDB")) {
                this.c5 = y().getString("mDB");
            }
            if (this.c5 == null) {
                this.c5 = "Dx";
            }
            iMDLogger.f("Loading Document", this.E4);
            String str3 = this.E4.split("-")[1];
            ArrayList<Bundle> V = this.Q4.V(this.D4, "Select * from " + this.c5 + "_monographs where id=" + str3);
            if (V != null) {
                if (V.size() != 0) {
                    JSONObject jSONObject = new JSONObject(this.Q4.B(V.get(0).getString("monograph"), str3, "127"));
                    this.F4 = jSONObject.getString("title");
                    this.X4 = jSONObject;
                    if (this.Y4 == null) {
                        this.Y4 = "root";
                    }
                    this.d5 = str;
                    if (jSONObject.has("citations")) {
                        if (this.X4.getJSONObject("citations").has("articles")) {
                            for (int i2 = 0; i2 < this.X4.getJSONObject("citations").getJSONArray("articles").length(); i2++) {
                                JSONObject jSONObject2 = this.X4.getJSONObject("citations").getJSONArray("articles").getJSONObject(i2);
                                str = str + "<div id=\"articleCitation" + jSONObject2.getString("id") + "\" style=\"margin:10px\"><b>" + jSONObject2.getString("id") + ": </b>" + jSONObject2.getString(HTML.Tag.y) + "</div>";
                            }
                            this.d5 = str;
                        }
                    }
                    M4();
                    ArrayList<Bundle> arrayList = new ArrayList<>();
                    if (this.X4.has("media")) {
                        for (int i3 = 0; i3 < this.X4.getJSONArray("media").length(); i3++) {
                            JSONObject jSONObject3 = this.X4.getJSONArray("media").getJSONObject(i3);
                            String string = jSONObject3.getString(Annotation.k3);
                            String h1 = CompressHelper.h1(this.D4, string, "pictures");
                            if (new File(h1).exists()) {
                                Bundle bundle2 = new Bundle();
                                bundle2.putString("ImagePath", h1);
                                bundle2.putString("id", string);
                                bundle2.putString("Description", jSONObject3.getString(HTML.Tag.f27619g) + StringUtils.LF + jSONObject3.getString("source"));
                                arrayList.add(bundle2);
                            }
                        }
                    }
                    this.b5 = arrayList;
                    this.Z4.setAdapter(new EpocrateAdapter());
                    J4();
                    f3(R.menu.f1413epolistmenu);
                    o2(false);
                    G3();
                    return this.C4;
                }
            }
            CompressHelper.x2(r(), "Document doesn't exist", 1);
            return this.C4;
        } catch (Exception e2) {
            B4(e2);
        }
    }

    public boolean e1(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.f799action_gallery) {
            N4("soheilvb");
        }
        return super.e1(menuItem);
    }
}
