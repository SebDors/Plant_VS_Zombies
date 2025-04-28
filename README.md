# Plants vs Zombies - Clone Java

Une implémentation du célèbre jeu Plants vs Zombies en Java, réalisée dans le cadre d'un projet académique.

## 🎮 Présentation du projet

Ce projet est un clone du jeu Plants vs Zombies développé en Java avec Spring. Le jeu reprend les mécaniques principales du jeu original où le joueur doit défendre son jardin contre des vagues de zombies en plaçant stratégiquement des plantes.

## 🚀 Installation

1. Clonez le repository :

```bash
git clone [url-du-repo]
```

2. Assurez-vous d'avoir Java 17+ et Maven installés
3. Compilez le projet :

```bash
mvn clean install
```

## 🏃‍♂️ Lancement du jeu

1. Exécutez le fichier JAR généré :

```bash
java -jar target/PVZ-1.0.jar
```

## 🎯 Fonctionnalités

- Système de placement de plantes sur une grille
- Différents types de plantes avec des capacités uniques
- Gestion des vagues de zombies
- Système de soleil comme ressource
- Sauvegarde des scores
- Interface graphique intuitive

## 🛠 Technologies utilisées

- Java 17+
- Spring Framework
- Maven
- JUnit 5 pour les tests
- Base de données (H2/MySQL)

## 📝 Structure du projet

```
src/
├── main/
│   ├── java/
│   │   └── com/epf/
│   │       ├── Core/          # Logique métier
│   │       ├── Persistance/   # Couche de données
│   │       └── UI/            # Interface utilisateur
│   └── resources/            # Ressources (images, config)
└── test/                    # Tests unitaires
```

## 🤝 Contribution

Les contributions sont les bienvenues ! N'hésitez pas à :

1. Fork le projet
2. Créer une branche pour votre fonctionnalité
3. Commit vos changements
4. Push sur votre branche
5. Ouvrir une Pull Request
