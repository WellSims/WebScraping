package SocketEThread;

public class PrincipalThread {
	

		//REALIZADO POR WELINGTON DA GL�RIA SIM�ES
	
		//MAIN QUE INST�NCIA A THREAD E DA O START
		public static void main(String[] args) {
			System.out.println("INICIO DO MAIN");

			Noticia noticia = new Noticia();
			Thread thread = new Thread(new NoticiaRun(noticia));
			thread.start();
			System.out.println("FIM DO MAIN");
}
}