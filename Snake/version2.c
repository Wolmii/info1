#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <fcntl.h>
#include <termios.h>

#define TAILLE 10 //constante de taille du serpent
#define FIN 'a' //constante de fin
#define TEMPO 100000 //constante pour el temps d'arret du programme, vitesse du serpent
#define QUEUE 'X' //constante pour le caractère du corps
#define TETE 'O' //constante pour le caractère de tête
#define X 20 //constante de coodronnées de départ en x
#define Y 20 //constante de coordonnées de départ en y
#define DROITE 'd' //constante de touche pour aller a droite
#define GAUCHE 'q' //constante de touche pour aller a gauche
#define HAUT 'z' //constante de touche pour aller en bas
#define BAS 's' //constante de touche pour aller en haut


int kbhit(); //regagrder si une touche est rentrée au clavier
void gotoXY(int x, int y); //positionner le curseur avant d'afficher le tête a cet endroit
void afficher(int x, int y, char O); //afficher le caractère 0 (tête dus serpent)
void effacer(int x, int y); //effacer le caractère
void progresser(int lesX[TAILLE], int lesY[TAILLE], char direction); //calculer l'avancée vers la droite
void dessinerSerpent(int lesX[TAILLE], int lesY[TAILLE]); //dessiner ler serpent depuis las coordonnées donnée (tête puis tout le corps)
void disableEcho(); //permet de ne plus afficher les touches rentrées au clavier
void enableEcho(); //affuche a nouveau les touches rentrées au clavier

int main(){
	int tabx[TAILLE], taby[TAILLE]; //
	int x,y; //position initiale du serpent
	int duree=TEMPO; //temps d'arrêt du programme
	char clav=DROITE, clavVerif; //lire le caractère au clavier, vérifier le caractère au clavier

	for(int i=0; i<TAILLE; i++){//créer les coordonnées du serpent a partir de la tête
		tabx[i]=X-i;
		taby[i]=Y;
	}
	disableEcho();
	system ("clear");
	dessinerSerpent(tabx, taby); //dessiner le serpent depuis les coordonnées données
	printf("\e[?25l");
	while(clav!=FIN){// tant que le caractère au clavier n'est pas FIN (a ici)
		usleep(duree);
		progresser(tabx, taby, clav); //faire avancer le serpent
		if(kbhit()==1){ //si un caractère est tapé au clavier
			clavVerif=getchar();//récupérer la touvhe au clavier pour la vérifier
			if(clavVerif==DROITE || clavVerif==GAUCHE || clavVerif==HAUT || clavVerif==BAS || clavVerif==FIN){ //regarde si la touche est utilisée quelque part
                if((clav==DROITE && clavVerif==GAUCHE) || (clav==GAUCHE && clavVerif==DROITE) || (clav==HAUT && clavVerif==BAS) || (clav==BAS && clavVerif==HAUT)){ //ne aps aller a droite si le serpent va a gauche, en haut si il va en bas,...
					clavVerif=clav;
				}
				clav=clavVerif; //si elle sert, elle est sauvegardée pour être utilisée
            }
		}
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

void dessinerSerpent(int lesX[TAILLE], int lesY[TAILLE]){ //dessine le serpent
	for (int i=1; i<TAILLE; i++){//dessine le corps
		if(lesX[i]>0 && lesY[i]>0){
			afficher(lesX[i], lesY[i], QUEUE);
		}
	}
	if(lesX[0]>0 && lesY[0]>0){
		afficher(lesX[0], lesY[0], TETE);//affiche la tête aux coordonnées
	}
}

void progresser(int lesX[TAILLE], int lesY[TAILLE], char direction){ //faire avancer le serpent
	effacer(lesX[TAILLE-1], lesY[TAILLE-1]);//efface le dernier caractère du corps
	for(int i=TAILLE; i>0; i--){
		lesX[i]=lesX[i-1];
		lesY[i]=lesY[i-1];
	}
	switch(direction) //détermine la direction du serpent
	{
		case DROITE://claculer les nouvelles coordonnées du corps
			lesX[0]+=1;
			break;
		case GAUCHE ://claculer les nouvelles coordonnées du corps
			lesX[0]-=1;
			break;
		case HAUT ://claculer les nouvelles coordonnées du corps
			lesY[0]-=1;
			break;
		case BAS ://claculer les nouvelles coordonnées du corps
			lesY[0]+=1;
			break;
		default :
		    break;
	}
	dessinerSerpent(lesX, lesY);//dessine le serpent aux nouvelles coordonnées
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
}
//regarder si quelque chose est tappé au clavier
