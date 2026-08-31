//feito por Igor Cristiano Bezerra (CB3038408) e Pedro Matias dos Santos Neto (CB3038785)


package LPR1.LPR2;

class Book {
    private String name;
    private Author[] authors;
    private double price;
    private int qty = 0;

    public Book(String name, Author[] authors, double price) {
        this.name = name;
        this.authors = authors;
        this.price = price;
    }

    public Book(String name, Author[] authors, double price, int qty) {
        this.name = name;
        this.authors = authors;
        this.price = price;
        this.qty = qty;
    }

    public String getName() {
        return name;
    }

    public Author[] getAuthors() {
        return authors;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        StringBuilder authorsStr = new StringBuilder("{");
        for (int i = 0; i < authors.length; i++) {
            authorsStr.append(authors[i].toString());
            if (i < authors.length - 1) {
                authorsStr.append(",");
            }
        }
        authorsStr.append("}");
        return "Book[name=" + name + ",authors=" + authorsStr.toString() + ",price=" + price + ",qty=" + qty + "]";
    }

    public String getAuthorNames() {
        StringBuilder namesStr = new StringBuilder();
        for (int i = 0; i < authors.length; i++) {
            namesStr.append(authors[i].getName());
            if (i < authors.length - 1) {
                namesStr.append(",");
            }
        }
        return namesStr.toString();
    }
}

public class TP01_Ex02 {
    public static void main(String[] args) {
        Author[] authors = new Author[2];
        authors[0] = new Author("Igor Cristiano bezerra", "igor@aluno.ifsp.edu.br", 'm');
        authors[1] = new Author("Chuck Palahniuk", "chuck@palahniuk.net", 'm');
        
        Book testeBook = new Book("Clube da Luta", authors, 49.90, 5);
        
        System.out.println(testeBook.toString());
        System.out.println(testeBook.getAuthorNames());
    }
}