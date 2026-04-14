/*
Exercício 2  - Receber através de digitação uma mensagem. 

Informar se esta mensagem é ou não um dado palíndromo 
(no caso de haver espaços no texto, desconsiderá-los para a verificação). Exemplos:

OVO
ARARA
SOCORRAM ME SUBI NO ONIBUS EM MARROCOS
*/

#include <iostream>
#include <locale.h>
#include <string>
#include <stdlib.h>

using namespace std;

int main()
{
    setlocale(LC_ALL, "");

    string msg;
    string semEspaco = "";
    string invertida = "";

    cout << "Digite uma mensagem: ";
    getline(cin, msg);

    for (int i = 0; i < msg.size(); i++) {
        if (msg[i] != ' ') {
            semEspaco += toupper(msg[i]);
        }
    }

    for (int i = semEspaco.size() - 1; i >= 0; i--) {
        invertida += semEspaco[i];
    }

    if (semEspaco == invertida) {
        cout << "Eh palindromo" << endl;
    } else {
        cout << "Nao eh palindromo" << endl;
    }

    system("pause");
    return 0;
}