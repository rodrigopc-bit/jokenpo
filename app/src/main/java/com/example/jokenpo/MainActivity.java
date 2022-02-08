package com.example.jokenpo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void pedra(View view){
        this.escolha("pedra");
    }

    public void papel(View view){
        this.escolha("papel");
    }

    public void tesoura(View view){
        this.escolha("tesoura");
    }

    public void spock(View view) { this.escolha("spock"); }

    public void lizard(View view) { this.escolha("lizard"); }

    int appScore = 0,userScore = 0;

    @SuppressLint("SetTextI18n")
    public void escolha(String escolha){
        int num = new Random().nextInt(5); // 0, 1, 2, 3 ou 4
        String[] opcoes = {"pedra","papel","tesoura","spock","lizard"};
        String escolhaApp = opcoes[num];

        ImageView imgEscolha = findViewById(R.id.imgEscolha); // Inicializa o ImageView e guarda a imgEscolha na variável

        switch(escolhaApp){
            case "pedra":
                imgEscolha.setImageResource(R.drawable.pedra);
                break;
            case "papel":
                imgEscolha.setImageResource(R.drawable.papel);
                break;
            case "tesoura":
                imgEscolha.setImageResource(R.drawable.tesoura);
                break;
            case "spock":
                imgEscolha.setImageResource(R.drawable.spock);
                break;
            case "lizard":
                imgEscolha.setImageResource(R.drawable.lagarto);
        }

        TextView textoResultado = findViewById(R.id.textoResultado);

        TextView textoResultadoUsuario = findViewById(R.id.textoResultadoUsuario);
        TextView textoResultadoApp = findViewById(R.id.textoResultadoApp);

        if( (escolhaApp == "pedra"   && escolha == "tesoura") || //App vence
            (escolhaApp == "pedra"   && escolha == "lizard")  ||
            (escolhaApp == "papel"   && escolha == "spock")   ||
            (escolhaApp == "papel"   && escolha == "pedra")   ||
            (escolhaApp == "tesoura" && escolha == "lizard")  ||
            (escolhaApp == "tesoura" && escolha == "papel")   ||
            (escolhaApp == "spock"   && escolha == "pedra")   ||
            (escolhaApp == "spock"   && escolha == "tesoura") ||
            (escolhaApp == "lizard"  && escolha == "papel")   ||
            (escolhaApp == "lizard"  && escolha == "spock")){

            textoResultado.setText("App vence");
            appScore += 1;
            textoResultadoApp.setText(Integer.toString(appScore));

        }else if(   (escolhaApp == "pedra"   && escolha == "papel")   || //Usuário vence
                    (escolhaApp == "pedra"   && escolha == "spock")   ||
                    (escolhaApp == "papel"   && escolha == "lizard")  ||
                    (escolhaApp == "papel"   && escolha == "tesoura") ||
                    (escolhaApp == "tesoura" && escolha == "pedra")   ||
                    (escolhaApp == "tesoura" && escolha == "spock")   ||
                    (escolhaApp == "spock"   && escolha == "lizard")  ||
                    (escolhaApp == "spock"   && escolha == "papel")   ||
                    (escolhaApp == "lizard"  && escolha == "pedra")   ||
                    (escolhaApp == "lizard"  && escolha == "tesoura")){

            textoResultado.setText("Usuário vence");
            userScore += 1;
            textoResultadoUsuario.setText(Integer.toString(userScore));

        }else{ //Empate
            textoResultado.setText("Empate");
        }

    }

}