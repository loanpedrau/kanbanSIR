## Installation


## BDD

localhost:3306

1. Créer une base : mydatabase
2. Avec username : root et mdp : root

Actuellement dans le persistence.xml :

	database : mydatabase
	username : root
	password : root

Ou adapter en fonction de la configuration de sa base de donnée mysql, le fichier persistence.xml..

## Versions utilisées

Java : jdk-14.0.1

MySql : 8.0.18 for Win64 on x86_64 (MySQL Community Server - GPL)

## Lancement

Lancer la classe java :  RestServer.java

## Accès swagger

Swagger : http://localhost:8080/api/

Depuis swagger vous avez la possibilité de tester notre API, ce qui a été mis en place

## Quelques explications

Ce TP5 reprend les classes du TP2-4 pour créer le back-end de l'application Kanban.
Nous retrouvons dans les packages :
+ generic les DAO
+ domain les Entités
+ rest les endpoint avec les méthodes associées

Divers type de requêtes ont étés mises en place : 

+ requêtes nomées (allUsers, allUsersByName & allUsersByEmail)
+ requêtes avec paramètres (allUsersByName & allUsersByEmail)
+ requêtes simples (ex : /users/all , /kanban/all , etc... )
+ requêtes avec l'héritage (ex : /users/admins, qui va récupérer tous les Admins (sous-type de Utilisateur) )

Au niveau des DAO ceux ou il y a eu l'ajout de méthodes personnalisés :
FicheDAO et UtilisateurDAO

Mise en place de l'héritage : Admin hérite d'Utilisateur

Pour chaque ressource possibilité via l'api de faire un GET (ALL) pour tous les récupérer et un POST pour en ajouter un.

