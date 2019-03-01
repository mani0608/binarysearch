import java.util.Stack;

public class TreeIterator {
	
	Tree root = null;
	Tree nextLeft = null;
	Tree nextRight = null;
	Stack<Tree> parents = null;
	
	TreeIterator(Tree t) {
		this.root = t;
		this.nextLeft = t.left;
		this.nextRight = t.right;
		this.parents = new Stack<>();
		this.parents.push(t);
	}
	
	public boolean hasNext() {
		return (this.nextLeft != null || this.nextRight != null);
	}
	
	public boolean isLeaf(Tree t) {
		return (t.left == null && t.right == null);
	}
	
	public Tree next() {
		
		Tree current = (this.nextLeft != null) ? this.nextLeft : this.nextRight;		
		
		if (current == null) {
			while (current == null && !this.parents.isEmpty()) {
				current = this.parents.pop();
				current = current.right;
			}
		}
		
		if (this.parents.isEmpty() && current == null) {
			return null;
		}
		
		if (current != null) {
			if (!this.isLeaf(current)) {
				this.parents.push(current);
				this.nextLeft = current.left;
				this.nextRight = current.right;
			} else {
				this.nextLeft = null;
				this.nextRight = this.getNextAvailable();
			}
		} 
		
		return current;
		
	}
	
	public Tree getNextAvailable() {
		
		Tree nextAvailable = null;
		
		while (nextAvailable == null && !this.parents.isEmpty()) {
			nextAvailable = this.parents.pop();
			nextAvailable = nextAvailable.right;
		}
		
		return nextAvailable;
		
	}

}
