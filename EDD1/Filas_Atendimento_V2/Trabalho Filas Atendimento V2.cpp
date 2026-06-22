#include <iostream>
#include <cstdlib>

using namespace std;

struct No {
    int dado;
    No *prox;
};

struct Fila {
    No *ini;
    No *fim;
};

struct Guiche {
    int id;
    Fila *senhasAtendidas;
    Guiche *prox;
};

Fila* initFila() {
    Fila *f = new Fila;
    f->ini = NULL;
    f->fim = NULL;
    return f;
}

int isEmpty(Fila *f) {
    return (f->ini == NULL);
}

int countFila(Fila *f) {
    int cont = 0;
    No *aux = f->ini;

    while (aux != NULL) {
        cont++;
        aux = aux->prox;
    }

    return cont;
}

void enqueue(Fila *f, int v) {
    No *novo = new No;
    novo->dado = v;
    novo->prox = NULL;

    if (isEmpty(f)) {
        f->ini = novo;
    }
    else {
        f->fim->prox = novo;
    }

    f->fim = novo;
}

int dequeue(Fila *f) {
    int ret;

    if (isEmpty(f)) {
        ret = -1;
    }
    else {
        No *aux = f->ini;

        ret = aux->dado;
        f->ini = aux->prox;

        if (f->ini == NULL) {
            f->fim = NULL;
        }

        delete aux;
    }

    return ret;
}

void printFila(Fila *f) {
    No *aux = f->ini;

    while (aux != NULL) {
        cout << "Senha: " << aux->dado << endl;
        aux = aux->prox;
    }
}

Guiche* initLista() {
    return NULL;
}

int countGuiches(Guiche *lista) {
    int cont = 0;
    Guiche *aux = lista;

    while (aux != NULL) {
        cont++;
        aux = aux->prox;
    }

    return cont;
}

Guiche* pesquisarGuiche(Guiche *lista, int id) {
    Guiche *aux = lista;

    while (aux != NULL && aux->id != id) {
        aux = aux->prox;
    }

    return aux;
}

Guiche* inserirGuiche(Guiche *lista, int id) {
    Guiche *g = pesquisarGuiche(lista, id);

    if (g != NULL) {
        cout << "Guiche ja aberto" << endl;
        return lista;
    }

    Guiche *novo = new Guiche;

    novo->id = id;
    novo->senhasAtendidas = initFila();
    novo->prox = lista;

    cout << "Guiche aberto" << endl;

    return novo;
}

int main() {

    Fila *senhasGeradas = initFila();
    Guiche *guiches = initLista();

    int op;
    int controleSenha = 0;
    int totalAtendidas = 0;
    int id;

    do {

        cout << "\n--------------------------------" << endl;
        cout << "Senhas aguardando: "
             << countFila(senhasGeradas) << endl;

        cout << "Guiches abertos: "
             << countGuiches(guiches) << endl;

        cout << "\n0 - Sair";
        cout << "\n1 - Gerar senha";
        cout << "\n2 - Abrir guiche";
        cout << "\n3 - Realizar atendimento";
        cout << "\n4 - Listar senhas atendidas";
        cout << "\nOpcao: ";
        cin >> op;

        if (op == 0) {

            if (!isEmpty(senhasGeradas)) {
                cout << "Nao pode sair. Ainda existem senhas aguardando." << endl;
                op = -1;
            }
        }

        else if (op == 1) {

            controleSenha++;

            enqueue(senhasGeradas, controleSenha);

            cout << "Senha gerada: "
                 << controleSenha << endl;
        }

        else if (op == 2) {

            cout << "Digite o id do guiche: ";
            cin >> id;

            guiches = inserirGuiche(guiches, id);
        }

        else if (op == 3) {

            if (isEmpty(senhasGeradas)) {

                cout << "Nao existem senhas aguardando" << endl;
            }
            else {

                cout << "Digite o id do guiche: ";
                cin >> id;

                Guiche *g = pesquisarGuiche(guiches, id);

                if (g == NULL) {

                    cout << "Guiche nao encontrado" << endl;
                }
                else {

                    int senha = dequeue(senhasGeradas);

                    enqueue(g->senhasAtendidas, senha);

                    totalAtendidas++;

                    cout << "Senha "
                         << senha
                         << " atendida pelo guiche "
                         << id << endl;
                }
            }
        }

        else if (op == 4) {

            cout << "Digite o id do guiche: ";
            cin >> id;

            Guiche *g = pesquisarGuiche(guiches, id);

            if (g == NULL) {

                cout << "Guiche nao encontrado" << endl;
            }
            else {

                cout << "\nSenhas atendidas pelo guiche "
                     << id << endl;

                if (isEmpty(g->senhasAtendidas)) {

                    cout << "Nenhuma senha atendida" << endl;
                }
                else {

                    printFila(g->senhasAtendidas);
                }
            }
        }

        else {

            cout << "Opcao invalida" << endl;
        }

    } while (op != 0);

    cout << "\nPrograma encerrado" << endl;

    cout << "Total de senhas atendidas: "
         << totalAtendidas << endl;

    cout << "\nAtendimentos por guiche:" << endl;

    Guiche *aux = guiches;

    while (aux != NULL) {

        cout << "Guiche "
             << aux->id
             << ": "
             << countFila(aux->senhasAtendidas)
             << " senha(s) atendida(s)"
             << endl;

        aux = aux->prox;
    }

    system("pause");
    return 0;
}