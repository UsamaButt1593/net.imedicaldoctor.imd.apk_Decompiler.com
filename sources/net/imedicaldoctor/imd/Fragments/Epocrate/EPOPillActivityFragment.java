package net.imedicaldoctor.imd.Fragments.Epocrate;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.util.ArrayList;
import net.imedicaldoctor.imd.Data.CompressHelper;
import net.imedicaldoctor.imd.Fragments.SearchHelperFragment;
import net.imedicaldoctor.imd.R;
import net.imedicaldoctor.imd.Utils.MaterialRippleLayout;
import net.imedicaldoctor.imd.ViewHolders.SpellSearchAdapter;
import org.apache.commons.lang3.StringUtils;

public class EPOPillActivityFragment extends SearchHelperFragment {
    public SpellSearchAdapter A4;
    public String B4;
    public Button C4;
    public String D4;
    public Bundle E4;
    public Bundle F4;
    public Bundle G4;
    public String H4;
    public String I4;
    public String J4;
    public ArrayList<Bundle> K4;

    public class InputTextViewHolder extends RecyclerView.ViewHolder {
        public TextView I;
        public EditText J;

        public InputTextViewHolder(View view) {
            super(view);
            this.I = (TextView) view.findViewById(R.id.f1132text_view);
            this.J = (EditText) view.findViewById(R.id.f1124text_edit);
        }
    }

    public class PillIDAdapter extends RecyclerView.Adapter {
        public PillIDAdapter() {
        }

        public int C(int i2) {
            return i2 < 2 ? 0 : 1;
        }

