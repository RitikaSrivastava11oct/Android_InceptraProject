package app.com.example.android.firebase;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;

//import app.com.example.android.firebase.Adapter.AdapterImage;

public class Fragment_event extends Fragment {
    ArrayList<Bitmap> arrayList;
    private Bitmap image1;
    private Bitmap image2;
    private Bitmap image3;
    private Bitmap image4;
    private Bitmap image5;
    private Bitmap image6;
    private Bitmap image7;
    private Bitmap image8;
    private Bitmap image9;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View v = inflater.inflate(R.layout.activity_fragment_event, container, false);
        Button but_literary = (Button) v.findViewById(R.id.but_literary);
        Button but_technical = (Button) v.findViewById(R.id.but_technical);
        Button but_cultural = (Button) v.findViewById(R.id.but_cultural);
        Button but_informal = (Button) v.findViewById(R.id.but_informal);

        but_literary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent n = new Intent(getActivity(), Literaryevent.class);
                startActivity(n);
            }
        });

        but_technical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent n=new Intent(getActivity(),TechnicalEvent.class);
                startActivity(n);
            }
        });

        but_cultural.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent n=new Intent(getActivity(),CulturalEvent.class);
                startActivity(n);
            }
        });

        but_informal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent n=new Intent(getActivity(),InformalEvent.class);
                startActivity(n);
            }
        });

        if(container!=null)
        {
            container.removeAllViews();
        }
        return v;



    }

}
