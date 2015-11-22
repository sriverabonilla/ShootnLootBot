import org.jibble.pircbot.*;

public class SnLBotMain {
        
    public static void main(String[] args) throws Exception {
         // Start up the configuration manager
         BotConf conf = new BotConf();
                
        // Now start our bot up.
        SnLBot bot = new SnLBot(conf.Nickname(),conf.Ad1(), conf.Ad2(), conf.Ad3(), conf.Ad4(), conf.Ad5(), conf.Admin());
        
        // Enable debugging output.
        bot.setVerbose(true);
        
        // Connect to the IRC server.
        bot.connect("irc.twitch.tv", 6667, conf.Oauth());

        // Join the #pircbot channel.
        bot.joinChannel("#" + conf.Channel());
        
    }
    
}