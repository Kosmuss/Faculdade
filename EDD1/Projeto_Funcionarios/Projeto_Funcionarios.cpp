/*
À partir da estrutura "Funcionario" descrita abaixo:

------------------
| Funcionario       |
|-------------------|
| - prontuario: int |
| - nome: string    |
| - salario: double |
---------------------

Elabore um programa que permita administrar uma lista de funcionários e, através de um menu, ofereça as seguintes opções:

   0. Sair
   1. Incluir
   2. Excluir
   3. Pesquisar
   4. Listar

OBSERVAÇÕES:

a) Não poderão ser cadastrados funcionários com mesmo prontuário;

b) A pesquisa de funcionário deverá utilizar o atributo "Prontuário" como critério e, quando encontrado, deverão ser exibidos os demais atributos;

c) A listagem dos funcionários deverá apresentar todos os seus atributos e, ao final, informar o total dos salários.
*/


#include <iostream>
#include <vector>
#include <string>
#include <iomanip>

using namespace std;

class Funcionario {
public:
    int prontuario;
    string nome;
    double salario;

    Funcionario(int p, string n, double s) {
        prontuario = p;
        nome = n;
        salario = s;
    }
};

int buscarFuncionario(const vector<Funcionario>& lista, int prontuario) {
    for (size_t i = 0; i < lista.size(); i++) {
        if (lista[i].prontuario == prontuario) {
            return i;
        }
    }
    return -1;
}

int main() {
    vector<Funcionario> lista_funcionarios;
    int opcao;

    do {
        cout << "\n==============================\n";
        cout << "      MENU FUNCIONARIOS       \n";
        cout << "==============================\n";
        cout << "0. Sair\n";
        cout << "1. Incluir\n";
        cout << "2. Excluir\n";
        cout << "3. Pesquisar\n";
        cout << "4. Listar\n";
        cout << "==============================\n";
        cout << "Escolha uma opcao: ";
        cin >> opcao;

        if (opcao == 0) {
            cout << "Saindo do programa...\n";
        }
        else if (opcao == 1) {
            int prontuario;
            cout << "Digite o Prontuario: ";
            cin >> prontuario;
            
            if (buscarFuncionario(lista_funcionarios, prontuario) != -1) {
                cout << "Erro: Ja existe um funcionario com este prontuario.\n";
            } else {
                string nome;
                double salario;
                
                cout << "Digite o Nome: ";
                cin.ignore();
                getline(cin, nome);
                
                cout << "Digite o Salario: R$ ";
                cin >> salario;
                
                lista_funcionarios.push_back(Funcionario(prontuario, nome, salario));
                cout << "Funcionario cadastrado com sucesso!\n";
            }
        }
        else if (opcao == 2) {
            int prontuario;
            cout << "Digite o Prontuario do funcionario que deseja excluir: ";
            cin >> prontuario;
            
            int indice = buscarFuncionario(lista_funcionarios, prontuario);
            
            if (indice != -1) {
                cout << "Funcionario " << lista_funcionarios[indice].nome << " excluido com sucesso!\n";
                lista_funcionarios.erase(lista_funcionarios.begin() + indice);
            } else {
                cout << "Erro: Funcionario nao encontrado.\n";
            }
        }
        else if (opcao == 3) {
            int prontuario;
            cout << "Digite o Prontuario para pesquisar: ";
            cin >> prontuario;
            
            int indice = buscarFuncionario(lista_funcionarios, prontuario);
            
            if (indice != -1) {
                cout << "\n--- Funcionario Encontrado ---\n";
                cout << "Nome: " << lista_funcionarios[indice].nome << "\n";
                cout << fixed << setprecision(2); 
                cout << "Salario: R$ " << lista_funcionarios[indice].salario << "\n";
                cout << "------------------------------\n";
            } else {
                cout << "Erro: Funcionario nao encontrado.\n";
            }
        }
        else if (opcao == 4) {
            if (lista_funcionarios.empty()) {
                cout << "Nenhum funcionario cadastrado no momento.\n";
            } else {
                cout << "\n--- Lista de Todos os Funcionarios ---\n";
                double total_salarios = 0.0;
                
                cout << fixed << setprecision(2);
                
                for (size_t i = 0; i < lista_funcionarios.size(); i++) {
                    cout << "Prontuario: " << lista_funcionarios[i].prontuario 
                         << " | Nome: " << lista_funcionarios[i].nome 
                         << " | Salario: R$ " << lista_funcionarios[i].salario << "\n";
                    total_salarios += lista_funcionarios[i].salario;
                }
                
                cout << "--------------------------------------\n";
                cout << "TOTAL DOS SALARIOS: R$ " << total_salarios << "\n";
            }
        }
        else {
            cout << "Opcao invalida! Tente novamente.\n";
        }
        
    } while (opcao != 0);

    return 0;
}