package com.meenu.coding.problems.hard;

import java.util.*;

/**
 * @author Meenu V. Nair
 * @created 20/08/25
 */

/*******  APPROACH ******************** 

 */

/**** COMPLEXITY ANALYSIS ********************
 Time complexity: O((n∗m)log(n∗m))
 Space complexity: O(n∗m)

 Where n is the number of accounts and m is the number of emails.
 */

public class AccountsMerge {
    class UnionFind {
        int[] parent;
        int[] rank;

        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];

            for(int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int n) {
            int p = parent[n];
            while(p != parent[p]) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }

        public boolean union(int n1, int n2) {
            int p1 = find(n1);
            int p2 = find(n2);

            if(p1 == p2)
                return false;
            if(rank[p1] > rank[p2]) {
                parent[p2] = p1;
                rank[p1] += rank[p2];
            } else {
                parent[p1] = p2;
                rank[p2] += rank[p1];
            }
            return true;
        }
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        UnionFind uf = new UnionFind(n);

        Map<String, Integer> emailToAccount = new HashMap<>(); // email -> index of acc

        // Build union-find structure
        for(int i = 0; i < n; i++) {
            List<String> account = accounts.get(i);
            for(int j = 1; j < account.size(); j++) {
                String email = account.get(j);
                if(emailToAccount.containsKey(email)) {
                    uf.union(i, emailToAccount.get(email));
                } else {
                    emailToAccount.put(email, i);
                }
            }
        }

        // Group emails by leader account
        Map<Integer, List<String>> emailGroup = new HashMap<>(); // index of acc -> list of emails
        for(Map.Entry<String, Integer> entry : emailToAccount.entrySet()) {
            String email = entry.getKey();
            int accountId = entry.getValue();
            int leader = uf.find(accountId);
            emailGroup.putIfAbsent(leader, new ArrayList<>());
            emailGroup.get(leader).add(email);
        }

        // Build result
        List<List<String>> result = new ArrayList<>();
        for(Map.Entry<Integer, List<String>> entry : emailGroup.entrySet()) {
            int accountId = entry.getKey();
            String name = accounts.get(accountId).get(0);
            List<String> emails = entry.getValue();
            Collections.sort(entry.getValue());
            List<String> mergedList = new ArrayList<>();
            mergedList.add(name);
            mergedList.addAll(emails);
            result.add(mergedList);
        }
        return result;
    }

    public static void main(String[] args) {
        AccountsMerge obj = new AccountsMerge();

        List<List<String>> accounts = new ArrayList<>();
        accounts.add(Arrays.asList("John", "john1@mail.com", "john12@mail.com"));
        accounts.add(Arrays.asList("Jacob", "John12@email.com", "Jacob@gmail.com"));
        accounts.add(Arrays.asList("Lisa", "Lisa2@email.com", "Lisa@gmail.com"));
        accounts.add(Arrays.asList("Alice", "e@mail.com"));
        //System.out.println(accounts.toString());

        List<List<String>> output = obj.accountsMerge(accounts);

        System.out.println(output.toString());
    }
}

/*******  PROBLEM DESCRIPTION ******************** 
 Given a list of accounts where each element accounts[i] is a list of strings, where the first element accounts[i][0] is a name, and the rest of the elements are emails representing emails of the account.

 Now, we would like to merge these accounts. Two accounts definitely belong to the same person if there is some common email to both accounts. Note that even if two accounts have the same name, they may belong to different people as people could have the same name. A person can have any number of accounts initially, but all of their accounts definitely have the same name.

 After merging the accounts, return the accounts in the following format: the first element of each account is the name, and the rest of the elements are emails in sorted order. The accounts themselves can be returned in any order.



 Example 1:

 Input: accounts = [["John","johnsmith@mail.com","john_newyork@mail.com"],["John","johnsmith@mail.com","john00@mail.com"],["Mary","mary@mail.com"],["John","johnnybravo@mail.com"]]
 Output: [["John","john00@mail.com","john_newyork@mail.com","johnsmith@mail.com"],["Mary","mary@mail.com"],["John","johnnybravo@mail.com"]]
 Explanation:
 The first and second John's are the same person as they have the common email "johnsmith@mail.com".
 The third John and Mary are different people as none of their email addresses are used by other accounts.
 We could return these lists in any order, for example the answer [['Mary', 'mary@mail.com'], ['John', 'johnnybravo@mail.com'],
 ['John', 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com']] would still be accepted.
 Example 2:

 Input: accounts = [["Gabe","Gabe0@m.co","Gabe3@m.co","Gabe1@m.co"],["Kevin","Kevin3@m.co","Kevin5@m.co","Kevin0@m.co"],["Ethan","Ethan5@m.co","Ethan4@m.co","Ethan0@m.co"],["Hanzo","Hanzo3@m.co","Hanzo1@m.co","Hanzo0@m.co"],["Fern","Fern5@m.co","Fern1@m.co","Fern0@m.co"]]
 Output: [["Ethan","Ethan0@m.co","Ethan4@m.co","Ethan5@m.co"],["Gabe","Gabe0@m.co","Gabe1@m.co","Gabe3@m.co"],["Hanzo","Hanzo0@m.co","Hanzo1@m.co","Hanzo3@m.co"],["Kevin","Kevin0@m.co","Kevin3@m.co","Kevin5@m.co"],["Fern","Fern0@m.co","Fern1@m.co","Fern5@m.co"]]


 Constraints:

 1 <= accounts.length <= 1000
 2 <= accounts[i].length <= 10
 1 <= accounts[i][j].length <= 30
 accounts[i][0] consists of English letters.
 accounts[i][j] (for j > 0) is a valid email.

 Hint 1
 For every pair of emails in the same account, draw an edge between those emails.
 The problem is about enumerating the connected components of this graph.
 */
