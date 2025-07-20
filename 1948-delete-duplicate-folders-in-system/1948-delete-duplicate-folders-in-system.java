class Solution {
    Folder start = new Folder("");
    Map<String, Integer> map = new HashMap<>();
    public List<List<String>> deleteDuplicateFolder(List<List<String>> ways) {
        for (List<String> way : ways)
            addway(way);
        for (Folder f : start.list)
            generateKey(f);
        for (Folder f : start.list)
            updateDeleteStatus(f);
        List<List<String>> ans = new ArrayList<>();
        for (List<String> way : ways)
            if (isValid(way))
                ans.add(way);
        return ans;
    }
    private boolean isValid(List<String> way){
        Folder curr = start;
        for (String f : way){
            curr = curr.map.get(f);
            if (curr.del)
                return false;
        }
        return true;
    }
    private void updateDeleteStatus(Folder f){
        if (f.list.size() > 0 && map.get(f.key) > 1){
            f.del = true;
            return;
        }
        for (Folder fold : f.list)
            updateDeleteStatus(fold);
    }
    private String generateKey(Folder fold){
        StringBuilder sb = new StringBuilder();
        if (fold.list.size() == 0)
            return sb.toString();
        Collections.sort(fold.list, (a, b) -> a.name.compareTo(b.name));
        for (Folder f : fold.list){
            sb.append('(');
            sb.append(f.name + generateKey(f));
            sb.append(')');
        }
        String key = sb.toString();
        fold.key = key;
        map.put(key, map.getOrDefault(key, 0) + 1);
        return key;
    }
    private void addway(List<String> way){
        Folder curr = start;
        for (String f : way){
            if (!curr.map.containsKey(f)){
                Folder fold = new Folder(f);
                curr.map.put(f, fold);
                curr.list.add(fold);
            }
            curr = curr.map.get(f);
        }
    }
}
class Folder{
    String name;
    Map<String, Folder> map;
    List<Folder> list;
    String key;
    boolean del;
    Folder(String name){
        this.name = name;
        map = new HashMap<>();
        list = new ArrayList<>();
        key = "";
        del = false;
    }
}