        public void R(RecyclerView.ViewHolder viewHolder, int i2) {
            MaterialRippleLayout materialRippleLayout;
            View.OnClickListener r4;
            if (viewHolder.F() == 0) {
                InputTextViewHolder inputTextViewHolder = (InputTextViewHolder) viewHolder;
                inputTextViewHolder.J.setHint("type");
                inputTextViewHolder.J.addTextChangedListener(new TextWatcher() {
                    public void afterTextChanged(Editable editable) {
                        EPOPillActivityFragment.this.j3();
                    }

                    public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                    }

                    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                    }
                });
                inputTextViewHolder.I.setText(i2 == 0 ? "Imprint - Side 1" : "Imprint - Side 2");
                if (i2 == 0) {
                    inputTextViewHolder.J.addTextChangedListener(new TextWatcher() {
                        public void afterTextChanged(Editable editable) {
                            EPOPillActivityFragment.this.H4 = editable.toString();
                        }

                        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                        }

                        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                        }
                    });
                }
                if (i2 == 1) {
                    inputTextViewHolder.J.addTextChangedListener(new TextWatcher() {
                        public void afterTextChanged(Editable editable) {
                            EPOPillActivityFragment.this.I4 = editable.toString();
                        }

                        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                        }

                        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                        }
                    });
                    return;
                }
                return;
            }
            SettingViewHolder settingViewHolder = (SettingViewHolder) viewHolder;
            if (i2 == 2) {
                settingViewHolder.I.setText("Shape");
                Bundle bundle = EPOPillActivityFragment.this.E4;
                if (bundle == null) {
                    settingViewHolder.K.setText("Any Shape");
                } else {
                    settingViewHolder.K.setText(bundle.getString("STRING_TEXT"));
                }
                materialRippleLayout = settingViewHolder.J;
                r4 = new View.OnClickListener() {
                    public void onClick(View view) {
                        EPOPillActivityFragment.this.m3("shape");
                    }
                };
            } else if (i2 == 3) {
                settingViewHolder.I.setText("Color");
                Bundle bundle2 = EPOPillActivityFragment.this.F4;
                if (bundle2 == null) {
                    settingViewHolder.K.setText("Any Color");
                } else {
                    settingViewHolder.K.setText(bundle2.getString("STRING_TEXT"));
                }
                materialRippleLayout = settingViewHolder.J;
                r4 = new View.OnClickListener() {
                    public void onClick(View view) {
                        EPOPillActivityFragment.this.m3("color");
                    }
                };
            } else if (i2 == 4) {
                settingViewHolder.I.setText("Score");
                Bundle bundle3 = EPOPillActivityFragment.this.G4;
                if (bundle3 == null) {
                    settingViewHolder.K.setText("Any Score");
                } else {
                    settingViewHolder.K.setText(bundle3.getString("STRING_TEXT"));
                }
                materialRippleLayout = settingViewHolder.J;
                r4 = new View.OnClickListener() {
                    public void onClick(View view) {
                        EPOPillActivityFragment.this.m3("score");
                    }
                };
            } else {
                return;
            }
            materialRippleLayout.setOnClickListener(r4);
        }

        public RecyclerView.ViewHolder T(ViewGroup viewGroup, int i2) {
            if (i2 == 0) {
                return new InputTextViewHolder(LayoutInflater.from(EPOPillActivityFragment.this.r()).inflate(R.layout.f1329list_view_item_input_text, viewGroup, false));
            } else if (i2 != 1) {
                return null;
            } else {
                return new SettingViewHolder(LayoutInflater.from(EPOPillActivityFragment.this.r()).inflate(R.layout.f1379list_view_item_text_setting, viewGroup, false));
            }
        }

        public int b() {
            return 5;
        }
    }

    public class SettingViewHolder extends RecyclerView.ViewHolder {
        public TextView I;
        public MaterialRippleLayout J;
        public TextView K;

        public SettingViewHolder(View view) {
            super(view);
            this.I = (TextView) view.findViewById(R.id.f1132text_view);
            this.K = (TextView) view.findViewById(R.id.f1095subtext_view);
            this.J = (MaterialRippleLayout) view.findViewById(R.id.f1061ripple_layout);
        }
    }

    public View U0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.q4 = layoutInflater.inflate(R.layout.f1261fragment_pill_identifier, viewGroup, false);
        W2(bundle);
        S2();
        this.H4 = "";
        this.I4 = "";
        this.D4 = "RX.sqlite";
        SearchView searchView = (SearchView) this.q4.findViewById(R.id.f1069search_view);
        this.s4 = searchView;
        if (Build.VERSION.SDK_INT >= 26) {
            searchView.setImportantForAutofill(8);
        }
        this.s4.setVisibility(8);
        this.w4 = (RecyclerView) this.q4.findViewById(R.id.f1054recycler_view);
        this.r4.setTitle((CharSequence) "Pill Identifier");
        ((AppBarLayout) this.q4.findViewById(R.id.f825appbar)).D(true, false);
        ((RelativeLayout) this.q4.findViewById(R.id.f830background_layout)).setVisibility(0);
        Button button = (Button) this.q4.findViewById(R.id.f1060result_button);
        this.C4 = button;
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("Query", EPOPillActivityFragment.this.J4);
                EPOPillActivityFragment ePOPillActivityFragment = EPOPillActivityFragment.this;
                ePOPillActivityFragment.k4.B1(ePOPillActivityFragment.h4, "pillid-adf", (String[]) null, (String) null, bundle);
            }
        });
        PillIDAdapter pillIDAdapter = new PillIDAdapter();
        this.l4 = pillIDAdapter;
        this.w4.setAdapter(pillIDAdapter);
        N2();
        o2(false);
        return this.q4;
    }

    public void X2() {
        this.A4.i0(this.o4, this.p4);
        this.w4.setAdapter(this.A4);
    }

    public void c3() {
        this.t4.setImageDrawable(b0().getDrawable(R.drawable.f714pill_id_icon));
    }

    public String h3() {
        return "";
    }

    public void i3() {
        ArrayList<Bundle> X;
        ArrayList arrayList = new ArrayList();
        String str = this.H4;
        String str2 = this.I4;
        if (str.length() > 0) {
            String k3 = k3(str);
            if (k3 == null) {
                X = new ArrayList<>();
                this.K4 = X;
            }
            arrayList.add("(imprint1_string_id in (" + k3 + ") OR imprint2_string_id in (" + k3 + "))");
        }
        if (str2.length() > 0) {
            String k32 = k3(str2);
            if (k32 == null) {
                X = new ArrayList<>();
                this.K4 = X;
            }
            arrayList.add("(imprint2_string_id in (" + k32 + ") OR imprint1_string_id in (" + k32 + "))");
        }
        Bundle bundle = this.E4;
        if (bundle != null) {
            String string = bundle.getString("ID");
            arrayList.add("shape_string_id=" + string);
        }
        Bundle bundle2 = this.G4;
        if (bundle2 != null) {
            String string2 = bundle2.getString("ID");
            arrayList.add("score_string_id=" + string2);
        }
        Bundle bundle3 = this.F4;
        if (bundle3 != null) {
            String string3 = bundle3.getString("ID");
            arrayList.add("color_string_id=" + string3);
        }
        String join = StringUtils.join((Iterable<?>) arrayList, " AND ");
        this.J4 = join;
        X = this.k4.X(this.h4, "Select id from pill_pictures where " + join, this.D4, true);
        this.K4 = X;
    }

    public void j3() {
        Observable.w1(new ObservableOnSubscribe<String>() {
            public void a(@NonNull ObservableEmitter<String> observableEmitter) throws Throwable {
                EPOPillActivityFragment.this.i3();
                observableEmitter.onNext("asdf");
            }
        }).h6(Schedulers.e()).s4(AndroidSchedulers.e()).f6(new Consumer<String>() {
            /* renamed from: a */
            public void accept(String str) throws Throwable {
                if (EPOPillActivityFragment.this.K4.size() == 0) {
                    EPOPillActivityFragment.this.C4.setEnabled(false);
                    EPOPillActivityFragment.this.C4.setBackgroundColor(Color.rgb(100, 100, 100));
                    EPOPillActivityFragment.this.C4.setText("Nothing Found");
                    return;
                }
                Button button = EPOPillActivityFragment.this.C4;
                button.setText(EPOPillActivityFragment.this.K4.size() + " Drugs Found");
                EPOPillActivityFragment.this.C4.setEnabled(true);
                EPOPillActivityFragment.this.C4.setBackgroundColor(Color.rgb(64, 140, 83));
            }
        }, new Consumer<Throwable>() {
            /* renamed from: a */
            public void accept(Throwable th) throws Throwable {
            }
        }, new Action() {
            public void run() throws Throwable {
            }
        });
    }

    public String k3(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        CompressHelper compressHelper = this.k4;
        Bundle bundle = this.h4;
        Bundle s1 = compressHelper.s1(compressHelper.W(bundle, "select  group_concat(id) as ids from imprint_strings where string_text like '%" + str + "%'", this.D4));
        if (s1 == null) {
            return null;
        }
        String string = s1.getString("ids");
        if (string.length() == 0) {
            return null;
        }
        return string;
    }

    public void l3(String str, Bundle bundle) {
        if (str.equals("shape")) {
            this.E4 = bundle;
        }
        if (str.equals("color")) {
            this.F4 = bundle;
        }
        if (str.equals("score")) {
            this.G4 = bundle;
        }
        this.w4.setAdapter(this.l4);
        j3();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x002e, code lost:
        r1 = r6.E4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m3(java.lang.String r7) {
        /*
            r6 = this;
            r6.V2()
            net.imedicaldoctor.imd.Data.CompressHelper r0 = r6.k4
            android.os.Bundle r1 = r6.h4
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "select * from "
            r2.append(r3)
            r2.append(r7)
            java.lang.String r3 = "_strings"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = r6.D4
            r4 = 1
            java.util.ArrayList r0 = r0.X(r1, r2, r3, r4)
            java.lang.String r1 = "shape"
            boolean r1 = r7.equals(r1)
            java.lang.String r2 = "ID"
            if (r1 == 0) goto L_0x0037
            android.os.Bundle r1 = r6.E4
            if (r1 == 0) goto L_0x0037
            java.lang.String r1 = r1.getString(r2)
            goto L_0x0039
        L_0x0037:
            java.lang.String r1 = ""
        L_0x0039:
            java.lang.String r3 = "score"
            boolean r3 = r7.equals(r3)
            if (r3 == 0) goto L_0x0049
            android.os.Bundle r3 = r6.G4
            if (r3 == 0) goto L_0x0049
            java.lang.String r1 = r3.getString(r2)
        L_0x0049:
            java.lang.String r3 = "color"
            boolean r3 = r7.equals(r3)
            if (r3 == 0) goto L_0x0059
            android.os.Bundle r3 = r6.F4
            if (r3 == 0) goto L_0x0059
            java.lang.String r1 = r3.getString(r2)
        L_0x0059:
            int r2 = r1.length()
            if (r2 != 0) goto L_0x0061
            java.lang.String r1 = "-1"
        L_0x0061:
            net.imedicaldoctor.imd.Fragments.Epocrate.EPOPillSelectDialog r2 = new net.imedicaldoctor.imd.Fragments.Epocrate.EPOPillSelectDialog
            r2.<init>()
            android.os.Bundle r3 = new android.os.Bundle
            r3.<init>()
            java.lang.String r5 = "Items"
            r3.putParcelableArrayList(r5, r0)
            java.lang.String r0 = "Category"
            r3.putString(r0, r7)
            java.lang.String r7 = "Selected"
            r3.putString(r7, r1)
            r2.i2(r3)
            r2.Z2(r4)
            r7 = 0
            r2.A2(r6, r7)
            androidx.fragment.app.FragmentManager r7 = r6.M()
            java.lang.String r0 = "EPOPillSelectDialog"
            r2.e3(r7, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.imedicaldoctor.imd.Fragments.Epocrate.EPOPillActivityFragment.m3(java.lang.String):void");
    }
}
