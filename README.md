# java-jdbc-CRUD

l'objectif est de realiser les operations d'insertion , de lecture , de mise a jour et de suppression (CRUD)
dans une base de donnee a l'aide du JDBC.

Le fichier script.sql contient trois tables , la table Etudiant , la table Moduule et la table EtudiantModule.
on s'est baser sur l'hypothese suivante: un etudiant peut etudier plusieur modules et un module peut etre suivie
par plusieur etudiants , raison pour laquelle il ya la table intermediaire (EtudiantModule).

Le fichier config.properties contient les configurations pour se connecter a la base de donnee mysql.
Si on veut un jour changer notre base de donnee en Postgres ou sqlServer , c'est principalement le fichier
config.properties qu'on va modifier aulieu de modifier les fichiers .java

Les testes unitaire on ete realiser avec Junit integre dans eclipse.
