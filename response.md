What we refactored and why we refactored it.

-We broke down the runMelee method in ClanMelee because it was a very long method. 
We broke it down into 6 'sub-methods' that make the code easier to understand
as well as cleaner.

-We combined the ClanMeleeConstants and ClanMelee because ClanMeleeConstants was only being used 
in ClanMember. So we took the instance variables from ClanMeleeConstants and put them into ClanMelee.
And integrated ClanMember to use ClanMelee instead of ClanMeleeConstants. Now there is one less uncessary class. 