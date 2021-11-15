import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
/**
 * @Author Gallon
 * @ClassName ResourceAllocator
 * @Description 核心实现类，用于初始化分区、分配分区、回收分区、合并分区。
 * @Time 2021-11-15,周一 09:11
 */

public class ResourceAllocator {


    List<Partition> partitions=new ArrayList<Partition>();
    public static class FirstFitComparator implements Comparator<Partition>{
        @Override
        public int compare(Partition o1, Partition o2) {
            return o1.begin-o2.begin;
        }
    }
    public static class BestFitComparator implements Comparator<Partition>{
        @Override
        public int compare(Partition o1, Partition o2) {
            return o1.end - o1.begin - (o2.end - o2.begin);
        }
    }
    public static class WorstFitComparator implements Comparator<Partition>{
        @Override
        public int compare(Partition o1, Partition o2) {
            return o2.end - o2.begin - (o1.end - o1.begin);
        }
    }

}
