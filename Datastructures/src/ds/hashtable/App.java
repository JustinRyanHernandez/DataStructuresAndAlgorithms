package ds.hashtable;

public class App {

	public static void main(String[] args) {
		
		HashTable table = new HashTable(19);
		table.insert("Apple");
		table.insert("Hello");
		table.insert("Feeling");
		table.insert("Water");
		table.insert("Africa");
		table.insert("Speed");
		table.insert("Phone");
		table.insert("September");
		table.insert("Justin");
		table.insert("Milk");
		table.insert("Dog");
		table.insert("Cat");
		table.insert("Huge");
		
		
		
		System.out.println("------FIND ELEMENTS-------");
		System.out.println(table.find("Apple"));
		System.out.println(table.find("Zebra"));
		System.out.println(table.find("Milk"));
		System.out.println(table.find("Justin"));
		System.out.println(table.find("Cat"));
		System.out.println(table.find("Hello"));

	}

}
