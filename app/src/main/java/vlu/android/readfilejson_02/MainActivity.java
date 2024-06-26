package vlu.android.readfilejson_02;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvDSNV;
    ArrayList<String> dataLV =new ArrayList<>();
    ArrayAdapter<String> adapter;
    ArrayList<NV> dsnv = new ArrayList<>();

    String filename="dsnv02.json";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //------------------------------
            lvDSNV=(ListView) findViewById(R.id.lvDSNV);
        //---------------------------
        // Doc du lieu tu json va hien thi tren LV


    }
    //Doc du lieu tu JsonArrr
    ArrayList<NV> readJsonDSNV(String filename) throws IOException, JSONException {
        ArrayList<NV> dsnv = new ArrayList<>();
        //-------------
        InputStream inputStream = getResources().getAssets().open(filename);
        int size = inputStream.available();
        byte[]data = new byte[size];
        inputStream.read(data);
        inputStream.close();
        String kq = new String(data,"UTF-8");
        //------------------------
        //Tach du lieu tu json
        JSONObject jsonObjectDSNV = new JSONObject(kq);
        JSONArray jsonArrayDSNV = jsonObjectDSNV.getJSONArray("dsnv");
        for(int i=0;i<jsonArrayDSNV.length();i++)
        {
            NV nv=new NV();
            JSONObject object = jsonArrayDSNV.getJSONObject(i);
            String msnv = object.getString("msnv");
            String idAnh = object.getString("anh");
            String hten = object.getString("hten");
            String ngaysinh = object.getString("ngaysinh");
            String cvu = object.getString("cvu");
            dsnv.add(nv);
        }
        //--------------------
        return dsnv;
    }

    void setDataLV (ArrayList<NV> dsnv ) {
        for (int i = 0; i < dsnv.size(); i++)
        {
            String st = "Msnv:  " + dsnv.get(i).getMsnv() + "--" + "Ho ten: " + dsnv.get(i).getHten();
            dataLV.add(st);
        }



}