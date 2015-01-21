package parts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HierarchyTree
{

	private static class Data
	{
		Integer dealId;
		Integer ancestorId;
		Integer descendantId;
		Integer depth;

		private Data(Integer dealId, Integer ancestorId, Integer descendantId, Integer depth)
		{
			super();
			this.dealId = dealId;
			this.ancestorId = ancestorId;
			this.descendantId = descendantId;
			this.depth = depth;
		}

		public Integer getDealId()
		{
			return dealId;
		}

		public void setDealId(Integer dealId)
		{
			this.dealId = dealId;
		}

		public Integer getAncestorId()
		{
			return ancestorId;
		}

		public void setAncestorId(Integer ancestorId)
		{
			this.ancestorId = ancestorId;
		}

		public Integer getDescendantId()
		{
			return descendantId;
		}

		public void setDescendantId(Integer descendantId)
		{
			this.descendantId = descendantId;
		}

		public Integer getDepth()
		{
			return depth;
		}

		public void setDepth(Integer depth)
		{
			this.depth = depth;
		}
	}

	public hierarchyTree(Integer descendantId)
	{
		this.id = descendantId;
	}

	public hierarchyTree()
	{
		// TODO Auto-generated constructor stub
	}

	public hierarchyTree(Integer descendantId, Integer ancestorId)
	{
		this.id = descendantId;
		this.parentId = ancestorId;
	}

	public static void main(String[] args)
	{

		String text = "i  want  to  replace   multiple space";
		System.out.println(text);
		text = text.replaceAll("\\s+?", " ");
		System.out.println(text);

		List<Data> data = new ArrayList<Data>();
		data.add(new Data(1, 1, 1, 0));
		data.add(new Data(1, 1, 2, 1));
		data.add(new Data(1, 1, 3, 1));
		data.add(new Data(1, 2, 4, 1));
		data.add(new Data(1, 3, 5, 1));
		data.add(new Data(1, 3, 7, 1));
		data.add(new Data(1, 4, 8, 1));
		data.add(new Data(1, 4, 9, 1));
		data.add(new Data(1, 5, 11, 1));
		data.add(new Data(1, 7, 14, 1));

		hierarchyTree tree = new hierarchyTree();
		Map<Integer, hierarchyTree> cache = new HashMap<Integer, hierarchyTree>();

		for (Data row : data)
		{
			if (row.ancestorId == row.descendantId)
			{
				tree.id = row.ancestorId;
				cache.put(tree.id, tree);
				continue;
			}
			hierarchyTree child = new hierarchyTree(row.descendantId, row.ancestorId);
			// ClosureTree parent = findParent(row.ancestorId, tree);
			hierarchyTree parent = cache.get(child.getParentId());
			cache.put(child.id, child);
			parent.getChildren().add(child);
		}
		for (Map.Entry i : cache.entrySet())
		{
			System.out.println(i.getKey() + ", " + i.getValue());
		}
	}

	private static hierarchyTree findParent(Integer ancestorId, hierarchyTree node)
	{
		if (ancestorId == 0)
		{
			return null;
		}
		if (ancestorId == node.id)
		{
			return node;
		}
		for (hierarchyTree child : node.getChildren())
		{
			hierarchyTree parent = findParent(ancestorId, child);
			if (parent == null)
			{
				continue;
			}
			return parent;
		}
		return null;
	}

	public hierarchyTree parent;
	public List<hierarchyTree> children = new ArrayList<hierarchyTree>();
	public Integer id;
	public Integer parentId;

	public Integer getParentId()
	{
		return parentId;
	}

	public void setParentId(Integer parentId)
	{
		this.parentId = parentId;
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public hierarchyTree getParent()
	{
		return parent;
	}

	public void setParent(hierarchyTree parent)
	{
		this.parent = parent;
	}

	public List<hierarchyTree> getChildren()
	{
		if (children == null)
		{
			children = new ArrayList<hierarchyTree>();
		}
		return children;
	}

	public void setChildren(List<hierarchyTree> children)
	{
		this.children = children;
	}

	public String toString()
	{
		return "Node " + this.id;
	}

}