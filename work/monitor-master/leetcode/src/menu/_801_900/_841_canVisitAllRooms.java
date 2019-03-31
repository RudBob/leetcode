package menu._801_900;

import java.util.List;

public class _841_canVisitAllRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if(rooms == null || rooms.size() == 0){
            return true;
        }
        boolean[] opened = new boolean[rooms.size()];
        opened[0] = true;
        List<Integer> keys = rooms.get(0);
        openDoorsByKey(keys, opened, rooms);
        for (boolean open : opened) {
            if (!open) {
                return false;
            }
        }
        return true;
    }

    private void openDoorsByKey(List<Integer> keys, boolean[] opened, List<List<Integer>> rooms) {
        for (Integer key : keys) {
            if (!opened[key]) {
                opened[key] = true;
                openDoorsByKey(rooms.get(key),opened,rooms);
            }
        }
    }
}
