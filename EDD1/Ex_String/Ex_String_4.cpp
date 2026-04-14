/*
Exercício 4 - À partir de uma lista de nomes disponível em um arquivo TXT,
transforma-los em nomes no formato citação bibliográfica. Exemplo:

    José Antonio Santos Silva
    SILVA, José A. S.
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

        if (pos != string::npos)
        {
            string sobrenome = nome.substr(pos + 1);
            string nomes = nome.substr(0, pos);

            for (int i = 0; i < sobrenome.size(); i++)
                sobrenome[i] = toupper(sobrenome[i]);

            cout << sobrenome << ", ";

            bool primeiro = true;
            string parte = "";

            for (int i = 0; i <= nomes.size(); i++)
            {
                if (i == nomes.size() || nomes[i] == ' ')
                {
                    if (primeiro)
                    {
                        cout << parte << " ";
                        primeiro = false;
                    }
                    else
                    {
                        cout << (char)toupper(parte[0]) << ". ";
                    }
                    parte = "";
                }
                else
                {
                    parte += nomes[i];
                }
            }

            cout << endl;
        }
    }

    arq.close();

    cin.get();
    return 0;
}