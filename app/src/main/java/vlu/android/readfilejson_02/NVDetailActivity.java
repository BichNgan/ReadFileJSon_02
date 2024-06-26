package vlu.android.readfilejson_02;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class NVDetailActivity extends AppCompatActivity {

    ImageView imgNV;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_nvdetail);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //-------------------------------
        addControl();
        //--------------------------------
        Intent intent = getIntent();
        NV nv = (NV)intent.getSerializableExtra("nhanvien");


        int idAnh = getResources().getIdentifier
                (nv.getIdAnh(),"drawable",getPackageName());
        imgNV.setImageResource(idAnh);

    }
    void addControl()
    {
        imgNV = (ImageView) findViewById(R.id.imgNV);
    }
}