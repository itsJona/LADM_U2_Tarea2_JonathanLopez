package mx.edu.ittepic.ladm_u2_tarea2_jonathanlopez

import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint
import android.view.MotionEvent
import android.view.View
import android.widget.Toast

class Lienzo (p:MainActivity) : View(p){


    var punteroSprite : Sprite ?= null
    var hiloControl : Hilo?=null
    var apuntador =p
    var fin=false

    //BOTONES
    var btnPausar = Sprite(BitmapFactory.decodeResource(resources,R.drawable.pause),900,50)
    var btnReiniciar = Sprite(BitmapFactory.decodeResource(resources,R.drawable.reinicar),900,200)
    var btnDetener = Sprite(BitmapFactory.decodeResource(resources,R.drawable.detener),900,350)
    var btnDespausar = Sprite(BitmapFactory.decodeResource(resources,R.drawable.despausar),900,500)

    //HEROE
    var Link = Sprite(BitmapFactory.decodeResource(resources,R.drawable.link),500,1500)
    //PAISAJE
    var Fondo = Sprite(BitmapFactory.decodeResource(resources,R.drawable.paisaje),0,0)
    var gameOver = Sprite(BitmapFactory.decodeResource(resources,R.drawable.gameover),150,200)
    //HORDA DE ENEMIGOS
    var enemigo1 = Sprite(BitmapFactory.decodeResource(resources,R.drawable.enemigo1),100,-300-1000)
    var enemigo2 = Sprite(BitmapFactory.decodeResource(resources,R.drawable.enemigo2),500,200-1000)
    var enemigo3 = Sprite(BitmapFactory.decodeResource(resources,R.drawable.enemigo1),250,-500-1000)
    var enemigo4 = Sprite(BitmapFactory.decodeResource(resources,R.drawable.enemigo2),600,900-1000)
    var enemigo5 = Sprite(BitmapFactory.decodeResource(resources,R.drawable.enemigo1),650,-1000)
    var enemigo6 = Sprite(BitmapFactory.decodeResource(resources,R.drawable.enemigo2),800,520-1000)
    var enemigo7 = Sprite(BitmapFactory.decodeResource(resources,R.drawable.enemigo1),450,600-1000)
    var enemigo8 = Sprite(BitmapFactory.decodeResource(resources,R.drawable.enemigo2),964,700-1000)
    var enemigo9 = Sprite(BitmapFactory.decodeResource(resources,R.drawable.enemigo1),60,800-1000)
    var enemigo10 = Sprite(BitmapFactory.decodeResource(resources,R.drawable.enemigo2),200,10-1000)
    var enemigo11 = Sprite(BitmapFactory.decodeResource(resources,R.drawable.enemigo1),160,400-1000)
    var enemigo12 = Sprite(BitmapFactory.decodeResource(resources,R.drawable.enemigo2),150,-600-1000)
    var enemigo13 = Sprite(BitmapFactory.decodeResource(resources,R.drawable.enemigo1),750,-900-1000)
    var enemigo14 = Sprite(BitmapFactory.decodeResource(resources,R.drawable.enemigo2),160,-900-1000)
    var enemigo15 = Sprite(BitmapFactory.decodeResource(resources,R.drawable.enemigo1),600,900-1000)
    override fun onDraw(c: Canvas) {
        super.onDraw(c)
        var p = Paint()

        Fondo.pintar(c,p)
        Link.pintar(c,p)
        enemigo1.pintar(c,p)
        enemigo2.pintar(c,p)
        enemigo3.pintar(c,p)
        enemigo4.pintar(c,p)
        enemigo5.pintar(c,p)
        enemigo6.pintar(c,p)
        enemigo7.pintar(c,p)
        enemigo8.pintar(c,p)
        enemigo9.pintar(c,p)
        enemigo10.pintar(c,p)
        enemigo11.pintar(c,p)
        enemigo12.pintar(c,p)
        enemigo13.pintar(c,p)
        enemigo14.pintar(c,p)
        enemigo15.pintar(c,p)

        btnDetener.pintar(c,p)
        btnPausar.pintar(c,p)
        btnReiniciar.pintar(c,p)
        btnDespausar.pintar(c,p)

        if(fin){
            gameOver.pintar(c,p)
        }

        if(Link.colision(enemigo1)){ fin=true; hiloControl?.detener(); apuntador.setTitle("Link ha sido atacado")  }
        if(Link.colision(enemigo2)){ fin=true; hiloControl?.detener();  apuntador.setTitle("Link ha sido atacado") }
        if(Link.colision(enemigo3)){ fin=true; hiloControl?.detener();  apuntador.setTitle("Link ha sido atacado") }
        if(Link.colision(enemigo4)){ fin=true; hiloControl?.detener();  apuntador.setTitle("Link ha sido atacado") }
        if(Link.colision(enemigo5)){ fin=true; hiloControl?.detener();  apuntador.setTitle("Link ha sido atacado") }
        if(Link.colision(enemigo6)){ fin=true; hiloControl?.detener();  apuntador.setTitle("Link ha sido atacado") }
        if(Link.colision(enemigo7)){ fin=true; hiloControl?.detener();  apuntador.setTitle("Link ha sido atacado") }
        if(Link.colision(enemigo8)){ fin=true; hiloControl?.detener();  apuntador.setTitle("Link ha sido atacado") }
        if(Link.colision(enemigo9)){ fin=true; hiloControl?.detener();  apuntador.setTitle("Link ha sido atacado") }
        if(Link.colision(enemigo10)){ fin=true; hiloControl?.detener();  apuntador.setTitle("Link ha sido atacado") }
        if(Link.colision(enemigo11)){ fin=true; hiloControl?.detener();  apuntador.setTitle("Link ha sido atacado") }
        if(Link.colision(enemigo12)){ fin=true; hiloControl?.detener();  apuntador.setTitle("Link ha sido atacado") }
        if(Link.colision(enemigo13)){ fin=true; hiloControl?.detener();  apuntador.setTitle("Link ha sido atacado") }
        if(Link.colision(enemigo14)){ fin=true; hiloControl?.detener();  apuntador.setTitle("Link ha sido atacado") }
        if(Link.colision(enemigo15)){ fin=true; hiloControl?.detener();  apuntador.setTitle("Link ha sido atacado") }

    }


