import org.jibble.pircbot.*;
import java.util.*;


public class SnLBot extends PircBot {
    
    Timer timer;
    String ch, ad1, ad2, ad3, ad4, ad5, admin;
    boolean timer_check = false;
    int randNumber, randOldNumber = 0, timerMinutes = 2, X = 60;
    Random rand;
            
    public SnLBot(String nick, String AD1, String AD2, String AD3, String AD4, String AD5, String Admin) { 
        this.setName(nick);
        ad1 = AD1; ad2 = AD2; ad3 = AD3; ad4 = AD4; ad5 = AD5; admin = Admin;
        
    }
        
    public void onMessage(String channel, String sender, String login, String hostname, String message) {

        //Command List
        if (message.equalsIgnoreCase("!cmd")){
        
            sendMessage(channel, "@" + sender + " the bot commands are: !time, !snl");
            
        }
        //General Commands - Public Commands
        if (message.equalsIgnoreCase("!time")) {
            
            String time = new java.util.Date().toString();
            sendMessage(channel, "@" + sender + " the local time and date is: " + time);
            
        }
        if (message.equalsIgnoreCase("!snl")){
            
            sendMessage(channel, "@" + sender + " to join Shoot n Loot visit http://shootnloot.com");
            
        }
        //Hidden Commands
        if(message.equalsIgnoreCase("!exit") && sender.equalsIgnoreCase(admin)){
            sendMessage(channel, "Good bye " + sender + ", I'm going to miss you!");
            Runtime.getRuntime().exit(0);           
        } 
        if (message.equalsIgnoreCase("!debug") && sender.equalsIgnoreCase(admin)){
            
            sendMessage(channel, "Channel: " + channel + ", Hostname: " + hostname + ", Login: " + login);
            
        }
        //Ads Commands
        if(message.equalsIgnoreCase("!ads_on") && sender.equalsIgnoreCase(admin)){
            
            ch = new String(channel);
            timer = new Timer();
            timer.schedule( new AdTask(), (timerMinutes*X)*1000);
            timer_check = true;
            
        }
        if(message.equalsIgnoreCase("!ads_off") && sender.equalsIgnoreCase(admin)){
            
            timer_check = false;
            timer.cancel();
            
        }
    }
    
    class AdTask extends TimerTask {
        public void run() {
            
            if(timer_check == true){
            
                Roll();
            
                if(randNumber == 1){
            
                    sendMessage(ch, ad1 );
            
                }else if(randNumber == 2){
            
                    sendMessage(ch, ad2 );
            
                }else if(randNumber == 3){
            
                    sendMessage(ch, ad3 );
            
                }else if(randNumber == 4){
            
                    sendMessage(ch, ad4 );
            
                }else if(randNumber == 5){
            
                    sendMessage(ch, ad5 );
            
                }
            }
            
            timer.schedule( new AdTask(), (timerMinutes*X)*1000);
            randOldNumber = randNumber;
        }
        public void Roll(){
            rand = new Random();
                randNumber = rand.nextInt((5 - 1) + 1) + 1;
                if(randNumber == randOldNumber){
                    randNumber = rand.nextInt((5 - 1) + 1) + 1;
                }else if(randNumber == randOldNumber){
                    randNumber = rand.nextInt((5 - 1) + 1) + 1;
                }
        }
    }
}