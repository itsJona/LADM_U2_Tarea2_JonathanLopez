package mx.edu.ittepic.ladm_u2_tarea2_jonathanlopez

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Paint
import android.view.MotionEvent

class Sprite(){

    var x = 0f
    var y = 0f
    var ancho = 0f
    var alto = 0f
    var sprite : Bitmap ?= null
    var incY = 5f
    var tipo = 1

    constructor(Bitmap : Bitmap, x:Int, y:Int) : this(){
        this.sprite = Bitmap
        this.y = y.toFloat()
        this.x = x.toFloat()
        tipo =3
        ancho = sprite!!.width.toFloat()
        alto = sprite!!.height.toFloat()
    }

    fun pintar (c:Canvas,p:Paint){
        c.drawBitmap(sprite!!,x,y,p)
    }

    fun estaEnArea(event: MotionEvent):Boolean{
        if(event.x>=x && event.x<=x+ancho){
            if(event.y>=y && event.y<=y+alto){
                return true
            }
        }
        return false
    }


    fun arrastrar(event: MotionEvent){
        x = event.x-(ancho/2)

    }

    fun colision(objetoB:Sprite) :Boolean{
        //caso 1
        if(objetoB.estaEnArea(x+ancho,y+alto)) {
            return true
        }
        //caso 2
        if(objetoB.estaEnArea(x,y+alto)){
            return true
        }
        //caso 3
        if(objetoB.estaEnArea(x+ancho,y)){
            return true
        }
        //caso 4
        if(objetoB.estaEnArea(x,y)){
            return true
        }

        return false
    }

    fun estaEnArea(posX:Float,posY:Float):Boolean{
        if(posX>=x+15f && posX<=x+ancho-15f){
            if(posY>=y+15f && posY<=y+alto-15f){
                return true
            }
        }
        return false
    }

    fun alAtaque(alto:Int){
        y+= incY
        if(y>=alto+100){
            y = 0f
        }
    }

    fun reiniciarY(valorI :Float){
          y=valorI
    }


}
