READMEEEE


#  CS2 Esports Hub — Database & Java Project

##  About the project

This project is a **CS2 Esports Hub** built with **PostgreSQL + Java (JDBC)**.
The idea is inspired by **HLTV** and **CS2 inventory system**.

The application stores:

* teams
* players
* matches
* tournaments
* articles and tags
* player arsenal (weapons + skins)
* maps from CS2
* analytics (top players, inventories, maps, trends)

---

##  Database design (SQL first)

I started with **database schema**

### Tables created:

* `teams`
* `players`
* `tournaments`
* `matches`
* `articles`
* `tags`
* `article_tags` (many-to-many)
* `weapons`
* `skins`
* `player_inventory` (many-to-many)
* `maps`

### Key database features:

* Primary keys (PK)
* Foreign keys (FK)
* `ON DELETE CASCADE / SET NULL`
* `CHECK` constraints
* `UNIQUE` constraints
* Many-to-many relations
* Real CS2 logic (inventory, skins, maps)

All database structure is defined in **schema.sql**.

---

##  Test data

After creating tables, I added **realistic test data**:

* CS2 teams (Vitality, Furia, Mouz, Spirit, Falcons, FaZe)
* Players (ZywOo,Molodoy,Donk, m0NESY, ropz)
* Matches and tournaments
* CS2 maps (Mirage, Inferno, Nuke, Anubis, Ancient)
* Weapons (AK-47, AWP, M4A1-S, etc.)
* Skins with rarity and market prices

This allows running analytics immediately.

---

##   project setup

Project structure:

* `model` — entities and DTOs
* `repository` — database access (JDBC)
* `service` — business logic & analytics
* `exception` — custom exceptions
* `utils` — database connection
* `Main` — demo controller

---

##  JDBC & PreparedStatement

All database access uses **PreparedStatement**, not Statement.

Why:

* safer (no SQL injection)
* cleaner code
* professional approach

Each repository:

* opens connection
* executes SQL
* maps ResultSet to objects
* closes resources automatically

---

##  Business logic (Service layer)

Implemented logic such as:

* Top teams by rating
* Top players by rating
* K/D calculation
* Trending tags (GROUP BY + COUNT)
* Inventory value calculation
* Most played CS2 maps
* Player arsenal view (skins + weapons)



---

## Player Arsenal 

Each player has an inventory:

* weapons
* skins
* rarity
* quantity
* market price

Relations:

* Player ↔ Skin = many-to-many (`player_inventory`)
* Skin ↔ Weapon = many-to-one

### Features:

* show all skins of a player
* calculate total inventory value
* top players by inventory value


---

##  Maps analytics

Added CS2 maps and linked them to matches.

Analytics:

* most played maps
* map usage statistics


---

##   Custom Exceptions

Created custom exceptions:

* `InvalidInputException`
* `ResourceNotFoundException`
* `DuplicateResourceException`
* `DatabaseOperationException`

Why:

* separate business errors from SQL errors
* cleaner code
* easier debugging

---

##  Main 

`Main.java` demonstrates:

* database connection
* teams and players output
* top teams & players
* matches with maps
* articles and trends
* player inventory and arsenal
* analytics results



---

## Git Commit History 

1. `init project and database schema`
2. `add PostgreSQL JDBC connection`
3. `add team entity and repository`
4. `add player and match repositories`
5. `add service layer analytics`
6. `add articles and trending tags`
7. `add cs2 arsenal inventory and map analytics`
8. `add custom exception handling layer`
9. `add player inventory view with skins`
10. `finalize main demo and documentation`


---

##  What I learned

* Designing relational databases
* Using foreign keys and many-to-many relations
* Working with JDBC and PreparedStatement
* Layered architecture
* Writing analytics queries
* Connecting SQL logic with Java services
* Structuring a real backend project

---

##  Final note

This project combines:

* databases
* Java backend
* CS2 esports logic
* analytics


---

##  How to run

1. Create database in PostgreSQL
2. Run `schema.sql`
3. Open project in IntelliJ
4. Run `Main.java`


