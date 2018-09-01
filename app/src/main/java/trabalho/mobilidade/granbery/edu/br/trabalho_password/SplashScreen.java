package trabalho.mobilidade.granbery.edu.br.trabalho_password;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;

public class SplashScreen extends Activity {

    private static int splash_time_out = 3000;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

            new Handler().postDelayed(new Runnable() {
                /*
                 * Exibindo splash com um timer.
                 */
                @Override
                public void run() {
                    Intent i = new Intent(SplashScreen.this, MainActivity.class);
                    startActivity(i);

                    // Fecha esta activity
                    finish();
                }
            }, splash_time_out);
        }
    }