    override fun onTouchEvent(event: MotionEvent): Boolean {
        apuntador.setTitle("")
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                //REVISAMOS QUIEN ESTA EN AREA
                if (Link.estaEnArea(event)) {
                    punteroSprite = Link
                }


                //FUNCION DE BOTONES
                if (btnPausar.estaEnArea(event)) {
                    if(!hiloControl!!.isAlive) {
                        Toast.makeText(apuntador,"Hilo ya ha sido detenido",Toast.LENGTH_LONG).show()
                    }else {
                        punteroSprite = btnPausar
                        hiloControl?.pausar()
                        apuntador.setTitle("Pausado")
                    }
                }
                if (btnReiniciar.estaEnArea(event)) {
                    if(!hiloControl!!.isAlive) {
                        Toast.makeText(apuntador,"Hilo ya ha sido detenido",Toast.LENGTH_LONG).show()
                    }else{

                    reiniciar()
                    punteroSprite = btnReiniciar}
                }
                if (btnDetener.estaEnArea(event)) {
                    if(!hiloControl!!.isAlive) {
                        Toast.makeText(apuntador,"Hilo ya ha sido detenido",Toast.LENGTH_LONG).show()
                    }else{
                        punteroSprite = btnDetener
                        hiloControl?.detener()
                        apuntador.setTitle("Detener")
                        fin=true

                    }
                }
                if (btnDespausar.estaEnArea(event)) {
                    if(!hiloControl!!.isAlive) {
                        Toast.makeText(apuntador,"Hilo ya ha sido detenido",Toast.LENGTH_LONG).show()
                    }else {
                        punteroSprite = btnDetener
                        hiloControl?.despausar()
                    }
                }

            }
            MotionEvent.ACTION_MOVE -> {
                if (punteroSprite != null && punteroSprite==Link) {
                    punteroSprite!!.arrastrar(event)

                }

            }
            MotionEvent.ACTION_UP -> {
                punteroSprite = null


                if (Link.estaEnArea(event)) {
                    punteroSprite = Link
                }
                //FUNCION DE BOTONES
                if (btnPausar.estaEnArea(event)) {
                    apuntador.setTitle("Pausado")
                }
                if (btnReiniciar.estaEnArea(event)) {
                    apuntador.setTitle("Reiniciado")
                }
                if (btnDetener.estaEnArea(event)) {
                    apuntador.setTitle("Detenido")
                }
                if (btnDespausar.estaEnArea(event)) {
                    apuntador.setTitle("Despausado")
                }
            }
        }
        invalidate()
        return true
    }

    fun iniciarHilo(){
        hiloControl=Hilo(apuntador)
        hiloControl?.start()
    }

    fun iniciarHoleada(){
        enemigo1.alAtaque(height)
        enemigo2.alAtaque(height)
        enemigo3.alAtaque(height)
        enemigo4.alAtaque(height)
        enemigo5.alAtaque(height)
        enemigo6.alAtaque(height)
        enemigo7.alAtaque(height)
        enemigo8.alAtaque(height)
        enemigo9.alAtaque(height)
        enemigo10.alAtaque(height)
        enemigo11.alAtaque(height)
        enemigo12.alAtaque(height)
        enemigo13.alAtaque(height)
        enemigo14.alAtaque(height)
        enemigo15.alAtaque(height)
        invalidate()
    }

    fun reiniciar() {
        enemigo1.reiniciarY(-300-1000f)
        enemigo2.reiniciarY(200-1000f)
        enemigo3.reiniciarY(-500-1000f)
        enemigo4.reiniciarY(900-1000f)
        enemigo5.reiniciarY(-1000f)
        enemigo6.reiniciarY(520-1000f)
        enemigo7.reiniciarY(600-1000f)
        enemigo8.reiniciarY(700-1000f)
        enemigo9.reiniciarY(800-1000f)
        enemigo10.reiniciarY(10-1000f)
        enemigo11.reiniciarY(400-1000f)
        enemigo12.reiniciarY(-600-1000f)
        enemigo13.reiniciarY(-900-1000f)
        enemigo14.reiniciarY(-900-1000f)
        enemigo15.reiniciarY(900-1000f)
    }



}