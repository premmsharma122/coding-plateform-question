class Pair{
    String word;
    int st;
    Pair(String word, int st){
        this.word = word;
        this.st = st;
    }
}
class Solution {
    
    public int wordLadderLength(String startWord, String targetWord,
                                String[] wordList) {
        // Code here
        Queue<Pair> q = new LinkedList<>();
        HashSet<String> s = new HashSet<>();
        q.add(new Pair(startWord,1));
        for(int i=0; i<wordList.length; i++){
            s.add(wordList[i]);
        }
        s.remove(startWord);
        while(!q.isEmpty()){
            String w = q.peek().word;
            int step = q.peek().st;
            q.remove();
            if(targetWord.equals(w)) return step;
            
            for(int i=0; i<w.length(); i++){
                for(char j='a'; j<='z'; j++){
                    char arr[] = w.toCharArray();
                    arr[i] = j;
                    String nw = new String(arr);
                    if(s.contains(nw)){
                        s.remove(nw);
                        q.add(new Pair(nw,step+1));
                        
                    }
                    
                }
            }
        }
        return 0;
        
        
        
    }
}
