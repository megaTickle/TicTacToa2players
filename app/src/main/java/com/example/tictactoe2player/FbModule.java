package com.example.tictactoe2player;

import android.content.Context;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class FbModule {
    private Context context;
    private FirebaseDatabase database;
    private DatabaseReference reference;

    public FbModule(Context context){
        this.context = context;

        database = FirebaseDatabase.getInstance();
        reference = database.getReference("play");

        initFirebaseListener();
    }

    private void initFirebaseListener() {
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Position position = snapshot.getValue(Position.class);
                if (position != null){
                    ((GameActivity)context).setPositionFromFb(position);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void setPositionToFirebase(Position position){
        reference.setValue(position);
    }
}
