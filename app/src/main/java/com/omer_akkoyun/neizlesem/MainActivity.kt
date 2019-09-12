package com.omer_akkoyun.neizlesem

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.animation.AnimationUtils
import android.widget.Toast
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.Url
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        internetKontrolDurum()

        var id = (0..13176).random()

        var clientApi = ApiClient.client?.create(ApiInterface::class.java)
        var interfaceApi = clientApi?.filmiGetir(id)
        var intent = Intent(applicationContext,MainActivity::class.java)//hata olursa main activity tekrar başlatmak için

        if (internetKontrolDurum()){



            interfaceApi?.enqueue(object : Callback<DataModelClass> {
                //HATA OLURSA
                override fun onFailure(call: Call<DataModelClass>, t: Throwable) { Toast.makeText(this@MainActivity, "Please wait ", Toast.LENGTH_LONG).show()
                    startActivity(intent)
                }

                //BAŞARILI OLUNCA
                override fun onResponse(
                    call: Call<DataModelClass>,
                    response: Response<DataModelClass>
                ) {


                    //var url = (call?.request()?.url()?.toString())
                    var resim =(response.body()?.data?.movie?.mediumCoverİmage).toString()
                    var baslik = (response.body()?.data?.movie?.title).toString()
                    var yil = (response.body()?.data?.movie?.year).toString()
                    var begeniSayisi =(response.body()?.data?.movie?.likeCount).toString()
                    var puan = (response.body()?.data?.movie?.rating).toString()
                    var dakika = (response.body()?.data?.movie?.runtime).toString()
                    var kategori:List<String?> = response.body()?.data?.movie?.genres!!
                    var ozet=(response.body()?.data?.movie?.descriptionİntro).toString()


                    if(yil=="0"){ //nul değer gelirse tekrar başlasın aktivity

                        startActivity(intent)
                    }
                    Picasso.with(this@MainActivity).load(resim).into(imgResim);


                   // Log.e("DASDASDASDASDASDASD",url)

                    tvTitle.text = "Title : "+baslik.toString()
                    tvImdb.text= "Imdb : "+puan.toString()+"/10" +"    Like Count: "+begeniSayisi.toString()
                    tvYear.text = "Year : "+yil.toString()
                    tvdakika.text ="Minute : "+dakika.toString()+"min"
                    tvGenres.text ="Genres :"+kategori.toString()
                    tvSummaryAlan.text = ozet.toString()
                    textView5d.text ="Summary"

                    var butondondurAnimasyon = AnimationUtils.loadAnimation(this@MainActivity,R.anim.dondur)


                    button.setOnClickListener {


                        button.startAnimation(butondondurAnimasyon)

                        //Animasyon bitmeden 1sn sonra MainActivity açılsın
                        object : CountDownTimer(1000, 1000) {
                            override fun onFinish() {
                                var intent = Intent(applicationContext, MainActivity::class.java)
                                startActivity(intent)
                            }

                            override fun onTick(p0: Long) {
                                //işimiz yok burasıyla
                            }

                        }.start()

                    }

                }


            })





        }
        else{
            anayer.setBackgroundResource(R.drawable.notinternet)

        }



    }

    //İnternet Kontrolü
    fun internetKontrolDurum():Boolean{


        val baglantiMain= getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val internetBilgi = baglantiMain.activeNetworkInfo
        val durum = internetBilgi!= null && internetBilgi.isConnectedOrConnecting
        if (!durum){

            Toast.makeText(this,"Opps\n" +"Check Your Internet Connection!",Toast.LENGTH_SHORT).show()
            return false
        }
        else{

            return true
        }

    }
}

