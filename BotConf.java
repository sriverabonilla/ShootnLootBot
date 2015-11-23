import java.util.*;
import java.io.*;

public class BotConf {
	String oauth, channel, nickname, ad1, ad2, ad3, ad4, ad5, admin, bungie_api, motd;
	
	public BotConf() throws IOException , FileNotFoundException {

		File file1 = new File("./conf/conf.txt");
		Scanner a = new Scanner(file1).useDelimiter("\\a*;\\a*");
		admin = a.next();
		channel = a.next();
		nickname = a.next();
		oauth = a.next();
		a.close();
		
		File file2 = new File("./conf/ads.txt");
		Scanner b = new Scanner(file2).useDelimiter("\\b*;\\b*");
		ad1 = b.next();
		ad2 = b.next();
		ad3 = b.next();
		ad4 = b.next();
		ad5 = b.next();
		b.close();
				
		File file3 = new File("./conf/bungie.txt");
		Scanner d = new Scanner(file3).useDelimiter("\\d*;\\d*");
		bungie_api = d.next();
		d.close();
		
		File file4 = new File("./conf/motd.txt");
		Scanner e = new Scanner(file4).useDelimiter("\\e*;\\e*");
		motd = e.next();
		e.close();
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
	public String Motd(){
		return motd;
	}
	public String BungieApi(){
		return bungie_api;
	}
}