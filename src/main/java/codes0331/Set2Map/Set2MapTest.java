package codes0331.Set2Map;

public class Set2MapTest {
    public static void main(String[] args) {
        Set2Map<String, Integer> scores = new Set2Map<String, Integer>();
        scores.put("语文", 89);
        scores.put("数学", 83);
        scores.put("英文", 80);
        System.out.println(scores);
        System.out.println(scores.size());
        scores.removeEntry("数学");
        System.out.println("删除数学后的键值对" + scores);
        System.out.println("语文成绩 ： " + scores.get("语文"));
        System.out.println("是否包含英文？" + scores.containKey("英文"));
        System.out.println("是否包含82这个值？" + scores.containValue(82));
        scores.clear();
        System.out.println("执行clear()之后的集合:" + scores);
    }
}
