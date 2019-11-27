import java.util.ArrayList;

abstract class TreeNode {
	
	private String criterion;
	private TreeNode parent;
	private ArrayList<TreeNode> children;
	private ArrayList<String> criteria;
	
	public TreeNode(TreeNode parent, String criterion) {
		this.criterion = criterion;
		this.parent = parent;
		children = new ArrayList<TreeNode>();
		criteria = new ArrayList<String>();
	}
	
	public void addResident(ResidentModel res) {
		
	}
	
	public void addChild(String criterion) {
		
	}
	
	public void addChildren(String[] criteria) {
		
	}
	
	public void setChildren(String[] criteria) {
		
	}
	
	public ArrayList<TreeNode> getChildren() {
		return children;
	}
	
	public ArrayList<String> getCriteria() {
		return criteria;
	}
	
	public TreeNode getChild(String criteria) {
		
	}
}
