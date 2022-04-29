# BoatClub
In short this project is about creating a member registry for a boat club. The application should be runnable as a simple console application with a menu and the information in the registry should be loaded and saved to a file.

Project tasks:
1.You should be able to create a new member. A member has a name, and an optional email adress.

If the member has an email adress it must be unique (two different members cannot have the same email adress)
When a member is created the member is assigned a new unique random 6 character alpha numeric member id. This id must be unique and no other member in the registry should be able to get the same id.


2.You should be able to list all members.
3.You should be able to select a particular member see the detailed information about the member. You should then be able to:

4.delete the member
5.add a new boat. A boat has a name, type (sailboat, motorboat, motorsailer, or canoe). Depending on the type there is different information needed:
    Sailboat: lenght in meter, depth in meter.
    Motorboat: length in meter, engine power in horse powers.
    Motorsailer: length in meter, depth in meter, engine power in horse powers.
    Canoe: lenght in meter.

6.Select a boat and see the detailed information about the boat. You should then be able to:
7.delete the boat
8.You should be able to quit the application
9.The registry information should be loaded from a file registry.data when the application starts.
10. The registry information should be saved to a file registry.data when the application exits.
