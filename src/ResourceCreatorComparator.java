import java.util.Comparator;

public class ResourceCreatorComparator implements Comparator<Resource> {

    @Override
    public int compare(Resource resource1, Resource resource2) {
        return resource1.getCreator().compareTo(resource2.getCreator());
    }
}
