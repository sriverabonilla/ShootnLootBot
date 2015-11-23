import org.jibble.pircbot.*;
import java.util.*;


public class SnLBotMain {
        
    public static void main(String[] args) throws Exception {
         // Start up the configuration manager
         BotConf conf = new BotConf();
                
        // Now start our bot up.
        SnLBot bot = new SnLBot();
        
        // Enable debugging output.
        bot.setVerbose(true);
        
        // Connect to the IRC server.
        bot.connect("irc.twitch.tv", 6667, conf.Oauth());

        // Join the #pircbot channel.
        bot.joinChannel("#" + conf.Channel());
        
    }
    
}