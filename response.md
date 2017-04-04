What we refactored and why we refactored it.

-We broke down the runMelee method in ClanMelee because it was a very long method. 
We broke it down into 6 'sub-methods' that make the code easier to understand
as well as cleaner.

-We combined the ClanMeleeConstants and ClanMelee because ClanMeleeConstants was only being used 
in ClanMember. So we took the instance variables from ClanMeleeConstants and put them into ClanMelee.
And integrated ClanMember to use ClanMelee instead of ClanMeleeConstants. Now there is one less unnecessary class. 

-We changed the name of the ClansWins class to TotalWinsOfClans to make the code easier to read and understand.
Although this does not have to do with refactoring, it makes the code a lot more understandable and avoids the
confusion when talking about ClanWins and ClansWins.