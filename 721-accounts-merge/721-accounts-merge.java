class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        
        Map<String, HashSet<String>> graph = new HashMap<>();
        Set<String> visited = new HashSet<>();
        Map<String, String> owner = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        
        for(List<String> account : accounts) {
            String name = account.get(0);
            Set<String> neighbors = new HashSet<>(account);
            neighbors.remove(name);
            
            for(int i = 1 ; i < account.size() ; i++) {
                String email = account.get(i);
                if(!graph.containsKey(email)) {
                    graph.put(email, new HashSet<>());
                }
                graph.get(email).addAll(neighbors);
                owner.put(email, name);
            }
        }
        
        for(String email : owner.keySet()) {
            if(!visited.contains(email)) {
                List<String> subRes = new ArrayList<>();
                dfs(subRes, visited, graph, email);
                Collections.sort(subRes);
                subRes.add(0, owner.get(email));
                res.add(subRes);
            }
        }
        return res;
    }    
    
    
    private void dfs(List<String> subRes, Set<String> visited, Map<String, HashSet<String>> graph, String email) {
        
        visited.add(email);
        subRes.add(email);
        
        for(String neighbor : graph.get(email)) {
            if(!visited.contains(neighbor))
                dfs(subRes, visited, graph, neighbor);
        }
    }
}



/*
accounts =

["John","johnsmith@mail.com","john_newyork@mail.com"]["John","johnsmith@mail.com","john00@mail.com"]
["Mary","mary@mail.com"]
["John","johnnybravo@mail.com","john_newyork@mail.com"]



sol :

- map is not a good option since we are not merging by the names.

brute force :
O(numberOfAccounts * numberOfMailsInEachAcc^2)

- construct a graph.
- perform a dfs.


*/


/*

name, emails..


["John","johnsmith@mail.com","john_newyork@mail.com"]["John","johnsmith@mail.com","john00@mail.com"]
["John","john_newyork@mail.com","john11_newyork@mail.com"]

["Mary","mary@mail.com"]
["John","johnnybravo@mail.com"]

Brute Force:
N - emails in total
O(N^2)


Optimized:

johnsmith@mail.com - john_newyork@mail.com, john00@mail.com
john_newyork@mail.com - johnsmith@mail.com, john11_newyork@mail.com
john00@mail.com - johnsmith@mail.com
john11_newyork@mail.com - john_newyork@mail.com

mary@mail.com
johnnybravo@mail.com


*/




























