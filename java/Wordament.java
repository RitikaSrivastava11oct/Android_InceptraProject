package app.com.example.android.firebase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Wordament extends AppCompatActivity {
    private DatabaseReference mDatabsewrite;
    private DatabaseReference mDatabseread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wordament);
        Intent n=getIntent();
        final String str=n.getStringExtra("value2");

        Button but_apply=(Button)findViewById(R.id.but_apply);
        but_apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDatabseread = FirebaseDatabase.getInstance().getReference().child("Users").child(str).child("Name");
                mDatabseread.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String naam=dataSnapshot.getValue().toString();
                        mDatabsewrite = FirebaseDatabase.getInstance().getReference();
                        mDatabsewrite.child("Events").child("Litereary").child("RAMPAGE").child(str).child("Name").setValue(naam);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });

                mDatabseread = FirebaseDatabase.getInstance().getReference().child("Users").child(str).child("Contact");
                mDatabseread.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String naam=dataSnapshot.getValue().toString();
                        mDatabsewrite = FirebaseDatabase.getInstance().getReference();
                        mDatabsewrite.child("Events").child("Litereary").child("RAMPAGE").child(str).child("Contact").setValue(naam);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });

                mDatabseread = FirebaseDatabase.getInstance().getReference().child("Users").child(str).child("Branch");
                mDatabseread.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String naam=dataSnapshot.getValue().toString();
                        mDatabsewrite = FirebaseDatabase.getInstance().getReference();
                        mDatabsewrite.child("Events").child("Litereary").child("RAMPAGE").child(str).child("Branch").setValue(naam);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });

                mDatabseread = FirebaseDatabase.getInstance().getReference().child("Users").child(str).child("Year");
                mDatabseread.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String naam=dataSnapshot.getValue().toString();
                        mDatabsewrite = FirebaseDatabase.getInstance().getReference();
                        mDatabsewrite.child("Events").child("Litereary").child("RAMPAGE").child(str).child("Year").setValue(naam);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });



                Toast toast=Toast.makeText(getApplicationContext(),"SUCCESSFULLY APPLIED FOR THE EVENT..SUBMIT ENTRY FEE TO THE RESPECTIVE VOLUNTEER ",Toast.LENGTH_SHORT);
                toast.show();



            }
        });
    }
}


