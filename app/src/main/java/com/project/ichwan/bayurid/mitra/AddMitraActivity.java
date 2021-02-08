package com.project.ichwan.bayurid.mitra;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.project.ichwan.bayurid.R;
import com.project.ichwan.bayurid.cnbfragment.MitraFragment;

import java.util.ArrayList;

public class AddMitraActivity extends AppCompatActivity implements View.OnClickListener {

    LinearLayout layoutList;
    EditText nama, nohp, alamat, produk, stok;
    TextView txstok;
    ArrayList<MitraItem> mitraItems = new ArrayList<>();
    public static final String EXTRA_MITRA = "data_mitra";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_mitra);

        layoutList = findViewById(R.id.layout_list);
        nama = findViewById(R.id.namamitra);
        alamat = findViewById(R.id.alamatmitra);
        nohp = findViewById(R.id.nohpmitra);
        findViewById(R.id.btn_add_item).setOnClickListener(this);
        findViewById(R.id.savemitra).setOnClickListener(this);
    }

    private void addView() {
        final View productView = getLayoutInflater().inflate(R.layout.row_add_mitra,null,false);
        produk = productView.findViewById(R.id.item_produk);
        stok = productView.findViewById(R.id.item_stok);
        txstok = productView.findViewById(R.id.st);
        productView.findViewById(R.id.removeproduk).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                removeView(productView);
            }
        });

        layoutList.addView(productView);
    }

    private void removeView(View productView) {
        layoutList.removeView(productView);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_add_item:
                addView();
                break;
            case R.id.savemitra:
                if(checkValidateText()){
                    String names = nama.getText().toString();
                    String address = alamat.getText().toString();
                    String phones = nohp.getText().toString();
                    String product = produk.getText().toString();
                    String stocks = stok.getText().toString();
                    MitraItem item = new MitraItem(names,address,phones,product,stocks);

                    MitraFragment fragment = new MitraFragment();
                    FragmentManager manager = getSupportFragmentManager();
                    Bundle bundle = new Bundle();
                    bundle.putParcelable(EXTRA_MITRA,item);
                    fragment.setArguments(bundle);

                    manager.beginTransaction().add(R.id.activitymitraadd,fragment).commit();
                }
        }
    }

    private boolean checkValidateText() {
        mitraItems.clear();
        boolean res = true;

        MitraItem item = new MitraItem();

        for(int i = 0;i < layoutList.getChildCount();i++){
            View productview = layoutList.getChildAt(i);
            EditText produk = productview.findViewById(R.id.item_produk);
            EditText stoks = productview.findViewById(R.id.item_stok);

            if(!produk.getText().toString().equals("")){
                item.setItemproduk(produk.getText().toString());
            } else {
                res = false;
                break;
            }

            if (!stoks.getText().toString().equals("")){
                item.setStok(stoks.getText().toString());
            } else {
                res = false;
                break;
            }

            mitraItems.add(item);
        }
        if(!nama.getText().toString().equals("")){
            item.setNamamitra(nama.getText().toString());
        }
        if(!alamat.getText().toString().equals("")){
            item.setAlamatmitra(alamat.getText().toString());
        }
        if(!nohp.getText().toString().equals("")){
            item.setNohp(nohp.getText().toString());
        }
        if (mitraItems.size() == 0){
            res = false;
            Toast.makeText(this, "Berhasil!", Toast.LENGTH_SHORT).show();
        }
        if(!res){
            Toast.makeText(this, "Masukkan semua!", Toast.LENGTH_SHORT).show();
        }

        return res;
    }
}