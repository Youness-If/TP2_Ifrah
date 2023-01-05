package com.example.evolvedactivity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AutreLogin extends AppCompatActivity {

    private static final int REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autre_login);

        // Récupération de l'Intent qui a démarré l'activité
        Intent intent = getIntent();
        // Vérification de l'action de l'Intent et affichage d'un message Toast en conséquence
        if (intent.getAction().equals("login.ACTION")) {
            Toast.makeText(this, "Démarrage de l'activité AutreLogin via l'action login.ACTION", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Démarrage de l'activité AutreLogin via un autre moyen", Toast.LENGTH_SHORT).show();
        }

        Button loginButton = (Button) findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Création d'un Intent avec l'action login.ACTION et l'ajout d'un extra "login_success"
                Intent resultIntent = new Intent("login.ACTION");
                resultIntent.putExtra("login_success", true);
                // Envoi du résultat à l'activité qui a appelé celle-ci de manière implicite
                setResult(RESULT_OK, resultIntent);
                // Fermeture de l'activité

                finish();
            }
        });
        Button cancelButton = (Button) findViewById(R.id.cancelButton);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Envoi du résultat "Annuler" à l'activité qui a appelé celle-ci de manière implicite
                setResult(RESULT_CANCELED);
                // Fermeture de l'activité
                finish();
            }
        });
    }
}