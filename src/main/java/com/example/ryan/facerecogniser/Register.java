package com.example.ryan.facerecogniser;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Register extends AppCompatActivity {
    private static final String NAME_FILE = "name.txt";
    private static final String AGE_FILE = "age.txt";
    private static final String EMAIL_FILE = "email.txt";

    EditText fullname;
    EditText age;
    EditText email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        fullname = findViewById(R.id.nameText);
        age = findViewById(R.id.ageText);
        email = findViewById(R.id.emailText);

        Spinner gender = findViewById(R.id.gender);

        String[] items = new String[]{"(Select Gender)", "Male", "Female", "Prefer not to say"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        gender.setAdapter(adapter);

        Spinner user = findViewById(R.id.user);

        String[] items2 = new String[]{"(Select User)", "Standard User", "Software Engineer"};
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items2);
        user.setAdapter(adapter2);
    }

    public void onClick(View v) {
        startActivity(new Intent(Register.this, Camera.class));

        String nameInput = fullname.getText().toString();
        String ageInput = age.getText().toString();
        String emailInput = email.getText().toString();
        FileOutputStream fos = null;

        try {
            fos = openFileOutput(NAME_FILE, MODE_PRIVATE);
            fos.write(nameInput.getBytes());

            fos = openFileOutput(AGE_FILE, MODE_PRIVATE);
            fos.write(ageInput.getBytes());

            fos = openFileOutput(EMAIL_FILE, MODE_PRIVATE);
            fos.write(emailInput.getBytes());

            fullname.getText().clear();
            age.getText().clear();
            email.getText().clear();

            Toast.makeText(this, "Saved to " + getFilesDir() +"/"+ NAME_FILE, Toast.LENGTH_LONG);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static String getName() {
        return NAME_FILE;
    }

    public static String getAge() {
        return AGE_FILE;
    }
    public static String getEmail() {
        return EMAIL_FILE;
    }
}
