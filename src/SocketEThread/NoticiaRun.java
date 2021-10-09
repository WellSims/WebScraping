package SocketEThread;

import java.io.IOException;

public class NoticiaRun implements Runnable  {


    //RUNNABLE QUE RECEBE A NOTICIA MAIS RECENTE, GUARDA E VERIFICA SE AS PRÓXIMAS CONSULTAS VÃO
    //RETORNAR NOTICIAS IGUAIS

    Noticia noticia;
    public NoticiaRun(Noticia noticia) {
        this.noticia = noticia;
    }

    @Override
    public void run() {
        String noticiaAtual="";
        while(true){
            String noticiaNova ="";

            System.out.println("RODANDO");

            try {
                noticiaNova = noticia.ConsultaNoticia();
            } catch (IOException e) {
                e.printStackTrace();
            }

            if(!(noticiaNova.equals(noticiaAtual))){
            System.out.println("NOVA NOTICIA: " + noticiaNova);
                noticiaAtual=noticiaNova;
            }else{
                System.out.println("AGUARDANDO NOVA NOTICIA");
            }

            try {
                Thread.sleep(3600000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
