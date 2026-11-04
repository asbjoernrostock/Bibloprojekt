import java.util.Comparator;

public class ResourceCreatorComparator implements Comparator<Resource> {


    @Override
    public int compare(Resource o1, Resource o2) {
        return o1.getCreator().compareTo(o2.getCreator());
    }
}
