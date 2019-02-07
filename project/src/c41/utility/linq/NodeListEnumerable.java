package c41.utility.linq;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import c41.core.assertion.Arguments;
import c41.utility.linq.enumerator.IEnumerator;
import c41.utility.linq.enumerator.ReferenceEnumeratorBase;

class NodeListEnumerable implements IReferenceEnumerable<Node>{

	private final NodeList nodes;
	
	public NodeListEnumerable(NodeList nodes) {
		Arguments.isNotNull(nodes);
		this.nodes = nodes;
	}

	@Override
	public IEnumerator<Node> iterator() {
		return new Enumerator();
	}

	@Override
	public int count() {
		return nodes.getLength();
	}
	
	private final class Enumerator extends ReferenceEnumeratorBase<Node>{

		private int index = -1;
		
		@Override
		public boolean hasNext() {
			return index + 1 < nodes.getLength();
		}

		@Override
		public Node doNext() {
			return nodes.item(++index);
		}
		
	}
	
}
