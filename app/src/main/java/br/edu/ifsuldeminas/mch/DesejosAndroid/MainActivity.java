package br.edu.ifsuldeminas.mch.DesejosAndroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText desejoEditText;
    private Button addButton;
    private Button showButton;
    private ArrayList<String> desejoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        desejoEditText = findViewById(R.id.desejoEditText);
        addButton = findViewById(R.id.addButton);
        showButton = findViewById(R.id.showButton);

        desejoList = new ArrayList<>();

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String desejo = desejoEditText.getText().toString();
                if (!desejo.isEmpty()) {
                    desejoList.add(desejo);
                    desejoEditText.setText("");
                    Toast.makeText(MainActivity.this, "Desejo adicionado!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Digite um desejo válido!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        showButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListActivity.class);
                intent.putExtra("desejoList", desejoList); // Passa a lista diretamente
                startActivity(intent);
            }
        });
    }
}