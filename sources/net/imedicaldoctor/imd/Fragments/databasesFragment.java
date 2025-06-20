package net.imedicaldoctor.imd.Fragments;

import android.annotation.SuppressLint;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.SearchView;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.media3.common.util.k;
import androidx.media3.exoplayer.audio.SilenceSkippingAudioProcessor;
import androidx.media3.extractor.AacUtil;
import androidx.media3.extractor.metadata.icy.IcyHeaders;
import androidx.palette.graphics.Palette;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.h6ah4i.android.widget.advrecyclerview.draggable.DraggableItemAdapter;
import com.h6ah4i.android.widget.advrecyclerview.draggable.DraggableItemViewHolder;
import com.h6ah4i.android.widget.advrecyclerview.draggable.ItemDraggableRange;
import com.h6ah4i.android.widget.advrecyclerview.draggable.RecyclerViewDragDropManager;
import com.h6ah4i.android.widget.advrecyclerview.utils.AbstractDraggableItemViewHolder;
import com.itextpdf.text.pdf.PdfBoolean;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.observers.DisposableObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.io.File;
import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.imedicaldoctor.imd.Data.CompressHelper;
import net.imedicaldoctor.imd.R;
import net.imedicaldoctor.imd.Utils.MaterialRippleLayout;
import net.imedicaldoctor.imd.VBHelper;
import net.imedicaldoctor.imd.ViewHolders.StatusAdapter;
import net.imedicaldoctor.imd.iMD;
import net.imedicaldoctor.imd.iMDLogger;
import okio.BufferedSource;
import okio.Okio;
import org.apache.commons.lang3.StringUtils;

