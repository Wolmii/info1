from random import randint


def Kmeans(lst : list[tuple], k : int):
    # Initialisation
    n = len(lst[0]) # nombre de dimensions
    clusters = [[] for x in range(k)]
    centroides = [lst[randint(1, len(lst))-1] for x in range(k)]


    # Affectation des points dans chaque cluster
    clusters = doClusters(lst, centroides, k)
   
    # Initialisation d'autres variable
    nb_iteration = 0
    stop = False
    convergence = 0


    # Modification des centroïdes et réaffectation des points dans chaque clusters
    while not stop:
        pre_centres = [[centroides[x]] for x in range(k)] # sauvegarde des anciens centroïdes


        for x in range(len(clusters)):
            # Si le cluster n'est pas vide
            if len(clusters[x]):
                # Calcul du point moyen
                moy = [0 for l in range(n)]
                for pt in clusters[x]:
                    for l in range(n):
                        moy[l] += pt[l]
                moy = [moy[l]//len(clusters[x]) for l in range(n)]


                # Calcul du point le plus proche du point moyen
                proche = 0
                for i in range(len(clusters[x])):
                    d1 = 0
                    d2 = 0
                    for l in range(n):
                        d1 += abs(clusters[x][i][l] - moy[l])
                        d2 += abs(clusters[x][proche][l] - moy[l])
                        if d1 < d2:
                            proche = i
                    clusters[x][proche], centroides[x] = centroides[x], clusters[x][proche]
               
        # Vérification d'une potentielle répétition
        if pre_centres == centroides:
            convergence += 1
       
        # Reaffectation des points dans chaque cluster
        clusters = doClusters(lst, centroides, k)


        # Etude des cas d'arrêt de l'algorithme
        nb_iteration += 1
        stop = convergence >= 3 or nb_iteration > 100000
   
    return (clusters, centroides)






def doClusters(lst, centroides, k):
    # Initialisation
    n = len(lst[0]) # Nombre de dimensions
    clusters = [[] for x in range(k)]


    # Traitement de tous les points de lst
    mini = 0
    for pt in lst:
        if pt not in centroides:
            # Recherche du centroïde le plus proche
            for x in range(k):
                d1 = 0
                d2 = 0
                for l in range(n):
                    d1 += abs(pt[l] - centroides[x][l])
                    d2 += abs(pt[l] - centroides[mini][l])
                if d1 < d2:
                    mini = x
            clusters[mini].append(pt)
   
    return clusters
