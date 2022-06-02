
public class StacksAndQueues {
	
	static class Item{
		int data;
		Item next;
		
		public Item(int data) {
			this.data = data;
		}
		
		public Item(int data, Item next) {
			this.data = data;
			this.next = next;
		}
	}
	
	static class Stacky<Integer>{
		int size = 0;
		Item top;
		Item lowest;
		
		void push(int data) {
			Item newItem = new Item(data);
			
			if (isEmpty()) {
				top = newItem;
				lowest = newItem;
			}
			
			else 
				if (newItem.data <= lowest.data)
					lowest = newItem;

			newItem.next = top;
			top = newItem;
			size++;
		}
		
		Item pop() {
			if (size == 0) throw new RuntimeException("Stack is empty!");
			
			size--;
			Item deleted = top;
			top = top.next;
			return deleted;
		}
		
		Item min() {
			return lowest;
		}
		
		boolean isEmpty() {
			return size == 0;
		}
		
		void print() {
			int tempSize = size;
			Item  temptop = top;
			if (size == 0) {
				throw new RuntimeException("Stack is empty!");
			}
			
			while (size > 0) {
				System.out.println(top.data);
				top = top.next;
				size--;
			}
			size = tempSize;
			top = temptop;
			System.out.println("--");
		}
	}
	
	public static void main(String[] args) {
			
	}
	
	static void testStackMin() {
		Stacky<Integer> stack = new Stacky<>();
		
		stack.push(0);
		stack.push(3);
		stack.push(1);
		stack.push(5);
		stack.push(4);
		stack.push(10);
		
		stack.print();
		
		System.out.println(stack.min().data);
	}

	
}
