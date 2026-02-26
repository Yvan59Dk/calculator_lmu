# Observations 

## Branch WorkCalculTour : last commit => "Amélioration Modularité"
## 26/02/26 : pré 12h du Mans => 0.2.05

- **CORRIGE : Problème d'arrêt au stand** : La voiture rentre un tour trop tôt par rapport à ce qui était prévu. Au lieu de rentrer lorsque le carburant actuel est inférieur à la conso, il s'arrête avant.
![Exemple](image/260226_post12hMans_DonneeStand.png)
    - *Note de post-patch : c'était un mauvais choix de conditions pour les arrêts au stands, il prennais la valeur de conso au lieu d'un bon vieux 0 pour provoquer un arrêt*

- **CORRIGE : Stand doublé en fin de course** : La voiture rentre deux fois au stand à la fin de la course, augmentant les chronos et faussant les fins de prédiction.
![Exemple](image/260226_post12hMans_StandFin.png)

- **Rythme pas réaliste** : Un point a été relevée lors de la stratégie, c'est que l'algorithme ne prend pas en considération la dégradation des pneus et donc, son influance sur les temps au tour. Par exemple, avec des pneus neud, je suis en ```3:28:450``` de rhythme de course mais rapidement avec des pneux à 85%, je tombe en ```3:30:100```, chose que ne prend pas en compte l'algo. 
    - *Note : ceci n'est réglable QUE en rajoutant la mécanique des pneux à l'algo, ce qui ve prend du temps.*
    - *Solution temporaire envisagé : augmentation arbitraire, ce que je n'aime pas*