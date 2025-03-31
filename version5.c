#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <fcntl.h>
#include <termios.h>
#include <stdbool.h>
#include <time.h>

#define TAILLE 10 //constante de taille du serpent
#define TAILLE_MAX 20 //taille max du serpent
#define FIN 'c' //constante de fin
#define TEMPO 100000 //constante pour el temps d'arret du programme, vitesse du serpent
#define QUEUE 'X' //constante pour le caractère du corps
#define TETE_HAUT '^' //constante pour le caractère de tête vers le haut
#define TETE_BAS 'v'//constante pour le caractère de tête vers le bas
#define TETE_DROITE '>'//constante pour le caractère de tête vers la droite
#define TETE_GAUCHE '<'//constante pour le caractère de tête vers la gauche
#define X 40 //constante de coodronnées de départ en x
#define Y 20 //constante de coordonnées de départ en y
#define DROITE 'd' //constante de touche pour aller a droite
#define GAUCHE 'q' //constante de touche pour aller a gauche
#define HAUT 'z' //constante de touche pour aller en bas
#define BAS 's' //constante de touche pour aller en haut
#define PLATHAUT 40 //constante de hauteur du plateau
#define PLATLARG 80 //constante de largeur du plateau
#define PLATEAU 'B' //définition du motif du plateau
#define FOND ' ' //definition du motif du font du plateau
#define POMME '6' //définition de la pomme
#define AUGM_VIT 5000 //définitio  de l'augmentation de la vitesse
#define GRANDIR 1 //définition du nombre d'augmentation de taille du serpent
#define VIES_FIN 3 //définition du nombre de vie du serpent

char tab[PLATLARG][PLATHAUT]; //tableau pour le plateau
int tailleT=TAILLE; //défini d'une variable globale pour la taille du serpent a un instant t

int kbhit(); //regagrder si une touche est rentrée au clavier
void gotoXY(int x, int y); //positionner le curseur avant d'afficher le tête a cet endroit
void afficher(int x, int y, char O); //afficher le caractère 0 (tête dus serpent)
void effacer(int x, int y); //effacer le caractère
void progresser(int lesX[tailleT], int lesY[tailleT], char direction, bool* collision, bool*manger, char tete); //calculer l'avancée vers la droite
void dessinerSerpent(int lesX[tailleT], int lesY[tailleT], char tete); //dessiner ler serpent depuis las coordonnées donnée (tête puis tout le corps)
void disableEcho(); //permet de ne plus afficher les touches rentrées au clavier
void enableEcho(); //affuche a nouveau les touches rentrées au clavier
void initPlateau(char tab[PLATLARG][PLATHAUT]); //initialiser le plateau et les blocs dedans
void dessinerPlateau(char tab[PLATLARG][PLATHAUT]); //dessiner les plateau et les blocs dedans
void ajouter_pomme(char tab[PLATLARG][PLATHAUT], int lesX[tailleT], int lesY[tailleT]); //place aléatoirement une pomme a une emplaceament libre du plateau
bool pommeSerpent(int lesX[TAILLE_MAX], int lesY[TAILLE_MAX], int x, int y);//regarder si la pomme spawn sur le serpent ou pas

