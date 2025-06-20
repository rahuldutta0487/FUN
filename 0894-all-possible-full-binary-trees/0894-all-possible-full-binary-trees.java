class Solution {
    Map<Integer, List<TreeNode>> cache = new HashMap();
    
    public List<TreeNode> allPossibleFBT(int n) {
        if(cache.containsKey(n)) return cache.get(n);
        
        List<TreeNode> trees = new LinkedList();
        
        //n is even
        //when n is even, can't have any FBT
        if(n % 2 == 0) return trees;
        
        //base case
        //n is 1, just add one tree return
        if(n == 1){
            trees.add(new TreeNode(0));
            cache.put(n, trees);
            return trees;
        }
        
        //n is odd
        //e.g n = 7
        // x = 1, 3, 5 -  nodes in left subtree
        // y = 5, 3, 1 -  nodes in right subtree
            
        for(int x = 1; x < n; x += 2){
            int y = n - 1 - x;

            for(TreeNode left : allPossibleFBT(x)){

                for(TreeNode right : allPossibleFBT(y)){
                        
                        //create a new tree
                        TreeNode tree = new TreeNode(0);
                    
                        //swallow copy of left subtrees
                        tree.left = left;
                    
                        //swallow copy of right subtree
                        tree.right = right;

                        trees.add(tree);
                }    
            }
        }
        
        //save the trees, to avoid recreating the trees
        cache.put(n, trees);
        
        //if we want avoid the connected tree in the list
        //we have to deep copy of each tree
        List<TreeNode> clonedTrees = new LinkedList();
        for(TreeNode tree : trees){
            //add deep copy of tree
            clonedTrees.add(deepCopy(tree));
        }
        
        return clonedTrees;
    }
    
    
    public TreeNode deepCopy(TreeNode tree)  {
        if (tree == null) return null;
        
        //create new TreeNode
        TreeNode newTree = new TreeNode(tree.val);
        
        //deep copy left substree
        newTree.left = clone(tree.left);
        
        //deep copy right subtree
        newTree.right = clone(tree.right);
        
        return newTree;
    }
}