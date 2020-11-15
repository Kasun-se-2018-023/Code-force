import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Code_force{
      
	public static void main(String args[]) {
		ContactList obj = new ContactList();
        Scanner value = new Scanner(System.in);
        File file = new File("contactList.txt");
    
    
		int choice=0 ;
	    while(choice != 7) {
	    	System.out.println("Select an Option\n    • Enter 1 to display all contacts\r\n" + 
	    			"     • Enter 2 to add contact\r\n" + 
	    			"     • Enter 3 to remove contact\r\n" + 
	    			"     • Enter 4 to edit a contact\r\n" + 
	    			"     • Enter 5 to load contacts from a text file.\r\n" + 
	    			"     • Enter 6 to save contacts to the text file.\r\n" + 
                    "     • Enter 7 to exit from the program");
            
            choice  = value.nextInt();
            switch(choice){
                case 1:
                obj.allContact(file);
                break;
                case 2:
                obj.addContact(file);
                break;
                case 3:
                obj.removeContact(file);
                break;
                case 4:
                obj.editContact(file);
                break;
                case 5:
                obj.loadContactTextFile(file);
                break;
                case 6:
                obj.saveContactTextFile(file);
                break;
                case 7:
                continue;
                default:
                System.out.println("\n enter the correct choice....\n");
                break;

                 }
             }
    	}
	
}



 class Contacts{
    private String name;
    private String phoneNo;

    public void setname(){  
          this.name = name;
    }
    public String getname(){
        return name;
    }
    public void setphoneNo(){  
        this.phoneNo = phoneNo;
  }
  public String getphoneNo(){
      return phoneNo;
              }
    
}


class ContactList{
    Scanner in = new Scanner(System.in);
    ArrayList name = new ArrayList<>();
    ArrayList phoneNo = new ArrayList<>();



    void allContact(File file){
try {
        Scanner inFile = new Scanner(file);
        while(inFile.hasNextLine()){
            String data = inFile.nextLine();
            System.out.println(data);
            
        }}catch(Exception e) {
    }}




   
    void addContact(File file){
    	
    try {    System.out.println("Please enter name..\n");
        String nam = in.nextLine();
        name.add(nam);
        System.out.println("\nPlease add number\n");
        String phone = in.nextLine();
        FileWriter fileWriter = new FileWriter(file,true);
        fileWriter.write(nam +" "+phone+"\n");
        fileWriter.close();}catch(Exception e) {
        	System.out.print("\n");
        }

        
}
    
    
    void removeContact(File file){
        System.out.println("\nPlease enter name of the contact that you want to delete\n");
        String nameremove = in.nextLine();
    }
    
    
    void editContact(File file){
        System.out.println("\nPlease enter name of the contact that you want to change\n");
        String editName = in.nextLine();
        System.out.println("\nPlease enter the new phone numbe\n");
        String editPhone = in.nextLine();
    }
   
    void loadContactTextFile(File file){}
   
    void saveContactTextFile(File file){}

}