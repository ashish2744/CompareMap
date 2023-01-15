import java.util.*;

public class TestOpcoAndNationalId {

    private Map<String, List<String>> uomMap = new HashMap<>();
    private Map<String, List<String>> ogmMap = new HashMap<>();

    private void setUomMap(){
        uomMap.put("AAFL", Arrays.asList("002","003","004","001"));
        uomMap.put("ABFH",Arrays.asList("003","001","004","002"));
        uomMap.put("AITR",Arrays.asList("001","002","003"));
        uomMap.put("AISH",Arrays.asList("001","002","004"));
    }

    private void setOgmMap(){
        ogmMap.put("AAFL",Arrays.asList("001","002","003","004"));
        ogmMap.put("ABFH",Arrays.asList("001","004"));
        ogmMap.put("AITR",Arrays.asList("001","003"));
    }

    public void dataProvider(){
        setUomMap();
        setOgmMap();
    }

    public void compareMap(){
        Set<String> uomKeys = uomMap.keySet();
        Set<String> ogmKeys = ogmMap.keySet();
        for(String uomKey : uomKeys) {
            List<String> opcoListToBeAdded = new ArrayList<>();
            Map<String, List<String>> resultMap = new HashMap<>();
            if(ogmKeys.contains(uomKey)){
                List<String> uomOpcoList = uomMap.get(uomKey);
                List<String> ogmOpcoList = ogmMap.get(uomKey);
                uomOpcoList.stream().forEach(opco -> {
                    if(!ogmOpcoList.contains(opco)){
                        opcoListToBeAdded.add(opco);
                    }
                });
                resultMap.put(uomKey,opcoListToBeAdded);
                System.out.println("Result map if: "+resultMap);
            }else {
                resultMap.put(uomKey, uomMap.get(uomKey));
                System.out.println("Result map else: "+resultMap);
            }
        }
    }

}
