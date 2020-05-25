package app.com.example.android.firebase;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Objects;

public class SignIn extends AppCompatActivity {

    private EditText name;
    private DatabaseReference mDatabase;
    private EditText roll;
    private EditText contact;
    private EditText password;
    private EditText cpassword;
    Spinner branch;
    Spinner year;
    String rno;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        branch=(Spinner)findViewById(R.id.spinner_branch);
        year=(Spinner)findViewById(R.id.spinner_year);

        mDatabase = FirebaseDatabase.getInstance().getReference();
        Button sign = (Button) findViewById(R.id.input_button);
        name = (EditText) findViewById(R.id.input_name);
        roll=(EditText)findViewById(R.id.rollno) ;
        contact=(EditText) findViewById(R.id.input_contact);
        password=(EditText)findViewById(R.id.input_password);
        cpassword=(EditText)findViewById(R.id.input_cpassword);
        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fullname=name.getText().toString().trim();
                 rno=roll.getText().toString().trim();
                String cont=contact.getText().toString().trim();
                String pass=password.getText().toString().trim();
                String cpass=cpassword.getText().toString().trim();
                if(Objects.equals(pass, cpass)){
//                    HashMap<String, String> datamap=new HashMap<String, String>();
//                    datamap.put("Name",fullname);
//                    datamap.put("Contact",cont);
//                    datamap.put("Password",pass);
                    mDatabase.child("Users").child(rno).child("Name").setValue(fullname);
                    mDatabase.child("Users").child(rno).child("Contact").setValue(cont);
                    mDatabase.child("Users").child(rno).child("Password").setValue(pass);
                    Context context = getApplicationContext();
                    CharSequence text1 = "Sign Up Successfull..now Login";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text1, duration);
                    toast.show();

                    Intent n=new Intent(SignIn.this,MainActivity.class);
                    startActivity(n);
                }
                else{
                    Context context = getApplicationContext();
                    CharSequence text = "Error";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
            }
        });
        addItemToSpinner();
        addListenerToSpinner();
    }

void addItemToSpinner() {

    ArrayAdapter<CharSequence> arrayAdapter_1 = ArrayAdapter.createFromResource(this, R.array.branch, android.R.layout.simple_spinner_dropdown_item);
    arrayAdapter_1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    branch.setAdapter(arrayAdapter_1);

    ArrayAdapter<CharSequence> arrayAdapter_2 = ArrayAdapter.createFromResource(this, R.array.year, android.R.layout.simple_spinner_dropdown_item);
    arrayAdapter_2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    year.setAdapter(arrayAdapter_2);

}



    void addListenerToSpinner() {

        branch.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                final String str1 = branch.getItemAtPosition(position).toString();
                mDatabase = FirebaseDatabase.getInstance().getReference();
                rno=roll.getText().toString().trim();
                mDatabase.child("Users").child(rno).child("Branch").setValue(str1);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        year.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                final String str2 = year.getItemAtPosition(position).toString();
                mDatabase = FirebaseDatabase.getInstance().getReference();
                rno=roll.getText().toString().trim();
                mDatabase.child("Users").child(rno).child("Year").setValue(str2);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }
}
