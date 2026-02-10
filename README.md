# Calculator LMU - Outil de Stratégie d'Endurance

**Calculator LMU** est un outil avancé d'aide à la décision conçu pour les pilotes et ingénieurs de course sur le jeu *Le Mans Ultimate*. Ce logiciel permet d'optimiser les stratégies d'endurance en calculant avec précision la consommation de carburant et d'énergie, ainsi que la planification des arrêts aux stands.

## 🎯 Objectifs

L'objectif principal de cet outil est de fournir des données fiables pour :
*   Calculer la consommation de carburant ou d'énergie en temps réel au cours d'une épreuve d'endurance.
*   Estimer le nombre de tours restants avant le prochain ravitaillement.
*   Optimiser la stratégie de course pour maximiser la performance sur la durée.
*   Comparer les performances théoriques avec les résultats observés en course.

## 🚀 Fonctionnalités Clés

*   **Calcul de Consommation** : Estimation précise de la consommation de carburant et d'énergie par tour.
*   **Planification des Arrêts** : Détermination du moment optimal pour ravitailler (Fuel/Energy).
*   **Gestion des Catégories** : Prise en charge de différentes catégories de véhicules, notamment les prototypes **LMP2** et **LMP3**.
*   **Suivi Chronométrique** : Intégration des temps au tour et du temps restant de course.
*   **Observations Réelles** : Possibilité de confronter les calculs théoriques aux données issues d'observations en situation réelle (voir dossier `Observation`).

## 🛠️ Prérequis

Pour utiliser ce projet, vous devez disposer de l'environnement suivant :
*   **Java Development Kit (JDK)** version 8 ou supérieure.
*   Un terminal de commande (PowerShell, Bash, ou CMD).

## 📦 Installation

1.  Clonez ce dépôt ou téléchargez les fichiers sources.
    ```bash
    git clone https://github.com/votre-utilisateur/calculator_lmu.git
    cd calculator_lmu/calculator_lmu-main
    ```

2.  Compilez les fichiers sources Java.
    Assurez-vous d'être dans le répertoire racine du code source (là où se trouve `main.java`).
    ```bash
    javac main.java *.java */*.java
    ```

## 💻 Utilisation

Pour lancer l'application et visualiser les données simulées :

```bash
java main
```

### Modification des Paramètres de Simulation

Actuellement, les paramètres de la simulation (temps de course, consommation, chrono de référence) sont définis directement dans le fichier `main.java`. Pour adapter la simulation à une nouvelle course :

1.  Ouvrez le fichier `main.java`.
2.  Modifiez les instances des objets `Chrono` (temps au tour) et `Timer` (durée de la course).
3.  Recompilez et relancez le programme pour obtenir les nouvelles estimations.

## 📂 Architecture du Projet

Le code source est organisé de manière modulaire pour faciliter la maintenance et l'évolution :

*   **`Temps/`** : Gestion du temps, des chronomètres et des timers.
*   **`bibliotheque/`** : Structures de données et définitions des catégories de véhicules.
*   **`calculator/`** : Logique métier pour les calculs de consommation et d'énergie.
*   **`Central_Service.java`** : Service central orchestrant les calculs et les interactions entre les modules.
*   **`Observation/`** : Dossier contenant des comparaisons entre les calculs théoriques et les données réelles de course (format Markdown).

## 📝 Observations

Le projet inclut une section dédiée aux retours d'expérience. Le dossier `Observation` contient des analyses post-course comparant les prédictions du logiciel avec le déroulement réel des épreuves d'endurance. Ces données permettent d'affiner continuellement les algorithmes de calcul.

## Ajout prévu 

* **Peaufinage de la mécanique des arrêts au stand** : Cela permettra de faire des prédictions plus poussée et plus précise.
* **Simulation de Pneu** : Intégré une simulation des pneus dans le logiciel
* **De vrai donnée par défaut pour les Chronos et la conso.** : Objectif sur la durée en fonction des événements.

---
