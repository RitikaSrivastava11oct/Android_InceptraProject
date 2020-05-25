package app.com.example.android.firebase;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private Button signupbtn;
    private DatabaseReference mDatabase;
    private Button signinbtn;
    EditText userid;
    private EditText pass;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userid=(EditText)findViewById(R.id.user_id);
        pass=(EditText)findViewById(R.id.pass_field);



        signinbtn=(Button)findViewById(R.id.signin_button);
        signinbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               final String rollnum=userid.getText().toString().trim();

                mDatabase=FirebaseDatabase.getInstance().getReference().child("Users").child(rollnum).child("Password");
                mDatabase.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String result=dataSnapshot.getValue().toString();
                        String password=pass.getText().toString().trim();
                        if(Objects.equals(password, result)&& rollnum!=""){
                            Intent intent = new Intent(MainActivity.this,
                                    hamburger.class);
                            intent.putExtra("edit ki value",rollnum);
                            startActivity(intent);}
                        else{
                        Context context = getApplicationContext();
                        int duration = Toast.LENGTH_SHORT;
                            CharSequence text = "Error";
                        Toast toast = Toast.makeText(context, text, duration);

                        toast.show();

                    }}

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });

        signupbtn=(Button)findViewById(R.id.signup_button);
        signinbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent n=new Intent(MainActivity.this,hamburger.class);
                startActivity(n);
            }
        });
        signupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this,
                        SignIn.class);
                startActivity(myIntent);
            }
        });

    }
}
