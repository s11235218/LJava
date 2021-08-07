package newCode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;

    public Employee(int id, int importance, List<Integer> subordinates) {
        this.id = id;
        this.importance = importance;
        this.subordinates = subordinates;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImportance() {
        return importance;
    }

    public void setImportance(int importance) {
        this.importance = importance;
    }

    public List<Integer> getSubordinates() {
        return subordinates;
    }

    public void setSubordinates(List<Integer> subordinates) {
        this.subordinates = subordinates;
    }
}

public class EmployeeImportance {
    public int DFS(Map<Integer, Employee> info, int id) {
        // 累加当前员工和直接下属的值
        int curImportance = info.get(id).importance;
        for(int subId: info.get(id).subordinates) {
            curImportance += DFS(info, subId);
        }
        return curImportance;
    }

    public int getImportance(List<Employee> employees, int id) {

        Map<Integer, Employee>info = new HashMap<>();
        for (Employee cur : employees) {
            info.put(cur.id, cur);
        }
        return DFS(info, id);
    }
}
