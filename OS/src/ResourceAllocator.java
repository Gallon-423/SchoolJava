import java.util.*;

/**
 * @Author Gallon
 * @ClassName ResourceAllocator
 * @Description 核心实现类，用于初始化分区、分配分区、回收分区、合并分区。
 * @Time 2021-11-15,周一 09:11
 */

public class ResourceAllocator {
    HashMap<String,Task> taskHashMap=new HashMap<>();
    List<Partition> emptyPartition=new ArrayList<>();

    public ResourceAllocator() {
    }
    public void add(Partition p){
        if(p.begin>=p.end) return;
        for (Partition args:emptyPartition
             ) {
            //这句代码是为了防止输入有重叠的空分区。
            if((p.end<=args.end&&p.end>=args.begin) || (p.begin<=args.end&&p.begin>=args.begin))
            {
                args.begin=Integer.min(args.begin,p.begin);
                args.end=Integer.max(args.end,p.end);
                return;
            }
        }
        emptyPartition.add(p);
    }

    public void firstFit(Task task){
        int require=task.require;
        emptyPartition.sort(new FirstFitComparator());
        //将空闲分区根据begin的大小升序排列
        int flag=1;
        int removeMark = 0;
        for (Partition p:emptyPartition
             ) {
            int len=p.end-p.begin;
            if(len>=require) {
                Partition temp= new Partition(p.begin,p.end);
                task.partition=temp;
                p.begin += require;
                taskHashMap.put(task.name,task);
                flag=0;
                removeMark=emptyPartition.indexOf(p);
                break;
            }

        }
        if(emptyPartition.get(removeMark).begin==emptyPartition.get(removeMark).end)
            emptyPartition.remove(removeMark);
        if(flag==1) System.out.println("找不到容量合适的空分区！");
    }
    public void bestFit(Task task){
        int require=task.require;
        emptyPartition.sort(new BestFitComparator());
        //将空闲分区根据begin的大小升序排列
        int flag=1;
        int removeMark = 0;
        for (Partition p:emptyPartition
        ) {
            int len=p.end-p.begin;
            if(len>=require) {
                Partition temp= new Partition(p.begin,p.end);
                task.partition=temp;
                p.begin += require;
                taskHashMap.put(task.name,task);
                flag=0;
                removeMark=emptyPartition.indexOf(p);
                break;

            }
        }
        if(emptyPartition.get(removeMark).begin==emptyPartition.get(removeMark).end)
            emptyPartition.remove(removeMark);
        if(flag==1) System.out.println("找不到容量合适的空分区！");
    }
    public void worstFit(Task task){
        int require=task.require;
        emptyPartition.sort(new WorstFitComparator());
        //将空闲分区根据begin的大小升序排列
        int flag=1;
        int removeMark = 0;
        for (Partition p:emptyPartition
        ) {
            int len=p.end-p.begin;
            if(len>=require) {
                Partition temp= new Partition(p.begin,p.end);
                task.partition=temp;
                p.begin += require;
                taskHashMap.put(task.name,task);
                flag=0;
                removeMark=emptyPartition.indexOf(p);
                break;
            }
        }
        if(emptyPartition.get(removeMark).begin==emptyPartition.get(removeMark).end)
            emptyPartition.remove(removeMark);
        if(flag==1) System.out.println("找不到容量合适的空分区！");
    }
    public void recycle(String taskName){
        Task task=taskHashMap.get(taskName);
        Partition partition=task.partition;
        this.add(partition);
        taskHashMap.remove(taskName);
        merge();
    }
    public void show(){
        //展示当前可用空分区
        emptyPartition.sort(new FirstFitComparator());
        System.out.println("剩余分区展示如下：");
        for (int i = 0; i < emptyPartition.size(); i++) {
            System.out.println("第"+(i+1)+"个空闲分区："+"起始地址为："+
                    emptyPartition.get(i).begin+
                    ",结束地址为："+emptyPartition.get(i).end);
        }

        if (!taskHashMap.isEmpty()) {
            System.out.println("任务分配表：");
            for (Map.Entry<String,Task> args:taskHashMap.entrySet()
                 ) {
                Task task=args.getValue();
                System.out.println(task.name+"号作业占用区域 "+"起始地址为："
                        +task.partition.begin
                        +",结束地址为："+(task.partition.begin+task.require));

            }

        }

    }
    
    public static class FirstFitComparator implements Comparator<Partition>{
        //用于首次适应算法以及输出展示剩余分区
        @Override
        public int compare(Partition o1, Partition o2) {
            return o1.begin-o2.begin;
        }
    }
    public static class BestFitComparator implements Comparator<Partition>{
        //用于最佳适应算法
        @Override
        public int compare(Partition o1, Partition o2) {
            return o1.end - o1.begin - (o2.end - o2.begin);
        }
    }
    public static class WorstFitComparator implements Comparator<Partition>{
        //用于最坏适应算法
        @Override
        public int compare(Partition o1, Partition o2) {
            return o2.end - o2.begin - (o1.end - o1.begin);
        }
    }
    public void merge(){
        //合并第一对应该出现的相邻空分区
        emptyPartition.sort(new FirstFitComparator());
        for(int i=1;i<emptyPartition.size();i++) {
            if (emptyPartition.get(i).begin == emptyPartition.get(i - 1).end) {
                emptyPartition.get(i - 1).end = emptyPartition.get(i).end;
                emptyPartition.remove(i);
                break;
            }
        }
    }

}
