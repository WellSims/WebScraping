package SocketEThread;

import java.io.*;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;

//SOCKET QUE CONSULTA AS NOTICIAS DO SITE DA CATÓLICA

public class Noticia {

    public String ConsultaNoticia() throws UnknownHostException, IOException {

        URL url = new URL("http://noosfero.ucsal.br/institucional/noticias/feed");

        BufferedReader is = new BufferedReader(new InputStreamReader(url.openStream()));

        String linha = "";
        String noticia = "";

        while ((linha = is.readLine()) != null) {

            //<title> </title>
            if (linha.contains("</description><item>")) {
                int tam = "</description><item><title>".length();
                int inicial = linha.lastIndexOf("</description><item><title>");
                int ultimo = linha.indexOf("</title><description>", inicial);

                noticia = linha.substring(inicial + tam, ultimo);
            }
        }
        return noticia;
    }
}
