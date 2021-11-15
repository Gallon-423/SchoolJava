/**
 * @Author Gallon
 * @ClassName Task
 * @Package
 * @Description 表示作业，name表示作业号，require表示所需分区大小。
 * @Time 2021-11-15,周一 10:32
 */

public class Task {
    int require;
    String name;
    Partition partition;
    public Task(int require, String name) {
        this.require = require;
        this.name = name;
    }
}