int main(){
   int tabx[TAILLE_MAX], taby[TAILLE_MAX]; //définition du tableau du serpent
   int duree=TEMPO; //temps d'arrêt du programme
   char clav=DROITE, clavVerif; //lire le caractère au clavier, vérifier le caractère au clavier
   bool collision=false;//sert pour savoir si le serpent rentre dans quelque chose
   bool manger=false;//sert pour savoir si une pomme est mangée
   char tete=TETE_DROITE;//définition de la tête au début du programme
   int vies=0;//définition de la vié au début du programme

   for(int i=0; i<tailleT; i++){//créer les coordonnées du serpent a partir de la tête
      tabx[i]=X-i;
      taby[i]=Y;
   }
   disableEcho();
   initPlateau(tab);
   system ("clear");
   dessinerPlateau(tab);
   dessinerSerpent(tabx, taby, tete); //dessiner le serpent depuis les coordonnées données
   ajouter_pomme(tab, tabx, taby);
   printf("\e[?25l");

   while(clav!=FIN && vies<VIES_FIN && tailleT<TAILLE_MAX){// tant que le caractère au clavier n'est pas FIN (a ici)
      usleep(duree);
      progresser(tabx, taby, clav, &collision, &manger, tete); //faire avancer le serpent
      if(manger==true){ //si une pomme est détectée comme mangée
         manger=false;
         duree-=AUGM_VIT; //la vitesse du serpent augmente
         tailleT=tailleT+GRANDIR; //la taille du serpent augmente
         if(tailleT!=TAILLE_MAX){
            ajouter_pomme(tab, tabx, taby); //une nouvelle pomme apparait
         }
      }
      if(kbhit()==1){ //si un caractère est tapé au clavier
         clavVerif=getchar();//récupérer la touvhe au clavier pour la vérifier
         if(clavVerif==DROITE || clavVerif==GAUCHE || clavVerif==HAUT || clavVerif==BAS || clavVerif==FIN){ //regarde si la touche est utilisée quelque part
            if((clav==DROITE && clavVerif==GAUCHE) || (clav==GAUCHE && clavVerif==DROITE) || (clav==HAUT && clavVerif==BAS) || (clav==BAS && clavVerif==HAUT)){ //ne aps aller a droite si le serpent va a gauche, en haut si il va en bas,...
               clavVerif=clav;
            }
            clav=clavVerif; //si elle sert, elle est sauvegardée pour être utilisée
         }
      }
      if(collision==true){//si il y a une collision de détectée
         for(int h=0; h<tailleT; h++){
            effacer(tabx[h+1], taby[h+1]);//l'ancien serpent s'efface
         }
         for(int i=0; i<tailleT; i++){//créer les coordonnées du serpent a partir de la tête
            tabx[i]=X-i;
            taby[i]=Y;
         }
         clav=DROITE;
         tete=TETE_DROITE;
         vies=vies+1;
         collision=false;
      }
   }
   if(tailleT==TAILLE_MAX){
      printf("Vous avez gagné !! :)");
   }
   else{
      printf("Vous avez perdu :(");
   }
   enableEcho();
   return EXIT_SUCCESS;
}

void gotoXY(int x, int y) { //va aux coordonnées x et y données
   printf("\033[%d;%df", y, x);
}

void afficher(int x, int y, char c){ //affiche un caractère à la position x et y
   gotoXY(x,y);
   printf("%c", c);
}

void effacer(int x, int y){ //efface le caractère à la position x et y
   afficher(x, y, ' ');
}

void dessinerSerpent(int lesX[tailleT], int lesY[tailleT], char tete){ //dessine le serpent
   for (int i=1; i<tailleT; i++){//dessine le corps
      if(lesX[i]>0 && lesY[i]>0){
         afficher(lesX[i], lesY[i], QUEUE);
      }
   }
   if(lesX[0]>0 && lesY[0]>0){
      afficher(lesX[0], lesY[0], tete);//affiche la tête aux coordonnées
   }
}

void progresser(int lesX[tailleT], int lesY[tailleT], char direction, bool* collision, bool* manger, char tete){ //faire avancer le serpent
   effacer(lesX[tailleT-1], lesY[tailleT-1]);//efface le dernier caractère du corps
   for(int i=tailleT; i>0; i--){
      lesX[i]=lesX[i-1];
      lesY[i]=lesY[i-1];
   }
   switch(direction) //détermine la direction du serpent
   {
      case DROITE://claculer les nouvelles coordonnées du corps
         tete=TETE_DROITE;
         lesX[0]+=1;
         break;
      case GAUCHE ://claculer les nouvelles coordonnées du corps
         tete=TETE_GAUCHE;
         lesX[0]-=1;
         break;
      case HAUT ://claculer les nouvelles coordonnées du corps
         tete=TETE_HAUT;
         lesY[0]-=1;
         break;
      case BAS ://claculer les nouvelles coordonnées du corps
         tete=TETE_BAS;
         lesY[0]+=1;
         break;
      default :
         break;
   }
   if(lesX[0]==1){//fais en sorte que si le serpent va dans le trou a gauche, il ressort a droite
      lesX[0]=PLATLARG;
   }
   else if(lesX[0]==PLATLARG){ //fais en sorte que si le serpent va dans le trou a droite, il ressort a gauche
      lesX[0]=1;
   }
   else if(lesY[0]==1){//fais en sorte que si le serpent va dans le trou en haut, il ressort en bas
      lesY[0]=PLATHAUT;
   }
   else if(lesY[0]==PLATHAUT){//fais en sorte que si le serpent va dans le trou en bas, il ressort en haut
      lesY[0]=1;
   }

   for(int i=1; i<tailleT; i++){//regarde si le serpent rentre en collision avec un élément du plateau
      if(((tab[lesX[0]-1][lesY[0]-1]==PLATEAU)) || ((lesX[0]==lesX[i]) && (lesY[0]==lesY[i]))){
         *collision=true;
      }
   }

   if(tab[lesX[0]][lesY[0]]==POMME){//si dans la case de la tête a une pomme dedans, le booléen deviens vrai
      *manger=true;
      tab[lesX[0]][lesY[0]]=FOND;
   }
   
   if(!*collision){
      dessinerSerpent(lesX, lesY, tete);//dessine le serpent aux nouvelles coordonnées
   }
}


