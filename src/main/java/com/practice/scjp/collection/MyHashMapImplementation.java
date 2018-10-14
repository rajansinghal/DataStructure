package com.practice.scjp.collection;

class Entry{
	
	final String key;
	String value;
	Entry next;
	Entry(String key, String value){
		
		this.key=key;
		this.value=value;
		
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}

	public String getKey() {
		return key;
	}
	
}
public class MyHashMapImplementation {

	/**
	 * @param args
	 */
	private static final int SIZE = 16;
	private Entry table[] = new Entry[SIZE];
	
	
	public void put(String k, String v){
		
		int i=k.hashCode() % SIZE;
		Entry e=table[i];
		if(e == null){
			
			Entry ent= new Entry(k,v);
			System.out.println(ent.key);
			table[i] = ent;
		}
		else{
			boolean flag=true;
			while(e !=null){
				if(k.equalsIgnoreCase(e.getKey())){
					System.out.println(e.key);
					e.value=v;
					flag =false;
					break;
				}	
				
			}
			if(flag){
				while(e!=null){
						
						e=e.next;
					}
				Entry e1=new Entry(k,v);
				System.out.println(e1.key);
				e.next=e1;
				}
			}
		}
		
	
	public String get(String k){
		
		int i=k.hashCode() % SIZE;
		Entry e=table[i];
		if(e == null){
			
			System.out.println("already empty...");
			return null;
		}
		else{
			
			while(e !=null){
				if(k.equalsIgnoreCase(e.getKey())){
					
					return e.value;
				
					
				}
				else{
					System.out.println("------------------" + e.value);
					e=e.next;
				}
				
			}
			if(e == null){
				System.out.println("not present");
				return "false";
			}
		}
		return null;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyHashMapImplementation myhash= new MyHashMapImplementation();
		myhash.put("rajan","BMW");
		/*myhash.put("rajan","OPEL");*/
		myhash.put("nitin","FIAT");
		myhash.put("ankit","AUDI");
		System.out.println("all puting done.......now sleeping");
		/*myhash.put("pankaj","SX4");*/
		System.out.println(myhash.get("nitin"));

	}

}
