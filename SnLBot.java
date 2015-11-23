import org.jibble.pircbot.*;
import java.util.*;
import java.io.*;


public class SnLBot extends PircBot {
    
    Timer timer;
    String ch, ad1, ad2, ad3, ad4, ad5, admin, lastSender;
    boolean timer_check = false;
    int randNumber, randOldNumber = 0, timerMinutes = 5, X = 60;
    Random rand;
    BotConf conf = new BotConf();
            
    public SnLBot() throws IOException { 
        ch = conf.Channel();
        ad1 = conf.Ad1(); ad2 = conf.Ad2(); ad3 = conf.Ad3(); ad4 = conf.Ad4(); ad5 = conf.Ad5(); admin = conf.Admin();
        this.setName(conf.Nickname());
        
    }
    public void onJoin(String channel, String sender, String login, String hostname){
        if(lastSender != sender){
        sendMessage(channel, "Welcome to " + channel + "'s channel "+ sender +". Have fun, and enjoy the stream!");
        }
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
        //Admin Commands Only
        if(sender.equalsIgnoreCase(admin)){
            //Hidden Commands
            if(message.equalsIgnoreCase("!exit") && sender.equalsIgnoreCase(admin)){
                sendMessage(channel, "Good bye " + sender + ", I'm going to miss you!");
                Runtime.getRuntime().exit(0);           
            } 
            if (message.equalsIgnoreCase("!debug") && sender.equalsIgnoreCase(admin)){
            
                sendMessage(channel, "Channel: " + channel + ", Hostname: " + hostname + ", Login: " + login);
            
            }
            //Ads Commands
            if(message.equalsIgnoreCase("!ads on")){
            
                timer = new Timer();
                timer.schedule( new AdTask(), (timerMinutes*X)*1000);
                timer_check = true;
                sendMessage(channel, "Ads are enabled.");
            
            }
            if(message.equalsIgnoreCase("!ads off") && sender.equalsIgnoreCase(admin)){
            
                timer_check = false;
                timer.cancel();
                sendMessage(channel, "Ads are disabled.");
            
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