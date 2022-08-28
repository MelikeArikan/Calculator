package com.melikearikan.hesapmatik

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    var check = 0

    fun btnSayiTik(view: View){
        if (check != 0 ){
            sayiGosterET.setText("0")
        }

        var btnSec = view as Button
        var btnTikDeger : String = sayiGosterET.text.toString()
        if (btnTikDeger == "0"){
            sayiGosterET.setText("")
            btnTikDeger = ""
        }

        when(btnSec.id){

            btn0.id -> {
                btnTikDeger += "0"
            }
            btn1.id -> {
                btnTikDeger +=  "1"
            }
            btn2.id -> {
                btnTikDeger +=  "2"
            }
            btn3.id -> {
                btnTikDeger +=  "3"
            }
            btn4.id -> {
                btnTikDeger +=  "4"
            } btn5.id -> {
            btnTikDeger +=  "5"
            }
            btn6.id -> {
                btnTikDeger +=  "6"
            }
            btn7.id -> {
                btnTikDeger +=  "7"
            }
            btn8.id -> {
                btnTikDeger += "8"
            }
            btn9.id -> {
                btnTikDeger +=  "9"
            }
            btnArtiEksi.id -> {
                btnTikDeger = '-' + btnTikDeger
            }
        }

        sayiGosterET.setText(btnTikDeger)
        check = 0
    }
    var operator :String?=null
    var eskiSayi :String?=null

    fun btnopTik(view: View) {
        if (operator != null){
            var operatorHatasi = AlertDialog.Builder(this@MainActivity)
            operatorHatasi.setTitle("aynı anda birden fazla operatör kullanamazsınız!!")
            operatorHatasi.setMessage("hatalı işlem yaptınız,lütfen tekrardan işlem yapınız.")
            operatorHatasi.setPositiveButton("anladım",DialogInterface.OnClickListener { dialogInterface, i ->
                sayiGosterET.setText("0")
                operator = null
                eskiSayi = ""
                check = 0
            }).show()
        }
        eskiSayi = sayiGosterET.text.toString()
        var btnSec = view as Button
        when (btnSec.id) {
            btnBolme.id -> {
                operator = "/"
            }
            btnCarpma.id -> {
                operator = "X"
            }
            btnCikarma.id -> {
                operator = "-"
            }
            btnToplama.id -> {
                operator = "+"
            }
        }
        sayiGosterET.setText(operator)
        check = check + 1

    }

    fun btnEsittirTik(view :View){
        var yeniSayi = sayiGosterET.text.toString()

        var sonucSayisi :Double? = null
        when(operator){
            "/" ->  { sonucSayisi = eskiSayi!!.toDouble() / yeniSayi.toDouble() }
            "X" ->  { sonucSayisi = eskiSayi!!.toDouble() * yeniSayi.toDouble() }
            "-" ->  { sonucSayisi = eskiSayi!!.toDouble() - yeniSayi.toDouble() }
            "+" ->  { sonucSayisi = eskiSayi!!.toDouble() + yeniSayi.toDouble() }
        }
        sayiGosterET.setText(sonucSayisi.toString())
        operator = null

    }

    fun btnAC(view: View){
        sayiGosterET.setText("0")
        operator = null

    }
    fun btnMode(view: View){
        var yuzdeSayi :Double = sayiGosterET.text.toString().toDouble() / 100
        sayiGosterET.setText(yuzdeSayi.toString())
    }
}
/* **************************** bu projeden öğrendiklerim. ************************************************

    1)_ 'view as Button' diyerek butonu bir değişkene atayabiliceğim.
    2)_ eğer bir değşken fonksyon içinde tanımlanmışsa, fonksiyon çalışıp bittiktan sonra fonksiyondaki değişken ve tuttuğu değer kaybolur.
    3)_ değişken,global alanda tanımlanmıs ama değeri fonksiyon içinde veriliyorsa ya da değeri fonksiyon içinde değiştiriliyorsa bu değişkenin yeni değerine o sınıf içinde heryerden ulaşılır.



     */
