CS2 Esports Hub — Database & Java Project
About the project

This project is a CS2 Esports Hub built with PostgreSQL + Java (JDBC).
The idea is inspired by HLTV and the CS2 inventory system.

The application stores:

teams

players

matches

tournaments

articles and tags

player arsenal (weapons + skins)

maps from CS2

analytics (top players, inventories, maps, trends)

Database design (SQL first)

The project was started from database design.

Tables created:

teams

players

tournaments

matches

articles

tags

article_tags (many-to-many)

weapons

skins

player_inventory (many-to-many)

maps

Key database features:

Primary keys (PK)

Foreign keys (FK)

ON DELETE CASCADE / SET NULL

CHECK constraints

UNIQUE constraints

Many-to-many relations

Real CS2 logic (inventory, skins, maps)

All database structure is defined in schema.sql.

Test data

After creating tables, realistic test data was added:

CS2 teams (Vitality, Furia, Mouz, Spirit, Falcons, FaZe)

Players (ZywOo, molodoy, donk, m0NESY, ropz)

Matches and tournaments

CS2 maps (Mirage, Inferno, Nuke, Anubis, Ancient)

Weapons (AK-47, AWP, M4A1-S, etc.)

Skins with rarity and market prices

This allows running analytics immediately without manual inserts.

Project setup

Project structure:

model — entities and DTOs

repository — database access (JDBC)

service — business logic & analytics

exception — custom exceptions

utils — database connection & helpers

Main — demo controller

JDBC & PreparedStatement

All database access uses PreparedStatement, not Statement.

Why:

safer (SQL injection protection)

cleaner code

professional JDBC usage

Each repository:

opens connection

executes SQL

maps ResultSet to objects

closes resources automatically

Business logic (Service layer)

The service layer implements analytics such as:

Top teams by rating

Top players by rating

K/D calculation

Trending tags (GROUP BY + COUNT)

Inventory value calculation

Most played CS2 maps

Player arsenal view (skins + weapons)

Player Arsenal

Each player has an inventory:

weapons

skins

rarity

quantity

market price

Relations:

Player ↔ Skin = many-to-many (player_inventory)

Skin ↔ Weapon = many-to-one

Features:

show all skins of a player

calculate total inventory value

top players by inventory value

Maps analytics

CS2 maps are stored and linked to matches.

Analytics:

most played maps

map usage statistics

Custom Exceptions

Custom exceptions were created:

InvalidInputException

ResourceNotFoundException

DuplicateResourceException

DatabaseOperationException

Purpose:

separate business logic errors from SQL errors

cleaner service layer

easier debugging

OOP Enhancements (Assignment 4)

As part of Assignment 4, the existing project was extended, not rewritten, with additional OOP features.

Abstract class and inheritance

The project already contained article functionality.
For Assignment 4, it was refactored using abstraction and polymorphism:

Article was redesigned as an abstract base class

It defines:

two abstract methods

one concrete method shared by all articles

Two concrete subclasses were introduced:

CS2Article

MatchArticle

This allows working with articles through the base Article type while creating specific implementations.

Interfaces

Two interfaces were added to demonstrate interface usage:

Printable

abstract method

default method

static utility method

Validatable<T>

abstract validation method

default validation logic

static helper method

These interfaces are implemented by domain classes and demonstrated in Main.

Generics

Generics are used to avoid duplicated repository logic:

BaseRepository<T> defines common CRUD operations

Concrete repositories extend it:

TeamRepository

PlayerRepository

This demonstrates reusable, type-safe data access logic.

Lambdas and Stream API

The Stream API is used in the service layer for:

sorting players and teams

filtering top results

aggregating analytics data

Reflection (RTTI)

Java Reflection API is used to inspect runtime class information:

class name

fields

methods

A utility class demonstrates RTTI usage during application execution.

Main

Main.java demonstrates:

database connection

teams and players output

top teams & players

matches with maps

articles and trends

player inventory and arsenal

analytics results

OOP features (interfaces, polymorphism, reflection)

Git Commit History

init project and database schema

add PostgreSQL JDBC connection

add team entity and repository

add player and match repositories

add service layer analytics

add articles and trending tags

add CS2 arsenal inventory and map analytics

add custom exception handling layer

add player inventory view with skins

refactor article model with abstraction and inheritance

add interfaces and generics support

add reflection and assignment 4 enhancements

finalize main demo and documentation

What I learned

Designing relational databases

Using foreign keys and many-to-many relations

Working with JDBC and PreparedStatement

Layered architecture

Writing analytics queries

Applying OOP principles (abstraction, inheritance, polymorphism)

Using generics, interfaces, lambdas and reflection

Structuring a real backend project

How to run

Create database in PostgreSQL

Run schema.sql

Open project in IntelliJ IDEA

Run Main.java
