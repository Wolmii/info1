# coding: utf-8
""" 
Une classe Python pour creer et manipuler des graphes
"""

from collections import deque
from math import *
import heapq

class Graphe(object):

    def __init__(self, graphe_dict=None):
        """ initialise un objet graphe.
	    Si aucun dictionnaire n'est
	    créé ou donné, on en utilisera un 
	    vide
        """
        if graphe_dict == None:
            graphe_dict = dict()
        self._graphe_dict = graphe_dict

    def aretes(self, sommet):
        """ retourne une liste de toutes les aretes d'un sommet"""
        return self._graphe_dict[sommet]

    def all_sommets(self):
        """ retourne tous les sommets du graphe """
        return set(self._graphe_dict.keys())

    def all_aretes(self):
        """ retourne toutes les aretes du graphe """
        return self.__list_aretes()

    def add_sommet(self, sommet):
        """ Si le "sommet" n'set pas déjà présent
	dans le graphe, on rajoute au dictionnaire 
	une clé "sommet" avec une liste vide pour valeur. 
	Sinon on ne fait rien.
        """
        if sommet not in self._graphe_dict:
            self._graphe_dict[sommet] = []

    def add_arete(self, arete):
        """ l'arete est de  type set, tuple ou list;
            Entre deux sommets il peut y avoir plus
	    d'une arete (multi-graphe)
        """
        arete = set(arete)
        arete1, arete2 = tuple(arete)
        for x, y in [(arete1, arete2), (arete2, arete1)]:
            if x in self._graphe_dict:
                self._graphe_dict[x].add(y)
            else:
                self._graphe_dict[x] = {y}

    def __list_aretes(self):
        """ Methode privée pour récupérer les aretes. 
	    Une arete est un ensemble (set)
            avec un (boucle) ou deux sommets.
        """
        aretes = []
        for sommet in self._graphe_dict:
            for voisin in self._graphe_dict[sommet]:
                if ({voisin, sommet})  not in aretes:
                    aretes.append({sommet, voisin})
        return aretes
    
    def trouve_chaine(self, sommet_dep, sommet_arr, chain=None):
        """ Trouver un chemin élémentaire de sommet_dep à sommet_arr 
            dans le graphe """
        graphe = self._graphe_dict
        if not({sommet_dep,sommet_arr}.issubset(graphe)):
            return None
        if chain == None:
            chain = []
        chain = chain + [sommet_dep]
        if sommet_dep == sommet_arr:
            return chain
        for sommet in graphe[sommet_dep]:
            if sommet not in chain:
                ext_chain = self.trouve_chaine(sommet, sommet_arr, chain)
                if ext_chain: 
                    return ext_chain
        return None
    
    
    def trouve_tous_chaines(self, sommet_dep, sommet_arr, chain=[]):
        """ Trouver tous les chemins élémentaires de sommet_dep à 
            sommet_arr dans le graphe """
        graphe = self._graphe_dict  
        #if ((sommet_dep not in graphe) | (sommet_arr not in graphe)):
        if not({sommet_dep,sommet_arr}.issubset(graphe)):
            return []
        chain = chain + [sommet_dep]
        if sommet_dep == sommet_arr:
            return [chain]
        if sommet_dep not in graphe:
            return []
        chains = []
        for sommet in graphe[sommet_dep]:
            if sommet not in chain:
                ext_chains = self.trouve_tous_chaines(sommet, sommet_arr, chain)
                for c in ext_chains: 
                    chains.append(c)
        return chains    
    def __iter__(self):
        self._iter_obj = iter(self._graphe_dict)
        return self._iter_obj

    def __next__(self):
        """ Pour itérer sur les sommets du graphe """
        return next(self._iter_obj)

    def __str__(self):
        res = "sommets: "
        for k in self._graphe_dict.keys():
            res += str(k) + " "
        res += "\naretes: "
        for arete in self.__list_aretes():
            res += str(arete) + " "
        return res


class Graphe2(Graphe):
    
    def sommet_degre(self, sommet):
        """ renvoie le degre du sommet """
        degre =  len(self._graphe_dict[sommet]) 
        if sommet in self._graphe_dict[sommet]:
            degre += 1 
        return degre

    def trouve_sommet_isole(self):
        """ renvoie la liste des sommets isoles """
        graphe = self._graphe_dict
        isoles = []
        for sommet in graphe:
            if not graphe[sommet]:
                isoles += [sommet]
        return isoles
        
    def Delta(self):
        """ le degre maximum  """
        max = 0
        for sommet in self._graphe_dict:
            sommet_degre = self.sommet_degre(sommet)
            if sommet_degre > max:
                max = sommet_degre
        return max
    
    def list_degres(self):
        """ calcule tous les degres et renvoie un 
	    tuple de degres decroissant
	"""
        degres = []
        for sommet in self._graphe_dict:
            degres.append(self.sommet_degre(sommet))
        degres.sort(reverse=True)
        return degres

def BFS(gra, s):
    s_index=list(gra._graphe_dict.keys()).index(s)
    Q=[s]
    D=[float('inf') for i in gra.all_sommets()]
    D[s_index]=0
    T=[]
    while Q!=[]:
        v=Q.pop(0)
        for w in g.aretes(v):
            w_index=list(gra._graphe_dict.keys()).index(w)
            if D[w_index]==float('inf'):
                v_index=list(gra._graphe_dict.keys()).index(v)
                D[w_index]=D[v_index]+1
                Q.append(w)
                T.append((v, w))
    return(D,T)

def DFS(gra, s):
    s_index=list(gra._graphe_dict.keys()).index(s)
    P=[s]
    D=[float('inf') for i in gra.all_sommets()]
    D[s_index]=0
    T=[]
    while P!=[]:
        v=P.pop(-1)
        for w in g.aretes(v):
            w_index=list(gra._graphe_dict.keys()).index(w)
            if D[w_index]==float('inf'):
                v_index=list(gra._graphe_dict.keys()).index(v)
                P.append(w)
                T.append((v, w))
    return(D,T)


def dijkstra(graphe, s):
    D = {key : float('inf') for key in graphe._graphe_dict.keys()}
    D[s] = 0
    P = {key : -1 for key in graphe._graphe_dict.keys()}
    Q = graphe.all_sommets()
    while Q:
        v = min(Q, key=lambda v: D[v])
        Q.remove(v)
        for u in [u for u in graphe.aretes(v).keys() if u in Q]:
            if D[u] > D[v] + graphe.aretes(v)[u]:
                D[u] = D[v] +graphe.aretes(v)[u]
                P[u] = v
    return (D, P)
    
def  plusCourt(d, P):
    L=[d]
    v=d
    while P[v]!=[]:
        L=L+P[v]
        v=P[v]
    L=L.reverse()
    return L
    

    """def bellmanford(g, s):
        V={g.all_sommet()}
        D=[float(inf) for i in range(len(V))]
        D[s]=0
        P=[]
        for i in V-1:
            for  in E:
                if D[v] > D[u]+ g.aretes(u)[v]:
                    D[v]=D[u]+ g.aretes(u)[v]
                    P[v]=u
        for in E:
            if D[v]>D[u]+g.aretes(u)[v]:
                return print('false')
        return (D, P)"""



graphe = {
"A" :{"C": 1},
"B" : {"C" : 2, "E" : 3},
"C" : {"A" : 1, "B" : 2, "D" : 4, "E" : 2},
"D" : {"C" : 4},
"E" : {"C" : 2, "B" : 3},
"F" : {}
}

g=Graphe(graphe)
"""print(BFS(g, "A"))"""

print(dijkstra(g, "A"))
