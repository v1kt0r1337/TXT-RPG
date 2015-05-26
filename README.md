# TXT RPG
This project is ment to be a framework for text based roleplaying game.
It uses a turn based time system, the character that gets to act first during interaction is the character that rolls the highest initiative score.

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

* Flexible attribute system, which can easily by changed and extended on to fit nearly any system.
* Base Attributes
	* Strength
	* Dexterity
	* Intelligence
	* Vitality
* Dependant Attributes, these are calculated on the values of the Base Attributes
		* Initiative - dependent on Dexterity and Intelligence.
		* Carry Capacity - dependent on Strength and Vitality.
		* Health - dependent on Vitality
		* Mana - dependent on Intelligence
* Allows both permanent buffs, and temporary buffs (and ofc debuffs).

* Items
	* Equipable items with multiple item slots. 
		* 2 Rands slots
			* Dual wielding and 2-handed weapons is implemented.
		* 2 Ring slots		
		* Amulet
		* Chest
		* Helm
		* Gloves 
		* Pants
		* Shoulder
	* Consumeable items 

* Enchanted Items - with a very flexible enchanting system (not ingame enchanting + needs a bit of refactoring).
  One item can contain multiple of these magical effects at once:	
	* OnHitMagic - Both permanent and temporary effects.
	* OnUseMagic - Both permanent and temporary effects.
	* Passive buffs - Only permanent effects.

* Enemies can be created dynamicly by a factory pattern.


### The framework most noticeably lack
* Leveling-system
* Currency
* Merchant/Shop
* Spellbook-system - there are already spells bound to items, so this shouldn't be too hard to implement.
* Quest-system.
* Probably a lot more!

  
### Not properly integrated yet
* Armor - atm its just a number.
* Mana - also just a number due to lack of spells.
* Probably other things that I cant remember atm!

