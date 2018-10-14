package com.practice.scjp.collection;

public class MyHashMap  {
	
	public static final int SIZE=16;
	public Entry table[]=new Entry[SIZE];
	
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
	public Entry get(String k){
		
		
        int hash = k.hashCode() % SIZE;
     
        Entry e = table[hash];
        // if bucket is found then traverse through the linked list and
        // see if element is present
        while(e != null) {
            if(e.key.equals(k)) {
                return e;
            }
            e = e.next;
        }
        return null;
	}
	public void put(String key, String value){
		int hash=key.hashCode() % SIZE;
		Entry ent=table[hash];
		if(ent !=null){
			while(ent.next != null){
				if(ent.key.equalsIgnoreCase(key)){
					ent.value=ent.value;
					break;
				}else{
					ent=ent.next;
				}
				
				
			}
			if(ent.next==null ){
				if(ent.key.equalsIgnoreCase(key))
					ent.value=value;
				else
				ent.next=new Entry(key,value);
			}
			
			
		}
		else{
			Entry entNew=new Entry(key,value);
			table[hash]=entNew;
		}
		
	}
	
	
	public static void main(String arr[]) {
		
		MyHashMap myhash= new MyHashMap();
		myhash.put("rajan","BMW");
		myhash.put("rajan","OPEL");
		myhash.put("nitin","FIAT");
		myhash.put("ankit","AUDI");
		System.out.println("all puting done.......now sleeping");
		/*myhash.put("pankaj","SX4");*/
		System.out.println(myhash.get("rajan").value);
	}

}
