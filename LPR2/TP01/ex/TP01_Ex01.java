//feito por Igor Cristiano Bezerra (CB3038408) e Pedro Matias dos Santos Neto (CB3038785)


package LPR1.LPR2;

class Author {
    private String name;
    private String email;
    private char gender;

    public Author(String name, String email, char gender) {
        this.name = name;
        this.email = email;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public char getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return "Author[name=" + name + ",email=" + email + ",gender=" + gender + "]";
    }
}

public class TP01_Ex01 {
    public static void main(String[] args) {
        Author author = new Author("Igor Cristiano bezerra", "igor@aluno.ifsp.edu.br", 'm');
        
        System.out.println(author.toString());
        
        author.setEmail("igor.novo@aluno.ifsp.edu.br");
        
        System.out.println(author.getName());
        System.out.println(author.getEmail());
        System.out.println(author.getGender());
    }
}