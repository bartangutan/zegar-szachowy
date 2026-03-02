package com.example.zegar_szachowy;

import android.os.CountDownTimer;
import android.widget.Button;

public class Gracz {
    private int ileSekund = 180;
    private boolean czyAktywny;
    private CountDownTimer countDownTimer;
    private Button button; //nie powinno się łączyć widoku z działaniem (a tutaj to robimy)

    public Gracz(boolean czyAktywny, Button button) {
        this.czyAktywny = czyAktywny;
        this.button = button;
        if(czyAktywny){
            uruchomZegar();
        }else{
            button.setClickable(false);
        }
    }

    public boolean isCzyAktywny() {
        return czyAktywny;
    }

    public void setCzyAktywny(boolean czyAktywny) {
        this.czyAktywny = czyAktywny;
    }

    public void odwrocAktywnosc(){
        czyAktywny = !czyAktywny;
        button.setClickable(czyAktywny);
        if(czyAktywny){
            uruchomZegar();
        }else{
            zatrzymajZegar();
        }
    }

    private void zatrzymajZegar(){
        countDownTimer.cancel();
    }

    private void uruchomZegar(){
        countDownTimer = new CountDownTimer(ileSekund*1000,1000) {
            @Override
            public void onFinish() {

            }

            @Override
            public void onTick(long l) {
                ileSekund = (int)l/1000;
                button.setText(""+ileSekund);
            }
        };
        countDownTimer.start();
    }
}
