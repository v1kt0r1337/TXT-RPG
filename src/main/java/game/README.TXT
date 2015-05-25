Project: TXT RPG
Authors: Viktor Setervang

This project is ment to become a text based RPG. I want to have a good framework before I start implementing content.
Hopefully I won't tire of this project before atleast the framework is finished.

This project was in start made on the framework of the project World of Zhuul on chapter 6 in the book "Objects first with Java".
Later on some of the programming logic has also been influenced by lever-oblig3, made by Even AAby Larsen, especially the Command-system and the "world package".

The Attribute system has been inspired by http://gamedevelopment.tutsplus.com/tutorials/using-the-d-for-an-rpg-attributes-system--gamedev-243
And the EnemyFactory system by http://www.newthinktank.com/2012/09/factory-design-pattern-tutorial/


TOP PRIOTITY:


Refactoring the Character class and perhaps Game class.
The Character class contains tons of logic regarding droping items, equiping items etc... This need to be put into the respective command
classes. The end goal for the Character class should perhaps be close to a character sheet with a few extra methods.




IMPLEMENTATION LIST:


NPCs should perhaps be built by the component system http://en.wikipedia.org/wiki/Entity_component_system  ("the game dev craze")



Ideas Soon To Be Implemented:

1. Entity->Character-Monster/NPC/Player hiearki

Look these design patters at: Factory design, Builder design, Decorator design, Composite design.

         Perhaps combinations?
         http://www.oodesign.com/
         
         Eks med Composite design for character creation:
         http://gamedevelopment.tutsplus.com/tutorials/using-the-d-for-an-rpg-attributes-system--gamedev-243
         
         Eks med factory design for random monster (se også abstract factory).
         https://www.youtube.com/watch?v=cDF5tyiamww


Ideas That Will Be Implemented Later On: (in no particular order).


1. Monsters made by the factory design prinsip.
2. Some kind of time system. 
   One way to do this:
   A counter that goes up for every certain type of command, some command can take more time like 
   go west (changing location), while a use command can take less time. f.ex use bow  will increase counter by +1, go west will increase counter by +5.
   Some zones should perhaps be reinstatiated after a certain amount of time, while other not, same with NPCs. 
   F.ex Main City, never reinstantiated, zone1-3 reinstatiated every 50 turn, zone 4-6 every 100 turn, a certain NPC every 100 turn.
   
   Possible pitfall, how will this effect the player and the zone he is currently in? How will the "back" command work in this case? 
   How will a teleport spell handle this? Should it take u back to the original object, or to the new object? 
   
3. Implement "Simplified BlackJack-v3" into the game! Perhaps an NPC you can meet can play blackjack, his money wallet will reset every 100 turn.
 
4. Implement a soundtrack player, perhaps changing music depending on location? Different clusters of locations got different music? Perhaps later on other sounds could also be implemented, like "go" sound.





Bug list so far (unfixed):

The enemy sometimes attacks first even though the scored a lower initiative roll.


The class FinalBonus is not working, if I want it work the way it's made now then I have to give the 
constructor the "parent" attribute as a param or something similiar.

Need better text formating in print outs. Some text feels "clustered".
Would perhaps be smart to change most of the prints to return back as Strings, then print them out on the first method that calls for them?


Possible OOP flaws:

Spell system need to change according to the new attribute class system.
currently a cheat fix in the Commando Use class, but this should not be permanent! 



Possible things to improve OOP later on:


How to implement equipment:

I want to differantiate from equiped items and not equiped items.
Perhaps dividing into 3 different storages, "Equiped items", "inventory" and "town stash".
inventory and town stash could perhaps be same class or atleast sharing same super class, main difference is that town stash is not always accessible and 
doesnt affect the weight capacity.

Equiped items can give certain stats to the wearer, items in inventory or "town stash" will not give these stats. 


I want different item slots that the "Equiped" can store (weapon, helm, rings etc..)

One way is to use subclasses of each item type or item slot.

Item slots: 
Weapon/hand: two weapon slots, either two 1h weapons, one 1h weapon and a shield, or one 2h weapon. 
                   Allow two shields? (perhaps for some weirdass spellcaster? Shieldbash? Thorns?)
                   Torsoe/chest: one slot.
                   
Shoulder?: one or two slots, aka different shoulderpads. think il settle for 1.
Helm: one slot.
Legs/Pants: one slot.
Ring: two ring slots.
Amulet: one amulet slot.
gloves: one or two slots+, perhaps enforce matching gloves with only one slot?
boots: Perhaps same as gloves? Although two different boots makes even less sense and is actually a hinderance irl.

Cape slot?
Multiple weapon sets? Perhaps an extra one for ranged weapons.


Some of the subclasses will be so similiar that there might not be a point?
Perhaps 4 different subclasses, "HandHeldItems", Armor, Accessories, UseAbles(with isConsumable as a field, and perhaps charges? with 1 charge as the norm).


