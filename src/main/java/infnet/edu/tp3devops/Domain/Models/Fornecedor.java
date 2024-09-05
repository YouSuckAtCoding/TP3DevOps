package infnet.edu.tp3devops.Domain.Models;

import infnet.edu.tp3devops.Domain.Primitives.EntityRoot;

public class Fornecedor extends EntityRoot{

    public String name;

    public String email;

    public String store;
    
    public Fornecedor(long id, String name, String email, String store) {
        super(id);
        this.name = name;
        this.email = email;
        this.store = store;
    }

    protected Fornecedor(long id) {
        super(id);
        //TODO Auto-generated constructor stub
    }

}
