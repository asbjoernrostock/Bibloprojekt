import java.util.Comparator;

public class ResourceTitleComparator implements Comparator<Resource> {


    @Override
    public int compare(Resource o1, Resource o2) {
        return o1.getTitle().compareTo(o2.getTitle());
    }
}
