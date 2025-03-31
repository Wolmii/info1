from math import *


# calcul de la distance
def Distance(p, list1, list2):
   res=0
   if p==1:
       for i in range(len(list1)):
           res+=abs(list1[i]-list2[i])
       return res
   elif p==2:
       for i in range(len(list1)):
           res+=(list1[i]-list2[i])**2
       res=sqrt(res)
       return res
   elif p>= float('inf'):
       return max([list1[i] - list2[i] for i in range(len(list1))])
   else:
       for i in range(len(list1)):
           res+=abs(list1[i]-list2[i])**p
       res=res**(1/p)
       return res


# KNN
def knn(donnees, data, k, p, choix):
   distances=[]
   nb_donnee=len(donnees)


   for donnee_id in range(nb_donnee):
       distances.append((donnee_id, Distance(p, data[0], donnees[donnee_id][0])))
  
   distances.sort(key=lambda x: x[1])
  
   # choix est ce que l'utilisateur choisi comme chose a faire
   for donnee_id in range(k):
       if choix=='reg':
           regression=0
           regression+=distances[donnee_id][0]
           regression=regression / k
           return regression


       elif choix=='cla':
           classification_dict = dict()
           classification_dict[donnees[distances[donnee_id][0]][1]] = classification_dict.setdefault(donnees[distances[donnee_id][0]][1], 0) + 1
           classification=max(classification_dict, key = classification_dict.get)
           return classification