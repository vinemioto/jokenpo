package com.example.vine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;


public class MainActivity extends AppCompatActivity {
    private TextView tV1,tV2,tV3,tV4,tV5;
    private Button btn1,btn2,btn3,btn4,alterar;
    private ImageView imageView,imageView2;
    int pontosComputador = 0;
    int pontosUsuario = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = findViewById(R.id.button);
        btn2 = findViewById(R.id.button2);
        btn3 = findViewById(R.id.button3);
        btn4 = findViewById(R.id.button4);
        tV1 = findViewById(R.id.textView);
        tV2 = findViewById(R.id.textView2);
        tV3 = findViewById(R.id.textView3);
        tV4 = findViewById(R.id.textView4);
        tV5 = findViewById(R.id.textView5);
        imageView = findViewById(R.id.imageView);
        imageView2 = findViewById(R.id.imageView2);
        alterar = findViewById(R.id.alterar);

        //1 - Papel ; 2 - Pedra; 3 - Tesoura;
        //U(1) C(2) = -1 Venc. Usuario;
        //U(1) C(3) = -2 Venc. Computador;
        //U(2) C(1) = 1 Venc. Computador;
        //U(2) C(3) = -1 Venc. Usuario;
        //U(3) C(1) = 2 Venc. Usuario;
        //U(3) C(2) = 1 Venc. Computador;


        for (int i = 0; i < 5; i++) {
            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int numeroUsuario = 1;
                    Random gerador = new Random();
                    int escolhaComputador;
                    imageView.setImageResource(R.drawable.paper);
                    escolhaComputador = gerador.nextInt(3) + 1; //Gera um num. de 1 e 3.
                    switch (escolhaComputador) {
                        case 1:
                            tV4.setText("Computador: PAPEL");
                            imageView2.setImageResource(R.drawable.paper);
                            break;
                        case 2:
                            tV4.setText("Computador: PEDRA");
                            imageView2.setImageResource(R.drawable.rock);
                            break;
                        case 3:
                            tV4.setText("Computador: TESOURA");
                            imageView2.setImageResource(R.drawable.scissors);
                            break;
                    } //verificaçăo do resutado.
                    if (numeroUsuario == escolhaComputador) {
                        tV5.setText("EMPATE");
                    }else {
                        if ((numeroUsuario - escolhaComputador) == -1 ||
                                (numeroUsuario - escolhaComputador) == 2) {
                            tV5.setText("Ponto Usuário!");
                            pontosUsuario++;
                        } else {
                            tV5.setText("Ponto Computador!");
                            pontosComputador++;
                        }
                        if (pontosUsuario > 4) {
                            tV5.setText("USUÁRIO VENCEDOR!!!");
                            pontosComputador = 0;
                            pontosUsuario = 0;
                        }
                        if (pontosComputador > 4) {
                            tV5.setText("COMPUTADOR VENCEDOR!!!");
                            pontosComputador = 0;
                            pontosUsuario = 0;
                        }
                    }
                    tV2.setText("User:" +pontosUsuario);
                    tV1.setText("Comp:" +pontosComputador);
                }

            });

            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    imageView.setImageResource(R.drawable.rock);
                    int numeroUsuario = 2;
                    Random gerador = new Random();
                    int escolhaComputador;
                    escolhaComputador = gerador.nextInt(3) + 1; //Gera um num. de 1 e 3.
                    switch (escolhaComputador) {
                        case 1:
                            tV4.setText("Computador: PAPEL");
                            imageView2.setImageResource(R.drawable.paper);
                            break;
                        case 2:
                            tV4.setText("Computador: PEDRA");
                            imageView2.setImageResource(R.drawable.rock);
                            break;
                        case 3:
                            tV4.setText("Computador: TESOURA");
                            imageView2.setImageResource(R.drawable.scissors);
                            break;
                    } //verificaçăo do resutado.

                    if (numeroUsuario == escolhaComputador) {
                        tV5.setText("EMPATE");
                    }else {
                        if ((numeroUsuario - escolhaComputador) == -1 ||
                                (numeroUsuario - escolhaComputador) == 2) {
                            tV5.setText("Ponto Usuário!");
                            pontosUsuario++;
                        } else {
                            tV5.setText("Ponto Computador!");
                            pontosComputador++;
                        }
                        if (pontosUsuario > 4) {
                            tV5.setText("USUÁRIO VENCEDOR!!!");
                            pontosComputador = 0;
                            pontosUsuario = 0;
                        }
                        if (pontosComputador > 4) {
                            tV5.setText("COMPUTADOR VENCEDOR!!!");
                            pontosComputador = 0;
                            pontosUsuario = 0;
                        }
                    }
                    tV2.setText("User:" +pontosUsuario);
                    tV1.setText("Comp:" +pontosComputador);
                }
            });

            btn3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    imageView.setImageResource(R.drawable.scissors);
                    int numeroUsuario = 3;
                    Random gerador = new Random();
                    int escolhaComputador;
                    escolhaComputador = gerador.nextInt(3) + 1; //Gera um num. de 1 e 3.
                    switch (escolhaComputador) {
                        case 1:
                            tV4.setText("Computador: PAPEL");
                            imageView2.setImageResource(R.drawable.paper);
                            break;
                        case 2:
                            tV4.setText("Computador: PEDRA");
                            imageView2.setImageResource(R.drawable.rock);
                            break;
                        case 3:
                            tV4.setText("Computador: TESOURA");
                            imageView2.setImageResource(R.drawable.scissors);
                            break;
                    } //verificaçăo do resutado.

                    if (numeroUsuario == escolhaComputador) {
                        tV5.setText("EMPATE");
                    } else if ((numeroUsuario - escolhaComputador) == -1 ||
                            (numeroUsuario - escolhaComputador) == 2) {
                        tV5.setText("Ponto Usuário!");
                        pontosUsuario++;
                    } else {
                        tV5.setText("Ponto Computador!");
                        pontosComputador++;
                    }
                    if (pontosUsuario>4) {
                        tV5.setText("USUÁRIO VENCEDOR!!!");
                        pontosComputador=0;
                        pontosUsuario=0;
                    }
                    if(pontosComputador>4){
                        tV5.setText("COMPUTADOR VENCEDOR!!!");
                        pontosComputador=0;
                        pontosUsuario=0;
                    }

                    tV2.setText("User:" +pontosUsuario);
                    tV1.setText("Comp:" +pontosComputador);
                }
            });
            if (pontosUsuario>4) {
                tV5.setText("USUÁRIO VENCEDOR!!!");
                pontosComputador=0;
                pontosUsuario=0;
            }
            if(pontosComputador>4){
                tV5.setText("COMPUTADOR VENCEDOR!!!");
                pontosComputador=0;
                pontosUsuario=0;
            }
        }
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Login.class);
                startActivity(intent);

            }
        });

        alterar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(it);
            }
        });


    }
}