#include <iostream>
using namespace std;

int main() {

    char teatro[15][40];
    int opcao;
    int fileira, poltrona;
    int ocupados = 0;
    float faturamento = 0;

    for (int linha = 0; linha < 15; linha++) {
        for (int coluna = 0; coluna < 40; coluna++) {
            teatro[linha][coluna] = '.';
        }
    }

    do {
        cout << "\n--- MENU ---\n";
        cout << "0 - Finalizar\n";
        cout << "1 - Reservar poltrona\n";
        cout << "2 - Mapa de ocupacao\n";
        cout << "3 - Faturamento\n";
        cout << "Digite a opcao: ";
        cin >> opcao;

        switch (opcao) {

            case 0:
                cout << "Programa finalizado.\n";
                break;

                case 1:

  cout << "\n";

cout << "     ";
for (int coluna = 1; coluna <= 40; coluna++) {
    if (coluna < 10)
        cout << coluna << "  ";
    else
        cout << coluna << " ";
}
cout << endl << endl;

for (int linha = 0; linha < 15; linha++) {
    if (linha + 1 < 10)
        cout << "F" << linha + 1 << "   ";
    else
        cout << "F" << linha + 1 << "  ";

    for (int coluna = 0; coluna < 40; coluna++) {
        cout << teatro[linha][coluna] << "  ";
    }
    cout << endl;
}

cout << "\n";
cout << "==================================================================================================================================================\n";
cout << "====================================================================== TELA ======================================================================\n";
cout << "==================================================================================================================================================\n";

    cout << "\nDigite a fileira (1 a 15): ";
    cin >> fileira;

    cout << "Digite a poltrona (1 a 40): ";
    cin >> poltrona;

    if (fileira < 1 || fileira > 15 || poltrona < 1 || poltrona > 40) {
        cout << "Lugar invalido.\n";
    }
    else {
        if (teatro[fileira - 1][poltrona - 1] == '.') {
            teatro[fileira - 1][poltrona - 1] = '#';
            cout << "Reserva realizada com sucesso.\n";
        }
        else {
            cout << "Essa poltrona ja esta ocupada.\n";
        }
    }
    break;
            case 2:
                cout << "\nMAPA DE OCUPACAO\n";
                cout << ". = vago | # = ocupado\n\n";

                for (int linha = 0; linha < 15; linha++) {
                    cout << "Fileira " << linha + 1 << ": ";
                    for (int coluna = 0; coluna < 40; coluna++) {
                        cout << teatro[linha][coluna] << " ";
                    }
                    cout << endl;
                }
                cout << "\n";
cout << "\n";
cout << "==================================================================================================================================================\n";
cout << "====================================================================== TELA ======================================================================\n";
cout << "==================================================================================================================================================\n";
                break;

            case 3:
                ocupados = 0;
                faturamento = 0;

                for (int linha = 0; linha < 15; linha++) {
                    for (int coluna = 0; coluna < 40; coluna++) {
                        if (teatro[linha][coluna] == '#') {
                            ocupados++;

                            if (linha >= 0 && linha <= 4) {
                                faturamento = faturamento + 50;
                            }
                            else if (linha >= 5 && linha <= 9) {
                                faturamento = faturamento + 30;
                            }
                            else {
                                faturamento = faturamento + 15;
                            }
                        }
                    }
                }

                cout << "\nQtde de lugares ocupados: " << ocupados << endl;
                cout << "Valor da bilheteria: R$ " << faturamento << endl;
                break;

            default:
                cout << "Opcao invalida.\n";
                break;
        }

    } while (opcao != 0);

    return 0;
}