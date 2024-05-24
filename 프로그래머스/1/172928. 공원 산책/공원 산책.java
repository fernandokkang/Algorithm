class Solution {
    
    static char [][] map;
    
    public int[] solution(String[] park, String[] routes) {
        
        int x = 0;
        int y = 0;
        
        map = new char[park.length][park[0].length()];
        
        for(int i = 0; i < park.length; i++) {
            map[i] = park[i].toCharArray();
            
            if(park[i].contains("S")) {
                y = i;
                x = park[i].indexOf("S");
            }
        }
        
        return findRoute(x, y, map, routes);
    }
    
    private int[] findRoute(int x, int y, char [][] map, String[] routes) {
        
        for(String route : routes){
            String dir = route.split(" ")[0];
            int len = Integer.parseInt(route.split(" ")[1]);
            
            int nx = x;
            int ny = y;
            
            for(int i = 0; i < len; i++){
                if(dir.equals("E")){
                    nx++;
                }
                if(dir.equals("W")){
                    nx--;
                }
                if(dir.equals("S")){
                    ny++;
                }
                if(dir.equals("N")){
                    ny--;
                }
                if(nx >= 0 && ny >= 0 && ny < map.length && nx < map[0].length){
                    if(map[ny][nx] == 'X'){
                        break;
                    }
                    if(i == len - 1){
                        x = nx;
                        y = ny;
                    }
                }
            }
        }
        
        return new int[]{y, x};
    }
}