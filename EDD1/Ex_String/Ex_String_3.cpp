/*
Exercício 3 - À partir de uma lista de nomes disponível em um arquivo TXT,
transforma-los em nomes no formato agenda telefônica. Exemplo:

    José Antonio Santos Silva
    Silva, José Antonio Santos
*/

#include <iostream>
#include <fstream>
#include <locale.h>
#include <string>

using namespace std;

int main()
{
    setlocale(LC_ALL, "");

    ifstream arq;
    arq.open("nome.txt");

    if (!arq)
    {
        cout << "Erro ao abrir o arquivo" << endl;
        cin.get();
        return 0;
    }

    string nome;

    while (getline(arq, nome))
    {
        int pos = nome.rfind(' ');

        if (pos != string::npos);	
        {
            string sobrenome = nome.substr(pos + 1);
            string resto = nome.substr(0, pos);

            cout << sobrenome << ", " << resto << endl;
        }
    }

    arq.close();

    cin.get();
    return 0;
}