package net.imedicaldoctor.imd.Fragments.VisualDXLookup;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.extractor.metadata.icy.IcyHeaders;
import androidx.palette.graphics.Palette;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.itextpdf.tool.xml.pipeline.end.PdfWriterPipeline;
import java.io.File;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import net.imedicaldoctor.imd.Data.CompressHelper;
import net.imedicaldoctor.imd.Fragments.CustomItemDecoration;
import net.imedicaldoctor.imd.Fragments.ViewerHelperActivity;
import net.imedicaldoctor.imd.Fragments.ViewerHelperFragment;
import net.imedicaldoctor.imd.Gallery.GalleryActivity;
import net.imedicaldoctor.imd.R;
import net.imedicaldoctor.imd.ViewHolders.ChaptersAdapter;
import net.imedicaldoctor.imd.ViewHolders.GridAutoFitLayoutManager;
import net.imedicaldoctor.imd.ViewHolders.ImageViewHolder;
import net.imedicaldoctor.imd.ViewHolders.RippleTextViewHolder;
import net.imedicaldoctor.imd.iMDLogger;

public class VDDiagnosisActivity extends ViewerHelperActivity {

    public static class VDDiagnosisFragment extends ViewerHelperFragment implements VDDialogListInterface {
        /* access modifiers changed from: private */
        public Bundle X4;
        /* access modifiers changed from: private */
        public ArrayList<Bundle> Y4;
        /* access modifiers changed from: private */
        public ArrayList<Bundle> Z4;
        /* access modifiers changed from: private */
        public ArrayList<Bundle> a5;
        /* access modifiers changed from: private */
        public int b5;
        /* access modifiers changed from: private */
        public Bundle c5;
        public RecyclerView d5;

        public class DatabaseHeaderViewHolder {

            /* renamed from: a  reason: collision with root package name */
            public final TextView f30044a;

            public DatabaseHeaderViewHolder(View view) {
                this.f30044a = (TextView) view.findViewById(R.id.f957header_text);
            }
        }

        public static class EmergencyTextViewHolder extends RecyclerView.ViewHolder {
            public TextView I;
            public TextView J;

            public EmergencyTextViewHolder(View view) {
                super(view);
                this.I = (TextView) view.findViewById(R.id.text);
                this.J = (TextView) view.findViewById(R.id.f926emergency_text);
            }
        }

        public static class GridViewHolder extends RecyclerView.ViewHolder {
            public GridView I;

            public GridViewHolder(View view) {
                super(view);
                this.I = (GridView) view.findViewById(R.id.f952grid_view);
            }
        }

        public static class HeaderCellViewHolder extends RecyclerView.ViewHolder {
            public TextView I;

            public HeaderCellViewHolder(View view) {
                super(view);
                this.I = (TextView) view.findViewById(R.id.f957header_text);
            }
        }

        public static class RecyclerViewViewHolder extends RecyclerView.ViewHolder {
            public RecyclerView I;

            public RecyclerViewViewHolder(View view) {
                super(view);
                this.I = (RecyclerView) view.findViewById(R.id.f1054recycler_view);
            }
        }

        public static class TextViewHolder extends RecyclerView.ViewHolder {
            public TextView I;

            public TextViewHolder(View view) {
                super(view);
                this.I = (TextView) view.findViewById(R.id.text);
            }
        }

        public class VDDiagnosisAdapter extends RecyclerView.Adapter {

            /* renamed from: d  reason: collision with root package name */
            public Context f30046d;

            public VDDiagnosisAdapter(Context context) {
                this.f30046d = context;
            }

            public int C(int i2) {
                String string = d0(i2).getString("Type");
                if (string.equals("Header")) {
                    return 0;
                }
                if (string.equals("SimpleTextEmergency")) {
                    return 1;
                }
                if (string.equals("TextList")) {
                    return 2;
                }
                if (string.equals("GridView")) {
                    return 3;
                }
                return string.equals("Item") ? 4 : -1;
            }

