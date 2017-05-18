
import java.util.Scanner;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;

public class internet {
	public static void main(String[] args) throws IOException {
		String name = "try.txt";
		int i = 0 ;
		System.out.println("input web site with full http path, add '/' at end "); 
		Scanner sc = new Scanner(System.in);
		String web = sc.nextLine();
		
		HttpURLConnection connection = null;
		
		try {
			FileReader file = new FileReader(name);
			Scanner read = new Scanner(file);
			while (read.hasNext()) {
				String tail = read.nextLine();
				URL u = new URL(web+tail);
				connection = (HttpURLConnection) u.openConnection();
				connection.setRequestMethod("HEAD");
				int code = connection.getResponseCode();
				System.out.println("" + code);
				// You can determine on HTTP return code received. 200 is success.
				if ( code == 200 ){
					System.out.println("exists "+tail);
				} else {
					//comment this out to filter only those that work
					System.out.println("doesnot exist " +tail);
				}
			
			}
			read.close();
			file.close();
		} catch ( Exception e ) {
			System.out.println(e);
		}
	   
	    sc.close();
	}
}


