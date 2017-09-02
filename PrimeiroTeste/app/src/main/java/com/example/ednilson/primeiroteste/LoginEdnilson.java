package com.example.ednilson.primeiroteste;

import android.content.DialogInterface;
import android.content.Intent;
import android.preference.DialogPreference;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class LoginEdnilson extends AppCompatActivity {

    private List<String> tasks = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_ednilson);
    }

    public void telaActivity (View view) {
        Intent it = new Intent (LoginEdnilson.this, TelaInicial.class);

        startActivity(it);
    }

    public void cadastroActivity (View view){
        Intent ap = new Intent(LoginEdnilson.this, Cadastro.class);
        startActivity(ap);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }



    public boolean onOptionItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.action_add_task:
                final EditText editText = new EditText(this);

                AlertDialog dialog = new AlertDialog.Builder(this)
                        .setTitle("Add new task")
                        .setMessage("Whats do you")
                        .setView(editText)
                        .setPositiveButton("add", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                String task = String.valueOf(editText.getText());
                                tasks.add(task);
                                Log.d("MAIN", "Task added: " + tasks);

                            }
                        })
                        .setNegativeButton("Cancel", null)
                        .create();

                        dialog.show();
                default:
                    return super.onOptionsItemSelected(item);
        }


    }

}
