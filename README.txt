~SnL Bot Alpha 1~ by Samuel R Rivera | pircbot.jar is CCL3.0 and this project is NOT FOR PROFIT
To run the Bot you are going to need Java and the latest release of pircbot.jar at the root of the folder. 

The contents of the folder need to include the following items:
-Folder: conf > admin.txt, ads.txt, snl.txt
-Files: BotConf.class, SnLBot.class, SnLBotMain.class, SnLBot$AdTask.class

Bot Configuration:
All the configuration files can be found on the on the "conf" folder. Each file needs to keep it's formating for the Bot to work properly. The ";" symbol is used as a separator.

-admins.txt format
admintwitchtvname;

-For Example:
samzombi;

-Rules:
Only 1 admin per bot.

-snl.txt format
password;channel;nickname

-For example:
oauth:XxXxXxXxXxXxXxXxX;samzombi;snl_bot

-Rules:
The password must be on oauth format, this can be obtain using twitchapps.com. The channel is the name of the user streaming. The nickname is the name of the twitch account belonging to your bot.

-ads.txt format
ad1;ad2;ad3;ad4;ad5;

-For example:
Buy this delicious chicken @ wallyworld!;Love me some cake!;Raid @ 10pm;Tacos and burritos;Raid Weekly Rules!;

-Rules:
You can only ad 5 ads

Launching the Bot
-Open the folder and "shift" + "right mouse click", and from the pop up menu select "Open command window here".
-On the command window type "java -classpath pircbot.jar;. SnLBotMain"

Bot commands
!cmd
Displays all the commands available to users.

!time
Displays the local time. (The time of the computer where the bot is running)

!snl
Displays recruting information for the Destiny Clan Shoot N Loot.

Hidden bot commands (only the admin can execute this commands)
!exit
Exits the bot.(You will need to re launch the bot manually)

!ads_on or !ads_off
Toggles the ads on and off.