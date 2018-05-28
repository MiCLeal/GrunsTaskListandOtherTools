package com.miniapps.grunstasklistandothertools.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import com.miniapps.grunstasklistandothertools.R;
import com.miniapps.grunstasklistandothertools.database.FeedReaderDBHelper;
import static com.miniapps.grunstasklistandothertools.constants.ConstsApplication.*;

public class AddClient extends AppCompatActivity {

    private FeedReaderDBHelper myDB;
    private EditText editName;
    private EditText editCPF;
    private EditText editEmail;
    private EditText editPhone;
    private EditText editCellphone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_client);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        myDB = new FeedReaderDBHelper(this);

        editName = findViewById(R.id.edit_Name);
        editCPF = findViewById(R.id.edit_CPF);
        editEmail = findViewById(R.id.edit_Email);
        editPhone = findViewById(R.id.edit_Phone);
        editCellphone = findViewById(R.id.edit_Cel);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editName.getText() == null || editCPF.getText() == null) {
                    Snackbar.make(view, REQUIRED_FIELDS, Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                } else {
                    if (InsertClient())
                        Snackbar.make(view, SUCCESSFULLY_ADD, Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    else
                        Snackbar.make(view, UNSUCCESSFULLY_ADD, Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                }

            }
        });
    }

    private boolean InsertClient() {
        boolean isInserted = myDB.insertClientData(editName.getText().toString(), editCPF.getText().toString(),
                editEmail.getText().toString(), editPhone.getText().toString(), editCellphone.getText().toString());
        return isInserted;
    }

}
