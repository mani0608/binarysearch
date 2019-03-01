import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.google.gson.Gson;

public class SearchTree {
	
	Integer nodeCount = 1;
	Set<Integer> values = null;
	boolean isFound = false;
	
	Integer countDistinct (Tree t) {
		
		System.out.println("Started at " + new Date());
		
		this.values = new HashSet<>();
		
		TreeIterator iterator = new TreeIterator(t);
		
		while (iterator.hasNext()) {
			Tree tree = iterator.next();
			values.add(tree.value);
			System.out.println("Current: " + tree.value);
			nodeCount++;
			if (iterator.isLeaf(tree)) {
				if (values.size() == nodeCount) {
					System.out.println("Values: " + this.values + " count: " + nodeCount);
					this.isFound = true;
					break;
				} else {
					System.out.println("Values: " + this.values + " count: " + nodeCount);
					System.out.println("Cleared");
					values.clear();
					values.add(t.value);
					nodeCount = 1;
				}
			}
		}
		
		System.out.println("Ended at " + new Date());
		
		return (this.isFound) ? values.size() : 0;
		
	}
	
	
	public static void main (String args[]) {
		
		SearchTree sTree = new SearchTree();
		Tree root = null;
		Tree parent = null;
		Tree temp = null;
		
		Tree leaf = new Tree();
		leaf.value = 5;
		
		parent = new Tree();
		parent.value = 4;
		parent.left = leaf;
		
		temp = parent;
		
		parent = new Tree();
		parent.value = 5;
		parent.left = temp;
		
		temp = parent;
		
		parent = new Tree();
		parent.value = 4;
		parent.left = temp;
		
		root = new Tree();
		root.value = 4;
		root.left = parent;
		
		leaf = new Tree();
		leaf.value = 6;
		
		parent = new Tree();
		parent.value = 6;
		parent.right = leaf;
		
		leaf = new Tree();
		leaf.value = 1;
		parent.left = leaf;
		
		root.right = parent;
		
		System.out.println("Result: " + sTree.countDistinct(root));
		
		Gson gson = new Gson();
		
		System.out.println(gson.toJson(root));
		
	}

}