void disableEcho() {
   struct termios tty;

   // Obtenir les attributs du terminal
   if (tcgetattr(STDIN_FILENO, &tty) == -1) {
      perror("tcgetattr");
      exit(EXIT_FAILURE);
   }

   // Desactiver le flag ECHO
   tty.c_lflag &= ~ECHO;

   // Appliquer les nouvelles configurations
   if (tcsetattr(STDIN_FILENO, TCSANOW, &tty) == -1) {
      perror("tcsetattr");
      exit(EXIT_FAILURE);
   }
}

void enableEcho() {
   struct termios tty;

   // Obtenir les attributs du terminal
   if (tcgetattr(STDIN_FILENO, &tty) == -1) {
      perror("tcgetattr");
      exit(EXIT_FAILURE);
   }

   // Reactiver le flag ECHO
   tty.c_lflag |= ECHO;

   // Appliquer les nouvelles configurations
   if (tcsetattr(STDIN_FILENO, TCSANOW, &tty) == -1) {
      perror("tcsetattr");
      exit(EXIT_FAILURE);
   }
}

int kbhit(){
   // la fonction retourne :
   // 1 si un caractere est present
   // 0 si pas de caractere present
   
   int unCaractere=0;
   struct termios oldt, newt;
   int ch;
   int oldf;

   // mettre le terminal en mode non bloquant
   tcgetattr(STDIN_FILENO, &oldt);
   newt = oldt;
   newt.c_lflag &= ~(ICANON | ECHO);
   tcsetattr(STDIN_FILENO, TCSANOW, &newt);
   oldf = fcntl(STDIN_FILENO, F_GETFL, 0);
   fcntl(STDIN_FILENO, F_SETFL, oldf | O_NONBLOCK);
   
   ch = getchar();

   // restaurer le mode du terminal
   tcsetattr(STDIN_FILENO, TCSANOW, &oldt);
   fcntl(STDIN_FILENO, F_SETFL, oldf);
   
   if(ch != EOF){
      ungetc(ch, stdin);
      unCaractere=1;
   }
   return unCaractere;
} //regarder si quelque chose est tappé au clavier

void initPlateau(char tab[PLATLARG][PLATHAUT]){//initialise le plateau
   int i, z;
   srand(time(NULL));
   for(z=1;z<=PLATHAUT+1;z++){ //initialise les bordure du plateau
      for(i=1;i<=PLATLARG+1;i++){
         tab[i-1][z-1]=PLATEAU;
         }
      }
   for(z=2;z<PLATHAUT;z++){//initialise le fond du plateau
      for(i=2;i<PLATLARG;i++){
         tab[i-1][z-1]=FOND;
      }
   }
}


void dessinerPlateau(char tab[PLATLARG][PLATHAUT]){//dessine le plateau
   int i,z;
   for(i=0; i<PLATHAUT; i++){
      for(z=0; z<PLATLARG; z++){
         afficher(z+1,i+1,tab[z][i]);
      }
   }
}

void ajouter_pomme(char tab[PLATLARG][PLATHAUT],int lesX[tailleT],int lesY[tailleT]){ //place aléatoirement une pomme a une emplaceament libre du plateau
   int x,y;
   bool pomme=false;
   srand(time(NULL));
   x=rand()%PLATLARG-1;
   y=rand()%PLATHAUT-1;
   for(int u=0; u<tailleT; u++){
      if(tab[lesX[u]][lesY[u]]==POMME){
         pomme=true;
      }
   }
   while(tab[x][y]!=FOND || pomme==true){ //||(pommeSerpent(tabx, taby, x, y)
      x=rand()%PLATLARG-1;
      y=rand()%PLATHAUT-1;
      pomme=false;
   }
   for(int u=0; u<tailleT; u++){
      if(tab[lesX[u]][lesY[u]]!=POMME){
         pomme=false;
      }
   }
   tab[x][y]=POMME;
   afficher(x,y,POMME);
}

/*
pour ajouetr_pomme, j'ai essayé de passer tabx et taby en variable globale, pour ne pas a avoir a le rajouter en entrée, mais ça ne marchais pas.
Pour des raisons qui me sont inconnues (et ayant demandé a d'autre amis, leur est inconnue aussi), lorsque je le mettais en variable globale, 
plus rien ne s'affichait sur mon écran (alors que je faisais exactement comme les autres).
J'ai donc deux parapètre d'entrée en trop dans ajouter_pomme, mais un programme fonctionnel.
Le problème vient peut être aussi de mon compilateur de c en ligne, car je n'ai pas de vm sur mon pc (j'en ai installé une, qui affiche un écran noir dés
que je me connecte).
*/