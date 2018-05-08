public class Dictionary implements DictionaryInterface{
	private class Node{
		String key;
		String value;
		Node next;
		
		private Node(String k, String v){
			//Key refers to the Place
			key=k;
			//value refers to whats inside that node
			value=v; 
			next=null;
		}
	}
	
	private Node head; 
	private int numItems; //at the end of insert and delete there should be a numitems++ or -- to represent that there more nodes now
	//Starting value of the dictionary no new nodes & head is null
	public Dictionary(){
		head=null;
		numItems=0;
	}
	
	//Determines if Empty
	//will know that it is empty because numitems is still 0
	public boolean isEmpty(){
		return(numItems==0);
	}
	//Brings back the size 
	//If anything was inserted then numItems wouldve gone up or down, so wouldnt be base
	public int size(){
		return numItems;
	}
	//If N is null returns null, however will return value of N looks up if there is a key within the node
	public String lookup(String key){
		Node N=findKey(key);
		if(N==null){
			return null;
		}else{
			return N.value;
		}
	}
	//value has to be null meaning that there is nothing inside of it, if there is anything within it then theree will be a duplicate
	public void insert(String key, String value)throws DuplicateKeyException{
		if (lookup(key)==null){
			//if there is nothing a new node will be created
			if (head==null){
				Node N=new Node(key, value);
				head=N;
			}else{
				//otherwise the N becomes head, If N is not null, if the n.next is null fcn will break
				Node N=head;
				//while loop, was referenced from friend (if N is not null, it will traverse the node until it gets to null breaking it out of while loop
				while(N!=null){
					if (N.next==null){
						break;
					}
					N=N.next;
				}
			//If head  is not null then a new node will be created
			N.next=new Node(key, value);
			}
	
		}else{
			throw new DuplicateKeyException("Error cannot insert duplicate keys");
		}
		numItems++;
	}
	//Will look up a specific Key and delete it
	//referenced sources from github, stackoverflow, and friend resources
	public void delete(String key)throws KeyNotFoundException{ 
		Node N=findKey(key);
		//Looks up if there is anything in that node if not returns an error
		//if there is no key then there is nothing to delete
		if (lookup(key==null)){
			KeyNotFoundException("Error: cannot delete nonexistent keys");
		}else{
			//There is something in the key 
			//If the N is head. will store head into H, and head will store its next value, N.next will become null, there is no more N
			if (N==head){
				Node H=head;
				head = head.next;
				N.next=null;
			}else{
				//Asked friend for how to do this section
				Node P=head;
				while(P!=null){
					Node H=P.next;
					String getKey=H.key;
					if(getKey.equals(key)){
						break;
					}
					P=P.next;
				}
				
				Node H=P.next;
				Node S=H.next;
				if(S==null){
					H.next=null;
					P.next=null;
				}else{
					P.next=S;
					H.next=null;
				}
			}
		}
		numItems--;
	}
	//makes the head null, and amount 0 reseting everything
	public void makeEmpty(){
		head=null;
		numItems=0;
	}
	
	//To string referenced online
	public String toString(){
		String s="";
		StringBuffer sb=new StringBuffer();
		Node N=head;
		while(N!=null){
			sb.append(N.key.append(" ").append(N.value).append("\n"));
			N=N.next;
		}
		return new String(sb);
	}
	
	private Node findKey(String key){
		Node N=head;
		//While N is not null getKey is what the value of N is at the key
		//if they are not equal then it looks at the next node, otherwise it will return the value of N
		//if N is null will return null
		while(N!=null){
			String getKey=N.key;
			if(!getgKey.equals(key)){
				N=N.next;
			}else{
				return N;
			}
		}
		return null;
	}
	//Whole function is meant to at previous nodes 
	//Find previousnode looked up online on github while looking for how to do toString & delete? is this useful for anything
	private Node findPreviousNode(String key){
		for (Node P=head; P!=null; P=P.next){
			Node N=P.next;
			String getKey=N.key;
			if(getKey.equals(key)){
				return P;
			}
		}
		return null;
	}
}