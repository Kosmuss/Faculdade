//Feito por Igor Cristiano Bezerra (CB3038408)//

//parte 1//

#include <iostream>

using namespace std;

struct PilhaVetor {
    int dados[30];
    int topo;
};

void inicializar(PilhaVetor& p) {
    p.topo = -1;
}

void push(PilhaVetor& p, int valor) {
    p.topo++;
    p.dados[p.topo] = valor;
}

int pop(PilhaVetor& p) {
    int valor = p.dados[p.topo];
    p.topo--;
    return valor;
}

int peek(const PilhaVetor& p) {
    return p.dados[p.topo];
}

bool is_empty(const PilhaVetor& p) {
    return p.topo == -1;
}

int main() {
    PilhaVetor par, impar;
    inicializar(par);
    inicializar(impar);

    int anterior;
    bool primeiro = true;

    for (int i = 0; i < 30; ) {
        int atual;
        cin >> atual;

        if (!primeiro && atual <= anterior) {
            cout << "Invalido. O numero deve ser maior que o anterior.\n";
            continue;
        }

        if (atual % 2 == 0) {
            push(par, atual);
        } else {
            push(impar, atual);
        }

        anterior = atual;
        primeiro = false;
        i++;
    }

    while (!is_empty(par) || !is_empty(impar)) {
        if (!is_empty(par) && !is_empty(impar)) {
            if (peek(par) > peek(impar)) {
                cout << pop(par) << " ";
            } else {
                cout << pop(impar) << " ";
            }
        } else if (!is_empty(par)) {
            cout << pop(par) << " ";
        } else {
            cout << pop(impar) << " ";
        }
    }
    cout << endl;

    return 0;
}

//parte 2//


#include <iostream>

using namespace std;

struct No {
    int valor;
    No* prox;
};

struct PilhaLista {
    No* topo;
};

void inicializar(PilhaLista& p) {
    p.topo = nullptr;
}

void push(PilhaLista& p, int valor) {
    No* novo = new No;
    novo->valor = valor;
    novo->prox = p.topo;
    p.topo = novo;
}

int pop(PilhaLista& p) {
    int valor = p.topo->valor;
    No* temp = p.topo;
    p.topo = p.topo->prox;
    delete temp;
    return valor;
}

int peek(const PilhaLista& p) {
    return p.topo->valor;
}

bool is_empty(const PilhaLista& p) {
    return p.topo == nullptr;
}

int main() {
    PilhaLista par, impar;
    inicializar(par);
    inicializar(impar);

    int anterior;
    bool primeiro = true;

    for (int i = 0; i < 30; ) {
        int atual;
        cin >> atual;

        if (!primeiro && atual <= anterior) {
            cout << "Invalido. O numero deve ser maior que o anterior.\n";
            continue;
        }

        if (atual % 2 == 0) {
            push(par, atual);
        } else {
            push(impar, atual);
        }

        anterior = atual;
        primeiro = false;
        i++;
    }

    while (!is_empty(par) || !is_empty(impar)) {
        if (!is_empty(par) && !is_empty(impar)) {
            if (peek(par) > peek(impar)) {
                cout << pop(par) << " ";
            } else {
                cout << pop(impar) << " ";
            }
        } else if (!is_empty(par)) {
            cout << pop(par) << " ";
        } else {
            cout << pop(impar) << " ";
        }
    }
    cout << endl;

    return 0;
}