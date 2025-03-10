# Projet PVZ (Plants vs Zombies)

## Description
Application Java inspirée du jeu Plants vs Zombies, utilisant Spring JDBC pour la gestion de la base de données.

## Prérequis
- Java JDK 17 ou supérieur
- MySQL Server
- Maven

## Configuration Base de données
1. Créer une base de données MySQL nommée `pvz`
2. Créer un utilisateur MySQL :
   ```sql
   CREATE USER 'epf'@'localhost' IDENTIFIED BY 'admin';
   GRANT ALL PRIVILEGES ON pvz.* TO 'epf'@'localhost';
   FLUSH PRIVILEGES;
   ```

## Installation
1. Cloner le projet
2. Configurer la base de données comme indiqué ci-dessus
3. Compiler le projet avec Maven :
   ```bash
   mvn clean install
   ```

## Exécution
Lancer l'application via la classe Main :
```bash
mvn exec:java -Dexec.mainClass="com.epf.Main"
```

## Structure du Projet
- `src/main/java/com/epf/Main.java` : Point d'entrée de l'application
- `src/main/java/com/epf/Persistance/ConfigBDD.java` : Configuration de la base de données
