package api;

import logic.*;

public interface BoardTestInterface {
// aus dem normalen:
    void placeStone(int column); // diese Methode legt einen Stein, überprüft den Status und wechselt den Spieler
    boolean getIsFull(); // gibt den Status ob das Spielfeld voll ist wieder
    int getWhoHasWon(); //0: niemand     1: Spieler1     2:Spieler2
    void saveBoard(); //speichert das Board als String in eine Textdatei
    void overwriteVariableWithSavestats(); //übernimmt die Werte aus dem savefile(Werte, die angepasst werden:board,isFull,isPlayer1sTurn)
    void savePvP(boolean pvp); // pvp = true wenn Player gegen Player, und = false bei Player gegen Computer 
    boolean loadPvP();
    int getComputerMove();
    boolean getTurn(); // gibt den Spieler der am Zug ist wieder (True = Spieler1, False = Spieler2)
    Tile[][] getBoard(); // gibt das Spielfeld als 2-dimensionalem Array aus Kacheln(Tiles) wieder
    int getColumns(); //gibt die Anzahl der Spalten
    int getrows();//gibt die Anzahl der Reihen
// extras:
    void checkStatus(int column); // überprüft den Status des Spiels, ob gewonnen oder voll
    void changePlayer(); // wechselt den Spieler
    void setTurn(boolean player1sTurn); // setzt welcher Spieler ist am Zug (True = Spieler1, False = Spieler2)
    void setColumns(int columns); //setzt die Anzahl der Spalten
    void setrows(int rows); //setzt die Anzahl der Reihen
    void setWhoHasWon(int whoWon); //0: niemand     1: Spieler1     2:Spieler2
    void setIsFull(boolean isFull); // setzt den Status ob das Spielfeld voll ist
    void setBoard(Tile[][] value); //ersetzt board mit dem input-Array
}
