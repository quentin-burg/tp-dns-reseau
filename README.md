## Quentin Burg et Alan Menit


## Remarques

Nous n'avons pas réussi à isoler l'adresse IP dans la trame que l'on récupère car elle n'y est pas. 
Pourtant quand je lance nslookup et wireshark, je vois qu'il y a plusieurs requetes DNS qui s'enchainent
pour pouvoir récupérer l'adresse IP. J'ai mis pourtant le flag "requete récursive" à 1 dans notre en-tête de requête DNS.