public class Test {
    public static void main(String[] args) {
        ResourceAllocator resourceAllocator=new ResourceAllocator();
        Partition p1=new Partition(0,1000);
        Partition p2=new Partition(2400,3000);
        Partition p3=new Partition(4000,6000);
        resourceAllocator.add(p1);
        resourceAllocator.add(p2);
        resourceAllocator.add(p3);
        resourceAllocator.show();
        Task t1=new Task(500,"001");
        Task t2=new Task(100,"002");
        resourceAllocator.bestFit(t1);
        resourceAllocator.firstFit(t2);
        resourceAllocator.show();
        resourceAllocator.recycle("001");
        resourceAllocator.show();

    }
}
