## Installation


## BDD

localhost:3306

1. Cr�er une base : mydatabase
2. Avec username : root et mdp : root

Actuellement dans le persistence.xml :

	database : mydatabase
	username : root
	password : root

Ou adapter en fonction de la configuration de sa base de donn�e mysql, le fichier persistence.xml..

## Versions utilis�es

Java : jdk-14.0.1

MySql : 8.0.18 for Win64 on x86_64 (MySQL Community Server - GPL)

## Lancement

Lancer la classe java :  RestServer.java

## Acc�s swagger

Swagger : http://localhost:8080/api/

Depuis swagger vous avez la possibilit� de tester notre API, ce qui a �t� mis en place

## Quelques explications

Ce TP5 reprend les classes du TP2-4 pour cr�er le back-end de l'application Kanban.
Nous retrouvons dans les packages :
+ generic les DAO
+ domain les Entit�s
+ rest les endpoint avec les m�thodes associ�es

Divers type de requ�tes ont �t�s mises en place : 

+ requ�tes nom�es (allUsers, allUsersByName & allUsersByEmail)
+ requ�tes avec param�tres (allUsersByName & allUsersByEmail)
+ requ�tes simples (ex : /users/all , /kanban/all , etc... )
+ requ�tes avec l'h�ritage (ex : /users/admins, qui va r�cup�rer tous les Admins (sous-type de Utilisateur) )

Au niveau des DAO ceux ou il y a eu l'ajout de m�thodes personnalis�s :
FicheDAO et UtilisateurDAO

Mise en place de l'h�ritage : Admin h�rite d'Utilisateur

Pour chaque ressource possibilit� via l'api de faire un GET (ALL) pour tous les r�cup�rer et un POST pour en ajouter un.

