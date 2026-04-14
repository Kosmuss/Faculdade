/*
Exercício 1  - Receber através de digitação uma mensagem. 

Apresentar esta mensagem, centralizada, na linha 5 da tela.

À partir daí, cada letra desta mensagem deverá "cair", da linha 5 até a linha 20,
simulando uma "cascata". Ao final, a mensagem deverá estar toda apresentada na linha 20.
*/

#include <iostream>
#include <windows.h>
#include <locale.h>
#include <string>

using namespace std;

void gotoxy(short x, short y)
{
    COORD coord = {x, y};
    SetConsoleCursorPosition(GetStdHandle(STD_OUTPUT_HANDLE), coord);
}

int main(int argc, char** argv)
{
    setlocale(LC_ALL, "");

    string msg;
    int colunaInicial;
    int i, linha;

    cout << "Digite uma mensagem: ";
    getline(cin, msg);

    colunaInicial = (80 - msg.size()) / 2;

    gotoxy(colunaInicial, 5);
    cout << msg;

    Sleep(1000);

    for (i = 0; i < msg.size(); i++) {

        for (linha = 5; linha <= 20; linha++) {

            gotoxy(colunaInicial + i, linha);
            cout << msg[i];

            Sleep(80);

            if (linha < 20) {
                gotoxy(colunaInicial + i, linha);
                cout << " ";
            }
        }
    }

    gotoxy(0, 22);
    system("pause");
    return 0;
}