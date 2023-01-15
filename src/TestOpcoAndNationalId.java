import java.util.*;

public class TestOpcoAndNationalId {

    private Map<String, List<String>> uomMap = new HashMap<>();
    private Map<String, List<String>> ogmMap = new HashMap<>();
    private Map<String, List<String>> resultMap = new HashMap<>();

    private void setUomMap(){
        uomMap.put("AAFL",Arrays.asList("001","002","003","004"));
        uomMap.put("ABFH",Arrays.asList("001","003","004"));
        uomMap.put("AITR",Arrays.asList("001","003"));
        uomMap.put("AISH",Arrays.asList("001","002","004"));
    }

    private void setOgmMap(){
        ogmMap.put("AAFL",Arrays.asList("001","002","003","004"));
        ogmMap.put("ABFH",Arrays.asList("001","004"));
        ogmMap.put("AITR",Arrays.asList("001","003"));
    }

    public void testMethod(){
        setUomMap();
        setOgmMap();
        Set<String> uomKeys = uomMap.keySet();
        Set<String> ogmKeys = ogmMap.keySet();
        List<String> opcoListToBeAdded = new ArrayList<>();
        for(String uomKey : uomKeys) {
           if(ogmKeys.contains(uomKey)){
               List<String> uomOpcoList = uomMap.get(uomKey);
               List<String> ogmOpcoList = ogmMap.get(uomKey);
               uomOpcoList.stream().forEach(opco -> {
                   if(!ogmOpcoList.contains(opco)){
                       opcoListToBeAdded.add(opco);
                   }
                   resultMap.put(uomKey,opcoListToBeAdded);
               });
           }else {
               System.out.println(uomKey+ " is not present");
           }
        }
    }

}
