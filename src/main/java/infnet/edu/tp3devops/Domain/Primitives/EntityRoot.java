package infnet.edu.tp3devops.Domain.Primitives;

public class EntityRoot {

    public long id;

    protected EntityRoot(long id) {
        this.id = id;
    }

    public boolean Equals(EntityRoot obj) {
        if (obj != null) {
            if (obj.getClass() != this.getClass()) {
                return false;
            }
            return obj.id == this.id;
        }

        return true;
    }

}
