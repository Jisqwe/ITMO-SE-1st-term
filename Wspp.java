import java.io.*;
import java.util.*;

public class Wspp {
    public static void main(String[] args) {
        Map<String, ArrayList<Integer>> map = new LinkedHashMap<>();
        int coooo = 0;
        String fileIn = args[0];
        String fileOut = args[1];
        StringBuilder sb = new StringBuilder();
        int totalWord = 0;
        try{
            BufferedReader reader = new BufferedReader(new FileReader(fileIn));
            try{
                int symbol = reader.read();
                while (symbol >= 0){
                    if(Character.DASH_PUNCTUATION == Character.getType((char) symbol) || Character.isLetter((char) symbol) || ((char) symbol) == '\''){
                        sb.append((char) symbol);
                    }
                    else{
                        if(!sb.isEmpty()){
                            totalWord = totalWord + 1;
                            String word = sb.toString().toLowerCase();
                            if(map.containsKey(word)){
                                ArrayList<Integer> res = map.get(word);
                                res.set(0, res.get(0) + 1);
                                res.add(totalWord);
                                map.put(word, res);
                                sb.setLength(0);
                            }
                            else{
                                ArrayList<Integer> res = new ArrayList<>();
                                res.add(1);
                                res.add(totalWord);
                                map.put(word, res);
                                sb.setLength(0);
                            }
                        }
                    }
                    symbol = reader.read();
                }
                if(!sb.isEmpty()){
                    totalWord = totalWord + 1;
                    String word = sb.toString().toLowerCase();
                    if(map.containsKey(word)){
                        ArrayList<Integer> res = map.get(word);
                        res.set(0, res.get(0) + 1);
                        res.add(totalWord);
                        map.put(word, res);
                    }
                    else{
                        ArrayList<Integer> res = new ArrayList<>();
                        res.add(1);
                        res.add(totalWord);
                        map.put(word, res);
                        sb.setLength(0);
                    }
                }
            } catch(IOException e){
                System.out.println("IOException error: " + e.getMessage());
            } finally {
                reader.close();
            }
        } catch (IOException e){
            System.out.println("IOException error: " + e.getMessage());
        }
        try {
            BufferedWriter writter = new BufferedWriter(new FileWriter(fileOut));
            try{
                for (String key: map.keySet()){
                    int k = (map.get(key)).size();
                    writter.write(key);
                    for (int i = 0; i < k; i++){
                        writter.write(" " + (map.get(key)).get(i));
                    }
                    writter.write("\n");
                }
            } catch (IOException e){
                System.out.println("IOException error: " + e.getMessage());
            } finally{
                writter.close();
            }
        }catch (IOException e){
            System.out.println("IOException error: " + e.getMessage());
        }
    }
}