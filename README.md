# TXT RPG
This project is a framework for a text based roleplaying game.
The framework is to this day not finished, it still misses some basic functionality.
The end goal of this framework is to have a very flexible base that can be used to everything between creating a D&D clone to a new text based elderscrolls game!


I started on this project with about 3 months of programming experience, and the bulk of the program was written in during the first 6 weeks.
Most of the code I wrote in the start is now fortunately refurbished and refactored away, but some of it still lingers and parts of the project in general could need some refurbishing or refactoring.



### The framework contains

* 14 Different commands
	* Attack
	* Back
	* Charactersheet
	* Drop
	* Equip
	* Equipment
	* Go
	* Help
	* Inventory
	* Look
	* Take
	* Unequip
	* Use
	* Quit 

* Flexible attribute system, which can easily by changed and extended on.
	* Dependant Attributes - These can easily be modified to fit nearly all types of systems.
		* Initiative, dependent on Dexterity and Intelligence (this can easily modified).
		* Carry Capacity, dependent on Strength and Vitality  (also easiliy modified).
	* Allows both permanent buffs, and temporary buffs (and ofc debuffs).

* Items
	* Equipable items with multiple item slots. 
		* 2 Rands slots
			* For dual wielding and 2-handed weapons.
		* 2 Ring slots		
		* Amulet
		* Chest
		* Helm
		* Gloves 
		* Pants
		* Shoulder
	* Consumeable items, 

* Enchanted Items, with a very flexible enchanting system (not ingame enchanting + needs a bit of refactoring).
  One item can contain multiple of these magical effects at once:	
	* OnHitMagic - Both permanent and temporary effects.
	* OnUseMagic - Both permanent and temporary effects.
	* Passive buffs - Only permanent effects.

* Enemies can be created dynamicly by an factory pattern.


### The framework most noticeably lack
* Leveling-system
* Currency
* Merchant/Shop
* Spellbook-system, there are already spells bound to items, so this shouldn't be too hard to implement.
* Quest-system.
* Probably a lot more!

  
### Not properly integrated yet
* Armor, atm its just a number.
* Mana, also just a number due to lack of spells.
* Probably other things that I cant remember atm!

