#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <fcntl.h>
#include <termios.h>

#define TAILLE 10 //constante de taille du serpent
#define FIN 'a' //constante de fin
const int XMAX=40, YMAX=40, XMIN=0, YMIN=0; //taille max et min de x et y au départ

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

void gotoXY(int x, int y); //positionner le curseur avant d'afficher le tête a cet endroit
void afficher(int x, int y, char O); //afficher le caractère 0 (tête dus serpent)
void effacer(int x, int y); //effacer le caractère
void progresser(int lesX[TAILLE], int lesY[TAILLE]); //calculer l'avancée vers la droite
void dessinerSerpent(int lesX[TAILLE], int lesY[TAILLE]); //dessiner ler serpent depuis las coordonnées donnée (tête puis tout le corps)

int main(){
	int tabx[TAILLE], taby[TAILLE];
	int x,y; //position initiale du serpent
	int duree=100000; //temps d'arrêt du programme
	char clav; //lire le caractère au clavier
	printf("Donnez le numéro de colonne et de ligne: ");
	scanf("%d %d", &x, &y);
	system ("clear");

	while(x>XMAX || y>YMAX || x<=XMIN || y<=YMIN){ //s'assurer que les coordonnées rentrent dans les mins et max données
		printf("Entrez une coordonnée entre 0 et 40\n");
		printf("Donnez le numéro de collonne et de ligne:");
		scanf("%d %d", &x, &y);
	}

	for(int i=0; i<TAILLE; i++){//créer les coordonnées du serpent a partir de la tête
		tabx[i]=x-i;
		taby[i]=y;
	}

	dessinerSerpent(tabx, taby); //dessiner le serpent depuis les coordonnées données

	while(clav!=FIN){// tant que le caractère au clavier n'est pas FIN (a ici)
		usleep(duree);
		progresser(tabx, taby); //faire avancer le serpent
		if(kbhit()==1){ //si un caractère est tapé au clavier
			clav=getchar();// récupère le caractère tapé
		}
	}
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
	for (int i=0; i<TAILLE; i++){//dessine le corps
		if(lesX[i]>0){//si la position est a l'écran
			afficher(lesX[i], lesY[i], 'X');
		}
	}
	afficher(lesX[0], lesY[0], 'O');//affiche la tête aux coordonnées
}

void progresser(int lesX[TAILLE], int lesY[TAILLE]){ //faire avancer le serpent
	effacer(lesX[TAILLE-1], lesY[TAILLE-1]);//efface le dernier caractère du corps
	for(int i=0;i<TAILLE;i++){//claculer les nouvelles coordonnées du corps
		lesX[i]+=1;
	}
	dessinerSerpent(lesX, lesY);//dessine le serpent aux nouvelles coordonnées
}
