import java.util.*;
import java.io.*;

public class BotConf {
	String oauth, channel, nickname, ad1, ad2, ad3, ad4, ad5, admin;
	
	public BotConf() throws IOException , FileNotFoundException {

		File file1 = new File("./conf/snl.txt");
		Scanner s = new Scanner(file1).useDelimiter("\\s*;\\s*");
		oauth = s.next();
		channel = s.next();
		nickname = s.next();
		s.close();
		
		File file2 = new File("./conf/ads.txt");
		Scanner a = new Scanner(file2).useDelimiter("\\a*;\\a*");
		ad1 = a.next();
		ad2 = a.next();
		ad3 = a.next();
		ad4 = a.next();
		ad5 = a.next();
		a.close();
		
		File file3 = new File("./conf/admin.txt");
		Scanner b = new Scanner(file3).useDelimiter("\\b*;\\b*");
		admin = b.next();
		b.close();
	}
	
	public String Oauth(){
		return oauth;
	}
	public String Channel() {
		return channel;
	}
	public String Nickname() {
		return nickname;
	}
	public String Ad1() {
		return ad1;
	}
	public String Ad2() {
		return ad2;
	}
	public String Ad3() {
		return ad3;
	}
	public String Ad4() {
		return ad4;
	}
	public String Ad5() {
		return ad5;
	}
	public String Admin() {
		return admin;
	}
}