import java.io.File;
import java.net.URL;
import java.rmi.server.RMIClassLoader;


public class HightunesBootstrap {
	public static void main(String[] args)
	{
		try {
			// SecurityManager
			String path = new File("rmi.policy").getAbsolutePath();
			System.out.println(path);
			System.setProperty("java.security.policy", path);
			if (System.getSecurityManager() == null) {
				System.setSecurityManager(new SecurityManager());
			}
			// téléchargement de la classe du client
			Class c = RMIClassLoader.loadClass("file:///D:/Documents/Etudes/4%20-%20Polytech/Polytech%202%20-%20redoublement/Architecture%20distribuée/HighTunes-serveur/bin", "HightunesClient");
			// instanciation du client
			Runnable r = (Runnable) c.newInstance();
			// lancement du ’véritable’ client
			r.run();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