public class databasesFragment extends Fragment {
    public static ArrayList<Bundle> D4;
    public static ArrayList<Bundle> E4;
    public static ArrayList<Bundle> F4;
    HashMap<String, Bundle> A4 = new HashMap<>();
    private final ActivityResultLauncher<String> B4 = G(new ActivityResultContracts.RequestPermission(), new j());
    public BroadcastReceiver C4 = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            databasesFragment.this.y4.R0(new Runnable() {
                public void run() {
                    databasesFragment.this.y4.k0();
                    databasesFragment.E4 = databasesFragment.this.y4.p2();
                }
            }, new Runnable() {
                public void run() {
                    RecyclerView R2;
                    RecyclerView.Adapter s3;
                    databasesFragment.this.I3();
                    databasesFragment.E4.size();
                    if (databasesFragment.this.h4 != null) {
                        databasesFragment.this.h4.G();
                    }
                    if (databasesFragment.this.q4 != null) {
                        databasesFragment.this.q4.G();
                    }
                    databasesFragment.this.Q2();
                    if (databasesFragment.this.p4 != null) {
                        databasesFragment.this.p4.k0("", false);
                        databasesFragment.this.p4.clearFocus();
                        if (!databasesFragment.this.j4) {
                            R2 = databasesFragment.this.g4;
                            s3 = databasesFragment.this.h4;
                        } else {
                            R2 = databasesFragment.this.g4;
                            s3 = databasesFragment.this.q4;
                        }
                        R2.setAdapter(s3);
                        LocalBroadcastManager.b(databasesFragment.this.r()).d(new Intent("reloadDownloads"));
                        LocalBroadcastManager.b(databasesFragment.this.r()).d(new Intent("referesh.account"));
                        LocalBroadcastManager.b(databasesFragment.this.r()).d(new Intent("reloadaccountdownloads"));
                    }
                }
            });
        }
    };
    /* access modifiers changed from: private */
    public String e4;
    /* access modifiers changed from: private */
    public View f4;
    /* access modifiers changed from: private */
    public RecyclerView g4;
    /* access modifiers changed from: private */
    public DatabasesAdapter h4;
    /* access modifiers changed from: private */
    public long i4;
    /* access modifiers changed from: private */
    public boolean j4;
    public VBHelper k4;
    /* access modifiers changed from: private */
    public boolean l4;
    /* access modifiers changed from: private */
    public String m4;
    /* access modifiers changed from: private */
    public MenuItem n4;
    /* access modifiers changed from: private */
    public MenuItem o4;
    /* access modifiers changed from: private */
    public SearchView p4;
    /* access modifiers changed from: private */
    public CollectionAdapter q4;
    /* access modifiers changed from: private */
    public RecyclerViewDragDropManager r4;
    private long s4;
    /* access modifiers changed from: private */
    public CustomItemDecoration t4;
    /* access modifiers changed from: private */
    public GridLayoutManager u4;
    /* access modifiers changed from: private */
    public FloatingActionButton v4;
    private boolean w4;
    Typeface x4;
    /* access modifiers changed from: private */
    public CompressHelper y4;
    /* access modifiers changed from: private */
    public Bundle z4;

    public static class AddCellViewHolder extends RecyclerView.ViewHolder {
        public TextView I;

        public AddCellViewHolder(View view) {
            super(view);
            this.I = (TextView) view.findViewById(R.id.text);
        }
    }

    public static class CardViewPlaceHolder extends RecyclerView.ViewHolder {
        /* access modifiers changed from: private */
        public final TextView I;
        /* access modifiers changed from: private */
        public final TextView J;
        /* access modifiers changed from: private */
        public final ImageView K;
        /* access modifiers changed from: private */
        public final AppCompatButton L;
        /* access modifiers changed from: private */
        public final MaterialRippleLayout M;

        public CardViewPlaceHolder(View view) {
            super(view);
            this.I = (TextView) view.findViewById(R.id.f1132text_view);
            this.J = (TextView) view.findViewById(R.id.f1095subtext_view);
            this.K = (ImageView) view.findViewById(R.id.f980image_view);
            this.L = (AppCompatButton) view.findViewById(R.id.f862buy_button);
            this.M = (MaterialRippleLayout) view.findViewById(R.id.f1061ripple_layout);
        }
    }

    public class CollectionAdapter extends RecyclerView.Adapter {

        /* renamed from: d  reason: collision with root package name */
        HashMap<String, Integer> f30117d = new HashMap<>();

        public CollectionAdapter() {
            Iterator<Bundle> it2 = databasesFragment.E4.iterator();
            int i2 = 0;
            while (it2.hasNext()) {
                Bundle next = it2.next();
                HashMap<String, Integer> hashMap = this.f30117d;
                hashMap.put("Section" + next.getString("title"), Integer.valueOf(i2));
                i2++;
                for (int i3 = 0; i3 < next.getParcelableArrayList("items").size(); i3++) {
                    HashMap<String, Integer> hashMap2 = this.f30117d;
                    hashMap2.put("Database" + ((Bundle) next.getParcelableArrayList("items").get(i3)).getString("Name"), Integer.valueOf(i2));
                    i2++;
                }
            }
        }

        public long B(int i2) {
            return (long) i2;
        }

        public int C(int i2) {
            return databasesFragment.this.O2(i2, databasesFragment.E4).containsKey("Title") ? 1 : 0;
        }

        public void R(RecyclerView.ViewHolder viewHolder, int i2) {
            Bundle O2 = databasesFragment.this.O2(i2, databasesFragment.E4);
            if (O2.containsKey("Item")) {
                CardViewPlaceHolder cardViewPlaceHolder = (CardViewPlaceHolder) viewHolder;
                databasesFragment.this.L2(O2.getBundle("Item"), cardViewPlaceHolder.L, cardViewPlaceHolder.I, cardViewPlaceHolder.J, cardViewPlaceHolder.K, cardViewPlaceHolder.M, cardViewPlaceHolder.f15587a);
                return;
            }
            ((HeaderCellViewHolder) viewHolder).I.setText(O2.getString("Title"));
        }

        public RecyclerView.ViewHolder T(ViewGroup viewGroup, int i2) {
            if (i2 == 0) {
                CardViewPlaceHolder cardViewPlaceHolder = new CardViewPlaceHolder(LayoutInflater.from(databasesFragment.this.r()).inflate(R.layout.f1303list_view_item_card_view_database, viewGroup, false));
                cardViewPlaceHolder.I.setTypeface(databasesFragment.this.x4);
                return cardViewPlaceHolder;
            } else if (i2 == 1) {
                return new HeaderCellViewHolder(LayoutInflater.from(databasesFragment.this.r()).inflate(R.layout.f1308list_view_item_database_card_header, viewGroup, false));
            } else {
                return null;
            }
        }

        public int b() {
            return databasesFragment.this.L3(databasesFragment.E4);
        }
    }

    public static class DatabaseCellViewHolder extends RecyclerView.ViewHolder {
        public TextView I;
        public TextView J;
        public ImageView K;
        public MaterialRippleLayout L;
        public AppCompatButton M;

        public DatabaseCellViewHolder(View view) {
            super(view);
            this.I = (TextView) view.findViewById(R.id.f896database_title);
            this.K = (ImageView) view.findViewById(R.id.f893database_image);
            this.L = (MaterialRippleLayout) view.findViewById(R.id.f1061ripple_layout);
            this.M = (AppCompatButton) view.findViewById(R.id.f862buy_button);
            this.J = (TextView) view.findViewById(R.id.f895database_subtitle);
        }
    }

    public class DatabasesAdapter extends RecyclerView.Adapter {

        /* renamed from: d  reason: collision with root package name */
        HashMap<String, Integer> f30119d = new HashMap<>();

        public DatabasesAdapter() {
            Iterator<Bundle> it2 = databasesFragment.E4.iterator();
            int i2 = 0;
            while (it2.hasNext()) {
                Bundle next = it2.next();
                HashMap<String, Integer> hashMap = this.f30119d;
                hashMap.put("Section" + next.getString("title"), Integer.valueOf(i2));
                i2++;
                for (int i3 = 0; i3 < next.getParcelableArrayList("items").size(); i3++) {
                    HashMap<String, Integer> hashMap2 = this.f30119d;
                    hashMap2.put("Database" + ((Bundle) next.getParcelableArrayList("items").get(i3)).getString("Name"), Integer.valueOf(i2));
                    i2++;
                }
            }
        }

        public long B(int i2) {
            return (long) i2;
        }

        public int C(int i2) {
            return databasesFragment.this.O2(i2, databasesFragment.E4).containsKey("Title") ? 1 : 0;
        }

        public void R(RecyclerView.ViewHolder viewHolder, int i2) {
            Bundle O2 = databasesFragment.this.O2(i2, databasesFragment.E4);
            if (O2.containsKey("Item")) {
                DatabaseCellViewHolder databaseCellViewHolder = (DatabaseCellViewHolder) viewHolder;
                databasesFragment.this.L2(O2.getBundle("Item"), databaseCellViewHolder.M, databaseCellViewHolder.I, databaseCellViewHolder.J, databaseCellViewHolder.K, databaseCellViewHolder.L, databaseCellViewHolder.f15587a);
                return;
            }
            ((HeaderCellViewHolder) viewHolder).I.setText(O2.getString("Title"));
        }

        public RecyclerView.ViewHolder T(ViewGroup viewGroup, int i2) {
            if (i2 == 0) {
                return new DatabaseCellViewHolder(LayoutInflater.from(databasesFragment.this.r()).inflate(R.layout.f1312list_view_item_database_ripple, viewGroup, false));
            }
            if (i2 == 1) {
                return new HeaderCellViewHolder(LayoutInflater.from(databasesFragment.this.r()).inflate(R.layout.f1310list_view_item_database_header, viewGroup, false));
            }
            return null;
        }

        public int b() {
            return databasesFragment.this.L3(databasesFragment.E4);
        }
    }

    public static class EditDatabaseCellViewHolder extends AbstractDraggableItemViewHolder implements DraggableItemViewHolder {
        public TextView J;
        public ImageView K;
        public ImageView L;
        public LinearLayout M;
        public ImageView N;

        public EditDatabaseCellViewHolder(View view) {
            super(view);
            this.J = (TextView) view.findViewById(R.id.f896database_title);
            this.K = (ImageView) view.findViewById(R.id.f893database_image);
            this.L = (ImageView) view.findViewById(R.id.f921drag_indicator);
            this.M = (LinearLayout) view.findViewById(R.id.f885container_view);
            this.N = (ImageView) view.findViewById(R.id.f1058remove_icon);
        }
    }

    public class EditDatabasesAdapter extends RecyclerView.Adapter implements DraggableItemAdapter {

        /* renamed from: d  reason: collision with root package name */
        HashMap<String, Integer> f30121d;

        /* renamed from: e  reason: collision with root package name */
        int f30122e = 0;

        public EditDatabasesAdapter() {
            HashMap<String, Integer> hashMap = new HashMap<>();
            this.f30121d = hashMap;
            hashMap.put("AddSEction", Integer.valueOf(AacUtil.f12876f));
            this.f30121d.put("EditSectionas", Integer.valueOf(this.f30122e));
            this.f30122e++;
            Iterator<Bundle> it2 = databasesFragment.E4.iterator();
            while (it2.hasNext()) {
                this.f30121d.put("EditSection" + it2.next().getString("title"), Integer.valueOf(this.f30122e));
                this.f30122e = this.f30122e + 1;
            }
            Iterator<Bundle> it3 = databasesFragment.E4.iterator();
            while (it3.hasNext()) {
                Bundle next = it3.next();
                this.f30121d.put("Section" + next.getString("title"), Integer.valueOf(this.f30122e));
                this.f30122e = this.f30122e + 1;
                for (int i2 = 0; i2 < next.getParcelableArrayList("items").size(); i2++) {
                    this.f30121d.put("Database" + ((Bundle) next.getParcelableArrayList("items").get(i2)).getString("Name"), Integer.valueOf(this.f30122e));
                    this.f30122e = this.f30122e + 1;
                }
            }
            a0(true);
        }

        public long B(int i2) {
            StringBuilder sb;
            String str;
            String sb2;
            Object obj;
            if (i2 < databasesFragment.E4.size() + 1) {
                if (i2 == 0) {
                    obj = this.f30121d.get("EditSectionas");
                } else {
                    sb2 = "EditSection" + databasesFragment.E4.get(i2 - 1).getString("title");
                    obj = this.f30121d.get(sb2);
                }
            } else if (i2 == databasesFragment.E4.size() + 1) {
                return SilenceSkippingAudioProcessor.A;
            } else {
                Bundle O2 = databasesFragment.this.O2((i2 - databasesFragment.E4.size()) - 2, databasesFragment.E4);
                if (O2.containsKey("Item")) {
                    O2 = O2.getBundle("Item");
                    sb = new StringBuilder();
                    sb.append("Database");
                    str = "Name";
                } else {
                    sb = new StringBuilder();
                    sb.append("Section");
                    str = "Title";
                }
                sb.append(O2.getString(str));
                sb2 = sb.toString();
                if (!this.f30121d.containsKey(sb2)) {
                    return -1;
                }
                obj = this.f30121d.get(sb2);
            }
            return (long) ((Integer) obj).intValue();
        }

        public int C(int i2) {
            if (i2 < databasesFragment.E4.size() + 1) {
                return i2 == 0 ? 1 : 2;
            }
            if (i2 == databasesFragment.E4.size() + 1) {
                return 3;
            }
            return databasesFragment.this.O2((i2 - databasesFragment.E4.size()) - 2, databasesFragment.E4).containsKey("Title") ? 1 : 0;
        }

        public void R(RecyclerView.ViewHolder viewHolder, final int i2) {
            if (viewHolder.F() == 3) {
                AddCellViewHolder addCellViewHolder = (AddCellViewHolder) viewHolder;
                addCellViewHolder.I.setText("Add Section");
                addCellViewHolder.f15587a.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        final EditText editText = new EditText(databasesFragment.this.r());
                        editText.setTextColor(databasesFragment.this.b0().getColor(R.color.f140black));
                        new AlertDialog.Builder(databasesFragment.this.r(), R.style.f2185alertDialogTheme).l("Enter Section Name").setView(editText).y("Add", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogInterface, int i2) {
                                String obj = editText.getText().toString();
                                if (obj.length() == 0) {
                                    CompressHelper.x2(databasesFragment.this.r(), "You must enter a name for the section", 1);
                                    return;
                                }
                                if (EditDatabasesAdapter.this.f30121d.containsKey("EditSection" + obj)) {
                                    CompressHelper.x2(databasesFragment.this.r(), "You already have a section with this name", 1);
                                    return;
                                }
                                Bundle bundle = new Bundle();
                                bundle.putString("title", obj);
                                bundle.putParcelableArrayList("items", new ArrayList());
                                databasesFragment.E4.add(bundle);
                                EditDatabasesAdapter editDatabasesAdapter = EditDatabasesAdapter.this;
                                editDatabasesAdapter.f30122e++;
                                editDatabasesAdapter.f30121d.put("EditSection" + obj, Integer.valueOf(EditDatabasesAdapter.this.f30122e));
                            }
                        }).p("Cancel", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogInterface, int i2) {
                            }
                        }).I();
                    }
                });
            } else if (i2 >= databasesFragment.E4.size() + 1) {
                final Bundle O2 = databasesFragment.this.O2((i2 - databasesFragment.E4.size()) - 2, databasesFragment.E4);
                if (O2.containsKey("Item")) {
                    Bundle bundle = O2.getBundle("Item");
                    EditDatabaseCellViewHolder editDatabaseCellViewHolder = (EditDatabaseCellViewHolder) viewHolder;
                    editDatabaseCellViewHolder.J.setText(databasesFragment.this.y4.b1(bundle.getString("Title")));
                    Glide.F(databasesFragment.this).t(CompressHelper.C(bundle)).B2(editDatabaseCellViewHolder.K);
                    editDatabaseCellViewHolder.N.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            new AlertDialog.Builder(databasesFragment.this.r(), R.style.f2185alertDialogTheme).l("Are you really want to delete this database ?").y("Yes", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialogInterface, int i2) {
                                    int i3 = O2.getInt("Section");
                                    int i4 = O2.getInt("Row");
                                    String string = O2.getBundle("Item").getString("Path");
                                    databasesFragment.this.B3();
                                    iMDLogger.f("HideKeyboard", "5");
                                    databasesFragment.this.N2(new File(string));
                                    databasesFragment.E4.get(i3).getParcelableArrayList("items").remove(i4);
                                    databasesFragment.this.g4.getAdapter().G();
                                    databasesFragment.this.y4.o2(databasesFragment.E4);
                                }
                            }).p("No", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialogInterface, int i2) {
                                }
                            }).I();
                        }
                    });
                    return;
                }
                ((HeaderCellViewHolder) viewHolder).I.setText(O2.getString("Title"));
            } else if (i2 == 0) {
                ((HeaderCellViewHolder) viewHolder).I.setText("Sections");
            } else {
                final String string = databasesFragment.E4.get(i2 - 1).getString("title");
                EditHeaderCellViewHolder editHeaderCellViewHolder = (EditHeaderCellViewHolder) viewHolder;
                editHeaderCellViewHolder.J.setText(string);
                editHeaderCellViewHolder.f15587a.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        final EditText editText = new EditText(databasesFragment.this.r());
                        editText.setText(string);
                        editText.setTextColor(databasesFragment.this.b0().getColor(R.color.f140black));
                        new AlertDialog.Builder(databasesFragment.this.r(), R.style.f2185alertDialogTheme).l("Edit Section Name").setView(editText).y("Edit", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogInterface, int i2) {
                                String obj = editText.getText().toString();
                                if (obj.length() == 0) {
                                    CompressHelper.x2(databasesFragment.this.r(), "You must enter a name for the section", 1);
                                } else if (!obj.equals(string)) {
                                    if (EditDatabasesAdapter.this.f30121d.containsKey("EditSection" + obj)) {
                                        CompressHelper.x2(databasesFragment.this.r(), "You already have a section with this name", 1);
                                        return;
                                    }
                                    Bundle bundle = databasesFragment.E4.get(i2 - 1);
                                    bundle.remove("title");
                                    bundle.putString("title", obj);
                                    EditDatabasesAdapter editDatabasesAdapter = EditDatabasesAdapter.this;
                                    editDatabasesAdapter.f30122e++;
                                    editDatabasesAdapter.f30121d.put("EditSection" + obj, Integer.valueOf(EditDatabasesAdapter.this.f30122e));
                                }
                            }
                        }).p("Cancel", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogInterface, int i2) {
                            }
                        }).I();
                    }
                });
                editHeaderCellViewHolder.M.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        ArrayList parcelableArrayList = databasesFragment.E4.get(i2 - 1).getParcelableArrayList("items");
                        if (parcelableArrayList == null || parcelableArrayList.size() <= 0) {
                            databasesFragment.E4.remove(i2 - 1);
                            databasesFragment.this.g4.getAdapter().G();
                            return;
                        }
                        CompressHelper.x2(databasesFragment.this.r(), "First delete databases inside this section", 1);
                    }
                });
            }
        }

        public RecyclerView.ViewHolder T(ViewGroup viewGroup, int i2) {
            if (i2 == 0) {
                return new EditDatabaseCellViewHolder(LayoutInflater.from(databasesFragment.this.r()).inflate(R.layout.f1309list_view_item_database_edit, viewGroup, false));
            }
            if (i2 == 1) {
                return new HeaderCellViewHolder(LayoutInflater.from(databasesFragment.this.r()).inflate(R.layout.f1310list_view_item_database_header, viewGroup, false));
            }
            if (i2 == 2) {
                return new EditHeaderCellViewHolder(LayoutInflater.from(databasesFragment.this.r()).inflate(R.layout.f1311list_view_item_database_header_edit, viewGroup, false));
            }
            if (i2 == 3) {
                return new AddCellViewHolder(LayoutInflater.from(databasesFragment.this.r()).inflate(R.layout.f1299list_view_item_add, viewGroup, false));
            }
            return null;
        }

        public int b() {
            return databasesFragment.this.L3(databasesFragment.E4) + databasesFragment.E4.size() + 2;
        }

        public void h(int i2, int i3) {
            ArrayList parcelableArrayList;
            if (i2 > 0) {
                try {
                    if (i2 < databasesFragment.E4.size() + 1) {
                        int i4 = i2 - 1;
                        databasesFragment.E4.remove(i4);
                        databasesFragment.E4.add(i3 - 1, databasesFragment.E4.get(i4));
                        return;
                    }
                } catch (Exception e2) {
                    FirebaseCrashlytics.d().g(e2);
                    return;
                }
            }
            Bundle O2 = databasesFragment.this.O2((i2 - databasesFragment.E4.size()) - 2, databasesFragment.E4);
            int i5 = O2.getInt("Row");
            int i6 = O2.getInt("Section");
            Bundle bundle = (Bundle) databasesFragment.E4.get(i6).getParcelableArrayList("items").get(i5);
            Bundle O22 = databasesFragment.this.O2((i3 - databasesFragment.E4.size()) - 2, databasesFragment.E4);
            int i7 = O22.getInt("Row");
            int i8 = O22.getInt("Section");
            iMDLogger.f("Staring Drag", "Section " + i6 + " , Row : " + i5 + ", Section2:" + i8 + ", row2:" + i7);
            databasesFragment.E4.get(i6).getParcelableArrayList("items").remove(i5);
            if (O22.containsKey("Title")) {
                int i9 = O22.getInt("Row2");
                int i10 = O22.getInt("Section2");
                iMDLogger.f("Staring Drag", "Section22:" + i10 + ", row22:" + i9);
                if (i6 < i8) {
                    parcelableArrayList = databasesFragment.E4.get(i8).getParcelableArrayList("items");
                } else {
                    if (databasesFragment.E4.get(i10).getParcelableArrayList("items").size() == 0) {
                        i9 = 0;
                    }
                    databasesFragment.E4.get(i10).getParcelableArrayList("items").add(i9, bundle);
                    return;
                }
            } else {
                parcelableArrayList = databasesFragment.E4.get(i8).getParcelableArrayList("items");
            }
            parcelableArrayList.add(i7, bundle);
        }

        public boolean k(RecyclerView.ViewHolder viewHolder, int i2, int i3, int i4) {
            ImageView imageView;
            LinearLayout linearLayout;
            if (viewHolder.F() == 1 || viewHolder.F() == 3) {
                return false;
            }
            if (viewHolder.F() == 2) {
                EditHeaderCellViewHolder editHeaderCellViewHolder = (EditHeaderCellViewHolder) viewHolder;
                imageView = editHeaderCellViewHolder.K;
                linearLayout = editHeaderCellViewHolder.L;
            } else {
                EditDatabaseCellViewHolder editDatabaseCellViewHolder = (EditDatabaseCellViewHolder) viewHolder;
                imageView = editDatabaseCellViewHolder.L;
                linearLayout = editDatabaseCellViewHolder.M;
            }
            linearLayout.getTop();
            ViewCompat.C0(linearLayout);
            boolean a2 = ViewUtils.a(imageView, i3 - (linearLayout.getLeft() + ((int) (ViewCompat.B0(linearLayout) + 0.5f))), 50);
            iMDLogger.f("CanDrag", a2 ? PdfBoolean.l3 : "false");
            return a2;
        }

        public ItemDraggableRange w(RecyclerView.ViewHolder viewHolder, int i2) {
            if (i2 <= 0 || i2 >= databasesFragment.E4.size() + 1) {
                return new ItemDraggableRange(databasesFragment.E4.size() + 3, b() - 1);
            }
            iMDLogger.j("RequestingRange", "Range requested");
            return new ItemDraggableRange(1, databasesFragment.E4.size());
        }
    }

    public static class EditHeaderCellViewHolder extends AbstractDraggableItemViewHolder implements DraggableItemViewHolder {
        public TextView J;
        public ImageView K;
        public LinearLayout L;
        public ImageView M;

        public EditHeaderCellViewHolder(View view) {
            super(view);
            this.J = (TextView) view.findViewById(R.id.f957header_text);
            this.K = (ImageView) view.findViewById(R.id.f921drag_indicator);
            this.L = (LinearLayout) view.findViewById(R.id.f885container_view);
            this.M = (ImageView) view.findViewById(R.id.f1058remove_icon);
        }
    }

    public static class HeaderCellViewHolder extends RecyclerView.ViewHolder {
        public TextView I;

        public HeaderCellViewHolder(View view) {
            super(view);
            this.I = (TextView) view.findViewById(R.id.f957header_text);
        }
    }

    public class SearchCollectionDatabasesAdapter extends RecyclerView.Adapter {
        public SearchCollectionDatabasesAdapter() {
        }

        public long B(int i2) {
            return (long) i2;
        }

        public int C(int i2) {
            return 0;
        }

        public void R(RecyclerView.ViewHolder viewHolder, int i2) {
            CardViewPlaceHolder cardViewPlaceHolder = (CardViewPlaceHolder) viewHolder;
            databasesFragment.this.L2(databasesFragment.F4.get(i2), cardViewPlaceHolder.L, cardViewPlaceHolder.I, cardViewPlaceHolder.J, cardViewPlaceHolder.K, cardViewPlaceHolder.M, cardViewPlaceHolder.f15587a);
        }

        public RecyclerView.ViewHolder T(ViewGroup viewGroup, int i2) {
            return new CardViewPlaceHolder(LayoutInflater.from(databasesFragment.this.r()).inflate(R.layout.f1303list_view_item_card_view_database, viewGroup, false));
        }

        public int b() {
            return databasesFragment.F4.size();
        }
    }

    public class SearchDatabasesAdapter extends RecyclerView.Adapter {
        public SearchDatabasesAdapter() {
        }

        public long B(int i2) {
            return (long) i2;
        }

        public int C(int i2) {
            return 0;
        }

        public void R(RecyclerView.ViewHolder viewHolder, int i2) {
            DatabaseCellViewHolder databaseCellViewHolder = (DatabaseCellViewHolder) viewHolder;
            databasesFragment.this.L2(databasesFragment.F4.get(i2), databaseCellViewHolder.M, databaseCellViewHolder.I, databaseCellViewHolder.J, databaseCellViewHolder.K, databaseCellViewHolder.L, databaseCellViewHolder.f15587a);
        }

        public RecyclerView.ViewHolder T(ViewGroup viewGroup, int i2) {
            return new DatabaseCellViewHolder(LayoutInflater.from(databasesFragment.this.r()).inflate(R.layout.f1312list_view_item_database_ripple, viewGroup, false));
        }

        public int b() {
            return databasesFragment.F4.size();
        }
    }

    public class TestCollectionAdapter extends RecyclerView.Adapter {

        /* renamed from: d  reason: collision with root package name */
        HashMap<String, Integer> f30126d = new HashMap<>();

        public TestCollectionAdapter() {
        }

        public long B(int i2) {
            return (long) i2;
        }

        public int C(int i2) {
            return databasesFragment.this.O2(1, databasesFragment.E4).containsKey("Title") ? 1 : 0;
        }

        public void R(RecyclerView.ViewHolder viewHolder, final int i2) {
            Bundle O2 = databasesFragment.this.O2(1, databasesFragment.E4);
            if (O2.containsKey("Item")) {
                Bundle bundle = O2.getBundle("Item");
                final CardViewPlaceHolder cardViewPlaceHolder = (CardViewPlaceHolder) viewHolder;
                cardViewPlaceHolder.I.setText(databasesFragment.this.y4.b1(bundle.getString("Title")));
                final String C = CompressHelper.C(bundle);
                if (databasesFragment.this.z4.containsKey(C)) {
                    cardViewPlaceHolder.M.setRippleColor(databasesFragment.this.z4.getInt(C));
                } else {
                    databasesFragment.this.y3(new Runnable() {
                        public void run() {
                            Bitmap bitmap;
                            if (C.contains("file:///android_asset/")) {
                                try {
                                    bitmap = BitmapFactory.decodeStream(databasesFragment.this.r().getAssets().open(C.replace("file:///android_asset/", "")));
                                } catch (Exception e2) {
                                    FirebaseCrashlytics.d().g(e2);
                                    e2.printStackTrace();
                                    return;
                                }
                            } else {
                                bitmap = BitmapFactory.decodeFile(C);
                            }
                            Palette.Swatch C = Palette.b(bitmap).g().C();
                            if (C != null) {
                                int e3 = C.e();
                                if (!databasesFragment.this.z4.containsKey(C)) {
                                    databasesFragment.this.z4.putInt(C, e3);
                                }
                            }
                        }
                    }, new Runnable() {
                        public void run() {
                            cardViewPlaceHolder.M.setRippleColor(databasesFragment.this.z4.getInt(C));
                        }
                    });
                }
                Glide.F(databasesFragment.this).t(C).a(new RequestOptions().u()).B2(cardViewPlaceHolder.K);
                cardViewPlaceHolder.M.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Bundle O2 = databasesFragment.this.O2(i2, databasesFragment.E4);
                        if (!O2.containsKey("Title")) {
                            databasesFragment.this.y4.z1(O2.getBundle("Item"));
                        }
                    }
                });
                return;
            }
            ((HeaderCellViewHolder) viewHolder).I.setText(O2.getString("Title"));
        }

        public RecyclerView.ViewHolder T(ViewGroup viewGroup, int i2) {
            if (i2 == 0) {
                CardViewPlaceHolder cardViewPlaceHolder = new CardViewPlaceHolder(LayoutInflater.from(databasesFragment.this.r()).inflate(R.layout.f1303list_view_item_card_view_database, viewGroup, false));
                cardViewPlaceHolder.I.setTypeface(databasesFragment.this.x4);
                return cardViewPlaceHolder;
            } else if (i2 == 1) {
                return new HeaderCellViewHolder(LayoutInflater.from(databasesFragment.this.r()).inflate(R.layout.f1308list_view_item_database_card_header, viewGroup, false));
            } else {
                return null;
            }
        }

        public int b() {
            return 300;
        }
    }

    public abstract class UIActionClass extends ItemTouchHelper.Callback {

        /* renamed from: i  reason: collision with root package name */
        Context f30128i;

        /* renamed from: j  reason: collision with root package name */
        private final Paint f30129j;

        /* renamed from: k  reason: collision with root package name */
        private final ColorDrawable f30130k = new ColorDrawable();

        /* renamed from: l  reason: collision with root package name */
        private final int f30131l = Color.parseColor("#b80f0a");

        /* renamed from: m  reason: collision with root package name */
        private final Drawable f30132m;

        /* renamed from: n  reason: collision with root package name */
        private final int f30133n;
        private final int o;

        UIActionClass(Context context) {
            this.f30128i = context;
            Paint paint = new Paint();
            this.f30129j = paint;
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
            Drawable l2 = ContextCompat.l(this.f30128i, 17301564);
            this.f30132m = l2;
            this.f30133n = l2.getIntrinsicWidth();
            this.o = l2.getIntrinsicHeight();
        }

        private void E(Canvas canvas, Float f2, Float f3, Float f4, Float f5) {
            canvas.drawRect(f2.floatValue(), f3.floatValue(), f4.floatValue(), f5.floatValue(), this.f30129j);
        }

        public boolean A(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder2) {
            return false;
        }

        public int l(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
            if (databasesFragment.this.C3()) {
                return ItemTouchHelper.Callback.v(0, 0);
            }
            viewHolder.F();
            return ItemTouchHelper.Callback.v(0, 4);
        }

        public float n(@NonNull RecyclerView.ViewHolder viewHolder) {
            return 0.7f;
        }

        public void w(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, float f2, float f3, int i2, boolean z) {
            super.w(canvas, recyclerView, viewHolder, f2, f3, i2, z);
            View view = viewHolder.f15587a;
            int height = view.getHeight();
            if (f2 != 0.0f || z) {
                this.f30130k.setColor(this.f30131l);
                this.f30130k.setBounds(view.getRight() + ((int) f2), view.getTop(), view.getRight(), view.getBottom());
                this.f30130k.draw(canvas);
                int top = view.getTop();
                int i3 = this.o;
                int i4 = top + ((height - i3) / 2);
                int i5 = (height - i3) / 2;
                this.f30132m.setBounds((view.getRight() - i5) - this.f30133n, i4, view.getRight() - i5, this.o + i4);
                this.f30132m.draw(canvas);
            } else {
                E(canvas, Float.valueOf(((float) view.getRight()) + f2), Float.valueOf((float) view.getTop()), Float.valueOf((float) view.getRight()), Float.valueOf((float) view.getBottom()));
            }
            super.w(canvas, recyclerView, viewHolder, f2, f3, i2, z);
        }
    }

    public abstract class UIActionClassRight extends ItemTouchHelper.Callback {

        /* renamed from: i  reason: collision with root package name */
        Context f30134i;

        /* renamed from: j  reason: collision with root package name */
        private final Paint f30135j;

        /* renamed from: k  reason: collision with root package name */
        private final ColorDrawable f30136k = new ColorDrawable();

        /* renamed from: l  reason: collision with root package name */
        private final int f30137l = Color.parseColor("#0ab867");

        /* renamed from: m  reason: collision with root package name */
        private final Drawable f30138m;

        /* renamed from: n  reason: collision with root package name */
        private final int f30139n;
        private final int o;

        UIActionClassRight(Context context) {
            this.f30134i = context;
            Paint paint = new Paint();
            this.f30135j = paint;
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
            Drawable l2 = ContextCompat.l(this.f30134i, 17301566);
            this.f30138m = l2;
            this.f30139n = l2.getIntrinsicWidth();
            this.o = l2.getIntrinsicHeight();
        }

        private void E(Canvas canvas, Float f2, Float f3, Float f4, Float f5) {
            canvas.drawRect(f2.floatValue(), f3.floatValue(), f4.floatValue(), f5.floatValue(), this.f30135j);
        }

        public boolean A(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder2) {
            return false;
        }

        public int l(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
            if (databasesFragment.this.C3()) {
                return ItemTouchHelper.Callback.v(0, 0);
            }
            return viewHolder.F() == 1 ? ItemTouchHelper.Callback.v(0, 8) : ItemTouchHelper.Callback.v(0, 0);
        }

        public float n(@NonNull RecyclerView.ViewHolder viewHolder) {
            return 0.7f;
        }

        public void w(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, float f2, float f3, int i2, boolean z) {
            super.w(canvas, recyclerView, viewHolder, f2, f3, i2, z);
            View view = viewHolder.f15587a;
            int height = view.getHeight();
            if (f2 != 0.0f || z) {
                this.f30136k.setColor(this.f30137l);
                this.f30136k.setBounds(view.getLeft(), view.getTop(), view.getLeft() + ((int) f2), view.getBottom());
                this.f30136k.draw(canvas);
                int top = view.getTop();
                int i3 = this.o;
                int i4 = top + ((height - i3) / 2);
                int i5 = (height - i3) / 2;
                this.f30138m.setBounds(i5, i4, this.f30139n + i5, i3 + i4);
                this.f30138m.draw(canvas);
            } else {
                E(canvas, Float.valueOf(((float) view.getRight()) + f2), Float.valueOf((float) view.getTop()), Float.valueOf((float) view.getRight()), Float.valueOf((float) view.getBottom()));
            }
            super.w(canvas, recyclerView, viewHolder, f2, f3, i2, z);
        }
    }

    /* access modifiers changed from: private */
    public void F3(@NonNull File file, @NonNull File file2, Bundle bundle, ObservableEmitter<Bundle> observableEmitter) throws IOException {
        if (file.isDirectory()) {
            G3(file, file2, bundle, observableEmitter);
            return;
        }
        this.i4++;
        if (System.currentTimeMillis() - this.s4 > 1000) {
            if (bundle.containsKey("counter")) {
                bundle.remove("counter");
            }
            bundle.putLong("counter", this.i4);
            this.s4 = System.currentTimeMillis();
            observableEmitter.onNext(bundle);
        }
        if (Build.VERSION.SDK_INT >= 26) {
            Path a2 = Paths.get(file.toURI());
            Path a3 = Paths.get(file2.toURI());
            if (!file2.exists()) {
                Path unused = Files.move(a2, a3, new CopyOption[0]);
            } else if ((file2.getName().contains("favorites.db") || file2.getName().contains("favorites.json") || file2.getName().contains("databases.json") || file2.getName().contains("highlights.db") || file2.getName().contains("recent.db")) && file2.delete()) {
                Path unused2 = Files.move(a2, a3, new CopyOption[0]);
            }
        } else if (!file2.exists() || ((file2.getName().contains("favorites.db") || file2.getName().contains("favorites.json") || file2.getName().contains("databases.json") || file2.getName().contains("highlights.db") || file2.getName().contains("recent.db")) && file2.delete())) {
            CompressHelper.Q1(file, file2);
        }
    }

    private void G3(@NonNull File file, @NonNull File file2, Bundle bundle, ObservableEmitter<Bundle> observableEmitter) throws IOException {
        if (file2.exists() || file2.mkdir()) {
            for (String str : file.list()) {
                F3(new File(file, str), new File(file2, str), bundle, observableEmitter);
            }
        }
    }

    /* access modifiers changed from: private */
    public void w3() {
        x3();
        if (Build.VERSION.SDK_INT >= 33 && ContextCompat.a(r(), "android.permission.POST_NOTIFICATIONS") != 0) {
            boolean C2 = C2("android.permission.POST_NOTIFICATIONS");
            this.B4.b("android.permission.POST_NOTIFICATIONS");
        }
    }

    private void x3() {
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationChannel a2 = k.a("12121", "iMDChannel", 4);
            a2.setDescription("iMDChannel");
            ((NotificationManager) r().getSystemService(NotificationManager.class)).createNotificationChannel(a2);
        }
    }

    /* access modifiers changed from: private */
    public void z3() {
        AnonymousClass1 r0 = new UIActionClass(r()) {
            /* JADX WARNING: Removed duplicated region for block: B:12:0x0043 A[Catch:{ Exception -> 0x0032 }] */
            /* JADX WARNING: Removed duplicated region for block: B:13:0x0071 A[Catch:{ Exception -> 0x0032 }] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void D(@androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView.ViewHolder r4, int r5) {
                /*
                    r3 = this;
                    int r5 = r4.B()     // Catch:{ Exception -> 0x0032 }
                    net.imedicaldoctor.imd.Fragments.databasesFragment r0 = net.imedicaldoctor.imd.Fragments.databasesFragment.this     // Catch:{ Exception -> 0x0032 }
                    androidx.recyclerview.widget.RecyclerView r0 = r0.g4     // Catch:{ Exception -> 0x0032 }
                    androidx.recyclerview.widget.RecyclerView$Adapter r0 = r0.getAdapter()     // Catch:{ Exception -> 0x0032 }
                    java.lang.Class r0 = r0.getClass()     // Catch:{ Exception -> 0x0032 }
                    java.lang.Class<net.imedicaldoctor.imd.Fragments.databasesFragment$SearchDatabasesAdapter> r1 = net.imedicaldoctor.imd.Fragments.databasesFragment.SearchDatabasesAdapter.class
                    if (r0 == r1) goto L_0x0035
                    net.imedicaldoctor.imd.Fragments.databasesFragment r0 = net.imedicaldoctor.imd.Fragments.databasesFragment.this     // Catch:{ Exception -> 0x0032 }
                    androidx.recyclerview.widget.RecyclerView r0 = r0.g4     // Catch:{ Exception -> 0x0032 }
                    androidx.recyclerview.widget.RecyclerView$Adapter r0 = r0.getAdapter()     // Catch:{ Exception -> 0x0032 }
                    java.lang.Class r0 = r0.getClass()     // Catch:{ Exception -> 0x0032 }
                    java.lang.Class<net.imedicaldoctor.imd.Fragments.databasesFragment$SearchCollectionDatabasesAdapter> r1 = net.imedicaldoctor.imd.Fragments.databasesFragment.SearchCollectionDatabasesAdapter.class
                    if (r0 != r1) goto L_0x0029
                    goto L_0x0035
                L_0x0029:
                    net.imedicaldoctor.imd.Fragments.databasesFragment r0 = net.imedicaldoctor.imd.Fragments.databasesFragment.this     // Catch:{ Exception -> 0x0032 }
                    java.util.ArrayList<android.os.Bundle> r1 = net.imedicaldoctor.imd.Fragments.databasesFragment.E4     // Catch:{ Exception -> 0x0032 }
                    android.os.Bundle r0 = r0.O2(r5, r1)     // Catch:{ Exception -> 0x0032 }
                    goto L_0x003d
                L_0x0032:
                    r4 = move-exception
                    goto L_0x00c5
                L_0x0035:
                    java.util.ArrayList<android.os.Bundle> r0 = net.imedicaldoctor.imd.Fragments.databasesFragment.F4     // Catch:{ Exception -> 0x0032 }
                    java.lang.Object r0 = r0.get(r5)     // Catch:{ Exception -> 0x0032 }
                    android.os.Bundle r0 = (android.os.Bundle) r0     // Catch:{ Exception -> 0x0032 }
                L_0x003d:
                    int r4 = r4.F()     // Catch:{ Exception -> 0x0032 }
                    if (r4 != 0) goto L_0x0071
                    androidx.appcompat.app.AlertDialog$Builder r4 = new androidx.appcompat.app.AlertDialog$Builder     // Catch:{ Exception -> 0x0032 }
                    net.imedicaldoctor.imd.Fragments.databasesFragment r1 = net.imedicaldoctor.imd.Fragments.databasesFragment.this     // Catch:{ Exception -> 0x0032 }
                    androidx.fragment.app.FragmentActivity r1 = r1.r()     // Catch:{ Exception -> 0x0032 }
                    r2 = 2132018351(0x7f1404af, float:1.9675006E38)
                    r4.<init>(r1, r2)     // Catch:{ Exception -> 0x0032 }
                    java.lang.String r1 = "Are you really want to delete this database ?"
                    androidx.appcompat.app.AlertDialog$Builder r4 = r4.l(r1)     // Catch:{ Exception -> 0x0032 }
                    java.lang.String r1 = "Yes"
                    net.imedicaldoctor.imd.Fragments.databasesFragment$1$2 r2 = new net.imedicaldoctor.imd.Fragments.databasesFragment$1$2     // Catch:{ Exception -> 0x0032 }
                    r2.<init>(r0, r5)     // Catch:{ Exception -> 0x0032 }
                    androidx.appcompat.app.AlertDialog$Builder r4 = r4.y(r1, r2)     // Catch:{ Exception -> 0x0032 }
                    java.lang.String r0 = "No"
                    net.imedicaldoctor.imd.Fragments.databasesFragment$1$1 r1 = new net.imedicaldoctor.imd.Fragments.databasesFragment$1$1     // Catch:{ Exception -> 0x0032 }
                    r1.<init>(r5)     // Catch:{ Exception -> 0x0032 }
                    androidx.appcompat.app.AlertDialog$Builder r4 = r4.p(r0, r1)     // Catch:{ Exception -> 0x0032 }
                    r4.I()     // Catch:{ Exception -> 0x0032 }
                    goto L_0x00cc
                L_0x0071:
                    java.lang.String r4 = "Section"
                    int r4 = r0.getInt(r4)     // Catch:{ Exception -> 0x0032 }
                    java.util.ArrayList<android.os.Bundle> r0 = net.imedicaldoctor.imd.Fragments.databasesFragment.E4     // Catch:{ Exception -> 0x0032 }
                    java.lang.Object r0 = r0.get(r4)     // Catch:{ Exception -> 0x0032 }
                    android.os.Bundle r0 = (android.os.Bundle) r0     // Catch:{ Exception -> 0x0032 }
                    java.lang.String r1 = "items"
                    java.util.ArrayList r0 = r0.getParcelableArrayList(r1)     // Catch:{ Exception -> 0x0032 }
                    if (r0 == 0) goto L_0x00a7
                    int r0 = r0.size()     // Catch:{ Exception -> 0x0032 }
                    if (r0 <= 0) goto L_0x00a7
                    net.imedicaldoctor.imd.Fragments.databasesFragment r4 = net.imedicaldoctor.imd.Fragments.databasesFragment.this     // Catch:{ Exception -> 0x0032 }
                    androidx.fragment.app.FragmentActivity r4 = r4.r()     // Catch:{ Exception -> 0x0032 }
                    java.lang.String r0 = "First delete databases inside this section"
                    r1 = 1
                    net.imedicaldoctor.imd.Data.CompressHelper.x2(r4, r0, r1)     // Catch:{ Exception -> 0x0032 }
                    net.imedicaldoctor.imd.Fragments.databasesFragment r4 = net.imedicaldoctor.imd.Fragments.databasesFragment.this     // Catch:{ Exception -> 0x0032 }
                    androidx.recyclerview.widget.RecyclerView r4 = r4.g4     // Catch:{ Exception -> 0x0032 }
                    androidx.recyclerview.widget.RecyclerView$Adapter r4 = r4.getAdapter()     // Catch:{ Exception -> 0x0032 }
                    r4.H(r5)     // Catch:{ Exception -> 0x0032 }
                    return
                L_0x00a7:
                    java.util.ArrayList<android.os.Bundle> r0 = net.imedicaldoctor.imd.Fragments.databasesFragment.E4     // Catch:{ Exception -> 0x0032 }
                    r0.remove(r4)     // Catch:{ Exception -> 0x0032 }
                    net.imedicaldoctor.imd.Fragments.databasesFragment r4 = net.imedicaldoctor.imd.Fragments.databasesFragment.this     // Catch:{ Exception -> 0x0032 }
                    net.imedicaldoctor.imd.Data.CompressHelper r4 = r4.y4     // Catch:{ Exception -> 0x0032 }
                    java.util.ArrayList<android.os.Bundle> r0 = net.imedicaldoctor.imd.Fragments.databasesFragment.E4     // Catch:{ Exception -> 0x0032 }
                    r4.o2(r0)     // Catch:{ Exception -> 0x0032 }
                    net.imedicaldoctor.imd.Fragments.databasesFragment r4 = net.imedicaldoctor.imd.Fragments.databasesFragment.this     // Catch:{ Exception -> 0x0032 }
                    androidx.recyclerview.widget.RecyclerView r4 = r4.g4     // Catch:{ Exception -> 0x0032 }
                    androidx.recyclerview.widget.RecyclerView$Adapter r4 = r4.getAdapter()     // Catch:{ Exception -> 0x0032 }
                    r4.P(r5)     // Catch:{ Exception -> 0x0032 }
                    goto L_0x00cc
                L_0x00c5:
                    com.google.firebase.crashlytics.FirebaseCrashlytics r5 = com.google.firebase.crashlytics.FirebaseCrashlytics.d()
                    r5.g(r4)
                L_0x00cc:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: net.imedicaldoctor.imd.Fragments.databasesFragment.AnonymousClass1.D(androidx.recyclerview.widget.RecyclerView$ViewHolder, int):void");
            }
        };
        AnonymousClass2 r1 = new UIActionClassRight(r()) {
            public void D(@NonNull RecyclerView.ViewHolder viewHolder, int i2) {
                final ArrayList arrayList = new ArrayList();
                final int B = viewHolder.B();
                final int i3 = databasesFragment.this.O2(B, databasesFragment.E4).getInt("Section");
                final String string = databasesFragment.E4.get(i3).getString("title");
                for (int i4 = 0; i4 < databasesFragment.E4.size(); i4++) {
                    if (i4 != i3) {
                        arrayList.add(databasesFragment.E4.get(i4).getString("title"));
                    }
                }
                final EditText editText = new EditText(databasesFragment.this.r());
                editText.setText(string);
                editText.setTextColor(databasesFragment.this.b0().getColor(R.color.f140black));
                final int i5 = B;
                new AlertDialog.Builder(databasesFragment.this.r(), R.style.f2185alertDialogTheme).l("Edit Section Name").setView(editText).y("Edit", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i2) {
                        String obj = editText.getText().toString();
                        if (obj.length() == 0) {
                            CompressHelper.x2(databasesFragment.this.r(), "You must enter a name for the section", 1);
                            databasesFragment.this.g4.getAdapter().H(i5);
                        } else if (obj.equals(string)) {
                            databasesFragment.this.g4.getAdapter().H(i5);
                        } else if (arrayList.contains(obj)) {
                            CompressHelper.x2(databasesFragment.this.r(), "You already have a section with this name", 1);
                            databasesFragment.this.g4.getAdapter().H(i5);
                        } else {
                            Bundle bundle = databasesFragment.E4.get(i3);
                            bundle.remove("title");
                            bundle.putString("title", obj);
                            databasesFragment.this.g4.getAdapter().H(i5);
                            databasesFragment.this.y4.o2(databasesFragment.E4);
                        }
                    }
                }).p("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i2) {
                        databasesFragment.this.g4.getAdapter().H(B);
                    }
                }).I();
            }
        };
        new ItemTouchHelper(r0).m(this.g4);
        new ItemTouchHelper(r1).m(this.g4);
    }

    public long A3(File file) {
        if (!file.isDirectory()) {
            return 1;
        }
        int i2 = 0;
        for (File file2 : file.listFiles()) {
            i2 = file2.isDirectory() ? (int) (((long) i2) + A3(file2)) : i2 + 1;
        }
        return (long) i2;
    }

    public void B3() {
        iMDLogger.f("HideKeyboard", "6");
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) r().getSystemService("input_method");
            if (r().getCurrentFocus() != null) {
                inputMethodManager.hideSoftInputFromWindow(r().getCurrentFocus().getWindowToken(), 0);
            }
            if (r().getCurrentFocus() != null) {
                r().getCurrentFocus().clearFocus();
            }
        } catch (Exception unused) {
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x003d, code lost:
        r0 = E4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean C3() {
        /*
            r3 = this;
            androidx.recyclerview.widget.RecyclerView r0 = r3.g4
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            androidx.recyclerview.widget.RecyclerView$Adapter r0 = r0.getAdapter()
            java.lang.Class r0 = r0.getClass()
            java.lang.Class<net.imedicaldoctor.imd.Fragments.databasesFragment$SearchDatabasesAdapter> r2 = net.imedicaldoctor.imd.Fragments.databasesFragment.SearchDatabasesAdapter.class
            if (r0 == r2) goto L_0x0048
            androidx.recyclerview.widget.RecyclerView r0 = r3.g4
            androidx.recyclerview.widget.RecyclerView$Adapter r0 = r0.getAdapter()
            java.lang.Class r0 = r0.getClass()
            java.lang.Class<net.imedicaldoctor.imd.Fragments.databasesFragment$SearchCollectionDatabasesAdapter> r2 = net.imedicaldoctor.imd.Fragments.databasesFragment.SearchCollectionDatabasesAdapter.class
            if (r0 == r2) goto L_0x0048
            androidx.recyclerview.widget.RecyclerView r0 = r3.g4
            androidx.recyclerview.widget.RecyclerView$Adapter r0 = r0.getAdapter()
            java.lang.Class r0 = r0.getClass()
            java.lang.Class<net.imedicaldoctor.imd.Fragments.databasesFragment$DatabasesAdapter> r2 = net.imedicaldoctor.imd.Fragments.databasesFragment.DatabasesAdapter.class
            if (r0 == r2) goto L_0x0048
            androidx.recyclerview.widget.RecyclerView r0 = r3.g4
            androidx.recyclerview.widget.RecyclerView$Adapter r0 = r0.getAdapter()
            java.lang.Class r0 = r0.getClass()
            java.lang.Class<net.imedicaldoctor.imd.Fragments.databasesFragment$CollectionAdapter> r2 = net.imedicaldoctor.imd.Fragments.databasesFragment.CollectionAdapter.class
            if (r0 != r2) goto L_0x003d
            goto L_0x0048
        L_0x003d:
            java.util.ArrayList<android.os.Bundle> r0 = E4
            if (r0 == 0) goto L_0x0048
            int r0 = r0.size()
            if (r0 == 0) goto L_0x0048
            r1 = 1
        L_0x0048:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: net.imedicaldoctor.imd.Fragments.databasesFragment.C3():boolean");
    }

    public void E3() {
        if ((Build.VERSION.SDK_INT < 23 || ContextCompat.a(r(), "android.permission.WRITE_EXTERNAL_STORAGE") == 0) && new File(this.y4.L()).exists()) {
            P2(new File(this.y4.L()), new File(this.y4.M1()));
        }
    }

    public void H3(final String str) {
        Observable.w1(new ObservableOnSubscribe<String>() {
            public void a(@io.reactivex.rxjava3.annotations.NonNull ObservableEmitter<String> observableEmitter) throws Throwable {
                databasesFragment.F4 = new ArrayList<>(Collections2.d(((iMD) databasesFragment.this.r().getApplicationContext()).s, new Predicate<Bundle>() {
                    /* renamed from: a */
                    public boolean apply(Bundle bundle) {
                        try {
                            return bundle.getString("Title").toLowerCase().contains(str.toLowerCase());
                        } catch (Exception e2) {
                            FirebaseCrashlytics.d().g(e2);
                            iMDLogger.f("Error in filtering", e2.getLocalizedMessage());
                            e2.printStackTrace();
                            return false;
                        }
                    }
                }));
                observableEmitter.onComplete();
            }
        }).h6(Schedulers.e()).s4(AndroidSchedulers.e()).f6(new Consumer<String>() {
            /* renamed from: a */
            public void accept(String str) throws Throwable {
            }
        }, new Consumer<Throwable>() {
            /* renamed from: a */
            public void accept(Throwable th) throws Throwable {
                try {
                    iMDLogger.f("DatabasesFragmentSearch", "Error occured in filtering databases");
                    th.printStackTrace();
                } catch (Exception unused) {
                }
            }
        }, new Action() {
            public void run() throws Throwable {
                RecyclerView R2;
                RecyclerView.Adapter searchCollectionDatabasesAdapter;
                ArrayList<Bundle> arrayList = databasesFragment.F4;
                if (arrayList == null || arrayList.size() == 0) {
                    databasesFragment.this.K3("Nothing Found");
                    return;
                }
                databasesFragment.this.J3();
                if (!databasesFragment.this.j4) {
                    R2 = databasesFragment.this.g4;
                    searchCollectionDatabasesAdapter = new SearchDatabasesAdapter();
                } else {
                    R2 = databasesFragment.this.g4;
                    searchCollectionDatabasesAdapter = new SearchCollectionDatabasesAdapter();
                }
                R2.setAdapter(searchCollectionDatabasesAdapter);
            }
        });
    }

    public final void I3() {
        iMDLogger.d("sendFavorite", "Sending FavoriteChanged message");
        Intent intent = new Intent("net.imedicaldoctor.imd.favorite");
        intent.putExtra("Test", "Random data for test");
        LocalBroadcastManager.b(r()).d(intent);
    }

    public void J3() {
        RecyclerView recyclerView;
        RecyclerView.Adapter adapter;
        if (!this.j4) {
            recyclerView = this.g4;
            adapter = this.h4;
        } else {
            recyclerView = this.g4;
            adapter = this.q4;
        }
        recyclerView.setAdapter(adapter);
    }

    public void K2(final Bundle bundle) {
        AnonymousClass22 r0 = new DisposableObserver<String>() {
            /* renamed from: c */
            public void onNext(@io.reactivex.rxjava3.annotations.NonNull String str) {
                String str2;
                String[] splitByWholeSeparator = StringUtils.splitByWholeSeparator(str, "|||||");
                if (splitByWholeSeparator[0].equals(IcyHeaders.a3)) {
                    String str3 = splitByWholeSeparator[1];
                    if (str3.equals("0")) {
                        str2 = "Are You Sure You Want To Buy " + bundle.getString("Title") + " For Free ?";
                    } else {
                        str2 = "Are You Sure You Want To Buy " + bundle.getString("Title") + " For " + str3 + " Toman ?";
                    }
                    new AlertDialog.Builder(databasesFragment.this.r(), R.style.f2185alertDialogTheme).l(str2).y("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogInterface, int i2) {
                            AnonymousClass1 r6 = new DisposableObserver<String>() {
                                @SuppressLint({"NotifyDataSetChanged"})
                                /* renamed from: c */
                                public void onNext(@io.reactivex.rxjava3.annotations.NonNull String str) {
                                    String[] splitByWholeSeparator = StringUtils.splitByWholeSeparator(str, "|||||");
                                    if (splitByWholeSeparator[0].equals(IcyHeaders.a3)) {
                                        databasesFragment.this.y4.t2(splitByWholeSeparator[1]);
                                        databasesFragment.this.y4.k0();
                                        LocalBroadcastManager.b(databasesFragment.this.r()).d(new Intent("referesh.account"));
                                        LocalBroadcastManager.b(databasesFragment.this.r()).d(new Intent("reloadDownloads"));
                                        bundle.remove("Inactive");
                                        bundle.remove("Demo");
                                        databasesFragment.this.g4.getAdapter().G();
                                        databasesFragment.this.y4.L1();
                                        Toast.makeText(databasesFragment.this.r(), "Purchase was successful", 1).show();
                                    } else if (splitByWholeSeparator.length <= 1) {
                                    } else {
                                        if (splitByWholeSeparator[1].contains("Not Enough Money")) {
                                            new AlertDialog.Builder(databasesFragment.this.r(), R.style.f2185alertDialogTheme).l("You don't have enough credit in your account. what do you want to do ?").y("Buy Database", new DialogInterface.OnClickListener() {
                                                public void onClick(DialogInterface dialogInterface, int i2) {
                                                    StringBuilder sb = new StringBuilder();
                                                    sb.append("http://imedicaldoctor.net/buydb.php?user=");
                                                    databasesFragment databasesfragment = databasesFragment.this;
                                                    sb.append(databasesfragment.k4.n(databasesfragment.y4.y1(), "127"));
                                                    sb.append("&db=");
                                                    AnonymousClass22 r5 = AnonymousClass22.this;
                                                    sb.append(databasesFragment.this.k4.n(bundle.getString("Name"), "127"));
                                                    databasesFragment.this.y4.P(sb.toString());
                                                }
                                            }).p("Cancel", new DialogInterface.OnClickListener() {
                                                public void onClick(DialogInterface dialogInterface, int i2) {
                                                }
                                            }).I();
                                        } else {
                                            CompressHelper.x2(databasesFragment.this.r(), splitByWholeSeparator[1], 1);
                                        }
                                    }
                                }

                                public void onComplete() {
                                }

                                public void onError(@io.reactivex.rxjava3.annotations.NonNull Throwable th) {
                                    CompressHelper.x2(databasesFragment.this.r(), "Error in contacting server, try again later", 1);
                                }
                            };
                            CompressHelper T2 = databasesFragment.this.y4;
                            databasesFragment databasesfragment = databasesFragment.this;
                            CompressHelper T22 = databasesfragment.y4;
                            T2.I0(databasesfragment, T22.o0("BuyItem|||||" + new VBHelper(databasesFragment.this.r()).m() + "|||||" + bundle.getString("Name"))).a(r6);
                        }
                    }).p("No", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogInterface, int i2) {
                        }
                    }).I();
                    return;
                }
                CompressHelper.x2(databasesFragment.this.r(), splitByWholeSeparator[1], 1);
            }

            public void onComplete() {
            }

            public void onError(@io.reactivex.rxjava3.annotations.NonNull Throwable th) {
                CompressHelper.x2(databasesFragment.this.r(), "Error in contacting server, try again later", 1);
            }
        };
        CompressHelper compressHelper = this.y4;
        compressHelper.I0(this, compressHelper.o0("QueryPrice|||||" + new VBHelper(r()).m() + "|||||" + bundle.getString("Name"))).a(r0);
    }

    public void K3(String str) {
        RecyclerView recyclerView;
        RecyclerView.Adapter statusAdapter;
        if (str.toLowerCase().contains("go to".toLowerCase())) {
            recyclerView = this.g4;
            statusAdapter = new StatusAdapter(r(), str) {
                public void d0() {
                    ((mainActivity) databasesFragment.this.r()).y3.setCurrentItem(4);
                }
            };
        } else {
            recyclerView = this.g4;
            statusAdapter = new StatusAdapter(r(), str);
        }
        recyclerView.setAdapter(statusAdapter);
    }

    public void L2(final Bundle bundle, AppCompatButton appCompatButton, TextView textView, TextView textView2, ImageView imageView, final MaterialRippleLayout materialRippleLayout, View view) {
        String str;
        View.OnClickListener r42;
        textView.setText(this.y4.b1(bundle.getString("Title")));
        final String C = CompressHelper.C(bundle);
        if (C.contains("file:///android_asset/") || new File(C).exists()) {
            if (C.contains("irandarou")) {
                iMDLogger.f("debug", "de");
            }
            Glide.F(this).t(C).B2(imageView);
            if (this.w4) {
                if (this.z4.containsKey(C)) {
                    materialRippleLayout.setRippleColor(this.z4.getInt(C));
                } else {
                    y3(new Runnable() {
                        public void run() {
                            Bitmap bitmap;
                            if (C.contains("file:///android_asset/")) {
                                try {
                                    bitmap = BitmapFactory.decodeStream(databasesFragment.this.r().getAssets().open(C.replace("file:///android_asset/", "")));
                                } catch (Exception e2) {
                                    FirebaseCrashlytics.d().g(e2);
                                    e2.printStackTrace();
                                    return;
                                }
                            } else {
                                bitmap = BitmapFactory.decodeFile(C);
                            }
                            Palette.Swatch C = Palette.b(bitmap).g().C();
                            if (C != null) {
                                int e3 = C.e();
                                if (!databasesFragment.this.z4.containsKey(C)) {
                                    databasesFragment.this.z4.putInt(C, e3);
                                }
                            }
                        }
                    }, new Runnable() {
                        public void run() {
                            materialRippleLayout.setRippleColor(databasesFragment.this.z4.getInt(C));
                        }
                    });
                }
            }
        } else {
            imageView.setImageDrawable(b0().getDrawable(R.drawable.f715placeholder));
        }
        if (!bundle.containsKey("Inactive")) {
            appCompatButton.setVisibility(8);
            if (bundle.containsKey("ExpDate")) {
                textView2.setVisibility(0);
                textView2.setText(CompressHelper.c1(bundle.getString("Version")));
            } else {
                textView2.setVisibility(8);
            }
            materialRippleLayout.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    databasesFragment.this.y4.z1(bundle);
                }
            });
            return;
        }
        appCompatButton.setVisibility(0);
        textView2.setVisibility(0);
        if (bundle.containsKey("ExpDate")) {
            str = "Expired at " + CompressHelper.c1(bundle.getString("ExpDate"));
        } else {
            str = "Click Buy for activation";
        }
        textView2.setText(str);
        if (bundle.containsKey("Demo")) {
            textView2.setText(textView2.getText() + " - Demo Available");
            textView2.setVisibility(8);
            r42 = new View.OnClickListener() {
                public void onClick(View view) {
                    new AlertDialog.Builder(databasesFragment.this.r(), R.style.f2185alertDialogTheme).l("You are using demo version of this database, in this mode you can see three random chapters and can't search the database").y("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogInterface, int i2) {
                            databasesFragment.this.y4.z1(bundle);
                        }
                    }).I();
                }
            };
        } else {
            r42 = new View.OnClickListener() {
                public void onClick(View view) {
                    Toast.makeText(databasesFragment.this.r(), "You don't own this database, please click Buy for purchase.", 1).show();
                }
            };
        }
        materialRippleLayout.setOnClickListener(r42);
        appCompatButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                databasesFragment.this.K2(bundle);
            }
        });
    }

    public int L3(ArrayList<Bundle> arrayList) {
        int i2 = 0;
        if (arrayList == null) {
            return 0;
        }
        Iterator<Bundle> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            i2 = i2 + it2.next().getParcelableArrayList("items").size() + 1;
        }
        return i2;
    }

    public void M2(File file) {
        if (file.isDirectory()) {
            for (File M2 : file.listFiles()) {
                M2(M2);
            }
        }
        file.delete();
    }

    public void N2(final File file) {
        Observable w1 = Observable.w1(new ObservableOnSubscribe<Long>() {
            public void a(@io.reactivex.rxjava3.annotations.NonNull ObservableEmitter<Long> observableEmitter) throws Throwable {
                databasesFragment.this.M2(file);
                observableEmitter.onComplete();
            }
        });
        final ProgressDialog show = ProgressDialog.show(r(), "Deleting", "Please wait...", true);
        w1.h6(Schedulers.e()).s4(AndroidSchedulers.e()).f6(new Consumer<Long>() {
            /* renamed from: a */
            public void accept(Long l2) throws Throwable {
            }
        }, new Consumer<Throwable>() {
            /* renamed from: a */
            public void accept(Throwable th) throws Throwable {
                show.dismiss();
                databasesFragment.this.y4.k0();
                LocalBroadcastManager.b(databasesFragment.this.r()).d(new Intent("reloadDownloads"));
            }
        }, new Action() {
            public void run() throws Throwable {
                show.dismiss();
                databasesFragment.this.y4.k0();
                LocalBroadcastManager.b(databasesFragment.this.r()).d(new Intent("reloadDownloads"));
            }
        });
    }

    public Bundle O2(int i2, ArrayList<Bundle> arrayList) {
        Iterator<Bundle> it2 = arrayList.iterator();
        int i3 = 0;
        int i5 = 0;
        while (it2.hasNext()) {
            Bundle next = it2.next();
            if (i2 == i3) {
                Bundle bundle = new Bundle();
                bundle.putString("Title", next.getString("title"));
                bundle.putInt("Row", 0);
                bundle.putInt("Section", i5);
                bundle.putInt("Row2", 1);
                bundle.putInt("Section2", i5 - 1);
                return bundle;
            }
            int size = i3 + next.getParcelableArrayList("items").size();
            if (i2 <= size) {
                int size2 = (i2 - (size - next.getParcelableArrayList("items").size())) - 1;
                Bundle bundle2 = new Bundle();
                bundle2.putBundle("Item", (Bundle) next.getParcelableArrayList("items").get(size2));
                bundle2.putInt("Row", size2);
                bundle2.putInt("Section", i5);
                return bundle2;
            }
            i3 = size + 1;
            i5++;
        }
        return null;
    }

    public void P2(final File file, final File file2) {
        Observable w1 = Observable.w1(new ObservableOnSubscribe<Bundle>() {
            public void a(@io.reactivex.rxjava3.annotations.NonNull ObservableEmitter<Bundle> observableEmitter) throws Throwable {
                BufferedSource e2;
                Throwable th;
                Throwable th2;
                ObservableEmitter<Bundle> observableEmitter2 = observableEmitter;
                String[] list = file.list();
                int length = list.length;
                int i2 = 0;
                int i3 = 0;
                while (i3 < length) {
                    String str = list[i3];
                    int i4 = i2 + 1;
                    long unused = databasesFragment.this.i4 = 0;
                    File file = new File(file, str);
                    File file2 = new File(file2, str);
                    if (file.isDirectory()) {
                        File file3 = new File(file, "info.vbe");
                        if (file3.exists()) {
                            BufferedSource e3 = Okio.e(Okio.t(file3));
                            try {
                                Bundle e4 = databasesFragment.this.k4.e(e3.b0(), file3);
                                if (e4 != null) {
                                    str = e4.getString("Title");
                                }
                                e3.close();
                            } catch (IOException e5) {
                                Log.e("Error", "Error reading vbe file", e5);
                            } catch (Throwable th3) {
                                th2.addSuppressed(th3);
                            }
                        } else {
                            File file4 = new File(file2, "info.vbe");
                            if (file4.exists()) {
                                e2 = Okio.e(Okio.t(file4));
                                Bundle e6 = databasesFragment.this.k4.e(e2.b0(), file4);
                                if (e6 != null) {
                                    str = e6.getString("Title");
                                }
                                e2.close();
                            }
                        }
                    }
                    Bundle bundle = new Bundle();
                    bundle.putLong("counter", 0);
                    bundle.putLong("total", databasesFragment.this.A3(file));
                    bundle.putString("title", "Moving " + i4 + " of " + list.length + " : " + str);
                    observableEmitter2.onNext(bundle);
                    try {
                        databasesFragment.this.F3(file, file2, bundle, observableEmitter2);
                    } catch (Exception e7) {
                        Log.e("IOError", e7.toString());
                    }
                    i3++;
                    i2 = i4;
                }
                try {
                    CompressHelper.P0(file);
                } catch (Exception unused2) {
                }
                observableEmitter.onComplete();
                return;
                throw th2;
                throw th;
            }
        });
        final ProgressDialog show = ProgressDialog.show(r(), "Migrating Databases", "Please wait...", true);
        w1.h6(Schedulers.e()).s4(AndroidSchedulers.e()).f6(new Consumer<Bundle>() {
            /* renamed from: a */
            public void accept(Bundle bundle) throws Throwable {
                show.setMessage(bundle.getString("title") + " (" + bundle.getLong("counter") + " of " + bundle.getLong("total") + " files)");
            }
        }, new Consumer<Throwable>() {
            /* renamed from: a */
            public void accept(Throwable th) throws Throwable {
                th.printStackTrace();
                iMDLogger.f("Moving", th.getMessage());
            }
        }, new Action() {
            public void run() throws Throwable {
                show.dismiss();
                LocalBroadcastManager.b(databasesFragment.this.r()).d(new Intent("reload"));
                databasesFragment.this.I3();
            }
        });
    }

    public void Q0(Bundle bundle) {
        super.Q0(bundle);
        LocalBroadcastManager.b(r()).c(this.C4, new IntentFilter("reload"));
    }

    public void Q2() {
        ArrayList<Bundle> arrayList = E4;
        if (arrayList == null || arrayList.size() == 0) {
            K3("No databases is installed. Tap to go to store tab to buy and download databases");
        } else {
            J3();
        }
    }

    public void T0(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.f1422menu_databases, menu);
        final MenuItem findItem = menu.findItem(R.id.f795action_edit);
        final MenuItem findItem2 = menu.findItem(R.id.f794action_done);
        this.n4 = findItem;
        this.o4 = findItem2;
        findItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem menuItem) {
                RecyclerView R2;
                RecyclerView.Adapter s3;
                ArrayList<Bundle> arrayList = databasesFragment.E4;
                if (arrayList == null || arrayList.size() == 0) {
                    return true;
                }
                databasesFragment.this.p4.clearFocus();
                if (databasesFragment.this.g4.getAdapter().getClass() == SearchDatabasesAdapter.class || databasesFragment.this.g4.getAdapter().getClass() == SearchCollectionDatabasesAdapter.class) {
                    databasesFragment.this.p4.k0("", false);
                    databasesFragment.this.p4.clearFocus();
                    if (!databasesFragment.this.j4) {
                        R2 = databasesFragment.this.g4;
                        s3 = databasesFragment.this.h4;
                    } else {
                        R2 = databasesFragment.this.g4;
                        s3 = databasesFragment.this.q4;
                    }
                    R2.setAdapter(s3);
                    databasesFragment.this.B3();
                    iMDLogger.f("HideKeyboard", "4");
                }
                findItem.setVisible(false);
                findItem2.setVisible(true);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(databasesFragment.this.r());
                RecyclerViewDragDropManager unused = databasesFragment.this.r4 = new RecyclerViewDragDropManager();
                databasesFragment.this.r4.R((NinePatchDrawable) databasesFragment.this.b0().getDrawable(R.drawable.Q7));
                RecyclerView.Adapter o = databasesFragment.this.r4.o(new EditDatabasesAdapter());
                databasesFragment.this.g4.setLayoutManager(linearLayoutManager);
                databasesFragment.this.g4.setAdapter(o);
                databasesFragment.this.r4.h(databasesFragment.this.g4);
                return false;
            }
        });
        findItem2.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem menuItem) {
                findItem.setVisible(true);
                findItem2.setVisible(false);
                databasesFragment.this.r4.N();
                if (!databasesFragment.this.j4) {
                    databasesFragment databasesfragment = databasesFragment.this;
                    DatabasesAdapter unused = databasesfragment.h4 = new DatabasesAdapter();
                    databasesFragment.this.g4.setAdapter(databasesFragment.this.h4);
                } else {
                    databasesFragment databasesfragment2 = databasesFragment.this;
                    CollectionAdapter unused2 = databasesfragment2.q4 = new CollectionAdapter();
                    databasesFragment.this.g4.setAdapter(databasesFragment.this.q4);
                    databasesFragment.this.g4.setLayoutManager(databasesFragment.this.u4);
                }
                databasesFragment.this.y4.o2(databasesFragment.E4);
                databasesFragment.this.y4.p2();
                databasesFragment.this.I3();
                return false;
            }
        });
        if (C3()) {
            this.n4.setVisible(false);
            this.o4.setVisible(true);
        } else {
            this.n4.setVisible(true);
            this.o4.setVisible(false);
        }
        menu.findItem(R.id.f802action_navigation).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem menuItem) {
                ((mainActivity) databasesFragment.this.r()).onToolbarNavigationClicked();
                return true;
            }
        });
        SearchView searchView = (SearchView) menu.findItem(R.id.f814action_search).getActionView();
        searchView.setIconified(true);
        searchView.d();
        this.p4 = searchView;
        if (Build.VERSION.SDK_INT >= 26) {
            searchView.setImportantForAutofill(8);
        }
        searchView.setIconifiedByDefault(false);
        searchView.setQueryHint("Search Databases");
        final String str = this.m4;
        this.p4.postDelayed(new Runnable() {
            public void run() {
                boolean unused = databasesFragment.this.l4 = true;
                databasesFragment.this.p4.k0(str, false);
                if (databasesFragment.this.e4 != null && databasesFragment.this.e4.length() > 0) {
                    ArrayList<Bundle> arrayList = databasesFragment.F4;
                    if (arrayList == null || arrayList.size() == 0) {
                        databasesFragment.this.p4.k0(databasesFragment.this.e4, true);
                    } else {
                        databasesFragment.this.p4.k0(databasesFragment.this.e4, false);
                        databasesFragment.this.g4.getAdapter().G();
                        databasesFragment.this.J3();
                    }
                    databasesFragment.this.B3();
                    iMDLogger.f("HideKeyboard", IcyHeaders.a3);
                }
            }
        }, 10);
        this.l4 = false;
        ((TextView) searchView.findViewById(R.id.search_src_text)).setText("");
        ((ImageView) searchView.findViewById(R.id.search_close_btn)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                RecyclerView R2;
                RecyclerView.Adapter s3;
                databasesFragment.this.p4.k0("", false);
                databasesFragment.this.p4.clearFocus();
                databasesFragment.this.Q2();
                if (!databasesFragment.this.j4) {
                    R2 = databasesFragment.this.g4;
                    s3 = databasesFragment.this.h4;
                } else {
                    R2 = databasesFragment.this.g4;
                    s3 = databasesFragment.this.q4;
                }
                R2.setAdapter(s3);
                databasesFragment.this.B3();
                iMDLogger.f("HideKeyboard", ExifInterface.Y4);
            }
        });
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            public boolean a(String str) {
                RecyclerView R2;
                RecyclerView.Adapter s3;
                if (!databasesFragment.this.l4) {
                    return true;
                }
                String unused = databasesFragment.this.m4 = str;
                String unused2 = databasesFragment.this.e4 = str;
                if (str.length() == 0) {
                    databasesFragment.this.Q2();
                    if (!databasesFragment.this.j4) {
                        R2 = databasesFragment.this.g4;
                        s3 = databasesFragment.this.h4;
                    } else {
                        R2 = databasesFragment.this.g4;
                        s3 = databasesFragment.this.q4;
                    }
                    R2.setAdapter(s3);
                } else {
                    databasesFragment.this.H3(str);
                }
                return true;
            }

            public boolean b(String str) {
                return false;
            }
        });
        try {
            r().setTitle("");
        } catch (Exception e2) {
            FirebaseCrashlytics.d().g(e2);
        }
    }

    public View U0(LayoutInflater layoutInflater, ViewGroup viewGroup, final Bundle bundle) {
        View view = this.f4;
        if (view != null) {
            return view;
        }
        this.x4 = Typeface.createFromAsset(r().getAssets(), "fonts/HelveticaNeue-Light.otf");
        this.w4 = V1().getSharedPreferences("default_preferences", 0).getBoolean("ripple", true);
        this.y4 = new CompressHelper(r());
        this.z4 = new Bundle();
        this.j4 = V1().getSharedPreferences("default_preferences", 0).getBoolean("GridView", true);
        this.k4 = new VBHelper(r());
        View inflate = layoutInflater.inflate(R.layout.f1221fragment_databases, viewGroup, false);
        this.f4 = inflate;
        B3();
        iMDLogger.f("HideKeyboard", ExifInterface.Z4);
        this.m4 = "";
        this.y4.R0(new Runnable() {
            public void run() {
                databasesFragment.E4 = databasesFragment.this.y4.p2();
            }
        }, new Runnable() {
            public void run() {
                FloatingActionButton u3;
                Resources resources;
                int i2;
                databasesFragment.this.I3();
                databasesFragment.this.o2(true);
                Bundle bundle = bundle;
                if (bundle != null && bundle.containsKey("Query")) {
                    String unused = databasesFragment.this.e4 = bundle.getString("Query");
                }
                databasesFragment databasesfragment = databasesFragment.this;
                RecyclerView unused2 = databasesfragment.g4 = (RecyclerView) databasesfragment.f4.findViewById(R.id.f1054recycler_view);
                databasesFragment.this.g4.setVisibility(0);
                ((TextView) databasesFragment.this.f4.findViewById(R.id.f1002loading_text)).setVisibility(8);
                databasesFragment databasesfragment2 = databasesFragment.this;
                CustomItemDecoration unused3 = databasesfragment2.t4 = new CustomItemDecoration(databasesfragment2.r());
                databasesFragment databasesfragment3 = databasesFragment.this;
                GridLayoutManager unused4 = databasesfragment3.u4 = new GridLayoutManager(databasesfragment3.r(), 2);
                databasesFragment.this.u4.R3(new GridLayoutManager.SpanSizeLookup() {
                    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0016, code lost:
                        r4 = r3.f30109e.X.O2(r4, net.imedicaldoctor.imd.Fragments.databasesFragment.E4);
                     */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public int f(int r4) {
                        /*
                            r3 = this;
                            net.imedicaldoctor.imd.Fragments.databasesFragment$4 r0 = net.imedicaldoctor.imd.Fragments.databasesFragment.AnonymousClass4.this
                            net.imedicaldoctor.imd.Fragments.databasesFragment r0 = net.imedicaldoctor.imd.Fragments.databasesFragment.this
                            androidx.recyclerview.widget.RecyclerView r0 = r0.g4
                            androidx.recyclerview.widget.RecyclerView$Adapter r0 = r0.getAdapter()
                            java.lang.Class r0 = r0.getClass()
                            java.lang.Class<net.imedicaldoctor.imd.Fragments.databasesFragment$SearchCollectionDatabasesAdapter> r1 = net.imedicaldoctor.imd.Fragments.databasesFragment.SearchCollectionDatabasesAdapter.class
                            r2 = 2
                            if (r0 != r1) goto L_0x0016
                            return r2
                        L_0x0016:
                            net.imedicaldoctor.imd.Fragments.databasesFragment$4 r0 = net.imedicaldoctor.imd.Fragments.databasesFragment.AnonymousClass4.this
                            net.imedicaldoctor.imd.Fragments.databasesFragment r0 = net.imedicaldoctor.imd.Fragments.databasesFragment.this
                            java.util.ArrayList<android.os.Bundle> r1 = net.imedicaldoctor.imd.Fragments.databasesFragment.E4
                            android.os.Bundle r4 = r0.O2(r4, r1)
                            if (r4 != 0) goto L_0x0023
                            return r2
                        L_0x0023:
                            java.lang.String r0 = "Title"
                            boolean r4 = r4.containsKey(r0)
                            if (r4 == 0) goto L_0x002c
                            return r2
                        L_0x002c:
                            r4 = 1
                            return r4
                        */
                        throw new UnsupportedOperationException("Method not decompiled: net.imedicaldoctor.imd.Fragments.databasesFragment.AnonymousClass4.AnonymousClass1.f(int):int");
                    }
                });
                if (!databasesFragment.this.j4) {
                    databasesFragment.this.g4.setItemDecoration(databasesFragment.this.t4);
                    databasesFragment.this.g4.setLayoutManager(new LinearLayoutManager(databasesFragment.this.r(), 1, false));
                    databasesFragment.this.g4.setItemAnimator(new DefaultItemAnimator());
                    databasesFragment databasesfragment4 = databasesFragment.this;
                    DatabasesAdapter unused5 = databasesfragment4.h4 = new DatabasesAdapter();
                    databasesFragment.this.g4.setAdapter(databasesFragment.this.h4);
                } else {
                    databasesFragment.this.g4.A1(databasesFragment.this.t4);
                    databasesFragment databasesfragment5 = databasesFragment.this;
                    CollectionAdapter unused6 = databasesfragment5.q4 = new CollectionAdapter();
                    databasesFragment.this.g4.setAdapter(databasesFragment.this.q4);
                    databasesFragment.this.g4.setLayoutManager(databasesFragment.this.u4);
                }
                databasesFragment.this.Q2();
                databasesFragment databasesfragment6 = databasesFragment.this;
                FloatingActionButton unused7 = databasesfragment6.v4 = (FloatingActionButton) databasesfragment6.f4.findViewById(R.id.f934fab);
                if (databasesFragment.this.j4) {
                    u3 = databasesFragment.this.v4;
                    resources = databasesFragment.this.r().getResources();
                    i2 = R.drawable.f682listview_icon;
                } else {
                    u3 = databasesFragment.this.v4;
                    resources = databasesFragment.this.r().getResources();
                    i2 = R.drawable.f640gridview_icon;
                }
                u3.setImageDrawable(resources.getDrawable(i2));
                databasesFragment.this.v4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        SharedPreferences.Editor putBoolean;
                        databasesFragment.this.n4.setVisible(true);
                        databasesFragment.this.o4.setVisible(false);
                        if (databasesFragment.this.j4) {
                            databasesFragment.this.g4.setLayoutManager(new LinearLayoutManager(databasesFragment.this.r()));
                            databasesFragment.this.g4.setItemDecoration(databasesFragment.this.t4);
                            boolean unused = databasesFragment.this.j4 = false;
                            databasesFragment databasesfragment = databasesFragment.this;
                            DatabasesAdapter unused2 = databasesfragment.h4 = new DatabasesAdapter();
                            databasesFragment.this.g4.setAdapter(databasesFragment.this.h4);
                            databasesFragment.this.v4.setImageDrawable(databasesFragment.this.r().getResources().getDrawable(R.drawable.f640gridview_icon));
                            putBoolean = databasesFragment.this.V1().getSharedPreferences("default_preferences", 0).edit().putBoolean("GridView", false);
                        } else {
                            databasesFragment.this.g4.setLayoutManager(databasesFragment.this.u4);
                            databasesFragment.this.g4.A1(databasesFragment.this.t4);
                            boolean unused3 = databasesFragment.this.j4 = true;
                            databasesFragment databasesfragment2 = databasesFragment.this;
                            CollectionAdapter unused4 = databasesfragment2.q4 = new CollectionAdapter();
                            databasesFragment.this.g4.setAdapter(databasesFragment.this.q4);
                            databasesFragment.this.v4.setImageDrawable(databasesFragment.this.r().getResources().getDrawable(R.drawable.f682listview_icon));
                            putBoolean = databasesFragment.this.V1().getSharedPreferences("default_preferences", 0).edit().putBoolean("GridView", true);
                        }
                        putBoolean.commit();
                        databasesFragment.this.Q2();
                    }
                });
                if (databasesFragment.this.V1().getSharedPreferences("default_preferences", 0).getBoolean("swipedelete", true)) {
                    databasesFragment.this.z3();
                }
                databasesFragment.this.w3();
            }
        });
        return inflate;
    }

    public void V0() {
        super.V0();
        LocalBroadcastManager.b(r()).f(this.C4);
    }

    public void m1(Bundle bundle) {
        super.m1(bundle);
    }

    public void y3(final Runnable runnable, final Runnable runnable2) {
        Observable.w1(new ObservableOnSubscribe<String>() {
            public void a(@io.reactivex.rxjava3.annotations.NonNull ObservableEmitter<String> observableEmitter) throws Throwable {
                try {
                    runnable.run();
                    observableEmitter.onNext("asdfadf");
                } catch (Exception unused) {
                }
            }
        }).h6(Schedulers.e()).s4(AndroidSchedulers.e()).e6(new Consumer<String>() {
            /* renamed from: a */
            public void accept(String str) throws Throwable {
                try {
                    runnable2.run();
                } catch (Exception e2) {
                    FirebaseCrashlytics.d().g(e2);
                }
            }
        }, new Consumer<Throwable>() {
            /* renamed from: a */
            public void accept(Throwable th) throws Throwable {
                try {
                    iMDLogger.f("Error occured", th.getMessage());
                } catch (Exception unused) {
                }
            }
        });
    }
}
