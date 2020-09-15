package com.example.assignment_tsr_ywh_nkh_tyc_wrk;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Cart extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    Button nextBtn;
    TextView totalPrice;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cart);

        recyclerView = findViewById(R.id.cart_list);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        toolbar = findViewById(R.id.toolbar);

        nextBtn = findViewById(R.id.nextBtn);
        totalPrice = findViewById(R.id.totalPrice);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    protected void onStart() {
        super.onStart();

        final DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("Cart List");

        FirebaseRecyclerOptions<CartGetSet> options = new FirebaseRecyclerOptions.Builder<CartGetSet>()
                .setQuery(reference.child("User View"), CartGetSet.class).build();

        FirebaseRecyclerAdapter<CartGetSet, CartViewHolder> adapter = new FirebaseRecyclerAdapter<CartGetSet, CartViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull CartViewHolder holder, int position, @NonNull CartGetSet model) {
                holder.txtProductName.setText("Product Name: " + model.getpName());
                holder.txtProductPrice.setText("Price: " +model.getPrice());
                holder.txtProductQuantity.setText("Quantity: " + model.getQuantity());

                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        CharSequence options[] = new CharSequence[]{
                                "Remove"
                        };
                        AlertDialog.Builder builder = new AlertDialog.Builder(Cart.this);
                        builder.setTitle("Cart Options: ");

                        builder.setItems(options, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                if (i == 0){
                                    reference.child("User View").child("Product").removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            Toast.makeText(Cart.this, "Item Remove!", Toast.LENGTH_SHORT).show();
                                        }
                                    });
                                }
                            }
                        });
                        builder.show();
                    }
                });

            }

            @NonNull
            @Override
            public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_item, parent, false);
                CartViewHolder holder = new CartViewHolder(view);
                return holder;
            }
        };

        recyclerView.setAdapter(adapter);
        adapter.startListening();

  }
}
