package br.edu.ifsuldeminas.mch.DesejosAndroid;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<String> desejoList;
    private MyAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        recyclerView = findViewById(R.id.recyclerView);
        desejoList = getIntent().getStringArrayListExtra("desejoList"); // Corrigido para obter uma StringArrayList

        // Verifica se a lista não é nula antes de criar o adaptador
        if (desejoList != null) {
            adapter = new MyAdapter(desejoList);
        } else {
            desejoList = new ArrayList<>(); // Cria uma lista vazia
            adapter = new MyAdapter(desejoList);
        }

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);


    }

    public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
        private List<String> dataList;

        public MyAdapter(List<String> dataList) {
            this.dataList = dataList;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.list_item, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            String item = dataList.get(position);
            holder.textViewItem.setText(item);
        }

        @Override
        public int getItemCount() {
            return dataList.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            public TextView textViewItem;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                textViewItem = itemView.findViewById(R.id.textViewItem);
            }
        }
    }
}