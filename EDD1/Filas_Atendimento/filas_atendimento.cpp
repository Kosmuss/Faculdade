//Feito por Igor Cristiano Bezerra (CB3038408)//

//Fila em forma de Ponteiro//

#include <iostream>

using namespace std;

struct No {
    int senha;
    No* prox;
};

struct Fila {
    No* inicio = nullptr;
    No* fim = nullptr;
    int tamanho = 0;
};

void enfileirar(Fila& f, int senha) {
    No* novo = new No{senha, nullptr};
    if (f.inicio == nullptr) {
        f.inicio = novo;
    } else {
        f.fim->prox = novo;
    }
    f.fim = novo;
    f.tamanho++;
}

int desenfileirar(Fila& f) {
    if (f.inicio == nullptr) return -1;
    No* temp = f.inicio;
    int senha = temp->senha;
    f.inicio = f.inicio->prox;
    if (f.inicio == nullptr) f.fim = nullptr;
    delete temp;
    f.tamanho--;
    return senha;
}

int main() {
    Fila senhasGeradas;
    Fila senhasAtendidas;
    int opcao;
    int proximaSenha = 1;

    do {
        cout << "\nSenhas aguardando atendimento: " << senhasGeradas.tamanho << "\n";
        cout << "0. Sair\n";
        cout << "1. Gerar senha\n";
        cout << "2. Realizar atendimento\n";
        cout << "Escolha uma opcao: ";
        cin >> opcao;

        if (opcao == 1) {
            enfileirar(senhasGeradas, proximaSenha++);
        } else if (opcao == 2) {
            if (senhasGeradas.tamanho > 0) {
                int senha = desenfileirar(senhasGeradas);
                cout << "Atendendo senha: " << senha << "\n";
                enfileirar(senhasAtendidas, senha);
            } else {
                cout << "Nenhuma senha aguardando atendimento.\n";
            }
        } else if (opcao == 0) {
            if (senhasGeradas.tamanho > 0) {
                cout << "Erro: Ainda ha senhas aguardando atendimento.\n";
                opcao = -1; 
            } else {
                cout << "Sistema encerrado. Total de senhas atendidas: " << senhasAtendidas.tamanho << "\n";
            }
        } else {
            cout << "Opcao invalida.\n";
        }
    } while (opcao != 0);

    while (senhasAtendidas.inicio != nullptr) {
        desenfileirar(senhasAtendidas);
    }

    return 0;
}


//Fila em forma de Vetor//

#include <iostream>
#include <vector>

using namespace std;

struct FilaVetor {
    vector<int> dados;
};

void enfileirarVetor(FilaVetor& f, int senha) {
    f.dados.push_back(senha);
}

int desenfileirarVetor(FilaVetor& f) {
    if (f.dados.empty()) return -1;
    int senha = f.dados.front();
    f.dados.erase(f.dados.begin());
    return senha;
}

int main() {
    FilaVetor senhasGeradas;
    FilaVetor senhasAtendidas;
    int opcao;
    int proximaSenha = 1;

    do {
        cout << "\nSenhas aguardando atendimento: " << senhasGeradas.dados.size() << "\n";
        cout << "0. Sair\n";
        cout << "1. Gerar senha\n";
        cout << "2. Realizar atendimento\n";
        cout << "Escolha uma opcao: ";
        cin >> opcao;

        if (opcao == 1) {
            enfileirarVetor(senhasGeradas, proximaSenha++);
        } else if (opcao == 2) {
            if (!senhasGeradas.dados.empty()) {
                int senha = desenfileirarVetor(senhasGeradas);
                cout << "Atendendo senha: " << senha << "\n";
                enfileirarVetor(senhasAtendidas, senha);
            } else {
                cout << "Nenhuma senha aguardando atendimento.\n";
            }
        } else if (opcao == 0) {
            if (!senhasGeradas.dados.empty()) {
                cout << "Erro: Ainda ha senhas aguardando atendimento.\n";
                opcao = -1;
            } else {
                cout << "Sistema encerrado. Total de senhas atendidas: " << senhasAtendidas.dados.size() << "\n";
            }
        } else {
            cout << "Opcao invalida.\n";
        }
    } while (opcao != 0);

    return 0;
}