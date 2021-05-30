import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Mission {
    public int coin;
    public int time;
    public int level;
    public HashMap<String ,Integer> wildAnimals;
    public HashMap<String ,Integer> productTasks;
    public HashMap<String ,Integer> animalTask;
    public int stars;

    public Mission(){
        wildAnimals= new HashMap<>();
        productTasks=new HashMap<>();
        animalTask=new HashMap<>();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Mission mission=new Mission();
        mission.productTasks= (HashMap<String, Integer>) this.productTasks.clone();
        mission.animalTask= (HashMap<String, Integer>) this.animalTask.clone();
        mission.wildAnimals= (HashMap<String, Integer>) this.wildAnimals.clone();
        mission.coin=this.coin;
        mission.time=this.time;
        mission.stars=this.stars;
        mission.level=this.level;
        return mission;
    }
}
