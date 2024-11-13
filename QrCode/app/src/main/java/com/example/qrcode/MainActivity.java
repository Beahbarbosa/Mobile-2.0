package com.example.qrcode;

import static android.content.ClipData.newIntent;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

        private ImageView imgqr;
        private Button btnLer;
        private Button btnGerar;

         @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            imgqr = findViewById(R.id.imgqr);
            btnLer = findViewById(R.id.btnLer);
            btnGerar = findViewById(R.id.btnGerar);

            // Texto para gerar o QR Code (pode ser uma URL ou qualquer outro texto)
            String textoParaQRCode = "https://www.example.com";

            // Instancia o gerador de QRCode e gera o QRCode
            QRCodeGenerator qrCodeGenerator = new QRCodeGenerator();
            Bitmap qrCodeBitmap = qrCodeGenerator.gerarQRCode(textoParaQRCode);

            // Exibe o QR Code gerado no ImageView
            if (qrCodeBitmap != null) {
                imgqr.setImageBitmap(qrCodeBitmap);
            }
        btnLer.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = newIntent(MainActivity.this, QRCodeGenerator.class);
                startActivity(intent);
            }
            
        });
         }

    private Intent newIntent(MainActivity mainActivity, Class<QRCodeGenerator> qrCodeGeneratorClass) {
    }


}