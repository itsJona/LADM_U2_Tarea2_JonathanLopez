package mx.edu.ittepic.ladm_u2_tarea2_jonathanlopez

class Hilo(p:MainActivity) : Thread(){

    var puntero = p
    var iniciado = false
    var pausa = false


    override fun run() {
        super.run()
        iniciado = true
        puntero.setTitle("Iniciado")
        while (iniciado) {
            sleep(40)
            if (!pausa) {
                puntero.runOnUiThread {
                    puntero.lienzo!!.iniciarHoleada()

                }
            }
        }
    }


    //El hilo debe pausar
    //El hilo debe quitar la pausa
    //El hilo podría reiniciarse
    //El hilo se debe detener


    fun pausar() {
        pausa = true
    }

    fun despausar() {
        pausa = false
    }

    fun detener() {
        iniciado = false
    }




}//class