            public void R(RecyclerView.ViewHolder viewHolder, final int i2) {
                Bundle d0 = d0(i2);
                int F = viewHolder.F();
                if (F == 0) {
                    ((HeaderCellViewHolder) viewHolder).I.setText(d0.getString("Text"));
                } else if (F == 1) {
                    EmergencyTextViewHolder emergencyTextViewHolder = (EmergencyTextViewHolder) viewHolder;
                    emergencyTextViewHolder.I.setText(d0.getString("Text"));
                    emergencyTextViewHolder.J.setVisibility(d0.getInt("Emergency") == 0 ? 8 : 0);
                } else if (F == 2) {
                    TextViewHolder textViewHolder = (TextViewHolder) viewHolder;
                    textViewHolder.I.setText(d0.getString("Text"));
                    textViewHolder.f15587a.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            VDDialogList vDDialogList = new VDDialogList();
                            Bundle bundle = new Bundle();
                            bundle.putBundle("db", VDDiagnosisFragment.this.D4);
                            bundle.putParcelableArrayList("items", VDDiagnosisFragment.this.Y4);
                            bundle.putString("titleProperty", "longName");
                            bundle.putString("type", "Module");
                            vDDialogList.i2(bundle);
                            vDDialogList.Z2(true);
                            vDDialogList.A2(VDDiagnosisFragment.this, 0);
                            vDDialogList.e3(VDDiagnosisFragment.this.M(), "VDDialogFragment");
                        }
                    });
                } else if (F == 3) {
                    RecyclerViewViewHolder recyclerViewViewHolder = (RecyclerViewViewHolder) viewHolder;
                    final AnonymousClass2 r0 = new ChaptersAdapter(VDDiagnosisFragment.this.r(), VDDiagnosisFragment.this.a5, "title", R.layout.f1326list_view_item_image) {
                        public void e0(RecyclerView.ViewHolder viewHolder, final Bundle bundle, int i2) {
                            final ImageViewHolder imageViewHolder = (ImageViewHolder) viewHolder;
                            Bundle bundle2 = VDDiagnosisFragment.this.D4;
                            final String h1 = CompressHelper.h1(bundle2, bundle.getString("imageId") + ".jpg", "Medium");
                            Glide.G(VDDiagnosisFragment.this.r()).i(new File(h1)).B2(imageViewHolder.I);
                            if (VDDiagnosisFragment.this.c5.containsKey(h1)) {
                                imageViewHolder.J.setRippleColor(VDDiagnosisFragment.this.c5.getInt(h1));
                            } else {
                                VDDiagnosisFragment.this.q3(new Runnable() {
                                    public void run() {
                                        Palette.Swatch C = Palette.b(BitmapFactory.decodeFile(h1)).g().C();
                                        if (C != null) {
                                            int e2 = C.e();
                                            if (!VDDiagnosisFragment.this.c5.containsKey(h1)) {
                                                VDDiagnosisFragment.this.c5.putInt(h1, e2);
                                            }
                                        }
                                    }
                                }, new Runnable() {
                                    public void run() {
                                        imageViewHolder.J.setRippleColor(VDDiagnosisFragment.this.c5.getInt(h1));
                                    }
                                });
                            }
                            imageViewHolder.f15587a.setOnClickListener(new View.OnClickListener() {
                                public void onClick(View view) {
                                    VDDiagnosisFragment.this.U4(bundle.getString("imageId"));
                                }
                            });
                        }

                        public RecyclerView.ViewHolder h0(View view) {
                            return new ImageViewHolder(view);
                        }
                    };
                    recyclerViewViewHolder.I.setAdapter(r0);
                    final GridAutoFitLayoutManager gridAutoFitLayoutManager = new GridAutoFitLayoutManager(VDDiagnosisFragment.this.r(), (int) (VDDiagnosisFragment.this.b0().getDisplayMetrics().density * 100.0f));
                    gridAutoFitLayoutManager.R3(new GridLayoutManager.SpanSizeLookup() {
                        public int f(int i2) {
                            if (r0.C(i2) == 1) {
                                return gridAutoFitLayoutManager.b0;
                            }
                            return 1;
                        }
                    });
                    recyclerViewViewHolder.I.setLayoutManager(gridAutoFitLayoutManager);
                } else if (F == 4) {
                    RippleTextViewHolder rippleTextViewHolder = (RippleTextViewHolder) viewHolder;
                    rippleTextViewHolder.I.setText(d0.getBundle("Item").getString("fieldName"));
                    rippleTextViewHolder.J.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            Bundle bundle = VDDiagnosisAdapter.this.d0(i2).getBundle("Item");
                            VDDiagnosisFragment vDDiagnosisFragment = VDDiagnosisFragment.this;
                            vDDiagnosisFragment.Q4.A1(vDDiagnosisFragment.D4, "Doc-" + ((Bundle) VDDiagnosisFragment.this.Y4.get(VDDiagnosisFragment.this.b5)).getString("id"), (String[]) null, "field" + bundle.getString("fieldId"));
                        }
                    });
                }
            }

            public RecyclerView.ViewHolder T(ViewGroup viewGroup, int i2) {
                if (i2 == 0) {
                    return new HeaderCellViewHolder(LayoutInflater.from(VDDiagnosisFragment.this.r()).inflate(R.layout.f1310list_view_item_database_header, viewGroup, false));
                }
                if (i2 == 1) {
                    return new EmergencyTextViewHolder(LayoutInflater.from(VDDiagnosisFragment.this.r()).inflate(R.layout.f1370list_view_item_simple_text_emergency, viewGroup, false));
                }
                if (i2 == 2) {
                    return new TextViewHolder(LayoutInflater.from(VDDiagnosisFragment.this.r()).inflate(R.layout.f1372list_view_item_simple_text_list_icon, viewGroup, false));
                }
                if (i2 == 3) {
                    return new RecyclerViewViewHolder(LayoutInflater.from(VDDiagnosisFragment.this.r()).inflate(R.layout.f1334list_view_item_recyclerview, viewGroup, false));
                }
                if (i2 == 4) {
                    return new RippleTextViewHolder(LayoutInflater.from(VDDiagnosisFragment.this.r()).inflate(R.layout.f1343list_view_item_ripple_text_arrow, viewGroup, false));
                }
                return null;
            }

            public int b() {
                return VDDiagnosisFragment.this.Z4.size() + 6;
            }

            public Bundle d0(int i2) {
                String str;
                String str2;
                Bundle bundle = new Bundle();
                String str3 = "TypeInteger";
                if (i2 == 0) {
                    bundle.putString("Type", "SimpleTextEmergency");
                    VDDiagnosisFragment vDDiagnosisFragment = VDDiagnosisFragment.this;
                    bundle.putString("Text", vDDiagnosisFragment.T4(Integer.valueOf(vDDiagnosisFragment.X4.getString("sortPriority")).intValue()));
                    bundle.putInt(str3, 0);
                    str3 = "Emergency";
                    if (!VDDiagnosisFragment.this.X4.getString("severityLevel").equals(ExifInterface.Y4)) {
                        bundle.putInt(str3, 0);
                        return bundle;
                    }
                } else {
                    if (i2 == 1) {
                        bundle.putString("Type", "Header");
                        str = "CLINICAL SCENARIO";
                    } else {
                        int i3 = 2;
                        if (i2 == 2) {
                            bundle.putString("Type", "TextList");
                            str2 = ((Bundle) VDDiagnosisFragment.this.Y4.get(VDDiagnosisFragment.this.b5)).getString("longName");
                        } else {
                            i3 = 3;
                            if (i2 == 3) {
                                bundle.putString("Type", "Header");
                                str = VDDiagnosisFragment.this.a5.size() + " IMAGES";
                            } else if (i2 == 4) {
                                bundle.putString("Type", "GridView");
                                str2 = "";
                            } else if (i2 == 5) {
                                bundle.putString("Type", "Header");
                                str = PdfWriterPipeline.f27720f;
                            } else {
                                if (i2 > 5) {
                                    bundle.putString("Type", "Item");
                                    bundle.putBundle("Item", (Bundle) VDDiagnosisFragment.this.Z4.get(i2 - 6));
                                    bundle.putInt(str3, 4);
                                }
                                return bundle;
                            }
                        }
                        bundle.putString("Text", str2);
                        bundle.putInt(str3, i3);
                        return bundle;
                    }
                    bundle.putString("Text", str);
                }
                bundle.putInt(str3, 1);
                return bundle;
            }

            public void e0(Bundle bundle, int i2) {
            }
        }

        /* access modifiers changed from: private */
        public String T4(int i2) {
            if (i2 == 1) {
                return "Very common or important";
            }
            if (i2 == 2) {
                return "Common";
            }
            if (i2 == 3) {
                return "Uncommon";
            }
            return i2 == 4 ? "Extremely rare" : "";
        }

        /* access modifiers changed from: private */
        public void U4(String str) {
            ArrayList<Bundle> arrayList = this.a5;
            if (arrayList == null || arrayList.size() == 0) {
                CompressHelper.x2(r(), "There is no media in this document", 1);
                return;
            }
            ArrayList arrayList2 = new ArrayList();
            int i2 = 0;
            for (int i3 = 0; i3 < this.a5.size(); i3++) {
                Bundle bundle = this.a5.get(i3);
                Bundle bundle2 = this.D4;
                String h1 = CompressHelper.h1(bundle2, bundle.getString("imageId") + ".jpg", "Large-Encrypted");
                Bundle bundle3 = new Bundle();
                bundle3.putString("ImagePath", h1);
                bundle3.putString("id", bundle.getString("imageId"));
                bundle3.putString("Encrypted", IcyHeaders.a3);
                if (bundle.getString("imageId").startsWith(str)) {
                    i2 = i3;
                }
                arrayList2.add(bundle3);
            }
            Intent intent = new Intent(r(), GalleryActivity.class);
            intent.putExtra("Images", arrayList2);
            intent.putExtra("Start", i2);
            D2(intent);
        }

        public void Q4() {
        }

        public String R2() {
            ArrayList<Bundle> arrayList = this.a5;
            if (arrayList == null || arrayList.size() <= 0) {
                return null;
            }
            Bundle v3 = v3(this.a5);
            Bundle bundle = this.D4;
            return CompressHelper.h1(bundle, v3.getString("imageId") + ".jpg", "Large-Encrypted");
        }

        public void R4() {
            this.d5.setItemAnimator(new DefaultItemAnimator());
            this.d5.setItemDecoration(new CustomItemDecoration(r()));
            this.d5.setLayoutManager(new LinearLayoutManager(r(), 1, false));
        }

        public int S4(int i2) {
            return (int) ((((float) i2) * b0().getDisplayMetrics().density) + 0.5f);
        }

        public void T0(Menu menu, MenuInflater menuInflater) {
        }

        public View onFragmentBind(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            View inflate = layoutInflater.inflate(R.layout.f1248fragment_new_list_viewer, viewGroup, false);
            this.Q4 = new CompressHelper(r());
            this.c5 = new Bundle();
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
                this.Y4 = bundle.getParcelableArrayList("mModules");
                this.Z4 = bundle.getParcelableArrayList("mFields");
                this.a5 = bundle.getParcelableArrayList("mImages");
                this.b5 = bundle.getInt("mSelectedModule");
                this.X4 = bundle.getBundle("mDiagnosis");
            }
            this.C4 = inflate;
            this.d5 = (RecyclerView) inflate.findViewById(R.id.f1054recycler_view);
            this.D4 = y().getBundle("DB");
            this.E4 = y().getString("URL");
            this.L4 = (Toolbar) this.C4.findViewById(R.id.f1139toolbar);
            TabHost tabHost = (TabHost) inflate.findViewById(R.id.f939findtabhost);
            this.x4 = tabHost;
            if (tabHost != null) {
                tabHost.setup();
            }
            if (y() == null) {
                return inflate;
            }
            try {
                final CompressHelper compressHelper = new CompressHelper(r());
                if (this.X4 == null) {
                    Bundle bundle2 = this.D4;
                    this.X4 = compressHelper.s1(compressHelper.V(bundle2, "select * from diagnoses where id = " + this.E4));
                    Bundle bundle3 = this.D4;
                    this.Y4 = compressHelper.V(bundle3, "SELECT DiagnosesModules.id,moduleId, imageCount,modules.longName FROM DiagnosesModules,modules where diagnosisId=" + this.E4 + " And diagnosesModules.moduleId=modules.id");
                    final int i2 = y().containsKey("defaultModule") ? y().getInt("defaultModule") : Integer.valueOf(this.X4.getString("defaultModule")).intValue();
                    this.b5 = this.Y4.indexOf((Bundle) new ArrayList(Collections2.d(this.Y4, new Predicate<Bundle>() {
                        /* renamed from: a */
                        public boolean apply(Bundle bundle) {
                            return bundle.getString("moduleId").equals(String.valueOf(i2));
                        }
                    })).get(0));
                    Bundle bundle4 = this.D4;
                    this.a5 = compressHelper.V(bundle4, "select imageId ,copyRight from Images where diagnosesModulesid=" + this.Y4.get(this.b5).getString("id"));
                    Bundle bundle5 = this.D4;
                    this.Z4 = compressHelper.V(bundle5, "select fieldId, fieldName,doc  from Documents, fields where DiagnosesModulesId=" + this.Y4.get(this.b5).getString("id") + " and documents.fieldId = fields.id");
                    this.F4 = this.X4.getString("dName");
                    this.A4 = "";
                    if (y().containsKey("SEARCH") && y().getStringArray("SEARCH") != null) {
                        new Timer().schedule(new TimerTask() {
                            public void run() {
                                CompressHelper compressHelper = compressHelper;
                                Bundle bundle = VDDiagnosisFragment.this.D4;
                                compressHelper.A1(bundle, "Doc-" + ((Bundle) VDDiagnosisFragment.this.Y4.get(VDDiagnosisFragment.this.b5)).getString("id"), VDDiagnosisFragment.this.y().getStringArray("SEARCH"), (String) null);
                                VDDiagnosisFragment.this.y().remove("SEARCH");
                            }
                        }, ExoPlayer.a1);
                    }
                }
                if (!compressHelper.x1()) {
                    m4(this.F4);
                }
                r().setTitle(this.F4);
                this.d5.setAdapter(new VDDiagnosisAdapter(r()));
                R4();
                f3(R.menu.f1414favorite);
                o2(false);
                g3();
                G3();
                return inflate;
            } catch (Exception e2) {
                FirebaseCrashlytics.d().g(e2);
                B4(e2);
                return inflate;
            }
        }

        public void V4() {
            ((ListView) this.C4.findViewById(R.id.f996list_view)).setVisibility(0);
            ((TextView) this.C4.findViewById(R.id.f1086status_label)).setVisibility(8);
            ((LinearLayout) this.C4.findViewById(R.id.f1087status_layout)).setVisibility(8);
        }

        public void h(Bundle bundle, String str) {
            CompressHelper compressHelper = new CompressHelper(r());
            if (str.equals("Module")) {
                this.b5 = this.Y4.indexOf(bundle);
                Bundle bundle2 = this.D4;
                this.a5 = compressHelper.V(bundle2, "select imageId ,copyRight from Images where diagnosesModulesid=" + this.Y4.get(this.b5).getString("id"));
                Bundle bundle3 = this.D4;
                this.Z4 = compressHelper.V(bundle3, "select fieldId, fieldName,doc  from Documents, fields where DiagnosesModulesId=" + this.Y4.get(this.b5).getString("id") + " and documents.fieldId = fields.id");
                this.d5.setAdapter(new VDDiagnosisAdapter(r()));
            }
        }

        public void l1() {
            super.l1();
            G3();
        }

        public void m1(Bundle bundle) {
            super.m1(bundle);
        }

        public void o4() {
            new AsyncTask() {

                /* renamed from: a  reason: collision with root package name */
                byte[] f30042a;

                /* access modifiers changed from: protected */
                public Object doInBackground(Object[] objArr) {
                    try {
                        File file = new File(VDDiagnosisFragment.this.R2());
                        this.f30042a = new CompressHelper(VDDiagnosisFragment.this.r()).w(CompressHelper.d2(file), file.getName(), "127");
                        return null;
                    } catch (Exception e2) {
                        FirebaseCrashlytics.d().g(e2);
                        iMDLogger.f("ImageGallery", "Error in decrypting image");
                        return null;
                    }
                }

                /* access modifiers changed from: protected */
                public void onPostExecute(Object obj) {
                    super.onPostExecute(obj);
                    Glide.G(VDDiagnosisFragment.this.r()).h(this.f30042a).B2(VDDiagnosisFragment.this.M4);
                }
            }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[0]);
        }

        public void onConfigurationChanged(Configuration configuration) {
            super.onConfigurationChanged(configuration);
            this.C4.postDelayed(new Runnable() {
                public void run() {
                    VDDiagnosisFragment.this.d5.getAdapter().G();
                }
            }, 500);
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.f1175activity_general_viewer);
        Y0(new VDDiagnosisFragment(), bundle);
    }
}
